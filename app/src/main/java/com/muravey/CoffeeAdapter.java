package com.muravey;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder> {

    public interface ClickListener {
        void onClick (int position);
    }

    private ClickListener clickListener;

    ArrayList<CoffeeModel> mlist;

    private Context mContext;
    CoffeeAdapter(ArrayList<CoffeeModel> mlist){
       this.mlist = mlist;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.rv_coffee_items, viewGroup, false);
        ViewHolder  viewHolder = new ViewHolder(view);

        return viewHolder;



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        CoffeeModel coffeeItem = mlist.get(i);
        ImageView imageView = viewHolder.item_image;
        TextView name,place, price;

        name = viewHolder.item_name;
        place = viewHolder.item_place;
        price = viewHolder.item_price;

        imageView.setImageResource(coffeeItem.getImage());

        name.setText(coffeeItem.getName());
        place.setText(coffeeItem.getPlace());
        price.setText(coffeeItem.getPrice());

    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView item_image;
        TextView item_name, item_place, item_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_place = itemView.findViewById(R.id.item_place);
            item_price = itemView.findViewById(R.id.item_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onClick(getAdapterPosition());
                }
            });

        }
    }
}
