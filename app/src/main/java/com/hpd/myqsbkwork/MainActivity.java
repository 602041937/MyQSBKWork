package com.hpd.myqsbkwork;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.hpd.myqsbkwork.fragments.FaxianFragment;
import com.hpd.myqsbkwork.fragments.QiushiFragment;
import com.hpd.myqsbkwork.fragments.QiuyouquanFragment;
import com.hpd.myqsbkwork.fragments.WoFragment;
import com.hpd.myqsbkwork.fragments.XiaozhitiaoFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView menu;
    private ActionBarDrawerToggle toggle;
    private QiushiFragment qiushiFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        menu = (NavigationView) findViewById(R.id.menu);

        toggle = new ActionBarDrawerToggle(this, drawer, 0, 0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();
        drawer.setDrawerListener(toggle);

        menu.setNavigationItemSelectedListener(this);


        FragmentManager manager = getSupportFragmentManager();

        qiushiFragment = new QiushiFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, qiushiFragment);
        transaction.commit();

    }

    //设置该drawer的监听事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Toggle控制DrawerLayout
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * NavigationView的点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = null;
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_qiushi:
                fragment = new QiushiFragment();
                break;
            case R.id.action_qiuyouquan:
                fragment = new QiuyouquanFragment();
                break;
            case R.id.action_faxian:
                fragment = new FaxianFragment();
                break;
            case R.id.action_xiaozhitiao:
                fragment = new XiaozhitiaoFragment();
                break;
            case R.id.action_wo:
                fragment = new WoFragment();
                break;
            case R.id.action_setting:
                drawer.closeDrawer(menu);
                return true;
            case R.id.action_me:
                drawer.closeDrawer(menu);
                return true;
            case R.id.aciton_quit:
                drawer.closeDrawer(menu);
                return true;
        }
        transaction.replace(R.id.container, fragment);
        transaction.commit();

        drawer.closeDrawer(menu);

        return true;
    }
}
