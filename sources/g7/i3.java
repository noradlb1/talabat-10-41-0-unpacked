package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;

public final /* synthetic */ class i3 implements SimpleBasePlayer.PositionSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f35228a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f35229b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f35230c;

    public /* synthetic */ i3(long j11, long j12, float f11) {
        this.f35228a = j11;
        this.f35229b = j12;
        this.f35230c = f11;
    }

    public final long get() {
        return k3.d(this.f35228a, this.f35229b, this.f35230c);
    }
}
