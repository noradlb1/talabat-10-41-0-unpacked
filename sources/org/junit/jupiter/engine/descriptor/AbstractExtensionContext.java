package org.junit.jupiter.engine.descriptor;

import d30.a;
import d30.b;
import d30.c;
import j$.util.Collection;
import j$.util.Optional;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.extension.ExecutableInvoker;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.ExtensionValuesStore;
import org.junit.jupiter.engine.execution.NamespaceAwareStore;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.EngineExecutionListener;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.engine.support.hierarchical.Node;

abstract class AbstractExtensionContext<T extends TestDescriptor> implements ExtensionContext, AutoCloseable {
    private final JupiterConfiguration configuration;
    private final EngineExecutionListener engineExecutionListener;
    private final ExecutableInvoker executableInvoker;
    private final ExtensionContext parent;
    private final Set<String> tags;
    private final T testDescriptor;
    private final ExtensionValuesStore valuesStore;

    /* renamed from: org.junit.jupiter.engine.descriptor.AbstractExtensionContext$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f62412a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.junit.platform.engine.support.hierarchical.Node$ExecutionMode[] r0 = org.junit.platform.engine.support.hierarchical.Node.ExecutionMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f62412a = r0
                org.junit.platform.engine.support.hierarchical.Node$ExecutionMode r1 = org.junit.platform.engine.support.hierarchical.Node.ExecutionMode.CONCURRENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f62412a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.junit.platform.engine.support.hierarchical.Node$ExecutionMode r1 = org.junit.platform.engine.support.hierarchical.Node.ExecutionMode.SAME_THREAD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.engine.descriptor.AbstractExtensionContext.AnonymousClass1.<clinit>():void");
        }
    }

    public AbstractExtensionContext(ExtensionContext extensionContext, EngineExecutionListener engineExecutionListener2, T t11, JupiterConfiguration jupiterConfiguration, ExecutableInvoker executableInvoker2) {
        this.executableInvoker = executableInvoker2;
        Preconditions.notNull(t11, "TestDescriptor must not be null");
        Preconditions.notNull(jupiterConfiguration, "JupiterConfiguration must not be null");
        this.parent = extensionContext;
        this.engineExecutionListener = engineExecutionListener2;
        this.testDescriptor = t11;
        this.configuration = jupiterConfiguration;
        this.valuesStore = createStore(extensionContext);
        this.tags = (Set) Collection.EL.stream(t11.getTags()).map(new a()).collect(Collectors.collectingAndThen(Collectors.toCollection(new b()), new c()));
    }

    private ExtensionValuesStore createStore(ExtensionContext extensionContext) {
        ExtensionValuesStore extensionValuesStore;
        if (extensionContext != null) {
            extensionValuesStore = ((AbstractExtensionContext) extensionContext).valuesStore;
        } else {
            extensionValuesStore = null;
        }
        return new ExtensionValuesStore(extensionValuesStore);
    }

    private ExecutionMode toJupiterExecutionMode(Node.ExecutionMode executionMode) {
        int i11 = AnonymousClass1.f62412a[executionMode.ordinal()];
        if (i11 == 1) {
            return ExecutionMode.CONCURRENT;
        }
        if (i11 == 2) {
            return ExecutionMode.SAME_THREAD;
        }
        throw new JUnitException("Unknown ExecutionMode: " + executionMode);
    }

    public abstract Node.ExecutionMode a();

    public T b() {
        return this.testDescriptor;
    }

    public void close() {
        this.valuesStore.closeAllStoredCloseableValues();
    }

    public Optional<String> getConfigurationParameter(String str) {
        return this.configuration.getRawConfigurationParameter(str);
    }

    public String getDisplayName() {
        return b().getDisplayName();
    }

    public ExecutableInvoker getExecutableInvoker() {
        return this.executableInvoker;
    }

    public ExecutionMode getExecutionMode() {
        return toJupiterExecutionMode(a());
    }

    public Optional<ExtensionContext> getParent() {
        return Optional.ofNullable(this.parent);
    }

    public /* synthetic */ Class getRequiredTestClass() {
        return z20.b.a(this);
    }

    public /* synthetic */ Object getRequiredTestInstance() {
        return z20.b.b(this);
    }

    public /* synthetic */ TestInstances getRequiredTestInstances() {
        return z20.b.c(this);
    }

    public /* synthetic */ Method getRequiredTestMethod() {
        return z20.b.d(this);
    }

    public ExtensionContext getRoot() {
        ExtensionContext extensionContext = this.parent;
        if (extensionContext != null) {
            return extensionContext.getRoot();
        }
        return this;
    }

    public ExtensionContext.Store getStore(ExtensionContext.Namespace namespace) {
        Preconditions.notNull(namespace, "Namespace must not be null");
        return new NamespaceAwareStore(this.valuesStore, namespace);
    }

    public Set<String> getTags() {
        return new LinkedHashSet(this.tags);
    }

    public String getUniqueId() {
        return b().getUniqueId().toString();
    }

    public /* synthetic */ void publishReportEntry(String str) {
        z20.b.e(this, str);
    }

    public /* synthetic */ void publishReportEntry(String str, String str2) {
        z20.b.f(this, str, str2);
    }

    public void publishReportEntry(Map<String, String> map) {
        this.engineExecutionListener.reportingEntryPublished(this.testDescriptor, ReportEntry.from(map));
    }

    public <V> Optional<V> getConfigurationParameter(String str, Function<String, V> function) {
        return this.configuration.getRawConfigurationParameter(str, function);
    }
}
