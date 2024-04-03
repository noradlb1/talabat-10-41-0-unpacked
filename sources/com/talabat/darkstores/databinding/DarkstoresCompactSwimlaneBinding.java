package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.cart.views.CompactSwimlaneView;

public final class DarkstoresCompactSwimlaneBinding implements ViewBinding {
    @NonNull
    public final CompactSwimlaneView compactSwimlane;
    @NonNull
    private final CompactSwimlaneView rootView;

    private DarkstoresCompactSwimlaneBinding(@NonNull CompactSwimlaneView compactSwimlaneView, @NonNull CompactSwimlaneView compactSwimlaneView2) {
        this.rootView = compactSwimlaneView;
        this.compactSwimlane = compactSwimlaneView2;
    }

    @NonNull
    public static DarkstoresCompactSwimlaneBinding bind(@NonNull View view) {
        if (view != null) {
            CompactSwimlaneView compactSwimlaneView = (CompactSwimlaneView) view;
            return new DarkstoresCompactSwimlaneBinding(compactSwimlaneView, compactSwimlaneView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresCompactSwimlaneBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresCompactSwimlaneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_compact_swimlane, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CompactSwimlaneView getRoot() {
        return this.rootView;
    }
}
