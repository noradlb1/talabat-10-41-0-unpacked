package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.homescreen.R;

public final class BottomSheetItemReplacementBinding implements ViewBinding {
    @NonNull
    public final TextView bsItemReplacementDescription;
    @NonNull
    public final TextView bsItemReplacementTitle;
    @NonNull
    private final LinearLayoutCompat rootView;

    private BottomSheetItemReplacementBinding(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayoutCompat;
        this.bsItemReplacementDescription = textView;
        this.bsItemReplacementTitle = textView2;
    }

    @NonNull
    public static BottomSheetItemReplacementBinding bind(@NonNull View view) {
        int i11 = R.id.bs_item_replacement_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.bs_item_replacement_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                return new BottomSheetItemReplacementBinding((LinearLayoutCompat) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static BottomSheetItemReplacementBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BottomSheetItemReplacementBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_item_replacement, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }
}
