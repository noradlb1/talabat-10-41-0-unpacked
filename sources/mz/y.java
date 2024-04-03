package mz;

import com.uxcam.datamodel.UXCamOcclusion;
import com.uxcam.datamodel.UXCamOverlay;
import com.uxcam.internals.ee;
import com.uxcam.internals.gn;
import java.util.Collections;

public final /* synthetic */ class y implements gn.ab {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f24000a;

    public /* synthetic */ y(boolean z11) {
        this.f24000a = z11;
    }

    public final void a(String str) {
        ee.a((UXCamOcclusion) new UXCamOverlay.Builder().screens(Collections.singletonList(str)).withoutGesture(!this.f24000a).excludeMentionedScreens(true).build());
    }
}
