package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {

    /* renamed from: a  reason: collision with root package name */
    public DeserializationComponents f24823a;
    @NotNull
    private final KotlinMetadataFinder finder;
    @NotNull
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;
    @NotNull
    private final ModuleDescriptor moduleDescriptor;
    @NotNull
    private final StorageManager storageManager;

    public AbstractDeserializedPackageFragmentProvider(@NotNull StorageManager storageManager2, @NotNull KotlinMetadataFinder kotlinMetadataFinder, @NotNull ModuleDescriptor moduleDescriptor2) {
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinMetadataFinder, "finder");
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        this.storageManager = storageManager2;
        this.finder = kotlinMetadataFinder;
        this.moduleDescriptor = moduleDescriptor2;
        this.fragments = storageManager2.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$fragments$1(this));
    }

    @Nullable
    public abstract DeserializedPackageFragment a(@NotNull FqName fqName);

    @NotNull
    public final DeserializationComponents b() {
        DeserializationComponents deserializationComponents = this.f24823a;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    @NotNull
    public final KotlinMetadataFinder c() {
        return this.finder;
    }

    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        CollectionsKt.addIfNotNull(collection, this.fragments.invoke(fqName));
    }

    @NotNull
    public final ModuleDescriptor d() {
        return this.moduleDescriptor;
    }

    @NotNull
    public final StorageManager e() {
        return this.storageManager;
    }

    public final void f(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.f24823a = deserializationComponents;
    }

    @NotNull
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return CollectionsKt__CollectionsKt.listOfNotNull(this.fragments.invoke(fqName));
    }

    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return SetsKt__SetsKt.emptySet();
    }

    public boolean isEmpty(@NotNull FqName fqName) {
        Object obj;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fragments.isComputed(fqName)) {
            obj = this.fragments.invoke(fqName);
        } else {
            obj = a(fqName);
        }
        if (obj == null) {
            return true;
        }
        return false;
    }
}
