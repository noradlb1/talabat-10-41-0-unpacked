package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class f1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35207b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f35208c;

    public /* synthetic */ f1(SimpleBasePlayer.State state, boolean z11) {
        this.f35207b = state;
        this.f35208c = z11;
    }

    public final Object get() {
        return this.f35207b.buildUpon().setShuffleModeEnabled(this.f35208c).build();
    }
}
