package org.junit.jupiter.api;

import j$.util.Optional;
import j$.util.function.Predicate;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.support.ModifierSupport;
import org.junit.platform.commons.util.AnnotationUtils;
import x20.o;
import x20.p;
import x20.q;
import x20.r;
import x20.s;
import x20.t;
import x20.u;
import x20.v;
import x20.w;
import x20.x;

@API(since = "5.7", status = API.Status.STABLE)
public interface DisplayNameGenerator {
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_GENERATOR_PROPERTY_NAME = "junit.jupiter.displayname.generator.default";

    @API(since = "5.7", status = API.Status.EXPERIMENTAL)
    public static class IndicativeSentences implements DisplayNameGenerator {

        /* renamed from: a  reason: collision with root package name */
        public static final DisplayNameGenerator f57101a = new IndicativeSentences();

        private static Optional<DisplayNameGeneration> findDisplayNameGeneration(Class<?> cls) {
            return AnnotationUtils.findAnnotation(cls, DisplayNameGeneration.class, true);
        }

        private static Optional<IndicativeSentencesGeneration> findIndicativeSentencesGeneration(Class<?> cls) {
            return AnnotationUtils.findAnnotation(cls, IndicativeSentencesGeneration.class, true);
        }

        private static String getFragmentSeparator(Class<?> cls) {
            return (String) findIndicativeSentencesGeneration(cls).map(new t()).orElse(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        }

        private static DisplayNameGenerator getGeneratorFor(Class<?> cls) {
            return (DisplayNameGenerator) findIndicativeSentencesGeneration(cls).map(new q()).filter(not(IndicativeSentences.class)).map(new r()).orElseGet(new s());
        }

        private String getSentenceBeginning(Class<?> cls) {
            boolean z11;
            String str;
            Class<?> enclosingClass = cls.getEnclosingClass();
            if (enclosingClass == null || ModifierSupport.isStatic(cls)) {
                z11 = true;
            } else {
                z11 = false;
            }
            Optional<U> map = AnnotationUtils.findAnnotation((AnnotatedElement) cls, DisplayName.class).map(new u()).map(new v());
            Class cls2 = IndicativeSentences.class;
            if (!z11) {
                if (findDisplayNameGeneration(enclosingClass).map(new w()).filter(new p(cls2)).isPresent()) {
                    str = getSentenceBeginning(enclosingClass) + getFragmentSeparator(cls);
                } else {
                    str = "";
                }
                return str + ((String) map.orElseGet(new x(cls)));
            } else if (map.isPresent()) {
                return (String) map.get();
            } else {
                Class cls3 = (Class) findDisplayNameGeneration(cls).map(new w()).filter(not(cls2)).orElse(null);
                if (cls3 != null) {
                    return o.a(cls3).generateDisplayNameForClass(cls);
                }
                return generateDisplayNameForClass(cls);
            }
        }

        private static Predicate<Class<?>> not(Class<?> cls) {
            Objects.requireNonNull(cls);
            return new p(cls).negate();
        }

        public String generateDisplayNameForClass(Class<?> cls) {
            return getGeneratorFor(cls).generateDisplayNameForClass(cls);
        }

        public String generateDisplayNameForMethod(Class<?> cls, Method method) {
            return getSentenceBeginning(cls) + getFragmentSeparator(cls) + getGeneratorFor(cls).generateDisplayNameForMethod(cls, method);
        }

        public String generateDisplayNameForNestedClass(Class<?> cls) {
            return getSentenceBeginning(cls);
        }
    }

    public static class ReplaceUnderscores extends Simple {

        /* renamed from: c  reason: collision with root package name */
        public static final DisplayNameGenerator f57102c = new ReplaceUnderscores();

        private static String replaceUnderscores(String str) {
            return str.replace('_', ' ');
        }

        public String generateDisplayNameForClass(Class<?> cls) {
            return replaceUnderscores(super.generateDisplayNameForClass(cls));
        }

        public String generateDisplayNameForMethod(Class<?> cls, Method method) {
            return replaceUnderscores(super.generateDisplayNameForMethod(cls, method));
        }

        public String generateDisplayNameForNestedClass(Class<?> cls) {
            return replaceUnderscores(super.generateDisplayNameForNestedClass(cls));
        }
    }

    public static class Simple extends Standard {

        /* renamed from: b  reason: collision with root package name */
        public static final DisplayNameGenerator f57103b = new Simple();

        private static boolean hasParameters(Method method) {
            return method.getParameterCount() > 0;
        }

        public String generateDisplayNameForMethod(Class<?> cls, Method method) {
            String name2 = method.getName();
            if (!hasParameters(method)) {
                return name2;
            }
            return name2 + ' ' + o.b(method);
        }
    }

    public static class Standard implements DisplayNameGenerator {

        /* renamed from: a  reason: collision with root package name */
        public static final DisplayNameGenerator f57104a = new Standard();

        public String generateDisplayNameForClass(Class<?> cls) {
            String name2 = cls.getName();
            return name2.substring(name2.lastIndexOf(46) + 1);
        }

        public String generateDisplayNameForMethod(Class<?> cls, Method method) {
            return method.getName() + o.b(method);
        }

        public String generateDisplayNameForNestedClass(Class<?> cls) {
            return cls.getSimpleName();
        }
    }

    String generateDisplayNameForClass(Class<?> cls);

    String generateDisplayNameForMethod(Class<?> cls, Method method);

    String generateDisplayNameForNestedClass(Class<?> cls);
}
