package com.example.myblog.controller;

import com.example.myblog.DTO.ArticleAndLabel;
import com.example.myblog.DTO.DetailedArticle;
import com.example.myblog.pojo.Post;
import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogArticle;
import com.example.myblog.service.ArticleLabelService;
import com.example.myblog.service.ArticleService;
import com.example.myblog.service.LabelService;
import com.example.myblog.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleLabelService ArticlelabelService;

    //获取所有博文

    @GetMapping("/api/Articles")
    public Result getArtciles() {
        List<BlogArticle> articles= articleService.getArticles();
        return Result.success(articles);
    }

    ////使用了DTO层来传输数据，将标签加上了，并根据是否置顶排序,时间顺序
    @GetMapping("/api/ArticlesAndLabel")
    public Result getArticlesAndLabel() {
        try {
            List<ArticleAndLabel> articles= articleService.getArticleAndLabel();
            return Result.success(articles);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取博文失败");
        }
    }

    //根据博文id获取博文
    @GetMapping("/api/Articles/{articleId}")
    public Result<BlogArticle> getArticleById(@PathVariable int articleId) {
        BlogArticle article = articleService.getArticleById(articleId);
        if (article != null) {
            return Result.success(article); // 成功时返回博文数据
        } else {
            return Result.error("博文不存在"); // 博文不存在时返回错误信息
        }
    }

    ////使用了DTO层来传输数据，将标签加上了
    @GetMapping("/api/ArticlesAndLabel/{articleId}")
    public Result getArticleAndLabelById(@PathVariable int articleId) {
        ArticleAndLabel article = articleService.getArticleAndLabelById(articleId);
        if (article != null) {
            return Result.success(article); // 成功时返回博文数据
        } else {
            return Result.error("博文不存在"); // 博文不存在时返回错误信息
        }
    }

    /////文章详细页代码调用
    @GetMapping("/api/DetailedArticle/{articleId}")
    public Result getDetailedArticle(@PathVariable int articleId) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        DetailedArticle article = null;
        try {
            article = articleService.getDetailedArticle(articleId, userId);
            if (article == null) {
                return Result.error("未找到文章");
            } else {
                return Result.success(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取文章失败");
        }
    }


    //写博文(标题和内容)
    @PostMapping("/api/writeArticle")
    public Result writeArticle(@RequestBody Map<String,String> params) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        String title=params.get("title");
        String content=params.get("content");
        try{
            articleService.writeArticle(title, content, userId);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("写博文失败");
        }

    }

    //删除博文
    @PostMapping("/api/deleteArticle/{articleId}")
    public Result deleteArticle(@PathVariable int articleId) {
        BlogArticle article = articleService.getArticleById(articleId);
        if (article == null) {
            return Result.error("博文不存在");
        }
        try {

            //注意数据库的外键约束关系，先删标签，再删博文
            articleService.deleteArticle(articleId);

            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("删除博文失败");
        }

    }

    //更新博文
    //目前要求更新标题和内容使用了RequestBody来传参数
    @PutMapping("/api/updateArticle/{articleId}")
    public Result updateArticle(@RequestBody Map<String,String> params,@PathVariable int articleId) {
        BlogArticle article = articleService.getArticleById(articleId);
        if (article == null) {
            return Result.error("博文不存在");
        }
        String title=params.get("title");
        String content=params.get("content");
        try {
            articleService.updateArticle(articleId, title, content);
            return Result.success("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("更新博文失败");
        }
    }
    //用户自己获取自己的博文列表
    @GetMapping("/api/Articles/myself")
    public Result<List<BlogArticle>> getArticlesByMyself() {
        Map<String, Object> claims = ThreadLocalUtil.get();//通过jwt令牌传输用户id
        String userId = (String) claims.get("userId");
        try {
            List<BlogArticle> articles = articleService.getArticlesByUserId(userId);
            return Result.success(articles);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取博文失败");
        }
    }
    //根据用户id获取博文列表
    @GetMapping("/api/Articles/author/{userId}")
    public Result<List<BlogArticle>> getArticlesByAuthor(@PathVariable String userId) {
        try {
            List<BlogArticle> articles = articleService.getArticlesByUserId(userId);
            return Result.success(articles);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取博文失败");
        }
    }

    //搜索文章功能
    ///模糊查询，模糊匹配标题和内容和标签
    @PostMapping("/api/searchArticles")
    public Result searchArticles(@RequestBody Map<String, String> params) {
        String keyword = params.get("keyword");
        try {
            List<ArticleAndLabel> articles = articleService.searchArticles(keyword);
            return Result.success(articles);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("搜索失败");
        }
    }












//    @Autowired
//    private PostService postService;
//
//
//
//    // 获取博文详情
//    @GetMapping("/api/posts/{postId}")
//    public Result<Post> getPostById(@PathVariable int postId) {
//        Post post = postService.getPostById(postId);
//        if (post != null) {
//            return Result.success(post); // 成功时返回博文数据
//        } else {
//            return Result.error("博文不存在"); // 博文不存在时返回错误信息
//        }
//    }
//
//    // 获取所有博文
//    @GetMapping("/api/posts")
//    public Result getPosts() {
//        List<Post> posts = postService.getPosts();
//        return Result.success(posts); // 返回所有博文数据
//    }
//
//    //写博文
//    @PostMapping("/api/writepost")
//    public Result writePost(String title, String content) {
//        Map<String, Object> claims = ThreadLocalUtil.get();
//        String userId = (String) claims.get("userId");
//        postService.writePost(title, content, userId);
//        return Result.success();
//    }
//
//    // 删除博文
//    @PostMapping("/api/deletepost/{postId}")
//    public Result deletePost(@PathVariable int postId) {
//        postService.deletePost(postId);
//        return Result.success();
//    }
//
//    //更新博文
//    //目前要求更新标题和内容
//    @PutMapping("/api/updatepost/{postId}")
//    public Result updatePost(@RequestBody Post post) {
//        postService.updatePost(post);
//        return Result.success();
//    }
//
//    //根据作者获取博文列表
//    @GetMapping("/api/posts/author/{userId}")
//    public Result<List<Post>> getPostsByAuthor(@PathVariable String userId) {
//        List<Post> post = postService.getPostsByAuthor(userId);
//        if (post != null) {
//            return Result.success(post); // 成功时返回博文数据
//        } else {
//            return Result.error("博文不存在"); // 博文不存在时返回错误信息
//        }
//    }


}
