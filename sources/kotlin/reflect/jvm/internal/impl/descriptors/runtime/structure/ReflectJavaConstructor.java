package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    @NotNull
    private final Constructor<?> member;

    public ReflectJavaConstructor(@NotNull Constructor<?> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "member");
        this.member = constructor;
    }

    @NotNull
    public Constructor<?> getMember() {
        return this.member;
    }

    @NotNull
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable[] typeParameters = getMember().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable reflectJavaTypeParameter : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(reflectJavaTypeParameter));
        }
        return arrayList;
    }

    @NotNull
    public List<JavaValueParameter> getValueParameters() {
        boolean z11;
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Class<?> declaringClass = getMember().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) ArraysKt___ArraysJvmKt.copyOfRange((T[]) genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        if (parameterAnnotations.length >= genericParameterTypes.length) {
            if (parameterAnnotations.length > genericParameterTypes.length) {
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "annotations");
                parameterAnnotations = (Annotation[][]) ArraysKt___ArraysJvmKt.copyOfRange((T[]) parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
            }
            Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "realTypes");
            Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "realAnnotations");
            return a(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
        }
        throw new IllegalStateException("Illegal generic signature: " + getMember());
    }
}
