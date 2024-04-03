package bn;

import android.view.View;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControlData;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionItemView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LifeStyleMissionItemView f58141b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LifeStyleMissionControlData f58142c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58143d;

    public /* synthetic */ a(LifeStyleMissionItemView lifeStyleMissionItemView, LifeStyleMissionControlData lifeStyleMissionControlData, int i11) {
        this.f58141b = lifeStyleMissionItemView;
        this.f58142c = lifeStyleMissionControlData;
        this.f58143d = i11;
    }

    public final void onClick(View view) {
        LifeStyleMissionItemView.m10221setContent$lambda1(this.f58141b, this.f58142c, this.f58143d, view);
    }
}
