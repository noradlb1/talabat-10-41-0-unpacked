package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaPackageScope$knownClassNamesInPackage$1 extends Lambda implements Function0<Set<? extends String>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaResolverContext f24628g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyJavaPackageScope f24629h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope$knownClassNamesInPackage$1(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaPackageScope lazyJavaPackageScope) {
        super(0);
        this.f24628g = lazyJavaResolverContext;
        this.f24629h = lazyJavaPackageScope;
    }

    @Nullable
    public final Set<String> invoke() {
        return this.f24628g.getComponents().getFinder().knownClassNamesInPackage(this.f24629h.getOwnerDescriptor().getFqName());
    }
}
