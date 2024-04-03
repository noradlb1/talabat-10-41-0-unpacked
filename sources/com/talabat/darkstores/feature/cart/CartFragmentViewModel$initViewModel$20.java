package com.talabat.darkstores.feature.cart;

import com.talabat.feature.darkstorescart.data.model.CheckoutParams;
import com.talabat.wrapper.EventWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/feature/darkstorescart/data/model/CheckoutParams;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModel$initViewModel$20 extends Lambda implements Function1<CheckoutParams, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f56266g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragmentViewModel$initViewModel$20(CartFragmentViewModel cartFragmentViewModel) {
        super(1);
        this.f56266g = cartFragmentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CheckoutParams) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CheckoutParams checkoutParams) {
        Intrinsics.checkNotNullParameter(checkoutParams, "it");
        this.f56266g._checkoutActionLiveData.postValue(new EventWrapper(checkoutParams));
    }
}
