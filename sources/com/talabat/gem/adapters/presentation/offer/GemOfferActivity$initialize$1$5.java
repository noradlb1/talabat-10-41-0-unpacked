package com.talabat.gem.adapters.presentation.offer;

import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType", "verticalOffset", "", "onOffsetChanged"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferActivity$initialize$1$5 implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GemOfferActivity f60201a;

    public GemOfferActivity$initialize$1$5(GemOfferActivity gemOfferActivity) {
        this.f60201a = gemOfferActivity;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        this.f60201a.checkVisibilityThreshold(((float) Math.abs(i11)) / ((float) appBarLayout.getTotalScrollRange()));
    }
}
