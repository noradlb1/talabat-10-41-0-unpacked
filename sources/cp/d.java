package cp;

import android.view.View;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationReasonBottomSheetFragment f61794b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f61795c;

    public /* synthetic */ d(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment, int i11) {
        this.f61794b = subscriptionCancellationReasonBottomSheetFragment;
        this.f61795c = i11;
    }

    public final void onClick(View view) {
        SubscriptionCancellationReasonBottomSheetFragment.m10395addCancellationReasonItemView$lambda4$lambda3(this.f61794b, this.f61795c, view);
    }
}
