package org.junit.jupiter.engine.config;

import c30.a;
import c30.b;
import c30.c;
import c30.d;
import c30.e;
import c30.f;
import c30.g;
import c30.h;
import c30.i;
import c30.j;
import j$.util.Optional;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.Function;
import j$.util.function.Predicate;
import org.apiguardian.api.API;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.parallel.ExecutionMode;

@API(since = "5.4", status = API.Status.INTERNAL)
public class CachingJupiterConfiguration implements JupiterConfiguration {
    private final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();
    private final JupiterConfiguration delegate;

    public CachingJupiterConfiguration(JupiterConfiguration jupiterConfiguration) {
        this.delegate = jupiterConfiguration;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$getDefaultClassesExecutionMode$3(String str) {
        return this.delegate.getDefaultClassesExecutionMode();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$getDefaultDisplayNameGenerator$6(String str) {
        return this.delegate.getDefaultDisplayNameGenerator();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$getDefaultExecutionMode$2(String str) {
        return this.delegate.getDefaultExecutionMode();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$getDefaultTempDirCleanupMode$9(String str) {
        return this.delegate.getDefaultTempDirCleanupMode();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$getDefaultTestClassOrderer$8(String str) {
        return this.delegate.getDefaultTestClassOrderer();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$getDefaultTestInstanceLifecycle$4(String str) {
        return this.delegate.getDefaultTestInstanceLifecycle();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$getDefaultTestMethodOrderer$7(String str) {
        return this.delegate.getDefaultTestMethodOrderer();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$getExecutionConditionFilter$5(String str) {
        return this.delegate.getExecutionConditionFilter();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$isExtensionAutoDetectionEnabled$1(String str) {
        return Boolean.valueOf(this.delegate.isExtensionAutoDetectionEnabled());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$isParallelExecutionEnabled$0(String str) {
        return Boolean.valueOf(this.delegate.isParallelExecutionEnabled());
    }

    public ExecutionMode getDefaultClassesExecutionMode() {
        return (ExecutionMode) ConcurrentMap.EL.computeIfAbsent(this.cache, "junit.jupiter.execution.parallel.mode.classes.default", new a(this));
    }

    public DisplayNameGenerator getDefaultDisplayNameGenerator() {
        return (DisplayNameGenerator) ConcurrentMap.EL.computeIfAbsent(this.cache, "junit.jupiter.displayname.generator.default", new e(this));
    }

    public ExecutionMode getDefaultExecutionMode() {
        return (ExecutionMode) ConcurrentMap.EL.computeIfAbsent(this.cache, "junit.jupiter.execution.parallel.mode.default", new i(this));
    }

    public CleanupMode getDefaultTempDirCleanupMode() {
        return (CleanupMode) ConcurrentMap.EL.computeIfAbsent(this.cache, TempDir.DEFAULT_CLEANUP_MODE_PROPERTY_NAME, new d(this));
    }

    public Optional<ClassOrderer> getDefaultTestClassOrderer() {
        return (Optional) ConcurrentMap.EL.computeIfAbsent(this.cache, "junit.jupiter.testclass.order.default", new g(this));
    }

    public TestInstance.Lifecycle getDefaultTestInstanceLifecycle() {
        return (TestInstance.Lifecycle) ConcurrentMap.EL.computeIfAbsent(this.cache, "junit.jupiter.testinstance.lifecycle.default", new f(this));
    }

    public Optional<MethodOrderer> getDefaultTestMethodOrderer() {
        return (Optional) ConcurrentMap.EL.computeIfAbsent(this.cache, "junit.jupiter.testmethod.order.default", new h(this));
    }

    public Predicate<ExecutionCondition> getExecutionConditionFilter() {
        return (Predicate) ConcurrentMap.EL.computeIfAbsent(this.cache, "junit.jupiter.conditions.deactivate", new j(this));
    }

    public Optional<String> getRawConfigurationParameter(String str) {
        return this.delegate.getRawConfigurationParameter(str);
    }

    public boolean isExtensionAutoDetectionEnabled() {
        return ((Boolean) ConcurrentMap.EL.computeIfAbsent(this.cache, "junit.jupiter.extensions.autodetection.enabled", new c(this))).booleanValue();
    }

    public boolean isParallelExecutionEnabled() {
        return ((Boolean) ConcurrentMap.EL.computeIfAbsent(this.cache, "junit.jupiter.execution.parallel.enabled", new b(this))).booleanValue();
    }

    public <T> Optional<T> getRawConfigurationParameter(String str, Function<String, T> function) {
        return this.delegate.getRawConfigurationParameter(str, function);
    }
}
