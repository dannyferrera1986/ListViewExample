package com.example.service_admin.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class itemadapter extends BaseAdapter {
     LayoutInflater layoutInflater;
    private final Context context;
    List<Item> itemList;
    public itemadapter(List<Item>itemList, Context context){
      this.itemList=itemList;
      this.context=context;
        layoutInflater=layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder holder;
        if (convertView == null) {
        convertView=layoutInflater.inflate(R.layout.list_item, null);
        holder =new ItemViewHolder(convertView);

      /*  } else {
            holder =(ItemViewHolder) convertView.getTag();
          if (holder ==null )
            {
                holder =new ItemViewHolder(convertView);
            }*/

        }
        holder =new ItemViewHolder(convertView);
        Item item= this.itemList.get(position);

        holder.imageView.setImageResource(item.imageid);
        holder.nameview.setText(item.name);
        holder.descriptionview.setText(item.description);

        return convertView;
    }

    public  void AddItem (Item item){
        this.itemList.add(item);
        this.notifyDataSetChanged();

    }

    static class ItemViewHolder {
        ImageView imageView;
        TextView nameview;
        TextView descriptionview;

        public ItemViewHolder(View view) {
            imageView=view.findViewById(R.id.imagen);
            nameview=view.findViewById(R.id.txtname);
            descriptionview=view.findViewById(R.id.txtdescripcion);
        }
    }
}
