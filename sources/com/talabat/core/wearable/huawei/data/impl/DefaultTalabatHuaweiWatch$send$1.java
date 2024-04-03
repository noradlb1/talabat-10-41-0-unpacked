package com.talabat.core.wearable.huawei.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch", f = "DefaultTalabatHuaweiWatch.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3}, l = {12, 12, 13, 14}, m = "send", n = {"this", "message", "this", "message", "this", "message", "this", "message", "bondedDevice"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"})
public final class DefaultTalabatHuaweiWatch$send$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f56029h;

    /* renamed from: i  reason: collision with root package name */
    public Object f56030i;

    /* renamed from: j  reason: collision with root package name */
    public Object f56031j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f56032k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DefaultTalabatHuaweiWatch f56033l;

    /* renamed from: m  reason: collision with root package name */
    public int f56034m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTalabatHuaweiWatch$send$1(DefaultTalabatHuaweiWatch defaultTalabatHuaweiWatch, Continuation<? super DefaultTalabatHuaweiWatch$send$1> continuation) {
        super(continuation);
        this.f56033l = defaultTalabatHuaweiWatch;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f56032k = obj;
        this.f56034m |= Integer.MIN_VALUE;
        return this.f56033l.send((String) null, this);
    }
}
