package com.talabat.fluttercore.presentation;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatFlutterFragmentActivity$talabatFeatureFlag$2 extends Lambda implements Function0<ITalabatFeatureFlag> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatFlutterFragmentActivity f59791g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatFlutterFragmentActivity$talabatFeatureFlag$2(TalabatFlutterFragmentActivity talabatFlutterFragmentActivity) {
        super(0);
        this.f59791g = talabatFlutterFragmentActivity;
    }

    @NotNull
    public final ITalabatFeatureFlag invoke() {
        return this.f59791g.getFeatureFlagCoreLibApi().getTalabatFeatureFlag();
    }
}
