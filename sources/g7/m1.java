package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class m1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35245b;

    public /* synthetic */ m1(SimpleBasePlayer.State state) {
        this.f35245b = state;
    }

    public final Object get() {
        return this.f35245b.buildUpon().setDeviceVolume(this.f35245b.deviceVolume + 1).build();
    }
}
