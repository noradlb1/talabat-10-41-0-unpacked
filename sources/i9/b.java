package i9;

import com.google.common.util.concurrent.AbstractIdleService;
import java.util.concurrent.Executor;

public final /* synthetic */ class b implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractIdleService f47110b;

    public /* synthetic */ b(AbstractIdleService abstractIdleService) {
        this.f47110b = abstractIdleService;
    }

    public final void execute(Runnable runnable) {
        this.f47110b.lambda$executor$0(runnable);
    }
}
