package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaPackageScope$classes$1 extends Lambda implements Function1<LazyJavaPackageScope.FindClassRequest, ClassDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaPackageScope f24626g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyJavaResolverContext f24627h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope$classes$1(LazyJavaPackageScope lazyJavaPackageScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.f24626g = lazyJavaPackageScope;
        this.f24627h = lazyJavaResolverContext;
    }

    @Nullable
    public final ClassDescriptor invoke(@NotNull LazyJavaPackageScope.FindClassRequest findClassRequest) {
        KotlinClassFinder.Result result;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(findClassRequest, "request");
        ClassId classId = new ClassId(this.f24626g.getOwnerDescriptor().getFqName(), findClassRequest.getName());
        if (findClassRequest.getJavaClass() != null) {
            result = this.f24627h.getComponents().getKotlinClassFinder().findKotlinClassOrContent(findClassRequest.getJavaClass());
        } else {
            result = this.f24627h.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId);
        }
        KotlinJvmBinaryClass kotlinJvmBinaryClass = result != null ? result.toKotlinJvmBinaryClass() : null;
        ClassId classId2 = kotlinJvmBinaryClass != null ? kotlinJvmBinaryClass.getClassId() : null;
        if (classId2 != null && (classId2.isNestedClass() || classId2.isLocal())) {
            return null;
        }
        LazyJavaPackageScope.KotlinClassLookupResult access$resolveKotlinBinaryClass = this.f24626g.resolveKotlinBinaryClass(kotlinJvmBinaryClass);
        if (access$resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.Found) {
            return ((LazyJavaPackageScope.KotlinClassLookupResult.Found) access$resolveKotlinBinaryClass).getDescriptor();
        }
        if (access$resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass) {
            return null;
        }
        if (access$resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.NotFound) {
            JavaClass javaClass = findClassRequest.getJavaClass();
            if (javaClass == null) {
                JavaClassFinder finder = this.f24627h.getComponents().getFinder();
                if (result != null) {
                    if (!(result instanceof KotlinClassFinder.Result.ClassFileContent)) {
                        result = null;
                    }
                    KotlinClassFinder.Result.ClassFileContent classFileContent = (KotlinClassFinder.Result.ClassFileContent) result;
                    if (classFileContent != null) {
                        bArr = classFileContent.getContent();
                        javaClass = finder.findClass(new JavaClassFinder.Request(classId, bArr, (JavaClass) null, 4, (DefaultConstructorMarker) null));
                    }
                }
                bArr = null;
                javaClass = finder.findClass(new JavaClassFinder.Request(classId, bArr, (JavaClass) null, 4, (DefaultConstructorMarker) null));
            }
            JavaClass javaClass2 = javaClass;
            if ((javaClass2 != null ? javaClass2.getLightClassOriginKind() : null) != LightClassOriginKind.BINARY) {
                FqName fqName = javaClass2 != null ? javaClass2.getFqName() : null;
                if (fqName == null || fqName.isRoot() || !Intrinsics.areEqual((Object) fqName.parent(), (Object) this.f24626g.getOwnerDescriptor().getFqName())) {
                    return null;
                }
                LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.f24627h, this.f24626g.getOwnerDescriptor(), javaClass2, (ClassDescriptor) null, 8, (DefaultConstructorMarker) null);
                this.f24627h.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                return lazyJavaClassDescriptor;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + javaClass2 + "\nClassId: " + classId + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinderKt.findKotlinClass(this.f24627h.getComponents().getKotlinClassFinder(), javaClass2) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinderKt.findKotlinClass(this.f24627h.getComponents().getKotlinClassFinder(), classId) + 10);
        }
        throw new NoWhenBranchMatchedException();
    }
}
