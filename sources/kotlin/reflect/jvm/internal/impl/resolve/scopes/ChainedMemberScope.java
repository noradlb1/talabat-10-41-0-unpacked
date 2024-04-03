package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ChainedMemberScope implements MemberScope {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String debugName;
    /* access modifiers changed from: private */
    @NotNull
    public final MemberScope[] scopes;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MemberScope create(@NotNull String str, @NotNull Iterable<? extends MemberScope> iterable) {
            Intrinsics.checkNotNullParameter(str, "debugName");
            Intrinsics.checkNotNullParameter(iterable, "scopes");
            SmartList smartList = new SmartList();
            for (MemberScope memberScope : iterable) {
                if (memberScope != MemberScope.Empty.INSTANCE) {
                    if (memberScope instanceof ChainedMemberScope) {
                        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(smartList, (T[]) ((ChainedMemberScope) memberScope).scopes);
                    } else {
                        smartList.add(memberScope);
                    }
                }
            }
            return createOrSingle$descriptors(str, smartList);
        }

        @NotNull
        public final MemberScope createOrSingle$descriptors(@NotNull String str, @NotNull List<? extends MemberScope> list) {
            Intrinsics.checkNotNullParameter(str, "debugName");
            Intrinsics.checkNotNullParameter(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return MemberScope.Empty.INSTANCE;
            }
            if (size == 1) {
                return (MemberScope) list.get(0);
            }
            Object[] array = list.toArray(new MemberScope[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new ChainedMemberScope(str, (MemberScope[]) array, (DefaultConstructorMarker) null);
        }
    }

    private ChainedMemberScope(String str, MemberScope[] memberScopeArr) {
        this.debugName = str;
        this.scopes = memberScopeArr;
    }

    public /* synthetic */ ChainedMemberScope(String str, MemberScope[] memberScopeArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, memberScopeArr);
    }

    @Nullable
    public Set<Name> getClassifierNames() {
        return MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt___ArraysKt.asIterable((T[]) this.scopes));
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope contributedClassifier : this.scopes) {
            ClassifierDescriptor contributedClassifier2 = contributedClassifier.getContributedClassifier(name2, lookupLocation);
            if (contributedClassifier2 != null) {
                if (!(contributedClassifier2 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier2).isExpect()) {
                    return contributedClassifier2;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier2;
                }
            }
        }
        return classifierDescriptor;
    }

    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedDescriptors(descriptorKindFilter, function1);
        }
        Collection<DeclarationDescriptor> collection = null;
        for (MemberScope contributedDescriptors : memberScopeArr) {
            collection = ScopeUtilsKt.concat(collection, contributedDescriptors.getContributedDescriptors(descriptorKindFilter, function1));
        }
        if (collection == null) {
            return SetsKt__SetsKt.emptySet();
        }
        return collection;
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedFunctions(name2, lookupLocation);
        }
        Collection<SimpleFunctionDescriptor> collection = null;
        for (MemberScope contributedFunctions : memberScopeArr) {
            collection = ScopeUtilsKt.concat(collection, contributedFunctions.getContributedFunctions(name2, lookupLocation));
        }
        if (collection == null) {
            return SetsKt__SetsKt.emptySet();
        }
        return collection;
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedVariables(name2, lookupLocation);
        }
        Collection<PropertyDescriptor> collection = null;
        for (MemberScope contributedVariables : memberScopeArr) {
            collection = ScopeUtilsKt.concat(collection, contributedVariables.getContributedVariables(name2, lookupLocation));
        }
        if (collection == null) {
            return SetsKt__SetsKt.emptySet();
        }
        return collection;
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        MemberScope[] memberScopeArr = this.scopes;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope functionNames : memberScopeArr) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, functionNames.getFunctionNames());
        }
        return linkedHashSet;
    }

    @NotNull
    public Set<Name> getVariableNames() {
        MemberScope[] memberScopeArr = this.scopes;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope variableNames : memberScopeArr) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, variableNames.getVariableNames());
        }
        return linkedHashSet;
    }

    public void recordLookup(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        for (MemberScope recordLookup : this.scopes) {
            recordLookup.recordLookup(name2, lookupLocation);
        }
    }

    @NotNull
    public String toString() {
        return this.debugName;
    }
}
