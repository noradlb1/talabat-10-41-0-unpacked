package com.talabat.wallet.qPayManager.data.impl;

import com.talabat.wallet.qPayManager.data.remote.dto.QPayRedirectUrlRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.qPayManager.data.impl.QPayManagerRepositoryImpl", f = "QPayManagerRepositoryImpl.kt", i = {}, l = {23}, m = "getQPayRedirectUrl", n = {}, s = {})
public final class QPayManagerRepositoryImpl$getQPayRedirectUrl$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12652h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12653i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ QPayManagerRepositoryImpl f12654j;

    /* renamed from: k  reason: collision with root package name */
    public int f12655k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QPayManagerRepositoryImpl$getQPayRedirectUrl$1(QPayManagerRepositoryImpl qPayManagerRepositoryImpl, Continuation<? super QPayManagerRepositoryImpl$getQPayRedirectUrl$1> continuation) {
        super(continuation);
        this.f12654j = qPayManagerRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12653i = obj;
        this.f12655k |= Integer.MIN_VALUE;
        return this.f12654j.getQPayRedirectUrl((String) null, (QPayRedirectUrlRequest) null, this);
    }
}
