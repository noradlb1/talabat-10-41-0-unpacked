package j10;

import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.homemap.HomeMapInteractor;

public final /* synthetic */ class g implements Consumer {
    public final void accept(Object obj) {
        HomeMapInteractor.m7893updateAddress$lambda6((CustomerAddressesRepository.Result) obj);
    }
}
