package com.awdroid.articleuitesting.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.awdroid.articleuitesting.R;
import com.awdroid.articleuitesting.model.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    private final List<Article> items;

    public ArticleAdapter(Context context, List<Article> items) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
    }

    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = inflater.inflate(R.layout.article_row_layout, parent, false);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {
        final Article item = items.get(position);
        ArticleUIStructure structure = ArticleUIStructureFactory.buildArticleUIStructure(item);
        holder.articleTitle.setText(structure.title);
        holder.articleDescription.setText(structure.description);
        holder.articleAuthor.setText(structure.author);
        holder.articlePostTime.setText(structure.timePosted);
        holder.articleTypeIndicator.setBackgroundColor(structure.indicatorColour);
        Picasso.with(context).load(structure.thumbnail).into(holder.articleThumbnail);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ArticleHolder extends RecyclerView.ViewHolder {

        View articleLayout;
        ImageView articleThumbnail;
        TextView articleTitle;
        TextView articleDescription;
        TextView articleAuthor;
        TextView articlePostTime;
        View articleTypeIndicator;

        ArticleHolder(View itemView) {
            super(itemView);
            articleLayout = itemView;
            articleThumbnail = (ImageView) itemView.findViewById(R.id.article_thumbnail);
            articleTitle = (TextView) itemView.findViewById(R.id.article_title);
            articleDescription = (TextView) itemView.findViewById(R.id.article_description);
            articleAuthor = (TextView) itemView.findViewById(R.id.article_author);
            articlePostTime = (TextView) itemView.findViewById(R.id.article_time);
            articleTypeIndicator = itemView.findViewById(R.id.article_type_indicator);
        }
    }
}
