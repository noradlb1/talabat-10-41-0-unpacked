package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaTypeParameter extends ReflectJavaElement implements ReflectJavaAnnotationOwner, JavaTypeParameter {
    @NotNull
    private final TypeVariable<?> typeVariable;

    public ReflectJavaTypeParameter(@NotNull TypeVariable<?> typeVariable2) {
        Intrinsics.checkNotNullParameter(typeVariable2, "typeVariable");
        this.typeVariable = typeVariable2;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ReflectJavaTypeParameter) && Intrinsics.areEqual((Object) this.typeVariable, (Object) ((ReflectJavaTypeParameter) obj).typeVariable);
    }

    @Nullable
    public ReflectJavaAnnotation findAnnotation(@NotNull FqName fqName) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName);
    }

    @Nullable
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable2 = this.typeVariable;
        if (typeVariable2 instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable2;
        }
        return null;
    }

    @NotNull
    public Name getName() {
        Name identifier = Name.identifier(this.typeVariable.getName());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(typeVariable.name)");
        return identifier;
    }

    public int hashCode() {
        return this.typeVariable.hashCode();
    }

    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @NotNull
    public String toString() {
        return ReflectJavaTypeParameter.class.getName() + ": " + this.typeVariable;
    }

    @NotNull
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @NotNull
    public List<ReflectJavaClassifierType> getUpperBounds() {
        Type[] bounds = this.typeVariable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type reflectJavaClassifierType : bounds) {
            arrayList.add(new ReflectJavaClassifierType(reflectJavaClassifierType));
        }
        ReflectJavaClassifierType reflectJavaClassifierType2 = (ReflectJavaClassifierType) CollectionsKt___CollectionsKt.singleOrNull(arrayList);
        return Intrinsics.areEqual((Object) reflectJavaClassifierType2 != null ? reflectJavaClassifierType2.getReflectType() : null, (Object) Object.class) ? CollectionsKt__CollectionsKt.emptyList() : arrayList;
    }
}
