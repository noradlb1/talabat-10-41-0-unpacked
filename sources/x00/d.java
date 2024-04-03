package x00;

import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28221b;

    public /* synthetic */ d(AddressInteractor addressInteractor) {
        this.f28221b = addressInteractor;
    }

    public final void accept(Object obj) {
        this.f28221b.onUpdateAddressResult((CustomerAddressesRepository.Result) obj);
    }
}
