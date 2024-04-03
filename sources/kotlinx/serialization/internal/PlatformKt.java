package kotlinx.serialization.internal;

import com.braze.ui.actions.brazeactions.steps.StepData;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0002¢\u0006\u0002\u0010\b\u001a\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0000\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a$\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000\u001aM\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00052\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\b\u001aM\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\f2\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\u0010\u001a$\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a$\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a&\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\b¢\u0006\u0002\u0010\u0016\u001a\u0015\u0010\u0013\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\b\u001a$\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0018\u0010\u0019\u001a\u00020\n*\u00020\u00032\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\fH\u0000\u001a\u001c\u0010\u001b\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u001d*\u0006\u0012\u0002\b\u00030\fH\u0000\u001a$\u0010\u001e\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0010\u0010\u001f\u001a\u00020\u001d*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001aK\u0010 \u001a\b\u0012\u0004\u0012\u0002H!0\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010!*\u0004\u0018\u0001H\u0002*\u0012\u0012\u0004\u0012\u0002H!0\"j\b\u0012\u0004\u0012\u0002H!`#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"invokeSerializerOnCompanion", "Lkotlinx/serialization/KSerializer;", "T", "", "jClass", "Ljava/lang/Class;", "args", "", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "isReferenceArray", "", "rootClass", "Lkotlin/reflect/KClass;", "companionOrNull", "compiledSerializerImpl", "constructSerializerForGivenTypeArgs", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "createEnumSerializer", "findObjectSerializer", "getChecked", "index", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "interfaceSerializer", "isInstanceOf", "kclass", "isNotAnnotated", "platformSpecificSerializerNotRegistered", "", "polymorphicSerializer", "serializerNotRegistered", "toNativeArrayImpl", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PlatformKt {
    private static final Object companionOrNull(Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static final <T> KSerializer<T> compiledSerializerImpl(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return constructSerializerForGivenTypeArgs(kClass, (KSerializer<Object>[]) new KSerializer[0]);
    }

    @Nullable
    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(@NotNull KClass<T> kClass, @NotNull KSerializer<Object>... kSerializerArr) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(kSerializerArr, StepData.ARGS);
        return constructSerializerForGivenTypeArgs(JvmClassMappingKt.getJavaClass(kClass), (KSerializer<Object>[]) (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    private static final <T> KSerializer<T> createEnumSerializer(Class<T> cls) {
        Object[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "canonicalName");
        if (enumConstants != null) {
            return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r5 == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0094, code lost:
        if (r5 == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0096, code lost:
        r6 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0091 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> kotlinx.serialization.KSerializer<T> findObjectSerializer(java.lang.Class<T> r11) {
        /*
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r1 = "declaredFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r6 = r2
            r4 = r3
            r5 = r4
        L_0x000f:
            r7 = 1
            if (r4 >= r1) goto L_0x0041
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x0036
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r9 == 0) goto L_0x0036
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L_0x0036
            r9 = r7
            goto L_0x0037
        L_0x0036:
            r9 = r3
        L_0x0037:
            if (r9 == 0) goto L_0x003e
            if (r5 == 0) goto L_0x003c
            goto L_0x0043
        L_0x003c:
            r5 = r7
            r6 = r8
        L_0x003e:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0041:
            if (r5 != 0) goto L_0x0044
        L_0x0043:
            r6 = r2
        L_0x0044:
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            if (r6 != 0) goto L_0x0049
            return r2
        L_0x0049:
            java.lang.Object r0 = r6.get(r2)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r1 = "methods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            int r1 = r11.length
            r6 = r2
            r4 = r3
            r5 = r4
        L_0x005a:
            if (r4 >= r1) goto L_0x0094
            r8 = r11[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "serializer"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x0089
            java.lang.Class[] r9 = r8.getParameterTypes()
            java.lang.String r10 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            int r9 = r9.length
            if (r9 != 0) goto L_0x0078
            r9 = r7
            goto L_0x0079
        L_0x0078:
            r9 = r3
        L_0x0079:
            if (r9 == 0) goto L_0x0089
            java.lang.Class r9 = r8.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r10 = kotlinx.serialization.KSerializer.class
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x0089
            r9 = r7
            goto L_0x008a
        L_0x0089:
            r9 = r3
        L_0x008a:
            if (r9 == 0) goto L_0x0091
            if (r5 == 0) goto L_0x008f
            goto L_0x0096
        L_0x008f:
            r5 = r7
            r6 = r8
        L_0x0091:
            int r4 = r4 + 1
            goto L_0x005a
        L_0x0094:
            if (r5 != 0) goto L_0x0097
        L_0x0096:
            r6 = r2
        L_0x0097:
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto L_0x009c
            return r2
        L_0x009c:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.Object r11 = r6.invoke(r0, r11)
            boolean r0 = r11 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto L_0x00a9
            r2 = r11
            kotlinx.serialization.KSerializer r2 = (kotlinx.serialization.KSerializer) r2
        L_0x00a9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.findObjectSerializer(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    public static final <T> T getChecked(@NotNull T[] tArr, int i11) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[i11];
    }

    private static final <T> KSerializer<T> interfaceSerializer(Class<T> cls) {
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable == null || Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(serializable.with()), (Object) Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(cls));
        }
        return null;
    }

    private static final <T> KSerializer<T> invokeSerializerOnCompanion(Class<?> cls, KSerializer<Object>... kSerializerArr) {
        boolean z11;
        Class[] clsArr;
        Object companionOrNull = companionOrNull(cls);
        if (companionOrNull == null) {
            return null;
        }
        try {
            if (kSerializerArr.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i11 = 0; i11 < length; i11++) {
                    clsArr2[i11] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = companionOrNull.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(companionOrNull, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (invoke instanceof KSerializer) {
                return (KSerializer) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause != null) {
                String message = cause.getMessage();
                if (message == null) {
                    message = e11.getMessage();
                }
                throw new InvocationTargetException(cause, message);
            }
            throw e11;
        }
    }

    public static final boolean isInstanceOf(@NotNull Object obj, @NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kclass");
        return JvmClassMappingKt.getJavaObjectType(kClass).isInstance(obj);
    }

    private static final <T> boolean isNotAnnotated(Class<T> cls) {
        if (cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null) {
            return true;
        }
        return false;
    }

    public static final boolean isReferenceArray(@NotNull KClass<Object> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "rootClass");
        return JvmClassMappingKt.getJavaClass(kClass).isArray();
    }

    @NotNull
    public static final Void platformSpecificSerializerNotRegistered(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    private static final <T> KSerializer<T> polymorphicSerializer(Class<T> cls) {
        if (cls.getAnnotation(Polymorphic.class) != null) {
            return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(cls));
        }
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(serializable.with()), (Object) Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return null;
        }
        return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(cls));
    }

    @NotNull
    public static final Void serializerNotRegistered(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        throw new SerializationException("Serializer for class '" + cls.getSimpleName() + "' is not found.\nMark the class as @Serializable or provide the serializer explicitly.");
    }

    @NotNull
    public static final <T, E extends T> E[] toNativeArrayImpl(@NotNull ArrayList<E> arrayList, @NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "eClass");
        Object newInstance = Array.newInstance(JvmClassMappingKt.getJavaClass(kClass), arrayList.size());
        if (newInstance != null) {
            E[] array = arrayList.toArray((Object[]) newInstance);
            Intrinsics.checkNotNullExpressionValue(array, "toArray(java.lang.reflec….java, size) as Array<E>)");
            return array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r3 == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        r0 = r4.getField("INSTANCE");
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlinx.serialization.KSerializer<T> constructSerializerForGivenTypeArgs(@org.jetbrains.annotations.NotNull java.lang.Class<T> r8, @org.jetbrains.annotations.NotNull kotlinx.serialization.KSerializer<java.lang.Object>... r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r8.isEnum()
            if (r0 == 0) goto L_0x001b
            boolean r0 = isNotAnnotated(r8)
            if (r0 == 0) goto L_0x001b
            kotlinx.serialization.KSerializer r8 = createEnumSerializer(r8)
            return r8
        L_0x001b:
            boolean r0 = r8.isInterface()
            if (r0 == 0) goto L_0x0026
            kotlinx.serialization.KSerializer r8 = interfaceSerializer(r8)
            return r8
        L_0x0026:
            int r0 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r0)
            kotlinx.serialization.KSerializer[] r9 = (kotlinx.serialization.KSerializer[]) r9
            kotlinx.serialization.KSerializer r9 = invokeSerializerOnCompanion(r8, r9)
            if (r9 == 0) goto L_0x0034
            return r9
        L_0x0034:
            kotlinx.serialization.KSerializer r9 = findObjectSerializer(r8)
            if (r9 == 0) goto L_0x003b
            return r9
        L_0x003b:
            r9 = 0
            java.lang.Class[] r0 = r8.getDeclaredClasses()     // Catch:{ NoSuchFieldException -> 0x007d }
            java.lang.String r1 = "declaredClasses"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ NoSuchFieldException -> 0x007d }
            int r1 = r0.length     // Catch:{ NoSuchFieldException -> 0x007d }
            r2 = 0
            r4 = r9
            r3 = r2
        L_0x0049:
            if (r2 >= r1) goto L_0x0061
            r5 = r0[r2]     // Catch:{ NoSuchFieldException -> 0x007d }
            java.lang.String r6 = r5.getSimpleName()     // Catch:{ NoSuchFieldException -> 0x007d }
            java.lang.String r7 = "$serializer"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ NoSuchFieldException -> 0x007d }
            if (r6 == 0) goto L_0x005e
            if (r3 == 0) goto L_0x005c
            goto L_0x0063
        L_0x005c:
            r3 = 1
            r4 = r5
        L_0x005e:
            int r2 = r2 + 1
            goto L_0x0049
        L_0x0061:
            if (r3 != 0) goto L_0x0064
        L_0x0063:
            r4 = r9
        L_0x0064:
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ NoSuchFieldException -> 0x007d }
            if (r4 == 0) goto L_0x0075
            java.lang.String r0 = "INSTANCE"
            java.lang.reflect.Field r0 = r4.getField(r0)     // Catch:{ NoSuchFieldException -> 0x007d }
            if (r0 == 0) goto L_0x0075
            java.lang.Object r0 = r0.get(r9)     // Catch:{ NoSuchFieldException -> 0x007d }
            goto L_0x0076
        L_0x0075:
            r0 = r9
        L_0x0076:
            boolean r1 = r0 instanceof kotlinx.serialization.KSerializer     // Catch:{ NoSuchFieldException -> 0x007d }
            if (r1 == 0) goto L_0x007d
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0     // Catch:{ NoSuchFieldException -> 0x007d }
            r9 = r0
        L_0x007d:
            if (r9 == 0) goto L_0x0080
            return r9
        L_0x0080:
            kotlinx.serialization.KSerializer r8 = polymorphicSerializer(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.constructSerializerForGivenTypeArgs(java.lang.Class, kotlinx.serialization.KSerializer[]):kotlinx.serialization.KSerializer");
    }

    public static final boolean getChecked(@NotNull boolean[] zArr, int i11) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[i11];
    }
}
