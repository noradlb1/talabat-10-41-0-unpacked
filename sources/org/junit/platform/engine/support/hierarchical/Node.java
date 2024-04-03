package org.junit.platform.engine.support.hierarchical;

import com.facebook.login.LoginLogger;
import j$.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.EngineExecutionListener;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.support.hierarchical.EngineExecutionContext;

@API(consumers = {"org.junit.platform.engine.support.hierarchical"}, since = "1.0", status = API.Status.MAINTAINED)
public interface Node<C extends EngineExecutionContext> {

    public interface DynamicTestExecutor {
        void awaitFinished() throws InterruptedException;

        @API(since = "5.7", status = API.Status.EXPERIMENTAL)
        Future<?> execute(TestDescriptor testDescriptor, EngineExecutionListener engineExecutionListener);

        void execute(TestDescriptor testDescriptor);
    }

    @API(consumers = {"org.junit.platform.engine.support.hierarchical"}, since = "1.3", status = API.Status.EXPERIMENTAL)
    public enum ExecutionMode {
        SAME_THREAD,
        CONCURRENT
    }

    @API(since = "1.4", status = API.Status.EXPERIMENTAL)
    public interface Invocation<C extends EngineExecutionContext> {
        void invoke(C c11) throws Exception;
    }

    public static class SkipResult {
        private static final SkipResult alwaysExecuteSkipResult = new SkipResult(false, (String) null);
        private final Optional<String> reason;
        private final boolean skipped;

        private SkipResult(boolean z11, String str) {
            this.skipped = z11;
            this.reason = Optional.ofNullable(str);
        }

        public static SkipResult doNotSkip() {
            return alwaysExecuteSkipResult;
        }

        public static SkipResult skip(String str) {
            return new SkipResult(true, str);
        }

        public Optional<String> getReason() {
            return this.reason;
        }

        public boolean isSkipped() {
            return this.skipped;
        }

        public String toString() {
            return new ToStringBuilder((Object) this).append(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, Boolean.valueOf(this.skipped)).append("reason", this.reason.orElse("<unknown>")).toString();
        }
    }

    void after(C c11) throws Exception;

    @API(since = "1.4", status = API.Status.EXPERIMENTAL)
    void around(C c11, Invocation<C> invocation) throws Exception;

    C before(C c11) throws Exception;

    void cleanUp(C c11) throws Exception;

    C execute(C c11, DynamicTestExecutor dynamicTestExecutor) throws Exception;

    @API(consumers = {"org.junit.platform.engine.support.hierarchical"}, since = "1.3", status = API.Status.EXPERIMENTAL)
    Set<ExclusiveResource> getExclusiveResources();

    @API(consumers = {"org.junit.platform.engine.support.hierarchical"}, since = "1.3", status = API.Status.EXPERIMENTAL)
    ExecutionMode getExecutionMode();

    @API(consumers = {"org.junit.platform.engine.support.hierarchical"}, since = "1.4", status = API.Status.EXPERIMENTAL)
    void nodeFinished(C c11, TestDescriptor testDescriptor, TestExecutionResult testExecutionResult);

    @API(consumers = {"org.junit.platform.engine.support.hierarchical"}, since = "1.4", status = API.Status.EXPERIMENTAL)
    void nodeSkipped(C c11, TestDescriptor testDescriptor, SkipResult skipResult);

    C prepare(C c11) throws Exception;

    SkipResult shouldBeSkipped(C c11) throws Exception;
}
