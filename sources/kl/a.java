package kl;

import com.talabat.feature.address.data.remote.AddressDtoMapper;
import com.talabat.feature.address.data.remote.api.UpdateAddressResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressDtoMapper f62215b;

    public /* synthetic */ a(AddressDtoMapper addressDtoMapper) {
        this.f62215b = addressDtoMapper;
    }

    public final Object apply(Object obj) {
        return this.f62215b.mapToUpdateAddressDto((UpdateAddressResponse) obj);
    }
}
