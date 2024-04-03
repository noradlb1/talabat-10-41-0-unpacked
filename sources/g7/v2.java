package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;
import java.util.List;

public final /* synthetic */ class v2 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer f35275b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f35276c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35277d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f35278e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f35279f;

    public /* synthetic */ v2(SimpleBasePlayer simpleBasePlayer, List list, SimpleBasePlayer.State state, int i11, long j11) {
        this.f35275b = simpleBasePlayer;
        this.f35276c = list;
        this.f35277d = state;
        this.f35278e = i11;
        this.f35279f = j11;
    }

    public final Object get() {
        return this.f35275b.lambda$setMediaItemsInternal$2(this.f35276c, this.f35277d, this.f35278e, this.f35279f);
    }
}
