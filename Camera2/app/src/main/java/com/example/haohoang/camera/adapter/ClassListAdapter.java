package com.example.haohoang.camera.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haohoang.camera.R;
import com.example.haohoang.camera.adapter.viewholders.ClassListHolder;
import com.example.haohoang.camera.database.DbContext;
import com.example.haohoang.camera.database.classlist.ClassItem;

/**
 * Created by haohoang on 3/1/17.
 */

public class ClassListAdapter extends RecyclerView.Adapter<ClassListHolder> {
    @Override
    public ClassListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1:create view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_class, parent, false);
        //2: create ViewHolder
        return new ClassListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ClassListHolder holder, int position) {
        ClassItem classItem=DbContext.instance.allClass().get(position);
        holder.bind(classItem);
    }

    @Override
    public int getItemCount() {
        return DbContext.instance.allClass().size();
    }
}
