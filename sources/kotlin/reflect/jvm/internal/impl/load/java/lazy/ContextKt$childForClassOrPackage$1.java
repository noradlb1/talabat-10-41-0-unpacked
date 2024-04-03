package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import org.jetbrains.annotations.Nullable;

public final class ContextKt$childForClassOrPackage$1 extends Lambda implements Function0<JavaTypeQualifiersByElementType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaResolverContext f24582g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ClassOrPackageFragmentDescriptor f24583h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextKt$childForClassOrPackage$1(LazyJavaResolverContext lazyJavaResolverContext, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor) {
        super(0);
        this.f24582g = lazyJavaResolverContext;
        this.f24583h = classOrPackageFragmentDescriptor;
    }

    @Nullable
    public final JavaTypeQualifiersByElementType invoke() {
        return ContextKt.computeNewDefaultTypeQualifiers(this.f24582g, this.f24583h.getAnnotations());
    }
}
