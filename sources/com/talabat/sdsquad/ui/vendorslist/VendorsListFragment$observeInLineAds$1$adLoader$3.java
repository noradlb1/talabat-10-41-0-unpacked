package com.talabat.sdsquad.ui.vendorslist;

import android.util.Log;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/sdsquad/ui/vendorslist/VendorsListFragment$observeInLineAds$1$adLoader$3", "Lcom/google/android/gms/ads/AdListener;", "onAdFailedToLoad", "", "loadAdError", "Lcom/google/android/gms/ads/LoadAdError;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$observeInLineAds$1$adLoader$3 extends AdListener {
    public void onAdFailedToLoad(@NotNull LoadAdError loadAdError) {
        Intrinsics.checkNotNullParameter(loadAdError, "loadAdError");
        AdError cause = loadAdError.getCause();
        Log.e("inlineAds", "onAdFailedToLoad: " + cause + "ad: ", (Throwable) null);
    }
}
