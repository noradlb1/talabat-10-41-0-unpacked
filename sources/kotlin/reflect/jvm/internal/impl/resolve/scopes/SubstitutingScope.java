package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SubstitutingScope implements MemberScope {
    @NotNull
    private final Lazy _allDescriptors$delegate = LazyKt__LazyJVMKt.lazy(new SubstitutingScope$_allDescriptors$2(this));
    @Nullable
    private Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    @NotNull
    private final TypeSubstitutor substitutor;
    /* access modifiers changed from: private */
    @NotNull
    public final MemberScope workerScope;

    public SubstitutingScope(@NotNull MemberScope memberScope, @NotNull TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(memberScope, "workerScope");
        Intrinsics.checkNotNullParameter(typeSubstitutor, "givenSubstitutor");
        this.workerScope = memberScope;
        TypeSubstitution substitution = typeSubstitutor.getSubstitution();
        Intrinsics.checkNotNullExpressionValue(substitution, "givenSubstitutor.substitution");
        this.substitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(substitution, false, 1, (Object) null).buildSubstitutor();
    }

    private final Collection<DeclarationDescriptor> get_allDescriptors() {
        return (Collection) this._allDescriptors$delegate.getValue();
    }

    private final <D extends DeclarationDescriptor> D substitute(D d11) {
        if (this.substitutor.isEmpty()) {
            return d11;
        }
        if (this.substitutedDescriptors == null) {
            this.substitutedDescriptors = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.substitutedDescriptors;
        Intrinsics.checkNotNull(map);
        D d12 = map.get(d11);
        if (d12 == null) {
            if (d11 instanceof Substitutable) {
                d12 = ((Substitutable) d11).substitute(this.substitutor);
                if (d12 != null) {
                    map.put(d11, d12);
                } else {
                    throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d11 + " substitution fails");
                }
            } else {
                throw new IllegalStateException(("Unknown descriptor in scope: " + d11).toString());
            }
        }
        D d13 = (DeclarationDescriptor) d12;
        Intrinsics.checkNotNull(d13, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return d13;
    }

    @Nullable
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        ClassifierDescriptor contributedClassifier = this.workerScope.getContributedClassifier(name2, lookupLocation);
        if (contributedClassifier != null) {
            return (ClassifierDescriptor) substitute(contributedClassifier);
        }
        return null;
    }

    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return get_allDescriptors();
    }

    @NotNull
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return substitute(this.workerScope.getContributedFunctions(name2, lookupLocation));
    }

    @NotNull
    public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return substitute(this.workerScope.getContributedVariables(name2, lookupLocation));
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @NotNull
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    public void recordLookup(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        MemberScope.DefaultImpls.recordLookup(this, name2, lookupLocation);
    }

    /* access modifiers changed from: private */
    public final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> collection) {
        if (this.substitutor.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet newLinkedHashSetWithExpectedSize = CollectionsKt.newLinkedHashSetWithExpectedSize(collection.size());
        Iterator<? extends D> it = collection.iterator();
        while (it.hasNext()) {
            newLinkedHashSetWithExpectedSize.add(substitute((DeclarationDescriptor) it.next()));
        }
        return newLinkedHashSetWithExpectedSize;
    }
}
