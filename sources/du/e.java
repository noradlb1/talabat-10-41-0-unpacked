package du;

import com.talabat.sdsquad.data.vendorslist.response.VendorsInfoResponse;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsInfoUseCase;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetVendorsInfoUseCase f61961b;

    public /* synthetic */ e(GetVendorsInfoUseCase getVendorsInfoUseCase) {
        this.f61961b = getVendorsInfoUseCase;
    }

    public final Object apply(Object obj) {
        return GetVendorsInfoUseCase.m10793executeUseCase$lambda1$lambda0(this.f61961b, (VendorsInfoResponse) obj);
    }
}
