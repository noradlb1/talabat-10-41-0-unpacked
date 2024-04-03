package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ContinuousScrollTabItemBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView sectionName;

    private ContinuousScrollTabItemBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.sectionName = textView;
    }

    @NonNull
    public static ContinuousScrollTabItemBinding bind(@NonNull View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.section_name);
        if (textView != null) {
            return new ContinuousScrollTabItemBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.section_name)));
    }

    @NonNull
    public static ContinuousScrollTabItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ContinuousScrollTabItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.continuous_scroll_tab_item, viewGroup, false);
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
