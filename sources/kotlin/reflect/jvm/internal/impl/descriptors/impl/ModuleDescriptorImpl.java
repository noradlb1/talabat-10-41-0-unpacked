package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.facebook.internal.NativeProtocol;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleExceptionKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    @NotNull
    private final KotlinBuiltIns builtIns;
    @NotNull
    private final Map<ModuleCapability<?>, Object> capabilities;
    /* access modifiers changed from: private */
    @Nullable
    public ModuleDependencies dependencies;
    private boolean isValid;
    /* access modifiers changed from: private */
    @Nullable
    public PackageFragmentProvider packageFragmentProviderForModuleContent;
    @NotNull
    private final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final PackageViewDescriptorFactory packageViewDescriptorFactory;
    @NotNull
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
    @Nullable
    private final TargetPlatform platform;
    @Nullable
    private final Name stableName;
    /* access modifiers changed from: private */
    @NotNull
    public final StorageManager storageManager;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name name2, @NotNull StorageManager storageManager2, @NotNull KotlinBuiltIns kotlinBuiltIns, @Nullable TargetPlatform targetPlatform) {
        this(name2, storageManager2, kotlinBuiltIns, targetPlatform, (Map) null, (Name) null, 48, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(name2, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModuleDescriptorImpl(Name name2, StorageManager storageManager2, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map map, Name name3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(name2, storageManager2, kotlinBuiltIns, (i11 & 8) != 0 ? null : targetPlatform, (i11 & 16) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i11 & 32) != 0 ? null : name3);
    }

    /* access modifiers changed from: private */
    public final String getId() {
        String name2 = getName().toString();
        Intrinsics.checkNotNullExpressionValue(name2, "name.toString()");
        return name2;
    }

    private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        return (CompositePackageFragmentProvider) this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final boolean isInitialized() {
        return this.packageFragmentProviderForModuleContent != null;
    }

    @Nullable
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d11) {
        return ModuleDescriptor.DefaultImpls.accept(this, declarationDescriptorVisitor, d11);
    }

    public void assertValid() {
        if (!isValid()) {
            InvalidModuleExceptionKt.moduleInvalidated(this);
        }
    }

    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    @Nullable
    public <T> T getCapability(@NotNull ModuleCapability<T> moduleCapability) {
        Intrinsics.checkNotNullParameter(moduleCapability, "capability");
        T t11 = this.capabilities.get(moduleCapability);
        if (t11 == null) {
            return null;
        }
        return t11;
    }

    @Nullable
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @NotNull
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        throw new AssertionError("Dependencies of module " + getId() + " were not set");
    }

    @NotNull
    public PackageViewDescriptor getPackage(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        assertValid();
        return this.packages.invoke(fqName);
    }

    @NotNull
    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, function1);
    }

    public final void initialize(@NotNull PackageFragmentProvider packageFragmentProvider) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "providerForModuleContent");
        isInitialized();
        this.packageFragmentProviderForModuleContent = packageFragmentProvider;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public final void setDependencies(@NotNull ModuleDependencies moduleDependencies) {
        Intrinsics.checkNotNullParameter(moduleDependencies, "dependencies");
        this.dependencies = moduleDependencies;
    }

    public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "targetModule");
        if (Intrinsics.areEqual((Object) this, (Object) moduleDescriptor)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.dependencies;
        Intrinsics.checkNotNull(moduleDependencies);
        if (!CollectionsKt___CollectionsKt.contains(moduleDependencies.getModulesWhoseInternalsAreVisible(), moduleDescriptor) && !getExpectedByModules().contains(moduleDescriptor) && !moduleDescriptor.getExpectedByModules().contains(this)) {
            return false;
        }
        return true;
    }

    public final void setDependencies(@NotNull ModuleDescriptorImpl... moduleDescriptorImplArr) {
        Intrinsics.checkNotNullParameter(moduleDescriptorImplArr, "descriptors");
        setDependencies((List<ModuleDescriptorImpl>) ArraysKt___ArraysKt.toList((T[]) moduleDescriptorImplArr));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name name2, @NotNull StorageManager storageManager2, @NotNull KotlinBuiltIns kotlinBuiltIns, @Nullable TargetPlatform targetPlatform, @NotNull Map<ModuleCapability<?>, ? extends Object> map, @Nullable Name name3) {
        super(Annotations.Companion.getEMPTY(), name2);
        Intrinsics.checkNotNullParameter(name2, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics.checkNotNullParameter(map, "capabilities");
        this.storageManager = storageManager2;
        this.builtIns = kotlinBuiltIns;
        this.platform = targetPlatform;
        this.stableName = name3;
        if (name2.isSpecial()) {
            this.capabilities = map;
            PackageViewDescriptorFactory packageViewDescriptorFactory2 = (PackageViewDescriptorFactory) getCapability(PackageViewDescriptorFactory.Companion.getCAPABILITY());
            this.packageViewDescriptorFactory = packageViewDescriptorFactory2 == null ? PackageViewDescriptorFactory.Default.INSTANCE : packageViewDescriptorFactory2;
            this.isValid = true;
            this.packages = storageManager2.createMemoizedFunction(new ModuleDescriptorImpl$packages$1(this));
            this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt__LazyJVMKt.lazy(new ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(this));
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + name2);
    }

    public final void setDependencies(@NotNull List<ModuleDescriptorImpl> list) {
        Intrinsics.checkNotNullParameter(list, "descriptors");
        setDependencies(list, SetsKt__SetsKt.emptySet());
    }

    public final void setDependencies(@NotNull List<ModuleDescriptorImpl> list, @NotNull Set<ModuleDescriptorImpl> set) {
        Intrinsics.checkNotNullParameter(list, "descriptors");
        Intrinsics.checkNotNullParameter(set, NativeProtocol.AUDIENCE_FRIENDS);
        setDependencies((ModuleDependencies) new ModuleDependenciesImpl(list, set, CollectionsKt__CollectionsKt.emptyList(), SetsKt__SetsKt.emptySet()));
    }
}
