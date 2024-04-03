package bo;

import androidx.lifecycle.Observer;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RewardsMissionView f58161a;

    public /* synthetic */ f(RewardsMissionView rewardsMissionView) {
        this.f58161a = rewardsMissionView;
    }

    public final void onChanged(Object obj) {
        this.f58161a.setupLoadingIndicatorClaimReward(((Boolean) obj).booleanValue());
    }
}
