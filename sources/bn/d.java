package bn;

import android.view.View;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.mission.control.presentation.OneLifeStyleMissionItem;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OneLifeStyleMissionItem f58148b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LifestyleMissionItem f58149c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58150d;

    public /* synthetic */ d(OneLifeStyleMissionItem oneLifeStyleMissionItem, LifestyleMissionItem lifestyleMissionItem, int i11) {
        this.f58148b = oneLifeStyleMissionItem;
        this.f58149c = lifestyleMissionItem;
        this.f58150d = i11;
    }

    public final void onClick(View view) {
        OneLifeStyleMissionItem.m10224setContent$lambda3(this.f58148b, this.f58149c, this.f58150d, view);
    }
}
