package qd;

import com.instabug.library.util.threading.PriorityThreadFactory;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PriorityThreadFactory f57186b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f57187c;

    public /* synthetic */ b(PriorityThreadFactory priorityThreadFactory, Runnable runnable) {
        this.f57186b = priorityThreadFactory;
        this.f57187c = runnable;
    }

    public final void run() {
        this.f57186b.lambda$newThread$0(this.f57187c);
    }
}
