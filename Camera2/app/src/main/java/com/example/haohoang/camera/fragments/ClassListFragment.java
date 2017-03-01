package com.example.haohoang.camera.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haohoang.camera.R;
import com.example.haohoang.camera.adapter.ClassListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by haohoang on 3/1/17.
 */

public class ClassListFragment extends Fragment {
    private static final String TAG = ClassListFragment.class.toString();
    @BindView(R.id.rv_classlist)
    RecyclerView rvTaskList;
    ClassListAdapter classListAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classlist, container, false);
        setupUI(view);
        Log.e(TAG, "onCreateView: Phịch");
        return view;
    }

    public void setupUI(View view) {
        ButterKnife.bind(this,view);
        classListAdapter=new ClassListAdapter();
        rvTaskList.setAdapter(classListAdapter);
        rvTaskList.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        rvTaskList.addItemDecoration(dividerItemDecoration);
    }
}
