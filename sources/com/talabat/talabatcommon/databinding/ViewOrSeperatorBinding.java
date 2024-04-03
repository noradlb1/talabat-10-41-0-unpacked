package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;

public final class ViewOrSeperatorBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;

    private ViewOrSeperatorBinding(@NonNull LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    @NonNull
    public static ViewOrSeperatorBinding bind(@NonNull View view) {
        if (view != null) {
            return new ViewOrSeperatorBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ViewOrSeperatorBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewOrSeperatorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_or_seperator, viewGroup, false);
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
