package il;

import com.talabat.feature.address.data.CustomerAddressesRepositoryImpl;
import com.talabat.feature.address.data.remote.dto.UpdateAddressDto;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepositoryImpl f62152b;

    public /* synthetic */ d(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl) {
        this.f62152b = customerAddressesRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return CustomerAddressesRepositoryImpl.m10135updateAddress$lambda7(this.f62152b, (UpdateAddressDto) obj);
    }
}
