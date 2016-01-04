package com.hpd.myqsbkwork.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hpd.myqsbkwork.R;
import com.hpd.myqsbkwork.models.VIPCommentResponse;
import com.hpd.myqsbkwork.utils.CircleTransformation;
import com.hpd.myqsbkwork.utils.ItemUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 15-12-30.
 */
public class CommentAdapter extends BaseAdapter {

    private Context context;
    private List<VIPCommentResponse.ItemsEntity> list;

    public CommentAdapter(Context context) {
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
            convertView = inflater.inflate(R.layout.comment_list_item, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }

        VIPCommentResponse.ItemsEntity items = list.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();

        //用户头像
        Picasso.with(context).load(ItemUtils.getIconURL(items.getUser().getId(), items.getUser().getIcon()))
                .transform(new CircleTransformation())
                .into(holder.vipCommentIcon);
        //用户名字
        holder.vipCommentName.setText(items.getUser().getLogin());
        //用户内容
        holder.vipCommentContent.setText(items.getContent());
        //喜欢数量
        holder.vipCommentLikeCount.setText(Integer.toString(items.getLike_count()));

        return convertView;
    }

    public void addAll(Collection<? extends VIPCommentResponse.ItemsEntity> collection) {

        if (collection != null) {
            list.addAll(collection);
            notifyDataSetChanged();
        }
    }

    private static class ViewHolder {

        private ImageView vipCommentIcon;
        private TextView vipCommentName;
        private TextView vipCommentContent;
        private TextView vipCommentLikeCount;

        public ViewHolder(View itemView) {

            vipCommentIcon = (ImageView) itemView.findViewById(R.id.vip_comment_icon);
            vipCommentName = (TextView) itemView.findViewById(R.id.vip_comment_name);
            vipCommentContent = (TextView) itemView.findViewById(R.id.vip_comment_content);
            vipCommentLikeCount = (TextView) itemView.findViewById(R.id.vip_comment_like_count);
        }
    }
}
