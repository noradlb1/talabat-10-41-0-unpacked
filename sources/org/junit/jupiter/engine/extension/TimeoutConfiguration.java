package org.junit.jupiter.engine.extension;

import j$.util.Map;
import j$.util.Optional;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Supplier;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

class TimeoutConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(TimeoutConfiguration.class);
    private final Map<String, Optional<TimeoutDuration>> cache = new ConcurrentHashMap();
    private final ExtensionContext extensionContext;
    private final TimeoutDurationParser parser = new TimeoutDurationParser();
    private final AtomicReference<Optional<Timeout.ThreadMode>> threadMode = new AtomicReference<>();

    public TimeoutConfiguration(ExtensionContext extensionContext2) {
        this.extensionContext = extensionContext2;
    }

    /* access modifiers changed from: private */
    public Optional<TimeoutDuration> getDefaultLifecycleMethodTimeout() {
        return parseOrDefault("junit.jupiter.execution.timeout.lifecycle.method.default", new p(this));
    }

    /* access modifiers changed from: private */
    public Optional<TimeoutDuration> getDefaultTestableMethodTimeout() {
        return parseOrDefault("junit.jupiter.execution.timeout.testable.method.default", new p(this));
    }

    /* access modifiers changed from: private */
    public Optional<TimeoutDuration> getDefaultTimeout() {
        return parseTimeoutDuration("junit.jupiter.execution.timeout.default");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ TimeoutDuration lambda$parseTimeoutDuration$1(String str, String str2) {
        try {
            return this.parser.a(str2);
        } catch (Exception e11) {
            logger.warn(e11, new v(str2, str));
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$parseTimeoutDuration$2(String str) {
        return this.extensionContext.getConfigurationParameter(str).map(new u(this, str));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Timeout.ThreadMode lambda$parseTimeoutThreadModeConfiguration$5(String str) {
        try {
            Timeout.ThreadMode valueOf = Timeout.ThreadMode.valueOf(str.toUpperCase());
            if (valueOf != Timeout.ThreadMode.INFERRED) {
                return valueOf;
            }
            logger.warn(new s(str));
            return null;
        } catch (Exception e11) {
            logger.warn(e11, new t(str));
            return null;
        }
    }

    private Optional<TimeoutDuration> parseOrDefault(String str, Supplier<Optional<TimeoutDuration>> supplier) {
        Optional<TimeoutDuration> parseTimeoutDuration = parseTimeoutDuration(str);
        if (parseTimeoutDuration.isPresent()) {
            return parseTimeoutDuration;
        }
        return supplier.get();
    }

    private Optional<TimeoutDuration> parseTimeoutDuration(String str) {
        return (Optional) Map.EL.computeIfAbsent(this.cache, str, new q(this));
    }

    private Optional<Timeout.ThreadMode> parseTimeoutThreadModeConfiguration() {
        return this.extensionContext.getConfigurationParameter("junit.jupiter.execution.timeout.thread.mode.default").map(new r());
    }

    public Optional<TimeoutDuration> j() {
        return parseOrDefault("junit.jupiter.execution.timeout.afterall.method.default", new x(this));
    }

    public Optional<TimeoutDuration> k() {
        return parseOrDefault("junit.jupiter.execution.timeout.aftereach.method.default", new x(this));
    }

    public Optional<TimeoutDuration> l() {
        return parseOrDefault("junit.jupiter.execution.timeout.beforeall.method.default", new x(this));
    }

    public Optional<TimeoutDuration> m() {
        return parseOrDefault("junit.jupiter.execution.timeout.beforeeach.method.default", new x(this));
    }

    public Optional<TimeoutDuration> n() {
        return parseOrDefault("junit.jupiter.execution.timeout.testfactory.method.default", new w(this));
    }

    public Optional<TimeoutDuration> o() {
        return parseOrDefault("junit.jupiter.execution.timeout.test.method.default", new w(this));
    }

    public Optional<TimeoutDuration> p() {
        return parseOrDefault("junit.jupiter.execution.timeout.testtemplate.method.default", new w(this));
    }

    public Optional<Timeout.ThreadMode> q() {
        if (this.threadMode.get() != null) {
            return this.threadMode.get();
        }
        Optional<Timeout.ThreadMode> parseTimeoutThreadModeConfiguration = parseTimeoutThreadModeConfiguration();
        this.threadMode.set(parseTimeoutThreadModeConfiguration);
        return parseTimeoutThreadModeConfiguration;
    }
}
