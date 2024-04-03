package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class RecentSearchItemBinding implements ViewBinding {
    @NonNull
    public final ImageView ivArrow;
    @NonNull
    public final ImageView ivSearch;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvQuery;

    private RecentSearchItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.ivArrow = imageView;
        this.ivSearch = imageView2;
        this.tvQuery = textView;
    }

    @NonNull
    public static RecentSearchItemBinding bind(@NonNull View view) {
        int i11 = R.id.ivArrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.ivSearch;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView2 != null) {
                i11 = R.id.tvQuery;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    return new RecentSearchItemBinding((ConstraintLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static RecentSearchItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static RecentSearchItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.recent_search_item, viewGroup, false);
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
