package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class l1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35239b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f35240c;

    public /* synthetic */ l1(SimpleBasePlayer.State state, boolean z11) {
        this.f35239b = state;
        this.f35240c = z11;
    }

    public final Object get() {
        return this.f35239b.buildUpon().setIsDeviceMuted(this.f35240c).build();
    }
}
