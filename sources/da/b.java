package da;

import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f50604b;

    public /* synthetic */ b(DefaultHeartBeatController defaultHeartBeatController) {
        this.f50604b = defaultHeartBeatController;
    }

    public final Object call() {
        return this.f50604b.lambda$registerHeartBeat$0();
    }
}
