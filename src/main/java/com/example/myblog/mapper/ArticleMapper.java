package com.example.myblog.mapper;

import com.example.myblog.DTO.ArticleAndLabel;
import com.example.myblog.DTO.DetailedArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.myblog.pojo.Post;
import com.example.myblog.pojo2.BlogArticle;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from blog_articles")
    List<BlogArticle> getArticles();
    //查询文章和标签
    @Select("select blog_articles.*, blog_labels.label_name from blog_articles " +
            " left join blog_set_article_label on blog_articles.article_id = blog_set_article_label.article_id " +
            " left join blog_labels on blog_set_article_label.label_id = blog_labels.label_id " +
            " ORDER BY article_isPinned DESC, article_date DESC")
    List<ArticleAndLabel> getArticleAndLabel();

    @Select("select * from blog_articles where article_id = #{articleId}")
    BlogArticle getArticleById(int articleId);
    //查询文章和标签
    @Select("select blog_articles.*, blog_labels.label_name from blog_articles " +
            " left join blog_set_article_label on blog_articles.article_id = blog_set_article_label.article_id " +
            " left join blog_labels on blog_set_article_label.label_id = blog_labels.label_id " +
            " where blog_articles.article_id = #{articleId}")
    ArticleAndLabel getArticleAndLabelById(int articleId);

    @Insert("INSERT INTO blog_articles(article_title, article_content, user_id, " +
            "article_views, article_comment_count, article_like_count, article_date, article_isPinned) " +
            "VALUES(#{title}, #{content}, #{userId}, 0, 0, 0, NOW(), 0)")
    void writeArticle(String title, String content, String userId);

    @Delete("delete from blog_articles where article_id = #{articleId}")
    void deleteArticle(int articleId);

    @Update("update blog_articles set article_title = #{title}, article_content = #{content} where article_id = #{articleId}")
    void updateArticle(int articleId, String title, String content);

    @Select("select * from blog_articles where user_id = #{userId}")
    List<BlogArticle> getArticlesByUserId(String userId);

    //根据用户名查找文章，只返回文章id
    @Select("select article_id from blog_articles where user_id = #{userId}")
    List<Integer> getArticleIdByUserId(String userId);

    //评论数加1
    @Update("update blog_articles set article_comment_count = article_comment_count + 1 where article_id = #{articleId}")
    void addCommentCount(int articleId);

    //评论数减1
    @Update("update blog_articles set article_comment_count = article_comment_count - 1 where article_id = #{articleId}")
    void subCommentCount(long articleId);

    //点赞数加1
    @Update("update blog_articles set article_like_count = article_like_count + 1 where article_id = #{articleId}")
    void addLikeCount(int articleId);

    /////详细文章信息

    @Select(
            "SELECT a.article_id, a.user_id, a.article_title, a.article_content, a.article_views, a.article_comment_count, a.article_like_count, a.article_date, a.article_isPinned, " +
                    "l.label_name, " +
                    "CASE WHEN la.like_type = 1 THEN true ELSE false END AS isLiked, " +
                    "CASE WHEN la.like_type = 0 THEN true ELSE false END AS isDisliked, " +
                    "CASE WHEN ac.article_id IS NOT NULL THEN true ELSE false END AS isCollected, " +
                    "CASE WHEN us.user_id IS NOT NULL THEN true ELSE false END AS isSubscribed " +
                    "FROM blog_articles a " +
                    "LEFT JOIN blog_set_article_label sal ON a.article_id = sal.article_id " +
                    "LEFT JOIN blog_labels l ON sal.label_id = l.label_id " +
                    "LEFT JOIN blog_like_article la ON a.article_id = la.article_id AND la.user_id = #{userId} " +
                    "LEFT JOIN blog_set_article_collection ac ON a.article_id = ac.article_id " +
                    "LEFT JOIN blog_collection c ON ac.collection_id = c.collection_id AND c.user_id = #{userId} " +  // 修改这里，使用 c.user_id 进行关联
                    "LEFT JOIN blog_user_subscribe us ON a.user_id = us.user_subscribe_id AND us.user_id = #{userId} " +
                    "WHERE a.article_id = #{articleId}"
    )
    DetailedArticle getDetailedArticle(int articleId, String userId);

    ///////////////搜索文章/////////
    @Select("SELECT a.article_id, a.user_id, a.article_title, a.article_content, a.article_views, a.article_comment_count, " +
            "a.article_like_count, a.article_date, a.article_isPinned, " +
            "l.label_name " +
            "FROM blog_articles a " +
            "LEFT JOIN blog_set_article_label sal ON a.article_id = sal.article_id " +
            "LEFT JOIN blog_labels l ON sal.label_id = l.label_id " +
            "WHERE a.article_title LIKE CONCAT('%', #{keyword}, '%') " +
            "OR a.article_content LIKE CONCAT('%', #{keyword}, '%') " +
            "OR l.label_name LIKE CONCAT('%', #{keyword}, '%')")
    List<ArticleAndLabel> searchArticles(String keyword);

//    @Select("select * from posts where post_id = #{postId}")
//    Post getPostById(int postId);
//
//    @Insert("insert into posts(title, content, user_id) values(#{title}, #{content}, #{userId})")
//    void writePost(String title, String content, String userId);
//
//    @Delete("delete from posts where post_id = #{postId}")
//    void deletePost(int postId);
//
//    @Update("update posts set title = #{title}, content = #{content} where post_id = #{postId}")
//    void updatePost(Post post);
//
//    @Select("select * from posts where user_id = #{userId}")
//    List<Post> getPostByAuthor(String userId);
}
