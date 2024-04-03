package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaMethod extends ReflectJavaMember implements JavaMethod {
    @NotNull
    private final Method member;

    public ReflectJavaMethod(@NotNull Method method) {
        Intrinsics.checkNotNullParameter(method, "member");
        this.member = method;
    }

    @Nullable
    public JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        Object defaultValue = getMember().getDefaultValue();
        if (defaultValue != null) {
            return ReflectJavaAnnotationArgument.Factory.create(defaultValue, (Name) null);
        }
        return null;
    }

    public boolean getHasAnnotationParameterDefaultValue() {
        return JavaMethod.DefaultImpls.getHasAnnotationParameterDefaultValue(this);
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
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "member.parameterAnnotations");
        return a(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }

    @NotNull
    public Method getMember() {
        return this.member;
    }

    @NotNull
    public ReflectJavaType getReturnType() {
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        Type genericReturnType = getMember().getGenericReturnType();
        Intrinsics.checkNotNullExpressionValue(genericReturnType, "member.genericReturnType");
        return factory.create(genericReturnType);
    }
}
