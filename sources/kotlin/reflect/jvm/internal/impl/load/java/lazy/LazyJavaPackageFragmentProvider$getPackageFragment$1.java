package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaPackageFragmentProvider$getPackageFragment$1 extends Lambda implements Function0<LazyJavaPackageFragment> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaPackageFragmentProvider f24590g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ JavaPackage f24591h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragmentProvider$getPackageFragment$1(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, JavaPackage javaPackage) {
        super(0);
        this.f24590g = lazyJavaPackageFragmentProvider;
        this.f24591h = javaPackage;
    }

    @NotNull
    public final LazyJavaPackageFragment invoke() {
        return new LazyJavaPackageFragment(this.f24590g.f24589c, this.f24591h);
    }
}
