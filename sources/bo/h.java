package bo;

import androidx.lifecycle.Observer;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;
import kotlin.Unit;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RewardsMissionView f58163a;

    public /* synthetic */ h(RewardsMissionView rewardsMissionView) {
        this.f58163a = rewardsMissionView;
    }

    public final void onChanged(Object obj) {
        RewardsMissionView.m10286setupObservers$lambda6(this.f58163a, (Unit) obj);
    }
}
