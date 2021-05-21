package com.aad.exampleapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<AnimalViewHolder> {


    private List<Animal> animals;
    private Context context;
    private LayoutInflater mLayoutInflater;

    public CustomRecyclerViewAdapter(Context context, List<Animal> datas) {
        this.context = context;
        this.animals = datas;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View recyclerViewItem = mLayoutInflater.inflate(R.layout.recyclerview_item_layout, parent, false);

        recyclerViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRecyclerItemClick( (RecyclerView)parent, v);
            }
        });
        return new AnimalViewHolder(recyclerViewItem);
    }


    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Animal animal = this.animals.get(position);

        int imageResId = this.getDrawableResIdByName(animal.getName().toLowerCase());
        holder.animalView.setImageResource(imageResId);
        holder.animalNameView.setText(animal.getName());
    }

    @Override
    public int getItemCount() {
        return this.animals.size();
    }
    public int getDrawableResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i("Taga", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    private void handleRecyclerItemClick(RecyclerView recyclerView, View itemView) {
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
        Animal animal  = this.animals.get(itemPosition);

        Intent i = new Intent(context, AnimalActivity.class);
        i.putExtra("AnimalName", animal.getName());
        this.context.startActivity(i);
    }
}