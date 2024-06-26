package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.banner.BannerView;

public final class DarkstoresItemHomeBannerBinding implements ViewBinding {
    @NonNull
    public final BannerView bannerView;
    @NonNull
    private final LinearLayout rootView;

    private DarkstoresItemHomeBannerBinding(@NonNull LinearLayout linearLayout, @NonNull BannerView bannerView2) {
        this.rootView = linearLayout;
        this.bannerView = bannerView2;
    }

    @NonNull
    public static DarkstoresItemHomeBannerBinding bind(@NonNull View view) {
        int i11 = R.id.banner_view;
        BannerView bannerView2 = (BannerView) ViewBindings.findChildViewById(view, i11);
        if (bannerView2 != null) {
            return new DarkstoresItemHomeBannerBinding((LinearLayout) view, bannerView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemHomeBannerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemHomeBannerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_home_banner, viewGroup, false);
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
