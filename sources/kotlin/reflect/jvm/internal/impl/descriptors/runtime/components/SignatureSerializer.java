package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

final class SignatureSerializer {
    @NotNull
    public static final SignatureSerializer INSTANCE = new SignatureSerializer();

    private SignatureSerializer() {
    }

    @NotNull
    public final String constructorDesc(@NotNull Constructor<?> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class[] parameterTypes = constructor.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
        for (Class cls : parameterTypes) {
            Intrinsics.checkNotNullExpressionValue(cls, "parameterType");
            sb2.append(ReflectClassUtilKt.getDesc(cls));
        }
        sb2.append(")V");
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        return sb3;
    }

    @NotNull
    public final String fieldDesc(@NotNull Field field) {
        Intrinsics.checkNotNullParameter(field, "field");
        Class<?> type = field.getType();
        Intrinsics.checkNotNullExpressionValue(type, "field.type");
        return ReflectClassUtilKt.getDesc(type);
    }

    @NotNull
    public final String methodDesc(@NotNull Method method) {
        Intrinsics.checkNotNullParameter(method, "method");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
        for (Class cls : parameterTypes) {
            Intrinsics.checkNotNullExpressionValue(cls, "parameterType");
            sb2.append(ReflectClassUtilKt.getDesc(cls));
        }
        sb2.append(")");
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
        sb2.append(ReflectClassUtilKt.getDesc(returnType));
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        return sb3;
    }
}
