package com.talabat.userandlocation.login.domain.usecase.business.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl", f = "VerifyLoginPasswordUseCaseImpl.kt", i = {}, l = {49}, m = "tryAuthenticateWithPassword", n = {}, s = {})
public final class VerifyLoginPasswordUseCaseImpl$tryAuthenticateWithPassword$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f12375h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VerifyLoginPasswordUseCaseImpl f12376i;

    /* renamed from: j  reason: collision with root package name */
    public int f12377j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerifyLoginPasswordUseCaseImpl$tryAuthenticateWithPassword$1(VerifyLoginPasswordUseCaseImpl verifyLoginPasswordUseCaseImpl, Continuation<? super VerifyLoginPasswordUseCaseImpl$tryAuthenticateWithPassword$1> continuation) {
        super(continuation);
        this.f12376i = verifyLoginPasswordUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12375h = obj;
        this.f12377j |= Integer.MIN_VALUE;
        return this.f12376i.tryAuthenticateWithPassword((String) null, (String) null, this);
    }
}
