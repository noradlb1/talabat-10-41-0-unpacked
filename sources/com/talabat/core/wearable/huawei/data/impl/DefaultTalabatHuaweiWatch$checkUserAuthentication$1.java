package com.talabat.core.wearable.huawei.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch", f = "DefaultTalabatHuaweiWatch.kt", i = {0}, l = {21, 22}, m = "checkUserAuthentication", n = {"this"}, s = {"L$0"})
public final class DefaultTalabatHuaweiWatch$checkUserAuthentication$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f56025h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f56026i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DefaultTalabatHuaweiWatch f56027j;

    /* renamed from: k  reason: collision with root package name */
    public int f56028k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTalabatHuaweiWatch$checkUserAuthentication$1(DefaultTalabatHuaweiWatch defaultTalabatHuaweiWatch, Continuation<? super DefaultTalabatHuaweiWatch$checkUserAuthentication$1> continuation) {
        super(continuation);
        this.f56027j = defaultTalabatHuaweiWatch;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f56026i = obj;
        this.f56028k |= Integer.MIN_VALUE;
        return this.f56027j.checkUserAuthentication(this);
    }
}
