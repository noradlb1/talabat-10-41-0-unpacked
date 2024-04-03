package kotlin.reflect.jvm.internal.impl.storage;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LockBasedStorageManager implements StorageManager {
    public static final StorageManager NO_LOCKS = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.THROW, EmptySimpleLock.INSTANCE) {
        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            String str = i11 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i11 != 1 ? 3 : 2)];
            if (i11 != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i11 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i11 != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String format = String.format(str, objArr);
            throw (i11 != 1 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        @NotNull
        public <K, V> RecursionDetectedResult<V> c(@NotNull String str, K k11) {
            if (str == null) {
                $$$reportNull$$$0(0);
            }
            RecursionDetectedResult<V> fallThrough = RecursionDetectedResult.fallThrough();
            if (fallThrough == null) {
                $$$reportNull$$$0(1);
            }
            return fallThrough;
        }
    };
    private static final String PACKAGE_NAME = StringsKt__StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "");

    /* renamed from: a  reason: collision with root package name */
    public final SimpleLock f24917a;
    private final String debugText;
    /* access modifiers changed from: private */
    public final ExceptionHandlingStrategy exceptionHandlingStrategy;

    public static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            String str = i11 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i11 != 3 ? 3 : 2)];
            if (i11 == 1) {
                objArr[0] = Param.MAP;
            } else if (i11 == 2) {
                objArr[0] = "computation";
            } else if (i11 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i11 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i11 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i11 != 3) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            }
            String format = String.format(str, objArr);
            throw (i11 != 3 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        @NotNull
        public V computeIfAbsent(K k11, @NotNull Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            V computeIfAbsent = super.computeIfAbsent(k11, function0);
            if (computeIfAbsent == null) {
                $$$reportNull$$$0(3);
            }
            return computeIfAbsent;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private CacheWithNotNullValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(concurrentMap);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }
    }

    public static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> implements CacheWithNullableValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            Object[] objArr = new Object[3];
            if (i11 == 1) {
                objArr[0] = Param.MAP;
            } else if (i11 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i11 != 2) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Nullable
        public V computeIfAbsent(K k11, @NotNull Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            return invoke(new KeyWithComputation(k11, function0));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private CacheWithNullableValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, new Function1<KeyWithComputation<K, V>, V>() {
                public V invoke(KeyWithComputation<K, V> keyWithComputation) {
                    return keyWithComputation.computation.invoke();
                }
            });
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }
    }

    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new ExceptionHandlingStrategy() {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"}));
            }

            @NotNull
            public RuntimeException handleException(@NotNull Throwable th2) {
                if (th2 == null) {
                    $$$reportNull$$$0(0);
                }
                throw ExceptionUtilsKt.rethrow(th2);
            }
        };

        @NotNull
        RuntimeException handleException(@NotNull Throwable th2);
    }

    public static class KeyWithComputation<K, V> {
        /* access modifiers changed from: private */
        public final Function0<? extends V> computation;
        private final K key;

        public KeyWithComputation(K k11, Function0<? extends V> function0) {
            this.key = k11;
            this.computation = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass() || !this.key.equals(((KeyWithComputation) obj).key)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    public static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final Function0<? extends T> computable;
        private final LockBasedStorageManager storageManager;
        @Nullable
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            String str = (i11 == 2 || i11 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i11 == 2 || i11 == 3) ? 2 : 3)];
            if (i11 == 1) {
                objArr[0] = "computable";
            } else if (i11 == 2 || i11 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i11 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i11 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (!(i11 == 2 || i11 == 3)) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            }
            String format = String.format(str, objArr);
            throw ((i11 == 2 || i11 == 3) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        public LockBasedLazyValue(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = lockBasedStorageManager;
            this.computable = function0;
        }

        public void a(T t11) {
        }

        @NotNull
        public RecursionDetectedResult<T> b(boolean z11) {
            RecursionDetectedResult<T> c11 = this.storageManager.c("in a lazy value", null);
            if (c11 == null) {
                $$$reportNull$$$0(2);
            }
            return c11;
        }

        public T invoke() {
            T invoke;
            Object obj = this.value;
            if (!(obj instanceof NotValue)) {
                return WrappedValues.unescapeThrowable(obj);
            }
            this.storageManager.f24917a.lock();
            try {
                Object obj2 = this.value;
                if (!(obj2 instanceof NotValue)) {
                    invoke = WrappedValues.unescapeThrowable(obj2);
                } else {
                    NotValue notValue = NotValue.COMPUTING;
                    if (obj2 == notValue) {
                        this.value = NotValue.RECURSION_WAS_DETECTED;
                        RecursionDetectedResult b11 = b(true);
                        if (!b11.isFallThrough()) {
                            invoke = b11.getValue();
                        }
                    }
                    if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                        RecursionDetectedResult b12 = b(false);
                        if (!b12.isFallThrough()) {
                            invoke = b12.getValue();
                        }
                    }
                    this.value = notValue;
                    invoke = this.computable.invoke();
                    a(invoke);
                    this.value = invoke;
                }
                this.storageManager.f24917a.unlock();
                return invoke;
            } catch (Throwable th2) {
                this.storageManager.f24917a.unlock();
                throw th2;
            }
        }

        public boolean isComputed() {
            return (this.value == NotValue.NOT_COMPUTED || this.value == NotValue.COMPUTING) ? false : true;
        }
    }

    public static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {
        @Nullable
        private volatile SingleThreadValue<T> valuePostCompute;

        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            Object[] objArr = new Object[3];
            if (i11 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LockBasedLazyValueWithPostCompute(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.valuePostCompute = null;
        }

        public final void a(T t11) {
            this.valuePostCompute = new SingleThreadValue<>(t11);
            try {
                c(t11);
            } finally {
                this.valuePostCompute = null;
            }
        }

        public abstract void c(T t11);

        public T invoke() {
            SingleThreadValue<T> singleThreadValue = this.valuePostCompute;
            if (singleThreadValue == null || !singleThreadValue.hasValue()) {
                return super.invoke();
            }
            return singleThreadValue.getValue();
        }
    }

    public static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            String str = i11 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i11 != 2 ? 3 : 2)];
            if (i11 == 1) {
                objArr[0] = "computable";
            } else if (i11 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i11 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i11 != 2) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            }
            String format = String.format(str, objArr);
            throw (i11 != 2 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValue(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @NotNull
        public T invoke() {
            T invoke = super.invoke();
            if (invoke == null) {
                $$$reportNull$$$0(2);
            }
            return invoke;
        }
    }

    public static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            String str = i11 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i11 != 2 ? 3 : 2)];
            if (i11 == 1) {
                objArr[0] = "computable";
            } else if (i11 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i11 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i11 != 2) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            }
            String format = String.format(str, objArr);
            throw (i11 != 2 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValueWithPostCompute(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @NotNull
        public T invoke() {
            T invoke = super.invoke();
            if (invoke == null) {
                $$$reportNull$$$0(2);
            }
            return invoke;
        }
    }

    public static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;
        private final LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            String str = (i11 == 3 || i11 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i11 == 3 || i11 == 4) ? 2 : 3)];
            if (i11 == 1) {
                objArr[0] = Param.MAP;
            } else if (i11 == 2) {
                objArr[0] = "compute";
            } else if (i11 == 3 || i11 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i11 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i11 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (!(i11 == 3 || i11 == 4)) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            }
            String format = String.format(str, objArr);
            throw ((i11 == 3 || i11 == 4) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        public MapBasedMemoizedFunction(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
            this.storageManager = lockBasedStorageManager;
            this.cache = concurrentMap;
            this.compute = function1;
        }

        @NotNull
        private AssertionError raceCondition(K k11, Object obj) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Race condition detected on input " + k11 + ". Old value is " + obj + " under " + this.storageManager));
            if (assertionError == null) {
                $$$reportNull$$$0(4);
            }
            return assertionError;
        }

        @NotNull
        public RecursionDetectedResult<V> a(K k11, boolean z11) {
            RecursionDetectedResult<V> c11 = this.storageManager.c("", k11);
            if (c11 == null) {
                $$$reportNull$$$0(3);
            }
            return c11;
        }

        @Nullable
        public V invoke(K k11) {
            V unescapeExceptionOrNull;
            Object obj = this.cache.get(k11);
            if (obj != null && obj != NotValue.COMPUTING) {
                return WrappedValues.unescapeExceptionOrNull(obj);
            }
            this.storageManager.f24917a.lock();
            try {
                Object obj2 = this.cache.get(k11);
                NotValue notValue = NotValue.COMPUTING;
                if (obj2 == notValue) {
                    obj2 = NotValue.RECURSION_WAS_DETECTED;
                    RecursionDetectedResult a11 = a(k11, true);
                    if (!a11.isFallThrough()) {
                        unescapeExceptionOrNull = a11.getValue();
                        this.storageManager.f24917a.unlock();
                        return unescapeExceptionOrNull;
                    }
                }
                if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                    RecursionDetectedResult a12 = a(k11, false);
                    if (!a12.isFallThrough()) {
                        unescapeExceptionOrNull = a12.getValue();
                        this.storageManager.f24917a.unlock();
                        return unescapeExceptionOrNull;
                    }
                }
                if (obj2 != null) {
                    unescapeExceptionOrNull = WrappedValues.unescapeExceptionOrNull(obj2);
                    this.storageManager.f24917a.unlock();
                    return unescapeExceptionOrNull;
                }
                this.cache.put(k11, notValue);
                V invoke = this.compute.invoke(k11);
                Object put = this.cache.put(k11, WrappedValues.escapeNull(invoke));
                if (put == notValue) {
                    this.storageManager.f24917a.unlock();
                    return invoke;
                }
                throw raceCondition(k11, put);
            } catch (Throwable th2) {
                this.storageManager.f24917a.unlock();
                throw th2;
            }
        }

        public boolean isComputed(K k11) {
            Object obj = this.cache.get(k11);
            if (obj == null || obj == NotValue.COMPUTING) {
                return false;
            }
            return true;
        }
    }

    public static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            String str = i11 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i11 != 3 ? 3 : 2)];
            if (i11 == 1) {
                objArr[0] = Param.MAP;
            } else if (i11 == 2) {
                objArr[0] = "compute";
            } else if (i11 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i11 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i11 != 3) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            }
            String format = String.format(str, objArr);
            throw (i11 != 3 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MapBasedMemoizedFunctionToNotNull(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            super(lockBasedStorageManager, concurrentMap, function1);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
        }

        @NotNull
        public V invoke(K k11) {
            V invoke = super.invoke(k11);
            if (invoke == null) {
                $$$reportNull$$$0(3);
            }
            return invoke;
        }
    }

    public enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    public static class RecursionDetectedResult<T> {
        private final boolean fallThrough;
        private final T value;

        private RecursionDetectedResult(T t11, boolean z11) {
            this.value = t11;
            this.fallThrough = z11;
        }

        @NotNull
        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult<>((Object) null, true);
        }

        @NotNull
        public static <T> RecursionDetectedResult<T> value(T t11) {
            return new RecursionDetectedResult<>(t11, false);
        }

        public T getValue() {
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public String toString() {
            return isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.value);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ void $$$reportNull$$$0(int r13) {
        /*
            r0 = 37
            r1 = 20
            r2 = 13
            r3 = 10
            if (r13 == r3) goto L_0x0013
            if (r13 == r2) goto L_0x0013
            if (r13 == r1) goto L_0x0013
            if (r13 == r0) goto L_0x0013
            java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L_0x0015
        L_0x0013:
            java.lang.String r4 = "@NotNull method %s.%s must not return null"
        L_0x0015:
            r5 = 3
            r6 = 2
            if (r13 == r3) goto L_0x0021
            if (r13 == r2) goto L_0x0021
            if (r13 == r1) goto L_0x0021
            if (r13 == r0) goto L_0x0021
            r7 = r5
            goto L_0x0022
        L_0x0021:
            r7 = r6
        L_0x0022:
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r8 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager"
            java.lang.String r9 = "compute"
            r10 = 1
            r11 = 0
            if (r13 == r10) goto L_0x0065
            if (r13 == r5) goto L_0x0065
            r5 = 5
            if (r13 == r5) goto L_0x0065
            r5 = 6
            if (r13 == r5) goto L_0x0060
            switch(r13) {
                case 8: goto L_0x0065;
                case 9: goto L_0x005d;
                case 10: goto L_0x005a;
                case 11: goto L_0x005d;
                case 12: goto L_0x0055;
                case 13: goto L_0x005a;
                case 14: goto L_0x005d;
                case 15: goto L_0x0050;
                case 16: goto L_0x005d;
                case 17: goto L_0x0055;
                case 18: goto L_0x0050;
                case 19: goto L_0x005d;
                case 20: goto L_0x005a;
                case 21: goto L_0x005d;
                case 22: goto L_0x0050;
                case 23: goto L_0x004b;
                case 24: goto L_0x004b;
                case 25: goto L_0x0055;
                case 26: goto L_0x004b;
                case 27: goto L_0x0055;
                case 28: goto L_0x004b;
                case 29: goto L_0x0046;
                case 30: goto L_0x004b;
                case 31: goto L_0x004b;
                case 32: goto L_0x004b;
                case 33: goto L_0x0046;
                case 34: goto L_0x004b;
                case 35: goto L_0x0041;
                case 36: goto L_0x003c;
                case 37: goto L_0x005a;
                default: goto L_0x0037;
            }
        L_0x0037:
            java.lang.String r5 = "debugText"
            r7[r11] = r5
            goto L_0x0069
        L_0x003c:
            java.lang.String r5 = "throwable"
            r7[r11] = r5
            goto L_0x0069
        L_0x0041:
            java.lang.String r5 = "source"
            r7[r11] = r5
            goto L_0x0069
        L_0x0046:
            java.lang.String r5 = "postCompute"
            r7[r11] = r5
            goto L_0x0069
        L_0x004b:
            java.lang.String r5 = "computable"
            r7[r11] = r5
            goto L_0x0069
        L_0x0050:
            java.lang.String r5 = "map"
            r7[r11] = r5
            goto L_0x0069
        L_0x0055:
            java.lang.String r5 = "onRecursiveCall"
            r7[r11] = r5
            goto L_0x0069
        L_0x005a:
            r7[r11] = r8
            goto L_0x0069
        L_0x005d:
            r7[r11] = r9
            goto L_0x0069
        L_0x0060:
            java.lang.String r5 = "lock"
            r7[r11] = r5
            goto L_0x0069
        L_0x0065:
            java.lang.String r5 = "exceptionHandlingStrategy"
            r7[r11] = r5
        L_0x0069:
            java.lang.String r5 = "sanitizeStackTrace"
            java.lang.String r11 = "createMemoizedFunctionWithNullableValues"
            java.lang.String r12 = "createMemoizedFunction"
            if (r13 == r3) goto L_0x0080
            if (r13 == r2) goto L_0x0080
            if (r13 == r1) goto L_0x007d
            if (r13 == r0) goto L_0x007a
            r7[r10] = r8
            goto L_0x0082
        L_0x007a:
            r7[r10] = r5
            goto L_0x0082
        L_0x007d:
            r7[r10] = r11
            goto L_0x0082
        L_0x0080:
            r7[r10] = r12
        L_0x0082:
            switch(r13) {
                case 4: goto L_0x00be;
                case 5: goto L_0x00be;
                case 6: goto L_0x00be;
                case 7: goto L_0x00b9;
                case 8: goto L_0x00b9;
                case 9: goto L_0x00b6;
                case 10: goto L_0x00c2;
                case 11: goto L_0x00b6;
                case 12: goto L_0x00b6;
                case 13: goto L_0x00c2;
                case 14: goto L_0x00b6;
                case 15: goto L_0x00b6;
                case 16: goto L_0x00b6;
                case 17: goto L_0x00b6;
                case 18: goto L_0x00b6;
                case 19: goto L_0x00b3;
                case 20: goto L_0x00c2;
                case 21: goto L_0x00b3;
                case 22: goto L_0x00b3;
                case 23: goto L_0x00ae;
                case 24: goto L_0x00ae;
                case 25: goto L_0x00ae;
                case 26: goto L_0x00a9;
                case 27: goto L_0x00a9;
                case 28: goto L_0x00a4;
                case 29: goto L_0x00a4;
                case 30: goto L_0x009f;
                case 31: goto L_0x009a;
                case 32: goto L_0x0095;
                case 33: goto L_0x0095;
                case 34: goto L_0x0092;
                case 35: goto L_0x008d;
                case 36: goto L_0x008a;
                case 37: goto L_0x00c2;
                default: goto L_0x0085;
            }
        L_0x0085:
            java.lang.String r5 = "createWithExceptionHandling"
            r7[r6] = r5
            goto L_0x00c2
        L_0x008a:
            r7[r6] = r5
            goto L_0x00c2
        L_0x008d:
            java.lang.String r5 = "recursionDetectedDefault"
            r7[r6] = r5
            goto L_0x00c2
        L_0x0092:
            r7[r6] = r9
            goto L_0x00c2
        L_0x0095:
            java.lang.String r5 = "createNullableLazyValueWithPostCompute"
            r7[r6] = r5
            goto L_0x00c2
        L_0x009a:
            java.lang.String r5 = "createRecursionTolerantNullableLazyValue"
            r7[r6] = r5
            goto L_0x00c2
        L_0x009f:
            java.lang.String r5 = "createNullableLazyValue"
            r7[r6] = r5
            goto L_0x00c2
        L_0x00a4:
            java.lang.String r5 = "createLazyValueWithPostCompute"
            r7[r6] = r5
            goto L_0x00c2
        L_0x00a9:
            java.lang.String r5 = "createRecursionTolerantLazyValue"
            r7[r6] = r5
            goto L_0x00c2
        L_0x00ae:
            java.lang.String r5 = "createLazyValue"
            r7[r6] = r5
            goto L_0x00c2
        L_0x00b3:
            r7[r6] = r11
            goto L_0x00c2
        L_0x00b6:
            r7[r6] = r12
            goto L_0x00c2
        L_0x00b9:
            java.lang.String r5 = "replaceExceptionHandling"
            r7[r6] = r5
            goto L_0x00c2
        L_0x00be:
            java.lang.String r5 = "<init>"
            r7[r6] = r5
        L_0x00c2:
            java.lang.String r4 = java.lang.String.format(r4, r7)
            if (r13 == r3) goto L_0x00d4
            if (r13 == r2) goto L_0x00d4
            if (r13 == r1) goto L_0x00d4
            if (r13 == r0) goto L_0x00d4
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r13.<init>(r4)
            goto L_0x00d9
        L_0x00d4:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            r13.<init>(r4)
        L_0x00d9:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.$$$reportNull$$$0(int):void");
    }

    @NotNull
    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* access modifiers changed from: private */
    @NotNull
    public static <T extends Throwable> T sanitizeStackTrace(@NotNull T t11) {
        if (t11 == null) {
            $$$reportNull$$$0(36);
        }
        StackTraceElement[] stackTrace = t11.getStackTrace();
        int length = stackTrace.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            } else if (!stackTrace[i11].getClassName().startsWith(PACKAGE_NAME)) {
                break;
            } else {
                i11++;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i11, length);
        t11.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t11;
    }

    @NotNull
    public <K, V> RecursionDetectedResult<V> c(@NotNull String str, K k11) {
        String str2;
        if (str == null) {
            $$$reportNull$$$0(35);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Recursion detected ");
        sb2.append(str);
        if (k11 == null) {
            str2 = "";
        } else {
            str2 = "on input: " + k11;
        }
        sb2.append(str2);
        sb2.append(" under ");
        sb2.append(this);
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(sb2.toString())));
    }

    public <T> T compute(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(34);
        }
        this.f24917a.lock();
        try {
            T invoke = function0.invoke();
            this.f24917a.unlock();
            return invoke;
        } catch (Throwable th2) {
            this.f24917a.unlock();
            throw th2;
        }
    }

    @NotNull
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    @NotNull
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new CacheWithNullableValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    @NotNull
    public <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(23);
        }
        return new LockBasedNotNullLazyValue(this, function0);
    }

    @NotNull
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, @NotNull Function1<? super T, Unit> function12) {
        if (function0 == null) {
            $$$reportNull$$$0(28);
        }
        if (function12 == null) {
            $$$reportNull$$$0(29);
        }
        final Function1<? super Boolean, ? extends T> function13 = function1;
        final Function1<? super T, Unit> function14 = function12;
        return new LockBasedNotNullLazyValueWithPostCompute<T>(this, function0) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                String str = i11 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                Object[] objArr = new Object[(i11 != 2 ? 2 : 3)];
                if (i11 != 2) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                } else {
                    objArr[0] = "value";
                }
                if (i11 != 2) {
                    objArr[1] = "recursionDetected";
                } else {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                }
                if (i11 == 2) {
                    objArr[2] = "doPostCompute";
                }
                String format = String.format(str, objArr);
                throw (i11 != 2 ? new IllegalStateException(format) : new IllegalArgumentException(format));
            }

            @NotNull
            public RecursionDetectedResult<T> b(boolean z11) {
                Function1 function1 = function13;
                if (function1 == null) {
                    RecursionDetectedResult<T> b11 = super.b(z11);
                    if (b11 == null) {
                        $$$reportNull$$$0(0);
                    }
                    return b11;
                }
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(function1.invoke(Boolean.valueOf(z11)));
                if (value == null) {
                    $$$reportNull$$$0(1);
                }
                return value;
            }

            public void c(@NotNull T t11) {
                if (t11 == null) {
                    $$$reportNull$$$0(2);
                }
                function14.invoke(t11);
            }
        };
    }

    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(9);
        }
        MemoizedFunctionToNotNull<K, V> createMemoizedFunction = createMemoizedFunction(function1, createConcurrentHashMap());
        if (createMemoizedFunction == null) {
            $$$reportNull$$$0(10);
        }
        return createMemoizedFunction;
    }

    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(19);
        }
        MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, createConcurrentHashMap());
        if (createMemoizedFunctionWithNullableValues == null) {
            $$$reportNull$$$0(20);
        }
        return createMemoizedFunctionWithNullableValues;
    }

    @NotNull
    public <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(30);
        }
        return new LockBasedLazyValue(this, function0);
    }

    @NotNull
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> function0, @NotNull final T t11) {
        if (function0 == null) {
            $$$reportNull$$$0(26);
        }
        if (t11 == null) {
            $$$reportNull$$$0(27);
        }
        return new LockBasedNotNullLazyValue<T>(this, function0) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"}));
            }

            @NotNull
            public RecursionDetectedResult<T> b(boolean z11) {
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(t11);
                if (value == null) {
                    $$$reportNull$$$0(0);
                }
                return value;
            }
        };
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.debugText + ")";
    }

    private LockBasedStorageManager(@NotNull String str, @NotNull ExceptionHandlingStrategy exceptionHandlingStrategy2, @NotNull SimpleLock simpleLock) {
        if (str == null) {
            $$$reportNull$$$0(4);
        }
        if (exceptionHandlingStrategy2 == null) {
            $$$reportNull$$$0(5);
        }
        if (simpleLock == null) {
            $$$reportNull$$$0(6);
        }
        this.f24917a = simpleLock;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy2;
        this.debugText = str;
    }

    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(14);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(15);
        }
        return new MapBasedMemoizedFunctionToNotNull(this, concurrentMap, function1);
    }

    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(21);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(22);
        }
        return new MapBasedMemoizedFunction(this, concurrentMap, function1);
    }

    public LockBasedStorageManager(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, Unit>) null);
    }

    public LockBasedStorageManager(String str, @Nullable Runnable runnable, @Nullable Function1<InterruptedException, Unit> function1) {
        this(str, ExceptionHandlingStrategy.THROW, (SimpleLock) SimpleLock.Companion.simpleLock(runnable, function1));
    }
}
