package com.aad.exampleapplication;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends   RecyclerView.ViewHolder {

    ImageView animalView;
    TextView animalNameView;
    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);

        this.animalView = (ImageView) itemView.findViewById(R.id.animalimage);
        this.animalNameView = (TextView) itemView.findViewById(R.id.animalname);
    }
}
