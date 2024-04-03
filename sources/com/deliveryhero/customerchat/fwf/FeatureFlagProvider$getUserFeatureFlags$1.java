package com.deliveryhero.customerchat.fwf;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.fwf.FeatureFlagProvider", f = "FeatureFlagProvider.kt", i = {}, l = {180}, m = "getUserFeatureFlags", n = {}, s = {})
public final class FeatureFlagProvider$getUserFeatureFlags$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f30005h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FeatureFlagProvider f30006i;

    /* renamed from: j  reason: collision with root package name */
    public int f30007j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeatureFlagProvider$getUserFeatureFlags$1(FeatureFlagProvider featureFlagProvider, Continuation<? super FeatureFlagProvider$getUserFeatureFlags$1> continuation) {
        super(continuation);
        this.f30006i = featureFlagProvider;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f30005h = obj;
        this.f30007j |= Integer.MIN_VALUE;
        return this.f30006i.getUserFeatureFlags(this);
    }
}
