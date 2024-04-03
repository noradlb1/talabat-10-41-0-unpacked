package il;

import com.talabat.feature.address.data.CustomerAddressesRepositoryImpl;
import com.talabat.feature.address.data.remote.dto.AddAddressDto;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepositoryImpl f62151b;

    public /* synthetic */ b(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl) {
        this.f62151b = customerAddressesRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return CustomerAddressesRepositoryImpl.m10132addAddress$lambda4(this.f62151b, (AddAddressDto) obj);
    }
}
