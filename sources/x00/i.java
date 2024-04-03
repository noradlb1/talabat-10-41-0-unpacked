package x00;

import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28226b;

    public /* synthetic */ i(AddressInteractor addressInteractor) {
        this.f28226b = addressInteractor;
    }

    public final void accept(Object obj) {
        this.f28226b.onAddAddressResult((CustomerAddressesRepository.Result) obj);
    }
}
