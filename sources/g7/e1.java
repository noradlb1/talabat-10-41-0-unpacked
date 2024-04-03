package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.Size;
import com.google.common.base.Supplier;

public final /* synthetic */ class e1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35204b;

    public /* synthetic */ e1(SimpleBasePlayer.State state) {
        this.f35204b = state;
    }

    public final Object get() {
        return this.f35204b.buildUpon().setSurfaceSize(Size.UNKNOWN).build();
    }
}
