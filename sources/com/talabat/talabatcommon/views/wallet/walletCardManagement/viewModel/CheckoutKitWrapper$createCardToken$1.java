package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutKitWrapper", f = "CheckoutKitWrapper.kt", i = {}, l = {13}, m = "createCardToken", n = {}, s = {})
public final class CheckoutKitWrapper$createCardToken$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11959h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CheckoutKitWrapper f11960i;

    /* renamed from: j  reason: collision with root package name */
    public int f11961j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckoutKitWrapper$createCardToken$1(CheckoutKitWrapper checkoutKitWrapper, Continuation<? super CheckoutKitWrapper$createCardToken$1> continuation) {
        super(continuation);
        this.f11960i = checkoutKitWrapper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f11959h = obj;
        this.f11961j |= Integer.MIN_VALUE;
        return this.f11960i.createCardToken((CheckoutCard) null, (Integer) null, this);
    }
}
