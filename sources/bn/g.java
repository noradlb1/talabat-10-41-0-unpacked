package bn;

import android.view.View;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControlData;
import com.talabat.feature.mission.control.presentation.TwoPrimaryMissionItem;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TwoPrimaryMissionItem f58155b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PrimaryMissionControlData f58156c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58157d;

    public /* synthetic */ g(TwoPrimaryMissionItem twoPrimaryMissionItem, PrimaryMissionControlData primaryMissionControlData, int i11) {
        this.f58155b = twoPrimaryMissionItem;
        this.f58156c = primaryMissionControlData;
        this.f58157d = i11;
    }

    public final void onClick(View view) {
        TwoPrimaryMissionItem.m10227setContent$lambda1(this.f58155b, this.f58156c, this.f58157d, view);
    }
}
