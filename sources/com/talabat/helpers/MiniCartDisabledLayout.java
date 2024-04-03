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
import zr.g;
import zr.h;
import zr.i;

public class MiniCartDisabledLayout extends LinearLayout {
    private TextView mCartItemsAmountTxt;
    private Button mShowCartBtn;
    private TextView mTotalAmountTxt;
    private View mViewContainer;

    public MiniCartDisabledLayout(Context context) {
        super(context);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.mini_cart_disabled, this));
    }

    private void initView(View view) {
        this.mCartItemsAmountTxt = (TextView) view.findViewById(R.id.cartAmount);
        this.mTotalAmountTxt = (TextView) view.findViewById(R.id.totalAmount);
        this.mShowCartBtn = (Button) view.findViewById(R.id.showCartBtn);
        this.mViewContainer = view.findViewById(R.id.ll_container);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setData$0(int i11, MiniCartLayout.OnCartClickListener onCartClickListener, View view) {
        if (i11 > 0 && onCartClickListener != null) {
            onCartClickListener.cartButtonClicked();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setData$1(int i11, MiniCartLayout.OnCartClickListener onCartClickListener, View view) {
        if (i11 > 0 && onCartClickListener != null) {
            onCartClickListener.cartButtonClicked();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setData$2(int i11, MiniCartLayout.OnCartClickListener onCartClickListener, View view) {
        if (i11 > 0 && onCartClickListener != null) {
            onCartClickListener.cartButtonClicked();
        }
    }

    public void setData(Context context, int i11, String str, MiniCartLayout.OnCartClickListener onCartClickListener) {
        if (i11 > 0) {
            this.mShowCartBtn.setText(getResources().getString(R.string.see_cart));
        } else {
            this.mShowCartBtn.setText(getResources().getString(R.string.cart_add_more_items));
        }
        TextView textView = this.mCartItemsAmountTxt;
        textView.setText(i11 + "");
        if (GlobalDataModel.ANIMATIONHELPER.addItemClicked) {
            GlobalDataModel.ANIMATIONHELPER.addItemClicked = false;
            this.mCartItemsAmountTxt.startAnimation(AnimationUtils.loadAnimation(context, R.anim.count_scale));
        }
        this.mTotalAmountTxt.setText(str);
        this.mCartItemsAmountTxt.setOnClickListener(new g(i11, onCartClickListener));
        this.mShowCartBtn.setOnClickListener(new h(i11, onCartClickListener));
        this.mViewContainer.setOnClickListener(new i(i11, onCartClickListener));
    }

    public MiniCartDisabledLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.mini_cart_disabled, this));
    }
}
