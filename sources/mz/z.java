package mz;

import com.uxcam.datamodel.UXCamOcclusion;
import com.uxcam.datamodel.UXCamOverlay;
import com.uxcam.internals.ee;
import com.uxcam.internals.gn;
import java.util.Collections;

public final /* synthetic */ class z implements gn.ab {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f24001a;

    public /* synthetic */ z(boolean z11) {
        this.f24001a = z11;
    }

    public final void a(String str) {
        ee.a((UXCamOcclusion) new UXCamOverlay.Builder().screens(Collections.singletonList(str)).withoutGesture(!this.f24001a).build());
    }
}
