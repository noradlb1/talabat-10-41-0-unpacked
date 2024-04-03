package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.talabat.R;

public class MiniCartLayout extends LinearLayout {
    private OnCartClickListener mClickListener;
    private MiniCartTotalLayout mMiniCartTotalLayout;
    private MiniCartDisabledLayout miniCartDisabledLayout;

    public interface OnCartClickListener {
        void cartButtonClicked();
    }

    public MiniCartLayout(Context context) {
        super(context);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.mini_cart, this));
    }

    private void hideVisibleView() {
        View findViewWithTag = findViewWithTag("Visible");
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(8);
            findViewWithTag.setTag("GONE");
        }
    }

    private void initView(View view) {
        this.mMiniCartTotalLayout = (MiniCartTotalLayout) view.findViewById(R.id.miniCartTotal);
        this.miniCartDisabledLayout = (MiniCartDisabledLayout) view.findViewById(R.id.mini_cart_disabled);
    }

    public void setClickListener(OnCartClickListener onCartClickListener) {
        this.mClickListener = onCartClickListener;
    }

    public void showMiniCart(int i11, String str, String str2, String str3, boolean z11) {
        String str4 = str.replaceAll(",", "").split(" ")[1];
        String str5 = str2.replaceAll(",", "").split(" ")[1];
        double parseDouble = Double.parseDouble(str3.replaceAll(",", "").split(" ")[1]);
        double parseDouble2 = Double.parseDouble(str5);
        if (str4.contains("%")) {
            str4 = str4.replace('%', ' ').trim();
        }
        if (!str4.isEmpty()) {
            Double.parseDouble(str4);
        }
        if ((parseDouble2 == 0.0d || parseDouble >= parseDouble2) && i11 != 0) {
            if (this.mMiniCartTotalLayout.getVisibility() != 0) {
                hideVisibleView();
                this.mMiniCartTotalLayout.setVisibility(0);
                this.mMiniCartTotalLayout.setTag("Visible");
            }
            this.mMiniCartTotalLayout.setData(getContext(), i11, str3, this.mClickListener);
            return;
        }
        if (this.miniCartDisabledLayout.getVisibility() != 0) {
            hideVisibleView();
            this.miniCartDisabledLayout.setVisibility(0);
            this.miniCartDisabledLayout.setTag("Visible");
        }
        this.miniCartDisabledLayout.setData(getContext(), i11, str3, this.mClickListener);
    }

    public MiniCartLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.mini_cart, this));
    }
}
