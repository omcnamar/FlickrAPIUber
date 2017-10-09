package com.olegsagenadatrytwo.flickrapiuber.view.mainactivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.olegsagenadatrytwo.flickrapiuber.R;
import com.olegsagenadatrytwo.flickrapiuber.entities.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omcna on 10/9/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    public static final String TAG = "FlickerAdapter";
    private List<Photo> list = new ArrayList<>();
    private Context context;

    public ImageAdapter(List<Photo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Photo item = list.get(position);
        String url = "http://farm" + item.getFarm() + ".static.flickr.com/" + item.getServer() + "/" + item.getId() +"_" + item.getSecret() + ".jpg";
        Glide.with(context).load(url).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivImage);

        }
    }
}

