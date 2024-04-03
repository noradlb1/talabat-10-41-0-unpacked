package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.Size;
import com.google.common.base.Supplier;

public final /* synthetic */ class k2 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35237b;

    public /* synthetic */ k2(SimpleBasePlayer.State state) {
        this.f35237b = state;
    }

    public final Object get() {
        return this.f35237b.buildUpon().setSurfaceSize(Size.ZERO).build();
    }
}
