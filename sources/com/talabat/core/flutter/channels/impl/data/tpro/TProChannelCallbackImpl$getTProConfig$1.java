package com.talabat.core.flutter.channels.impl.data.tpro;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl", f = "TProChannelCallbackImpl.kt", i = {0}, l = {47}, m = "getTProConfig", n = {"this"}, s = {"L$0"})
public final class TProChannelCallbackImpl$getTProConfig$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55927h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55928i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TProChannelCallbackImpl f55929j;

    /* renamed from: k  reason: collision with root package name */
    public int f55930k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProChannelCallbackImpl$getTProConfig$1(TProChannelCallbackImpl tProChannelCallbackImpl, Continuation<? super TProChannelCallbackImpl$getTProConfig$1> continuation) {
        super(continuation);
        this.f55929j = tProChannelCallbackImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55928i = obj;
        this.f55930k |= Integer.MIN_VALUE;
        return this.f55929j.getTProConfig((Object) null, this);
    }
}
