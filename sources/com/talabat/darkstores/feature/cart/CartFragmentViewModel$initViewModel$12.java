package com.talabat.darkstores.feature.cart;

import androidx.lifecycle.MutableLiveData;
import com.talabat.darkstores.common.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/darkstores/feature/cart/CartFragmentData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModel$initViewModel$12 extends Lambda implements Function1<CartFragmentData, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f56261g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragmentViewModel$initViewModel$12(CartFragmentViewModel cartFragmentViewModel) {
        super(1);
        this.f56261g = cartFragmentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CartFragmentData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CartFragmentData cartFragmentData) {
        MutableLiveData access$get_cartFragmentLiveData$p = this.f56261g._cartFragmentLiveData;
        Intrinsics.checkNotNullExpressionValue(cartFragmentData, "it");
        access$get_cartFragmentLiveData$p.postValue(new Result.Success(cartFragmentData));
    }
}
