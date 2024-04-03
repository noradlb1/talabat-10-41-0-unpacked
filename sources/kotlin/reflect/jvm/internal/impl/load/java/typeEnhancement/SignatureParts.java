package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SignatureParts extends AbstractSignatureParts<AnnotationDescriptor> {
    @NotNull
    private final AnnotationQualifierApplicabilityType containerApplicabilityType;
    @NotNull
    private final LazyJavaResolverContext containerContext;
    private final boolean isCovariant;
    private final boolean skipRawTypeArguments;
    @Nullable
    private final Annotated typeContainer;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SignatureParts(Annotated annotated, boolean z11, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotated, z11, lazyJavaResolverContext, annotationQualifierApplicabilityType, (i11 & 16) != 0 ? false : z12);
    }

    @NotNull
    public Iterable<AnnotationDescriptor> getAnnotations(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return ((KotlinType) kotlinTypeMarker).getAnnotations();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getAnnotations();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> getContainerAnnotations() {
        /*
            r1 = this;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r0 = r1.typeContainer
            if (r0 == 0) goto L_0x000b
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r0.getAnnotations()
            if (r0 == 0) goto L_0x000b
            goto L_0x0011
        L_0x000b:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureParts.getContainerAnnotations():java.lang.Iterable");
    }

    @NotNull
    public AnnotationQualifierApplicabilityType getContainerApplicabilityType() {
        return this.containerApplicabilityType;
    }

    @Nullable
    public JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers() {
        return this.containerContext.getDefaultTypeQualifiers();
    }

    public boolean getContainerIsVarargParameter() {
        Annotated annotated = this.typeContainer;
        return (annotated instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) annotated).getVarargElementType() != null;
    }

    public boolean getEnableImprovementsInStrictMode() {
        return this.containerContext.getComponents().getSettings().getTypeEnhancementImprovementsInStrictMode();
    }

    @Nullable
    public FqNameUnsafe getFqNameUnsafe(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor((KotlinType) kotlinTypeMarker);
        if (classDescriptor != null) {
            return DescriptorUtils.getFqName(classDescriptor);
        }
        return null;
    }

    public boolean getSkipRawTypeArguments() {
        return this.skipRawTypeArguments;
    }

    public boolean isArrayOrPrimitiveArray(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return KotlinBuiltIns.isArrayOrPrimitiveArray((KotlinType) kotlinTypeMarker);
    }

    public boolean isCovariant() {
        return this.isCovariant;
    }

    public boolean isEqual(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "other");
        return this.containerContext.getComponents().getKotlinTypeChecker().equalTypes((KotlinType) kotlinTypeMarker, (KotlinType) kotlinTypeMarker2);
    }

    public boolean isFromJava(@NotNull TypeParameterMarker typeParameterMarker) {
        Intrinsics.checkNotNullParameter(typeParameterMarker, "<this>");
        return typeParameterMarker instanceof LazyJavaTypeParameterDescriptor;
    }

    public boolean isNotNullTypeParameterCompat(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return ((KotlinType) kotlinTypeMarker).unwrap() instanceof NotNullTypeParameterImpl;
    }

    public SignatureParts(@Nullable Annotated annotated, boolean z11, @NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z12) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "containerContext");
        Intrinsics.checkNotNullParameter(annotationQualifierApplicabilityType, "containerApplicabilityType");
        this.typeContainer = annotated;
        this.isCovariant = z11;
        this.containerContext = lazyJavaResolverContext;
        this.containerApplicabilityType = annotationQualifierApplicabilityType;
        this.skipRawTypeArguments = z12;
    }

    @NotNull
    public AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.containerContext.getComponents().getAnnotationTypeQualifierResolver();
    }

    @Nullable
    public KotlinType getEnhancedForWarnings(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return TypeWithEnhancementKt.getEnhancement((KotlinType) kotlinTypeMarker);
    }

    public boolean getForceWarning(@NotNull AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        return ((annotationDescriptor instanceof PossiblyExternalAnnotationDescriptor) && ((PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) || ((annotationDescriptor instanceof LazyJavaAnnotationDescriptor) && !getEnableImprovementsInStrictMode() && (((LazyJavaAnnotationDescriptor) annotationDescriptor).isFreshlySupportedTypeUseAnnotation() || getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS));
    }

    @NotNull
    public TypeSystemInferenceExtensionContext getTypeSystem() {
        return SimpleClassicTypeSystemContext.INSTANCE;
    }
}
