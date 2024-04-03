package com.deliveryhero.customerchat.fwf;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.fwf.FeatureFlagProvider", f = "FeatureFlagProvider.kt", i = {0}, l = {161}, m = "getPhoneCallingType", n = {"this"}, s = {"L$0"})
public final class FeatureFlagProvider$getPhoneCallingType$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f30001h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f30002i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FeatureFlagProvider f30003j;

    /* renamed from: k  reason: collision with root package name */
    public int f30004k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeatureFlagProvider$getPhoneCallingType$1(FeatureFlagProvider featureFlagProvider, Continuation<? super FeatureFlagProvider$getPhoneCallingType$1> continuation) {
        super(continuation);
        this.f30003j = featureFlagProvider;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f30002i = obj;
        this.f30004k |= Integer.MIN_VALUE;
        return this.f30003j.getPhoneCallingType(this);
    }
}
