package com.vk.vktestapp;

/**
 * Created by Estat on 20.03.2018.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vk.vktestapp.com.models.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ItemAdapter extends ArrayAdapter<Item> {

    private Context mContext;
    private List<Item> itemsList = new ArrayList<>();

    public ItemAdapter(@NonNull Context context, ArrayList<Item> list) {
        super(context, 0 , list);
        mContext = context;
        itemsList = list;
    }


    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_layout,parent,false);

        Item currentItem = itemsList.get(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.icon);
        //Picasso.get().load(currentItem.getPhoto()).into(image);
        Picasso.with(getContext()).load(currentItem.getPhoto()).into(image);

        TextView name = (TextView) listItem.findViewById(R.id.item_name);
        name.setText(currentItem.getName());

        TextView description = (TextView) listItem.findViewById(R.id.item_price);
        description.setText("Quantity: "+currentItem.getQty()+"| Price: " + currentItem.getPrice());

        return listItem;
    }

}
