package org.junit.jupiter.engine.execution;

import f30.m;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.engine.EngineExecutionListener;
import org.junit.platform.engine.support.hierarchical.EngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

@API(since = "5.0", status = API.Status.INTERNAL)
public class JupiterEngineExecutionContext implements EngineExecutionContext {
    private static final Logger logger = LoggerFactory.getLogger(JupiterEngineExecutionContext.class);
    private boolean beforeAllCallbacksExecuted;
    private boolean beforeAllMethodsExecuted;
    private final State state;

    public static class Builder {
        private State newState;
        private State originalState;

        private State newState() {
            if (this.newState == null) {
                this.newState = this.originalState.clone();
            }
            return this.newState;
        }

        public JupiterEngineExecutionContext build() {
            State state = this.newState;
            if (state != null) {
                this.originalState = state;
                this.newState = null;
            }
            return new JupiterEngineExecutionContext(this.originalState);
        }

        public Builder withExtensionContext(ExtensionContext extensionContext) {
            newState().f62575f = extensionContext;
            return this;
        }

        public Builder withExtensionRegistry(MutableExtensionRegistry mutableExtensionRegistry) {
            newState().f62574e = mutableExtensionRegistry;
            return this;
        }

        public Builder withTestInstancesProvider(TestInstancesProvider testInstancesProvider) {
            newState().f62573d = testInstancesProvider;
            return this;
        }

        public Builder withThrowableCollector(ThrowableCollector throwableCollector) {
            newState().f62576g = throwableCollector;
            return this;
        }

        private Builder(State state) {
            this.newState = null;
            this.originalState = state;
        }
    }

    public static final class State implements Cloneable {

        /* renamed from: b  reason: collision with root package name */
        public final EngineExecutionListener f62571b;

        /* renamed from: c  reason: collision with root package name */
        public final JupiterConfiguration f62572c;

        /* renamed from: d  reason: collision with root package name */
        public TestInstancesProvider f62573d;

        /* renamed from: e  reason: collision with root package name */
        public MutableExtensionRegistry f62574e;

        /* renamed from: f  reason: collision with root package name */
        public ExtensionContext f62575f;

        /* renamed from: g  reason: collision with root package name */
        public ThrowableCollector f62576g;

        public State(EngineExecutionListener engineExecutionListener, JupiterConfiguration jupiterConfiguration) {
            this.f62571b = engineExecutionListener;
            this.f62572c = jupiterConfiguration;
        }

        public State clone() {
            try {
                return (State) super.clone();
            } catch (CloneNotSupportedException e11) {
                throw new JUnitException("State could not be cloned", e11);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$close$0(ExtensionContext extensionContext) {
        return "Caught exception while closing extension context: " + extensionContext;
    }

    public void beforeAllCallbacksExecuted(boolean z11) {
        this.beforeAllCallbacksExecuted = z11;
    }

    public void beforeAllMethodsExecuted(boolean z11) {
        this.beforeAllMethodsExecuted = z11;
    }

    public void close() throws Exception {
        ExtensionContext extensionContext = getExtensionContext();
        if (extensionContext instanceof AutoCloseable) {
            try {
                ((AutoCloseable) extensionContext).close();
            } catch (Exception e11) {
                logger.error(e11, new m(extensionContext));
                throw e11;
            }
        }
    }

    public Builder extend() {
        return new Builder(this.state);
    }

    public JupiterConfiguration getConfiguration() {
        return this.state.f62572c;
    }

    public EngineExecutionListener getExecutionListener() {
        return this.state.f62571b;
    }

    public ExtensionContext getExtensionContext() {
        return this.state.f62575f;
    }

    public MutableExtensionRegistry getExtensionRegistry() {
        return this.state.f62574e;
    }

    public TestInstancesProvider getTestInstancesProvider() {
        return this.state.f62573d;
    }

    public ThrowableCollector getThrowableCollector() {
        return this.state.f62576g;
    }

    public JupiterEngineExecutionContext(EngineExecutionListener engineExecutionListener, JupiterConfiguration jupiterConfiguration) {
        this(new State(engineExecutionListener, jupiterConfiguration));
    }

    public boolean beforeAllCallbacksExecuted() {
        return this.beforeAllCallbacksExecuted;
    }

    public boolean beforeAllMethodsExecuted() {
        return this.beforeAllMethodsExecuted;
    }

    private JupiterEngineExecutionContext(State state2) {
        this.beforeAllCallbacksExecuted = false;
        this.beforeAllMethodsExecuted = false;
        this.state = state2;
    }
}
