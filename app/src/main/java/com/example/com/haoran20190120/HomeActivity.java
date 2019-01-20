package com.example.com.haoran20190120;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.com.haoran20190120.adapter.CartAdapter;
import com.example.com.haoran20190120.adapter.ViewPagerAdapter;
import com.example.com.haoran20190120.bean.MyBean;
import com.example.com.haoran20190120.contract.MyContract;
import com.example.com.haoran20190120.fragment.CartFragment;
import com.example.com.haoran20190120.fragment.MineFragment;
import com.example.com.haoran20190120.presenter.MyPresenter;
import com.google.gson.Gson;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private BottomBar bottombar;
    private ViewPager viewpager;
    private List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();

    }

    private void initView() {
        bottombar = findViewById(R.id.home_bottombar);
        viewpager = findViewById(R.id.home_viewpager);
        //viewpager添加适配器
        list.add(new CartFragment());
        list.add(new MineFragment());
        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),list));
        //bottombar的点击事件
        bottombar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(int tabId) {
                if (tabId==R.id.shoppingcart){
                    viewpager.setCurrentItem(0);
                    Toast.makeText(HomeActivity.this, "0", Toast.LENGTH_SHORT).show();

                }
                if (tabId==R.id.mine){
                    viewpager.setCurrentItem(1);
                    Toast.makeText(HomeActivity.this, "1", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


}
