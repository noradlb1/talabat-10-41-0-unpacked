package com.talabat.configuration;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.configuration.RealConfigurationRemoteRepository", f = "RealConfigurationRemoteRepository.kt", i = {0}, l = {26}, m = "appRemoteConfig", n = {"this"}, s = {"L$0"})
public final class RealConfigurationRemoteRepository$appRemoteConfig$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55761h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55762i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RealConfigurationRemoteRepository f55763j;

    /* renamed from: k  reason: collision with root package name */
    public int f55764k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealConfigurationRemoteRepository$appRemoteConfig$1(RealConfigurationRemoteRepository realConfigurationRemoteRepository, Continuation<? super RealConfigurationRemoteRepository$appRemoteConfig$1> continuation) {
        super(continuation);
        this.f55763j = realConfigurationRemoteRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55762i = obj;
        this.f55764k |= Integer.MIN_VALUE;
        return this.f55763j.appRemoteConfig(0, this);
    }
}
