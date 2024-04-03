package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.tpro.TProView;

public final class DarkstoresItemHomeTproV2Binding implements ViewBinding {
    @NonNull
    private final TProView rootView;
    @NonNull
    public final TProView subscriptionHeaderTop;

    private DarkstoresItemHomeTproV2Binding(@NonNull TProView tProView, @NonNull TProView tProView2) {
        this.rootView = tProView;
        this.subscriptionHeaderTop = tProView2;
    }

    @NonNull
    public static DarkstoresItemHomeTproV2Binding bind(@NonNull View view) {
        if (view != null) {
            TProView tProView = (TProView) view;
            return new DarkstoresItemHomeTproV2Binding(tProView, tProView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemHomeTproV2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemHomeTproV2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_home_tpro_v2, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TProView getRoot() {
        return this.rootView;
    }
}
