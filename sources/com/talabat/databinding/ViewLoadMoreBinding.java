package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;

public final class ViewLoadMoreBinding implements ViewBinding {
    @NonNull
    public final LinearLayout llLoadMore;
    @NonNull
    private final LinearLayout rootView;

    private ViewLoadMoreBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.llLoadMore = linearLayout2;
    }

    @NonNull
    public static ViewLoadMoreBinding bind(@NonNull View view) {
        if (view != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new ViewLoadMoreBinding(linearLayout, linearLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ViewLoadMoreBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewLoadMoreBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_load_more, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
