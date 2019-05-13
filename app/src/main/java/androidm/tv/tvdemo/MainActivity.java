package androidm.tv.tvdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.owen.focus.FocusBorder;
import com.owen.tvrecyclerview.widget.SimpleOnItemListener;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    TvRecyclerView tRv;
    BaseQuickAdapter<String, BaseViewHolder> adapter;
    List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tRv = findViewById(R.id.trv);
        for (int i = 0; i < 20; i++) {
            datas.add("xxxxxxx--->>>" + i);
        }
        adapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.activity_main_item, datas) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                ((TextView) helper.getView(R.id.name)).setText(item);
            }
        };
        // 设置布局的横纵间距
        tRv.setSpacingWithMargins(10, 10);
        tRv.setAdapter(adapter);


        tRv.setOnItemListener(new SimpleOnItemListener() {

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
//                float radius = DisplayAdaptive.getInstance().toLocalPx(10);
//                onMoveFocusBorder(itemView, 1.1f, radius);
                Log.i("onItem","onItemSelected");
                itemView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
//                showToast("onItemClick::"+position);
                Toast.makeText(MainActivity.this,"onItemClick:"+position,Toast.LENGTH_SHORT).show();
                Log.i("onItem","onItemClick");
            }
        });

        tRv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
//                mFocusBorder.setVisible(hasFocus);
                Log.i("onItem","onFocusChange");
            }
        });
    }

}
