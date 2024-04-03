package com.talabat.userandlocation.compliance.status.domain.usecase.business.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl", f = "CheckUserIsAllowedToOrderUseCaseImpl.kt", i = {}, l = {107}, m = "getStatusOfUser", n = {}, s = {})
public final class CheckUserIsAllowedToOrderUseCaseImpl$getStatusOfUser$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f12283h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CheckUserIsAllowedToOrderUseCaseImpl f12284i;

    /* renamed from: j  reason: collision with root package name */
    public int f12285j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckUserIsAllowedToOrderUseCaseImpl$getStatusOfUser$1(CheckUserIsAllowedToOrderUseCaseImpl checkUserIsAllowedToOrderUseCaseImpl, Continuation<? super CheckUserIsAllowedToOrderUseCaseImpl$getStatusOfUser$1> continuation) {
        super(continuation);
        this.f12284i = checkUserIsAllowedToOrderUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12283h = obj;
        this.f12285j |= Integer.MIN_VALUE;
        return this.f12284i.getStatusOfUser((String) null, (String) null, (String) null, false, this);
    }
}
