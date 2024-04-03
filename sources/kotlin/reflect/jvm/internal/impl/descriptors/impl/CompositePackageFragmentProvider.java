package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class CompositePackageFragmentProvider implements PackageFragmentProviderOptimized {
    @NotNull
    private final String debugName;
    @NotNull
    private final List<PackageFragmentProvider> providers;

    public CompositePackageFragmentProvider(@NotNull List<? extends PackageFragmentProvider> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "providers");
        Intrinsics.checkNotNullParameter(str, "debugName");
        this.providers = list;
        this.debugName = str;
        list.size();
        CollectionsKt___CollectionsKt.toSet(list).size();
    }

    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        for (PackageFragmentProvider collectPackageFragmentsOptimizedIfPossible : this.providers) {
            PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(collectPackageFragmentsOptimizedIfPossible, fqName, collection);
        }
    }

    @NotNull
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        for (PackageFragmentProvider collectPackageFragmentsOptimizedIfPossible : this.providers) {
            PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(collectPackageFragmentsOptimizedIfPossible, fqName, arrayList);
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        for (PackageFragmentProvider subPackagesOf : this.providers) {
            hashSet.addAll(subPackagesOf.getSubPackagesOf(fqName, function1));
        }
        return hashSet;
    }

    public boolean isEmpty(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Iterable<PackageFragmentProvider> iterable = this.providers;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (PackageFragmentProvider isEmpty : iterable) {
            if (!PackageFragmentProviderKt.isEmpty(isEmpty, fqName)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public String toString() {
        return this.debugName;
    }
}
