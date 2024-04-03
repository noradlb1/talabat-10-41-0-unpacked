package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24620b;
    @NotNull
    private final Annotations annotations;
    @NotNull
    private final NotNullLazyValue binaryClasses$delegate;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f24621c;
    /* access modifiers changed from: private */
    @NotNull
    public final JavaPackage jPackage;
    @NotNull
    private final NotNullLazyValue partToFacade$delegate;
    @NotNull
    private final JvmPackageScope scope;
    @NotNull
    private final NotNullLazyValue<List<FqName>> subPackages;

    static {
        Class<LazyJavaPackageFragment> cls = LazyJavaPackageFragment.class;
        f24620b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaPackage javaPackage) {
        super(lazyJavaResolverContext.getModule(), javaPackage.getFqName());
        Annotations annotations2;
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "outerContext");
        Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        this.jPackage = javaPackage;
        LazyJavaResolverContext childForClassOrPackage$default = ContextKt.childForClassOrPackage$default(lazyJavaResolverContext, this, (JavaTypeParameterListOwner) null, 0, 6, (Object) null);
        this.f24621c = childForClassOrPackage$default;
        this.binaryClasses$delegate = childForClassOrPackage$default.getStorageManager().createLazyValue(new LazyJavaPackageFragment$binaryClasses$2(this));
        this.scope = new JvmPackageScope(childForClassOrPackage$default, javaPackage, this);
        this.subPackages = childForClassOrPackage$default.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaPackageFragment$subPackages$1(this), CollectionsKt__CollectionsKt.emptyList());
        if (childForClassOrPackage$default.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations()) {
            annotations2 = Annotations.Companion.getEMPTY();
        } else {
            annotations2 = LazyJavaAnnotationsKt.resolveAnnotations(childForClassOrPackage$default, javaPackage);
        }
        this.annotations = annotations2;
        this.partToFacade$delegate = childForClassOrPackage$default.getStorageManager().createLazyValue(new LazyJavaPackageFragment$partToFacade$2(this));
    }

    @Nullable
    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(@NotNull JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        return this.scope.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(javaClass);
    }

    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) StorageKt.getValue(this.binaryClasses$delegate, (Object) this, (KProperty<?>) f24620b[0]);
    }

    @NotNull
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    @NotNull
    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return (List) this.subPackages.invoke();
    }

    @NotNull
    public String toString() {
        return "Lazy Java package fragment: " + getFqName() + " of module " + this.f24621c.getComponents().getModule();
    }

    @NotNull
    public JvmPackageScope getMemberScope() {
        return this.scope;
    }
}
