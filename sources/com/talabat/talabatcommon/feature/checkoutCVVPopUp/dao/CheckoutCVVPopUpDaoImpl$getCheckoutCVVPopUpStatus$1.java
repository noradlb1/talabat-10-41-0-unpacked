package com.talabat.talabatcommon.feature.checkoutCVVPopUp.dao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.checkoutCVVPopUp.dao.CheckoutCVVPopUpDaoImpl", f = "CheckoutCVVPopUpDaoImpl.kt", i = {}, l = {12}, m = "getCheckoutCVVPopUpStatus", n = {}, s = {})
public final class CheckoutCVVPopUpDaoImpl$getCheckoutCVVPopUpStatus$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61541h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CheckoutCVVPopUpDaoImpl f61542i;

    /* renamed from: j  reason: collision with root package name */
    public int f61543j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckoutCVVPopUpDaoImpl$getCheckoutCVVPopUpStatus$1(CheckoutCVVPopUpDaoImpl checkoutCVVPopUpDaoImpl, Continuation<? super CheckoutCVVPopUpDaoImpl$getCheckoutCVVPopUpStatus$1> continuation) {
        super(continuation);
        this.f61542i = checkoutCVVPopUpDaoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61541h = obj;
        this.f61543j |= Integer.MIN_VALUE;
        return this.f61542i.getCheckoutCVVPopUpStatus((String) null, 0.0f, this);
    }
}
