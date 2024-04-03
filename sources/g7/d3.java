package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class d3 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35201b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f35202c;

    public /* synthetic */ d3(SimpleBasePlayer.State state, float f11) {
        this.f35201b = state;
        this.f35202c = f11;
    }

    public final Object get() {
        return this.f35201b.buildUpon().setVolume(this.f35202c).build();
    }
}
