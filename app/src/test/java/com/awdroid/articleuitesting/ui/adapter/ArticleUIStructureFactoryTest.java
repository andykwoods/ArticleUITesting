package com.awdroid.articleuitesting.ui.adapter;

import android.graphics.Color;

import com.awdroid.articleuitesting.R;
import com.awdroid.articleuitesting.model.Article;
import com.awdroid.articleuitesting.model.ArticleTypes;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArticleUIStructureFactoryTest {

    @Mock
    Article article;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        setUpArticle();
    }

    private void setUpArticle() {
        article.type = ArticleTypes.NEWS;
        article.title = "Something amazing has happened";
        article.description = "Something amazing has happened in the world today. " +
                "It's a very unprecedented decision.";
        article.author = "John Smith";
        article.content = "Something amazing has happened in the world today. " +
                "It's a very unprecedented decision. The people are really happy.";
        article.timePosted = 1482661800000L;
        article.imageResource = R.drawable.news;
    }

    @Test
    public void testWhenArticleIsNull_UIStructureIsNull() {
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(null);
        //noinspection ConstantConditions
        assertNull(structure);
    }

    @Test
    public void testArticleUIStructureTitle() {
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(article);
        assertEquals("Something amazing has happened", structure.title);
    }

    @Test
    public void testArticleUIStructureDescription() {
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(article);
        assertEquals("Something amazing has happened in the world today. " +
                "It's a very unprecedented decision.", structure.description);
    }

    @Test
    public void testArticleUIStructureAuthor() {
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(article);
        assertEquals("Smith, John.", structure.author);
    }

    @Test
    public void testArticleUIStructureTimePosted() {
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(article);
        assertEquals("10:30 am, 25 Dec 2016", structure.timePosted);
    }

    @Test
    public void testArticleNewsIndicatorColour() {
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(article);
        assertEquals(Color.CYAN, structure.indicatorColour);
    }

    @Test
    public void testArticleBusinessIndicatorColour() {
        article.type = ArticleTypes.BUSINESS;
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(article);
        assertEquals(Color.BLUE, structure.indicatorColour);
    }

    @Test
    public void testArticleLifestyleIndicatorColour() {
        article.type = ArticleTypes.LIFESTYLE;
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(article);
        assertEquals(Color.GREEN, structure.indicatorColour);
    }

    @Test
    public void testArticleSportIndicatorColour() {
        article.type = ArticleTypes.SPORT;
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(article);
        assertEquals(Color.RED, structure.indicatorColour);
    }

    @Test
    public void testArticleThumbnail() {
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(article);
        assertEquals(R.drawable.news, structure.thumbnail);
    }
}
