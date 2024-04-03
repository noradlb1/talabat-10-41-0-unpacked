package com.deliveryhero.customerchat.fwf;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.fwf.FeatureFlagProvider", f = "FeatureFlagProvider.kt", i = {}, l = {212}, m = "fetchUserFeatureFlags", n = {}, s = {})
public final class FeatureFlagProvider$fetchUserFeatureFlags$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f29998h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FeatureFlagProvider f29999i;

    /* renamed from: j  reason: collision with root package name */
    public int f30000j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeatureFlagProvider$fetchUserFeatureFlags$1(FeatureFlagProvider featureFlagProvider, Continuation<? super FeatureFlagProvider$fetchUserFeatureFlags$1> continuation) {
        super(continuation);
        this.f29999i = featureFlagProvider;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29998h = obj;
        this.f30000j |= Integer.MIN_VALUE;
        return this.f29999i.fetchUserFeatureFlags((String) null, (Custom) null, this);
    }
}
