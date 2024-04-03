package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

public final class JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1 extends Lambda implements Function0<KotlinType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JavaTypeResolver f24653g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TypeParameterDescriptor f24654h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ JavaClassifierType f24655i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ JavaTypeAttributes f24656j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TypeConstructor f24657k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1(JavaTypeResolver javaTypeResolver, TypeParameterDescriptor typeParameterDescriptor, JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor) {
        super(0);
        this.f24653g = javaTypeResolver;
        this.f24654h = typeParameterDescriptor;
        this.f24655i = javaClassifierType;
        this.f24656j = javaTypeAttributes;
        this.f24657k = typeConstructor;
    }

    @NotNull
    public final KotlinType invoke() {
        TypeParameterUpperBoundEraser access$getTypeParameterUpperBoundEraser$p = this.f24653g.typeParameterUpperBoundEraser;
        TypeParameterDescriptor typeParameterDescriptor = this.f24654h;
        boolean isRaw = this.f24655i.isRaw();
        JavaTypeAttributes javaTypeAttributes = this.f24656j;
        ClassifierDescriptor declarationDescriptor = this.f24657k.getDeclarationDescriptor();
        KotlinType erasedUpperBound$descriptors_jvm = access$getTypeParameterUpperBoundEraser$p.getErasedUpperBound$descriptors_jvm(typeParameterDescriptor, isRaw, javaTypeAttributes.withDefaultType(declarationDescriptor != null ? declarationDescriptor.getDefaultType() : null));
        Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "typeParameterUpperBoundE…efaultType)\n            )");
        return erasedUpperBound$descriptors_jvm;
    }
}
