package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rd.PageIndicatorView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.banner.LoopingViewPager;

public final class DarkstoresBannerViewBinding implements ViewBinding {
    @NonNull
    public final TextView bannerTitle;
    @NonNull
    public final PageIndicatorView pageIndicatorView;
    @NonNull
    private final View rootView;
    @NonNull
    public final LoopingViewPager viewpager;

    private DarkstoresBannerViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull PageIndicatorView pageIndicatorView2, @NonNull LoopingViewPager loopingViewPager) {
        this.rootView = view;
        this.bannerTitle = textView;
        this.pageIndicatorView = pageIndicatorView2;
        this.viewpager = loopingViewPager;
    }

    @NonNull
    public static DarkstoresBannerViewBinding bind(@NonNull View view) {
        int i11 = R.id.banner_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.pageIndicatorView;
            PageIndicatorView pageIndicatorView2 = (PageIndicatorView) ViewBindings.findChildViewById(view, i11);
            if (pageIndicatorView2 != null) {
                i11 = R.id.viewpager;
                LoopingViewPager loopingViewPager = (LoopingViewPager) ViewBindings.findChildViewById(view, i11);
                if (loopingViewPager != null) {
                    return new DarkstoresBannerViewBinding(view, textView, pageIndicatorView2, loopingViewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresBannerViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_banner_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
