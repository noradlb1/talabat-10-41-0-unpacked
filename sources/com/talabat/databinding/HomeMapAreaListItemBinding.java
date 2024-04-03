package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class HomeMapAreaListItemBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView itemText;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final FrameLayout seperatorBottom;

    private HomeMapAreaListItemBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.itemText = talabatTextView;
        this.seperatorBottom = frameLayout;
    }

    @NonNull
    public static HomeMapAreaListItemBinding bind(@NonNull View view) {
        int i11 = R.id.item_text;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_text);
        if (talabatTextView != null) {
            i11 = R.id.seperator_bottom;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.seperator_bottom);
            if (frameLayout != null) {
                return new HomeMapAreaListItemBinding((LinearLayout) view, talabatTextView, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static HomeMapAreaListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static HomeMapAreaListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.home_map_area_list_item, viewGroup, false);
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
