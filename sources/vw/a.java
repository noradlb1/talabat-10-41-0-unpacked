package vw;

import com.talabat.user.address.data.remote.AddressDtoMapper;
import com.talabat.user.address.data.remote.api.UpdateAddressResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressDtoMapper f24149b;

    public /* synthetic */ a(AddressDtoMapper addressDtoMapper) {
        this.f24149b = addressDtoMapper;
    }

    public final Object apply(Object obj) {
        return this.f24149b.mapToUpdateAddressDto((UpdateAddressResponse) obj);
    }
}
