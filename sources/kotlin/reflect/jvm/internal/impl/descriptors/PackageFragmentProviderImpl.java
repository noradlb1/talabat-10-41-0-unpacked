package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class PackageFragmentProviderImpl implements PackageFragmentProviderOptimized {
    @NotNull
    private final Collection<PackageFragmentDescriptor> packageFragments;

    public PackageFragmentProviderImpl(@NotNull Collection<? extends PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        this.packageFragments = collection;
    }

    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        for (Object next : this.packageFragments) {
            if (Intrinsics.areEqual((Object) ((PackageFragmentDescriptor) next).getFqName(), (Object) fqName)) {
                collection.add(next);
            }
        }
    }

    @NotNull
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        for (Object next : this.packageFragments) {
            if (Intrinsics.areEqual((Object) ((PackageFragmentDescriptor) next).getFqName(), (Object) fqName)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.packageFragments), PackageFragmentProviderImpl$getSubPackagesOf$1.INSTANCE), new PackageFragmentProviderImpl$getSubPackagesOf$2(fqName)));
    }

    public boolean isEmpty(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Iterable<PackageFragmentDescriptor> iterable = this.packageFragments;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (PackageFragmentDescriptor fqName2 : iterable) {
            if (Intrinsics.areEqual((Object) fqName2.getFqName(), (Object) fqName)) {
                return false;
            }
        }
        return true;
    }
}
