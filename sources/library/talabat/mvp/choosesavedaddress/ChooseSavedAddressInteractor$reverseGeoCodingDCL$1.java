package library.talabat.mvp.choosesavedaddress;

import JsonModels.GeoAddressRequest;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"library/talabat/mvp/choosesavedaddress/ChooseSavedAddressInteractor$reverseGeoCodingDCL$1", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/GeoAddressRequest;", "onComplete", "", "onError", "e", "", "onNext", "geoAddressRequest", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChooseSavedAddressInteractor$reverseGeoCodingDCL$1 extends DisposableObserver<GeoAddressRequest> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressInteractor f26704b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f26705c;

    public ChooseSavedAddressInteractor$reverseGeoCodingDCL$1(ChooseSavedAddressInteractor chooseSavedAddressInteractor, boolean z11) {
        this.f26704b = chooseSavedAddressInteractor;
        this.f26705c = z11;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        ChooseSavedAddressListener access$getChooseSavedAddressListener$p;
        Intrinsics.checkNotNullParameter(th2, "e");
        if (!TalabatUtils.isNullOrEmpty(th2.getLocalizedMessage()) && (access$getChooseSavedAddressListener$p = this.f26704b.ChooseSavedAddressListener) != null) {
            access$getChooseSavedAddressListener$p.updateApiError(th2.getLocalizedMessage());
        }
        ChooseSavedAddressListener access$getChooseSavedAddressListener$p2 = this.f26704b.ChooseSavedAddressListener;
        if (access$getChooseSavedAddressListener$p2 != null) {
            access$getChooseSavedAddressListener$p2.resBasereverseGeocodingError(true);
        }
    }

    public void onNext(@NotNull GeoAddressRequest geoAddressRequest) {
        Intrinsics.checkNotNullParameter(geoAddressRequest, "geoAddressRequest");
        if (this.f26704b.ChooseSavedAddressListener != null) {
            Address address = geoAddressRequest.result;
            if (address == null) {
                ChooseSavedAddressListener access$getChooseSavedAddressListener$p = this.f26704b.ChooseSavedAddressListener;
                if (access$getChooseSavedAddressListener$p != null) {
                    access$getChooseSavedAddressListener$p.resBasereverseGeocodingError(true);
                }
            } else if (address.countyId == GlobalDataModel.SelectedCountryId) {
                ChooseSavedAddressListener access$getChooseSavedAddressListener$p2 = this.f26704b.ChooseSavedAddressListener;
                if (access$getChooseSavedAddressListener$p2 != null) {
                    access$getChooseSavedAddressListener$p2.reverseGeocodingResult(geoAddressRequest.result, this.f26705c);
                }
            } else {
                ChooseSavedAddressListener access$getChooseSavedAddressListener$p3 = this.f26704b.ChooseSavedAddressListener;
                if (access$getChooseSavedAddressListener$p3 != null) {
                    access$getChooseSavedAddressListener$p3.outSideCountry(geoAddressRequest.result.countyId);
                }
            }
        }
    }
}
