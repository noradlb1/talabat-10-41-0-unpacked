package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.SwimlaneView;

public final class DarkstoresItemSubcategorySwimlaneBinding implements ViewBinding {
    @NonNull
    private final SwimlaneView rootView;
    @NonNull
    public final SwimlaneView swimlane;

    private DarkstoresItemSubcategorySwimlaneBinding(@NonNull SwimlaneView swimlaneView, @NonNull SwimlaneView swimlaneView2) {
        this.rootView = swimlaneView;
        this.swimlane = swimlaneView2;
    }

    @NonNull
    public static DarkstoresItemSubcategorySwimlaneBinding bind(@NonNull View view) {
        if (view != null) {
            SwimlaneView swimlaneView = (SwimlaneView) view;
            return new DarkstoresItemSubcategorySwimlaneBinding(swimlaneView, swimlaneView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemSubcategorySwimlaneBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemSubcategorySwimlaneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_subcategory_swimlane, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public SwimlaneView getRoot() {
        return this.rootView;
    }
}
