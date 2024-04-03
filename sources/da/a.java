package da;

import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f50603b;

    public /* synthetic */ a(DefaultHeartBeatController defaultHeartBeatController) {
        this.f50603b = defaultHeartBeatController;
    }

    public final Object call() {
        return this.f50603b.lambda$getHeartBeatsHeader$1();
    }
}
