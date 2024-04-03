package uw;

import com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl;
import com.talabat.user.address.data.remote.dto.UpdateAddressDto;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepositoryImpl f24135b;

    public /* synthetic */ a(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl) {
        this.f24135b = customerAddressesRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return CustomerAddressesRepositoryImpl.m5874updateAddress$lambda7(this.f24135b, (UpdateAddressDto) obj);
    }
}
