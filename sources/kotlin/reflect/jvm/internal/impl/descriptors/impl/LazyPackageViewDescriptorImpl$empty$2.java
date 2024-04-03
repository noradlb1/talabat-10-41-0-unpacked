package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import org.jetbrains.annotations.NotNull;

public final class LazyPackageViewDescriptorImpl$empty$2 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyPackageViewDescriptorImpl f24546g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl$empty$2(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.f24546g = lazyPackageViewDescriptorImpl;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(PackageFragmentProviderKt.isEmpty(this.f24546g.getModule().getPackageFragmentProvider(), this.f24546g.getFqName()));
    }
}
