package vw;

import com.talabat.user.address.data.remote.AddressDtoMapper;
import com.talabat.user.address.data.remote.api.AddAddressResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressDtoMapper f24150b;

    public /* synthetic */ c(AddressDtoMapper addressDtoMapper) {
        this.f24150b = addressDtoMapper;
    }

    public final Object apply(Object obj) {
        return this.f24150b.mapToAddAddressDto((AddAddressResponse) obj);
    }
}
