package du;

import com.talabat.sdsquad.data.vendorslist.response.VendorsListResponse;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsUseCase;
import io.reactivex.functions.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetVendorsUseCase f61962b;

    public /* synthetic */ f(GetVendorsUseCase getVendorsUseCase) {
        this.f61962b = getVendorsUseCase;
    }

    public final Object apply(Object obj) {
        return GetVendorsUseCase.m10794executeUseCase$lambda2$lambda1(this.f61962b, (VendorsListResponse) obj);
    }
}
