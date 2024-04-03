package androidx.arch.core.executor.testing;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.TaskExecutor;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class InstantTaskExecutorRule extends TestWatcher {
    public void g(Description description) {
        super.g(description);
        ArchTaskExecutor.getInstance().setDelegate((TaskExecutor) null);
    }

    public void j(Description description) {
        super.j(description);
        ArchTaskExecutor.getInstance().setDelegate(new TaskExecutor() {
            public void executeOnDiskIO(Runnable runnable) {
                runnable.run();
            }

            public boolean isMainThread() {
                return true;
            }

            public void postToMainThread(Runnable runnable) {
                runnable.run();
            }
        });
    }
}
