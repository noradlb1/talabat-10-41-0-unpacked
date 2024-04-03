package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;
import retrofit2.HttpException;

public final /* synthetic */ class s implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57350b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HttpException f57351c;

    public /* synthetic */ s(CartFragmentViewModel cartFragmentViewModel, HttpException httpException) {
        this.f57350b = cartFragmentViewModel;
        this.f57351c = httpException;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9818initViewModel$lambda33$lambda32(this.f57350b, this.f57351c, (Vendor) obj);
    }
}
