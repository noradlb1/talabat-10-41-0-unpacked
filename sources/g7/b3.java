package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import java.util.concurrent.Executor;

public final /* synthetic */ class b3 implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer f35189b;

    public /* synthetic */ b3(SimpleBasePlayer simpleBasePlayer) {
        this.f35189b = simpleBasePlayer;
    }

    public final void execute(Runnable runnable) {
        this.f35189b.postOrRunOnApplicationHandler(runnable);
    }
}
