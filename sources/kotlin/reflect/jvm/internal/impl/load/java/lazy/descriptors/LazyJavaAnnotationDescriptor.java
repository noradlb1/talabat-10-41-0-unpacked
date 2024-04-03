package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.apptimize.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24598a;
    @NotNull
    private final NotNullLazyValue allValueArguments$delegate;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f24599c;
    @NotNull
    private final NullableLazyValue fqName$delegate;
    private final boolean isFreshlySupportedTypeUseAnnotation;
    private final boolean isIdeExternalAnnotation;
    /* access modifiers changed from: private */
    @NotNull
    public final JavaAnnotation javaAnnotation;
    @NotNull
    private final JavaSourceElement source;
    @NotNull
    private final NotNullLazyValue type$delegate;

    static {
        Class<LazyJavaAnnotationDescriptor> cls = LazyJavaAnnotationDescriptor.class;
        f24598a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public LazyJavaAnnotationDescriptor(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaAnnotation javaAnnotation2, boolean z11) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(javaAnnotation2, "javaAnnotation");
        this.f24599c = lazyJavaResolverContext;
        this.javaAnnotation = javaAnnotation2;
        this.fqName$delegate = lazyJavaResolverContext.getStorageManager().createNullableLazyValue(new LazyJavaAnnotationDescriptor$fqName$2(this));
        this.type$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$type$2(this));
        this.source = lazyJavaResolverContext.getComponents().getSourceElementFactory().source(javaAnnotation2);
        this.allValueArguments$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$allValueArguments$2(this));
        this.isIdeExternalAnnotation = javaAnnotation2.isIdeExternalAnnotation();
        this.isFreshlySupportedTypeUseAnnotation = javaAnnotation2.isFreshlySupportedTypeUseAnnotation() || z11;
    }

    /* access modifiers changed from: private */
    public final ClassDescriptor createTypeForMissingDependencies(FqName fqName) {
        ModuleDescriptor module = this.f24599c.getModule();
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(fqName)");
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(module, classId, this.f24599c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    /* access modifiers changed from: private */
    public final ConstantValue<?> resolveAnnotationArgument(JavaAnnotationArgument javaAnnotationArgument) {
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            return ConstantValueFactory.INSTANCE.createConstantValue(((JavaLiteralAnnotationArgument) javaAnnotationArgument).getValue());
        }
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
            return resolveFromEnumValue(javaEnumValueAnnotationArgument.getEnumClassId(), javaEnumValueAnnotationArgument.getEntryName());
        } else if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            JavaArrayAnnotationArgument javaArrayAnnotationArgument = (JavaArrayAnnotationArgument) javaAnnotationArgument;
            Name name2 = javaArrayAnnotationArgument.getName();
            if (name2 == null) {
                name2 = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            Intrinsics.checkNotNullExpressionValue(name2, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            return resolveFromArray(name2, javaArrayAnnotationArgument.getElements());
        } else if (javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument) {
            return resolveFromAnnotation(((JavaAnnotationAsAnnotationArgument) javaAnnotationArgument).getAnnotation());
        } else {
            if (javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument) {
                return resolveFromJavaClassObjectType(((JavaClassObjectAnnotationArgument) javaAnnotationArgument).getReferencedType());
            }
            return null;
        }
    }

    private final ConstantValue<?> resolveFromAnnotation(JavaAnnotation javaAnnotation2) {
        return new AnnotationValue(new LazyJavaAnnotationDescriptor(this.f24599c, javaAnnotation2, false, 4, (DefaultConstructorMarker) null));
    }

    private final ConstantValue<?> resolveFromArray(Name name2, List<? extends JavaAnnotationArgument> list) {
        KotlinType kotlinType;
        SimpleType type = getType();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        if (KotlinTypeKt.isError(type)) {
            return null;
        }
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(this);
        Intrinsics.checkNotNull(annotationClass);
        ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name2, annotationClass);
        if (annotationParameterByName == null || (kotlinType = annotationParameterByName.getType()) == null) {
            kotlinType = this.f24599c.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType(ErrorTypeKind.UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, new String[0]));
        }
        Intrinsics.checkNotNullExpressionValue(kotlinType, "DescriptorResolverUtils.…GUMENT)\n                )");
        Iterable<JavaAnnotationArgument> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (JavaAnnotationArgument resolveAnnotationArgument : iterable) {
            Object resolveAnnotationArgument2 = resolveAnnotationArgument(resolveAnnotationArgument);
            if (resolveAnnotationArgument2 == null) {
                resolveAnnotationArgument2 = new NullValue();
            }
            arrayList.add(resolveAnnotationArgument2);
        }
        return ConstantValueFactory.INSTANCE.createArrayValue((List<? extends ConstantValue<?>>) arrayList, kotlinType);
    }

    private final ConstantValue<?> resolveFromEnumValue(ClassId classId, Name name2) {
        if (classId == null || name2 == null) {
            return null;
        }
        return new EnumValue(classId, name2);
    }

    private final ConstantValue<?> resolveFromJavaClassObjectType(JavaType javaType) {
        return KClassValue.Companion.create(this.f24599c.getTypeResolver().transformJavaType(javaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 3, (Object) null)));
    }

    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map) StorageKt.getValue(this.allValueArguments$delegate, (Object) this, (KProperty<?>) f24598a[2]);
    }

    @Nullable
    public FqName getFqName() {
        return (FqName) StorageKt.getValue(this.fqName$delegate, (Object) this, (KProperty<?>) f24598a[0]);
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.isFreshlySupportedTypeUseAnnotation;
    }

    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }

    @NotNull
    public String toString() {
        return DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, (AnnotationUseSiteTarget) null, 2, (Object) null);
    }

    @NotNull
    public JavaSourceElement getSource() {
        return this.source;
    }

    @NotNull
    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.type$delegate, (Object) this, (KProperty<?>) f24598a[1]);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaAnnotationDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation2, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, javaAnnotation2, (i11 & 4) != 0 ? false : z11);
    }
}
