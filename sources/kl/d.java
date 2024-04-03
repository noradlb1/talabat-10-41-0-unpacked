package kl;

import com.talabat.feature.address.data.remote.AddressDtoMapper;
import com.talabat.feature.address.data.remote.api.AddAddressResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressDtoMapper f62216b;

    public /* synthetic */ d(AddressDtoMapper addressDtoMapper) {
        this.f62216b = addressDtoMapper;
    }

    public final Object apply(Object obj) {
        return this.f62216b.mapToAddAddressDto((AddAddressResponse) obj);
    }
}
