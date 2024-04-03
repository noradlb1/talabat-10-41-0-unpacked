package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;

public final class AutoCompleteFooterViewBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout deliverHereContainer;
    @NonNull
    private final RelativeLayout rootView;

    private AutoCompleteFooterViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.deliverHereContainer = relativeLayout2;
    }

    @NonNull
    public static AutoCompleteFooterViewBinding bind(@NonNull View view) {
        if (view != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new AutoCompleteFooterViewBinding(relativeLayout, relativeLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static AutoCompleteFooterViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static AutoCompleteFooterViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.auto_complete_footer_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
