package androidm.tv.tvdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.owen.focus.AbsFocusBorder;
import com.owen.focus.FocusBorder;
import com.owen.tvrecyclerview.widget.SimpleOnItemListener;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity3 extends AppCompatActivity {
    private FocusBorder mFocusBorder;
    TvRecyclerView tRv;
    TvRecyclerView tRv2;
    BaseQuickAdapter<String, BaseViewHolder> adapter;
    BaseQuickAdapter<String, BaseViewHolder> adapter2;
    List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        // 移动框
        if (null == mFocusBorder) {
            mFocusBorder = new FocusBorder.Builder()
                    .asColor()
                    .borderColorRes(R.color.colorAccent2)
                    .borderWidth(TypedValue.COMPLEX_UNIT_DIP, 22f)
                    .shadowColorRes(R.color.colorAccent2)
                    .shadowWidth(TypedValue.COMPLEX_UNIT_DIP, 22f)
                    .build(this);
        }
//        mFocusBorder.boundGlobalFocusListener(new FocusBorder.OnFocusCallback() {
//            @Override
//            public FocusBorder.Options onFocus(View oldFocus, View newFocus) {
//                if (null != newFocus) {
//                    switch (newFocus.getId()) {
//                        case R.id.l1:
//                            Toast.makeText(MainActivity3.this,"onFocus",Toast.LENGTH_SHORT).show();
//                            float scale = 1.2f;
//                            //return FocusBorder.OptionsFactory.get(scale, scale, dp2px(0) * scale);
//                            return FocusBorder.OptionsFactory.get(1f, 1f);
//                        default:
//                            break;
//                    }
//                }
//                //返回null表示不使用焦点框框架
//                return null;
//            }
//        });

        tRv = findViewById(R.id.trv);
        tRv2 = findViewById(R.id.trv2);
        findViewById(R.id.l1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });
        for (int i = 0; i < 20; i++) {
            datas.add("xxxxxxx--->>>" + i);
        }
        adapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.activity_main_item, datas) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                ((TextView) helper.getView(R.id.name)).setText(item);
            }
        };
        adapter2 = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.activity_main_item, datas) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                ((TextView) helper.getView(R.id.name)).setText(item);
            }
        };
        // 设置布局的横纵间距
        tRv.setSpacingWithMargins(10, 10);
        tRv.setAdapter(adapter);
        tRv2.setSpacingWithMargins(10, 10);
        tRv2.setAdapter(adapter2);

        tRv.setOnItemListener(new SimpleOnItemListener() {

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
//                float radius = DisplayAdaptive.getInstance().toLocalPx(10);
                onMoveFocusBorder(itemView, 1.1f, 10);
                Log.i("onItem", "onItemSelected");
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
//                showToast("onItemClick::"+position);
                Toast.makeText(MainActivity3.this, "onItemClick:" + position, Toast.LENGTH_SHORT).show();
                Log.i("onItem", "onItemClick");
            }
        });


        tRv2.setOnItemListener(new SimpleOnItemListener() {

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                onMoveFocusBorder(itemView, 1.1f, 10);
                Log.i("onItem", "onItemSelected");
            }


            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
//                showToast("onItemClick::"+position);
                Toast.makeText(MainActivity3.this, "onItemClick:" + position, Toast.LENGTH_SHORT).show();
                Log.i("onItem", "onItemClick");
            }
        });
        l1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.i("xxx", "xxxxxxxxxxxxxx--->" + hasFocus);
//                mFocusBorder.setVisible(!hasFocus);
//                mFocusBorder.onFocus(v, FocusBorder.OptionsFactory.get(1f, 1f));
                if (tRv.hasFocus() || tRv2.hasFocus() && !hasFocus)
                    return;
                mFocusBorder.setVisible(hasFocus);
                mFocusBorder.onFocus(v, FocusBorder.OptionsFactory.get(1f, 1f));

            }
        });

        tRv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (tRv2.hasFocus() || l1.hasFocus() && !hasFocus)
                    return;
                mFocusBorder.setVisible(hasFocus);
            }
        });

        tRv2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (tRv.hasFocus()|| l1.hasFocus() && !hasFocus)
                    return;
                mFocusBorder.setVisible(hasFocus);
            }
        });
    }

    @BindView(R.id.l1)
    LinearLayout l1;

    protected void onMoveFocusBorder(View focusedView, float scale, float roundRadius) {
        if (null != mFocusBorder) {
            mFocusBorder.onFocus(focusedView, FocusBorder.OptionsFactory.get(1f, 1f));
        }
    }

    private float dp2px(int dp) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }


}
