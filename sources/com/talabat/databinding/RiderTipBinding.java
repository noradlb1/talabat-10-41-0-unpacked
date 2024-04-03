package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;
import com.talabat.feature.ridertips.presentation.view.RiderTipView;

public final class RiderTipBinding implements ViewBinding {
    @NonNull
    public final RiderTipView riderTipView;
    @NonNull
    private final RiderTipView rootView;

    private RiderTipBinding(@NonNull RiderTipView riderTipView2, @NonNull RiderTipView riderTipView3) {
        this.rootView = riderTipView2;
        this.riderTipView = riderTipView3;
    }

    @NonNull
    public static RiderTipBinding bind(@NonNull View view) {
        if (view != null) {
            RiderTipView riderTipView2 = (RiderTipView) view;
            return new RiderTipBinding(riderTipView2, riderTipView2);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static RiderTipBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static RiderTipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.rider_tip, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RiderTipView getRoot() {
        return this.rootView;
    }
}
