package com.example.espino.deportes.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.espino.deportes.R;
import com.example.espino.deportes.model.Sports;
import com.example.espino.deportes.model.SportsList;

import java.util.ArrayList;


/**
 * Created by espino on 12/12/16.
 */

public class SportsAdapter extends ArrayAdapter<Sports> {

    ArrayList<Sports> list;

    public SportsAdapter(Context context) {
        super(context, R.layout.listitem_sport, new ArrayList<>(SportsList.getInstance(context).getList()));
        list = new ArrayList<>(SportsList.getInstance(context).getList());
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View item = convertView;
        SportsHolder holder = null;

        if(item == null){
            item = LayoutInflater.from(getContext()).inflate(R.layout.listitem_sport, parent, false);
            holder = new SportsHolder();

            holder.name = (TextView) item.findViewById(R.id.listitem_txv_name);
            holder.favourite = (CheckBox) item.findViewById(R.id.listitem_cb);
            holder.favourite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getItem(position).setFavourite(isChecked);
                }
            });
            holder.img = (ImageView) item.findViewById(R.id.imageView);

            item.setTag(holder);
        }
        else
            holder = (SportsHolder) convertView.getTag();

        holder.name.setText(getItem(position).getName());
        holder.favourite.setChecked(getItem(position).isFavourite());
        holder.img.setImageResource(R.mipmap.ic_launcher);

        return item;
    }

    public boolean filter(String text){

        if(!TextUtils.isEmpty(text) && text.length() == 1 && text.matches("\\p{Alpha}")){
            list.clear();

            for(byte i = 0; i < getCount(); i++){
                if(getItem(i).getName().charAt(0) == text.charAt(0))
                    list.add(getItem(i));
            }
            clear();
            addAll(list);
        }
        else if(TextUtils.isEmpty(text)) {
            list = new ArrayList<>(SportsList.getInstance(getContext()).getList());
            clear();
            addAll(list);
            this.notifyDataSetChanged();
        }



        return true;
    }


    private static class SportsHolder{
        private TextView name;
        private CheckBox favourite;
        private ImageView img;
    }
}
