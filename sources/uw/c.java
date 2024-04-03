package uw;

import com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl;
import com.talabat.user.address.data.remote.dto.AddAddressDto;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepositoryImpl f24136b;

    public /* synthetic */ c(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl) {
        this.f24136b = customerAddressesRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return CustomerAddressesRepositoryImpl.m5871addAddress$lambda4(this.f24136b, (AddAddressDto) obj);
    }
}
