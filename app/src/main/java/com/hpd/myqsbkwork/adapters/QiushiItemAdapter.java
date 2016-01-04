package com.hpd.myqsbkwork.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hpd.myqsbkwork.CommentActivity;
import com.hpd.myqsbkwork.R;
import com.hpd.myqsbkwork.models.VIPresponse;
import com.hpd.myqsbkwork.utils.CircleTransformation;
import com.hpd.myqsbkwork.utils.ItemUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 15-12-29.
 */
public class QiushiItemAdapter extends BaseAdapter implements View.OnClickListener {

    private List<VIPresponse.ItemsEntity> list;
    private Context context;


    public QiushiItemAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.vip_list_item, parent, false);
            convertView.setTag(new Viewholder(convertView));
        }
        VIPresponse.ItemsEntity item = list.get(position);
        Viewholder holder = (Viewholder) convertView.getTag();

        if (item.getUser() != null) {
            //用户名
            holder.userName.setText(item.getUser().getLogin());
            //用户头像
            Picasso.with(context).load(ItemUtils.getIconURL(item.getUser().getId(), item.getUser().getIcon()))
                    .transform(new CircleTransformation())
                    .into(holder.userIcon);

        } else {
            holder.userName.setText("匿名用户");
        }
        //文本内容
        holder.textContent.setText(item.getContent());
        //设置图片内容
        if (item.getImage() == null && item.getPic_url() == null) {
            holder.imageContent.setVisibility(View.GONE);
        } else {
            holder.imageContent.setVisibility(View.VISIBLE);
            //加载图片
            if (item.getImage() != null) {
                Picasso.with(context)
                        .load(ItemUtils.getImageURL((String) item.getImage()))
                        .placeholder(R.mipmap.video_watermark)
                        .error(R.mipmap.video_watermark)
                        .into(holder.imageContent);
            }
            //加载视频
            if (item.getPic_url() != null) {
                Picasso.with(context)
                        .load(item.getPic_url())
                        .placeholder(R.mipmap.video_watermark)
                        .error(R.mipmap.video_watermark)
                        .into(holder.imageContent);
            }
        }

        //好笑
        if (item.getVotes() != null) {
            holder.textFunny.setText("好笑" + (item.getVotes().getUp() + item.getVotes().getDown()));
        }

        //讨论
        holder.textDiscuss.setText("评论" + item.getComments_count());

        //分享
        holder.textShare.setText("分享" + item.getShare_count());

        //是否是hot
        if (!"hot".equals(item.getType())) {
            holder.textHot.setVisibility(View.INVISIBLE);
        }

        //设置评论按钮的监听事件
        holder.imageDiscuss.setOnClickListener(this);
        holder.imageDiscuss.setTag(position);

        return convertView;
    }

    public void addAll(Collection<? extends VIPresponse.ItemsEntity> collection) {
        if (collection != null) {
            list.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public void clearAll() {
        list.clear();
        notifyDataSetChanged();
    }


    //评论按钮的点击事件
    @Override
    public void onClick(View v) {

        int position = (int) v.getTag();

        Intent intent = new Intent(context, CommentActivity.class);
        intent.putExtra("data", (ArrayList<VIPresponse.ItemsEntity>) list);
        intent.putExtra("position", position);

        context.startActivity(intent);

    }


    private static class Viewholder {

        private ImageView userIcon;
        private TextView userName;
        private TextView textHot;
        private TextView textContent;
        private ImageView imageContent;
        private TextView textFunny;
        private TextView textDiscuss;
        private TextView textShare;
        private TextView textRebirth;
        private RadioButton rbHappy;
        private RadioButton rbSad;
        private ImageButton imageDiscuss;
        private ImageButton share;

        public Viewholder(View itemView) {

            userIcon = (ImageView) itemView.findViewById(R.id.user_icon);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            textHot = (TextView) itemView.findViewById(R.id.text_hot);
            textContent = (TextView) itemView.findViewById(R.id.text_content);
            imageContent = (ImageView) itemView.findViewById(R.id.image_content);
            textFunny = (TextView) itemView.findViewById(R.id.text_funny);
            textDiscuss = (TextView) itemView.findViewById(R.id.text_discuss);
            textShare = (TextView) itemView.findViewById(R.id.text_share);
            textRebirth = (TextView) itemView.findViewById(R.id.text_rebirth);
            rbHappy = (RadioButton) itemView.findViewById(R.id.rb_happy);
            rbSad = (RadioButton) itemView.findViewById(R.id.rb_sad);
            imageDiscuss = (ImageButton) itemView.findViewById(R.id.image_discuss);
            share = (ImageButton) itemView.findViewById(R.id.share);


        }

    }
}
