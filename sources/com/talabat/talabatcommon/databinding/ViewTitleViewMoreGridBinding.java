package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewTitleViewMoreGridBinding implements ViewBinding {
    @NonNull
    private final View rootView;
    @NonNull
    public final RecyclerView titleViewMoreRecyclerView;
    @NonNull
    public final RelativeLayout titleViewMoreTitleRelativeLayout;
    @NonNull
    public final TextView titleViewMoreTitleTextView;
    @NonNull
    public final TextView titleViewMoreViewMoreTextView;

    private ViewTitleViewMoreGridBinding(@NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = view;
        this.titleViewMoreRecyclerView = recyclerView;
        this.titleViewMoreTitleRelativeLayout = relativeLayout;
        this.titleViewMoreTitleTextView = textView;
        this.titleViewMoreViewMoreTextView = textView2;
    }

    @NonNull
    public static ViewTitleViewMoreGridBinding bind(@NonNull View view) {
        int i11 = R.id.titleViewMoreRecyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
        if (recyclerView != null) {
            i11 = R.id.titleViewMoreTitleRelativeLayout;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
            if (relativeLayout != null) {
                i11 = R.id.titleViewMoreTitleTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.titleViewMoreViewMoreTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        return new ViewTitleViewMoreGridBinding(view, recyclerView, relativeLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewTitleViewMoreGridBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_title_view_more_grid, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
