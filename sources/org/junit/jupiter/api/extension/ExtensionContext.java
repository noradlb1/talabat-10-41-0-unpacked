package org.junit.jupiter.api.extension;

import j$.util.Optional;
import j$.util.function.Function;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.commons.util.Preconditions;

@API(since = "5.0", status = API.Status.STABLE)
public interface ExtensionContext {

    public static class Namespace {
        public static final Namespace GLOBAL = create(new Object());
        private final List<Object> parts;

        private Namespace(List<Object> list) {
            this.parts = list;
        }

        public static Namespace create(Object... objArr) {
            Preconditions.notEmpty((T[]) objArr, "parts array must not be null or empty");
            Preconditions.containsNoNullElements((T[]) objArr, "individual parts must not be null");
            return new Namespace(new ArrayList(Arrays.asList(objArr)));
        }

        @API(since = "5.8", status = API.Status.EXPERIMENTAL)
        public Namespace append(Object... objArr) {
            Preconditions.notEmpty((T[]) objArr, "parts array must not be null or empty");
            Preconditions.containsNoNullElements((T[]) objArr, "individual parts must not be null");
            ArrayList arrayList = new ArrayList(this.parts.size() + objArr.length);
            arrayList.addAll(this.parts);
            Collections.addAll(arrayList, objArr);
            return new Namespace(arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.parts.equals(((Namespace) obj).parts);
        }

        public int hashCode() {
            return this.parts.hashCode();
        }
    }

    public interface Store {

        @API(since = "5.1", status = API.Status.STABLE)
        public interface CloseableResource {
            void close() throws Throwable;
        }

        Object get(Object obj);

        <V> V get(Object obj, Class<V> cls);

        @API(since = "5.1", status = API.Status.STABLE)
        <V> V getOrComputeIfAbsent(Class<V> cls);

        <K, V> Object getOrComputeIfAbsent(K k11, Function<K, V> function);

        <K, V> V getOrComputeIfAbsent(K k11, Function<K, V> function, Class<V> cls);

        @API(since = "5.5", status = API.Status.STABLE)
        <V> V getOrDefault(Object obj, Class<V> cls, V v11);

        void put(Object obj, Object obj2);

        Object remove(Object obj);

        <V> V remove(Object obj, Class<V> cls);
    }

    @API(since = "5.1", status = API.Status.STABLE)
    Optional<String> getConfigurationParameter(String str);

    @API(since = "5.7", status = API.Status.EXPERIMENTAL)
    <T> Optional<T> getConfigurationParameter(String str, Function<String, T> function);

    String getDisplayName();

    Optional<AnnotatedElement> getElement();

    @API(since = "5.9", status = API.Status.EXPERIMENTAL)
    ExecutableInvoker getExecutableInvoker();

    Optional<Throwable> getExecutionException();

    @API(since = "5.8.1", status = API.Status.STABLE)
    ExecutionMode getExecutionMode();

    Optional<ExtensionContext> getParent();

    Class<?> getRequiredTestClass();

    Object getRequiredTestInstance();

    @API(since = "5.7", status = API.Status.STABLE)
    TestInstances getRequiredTestInstances();

    Method getRequiredTestMethod();

    ExtensionContext getRoot();

    Store getStore(Namespace namespace);

    Set<String> getTags();

    Optional<Class<?>> getTestClass();

    Optional<Object> getTestInstance();

    @API(since = "5.1", status = API.Status.STABLE)
    Optional<TestInstance.Lifecycle> getTestInstanceLifecycle();

    @API(since = "5.7", status = API.Status.STABLE)
    Optional<TestInstances> getTestInstances();

    Optional<Method> getTestMethod();

    String getUniqueId();

    @API(since = "5.3", status = API.Status.STABLE)
    void publishReportEntry(String str);

    void publishReportEntry(String str, String str2);

    void publishReportEntry(Map<String, String> map);
}
