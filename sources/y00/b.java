package y00;

import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.addresslist.AddressListInteractor;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressListInteractor f28234b;

    public /* synthetic */ b(AddressListInteractor addressListInteractor) {
        this.f28234b = addressListInteractor;
    }

    public final void accept(Object obj) {
        this.f28234b.d((CustomerAddressesRepository.Result) obj);
    }
}
