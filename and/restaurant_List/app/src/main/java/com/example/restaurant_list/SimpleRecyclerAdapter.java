package com.example.restaurant_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder> {
    private ArrayList<String> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        ViewHolder(View itemView){
            super(itemView);
            textView1 = itemView.findViewById(R.id.number);
        }
    }

    SimpleRecyclerAdapter(ArrayList<String> list){
        mData = list;
    }

    @Override
    public SimpleRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        Context context = parent.getContext();
        LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item, parent, false);
        SimpleRecyclerAdapter.ViewHolder vh = new SimpleRecyclerAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(SimpleRecyclerAdapter.ViewHolder holder, int position){
        String text = mData.get(position);
        holder.textView1.setText(text);
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }
}
