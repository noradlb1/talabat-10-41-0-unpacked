package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rd.PageIndicatorView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.banner.LoopingViewPager;

public final class LayoutDarkstoresImageSliderBinding implements ViewBinding {
    @NonNull
    public final FrameLayout bottomContainer;
    @NonNull
    public final PageIndicatorView pageIndicatorView;
    @NonNull
    public final TextView pageNumberText;
    @NonNull
    private final View rootView;
    @NonNull
    public final FrameLayout viewPagerContainer;
    @NonNull
    public final LoopingViewPager viewpager;

    private LayoutDarkstoresImageSliderBinding(@NonNull View view, @NonNull FrameLayout frameLayout, @NonNull PageIndicatorView pageIndicatorView2, @NonNull TextView textView, @NonNull FrameLayout frameLayout2, @NonNull LoopingViewPager loopingViewPager) {
        this.rootView = view;
        this.bottomContainer = frameLayout;
        this.pageIndicatorView = pageIndicatorView2;
        this.pageNumberText = textView;
        this.viewPagerContainer = frameLayout2;
        this.viewpager = loopingViewPager;
    }

    @NonNull
    public static LayoutDarkstoresImageSliderBinding bind(@NonNull View view) {
        int i11 = R.id.bottomContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
        if (frameLayout != null) {
            i11 = R.id.pageIndicatorView;
            PageIndicatorView pageIndicatorView2 = (PageIndicatorView) ViewBindings.findChildViewById(view, i11);
            if (pageIndicatorView2 != null) {
                i11 = R.id.pageNumberText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.viewPagerContainer;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i11);
                    if (frameLayout2 != null) {
                        i11 = R.id.viewpager;
                        LoopingViewPager loopingViewPager = (LoopingViewPager) ViewBindings.findChildViewById(view, i11);
                        if (loopingViewPager != null) {
                            return new LayoutDarkstoresImageSliderBinding(view, frameLayout, pageIndicatorView2, textView, frameLayout2, loopingViewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutDarkstoresImageSliderBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.layout_darkstores_image_slider, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
