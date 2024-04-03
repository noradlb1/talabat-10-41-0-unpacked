package com.deliveryhero.customerchat.fwf;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.fwf.FeatureFlagProvider", f = "FeatureFlagProvider.kt", i = {}, l = {191}, m = "fetchChannelFeatureFlags", n = {}, s = {})
public final class FeatureFlagProvider$fetchChannelFeatureFlags$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f29995h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FeatureFlagProvider f29996i;

    /* renamed from: j  reason: collision with root package name */
    public int f29997j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeatureFlagProvider$fetchChannelFeatureFlags$1(FeatureFlagProvider featureFlagProvider, Continuation<? super FeatureFlagProvider$fetchChannelFeatureFlags$1> continuation) {
        super(continuation);
        this.f29996i = featureFlagProvider;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29995h = obj;
        this.f29997j |= Integer.MIN_VALUE;
        return this.f29996i.fetchChannelFeatureFlags((String) null, (Custom) null, this);
    }
}
