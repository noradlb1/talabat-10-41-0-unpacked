package com.talabat.feature.referafriend.presentation.ui;

import android.view.View;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PromoCodeBannerView$talabatTracker$2 extends Lambda implements Function0<TalabatTracker> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PromoCodeBannerView f58729g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoCodeBannerView$talabatTracker$2(PromoCodeBannerView promoCodeBannerView) {
        super(0);
        this.f58729g = promoCodeBannerView;
    }

    @NotNull
    public final TalabatTracker invoke() {
        return ((TrackingCoreLibApi) AndroidComponentsKt.apiContainer((View) this.f58729g).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
    }
}
