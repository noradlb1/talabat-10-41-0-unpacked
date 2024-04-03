package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.talabat.talabatcommon.R;

public final class ViewTitleViewMoreHorizontalListBinding implements ViewBinding {
    @NonNull
    private final View rootView;
    @NonNull
    public final RelativeLayout titleViewMoreTitleRelativeLayout;
    @NonNull
    public final TextView titleViewMoreTitleTextView;
    @NonNull
    public final ImageView titleViewMoreViewAllImageView;
    @NonNull
    public final ViewPager titleViewMoreViewPager;

    private ViewTitleViewMoreHorizontalListBinding(@NonNull View view, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ViewPager viewPager) {
        this.rootView = view;
        this.titleViewMoreTitleRelativeLayout = relativeLayout;
        this.titleViewMoreTitleTextView = textView;
        this.titleViewMoreViewAllImageView = imageView;
        this.titleViewMoreViewPager = viewPager;
    }

    @NonNull
    public static ViewTitleViewMoreHorizontalListBinding bind(@NonNull View view) {
        int i11 = R.id.titleViewMoreTitleRelativeLayout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
        if (relativeLayout != null) {
            i11 = R.id.titleViewMoreTitleTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.titleViewMoreViewAllImageView;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    i11 = R.id.titleViewMoreViewPager;
                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i11);
                    if (viewPager != null) {
                        return new ViewTitleViewMoreHorizontalListBinding(view, relativeLayout, textView, imageView, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewTitleViewMoreHorizontalListBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_title_view_more_horizontal_list, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
