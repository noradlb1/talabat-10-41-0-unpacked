package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import org.jetbrains.annotations.NotNull;

public final class ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2 extends Lambda implements Function0<CompositePackageFragmentProvider> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ModuleDescriptorImpl f24551g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(0);
        this.f24551g = moduleDescriptorImpl;
    }

    @NotNull
    public final CompositePackageFragmentProvider invoke() {
        ModuleDependencies access$getDependencies$p = this.f24551g.dependencies;
        ModuleDescriptorImpl moduleDescriptorImpl = this.f24551g;
        if (access$getDependencies$p != null) {
            List<ModuleDescriptorImpl> allDependencies = access$getDependencies$p.getAllDependencies();
            this.f24551g.assertValid();
            allDependencies.contains(this.f24551g);
            Iterable<ModuleDescriptorImpl> iterable = allDependencies;
            for (ModuleDescriptorImpl access$isInitialized : iterable) {
                boolean unused = access$isInitialized.isInitialized();
            }
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (ModuleDescriptorImpl access$getPackageFragmentProviderForModuleContent$p : iterable) {
                PackageFragmentProvider access$getPackageFragmentProviderForModuleContent$p2 = access$getPackageFragmentProviderForModuleContent$p.packageFragmentProviderForModuleContent;
                Intrinsics.checkNotNull(access$getPackageFragmentProviderForModuleContent$p2);
                arrayList.add(access$getPackageFragmentProviderForModuleContent$p2);
            }
            return new CompositePackageFragmentProvider(arrayList, "CompositeProvider@ModuleDescriptor for " + this.f24551g.getName());
        }
        throw new AssertionError("Dependencies of module " + moduleDescriptorImpl.getId() + " were not set before querying module content");
    }
}
