package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.apptimize.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class LazyJavaScope extends MemberScopeImpl {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24630a;
    @NotNull
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final LazyJavaResolverContext f24631c;
    @NotNull
    private final NotNullLazyValue classNamesLazy$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField;
    /* access modifiers changed from: private */
    @NotNull
    public final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions;
    @NotNull
    private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;
    @NotNull
    private final NotNullLazyValue functionNamesLazy$delegate;
    @NotNull
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    @Nullable
    private final LazyJavaScope mainScope;
    @NotNull
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;
    @NotNull
    private final NotNullLazyValue propertyNamesLazy$delegate;

    public static final class MethodSignatureData {
        @NotNull
        private final List<String> errors;
        private final boolean hasStableParameterNames;
        @Nullable
        private final KotlinType receiverType;
        @NotNull
        private final KotlinType returnType;
        @NotNull
        private final List<TypeParameterDescriptor> typeParameters;
        @NotNull
        private final List<ValueParameterDescriptor> valueParameters;

        public MethodSignatureData(@NotNull KotlinType kotlinType, @Nullable KotlinType kotlinType2, @NotNull List<? extends ValueParameterDescriptor> list, @NotNull List<? extends TypeParameterDescriptor> list2, boolean z11, @NotNull List<String> list3) {
            Intrinsics.checkNotNullParameter(kotlinType, "returnType");
            Intrinsics.checkNotNullParameter(list, "valueParameters");
            Intrinsics.checkNotNullParameter(list2, "typeParameters");
            Intrinsics.checkNotNullParameter(list3, "errors");
            this.returnType = kotlinType;
            this.receiverType = kotlinType2;
            this.valueParameters = list;
            this.typeParameters = list2;
            this.hasStableParameterNames = z11;
            this.errors = list3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodSignatureData)) {
                return false;
            }
            MethodSignatureData methodSignatureData = (MethodSignatureData) obj;
            return Intrinsics.areEqual((Object) this.returnType, (Object) methodSignatureData.returnType) && Intrinsics.areEqual((Object) this.receiverType, (Object) methodSignatureData.receiverType) && Intrinsics.areEqual((Object) this.valueParameters, (Object) methodSignatureData.valueParameters) && Intrinsics.areEqual((Object) this.typeParameters, (Object) methodSignatureData.typeParameters) && this.hasStableParameterNames == methodSignatureData.hasStableParameterNames && Intrinsics.areEqual((Object) this.errors, (Object) methodSignatureData.errors);
        }

        @NotNull
        public final List<String> getErrors() {
            return this.errors;
        }

        public final boolean getHasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        @Nullable
        public final KotlinType getReceiverType() {
            return this.receiverType;
        }

        @NotNull
        public final KotlinType getReturnType() {
            return this.returnType;
        }

        @NotNull
        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.typeParameters;
        }

        @NotNull
        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.valueParameters;
        }

        public int hashCode() {
            int hashCode = this.returnType.hashCode() * 31;
            KotlinType kotlinType = this.receiverType;
            int hashCode2 = (((((hashCode + (kotlinType == null ? 0 : kotlinType.hashCode())) * 31) + this.valueParameters.hashCode()) * 31) + this.typeParameters.hashCode()) * 31;
            boolean z11 = this.hasStableParameterNames;
            if (z11) {
                z11 = true;
            }
            return ((hashCode2 + (z11 ? 1 : 0)) * 31) + this.errors.hashCode();
        }

        @NotNull
        public String toString() {
            return "MethodSignatureData(returnType=" + this.returnType + ", receiverType=" + this.receiverType + ", valueParameters=" + this.valueParameters + ", typeParameters=" + this.typeParameters + ", hasStableParameterNames=" + this.hasStableParameterNames + ", errors=" + this.errors + ')';
        }
    }

    public static final class ResolvedValueParameters {
        @NotNull
        private final List<ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        public ResolvedValueParameters(@NotNull List<? extends ValueParameterDescriptor> list, boolean z11) {
            Intrinsics.checkNotNullParameter(list, "descriptors");
            this.descriptors = list;
            this.hasSynthesizedNames = z11;
        }

        @NotNull
        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.descriptors;
        }

        public final boolean getHasSynthesizedNames() {
            return this.hasSynthesizedNames;
        }
    }

    static {
        Class<LazyJavaScope> cls = LazyJavaScope.class;
        f24630a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaScope lazyJavaScope, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, (i11 & 2) != 0 ? null : lazyJavaScope);
    }

    private final PropertyDescriptorImpl createPropertyDescriptor(JavaField javaField) {
        JavaPropertyDescriptor create = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.f24631c, javaField), Modality.FINAL, UtilsKt.toDescriptorVisibility(javaField.getVisibility()), !javaField.isFinal(), javaField.getName(), this.f24631c.getComponents().getSourceElementFactory().source(javaField), isFinalStatic(javaField));
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            owne…d.isFinalStatic\n        )");
        return create;
    }

    private final Set<Name> getClassNamesLazy() {
        return (Set) StorageKt.getValue(this.classNamesLazy$delegate, (Object) this, (KProperty<?>) f24630a[2]);
    }

    private final Set<Name> getFunctionNamesLazy() {
        return (Set) StorageKt.getValue(this.functionNamesLazy$delegate, (Object) this, (KProperty<?>) f24630a[0]);
    }

    private final Set<Name> getPropertyNamesLazy() {
        return (Set) StorageKt.getValue(this.propertyNamesLazy$delegate, (Object) this, (KProperty<?>) f24630a[1]);
    }

    private final KotlinType getPropertyType(JavaField javaField) {
        boolean z11 = false;
        KotlinType transformJavaType = this.f24631c.getTypeResolver().transformJavaType(javaField.getType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 3, (Object) null));
        if ((KotlinBuiltIns.isPrimitiveType(transformJavaType) || KotlinBuiltIns.isString(transformJavaType)) && isFinalStatic(javaField) && javaField.getHasConstantNotNullInitializer()) {
            z11 = true;
        }
        if (!z11) {
            return transformJavaType;
        }
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(transformJavaType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(propertyType)");
        return makeNotNullable;
    }

    private final boolean isFinalStatic(JavaField javaField) {
        return javaField.isFinal() && javaField.isStatic();
    }

    /* access modifiers changed from: private */
    public final PropertyDescriptor resolveProperty(JavaField javaField) {
        PropertyDescriptorImpl createPropertyDescriptor = createPropertyDescriptor(javaField);
        createPropertyDescriptor.initialize((PropertyGetterDescriptorImpl) null, (PropertySetterDescriptor) null, (FieldDescriptor) null, (FieldDescriptor) null);
        createPropertyDescriptor.setType(getPropertyType(javaField), CollectionsKt__CollectionsKt.emptyList(), k(), (ReceiverParameterDescriptor) null, CollectionsKt__CollectionsKt.emptyList());
        if (DescriptorUtils.shouldRecordInitializerForProperty(createPropertyDescriptor, createPropertyDescriptor.getType())) {
            createPropertyDescriptor.setCompileTimeInitializerFactory(new LazyJavaScope$resolveProperty$1(this, javaField, createPropertyDescriptor));
        }
        this.f24631c.getComponents().getJavaResolverCache().recordField(javaField, createPropertyDescriptor);
        return createPropertyDescriptor;
    }

    /* access modifiers changed from: private */
    public final void retainMostSpecificMethods(Set<SimpleFunctionDescriptor> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T next : set) {
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) next, false, false, 2, (Object) null);
            Object obj = linkedHashMap.get(computeJvmDescriptor$default);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(computeJvmDescriptor$default, obj);
            }
            ((List) obj).add(next);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection collection = list;
                Collection selectMostSpecificInEachOverridableGroup = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(collection, LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1.INSTANCE);
                set.removeAll(collection);
                set.addAll(selectMostSpecificInEachOverridableGroup);
            }
        }
    }

    @NotNull
    public abstract Set<Name> a(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1);

    @NotNull
    public final List<DeclarationDescriptor> b(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name next : a(descriptorKindFilter, function1)) {
                if (function1.invoke(next).booleanValue()) {
                    CollectionsKt.addIfNotNull(linkedHashSet, getContributedClassifier(next, noLookupLocation));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) && !descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name next2 : computeFunctionNames(descriptorKindFilter, function1)) {
                if (function1.invoke(next2).booleanValue()) {
                    linkedHashSet.addAll(getContributedFunctions(next2, noLookupLocation));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) && !descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name next3 : g(descriptorKindFilter, function1)) {
                if (function1.invoke(next3).booleanValue()) {
                    linkedHashSet.addAll(getContributedVariables(next3, noLookupLocation));
                }
            }
        }
        return CollectionsKt___CollectionsKt.toList(linkedHashSet);
    }

    public void c(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name2) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name2, "name");
    }

    @NotNull
    public abstract Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1);

    @NotNull
    public abstract DeclaredMemberIndex computeMemberIndex();

    @NotNull
    public final KotlinType d(@NotNull JavaMethod javaMethod, @NotNull LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(javaMethod, "method");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        return lazyJavaResolverContext.getTypeResolver().transformJavaType(javaMethod.getReturnType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, javaMethod.getContainingClass().isAnnotationType(), (TypeParameterDescriptor) null, 2, (Object) null));
    }

    public abstract void e(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name2);

    public abstract void f(@NotNull Name name2, @NotNull Collection<PropertyDescriptor> collection);

    @NotNull
    public abstract Set<Name> g(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1);

    @NotNull
    public Set<Name> getClassifierNames() {
        return getClassNamesLazy();
    }

    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return (Collection) this.allDescriptors.invoke();
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (!getFunctionNames().contains(name2)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return this.functions.invoke(name2);
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (!getVariableNames().contains(name2)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return this.properties.invoke(name2);
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    @NotNull
    public abstract DeclarationDescriptor getOwnerDescriptor();

    @NotNull
    public Set<Name> getVariableNames() {
        return getPropertyNamesLazy();
    }

    @NotNull
    public final NotNullLazyValue<Collection<DeclarationDescriptor>> h() {
        return this.allDescriptors;
    }

    @NotNull
    public final LazyJavaResolverContext i() {
        return this.f24631c;
    }

    @NotNull
    public final NotNullLazyValue<DeclaredMemberIndex> j() {
        return this.declaredMemberIndex;
    }

    @Nullable
    public abstract ReceiverParameterDescriptor k();

    @Nullable
    public final LazyJavaScope l() {
        return this.mainScope;
    }

    public boolean m(@NotNull JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        return true;
    }

    @NotNull
    public abstract MethodSignatureData n(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull KotlinType kotlinType, @NotNull List<? extends ValueParameterDescriptor> list2);

    @NotNull
    public final JavaMethodDescriptor o(@NotNull JavaMethod javaMethod) {
        boolean z11;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        Map map;
        JavaMethod javaMethod2 = javaMethod;
        Intrinsics.checkNotNullParameter(javaMethod2, "method");
        Annotations resolveAnnotations = LazyJavaAnnotationsKt.resolveAnnotations(this.f24631c, javaMethod2);
        DeclarationDescriptor ownerDescriptor = getOwnerDescriptor();
        Name name2 = javaMethod.getName();
        JavaSourceElement source = this.f24631c.getComponents().getSourceElementFactory().source(javaMethod2);
        if (((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).findRecordComponentByName(javaMethod.getName()) == null || !javaMethod.getValueParameters().isEmpty()) {
            z11 = false;
        } else {
            z11 = true;
        }
        JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(ownerDescriptor, resolveAnnotations, name2, source, z11);
        Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(\n      …eters.isEmpty()\n        )");
        LazyJavaResolverContext childForMethod$default = ContextKt.childForMethod$default(this.f24631c, createJavaMethod, javaMethod, 0, 4, (Object) null);
        Iterable<JavaTypeParameter> typeParameters = javaMethod.getTypeParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(typeParameters, 10));
        for (JavaTypeParameter resolveTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter2 = childForMethod$default.getTypeParameterResolver().resolveTypeParameter(resolveTypeParameter);
            Intrinsics.checkNotNull(resolveTypeParameter2);
            arrayList.add(resolveTypeParameter2);
        }
        ResolvedValueParameters p11 = p(childForMethod$default, createJavaMethod, javaMethod.getValueParameters());
        MethodSignatureData n11 = n(javaMethod2, arrayList, d(javaMethod2, childForMethod$default), p11.getDescriptors());
        KotlinType receiverType = n11.getReceiverType();
        if (receiverType != null) {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(createJavaMethod, receiverType, Annotations.Companion.getEMPTY());
        } else {
            receiverParameterDescriptor = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = receiverParameterDescriptor;
        ReceiverParameterDescriptor k11 = k();
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        List<TypeParameterDescriptor> typeParameters2 = n11.getTypeParameters();
        List<ValueParameterDescriptor> valueParameters = n11.getValueParameters();
        KotlinType returnType = n11.getReturnType();
        Modality convertFromFlags = Modality.Companion.convertFromFlags(false, javaMethod.isAbstract(), !javaMethod.isFinal());
        DescriptorVisibility descriptorVisibility = UtilsKt.toDescriptorVisibility(javaMethod.getVisibility());
        if (n11.getReceiverType() != null) {
            map = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, CollectionsKt___CollectionsKt.first(p11.getDescriptors())));
        } else {
            map = MapsKt__MapsKt.emptyMap();
        }
        Map map2 = map;
        JavaMethodDescriptor javaMethodDescriptor = createJavaMethod;
        createJavaMethod.initialize(receiverParameterDescriptor2, k11, emptyList, typeParameters2, valueParameters, returnType, convertFromFlags, descriptorVisibility, map2);
        javaMethodDescriptor.setParameterNamesStatus(n11.getHasStableParameterNames(), p11.getHasSynthesizedNames());
        if (!n11.getErrors().isEmpty()) {
            childForMethod$default.getComponents().getSignaturePropagator().reportSignatureErrors(javaMethodDescriptor, n11.getErrors());
        }
        return javaMethodDescriptor;
    }

    /* JADX WARNING: type inference failed for: r8v8, types: [kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.ResolvedValueParameters p(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r22, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r23, @org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> r24) {
        /*
            r21 = this;
            r0 = r22
            r1 = r24
            java.lang.String r2 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "function"
            r15 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            java.lang.String r2 = "jValueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Iterable r2 = kotlin.collections.CollectionsKt___CollectionsKt.withIndex(r2)
            java.util.ArrayList r14 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r2, r3)
            r14.<init>(r3)
            java.util.Iterator r2 = r2.iterator()
            r13 = 0
            r3 = r13
        L_0x002d:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x013e
            java.lang.Object r4 = r2.next()
            kotlin.collections.IndexedValue r4 = (kotlin.collections.IndexedValue) r4
            int r6 = r4.component1()
            java.lang.Object r4 = r4.component2()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter r4 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter) r4
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r7 = kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(r0, r4)
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r5 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r8 = 3
            r9 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r5 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r5, r13, r9, r8, r9)
            boolean r8 = r4.isVararg()
            r10 = 1
            if (r8 == 0) goto L_0x0093
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r8 = r4.getType()
            boolean r11 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
            if (r11 == 0) goto L_0x0061
            r9 = r8
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType r9 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) r9
        L_0x0061:
            if (r9 == 0) goto L_0x007c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r8 = r22.getTypeResolver()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r8.transformArrayType(r9, r5, r10)
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r8 = r22.getModule()
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r8 = r8.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r8.getArrayElementType(r5)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r8)
            goto L_0x00a3
        L_0x007c:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Vararg parameter should be an array: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0093:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r8 = r22.getTypeResolver()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r11 = r4.getType()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r8.transformJavaType(r11, r5)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r9)
        L_0x00a3:
            java.lang.Object r8 = r5.component1()
            r9 = r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r9
            java.lang.Object r5 = r5.component2()
            r16 = r5
            kotlin.reflect.jvm.internal.impl.types.KotlinType r16 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r16
            kotlin.reflect.jvm.internal.impl.name.Name r5 = r23.getName()
            java.lang.String r5 = r5.asString()
            java.lang.String r8 = "equals"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x00e1
            int r5 = r24.size()
            if (r5 != r10) goto L_0x00e1
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r5 = r22.getModule()
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r5 = r5.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r5 = r5.getNullableAnyType()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r9)
            if (r5 == 0) goto L_0x00e1
            java.lang.String r5 = "other"
            kotlin.reflect.jvm.internal.impl.name.Name r5 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r5)
            goto L_0x0104
        L_0x00e1:
            kotlin.reflect.jvm.internal.impl.name.Name r5 = r4.getName()
            if (r5 != 0) goto L_0x00e8
            r3 = r10
        L_0x00e8:
            if (r5 != 0) goto L_0x0104
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r8 = 112(0x70, float:1.57E-43)
            r5.append(r8)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            kotlin.reflect.jvm.internal.impl.name.Name r5 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r5)
            java.lang.String r8 = "identifier(\"p$index\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
        L_0x0104:
            r17 = r3
            r8 = r5
            java.lang.String r3 = "if (function.name.asStri…(\"p$index\")\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl r12 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl
            r5 = 0
            r10 = 0
            r11 = 0
            r18 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r3 = r22.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r3 = r3.getSourceElementFactory()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r19 = r3.source(r4)
            r3 = r12
            r4 = r23
            r20 = r12
            r12 = r18
            r18 = r13
            r13 = r16
            r0 = r14
            r14 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r3 = r20
            r0.add(r3)
            r14 = r0
            r3 = r17
            r13 = r18
            r0 = r22
            goto L_0x002d
        L_0x013e:
            r0 = r14
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters
            r1.<init>(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.p(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.util.List):kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters");
    }

    @NotNull
    public String toString() {
        return "Lazy scope for " + getOwnerDescriptor();
    }

    public LazyJavaScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @Nullable LazyJavaScope lazyJavaScope) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        this.f24631c = lazyJavaResolverContext;
        this.mainScope = lazyJavaScope;
        this.allDescriptors = lazyJavaResolverContext.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaScope$allDescriptors$1(this), CollectionsKt__CollectionsKt.emptyList());
        this.declaredMemberIndex = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaScope$declaredMemberIndex$1(this));
        this.declaredFunctions = lazyJavaResolverContext.getStorageManager().createMemoizedFunction(new LazyJavaScope$declaredFunctions$1(this));
        this.declaredField = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaScope$declaredField$1(this));
        this.functions = lazyJavaResolverContext.getStorageManager().createMemoizedFunction(new LazyJavaScope$functions$1(this));
        this.functionNamesLazy$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaScope$functionNamesLazy$2(this));
        this.propertyNamesLazy$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaScope$propertyNamesLazy$2(this));
        this.classNamesLazy$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaScope$classNamesLazy$2(this));
        this.properties = lazyJavaResolverContext.getStorageManager().createMemoizedFunction(new LazyJavaScope$properties$1(this));
    }
}
