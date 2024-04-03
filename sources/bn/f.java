package bn;

import android.view.View;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControlData;
import com.talabat.feature.mission.control.presentation.ThreePrimaryMissionItem;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ThreePrimaryMissionItem f58152b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PrimaryMissionControlData f58153c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58154d;

    public /* synthetic */ f(ThreePrimaryMissionItem threePrimaryMissionItem, PrimaryMissionControlData primaryMissionControlData, int i11) {
        this.f58152b = threePrimaryMissionItem;
        this.f58153c = primaryMissionControlData;
        this.f58154d = i11;
    }

    public final void onClick(View view) {
        ThreePrimaryMissionItem.m10226setContent$lambda1(this.f58152b, this.f58153c, this.f58154d, view);
    }
}
