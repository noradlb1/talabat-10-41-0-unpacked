package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClassifierType extends ReflectJavaType implements JavaClassifierType {
    @NotNull
    private final JavaClassifier classifier;
    @NotNull
    private final Type reflectType;

    public ReflectJavaClassifierType(@NotNull Type type) {
        JavaClassifier javaClassifier;
        Intrinsics.checkNotNullParameter(type, "reflectType");
        this.reflectType = type;
        Type reflectType2 = getReflectType();
        if (reflectType2 instanceof Class) {
            javaClassifier = new ReflectJavaClass((Class) reflectType2);
        } else if (reflectType2 instanceof TypeVariable) {
            javaClassifier = new ReflectJavaTypeParameter((TypeVariable) reflectType2);
        } else if (reflectType2 instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) reflectType2).getRawType();
            Intrinsics.checkNotNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            javaClassifier = new ReflectJavaClass((Class) rawType);
        } else {
            throw new IllegalStateException("Not a classifier type (" + reflectType2.getClass() + "): " + reflectType2);
        }
        this.classifier = javaClassifier;
    }

    @Nullable
    public JavaAnnotation findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public JavaClassifier getClassifier() {
        return this.classifier;
    }

    @NotNull
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException("Type not found: " + getReflectType());
    }

    @NotNull
    public String getPresentableText() {
        return getReflectType().toString();
    }

    @NotNull
    public Type getReflectType() {
        return this.reflectType;
    }

    @NotNull
    public List<JavaType> getTypeArguments() {
        Iterable<Type> parameterizedTypeArguments = ReflectClassUtilKt.getParameterizedTypeArguments(getReflectType());
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameterizedTypeArguments, 10));
        for (Type create : parameterizedTypeArguments) {
            arrayList.add(factory.create(create));
        }
        return arrayList;
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public boolean isRaw() {
        Type reflectType2 = getReflectType();
        if (!(reflectType2 instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) reflectType2).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }
}
