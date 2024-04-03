package org.junit.platform.engine.support.hierarchical;

import j$.util.Optional;
import m30.r;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.engine.ExecutionRequest;
import org.junit.platform.engine.TestEngine;
import org.junit.platform.engine.support.hierarchical.EngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;
import r30.h;

@API(since = "1.0", status = API.Status.MAINTAINED)
public abstract class HierarchicalTestEngine<C extends EngineExecutionContext> implements TestEngine {
    public abstract C a(ExecutionRequest executionRequest);

    @API(since = "1.3", status = API.Status.EXPERIMENTAL)
    public HierarchicalTestExecutorService b(ExecutionRequest executionRequest) {
        return new SameThreadHierarchicalTestExecutorService();
    }

    @API(since = "1.3", status = API.Status.EXPERIMENTAL)
    public ThrowableCollector.Factory c(ExecutionRequest executionRequest) {
        return new h();
    }

    public final void execute(ExecutionRequest executionRequest) {
        HierarchicalTestExecutorService b11;
        try {
            b11 = b(executionRequest);
            new HierarchicalTestExecutor(executionRequest, a(executionRequest), b11, c(executionRequest)).a().get();
            if (b11 != null) {
                b11.close();
                return;
            }
            return;
        } catch (Exception e11) {
            throw new JUnitException("Error executing tests for engine " + getId(), e11);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public /* synthetic */ Optional getArtifactId() {
        return r.a(this);
    }

    public /* synthetic */ Optional getGroupId() {
        return r.b(this);
    }

    public /* synthetic */ Optional getVersion() {
        return r.c(this);
    }
}
