package library.talabat.mvp.currentlocationfetch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Llibrary/talabat/mvp/currentlocationfetch/CurrentLocationPresenter;", "Llibrary/talabat/mvp/currentlocationfetch/ICurrentLocationPresenter;", "mView", "Llibrary/talabat/mvp/currentlocationfetch/ICurrentLocationView;", "(Llibrary/talabat/mvp/currentlocationfetch/ICurrentLocationView;)V", "fetchCurrentLocatioRequest", "", "skipLoctionRequest", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrentLocationPresenter implements ICurrentLocationPresenter {
    @NotNull
    private final ICurrentLocationView mView;

    public CurrentLocationPresenter(@NotNull ICurrentLocationView iCurrentLocationView) {
        Intrinsics.checkNotNullParameter(iCurrentLocationView, "mView");
        this.mView = iCurrentLocationView;
    }

    public void fetchCurrentLocatioRequest() {
        this.mView.fetchCurrentLocation();
    }

    public void skipLoctionRequest() {
        this.mView.skipLocationRequest();
    }
}
