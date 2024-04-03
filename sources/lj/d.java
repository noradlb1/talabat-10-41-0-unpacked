package lj;

import com.talabat.darkstores.feature.product.views.AddToCartButtonViewModel;
import com.talabat.darkstores.feature.product.views.CartButtonEvent;
import com.talabat.darkstores.feature.product.views.CartButtonState;
import io.reactivex.functions.BiFunction;

public final /* synthetic */ class d implements BiFunction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddToCartButtonViewModel f57012b;

    public /* synthetic */ d(AddToCartButtonViewModel addToCartButtonViewModel) {
        this.f57012b = addToCartButtonViewModel;
    }

    public final Object apply(Object obj, Object obj2) {
        return AddToCartButtonViewModel.m10051stateObservable$lambda0(this.f57012b, (CartButtonState) obj, (CartButtonEvent) obj2);
    }
}
