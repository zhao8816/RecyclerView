package test.bwie.com.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MainViewHolder> {

    private Context context;
    private ArrayList<String> list;

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       //设置RecyclerView条目布局文件
        View view = LayoutInflater.from(context).inflate(R.layout.item,null);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        //设置条目上控件的显示内容
        if (list!=null){
            holder.tv_item.setText(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //自定义ViewHolder
    public static class MainViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_item;

        public MainViewHolder(View itemView) {
            super(itemView);
            //找到控件
            tv_item = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }

    //创建接收外部数据的方法
    public void setData(ArrayList<String> list){
        this.list = list;
        //每向适配器传递一次数据，刷新一次
        notifyDataSetChanged();
    }
}
