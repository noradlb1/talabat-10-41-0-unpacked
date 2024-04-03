package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class u2 implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer f35272a;

    public /* synthetic */ u2(SimpleBasePlayer simpleBasePlayer) {
        this.f35272a = simpleBasePlayer;
    }

    public final void invoke(Object obj, FlagSet flagSet) {
        this.f35272a.lambda$new$0((Player.Listener) obj, flagSet);
    }
}
