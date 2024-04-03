package bo;

import androidx.lifecycle.Observer;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RewardsMissionView f58160a;

    public /* synthetic */ e(RewardsMissionView rewardsMissionView) {
        this.f58160a = rewardsMissionView;
    }

    public final void onChanged(Object obj) {
        this.f58160a.setupLoadingIndicatorAcceptMission(((Boolean) obj).booleanValue());
    }
}
