package com.hpd.myqsbkwork.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hpd.myqsbkwork.R;
import com.hpd.myqsbkwork.adapters.QiushiItemAdapter;
import com.hpd.myqsbkwork.interfaces.QsbkService;
import com.hpd.myqsbkwork.models.VIPresponse;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class QiushiItemFragment extends Fragment implements Callback<VIPresponse>, PullToRefreshBase.OnRefreshListener2<ListView> {

    private PullToRefreshListView listView;
    private QiushiItemAdapter adapter;
    private Context context;
    private Call<com.hpd.myqsbkwork.models.VIPresponse> call;
    private QsbkService service;
    private String flag;
    private boolean isToTop = false;
    private int currentPage = 1;

    public QiushiItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vi, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        flag = null;
        int position = bundle.getInt("position", 0);
        if (position == 0) {
            flag = "suggest";
        } else if (position == 1) {
            flag = "video";
        } else if (position == 2) {
            flag = "text";
        } else if (position == 3) {
            flag = "image";
        } else if (position == 4) {
            flag = "latest";
        }

        super.onViewCreated(view, savedInstanceState);

        listView = (PullToRefreshListView) view.findViewById(R.id.vip_list);

        //设置下拉刷新和上拉加载
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(this);

        adapter = new QiushiItemAdapter(context);
        listView.setAdapter(adapter);

        Retrofit build = new Retrofit.Builder().
                baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = build.create(QsbkService.class);
        call = service.getList(flag, 1);
        call.enqueue(this);


    }

    @Override
    public void onResponse(Response<com.hpd.myqsbkwork.models.VIPresponse> response, Retrofit retrofit) {
        if (isToTop) {
            adapter.clearAll();
        }
        adapter.addAll(response.body().getItems());
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(context, "网络连接错误", Toast.LENGTH_SHORT).show();
    }


    //下拉刷新
    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

        call = service.getList(flag, 1);
        call.enqueue(this);
        isToTop = true;
        currentPage = 1;

        listView.postDelayed(new Runnable() {


            @Override
            public void run() {
                listView.onRefreshComplete();
            }
        }, 2000);
    }

    //上拉加载
    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

        call = service.getList(flag, ++currentPage);
        call.enqueue(this);
        listView.postDelayed(new Runnable() {
            @Override
            public void run() {
                listView.onRefreshComplete();
            }
        }, 2000);

    }
}
