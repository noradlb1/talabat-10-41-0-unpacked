package org.junit.platform.engine.support.hierarchical;

import org.apiguardian.api.API;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.junit.platform.engine.TestExecutionResult;
import org.opentest4j.TestAbortedException;

@Deprecated
@API(since = "1.2", status = API.Status.DEPRECATED)
public class SingleTestExecutor {

    @FunctionalInterface
    public interface Executable {
        void execute() throws TestAbortedException, Throwable;
    }

    public TestExecutionResult executeSafely(Executable executable) {
        try {
            executable.execute();
            return TestExecutionResult.successful();
        } catch (TestAbortedException e11) {
            return TestExecutionResult.aborted(e11);
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            return TestExecutionResult.failed(th2);
        }
    }
}
