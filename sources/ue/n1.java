package ue;

import com.talabat.CartScreen;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.cart.CartAdapterListener;

public final /* synthetic */ class n1 implements Function1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartCustomizationViewHolder f57656b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartAdapterListener f57657c;

    public /* synthetic */ n1(CartScreen.CartCustomizationViewHolder cartCustomizationViewHolder, CartAdapterListener cartAdapterListener) {
        this.f57656b = cartCustomizationViewHolder;
        this.f57657c = cartAdapterListener;
    }

    public final Object invoke(Object obj) {
        return this.f57656b.lambda$bindFreeDeliveryView$8(this.f57657c, (TProOrderStatus) obj);
    }
}
