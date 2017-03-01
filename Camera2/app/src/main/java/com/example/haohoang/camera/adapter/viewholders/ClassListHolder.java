package com.example.haohoang.camera.adapter.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.haohoang.camera.R;
import com.example.haohoang.camera.database.classlist.ClassItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by haohoang on 3/1/17.
 */

public class ClassListHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_nameclass)
    TextView tvNameClass;
    @BindView(R.id.tv_numberStudent)
    TextView tvNumberStudent;
    @BindView(R.id.tv_item_classroom)
    TextView tvClassRoom;
    public ClassListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void bind(ClassItem classItem){
        tvNameClass.setText(classItem.getNameClass());
        tvNumberStudent.setText(String.format("%d %s", classItem.getNumberStudent(), "sv"));
        tvClassRoom.setText(classItem.getClassRoom());
    }
}
