package com.talabat.restaurants.inlineads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.restaurants.inlineads.RxAdLoader;
import io.reactivex.SingleEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/restaurants/inlineads/RxAdLoader$loadNativeCustomTemplateAd$1$3", "Lcom/google/android/gms/ads/AdListener;", "onAdFailedToLoad", "", "loadAdError", "Lcom/google/android/gms/ads/LoadAdError;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RxAdLoader$loadNativeCustomTemplateAd$1$3 extends AdListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter<NativeCustomTemplateAd> f61225b;

    public RxAdLoader$loadNativeCustomTemplateAd$1$3(SingleEmitter<NativeCustomTemplateAd> singleEmitter) {
        this.f61225b = singleEmitter;
    }

    public void onAdFailedToLoad(@NotNull LoadAdError loadAdError) {
        Intrinsics.checkNotNullParameter(loadAdError, "loadAdError");
        super.onAdFailedToLoad(loadAdError);
        this.f61225b.tryOnError(new RxAdLoader.AdRequestErrorException(new RxAdLoader.AdRequestError(loadAdError.getCode())));
    }
}
