package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.apptimize.c;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmPackageScope implements MemberScope {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24595a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f24596c;
    @NotNull
    private final LazyJavaPackageScope javaScope;
    @NotNull
    private final NotNullLazyValue kotlinScopes$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final LazyJavaPackageFragment packageFragment;

    public JvmPackageScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaPackage javaPackage, @NotNull LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragment, "packageFragment");
        this.f24596c = lazyJavaResolverContext;
        this.packageFragment = lazyJavaPackageFragment;
        this.javaScope = new LazyJavaPackageScope(lazyJavaResolverContext, javaPackage, lazyJavaPackageFragment);
        this.kotlinScopes$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new JvmPackageScope$kotlinScopes$2(this));
    }

    private final MemberScope[] getKotlinScopes() {
        return (MemberScope[]) StorageKt.getValue(this.kotlinScopes$delegate, (Object) this, (KProperty<?>) f24595a[0]);
    }

    @Nullable
    public Set<Name> getClassifierNames() {
        Set<Name> flatMapClassifierNamesOrNull = MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt___ArraysKt.asIterable((T[]) getKotlinScopes()));
        if (flatMapClassifierNamesOrNull == null) {
            return null;
        }
        flatMapClassifierNamesOrNull.addAll(this.javaScope.getClassifierNames());
        return flatMapClassifierNamesOrNull;
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name2, lookupLocation);
        ClassDescriptor contributedClassifier = this.javaScope.getContributedClassifier(name2, lookupLocation);
        if (contributedClassifier != null) {
            return contributedClassifier;
        }
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope contributedClassifier2 : getKotlinScopes()) {
            ClassifierDescriptor contributedClassifier3 = contributedClassifier2.getContributedClassifier(name2, lookupLocation);
            if (contributedClassifier3 != null) {
                if (!(contributedClassifier3 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier3).isExpect()) {
                    return contributedClassifier3;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier3;
                }
            }
        }
        return classifierDescriptor;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "kindFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "nameFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope r0 = r5.javaScope
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] r1 = r5.getKotlinScopes()
            java.util.Collection r0 = r0.getContributedDescriptors(r6, r7)
            int r2 = r1.length
            r3 = 0
        L_0x0016:
            if (r3 >= r2) goto L_0x0025
            r4 = r1[r3]
            java.util.Collection r4 = r4.getContributedDescriptors(r6, r7)
            java.util.Collection r0 = kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.concat(r0, r4)
            int r3 = r3 + 1
            goto L_0x0016
        L_0x0025:
            if (r0 != 0) goto L_0x002b
            java.util.Set r0 = kotlin.collections.SetsKt__SetsKt.emptySet()
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope.getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name2, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection contributedFunctions = lazyJavaPackageScope.getContributedFunctions(name2, lookupLocation);
        for (MemberScope contributedFunctions2 : kotlinScopes) {
            contributedFunctions = ScopeUtilsKt.concat(contributedFunctions, contributedFunctions2.getContributedFunctions(name2, lookupLocation));
        }
        if (contributedFunctions == null) {
            return SetsKt__SetsKt.emptySet();
        }
        return contributedFunctions;
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name2, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection contributedVariables = lazyJavaPackageScope.getContributedVariables(name2, lookupLocation);
        for (MemberScope contributedVariables2 : kotlinScopes) {
            contributedVariables = ScopeUtilsKt.concat(contributedVariables, contributedVariables2.getContributedVariables(name2, lookupLocation));
        }
        if (contributedVariables == null) {
            return SetsKt__SetsKt.emptySet();
        }
        return contributedVariables;
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        MemberScope[] kotlinScopes = getKotlinScopes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope functionNames : kotlinScopes) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, functionNames.getFunctionNames());
        }
        linkedHashSet.addAll(this.javaScope.getFunctionNames());
        return linkedHashSet;
    }

    @NotNull
    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    @NotNull
    public Set<Name> getVariableNames() {
        MemberScope[] kotlinScopes = getKotlinScopes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope variableNames : kotlinScopes) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, variableNames.getVariableNames());
        }
        linkedHashSet.addAll(this.javaScope.getVariableNames());
        return linkedHashSet;
    }

    public void recordLookup(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        UtilsKt.record(this.f24596c.getComponents().getLookupTracker(), lookupLocation, (PackageFragmentDescriptor) this.packageFragment, name2);
    }

    @NotNull
    public String toString() {
        return "scope for " + this.packageFragment;
    }
}
