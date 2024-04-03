package bo;

import androidx.lifecycle.Observer;
import com.talabat.feature.rewards.domain.model.MissionDetails;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RewardsMissionView f58162a;

    public /* synthetic */ g(RewardsMissionView rewardsMissionView) {
        this.f58162a = rewardsMissionView;
    }

    public final void onChanged(Object obj) {
        this.f58162a.showMissionDetails((MissionDetails) obj);
    }
}
