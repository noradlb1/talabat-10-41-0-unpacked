package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class a2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f35182a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f35183b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f35184c;

    public /* synthetic */ a2(int i11, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f35182a = i11;
        this.f35183b = positionInfo;
        this.f35184c = positionInfo2;
    }

    public final void invoke(Object obj) {
        SimpleBasePlayer.lambda$updateStateAndInformListeners$26(this.f35182a, this.f35183b, this.f35184c, (Player.Listener) obj);
    }
}
