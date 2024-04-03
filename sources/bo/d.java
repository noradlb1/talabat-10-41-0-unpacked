package bo;

import androidx.lifecycle.Observer;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RewardsMissionView f58159a;

    public /* synthetic */ d(RewardsMissionView rewardsMissionView) {
        this.f58159a = rewardsMissionView;
    }

    public final void onChanged(Object obj) {
        this.f58159a.setupHasMission((Mission) obj);
    }
}
