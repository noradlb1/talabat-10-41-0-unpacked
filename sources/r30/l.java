package r30;

import java.util.Collections;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.support.hierarchical.EngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.Node;

public final /* synthetic */ class l<C extends EngineExecutionContext> {
    public static void a(Node node, EngineExecutionContext engineExecutionContext) throws Exception {
    }

    @API(since = "1.4", status = API.Status.EXPERIMENTAL)
    public static void b(Node node, EngineExecutionContext engineExecutionContext, Node.Invocation invocation) throws Exception {
        invocation.invoke(engineExecutionContext);
    }

    public static EngineExecutionContext c(Node node, EngineExecutionContext engineExecutionContext) throws Exception {
        return engineExecutionContext;
    }

    public static void d(Node node, EngineExecutionContext engineExecutionContext) throws Exception {
    }

    public static EngineExecutionContext e(Node node, EngineExecutionContext engineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) throws Exception {
        return engineExecutionContext;
    }

    @API(consumers = {"org.junit.platform.engine.support.hierarchical"}, since = "1.3", status = API.Status.EXPERIMENTAL)
    public static Set f(Node node) {
        return Collections.emptySet();
    }

    @API(consumers = {"org.junit.platform.engine.support.hierarchical"}, since = "1.3", status = API.Status.EXPERIMENTAL)
    public static Node.ExecutionMode g(Node node) {
        return Node.ExecutionMode.CONCURRENT;
    }

    @API(consumers = {"org.junit.platform.engine.support.hierarchical"}, since = "1.4", status = API.Status.EXPERIMENTAL)
    public static void h(Node node, EngineExecutionContext engineExecutionContext, TestDescriptor testDescriptor, TestExecutionResult testExecutionResult) {
    }

    @API(consumers = {"org.junit.platform.engine.support.hierarchical"}, since = "1.4", status = API.Status.EXPERIMENTAL)
    public static void i(Node node, EngineExecutionContext engineExecutionContext, TestDescriptor testDescriptor, Node.SkipResult skipResult) {
    }

    public static EngineExecutionContext j(Node node, EngineExecutionContext engineExecutionContext) throws Exception {
        return engineExecutionContext;
    }

    public static Node.SkipResult k(Node node, EngineExecutionContext engineExecutionContext) throws Exception {
        return Node.SkipResult.doNotSkip();
    }
}
