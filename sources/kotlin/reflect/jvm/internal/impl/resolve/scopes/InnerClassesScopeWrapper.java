package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class InnerClassesScopeWrapper extends MemberScopeImpl {
    @NotNull
    private final MemberScope workerScope;

    public InnerClassesScopeWrapper(@NotNull MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(memberScope, "workerScope");
        this.workerScope = memberScope;
    }

    @Nullable
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        ClassifierDescriptor contributedClassifier = this.workerScope.getContributedClassifier(name2, lookupLocation);
        if (contributedClassifier == null) {
            return null;
        }
        if (contributedClassifier instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) contributedClassifier;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor != null) {
            return classDescriptor;
        }
        if (contributedClassifier instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) contributedClassifier;
        }
        return null;
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
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        this.workerScope.recordLookup(name2, lookupLocation);
    }

    @NotNull
    public String toString() {
        return "Classes from " + this.workerScope;
    }

    @NotNull
    public List<ClassifierDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        DescriptorKindFilter restrictedToKindsOrNull = descriptorKindFilter.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (restrictedToKindsOrNull == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : this.workerScope.getContributedDescriptors(restrictedToKindsOrNull, function1)) {
            if (next instanceof ClassifierDescriptorWithTypeParameters) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
