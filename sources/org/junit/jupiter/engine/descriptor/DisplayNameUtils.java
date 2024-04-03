package org.junit.jupiter.engine.descriptor;

import d30.h0;
import j$.util.Optional;
import j$.util.function.Supplier;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Objects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;
import x20.o;
import x20.w;

final class DisplayNameUtils {
    private static final DisplayNameGenerator indicativeSentencesGenerator = o.a(DisplayNameGenerator.IndicativeSentences.class);
    private static final Logger logger = LoggerFactory.getLogger(DisplayNameUtils.class);
    private static final DisplayNameGenerator replaceUnderscoresGenerator = o.a(DisplayNameGenerator.ReplaceUnderscores.class);
    private static final DisplayNameGenerator simpleGenerator = o.a(DisplayNameGenerator.Simple.class);
    private static final DisplayNameGenerator standardGenerator = o.a(DisplayNameGenerator.Standard.class);

    public static Supplier<String> f(Class<?> cls, JupiterConfiguration jupiterConfiguration) {
        return new f(cls, jupiterConfiguration);
    }

    public static Supplier<String> g(Class<?> cls, JupiterConfiguration jupiterConfiguration) {
        return new j(cls, jupiterConfiguration);
    }

    private static DisplayNameGenerator getDisplayNameGenerator(Class<?> cls, JupiterConfiguration jupiterConfiguration) {
        Preconditions.notNull(cls, "Test class must not be null");
        Optional<U> map = AnnotationUtils.findAnnotation(cls, DisplayNameGeneration.class, true).map(new w()).map(new i());
        Objects.requireNonNull(jupiterConfiguration);
        return (DisplayNameGenerator) map.orElseGet(new h0(jupiterConfiguration));
    }

    public static String h(AnnotatedElement annotatedElement, Supplier<String> supplier) {
        Preconditions.notNull(annotatedElement, "Annotated element must not be null");
        Optional<A> findAnnotation = AnnotationUtils.findAnnotation(annotatedElement, DisplayName.class);
        if (findAnnotation.isPresent()) {
            String trim = ((DisplayName) findAnnotation.get()).value().trim();
            if (!StringUtils.isBlank(trim)) {
                return trim;
            }
            logger.warn(new g(annotatedElement));
        }
        return supplier.get();
    }

    public static String i(Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration) {
        return h(method, new h(getDisplayNameGenerator(cls, jupiterConfiguration), cls, method));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ DisplayNameGenerator lambda$getDisplayNameGenerator$4(Class cls) {
        if (cls == DisplayNameGenerator.Standard.class) {
            return standardGenerator;
        }
        if (cls == DisplayNameGenerator.Simple.class) {
            return simpleGenerator;
        }
        if (cls == DisplayNameGenerator.ReplaceUnderscores.class) {
            return replaceUnderscoresGenerator;
        }
        if (cls == DisplayNameGenerator.IndicativeSentences.class) {
            return indicativeSentencesGenerator;
        }
        return (DisplayNameGenerator) ReflectionUtils.newInstance(cls, new Object[0]);
    }
}
