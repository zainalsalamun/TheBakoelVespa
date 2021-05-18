package com.dicoding.thebakoelvespa.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicoding.thebakoelvespa.R;
import com.dicoding.thebakoelvespa.entity.VespaModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by zainalsalamun on 03/09/2019.
 */

public class VespaAdapter extends BaseAdapter {

    ArrayList listItem;
    Activity activity;
    public static String KEY_ITEM = "item";
    private VespaModel item;

    public VespaAdapter(Activity activity, ArrayList listItem) {
        this.activity = activity;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        ViewHolder holder = null;

        
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list, null);
            holder.txtHarga = view.findViewById(R.id.txt_item_harga);
            holder.txtLokasi = view.findViewById(R.id.txt_item_lokasi);
            holder.txtTitle = view.findViewById(R.id.txt_item_title);
            holder.imgItem = view.findViewById(R.id.img_item);
            holder.txtShare =  view.findViewById(R.id.txt_item_share);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        VespaModel vespa = (VespaModel)getItem(i);
        holder.txtTitle.setText(vespa.getTitle());
        holder.txtHarga.setText(vespa.getHarga());
        holder.txtLokasi.setText(vespa.getLokasi());
        holder.txtShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Picasso.with(activity)
                .load(vespa.getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(holder.imgItem);

        return view;
    }

    static class ViewHolder {
        ImageView imgItem;
        TextView txtTitle, txtHarga, txtLokasi, txtShare, txtDetail;
    }
}
