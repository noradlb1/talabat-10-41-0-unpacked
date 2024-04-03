package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class z2 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer f35294b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35295c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f35296d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f35297e;

    public /* synthetic */ z2(SimpleBasePlayer simpleBasePlayer, SimpleBasePlayer.State state, int i11, int i12) {
        this.f35294b = simpleBasePlayer;
        this.f35295c = state;
        this.f35296d = i11;
        this.f35297e = i12;
    }

    public final Object get() {
        return this.f35294b.lambda$removeMediaItems$5(this.f35295c, this.f35296d, this.f35297e);
    }
}
