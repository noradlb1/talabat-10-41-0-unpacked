package bn;

import androidx.lifecycle.Observer;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionView;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LifeStyleMissionView f58144a;

    public /* synthetic */ b(LifeStyleMissionView lifeStyleMissionView) {
        this.f58144a = lifeStyleMissionView;
    }

    public final void onChanged(Object obj) {
        LifeStyleMissionView.m10222onAttachedToWindow$lambda1$lambda0(this.f58144a, (LifeStyleMissionControl) obj);
    }
}
