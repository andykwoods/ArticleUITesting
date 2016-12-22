package com.awdroid.articleuitesting.ui.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;

import com.awdroid.articleuitesting.model.Article;
import com.awdroid.articleuitesting.model.ArticleTypes;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ArticleUIStructureFactory {

    private static final String DATE_FORAMT = "K:mm a, d MMM yyyy";

    public static ArticleUIStructure buildArticleUIStructure(Article article) {
        if (article == null)
            return null;
        else {
            ArticleUIStructure structure = new ArticleUIStructure();
            structure.title = article.title;
            structure.description = article.description;
            structure.thumbnail = article.imageResource;
            structure.author = buildStructureAuthor(article);
            structure.timePosted = buildStructureTimePosted(article);
            structure.indicatorColour = buildStructureIndicatorColour(article);
            return structure;
        }
    }

    private static int buildStructureIndicatorColour(Article article) {
        switch (article.type) {
            case ArticleTypes.NEWS:
                return Color.CYAN;
            case ArticleTypes.BUSINESS:
                return Color.BLUE;
            case ArticleTypes.LIFESTYLE:
                return Color.GREEN;
            case ArticleTypes.SPORT:
                return Color.RED;
            default:
                return Color.WHITE;
        }
    }

    private static String buildStructureAuthor(Article article) {
        String names[] = article.author.split(" ");
        return names[1] + ", " + names[0] + ".";
    }

    private static String buildStructureTimePosted(Article article) {
        DateFormatSymbols symbols = getLowerCaseAmPmSymbols();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORAMT, symbols);
        return format.format(new Date(article.timePosted));
    }

    @NonNull
    private static DateFormatSymbols getLowerCaseAmPmSymbols() {
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.ENGLISH);
        symbols.setAmPmStrings(new String[] { "am", "pm" });
        return symbols;
    }
}
