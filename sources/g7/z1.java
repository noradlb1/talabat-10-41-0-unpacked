package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class z1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35292b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35293c;

    public /* synthetic */ z1(SimpleBasePlayer.State state, int i11) {
        this.f35292b = state;
        this.f35293c = i11;
    }

    public final Object get() {
        return this.f35292b.buildUpon().setDeviceVolume(this.f35293c).build();
    }
}
