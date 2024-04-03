package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresItemBannerPagerBinding implements ViewBinding {
    @NonNull
    public final ImageView bannerImage;
    @NonNull
    private final ImageView rootView;

    private DarkstoresItemBannerPagerBinding(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.rootView = imageView;
        this.bannerImage = imageView2;
    }

    @NonNull
    public static DarkstoresItemBannerPagerBinding bind(@NonNull View view) {
        if (view != null) {
            ImageView imageView = (ImageView) view;
            return new DarkstoresItemBannerPagerBinding(imageView, imageView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemBannerPagerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemBannerPagerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_banner_pager, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ImageView getRoot() {
        return this.rootView;
    }
}
