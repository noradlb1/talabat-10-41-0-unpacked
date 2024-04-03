package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.talabatcommon.views.banners.DisclaimerBannerView;

public final class DarkstoresItemDisclaimerBannerBinding implements ViewBinding {
    @NonNull
    public final DisclaimerBannerView disclaimerBanner;
    @NonNull
    private final DisclaimerBannerView rootView;

    private DarkstoresItemDisclaimerBannerBinding(@NonNull DisclaimerBannerView disclaimerBannerView, @NonNull DisclaimerBannerView disclaimerBannerView2) {
        this.rootView = disclaimerBannerView;
        this.disclaimerBanner = disclaimerBannerView2;
    }

    @NonNull
    public static DarkstoresItemDisclaimerBannerBinding bind(@NonNull View view) {
        if (view != null) {
            DisclaimerBannerView disclaimerBannerView = (DisclaimerBannerView) view;
            return new DarkstoresItemDisclaimerBannerBinding(disclaimerBannerView, disclaimerBannerView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemDisclaimerBannerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemDisclaimerBannerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_disclaimer_banner, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public DisclaimerBannerView getRoot() {
        return this.rootView;
    }
}
