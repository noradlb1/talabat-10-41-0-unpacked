package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.apptimize.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaStaticClassScope extends LazyJavaStaticScope {
    @NotNull
    private final JavaClass jClass;
    @NotNull
    private final LazyJavaClassDescriptor ownerDescriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaClass javaClass, @NotNull LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(lazyJavaResolverContext);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        Intrinsics.checkNotNullParameter(lazyJavaClassDescriptor, "ownerDescriptor");
        this.jClass = javaClass;
        this.ownerDescriptor = lazyJavaClassDescriptor;
    }

    private final <R> Set<R> flatMapJavaStaticSupertypesScopes(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
        DFS.dfs(CollectionsKt__CollectionsJVMKt.listOf(classDescriptor), LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1.INSTANCE, new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(classDescriptor, set, function1));
        return set;
    }

    private final PropertyDescriptor getRealOriginal(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor.getKind().isReal()) {
            return propertyDescriptor;
        }
        Collection<? extends PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        Iterable<PropertyDescriptor> iterable = overriddenDescriptors;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (PropertyDescriptor propertyDescriptor2 : iterable) {
            Intrinsics.checkNotNullExpressionValue(propertyDescriptor2, "it");
            arrayList.add(getRealOriginal(propertyDescriptor2));
        }
        return (PropertyDescriptor) CollectionsKt___CollectionsKt.single(CollectionsKt___CollectionsKt.distinct(arrayList));
    }

    private final Set<SimpleFunctionDescriptor> getStaticFunctionsFromJavaSuperClasses(Name name2, ClassDescriptor classDescriptor) {
        LazyJavaStaticClassScope parentJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(classDescriptor);
        if (parentJavaStaticClassScope == null) {
            return SetsKt__SetsKt.emptySet();
        }
        return CollectionsKt___CollectionsKt.toSet(parentJavaStaticClassScope.getContributedFunctions(name2, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    @NotNull
    public Set<Name> a(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return SetsKt__SetsKt.emptySet();
    }

    public void c(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name2) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name2, "name");
        i().getComponents().getSyntheticPartsProvider().generateStaticFunctions(getOwnerDescriptor(), name2, collection);
    }

    @NotNull
    public Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Set<Name> set;
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Set<Name> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(((DeclaredMemberIndex) j().invoke()).getMethodNames());
        LazyJavaStaticClassScope parentJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(getOwnerDescriptor());
        if (parentJavaStaticClassScope != null) {
            set = parentJavaStaticClassScope.getFunctionNames();
        } else {
            set = null;
        }
        if (set == null) {
            set = SetsKt__SetsKt.emptySet();
        }
        mutableSet.addAll(set);
        if (this.jClass.isEnum()) {
            mutableSet.addAll(CollectionsKt__CollectionsKt.listOf(StandardNames.ENUM_VALUE_OF, StandardNames.ENUM_VALUES));
        }
        mutableSet.addAll(i().getComponents().getSyntheticPartsProvider().getStaticFunctionNames(getOwnerDescriptor()));
        return mutableSet;
    }

    public void e(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name2) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name2, "name");
        Collection<D> resolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name2, getStaticFunctionsFromJavaSuperClasses(name2, getOwnerDescriptor()), collection, getOwnerDescriptor(), i().getComponents().getErrorReporter(), i().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers, "resolveOverridesForStati….overridingUtil\n        )");
        collection.addAll(resolveOverridesForStaticMembers);
        if (!this.jClass.isEnum()) {
            return;
        }
        if (Intrinsics.areEqual((Object) name2, (Object) StandardNames.ENUM_VALUE_OF)) {
            SimpleFunctionDescriptor createEnumValueOfMethod = DescriptorFactory.createEnumValueOfMethod(getOwnerDescriptor());
            Intrinsics.checkNotNullExpressionValue(createEnumValueOfMethod, "createEnumValueOfMethod(ownerDescriptor)");
            collection.add(createEnumValueOfMethod);
        } else if (Intrinsics.areEqual((Object) name2, (Object) StandardNames.ENUM_VALUES)) {
            SimpleFunctionDescriptor createEnumValuesMethod = DescriptorFactory.createEnumValuesMethod(getOwnerDescriptor());
            Intrinsics.checkNotNullExpressionValue(createEnumValuesMethod, "createEnumValuesMethod(ownerDescriptor)");
            collection.add(createEnumValuesMethod);
        }
    }

    public void f(@NotNull Name name2, @NotNull Collection<PropertyDescriptor> collection) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        Set flatMapJavaStaticSupertypesScopes = flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), new LinkedHashSet(), new LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(name2));
        if (!collection.isEmpty()) {
            Collection<D> resolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name2, flatMapJavaStaticSupertypesScopes, collection, getOwnerDescriptor(), i().getComponents().getErrorReporter(), i().getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers, "resolveOverridesForStati…ingUtil\n                )");
            collection.addAll(resolveOverridesForStaticMembers);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : flatMapJavaStaticSupertypesScopes) {
            PropertyDescriptor realOriginal = getRealOriginal((PropertyDescriptor) next);
            Object obj = linkedHashMap.get(realOriginal);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(realOriginal, obj);
            }
            ((List) obj).add(next);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry value : linkedHashMap.entrySet()) {
            Collection<D> resolveOverridesForStaticMembers2 = DescriptorResolverUtils.resolveOverridesForStaticMembers(name2, (Collection) value.getValue(), collection, getOwnerDescriptor(), i().getComponents().getErrorReporter(), i().getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers2, "resolveOverridesForStati…ingUtil\n                )");
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, resolveOverridesForStaticMembers2);
        }
        collection.addAll(arrayList);
    }

    @NotNull
    public Set<Name> g(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Set<Name> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(((DeclaredMemberIndex) j().invoke()).getFieldNames());
        flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), mutableSet, LazyJavaStaticClassScope$computePropertyNames$1$1.INSTANCE);
        return mutableSet;
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return null;
    }

    @NotNull
    /* renamed from: q */
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, LazyJavaStaticClassScope$computeMemberIndex$1.INSTANCE);
    }

    @NotNull
    /* renamed from: r */
    public LazyJavaClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
