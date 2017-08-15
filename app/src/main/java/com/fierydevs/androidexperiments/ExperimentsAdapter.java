package com.fierydevs.androidexperiments;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by morep on 05-08-2017.
 */

public class ExperimentsAdapter extends RecyclerView.Adapter<ExperimentsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ExperimentsModel> models;
    private OnItemClickListener onItemClickListener;

    public ExperimentsAdapter(Context context, ArrayList<ExperimentsModel> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public ExperimentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.experiment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ExperimentsAdapter.ViewHolder holder, int position) {
        ExperimentsModel model = models.get(position);

        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());
        holder.dots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.dots, holder.getAdapterPosition());
            }
        });
    }

    private void showPopupMenu(View view, final int position) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.link:
                        String link = models.get(position).getLink();
                        return true;
                    default:
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, desc;
        private RelativeLayout mainHolder;
        private ImageView dots;

        ViewHolder(final View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.experiment_title);
            desc = (TextView) itemView.findViewById(R.id.description);
            mainHolder = (RelativeLayout) itemView.findViewById(R.id.main_holder);
            dots = (ImageView) itemView.findViewById(R.id.dots);
            mainHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(itemView, getAdapterPosition());
                }
            });
        }
    }

    interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
