package com.talabat.fluttercore.presentation;

import androidx.fragment.app.Fragment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PreWarmedFlutterFragment$talabatFeatureFlag$2 extends Lambda implements Function0<ITalabatFeatureFlag> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PreWarmedFlutterFragment f59780g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreWarmedFlutterFragment$talabatFeatureFlag$2(PreWarmedFlutterFragment preWarmedFlutterFragment) {
        super(0);
        this.f59780g = preWarmedFlutterFragment;
    }

    @NotNull
    public final ITalabatFeatureFlag invoke() {
        return ((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this.f59780g).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
    }
}
