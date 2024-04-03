package bn;

import androidx.lifecycle.Observer;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControl;
import com.talabat.feature.mission.control.presentation.PrimaryMissionView;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimaryMissionView f58151a;

    public /* synthetic */ e(PrimaryMissionView primaryMissionView) {
        this.f58151a = primaryMissionView;
    }

    public final void onChanged(Object obj) {
        PrimaryMissionView.m10225onAttachedToWindow$lambda1$lambda0(this.f58151a, (PrimaryMissionControl) obj);
    }
}
