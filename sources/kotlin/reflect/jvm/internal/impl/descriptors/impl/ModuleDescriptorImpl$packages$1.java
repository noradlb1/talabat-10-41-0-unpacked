package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class ModuleDescriptorImpl$packages$1 extends Lambda implements Function1<FqName, PackageViewDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ModuleDescriptorImpl f24552g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl$packages$1(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(1);
        this.f24552g = moduleDescriptorImpl;
    }

    @NotNull
    public final PackageViewDescriptor invoke(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        PackageViewDescriptorFactory access$getPackageViewDescriptorFactory$p = this.f24552g.packageViewDescriptorFactory;
        ModuleDescriptorImpl moduleDescriptorImpl = this.f24552g;
        return access$getPackageViewDescriptorFactory$p.compute(moduleDescriptorImpl, fqName, moduleDescriptorImpl.storageManager);
    }
}
