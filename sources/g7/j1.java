package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class j1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35231b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f35232c;

    public /* synthetic */ j1(SimpleBasePlayer.State state, boolean z11) {
        this.f35231b = state;
        this.f35232c = z11;
    }

    public final Object get() {
        return this.f35231b.buildUpon().setPlayWhenReady(this.f35232c, 1).build();
    }
}
