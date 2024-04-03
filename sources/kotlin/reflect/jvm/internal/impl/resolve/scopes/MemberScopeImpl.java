package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class MemberScopeImpl implements MemberScope {
    @Nullable
    public Set<Name> getClassifierNames() {
        return null;
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return null;
    }

    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object next : getContributedDescriptors(DescriptorKindFilter.FUNCTIONS, FunctionsKt.alwaysTrue())) {
            if (next instanceof SimpleFunctionDescriptor) {
                Name name2 = ((SimpleFunctionDescriptor) next).getName();
                Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                linkedHashSet.add(name2);
            }
        }
        return linkedHashSet;
    }

    @NotNull
    public Set<Name> getVariableNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object next : getContributedDescriptors(DescriptorKindFilter.VARIABLES, FunctionsKt.alwaysTrue())) {
            if (next instanceof SimpleFunctionDescriptor) {
                Name name2 = ((SimpleFunctionDescriptor) next).getName();
                Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                linkedHashSet.add(name2);
            }
        }
        return linkedHashSet;
    }

    public void recordLookup(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        MemberScope.DefaultImpls.recordLookup(this, name2, lookupLocation);
    }
}
