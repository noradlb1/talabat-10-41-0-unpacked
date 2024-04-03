package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;
import java.util.List;

public final /* synthetic */ class g1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer f35212b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35213c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f35214d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f35215e;

    public /* synthetic */ g1(SimpleBasePlayer simpleBasePlayer, SimpleBasePlayer.State state, List list, int i11) {
        this.f35212b = simpleBasePlayer;
        this.f35213c = state;
        this.f35214d = list;
        this.f35215e = i11;
    }

    public final Object get() {
        return this.f35212b.lambda$addMediaItems$3(this.f35213c, this.f35214d, this.f35215e);
    }
}
