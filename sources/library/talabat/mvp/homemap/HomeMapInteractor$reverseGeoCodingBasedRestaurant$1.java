package library.talabat.mvp.homemap;

import JsonModels.RestGeoAddressRM;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"library/talabat/mvp/homemap/HomeMapInteractor$reverseGeoCodingBasedRestaurant$1", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/RestGeoAddressRM;", "onComplete", "", "onError", "e", "", "onNext", "response", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapInteractor$reverseGeoCodingBasedRestaurant$1 extends DisposableObserver<RestGeoAddressRM> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapInteractor f26733b;

    public HomeMapInteractor$reverseGeoCodingBasedRestaurant$1(HomeMapInteractor homeMapInteractor) {
        this.f26733b = homeMapInteractor;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        HomeMapListener access$getHomeMapListener$p = this.f26733b.homeMapListener;
        if (access$getHomeMapListener$p != null) {
            access$getHomeMapListener$p.resBasereverseGeocodingError();
        }
    }

    public void onNext(@NotNull RestGeoAddressRM restGeoAddressRM) {
        Intrinsics.checkNotNullParameter(restGeoAddressRM, "response");
        HomeMapListener access$getHomeMapListener$p = this.f26733b.homeMapListener;
        if (access$getHomeMapListener$p != null) {
            access$getHomeMapListener$p.resBasereverseGeocodingResult(restGeoAddressRM.result);
        }
    }
}
