package cp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationReasonBottomSheetFragment f61792a;

    public /* synthetic */ b(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment) {
        this.f61792a = subscriptionCancellationReasonBottomSheetFragment;
    }

    public final void onChanged(Object obj) {
        this.f61792a.selectedReasonChanged((Integer) obj);
    }
}
