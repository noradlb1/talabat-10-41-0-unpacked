package org.junit.jupiter.engine.config;

import c30.o;
import j$.util.Optional;
import java.util.Objects;
import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.engine.ConfigurationParameters;
import x20.v;

class InstantiatingConfigurationParameterConverter<T> {
    private static final Logger logger = LoggerFactory.getLogger(InstantiatingConfigurationParameterConverter.class);
    private final Class<T> clazz;

    /* renamed from: name  reason: collision with root package name */
    private final String f62397name;

    public InstantiatingConfigurationParameterConverter(Class<T> cls, String str) {
        this.clazz = cls;
        this.f62397name = str;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$get$0(String str) {
        return !str.isEmpty();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$logFailureMessage$5(String str, String str2) {
        return String.format("Failed to load default %s class '%s' set via the '%s' configuration parameter. Falling back to default behavior.", new Object[]{this.f62397name, str, str2});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$logSuccessMessage$6(String str, String str2) {
        return String.format("Using default %s '%s' set via the '%s' configuration parameter.", new Object[]{this.f62397name, str, str2});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$newInstance$3(String str, String str2, Object obj) {
        logSuccessMessage(str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: logFailureMessage */
    public void lambda$newInstance$4(String str, String str2, Exception exc) {
        logger.warn(exc, new a(this, str, str2));
    }

    private void logSuccessMessage(String str, String str2) {
        logger.config(new g(this, str, str2));
    }

    /* access modifiers changed from: private */
    /* renamed from: newInstance */
    public Optional<T> lambda$get$1(String str, String str2) {
        Try<U> andThenTry = ReflectionUtils.tryToLoadClass(str).andThenTry(new d());
        Class<T> cls = this.clazz;
        Objects.requireNonNull(cls);
        return andThenTry.andThenTry(new o(cls)).ifSuccess(new e(this, str, str2)).ifFailure(new f(this, str, str2)).toOptional();
    }

    public Optional<T> h(ConfigurationParameters configurationParameters, String str) {
        return configurationParameters.get(str).map(new v()).filter(new b()).flatMap(new c(this, str));
    }
}
