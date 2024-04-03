package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SubpackagesScope extends MemberScopeImpl {
    @NotNull
    private final FqName fqName;
    @NotNull
    private final ModuleDescriptor moduleDescriptor;

    public SubpackagesScope(@NotNull ModuleDescriptor moduleDescriptor2, @NotNull FqName fqName2) {
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        this.moduleDescriptor = moduleDescriptor2;
        this.fqName = fqName2;
    }

    @Nullable
    public final PackageViewDescriptor a(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        if (name2.isSpecial()) {
            return null;
        }
        ModuleDescriptor moduleDescriptor2 = this.moduleDescriptor;
        FqName child = this.fqName.child(name2);
        Intrinsics.checkNotNullExpressionValue(child, "fqName.child(name)");
        PackageViewDescriptor packageViewDescriptor = moduleDescriptor2.getPackage(child);
        if (packageViewDescriptor.isEmpty()) {
            return null;
        }
        return packageViewDescriptor;
    }

    @NotNull
    public Set<Name> getClassifierNames() {
        return SetsKt__SetsKt.emptySet();
    }

    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        if (!descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getPACKAGES_MASK())) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (this.fqName.isRoot() && descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.TopLevelPackages.INSTANCE)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Collection<FqName> subPackagesOf = this.moduleDescriptor.getSubPackagesOf(this.fqName, function1);
        ArrayList arrayList = new ArrayList(subPackagesOf.size());
        for (FqName shortName : subPackagesOf) {
            Name shortName2 = shortName.shortName();
            Intrinsics.checkNotNullExpressionValue(shortName2, "subFqName.shortName()");
            if (function1.invoke(shortName2).booleanValue()) {
                CollectionsKt.addIfNotNull(arrayList, a(shortName2));
            }
        }
        return arrayList;
    }

    @NotNull
    public String toString() {
        return "subpackages of " + this.fqName + " from " + this.moduleDescriptor;
    }
}
