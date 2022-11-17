package com.example.mycoverflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.coverflow.CoverFlowLayoutManger;
import com.example.coverflow.RecyclerCoverFlow;

public class MainActivity extends AppCompatActivity  implements  Adapter.onItemClick {
    private RecyclerCoverFlow mList;
    private void initList() {
        mList = findViewById(R.id.list);
//        mList.setFlatFlow(true); //平面滚动
//        mList.setGreyItem(true); //设置灰度渐变
//        mList.setAlphaItem(true); //设置半透渐变

      // mList.set3DItem(true); //3D 滚动
        mList.setLoop(); //循环滚动，注：循环滚动模式暂不支持平滑滚动
        mList.setAdapter(new Adapter(this, this, false));
        mList.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                //((TextView)findViewById(R.id.index)).setText((position+1)+"/"+mList.getLayoutManager().getItemCount());
            }
        });
    }
    @Override
    public void clickItem(int pos) {
        mList.smoothScrollToPosition(pos);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
    }
}