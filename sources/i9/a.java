package i9;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import java.util.concurrent.Executor;

public final /* synthetic */ class a implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractExecutionThreadService f47109b;

    public /* synthetic */ a(AbstractExecutionThreadService abstractExecutionThreadService) {
        this.f47109b = abstractExecutionThreadService;
    }

    public final void execute(Runnable runnable) {
        this.f47109b.lambda$executor$0(runnable);
    }
}
