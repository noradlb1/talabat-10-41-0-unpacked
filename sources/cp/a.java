package cp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment;
import java.util.List;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationReasonBottomSheetFragment f61791a;

    public /* synthetic */ a(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment) {
        this.f61791a = subscriptionCancellationReasonBottomSheetFragment;
    }

    public final void onChanged(Object obj) {
        this.f61791a.populate((List) obj);
    }
}
