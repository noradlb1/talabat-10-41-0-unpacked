package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Function;
import retrofit2.HttpException;

public final /* synthetic */ class e0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57300b;

    public /* synthetic */ e0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57300b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9817initViewModel$lambda33(this.f57300b, (HttpException) obj);
    }
}
