package com.dawn.viewslidingrootnavdawn;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View viewMenu = LayoutInflater.from(this).inflate(R.layout.menu_left_layout, null);
        setListener(viewMenu);
        new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withMenuLocked(false)
                .withGravity(SlideGravity.LEFT)
//                .withSavedState(savedInstanceState)
                .withMenuView(viewMenu)
                .withDragDistance(140)//Horizontal translation of a view. Default == 180dp
                .withRootViewScale(0.7f) //Content view's scale will be interpolated between 1f and 0.7f. Default == 0.65f;
//                .withRootViewElevation(10) //Content view's elevation will be interpolated between 0 and 10dp. Default == 8.
//                .withRootViewYTranslation(0) //Content view's translationY will be interpolated between 0 and 4. Default == 0
//                .withMenuLayout(R.layout.menu_left_layout)
                .inject();
        showFragment(new FragmentMain());
    }
    private void setListener(View viewMenu){
        View view01 = viewMenu.findViewById(R.id.tv_content01);
        View view02 = viewMenu.findViewById(R.id.tv_content02);
        View view03 = viewMenu.findViewById(R.id.tv_content03);
        view01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new Fragment01());
            }
        });
        view02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new Fragment02());
            }
        });
        view03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new Fragment03());
            }
        });
    }
    private void showFragment(Fragment fragment){
        getFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }
}
