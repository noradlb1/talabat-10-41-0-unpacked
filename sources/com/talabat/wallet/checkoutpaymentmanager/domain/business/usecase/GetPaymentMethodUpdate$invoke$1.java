package com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase;

import buisnessmodels.Cart;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate", f = "GetPaymentMethodUpdate.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5}, l = {40, 43, 46, 47, 51, 68}, m = "invoke", n = {"this", "cart", "defaultPaymentMethod", "bins", "isDebitCardAccepted", "isHideBNPLPaymentMethod", "this", "cart", "defaultPaymentMethod", "isHideBNPLPaymentMethod", "this", "cart", "defaultPaymentMethod", "isDebitCardAccepted", "isHideBNPLPaymentMethod", "this", "cart", "defaultPaymentMethod", "isDebitCardAccepted", "isHideBNPLPaymentMethod", "isQPayServiceDown", "this", "cart", "defaultPaymentMethod", "isHideBNPLPaymentMethod", "isQPayServiceDown", "this", "cart", "defaultPaymentMethod", "isHideBNPLPaymentMethod"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "Z$1", "L$0", "L$1", "L$2", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "Z$0", "Z$1", "L$0", "L$1", "L$2", "Z$0"})
public final class GetPaymentMethodUpdate$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12541h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12542i;

    /* renamed from: j  reason: collision with root package name */
    public Object f12543j;

    /* renamed from: k  reason: collision with root package name */
    public Object f12544k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f12545l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f12546m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f12547n;

    /* renamed from: o  reason: collision with root package name */
    public /* synthetic */ Object f12548o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ GetPaymentMethodUpdate f12549p;

    /* renamed from: q  reason: collision with root package name */
    public int f12550q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetPaymentMethodUpdate$invoke$1(GetPaymentMethodUpdate getPaymentMethodUpdate, Continuation<? super GetPaymentMethodUpdate$invoke$1> continuation) {
        super(continuation);
        this.f12549p = getPaymentMethodUpdate;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12548o = obj;
        this.f12550q |= Integer.MIN_VALUE;
        return this.f12549p.invoke(false, (Cart) null, (String) null, (String) null, false, this);
    }
}
