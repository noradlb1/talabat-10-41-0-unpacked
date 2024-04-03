package r9;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class n implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f50768a;

    public /* synthetic */ n(CountDownLatch countDownLatch) {
        this.f50768a = countDownLatch;
    }

    public final Object then(Task task) {
        return this.f50768a.countDown();
    }
}
