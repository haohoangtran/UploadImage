package com.example.haohoang.camera.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.haohoang.camera.R;
import com.example.haohoang.camera.fragments.ClassListFragment;
import com.example.haohoang.camera.fragments.ScheduleFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tl_action)
    TabLayout tabLayout;
    //cn la 1
    // t7 la 7

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addListenner();

        replaceFragment(new ClassListFragment(),false);
    }

    private void addListenner() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                replaceFragment(new ClassListFragment(),false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                replaceFragment(new ScheduleFragment(),false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public void replaceFragment(Fragment f, boolean addToBackTack) {
        if (addToBackTack) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_main, f)
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_main, f)
                    .commit();
        }
    }
}
