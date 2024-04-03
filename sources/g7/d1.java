package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class d1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer f35195b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35196c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f35197d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f35198e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f35199f;

    public /* synthetic */ d1(SimpleBasePlayer simpleBasePlayer, SimpleBasePlayer.State state, int i11, int i12, int i13) {
        this.f35195b = simpleBasePlayer;
        this.f35196c = state;
        this.f35197d = i11;
        this.f35198e = i12;
        this.f35199f = i13;
    }

    public final Object get() {
        return this.f35195b.lambda$moveMediaItems$4(this.f35196c, this.f35197d, this.f35198e, this.f35199f);
    }
}
