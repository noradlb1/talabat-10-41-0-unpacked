package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class g3 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35217b;

    public /* synthetic */ g3(SimpleBasePlayer.State state) {
        this.f35217b = state;
    }

    public final Object get() {
        return this.f35217b.buildUpon().setDeviceVolume(Math.max(0, this.f35217b.deviceVolume - 1)).build();
    }
}
