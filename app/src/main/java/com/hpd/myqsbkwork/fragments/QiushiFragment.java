package com.hpd.myqsbkwork.fragments;



import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpd.myqsbkwork.R;
import com.hpd.myqsbkwork.adapters.QiushiAdater;

import java.util.ArrayList;
import java.util.List;

public class QiushiFragment extends Fragment {


    private TabLayout tab;
    private ViewPager pager;
    private List<Fragment> fragments;
    private List<String> titles;
    private QiushiAdater qiushiAdater;

    public QiushiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qiushi, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        tab = (TabLayout) view.findViewById(R.id.tab);
        pager = (ViewPager) view.findViewById(R.id.pager);

        fragments = new ArrayList<Fragment>();
        titles = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            QiushiItemFragment qiushiItemFragment = new QiushiItemFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", i);
            qiushiItemFragment.setArguments(bundle);
            fragments.add(qiushiItemFragment);
        }

        titles.add("专享");
        titles.add("视频");
        titles.add("纯文");
        titles.add("纯图");
        titles.add("最新");

        FragmentManager childFragmentManager = getChildFragmentManager();

        qiushiAdater = new QiushiAdater(childFragmentManager, fragments, titles);

        pager.setAdapter(qiushiAdater);

        tab.setupWithViewPager(pager);


    }
}
