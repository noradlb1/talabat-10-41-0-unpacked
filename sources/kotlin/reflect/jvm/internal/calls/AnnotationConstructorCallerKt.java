package kotlin.reflect.jvm.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014²\u0006\u0014\u0010\u0015\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u0002²\u0006\u0014\u0010\u0016\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u0002"}, d2 = {"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AnnotationConstructorCallerKt {
    @NotNull
    public static final <T> T createAnnotationInstance(@NotNull Class<T> cls, @NotNull Map<String, ? extends Object> map, @NotNull List<Method> list) {
        Intrinsics.checkNotNullParameter(cls, "annotationClass");
        Intrinsics.checkNotNullParameter(map, "values");
        Intrinsics.checkNotNullParameter(list, "methods");
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(map));
        Lazy lazy2 = LazyKt__LazyJVMKt.lazy(new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(cls, map));
        T newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new AnnotationConstructorCallerKt$createAnnotationInstance$result$1(cls, map, lazy2, lazy, list));
        Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return newProxyInstance;
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class cls, Map map, List list, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            Set<String> keySet = map.keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10));
            for (String declaredMethod : keySet) {
                arrayList.add(cls.getDeclaredMethod(declaredMethod, new Class[0]));
            }
            list = arrayList;
        }
        return createAnnotationInstance(cls, map, list);
    }

    /* access modifiers changed from: private */
    public static final <T> boolean createAnnotationInstance$equals(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object obj) {
        Annotation annotation;
        boolean z11;
        boolean z12;
        KClass annotationClass;
        Class cls2 = null;
        if (obj instanceof Annotation) {
            annotation = (Annotation) obj;
        } else {
            annotation = null;
        }
        if (!(annotation == null || (annotationClass = JvmClassMappingKt.getAnnotationClass(annotation)) == null)) {
            cls2 = JvmClassMappingKt.getJavaClass(annotationClass);
        }
        if (!Intrinsics.areEqual((Object) cls2, (Object) cls)) {
            return false;
        }
        Iterable iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Method method = (Method) it.next();
                Object obj2 = map.get(method.getName());
                Object invoke = method.invoke(obj, new Object[0]);
                if (obj2 instanceof boolean[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                    z12 = Arrays.equals((boolean[]) obj2, (boolean[]) invoke);
                    continue;
                } else if (obj2 instanceof char[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.CharArray");
                    z12 = Arrays.equals((char[]) obj2, (char[]) invoke);
                    continue;
                } else if (obj2 instanceof byte[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
                    z12 = Arrays.equals((byte[]) obj2, (byte[]) invoke);
                    continue;
                } else if (obj2 instanceof short[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.ShortArray");
                    z12 = Arrays.equals((short[]) obj2, (short[]) invoke);
                    continue;
                } else if (obj2 instanceof int[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.IntArray");
                    z12 = Arrays.equals((int[]) obj2, (int[]) invoke);
                    continue;
                } else if (obj2 instanceof float[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.FloatArray");
                    z12 = Arrays.equals((float[]) obj2, (float[]) invoke);
                    continue;
                } else if (obj2 instanceof long[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.LongArray");
                    z12 = Arrays.equals((long[]) obj2, (long[]) invoke);
                    continue;
                } else if (obj2 instanceof double[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                    z12 = Arrays.equals((double[]) obj2, (double[]) invoke);
                    continue;
                } else if (obj2 instanceof Object[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
                    z12 = Arrays.equals((Object[]) obj2, (Object[]) invoke);
                    continue;
                } else {
                    z12 = Intrinsics.areEqual((Object) obj2, invoke);
                    continue;
                }
                if (!z12) {
                    z11 = false;
                    break;
                }
            }
        }
        z11 = true;
        if (z11) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: createAnnotationInstance$lambda-2  reason: not valid java name */
    public static final int m7566createAnnotationInstance$lambda2(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: createAnnotationInstance$lambda-3  reason: not valid java name */
    public static final String m7567createAnnotationInstance$lambda3(Lazy<String> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    public static final Void throwIllegalArgumentType(int i11, String str, Class<?> cls) {
        KClass<?> kClass;
        String str2;
        Class<Class> cls2 = Class.class;
        if (Intrinsics.areEqual((Object) cls, (Object) cls2)) {
            kClass = Reflection.getOrCreateKotlinClass(KClass.class);
        } else if (!cls.isArray() || !Intrinsics.areEqual((Object) cls.getComponentType(), (Object) cls2)) {
            kClass = JvmClassMappingKt.getKotlinClass(cls);
        } else {
            kClass = Reflection.getOrCreateKotlinClass(KClass[].class);
        }
        if (Intrinsics.areEqual((Object) kClass.getQualifiedName(), (Object) Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(kClass.getQualifiedName());
            sb2.append(Typography.less);
            Class<?> componentType = JvmClassMappingKt.getJavaClass(kClass).getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "kotlinClass.java.componentType");
            sb2.append(JvmClassMappingKt.getKotlinClass(componentType).getQualifiedName());
            sb2.append(Typography.greater);
            str2 = sb2.toString();
        } else {
            str2 = kClass.getQualifiedName();
        }
        throw new IllegalArgumentException("Argument #" + i11 + ' ' + str + " is not of the required type " + str2);
    }

    /* access modifiers changed from: private */
    public static final Object transformKotlinToJvm(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof KClass) {
            obj = JvmClassMappingKt.getJavaClass((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass javaClass : kClassArr) {
                    arrayList.add(JvmClassMappingKt.getJavaClass(javaClass));
                }
                obj = arrayList.toArray(new Class[0]);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
