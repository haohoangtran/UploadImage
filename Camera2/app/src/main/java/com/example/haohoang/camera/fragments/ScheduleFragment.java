package com.example.haohoang.camera.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;


/**
 * Created by haohoang on 3/1/17.
 */

public class ScheduleFragment extends Fragment {
    private  final String TAG=ScheduleFragment.class.toString();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        Log.e(TAG, String.format("onCreateView: %s %s", c.get(Calendar.DATE),c.get(Calendar.DAY_OF_WEEK)) );
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
