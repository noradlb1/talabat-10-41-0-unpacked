package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class h1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35218b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35219c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35220d;

    public /* synthetic */ h1(SimpleBasePlayer.State state, int i11, long j11) {
        this.f35218b = state;
        this.f35219c = i11;
        this.f35220d = j11;
    }

    public final Object get() {
        return SimpleBasePlayer.getStateWithNewPlaylistAndPosition(this.f35218b, this.f35218b.playlist, this.f35219c, this.f35220d);
    }
}
