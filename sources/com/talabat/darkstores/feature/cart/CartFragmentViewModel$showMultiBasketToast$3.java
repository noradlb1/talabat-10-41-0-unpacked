package com.talabat.darkstores.feature.cart;

import com.talabat.feature.darkstorescartlist.domain.model.CartListToast;
import com.talabat.wrapper.EventWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "cartListToast", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModel$showMultiBasketToast$3 extends Lambda implements Function1<CartListToast, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f56273g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragmentViewModel$showMultiBasketToast$3(CartFragmentViewModel cartFragmentViewModel) {
        super(1);
        this.f56273g = cartFragmentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CartListToast) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CartListToast cartListToast) {
        this.f56273g._cartListToastLiveData.postValue(new EventWrapper(cartListToast));
    }
}
