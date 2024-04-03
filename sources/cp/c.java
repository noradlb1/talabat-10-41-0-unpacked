package cp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationReasonBottomSheetFragment f61793a;

    public /* synthetic */ c(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment) {
        this.f61793a = subscriptionCancellationReasonBottomSheetFragment;
    }

    public final void onChanged(Object obj) {
        this.f61793a.showOtherInput(((Boolean) obj).booleanValue());
    }
}
