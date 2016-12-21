package test.bwie.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private RecyclerView recycleerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化界面
        initView();
        //初始化数据
        initData();
    }

    //初始化界面
    private void initView() {
        //连接到控件
        recycleerView = (RecyclerView) findViewById(R.id.recyclerview);
        //实例化布局管理器,三种布局方式
        //线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //两列
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        //4列，垂直布局
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        //给RecyclerView设置布局方式
        recycleerView.setLayoutManager(linearLayoutManager);
//        recycleerView.setLayoutManager(gridLayoutManager);
//        recycleerView.setLayoutManager(staggeredGridLayoutManager);
        //实例化适配器
        myAdapter = new MyAdapter(this);
        //RecyclerView设置适配器
        recycleerView.setAdapter(myAdapter);
    }


    //初始化数据
    private void initData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add("测试数据" + i);
        }
        //给适配器传递数据
        myAdapter.setData(list);
    }
}
