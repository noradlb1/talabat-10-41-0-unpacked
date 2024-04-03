package com.talabat.configuration.location;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.configuration.location.RealLocationConfigurationRepository", f = "RealLocationConfigurationRepository.kt", i = {0}, l = {36}, m = "areas", n = {"this"}, s = {"L$0"})
public final class RealLocationConfigurationRepository$areas$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55769h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55770i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RealLocationConfigurationRepository f55771j;

    /* renamed from: k  reason: collision with root package name */
    public int f55772k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealLocationConfigurationRepository$areas$1(RealLocationConfigurationRepository realLocationConfigurationRepository, Continuation<? super RealLocationConfigurationRepository$areas$1> continuation) {
        super(continuation);
        this.f55771j = realLocationConfigurationRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55770i = obj;
        this.f55772k |= Integer.MIN_VALUE;
        return this.f55771j.areas(0, this);
    }
}
