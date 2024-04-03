package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import org.jetbrains.annotations.NotNull;

public final class LazyPackageViewDescriptorImpl$fragments$2 extends Lambda implements Function0<List<? extends PackageFragmentDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyPackageViewDescriptorImpl f24547g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl$fragments$2(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.f24547g = lazyPackageViewDescriptorImpl;
    }

    @NotNull
    public final List<PackageFragmentDescriptor> invoke() {
        return PackageFragmentProviderKt.packageFragments(this.f24547g.getModule().getPackageFragmentProvider(), this.f24547g.getFqName());
    }
}
