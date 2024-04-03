package bo;

import androidx.lifecycle.Observer;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;
import com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RewardsMissionView f58158a;

    public /* synthetic */ c(RewardsMissionView rewardsMissionView) {
        this.f58158a = rewardsMissionView;
    }

    public final void onChanged(Object obj) {
        this.f58158a.setupMissionState((MissionViewModel.MissionState) obj);
    }
}
