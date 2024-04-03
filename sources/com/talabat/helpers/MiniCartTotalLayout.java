package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.talabat.R;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.MiniCartLayout;
import zr.j;
import zr.k;
import zr.l;

public class MiniCartTotalLayout extends LinearLayout {
    private TextView mCartItemsAmountTxt;
    private Button mShowCartBtn;
    private TextView mTotalAmountTxt;
    private View mViewContainer;

    public MiniCartTotalLayout(Context context) {
        super(context);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.mini_cart_total, this));
    }

    private void initView(View view) {
        this.mCartItemsAmountTxt = (TextView) view.findViewById(R.id.cartAmount);
        this.mTotalAmountTxt = (TextView) view.findViewById(R.id.totalAmount);
        this.mShowCartBtn = (Button) view.findViewById(R.id.showCartBtn);
        this.mViewContainer = view.findViewById(R.id.ll_container);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setData$0(MiniCartLayout.OnCartClickListener onCartClickListener, View view) {
        if (onCartClickListener != null) {
            onCartClickListener.cartButtonClicked();
        }
    }

    public void setData(Context context, int i11, String str, MiniCartLayout.OnCartClickListener onCartClickListener) {
        TextView textView = this.mCartItemsAmountTxt;
        textView.setText(i11 + "");
        if (GlobalDataModel.ANIMATIONHELPER.addItemClicked) {
            GlobalDataModel.ANIMATIONHELPER.addItemClicked = false;
            this.mCartItemsAmountTxt.startAnimation(AnimationUtils.loadAnimation(context, R.anim.count_scale));
        }
        this.mTotalAmountTxt.setText(str);
        this.mCartItemsAmountTxt.setOnClickListener(new j(onCartClickListener));
        this.mShowCartBtn.setOnClickListener(new k(onCartClickListener));
        this.mViewContainer.setOnClickListener(new l(onCartClickListener));
    }

    public MiniCartTotalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.mini_cart_total, this));
    }
}
