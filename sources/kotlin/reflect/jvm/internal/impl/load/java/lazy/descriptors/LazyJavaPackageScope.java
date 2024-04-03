package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.apptimize.c;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    @NotNull
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;
    @NotNull
    private final JavaPackage jPackage;
    @NotNull
    private final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    @NotNull
    private final LazyJavaPackageFragment ownerDescriptor;

    public static final class FindClassRequest {
        @Nullable
        private final JavaClass javaClass;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final Name f24625name;

        public FindClassRequest(@NotNull Name name2, @Nullable JavaClass javaClass2) {
            Intrinsics.checkNotNullParameter(name2, "name");
            this.f24625name = name2;
            this.javaClass = javaClass2;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof FindClassRequest) && Intrinsics.areEqual((Object) this.f24625name, (Object) ((FindClassRequest) obj).f24625name);
        }

        @Nullable
        public final JavaClass getJavaClass() {
            return this.javaClass;
        }

        @NotNull
        public final Name getName() {
            return this.f24625name;
        }

        public int hashCode() {
            return this.f24625name.hashCode();
        }
    }

    public static abstract class KotlinClassLookupResult {

        public static final class Found extends KotlinClassLookupResult {
            @NotNull
            private final ClassDescriptor descriptor;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Found(@NotNull ClassDescriptor classDescriptor) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
                this.descriptor = classDescriptor;
            }

            @NotNull
            public final ClassDescriptor getDescriptor() {
                return this.descriptor;
            }
        }

        public static final class NotFound extends KotlinClassLookupResult {
            @NotNull
            public static final NotFound INSTANCE = new NotFound();

            private NotFound() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class SyntheticClass extends KotlinClassLookupResult {
            @NotNull
            public static final SyntheticClass INSTANCE = new SyntheticClass();

            private SyntheticClass() {
                super((DefaultConstructorMarker) null);
            }
        }

        private KotlinClassLookupResult() {
        }

        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaPackage javaPackage, @NotNull LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(lazyJavaResolverContext);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragment, "ownerDescriptor");
        this.jPackage = javaPackage;
        this.ownerDescriptor = lazyJavaPackageFragment;
        this.knownClassNamesInPackage = lazyJavaResolverContext.getStorageManager().createNullableLazyValue(new LazyJavaPackageScope$knownClassNamesInPackage$1(lazyJavaResolverContext, this));
        this.classes = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaPackageScope$classes$1(this, lazyJavaResolverContext));
    }

    private final ClassDescriptor findClassifier(Name name2, JavaClass javaClass) {
        if (!SpecialNames.INSTANCE.isSafeIdentifier(name2)) {
            return null;
        }
        Set set = (Set) this.knownClassNamesInPackage.invoke();
        if (javaClass != null || set == null || set.contains(name2.asString())) {
            return this.classes.invoke(new FindClassRequest(name2, javaClass));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass == null) {
            return KotlinClassLookupResult.NotFound.INSTANCE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().getKind() != KotlinClassHeader.Kind.CLASS) {
            return KotlinClassLookupResult.SyntheticClass.INSTANCE;
        }
        ClassDescriptor resolveClass = i().getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinJvmBinaryClass);
        if (resolveClass != null) {
            return new KotlinClassLookupResult.Found(resolveClass);
        }
        return KotlinClassLookupResult.NotFound.INSTANCE;
    }

    @NotNull
    public Set<Name> a(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Name name2;
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        if (!descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return SetsKt__SetsKt.emptySet();
        }
        Set<String> set = (Set) this.knownClassNamesInPackage.invoke();
        if (set != null) {
            HashSet hashSet = new HashSet();
            for (String identifier : set) {
                hashSet.add(Name.identifier(identifier));
            }
            return hashSet;
        }
        JavaPackage javaPackage = this.jPackage;
        if (function1 == null) {
            function1 = FunctionsKt.alwaysTrue();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaClass javaClass : javaPackage.getClasses(function1)) {
            if (javaClass.getLightClassOriginKind() == LightClassOriginKind.SOURCE) {
                name2 = null;
            } else {
                name2 = javaClass.getName();
            }
            if (name2 != null) {
                linkedHashSet.add(name2);
            }
        }
        return linkedHashSet;
    }

    @NotNull
    public Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return SetsKt__SetsKt.emptySet();
    }

    @NotNull
    public DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    public void e(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name2) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name2, "name");
    }

    @Nullable
    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(@NotNull JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        return findClassifier(javaClass.getName(), javaClass);
    }

    @NotNull
    public Set<Name> g(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return SetsKt__SetsKt.emptySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "kindFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "nameFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter$Companion r0 = kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion
            int r1 = r0.getCLASSIFIERS_MASK()
            int r0 = r0.getNON_SINGLETON_CLASSIFIERS_MASK()
            r0 = r0 | r1
            boolean r5 = r5.acceptsKinds(r0)
            if (r5 != 0) goto L_0x0022
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.util.Collection r5 = (java.util.Collection) r5
            goto L_0x0067
        L_0x0022:
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r5 = r4.h()
            java.lang.Object r5 = r5.invoke()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x0035:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0066
            java.lang.Object r1 = r5.next()
            r2 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r2
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L_0x005f
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            kotlin.reflect.jvm.internal.impl.name.Name r2 = r2.getName()
            java.lang.String r3 = "it.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Object r2 = r6.invoke(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x005f
            r2 = 1
            goto L_0x0060
        L_0x005f:
            r2 = 0
        L_0x0060:
            if (r2 == 0) goto L_0x0035
            r0.add(r1)
            goto L_0x0035
        L_0x0066:
            r5 = r0
        L_0x0067:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    /* renamed from: q */
    public LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    @Nullable
    public ClassDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return findClassifier(name2, (JavaClass) null);
    }
}
