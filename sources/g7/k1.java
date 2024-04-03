package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.Size;
import com.google.common.base.Supplier;

public final /* synthetic */ class k1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35235b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Size f35236c;

    public /* synthetic */ k1(SimpleBasePlayer.State state, Size size) {
        this.f35235b = state;
        this.f35236c = size;
    }

    public final Object get() {
        return this.f35235b.buildUpon().setSurfaceSize(this.f35236c).build();
    }
}
