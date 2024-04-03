package library.talabat.mvp.placeorder;

import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.ApiStatus;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Llibrary/talabat/mvp/placeorder/PlaceOrderFailureTracker;", "Lio/reactivex/functions/Consumer;", "Llibrary/talabat/mvp/placeorder/PlaceOrderFailure;", "()V", "accept", "", "failure", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlaceOrderFailureTracker implements Consumer<PlaceOrderFailure> {
    public void accept(@NotNull PlaceOrderFailure placeOrderFailure) {
        Intrinsics.checkNotNullParameter(placeOrderFailure, "failure");
        ObservabilityManager.trackEvent("Place Order", ApiStatus.FAILURE, (Map<String, String>) PlaceOrderFailureTrackerKt.attributes(placeOrderFailure));
    }
}
