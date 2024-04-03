package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaMember extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    @NotNull
    public final List<JavaValueParameter> a(@NotNull Type[] typeArr, @NotNull Annotation[][] annotationArr, boolean z11) {
        int i11;
        String str;
        boolean z12;
        Intrinsics.checkNotNullParameter(typeArr, "parameterTypes");
        Intrinsics.checkNotNullParameter(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> loadParameterNames = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(getMember());
        if (loadParameterNames != null) {
            i11 = loadParameterNames.size() - typeArr.length;
        } else {
            i11 = 0;
        }
        int length = typeArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            ReflectJavaType create = ReflectJavaType.Factory.create(typeArr[i12]);
            if (loadParameterNames != null) {
                str = (String) CollectionsKt___CollectionsKt.getOrNull(loadParameterNames, i12 + i11);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i12 + SignatureVisitor.EXTENDS + i11 + " (name=" + getName() + " type=" + create + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            if (!z11 || i12 != ArraysKt___ArraysKt.getLastIndex((T[]) typeArr)) {
                z12 = false;
            } else {
                z12 = true;
            }
            arrayList.add(new ReflectJavaValueParameter(create, annotationArr[i12], str, z12));
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ReflectJavaMember) && Intrinsics.areEqual((Object) getMember(), (Object) ((ReflectJavaMember) obj).getMember());
    }

    @Nullable
    public ReflectJavaAnnotation findAnnotation(@NotNull FqName fqName) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName);
    }

    @NotNull
    public AnnotatedElement getElement() {
        Member member = getMember();
        Intrinsics.checkNotNull(member, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) member;
    }

    @NotNull
    public abstract Member getMember();

    public int getModifiers() {
        return getMember().getModifiers();
    }

    @NotNull
    public Name getName() {
        String name2 = getMember().getName();
        Name identifier = name2 != null ? Name.identifier(name2) : null;
        return identifier == null ? SpecialNames.NO_NAME_PROVIDED : identifier;
    }

    @NotNull
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    @NotNull
    public String toString() {
        return getClass().getName() + ": " + getMember();
    }

    @NotNull
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @NotNull
    public ReflectJavaClass getContainingClass() {
        Class<?> declaringClass = getMember().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "member.declaringClass");
        return new ReflectJavaClass(declaringClass);
    }
}
