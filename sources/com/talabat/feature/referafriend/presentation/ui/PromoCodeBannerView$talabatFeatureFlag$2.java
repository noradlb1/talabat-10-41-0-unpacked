package com.talabat.feature.referafriend.presentation.ui;

import android.view.View;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PromoCodeBannerView$talabatFeatureFlag$2 extends Lambda implements Function0<ITalabatFeatureFlag> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PromoCodeBannerView f58728g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoCodeBannerView$talabatFeatureFlag$2(PromoCodeBannerView promoCodeBannerView) {
        super(0);
        this.f58728g = promoCodeBannerView;
    }

    @NotNull
    public final ITalabatFeatureFlag invoke() {
        return ((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this.f58728g).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
    }
}
