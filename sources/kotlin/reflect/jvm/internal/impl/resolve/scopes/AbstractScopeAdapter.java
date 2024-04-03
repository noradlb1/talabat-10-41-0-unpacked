package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractScopeAdapter implements MemberScope {
    @NotNull
    public abstract MemberScope a();

    @NotNull
    public final MemberScope getActualScope() {
        if (!(a() instanceof AbstractScopeAdapter)) {
            return a();
        }
        MemberScope a11 = a();
        Intrinsics.checkNotNull(a11, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
        return ((AbstractScopeAdapter) a11).getActualScope();
    }

    @Nullable
    public Set<Name> getClassifierNames() {
        return a().getClassifierNames();
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return a().getContributedClassifier(name2, lookupLocation);
    }

    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return a().getContributedDescriptors(descriptorKindFilter, function1);
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return a().getContributedFunctions(name2, lookupLocation);
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return a().getContributedVariables(name2, lookupLocation);
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        return a().getFunctionNames();
    }

    @NotNull
    public Set<Name> getVariableNames() {
        return a().getVariableNames();
    }

    public void recordLookup(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        a().recordLookup(name2, lookupLocation);
    }
}
