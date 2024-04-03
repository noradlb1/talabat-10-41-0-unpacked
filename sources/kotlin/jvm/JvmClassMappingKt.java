package kotlin.jvm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u001f\u001a\u00020 \"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0014*\u0006\u0012\u0002\b\u00030!¢\u0006\u0002\u0010\"\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"5\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u0002H\b8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"-\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0015\";\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"+\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012\"-\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012\"+\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "Ljava/lang/Class;", "E", "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "java", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "JvmClassMappingKt")
public final class JvmClassMappingKt {
    @NotNull
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Class<? extends Annotation> annotationType = t11.annotationType();
        Intrinsics.checkNotNullExpressionValue(annotationType, "this as java.lang.annota…otation).annotationType()");
        KClass<? extends T> kotlinClass = getKotlinClass(annotationType);
        Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return kotlinClass;
    }

    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(E e11) {
        Intrinsics.checkNotNullParameter(e11, "<this>");
        Class<E> declaringClass = e11.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "this as java.lang.Enum<E>).declaringClass");
        return declaringClass;
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    public static /* synthetic */ void getDeclaringJavaClass$annotations(Enum enumR) {
    }

    @NotNull
    @JvmName(name = "getJavaClass")
    public static final <T> Class<T> getJavaClass(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return jClass;
    }

    public static /* synthetic */ void getJavaClass$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Class<T> getJavaObjectType(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!jClass.isPrimitive()) {
            Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return jClass;
        }
        String name2 = jClass.getName();
        switch (name2.hashCode()) {
            case -1325958191:
                if (name2.equals("double")) {
                    jClass = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name2.equals("int")) {
                    jClass = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name2.equals("byte")) {
                    jClass = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name2.equals("char")) {
                    jClass = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name2.equals(Constants.LONG)) {
                    jClass = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name2.equals("void")) {
                    jClass = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name2.equals(TypedValues.Custom.S_BOOLEAN)) {
                    jClass = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name2.equals(TypedValues.Custom.S_FLOAT)) {
                    jClass = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name2.equals("short")) {
                    jClass = Short.class;
                    break;
                }
                break;
        }
        Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return jClass;
    }

    @Nullable
    public static final <T> Class<T> getJavaPrimitiveType(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (jClass.isPrimitive()) {
            Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return jClass;
        }
        String name2 = jClass.getName();
        switch (name2.hashCode()) {
            case -2056817302:
                if (name2.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                break;
            case -527879800:
                if (name2.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                break;
            case -515992664:
                if (name2.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                break;
            case 155276373:
                if (name2.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                break;
            case 344809556:
                if (name2.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                break;
            case 398507100:
                if (name2.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                break;
            case 398795216:
                if (name2.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                break;
            case 399092968:
                if (name2.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                break;
            case 761287205:
                if (name2.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                break;
        }
        return null;
    }

    @NotNull
    @JvmName(name = "getKotlinClass")
    public static final <T> KClass<T> getKotlinClass(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Reflection.getOrCreateKotlinClass(cls);
    }

    @NotNull
    @JvmName(name = "getRuntimeClassOfKClassInstance")
    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class<?> cls = kClass.getClass();
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return cls;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(KClass kClass) {
    }

    public static final /* synthetic */ boolean isArrayOf(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Class<?> cls = t11.getClass();
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return cls;
    }
}
