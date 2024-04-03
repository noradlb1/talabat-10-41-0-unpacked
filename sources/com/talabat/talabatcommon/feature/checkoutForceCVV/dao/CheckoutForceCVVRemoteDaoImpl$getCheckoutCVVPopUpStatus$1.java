package com.talabat.talabatcommon.feature.checkoutForceCVV.dao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.checkoutForceCVV.dao.CheckoutForceCVVRemoteDaoImpl", f = "CheckoutForceCVVRemoteDaoImpl.kt", i = {}, l = {12}, m = "getCheckoutCVVPopUpStatus", n = {}, s = {})
public final class CheckoutForceCVVRemoteDaoImpl$getCheckoutCVVPopUpStatus$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61544h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CheckoutForceCVVRemoteDaoImpl f61545i;

    /* renamed from: j  reason: collision with root package name */
    public int f61546j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckoutForceCVVRemoteDaoImpl$getCheckoutCVVPopUpStatus$1(CheckoutForceCVVRemoteDaoImpl checkoutForceCVVRemoteDaoImpl, Continuation<? super CheckoutForceCVVRemoteDaoImpl$getCheckoutCVVPopUpStatus$1> continuation) {
        super(continuation);
        this.f61545i = checkoutForceCVVRemoteDaoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61544h = obj;
        this.f61546j |= Integer.MIN_VALUE;
        return this.f61545i.getCheckoutCVVPopUpStatus((String) null, 0.0f, this);
    }
}
