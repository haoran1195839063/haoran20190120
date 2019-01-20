package com.example.com.haoran20190120.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.com.haoran20190120.R;
import com.example.com.haoran20190120.bean.MyBean;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {
    private Context context;
    private List< MyBean.DataBean.Data> list;

    public CartItemAdapter(Context context,List< MyBean.DataBean.Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cart_item_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.checkBox.setChecked(list.get(i).ischecked);
        viewHolder.price.setText(list.get(i).price+"");
        viewHolder.title.setText(list.get(i).title);
        String images = list.get(i).images;
        String[] split = images.split("!");
        Glide.with(context).load(split[0]).into(viewHolder.tupian);

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  CheckBox checkBox;
        private  ImageView tupian;
        private  TextView price;
        private  TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.item_check);
            tupian = itemView.findViewById(R.id.item_image);
            price = itemView.findViewById(R.id.item_price);
            title = itemView.findViewById(R.id.item_text);

        }
    }
}
