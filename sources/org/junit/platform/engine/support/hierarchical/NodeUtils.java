package org.junit.platform.engine.support.hierarchical;

import java.util.Set;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.support.hierarchical.Node;
import r30.l;

final class NodeUtils {
    private static final Node noOpNode = new Node() {
        public /* synthetic */ void after(EngineExecutionContext engineExecutionContext) {
            l.a(this, engineExecutionContext);
        }

        public /* synthetic */ void around(EngineExecutionContext engineExecutionContext, Node.Invocation invocation) {
            l.b(this, engineExecutionContext, invocation);
        }

        public /* synthetic */ EngineExecutionContext before(EngineExecutionContext engineExecutionContext) {
            return l.c(this, engineExecutionContext);
        }

        public /* synthetic */ void cleanUp(EngineExecutionContext engineExecutionContext) {
            l.d(this, engineExecutionContext);
        }

        public /* synthetic */ EngineExecutionContext execute(EngineExecutionContext engineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) {
            return l.e(this, engineExecutionContext, dynamicTestExecutor);
        }

        public /* synthetic */ Set getExclusiveResources() {
            return l.f(this);
        }

        public /* synthetic */ Node.ExecutionMode getExecutionMode() {
            return l.g(this);
        }

        public /* synthetic */ void nodeFinished(EngineExecutionContext engineExecutionContext, TestDescriptor testDescriptor, TestExecutionResult testExecutionResult) {
            l.h(this, engineExecutionContext, testDescriptor, testExecutionResult);
        }

        public /* synthetic */ void nodeSkipped(EngineExecutionContext engineExecutionContext, TestDescriptor testDescriptor, Node.SkipResult skipResult) {
            l.i(this, engineExecutionContext, testDescriptor, skipResult);
        }

        public /* synthetic */ EngineExecutionContext prepare(EngineExecutionContext engineExecutionContext) {
            return l.j(this, engineExecutionContext);
        }

        public /* synthetic */ Node.SkipResult shouldBeSkipped(EngineExecutionContext engineExecutionContext) {
            return l.k(this, engineExecutionContext);
        }
    };

    private NodeUtils() {
    }

    public static <C extends EngineExecutionContext> Node<C> a(TestDescriptor testDescriptor) {
        return testDescriptor instanceof Node ? (Node) testDescriptor : noOpNode;
    }
}
