package util;

import com.awdroid.articleuitesting.R;
import com.awdroid.articleuitesting.model.Article;
import com.awdroid.articleuitesting.model.ArticleTypes;

import java.util.ArrayList;
import java.util.List;

public class ArticleListFactory {

    public static List<Article> buildArticleList() {
        List<Article> articles = new ArrayList<>(10);
        addNewsArticle(articles);
        addBusinessArticle(articles);
        addSportsArticle(articles);
        addLifestyleArticle(articles);
        addBusinessArticle(articles);
        addSportsArticle(articles);
        addNewsArticle(articles);
        addLifestyleArticle(articles);
        addSportsArticle(articles);
        addNewsArticle(articles);
        return articles;
    }

    private static void addNewsArticle(List<Article> articles) {
        Article article = new Article();
        article.title = "News Just In";
        article.description = "Breaking News just in about the country's finances. " +
                "Finance Minister, Mr. Minister, says taxes will raise as he needs a new holiday home.";
        article.type = ArticleTypes.NEWS;
        article.imageResource = R.drawable.news;
        article.author = "John O'Reilly";
        article.timePosted = 1482228000000L;
        articles.add(article);
    }

    private static void addBusinessArticle(List<Article> articles) {
        Article article = new Article();
        article.title = "AppGoog to make new smartphone";
        article.description = "AppGoog are planning to release a new smart phone in Q1 of 2017. " +
                "The phone will be in direct competition to other smart phone manufacturers.";
        article.type = ArticleTypes.BUSINESS;
        article.imageResource = R.drawable.business;
        article.author = "Eamonn O'Reilly";
        article.timePosted = 1482577020000L;
        articles.add(article);
    }

    private static void addSportsArticle(List<Article> articles) {
        Article article = new Article();
        article.title = "Local Team wins Local Derby";
        article.description = "A local team have won their local derby, by hammering their opposition. " +
                "The players and management have all said what a tough win it was and how it's the best possible" +
                "Christmas present for the club.";
        article.type = ArticleTypes.SPORT;
        article.imageResource = R.drawable.sports;
        article.author = "Jean O'Kane";
        article.timePosted = 1482774420000L;
        articles.add(article);
    }

    private static void addLifestyleArticle(List<Article> articles) {
        Article article = new Article();
        article.title = "Forgotten Z-list celebrity and Twitter";
        article.description = "Celine Cavanagh, from those awful reality tv shows, has posted an image of herself " +
                "in a Christmas bikini on Twitter. One has to wonder how far someone must go to get attention.";
        article.type = ArticleTypes.LIFESTYLE;
        article.imageResource = R.drawable.lifestyle;
        article.author = "Lisa McCarthy";
        article.timePosted = 1482664380000L;
        articles.add(article);
    }
}
