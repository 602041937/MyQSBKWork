package com.hpd.myqsbkwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.hpd.myqsbkwork.adapters.QiushiItemAdapter;
import com.hpd.myqsbkwork.adapters.CommentAdapter;
import com.hpd.myqsbkwork.interfaces.VIPCommentService;
import com.hpd.myqsbkwork.models.VIPCommentResponse;
import com.hpd.myqsbkwork.models.VIPresponse;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class CommentActivity extends AppCompatActivity implements Callback<VIPCommentResponse>, AbsListView.OnScrollListener {

    private ListView listView;
    private CommentAdapter adapter;
    private Call<VIPCommentResponse> call;
    private VIPCommentService service;
    private int currentPage = 1;
    private int id;
    private boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vipcomment);

        //得到点击的条目的数据
        Intent intent = getIntent();
        ArrayList<VIPresponse.ItemsEntity> data =
                (ArrayList<VIPresponse.ItemsEntity>) intent.getSerializableExtra("data");
        int position = intent.getIntExtra("position", 0);
        id = data.get(position).getId();
        //设置header
        View view = null;
        listView = (ListView) findViewById(R.id.vip_comment_list);
        QiushiItemAdapter adapter1 = new QiushiItemAdapter(this);
        adapter1.addAll(data);
        view = adapter1.getView(position, view, listView);
        view.findViewById(R.id.image_discuss).setVisibility(View.GONE);
        listView.addHeaderView(view);

        adapter = new CommentAdapter(this);

        listView.setAdapter(this.adapter);

        


        Retrofit build = new Retrofit.Builder().
                baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        

        service = build.create(VIPCommentService.class);
        call = service.getList(Integer.toString(id), currentPage);
        call.enqueue(this);
    }


    @Override
    public void onResponse(Response<VIPCommentResponse> response, Retrofit retrofit) {

        adapter.addAll(response.body().getItems());
        if (!flag) {
            listView.setOnScrollListener(this);
            flag=true;
        }
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(this, "网络连接错误", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        if ((firstVisibleItem + visibleItemCount)  >= totalItemCount) {
            call = service.getList(Integer.toString(id), ++currentPage);
            call.enqueue(this);

        }
    }
}
