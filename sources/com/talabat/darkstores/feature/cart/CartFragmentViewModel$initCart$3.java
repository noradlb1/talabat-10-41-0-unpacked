package com.talabat.darkstores.feature.cart;

import androidx.lifecycle.MutableLiveData;
import com.talabat.darkstores.common.Result;
import com.talabat.talabatcommon.optional.Optional;
import com.talabat.wrapper.EventWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModel$initCart$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f56258g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragmentViewModel$initCart$3(CartFragmentViewModel cartFragmentViewModel) {
        super(0);
        this.f56258g = cartFragmentViewModel;
    }

    public final void invoke() {
        this.f56258g.isCartReady = true;
        MutableLiveData access$get_cartReadyLiveData$p = this.f56258g._cartReadyLiveData;
        Unit unit = Unit.INSTANCE;
        access$get_cartReadyLiveData$p.postValue(new Result.Success(unit));
        this.f56258g._navigationReadyLiveData.postValue(new EventWrapper(unit));
        this.f56258g.productCountChanged.onNext(Optional.None.INSTANCE);
    }
}
