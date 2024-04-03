package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresFragmentBottomSheetSortBinding implements ViewBinding {
    @NonNull
    public final TextView btnApply;
    @NonNull
    public final ImageView close;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final RecyclerView sortOptionRv;
    @NonNull
    public final AppCompatTextView title;

    private DarkstoresFragmentBottomSheetSortBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.btnApply = textView;
        this.close = imageView;
        this.sortOptionRv = recyclerView;
        this.title = appCompatTextView;
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetSortBinding bind(@NonNull View view) {
        int i11 = R.id.btn_apply;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.sort_option_rv;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                if (recyclerView != null) {
                    i11 = R.id.title;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                    if (appCompatTextView != null) {
                        return new DarkstoresFragmentBottomSheetSortBinding((ConstraintLayout) view, textView, imageView, recyclerView, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetSortBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetSortBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_bottom_sheet_sort, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
