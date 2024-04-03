package bn;

import android.view.View;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControlData;
import com.talabat.feature.mission.control.presentation.OneLifeStyleMissionItem;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OneLifeStyleMissionItem f58145b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LifeStyleMissionControlData f58146c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58147d;

    public /* synthetic */ c(OneLifeStyleMissionItem oneLifeStyleMissionItem, LifeStyleMissionControlData lifeStyleMissionControlData, int i11) {
        this.f58145b = oneLifeStyleMissionItem;
        this.f58146c = lifeStyleMissionControlData;
        this.f58147d = i11;
    }

    public final void onClick(View view) {
        OneLifeStyleMissionItem.m10223setContent$lambda1(this.f58145b, this.f58146c, this.f58147d, view);
    }
}
