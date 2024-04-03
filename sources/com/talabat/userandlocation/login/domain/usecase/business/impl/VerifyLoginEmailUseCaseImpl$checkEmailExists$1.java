package com.talabat.userandlocation.login.domain.usecase.business.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl", f = "VerifyLoginEmailUseCaseImpl.kt", i = {0, 0, 1}, l = {48, 49}, m = "checkEmailExists", n = {"this", "email", "this"}, s = {"L$0", "L$1", "L$0"})
public final class VerifyLoginEmailUseCaseImpl$checkEmailExists$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12362h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12363i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f12364j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VerifyLoginEmailUseCaseImpl f12365k;

    /* renamed from: l  reason: collision with root package name */
    public int f12366l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerifyLoginEmailUseCaseImpl$checkEmailExists$1(VerifyLoginEmailUseCaseImpl verifyLoginEmailUseCaseImpl, Continuation<? super VerifyLoginEmailUseCaseImpl$checkEmailExists$1> continuation) {
        super(continuation);
        this.f12365k = verifyLoginEmailUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12364j = obj;
        this.f12366l |= Integer.MIN_VALUE;
        return this.f12365k.checkEmailExists((String) null, this);
    }
}
