package androidx.arch.core.executor;

import androidx.annotation.RestrictTo;
import java.util.List;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.mockito.Mockito;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class JunitTaskExecutorRule implements TestRule {
    private final TaskExecutorWithFakeMainThread mTaskExecutor;

    public JunitTaskExecutorRule(int i11, boolean z11) {
        if (z11) {
            this.mTaskExecutor = (TaskExecutorWithFakeMainThread) Mockito.spy(new TaskExecutorWithFakeMainThread(i11));
        } else {
            this.mTaskExecutor = new TaskExecutorWithFakeMainThread(i11);
        }
    }

    public void a() {
        ArchTaskExecutor.getInstance().setDelegate((TaskExecutor) null);
    }

    public Statement apply(final Statement statement, Description description) {
        return new Statement() {
            public void evaluate() throws Throwable {
                JunitTaskExecutorRule.this.b();
                try {
                    statement.evaluate();
                    JunitTaskExecutorRule.this.c();
                    JunitTaskExecutorRule.this.a();
                } catch (Throwable th2) {
                    JunitTaskExecutorRule.this.a();
                    throw th2;
                }
            }
        };
    }

    public void b() {
        ArchTaskExecutor.getInstance().setDelegate(this.mTaskExecutor);
    }

    public void c() throws InterruptedException, MultipleFailureException {
        this.mTaskExecutor.c(10);
        List<Throwable> b11 = this.mTaskExecutor.b();
        if (!b11.isEmpty()) {
            throw new MultipleFailureException(b11);
        }
    }

    public void drainTasks(int i11) throws InterruptedException {
        this.mTaskExecutor.drainTasks(i11);
    }

    public TaskExecutor getTaskExecutor() {
        return this.mTaskExecutor;
    }
}
