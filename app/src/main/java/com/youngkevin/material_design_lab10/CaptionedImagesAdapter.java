package com.youngkevin.material_design_lab10;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    private String[] names;
    private int[] imageIds;

    public CaptionedImagesAdapter(String[] names, int[] imageIds) {
        this.names = names;
        this.imageIds = imageIds;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private MaterialCardView materialCardView;
        public ViewHolder(MaterialCardView materialCardView){
            super(materialCardView);
            this.materialCardView = materialCardView;
        }
    }

    @NonNull
    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MaterialCardView materialCardView =  (MaterialCardView) LayoutInflater.from(parent.getContext()).inflate
                (R.layout.card_captioned_image,parent,false);
        return new ViewHolder(materialCardView);
    }

    @Override
    public void onBindViewHolder(@NonNull CaptionedImagesAdapter.ViewHolder holder, int position) {
        MaterialCardView mcv = holder.materialCardView;
        ImageView imageView = mcv.findViewById(R.id.image_info);
        imageView.setImageResource(imageIds[position]);
        imageView.setContentDescription(names[position]);
        TextView textView = mcv.findViewById(R.id.info_text);
        textView.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
}
