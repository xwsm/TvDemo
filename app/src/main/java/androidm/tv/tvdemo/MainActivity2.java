package androidm.tv.tvdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.owen.focus.AbsFocusBorder;
import com.owen.focus.FocusBorder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity2 extends AppCompatActivity {
    FocusBorder mColorFocusBorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        /** 颜色焦点框 */
        mColorFocusBorder = new FocusBorder.Builder().asColor()
                //阴影宽度(方法shadowWidth(18f)也可以设置阴影宽度)
                .shadowWidth(TypedValue.COMPLEX_UNIT_DIP, 20f)
                //阴影颜色
                .shadowColor(Color.parseColor("#3FBB66"))
                //边框宽度(方法borderWidth(2f)也可以设置边框宽度)
                .borderWidth(TypedValue.COMPLEX_UNIT_DIP, 3.2f)
                //边框颜色
                .borderColor(Color.parseColor("#00FF00"))
                //padding值
                .padding(2f)
                //动画时长
                .animDuration(300)
                //不要闪光动画
                //.noShimmer()
                //闪光颜色
                .shimmerColor(Color.parseColor("#66FFFFFF"))
                //闪光动画时长
                .shimmerDuration(1000)
                //不要呼吸灯效果
                //.noBreathing()
                //呼吸灯效果时长
                .breathingDuration(3000)
                //边框动画模式
                .animMode(AbsFocusBorder.Mode.TOGETHER)
                .build(this);

        //焦点监听 方式一:绑定整个页面的焦点监听事件
        mColorFocusBorder.boundGlobalFocusListener(new FocusBorder.OnFocusCallback() {
            @Override
            public FocusBorder.Options onFocus(View oldFocus, View newFocus) {
                if (null != newFocus) {
                    switch (newFocus.getId()) {
                        case R.id.i1:
                        case R.id.i2:
                        case R.id.i3:
                        case R.id.i4:
                        case R.id.i5:
                        case R.id.i6:
                        case R.id.i7:
                        case R.id.i8:
                        case R.id.l1:
                        case R.id.l2:
                            float scale = 1.2f;
                            //return FocusBorder.OptionsFactory.get(scale, scale, dp2px(0) * scale);
                            return FocusBorder.OptionsFactory.get(1f, 1f);
                        default:
                            break;
                    }
                }
                Log.i("xxxx", "aaaaaaaaaaaaaaaaaaaa");
                //返回null表示不使用焦点框框架
                return null;
            }
        });

        /*
       //  图片焦点框
        FocusBorder mDrawableFocusBorder = new FocusBorder.Builder().asDrawable()
                .borderDrawableRes(R.drawable.focus)
                .titleBackgroundRes(R.drawable.shape_item_title_bg)
                .titleMarginBottomAutoAlignBorder()
                .titleMargin(10, 0, 10, 4)
                .titlePadding(10)
                .titleTextColor(Color.LTGRAY)
                .titleTextSize(24)
                .titleWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .build(this);

        //焦点监听 方式二:单个的焦点监听事件
       i1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    mColorFocusBorder.onFocus(v, FocusBorder.OptionsFactory.get(1.2f, 1.2f));
                }
            }
        });*/

    }

    private float dp2px(int dp) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    @BindView(R.id.i1)
    ImageView i1;
    @BindView(R.id.i2)
    ImageView i2;
    @BindView(R.id.i3)
    ImageView i3;
    @BindView(R.id.i4)
    ImageView i4;
    @BindView(R.id.i5)
    ImageView i5;
    @BindView(R.id.i6)
    ImageView i6;
    @BindView(R.id.i7)
    ImageView i7;
    @BindView(R.id.i8)
    ImageView i8;
    @BindView(R.id.l1)
    LinearLayout l1;
    @BindView(R.id.l2)
    LinearLayout l2;

    @OnClick({R.id.i1, R.id.i2, R.id.i3, R.id.i4, R.id.i5, R.id.i6, R.id.i7, R.id.i8, R.id.l1, R.id.l2})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.i1:
                mColorFocusBorder.onFocus(i1, null);
                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i2:
                mColorFocusBorder.onFocus(i2, null);
                Toast.makeText(this, "222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i3:
                mColorFocusBorder.onFocus(i3, null);
                Toast.makeText(this, "333", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i4:
                mColorFocusBorder.onFocus(i4, null);
                Toast.makeText(this, "444", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i5:
                mColorFocusBorder.onFocus(i5, null);
                Toast.makeText(this, "555", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i6:
                mColorFocusBorder.onFocus(i6, null);
                Toast.makeText(this, "666", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i7:
                mColorFocusBorder.onFocus(i7, null);
                Toast.makeText(this, "777", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i8:
                mColorFocusBorder.onFocus(i8, null);
                Toast.makeText(this, "888", Toast.LENGTH_SHORT).show();
                break;
            case R.id.l1:
                mColorFocusBorder.onFocus(l1, null);
                Toast.makeText(this, "LLL111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.l2:
                mColorFocusBorder.onFocus(l2, null);
                Toast.makeText(this, "LLL222", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }
}
