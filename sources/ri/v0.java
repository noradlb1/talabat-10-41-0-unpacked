package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.feature.darkstorescart.data.model.CartVendor;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class v0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57360b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57361c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel.AddToCartData f57362d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Function0 f57363e;

    public /* synthetic */ v0(CartFragmentViewModel cartFragmentViewModel, int i11, CartFragmentViewModel.AddToCartData addToCartData, Function0 function0) {
        this.f57360b = cartFragmentViewModel;
        this.f57361c = i11;
        this.f57362d = addToCartData;
        this.f57363e = function0;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9784attachClearCartDataIfNeeded$lambda41(this.f57360b, this.f57361c, this.f57362d, this.f57363e, (CartVendor) obj);
    }
}
