package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class i1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35225b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35226c;

    public /* synthetic */ i1(SimpleBasePlayer.State state, int i11) {
        this.f35225b = state;
        this.f35226c = i11;
    }

    public final Object get() {
        return this.f35225b.buildUpon().setRepeatMode(this.f35226c).build();
    }
}
