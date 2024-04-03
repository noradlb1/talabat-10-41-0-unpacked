package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.apptimize.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaClassMemberScope extends LazyJavaScope {
    @NotNull
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
    /* access modifiers changed from: private */
    @NotNull
    public final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
    /* access modifiers changed from: private */
    @NotNull
    public final JavaClass jClass;
    /* access modifiers changed from: private */
    @NotNull
    public final NotNullLazyValue<Set<Name>> nestedClassIndex;
    @NotNull
    private final MemoizedFunctionToNullable<Name, ClassDescriptorBase> nestedClasses;
    @NotNull
    private final ClassDescriptor ownerDescriptor;
    private final boolean skipRefinement;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaClassMemberScope(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, JavaClass javaClass, boolean z11, LazyJavaClassMemberScope lazyJavaClassMemberScope, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, classDescriptor, javaClass, z11, (i11 & 16) != 0 ? null : lazyJavaClassMemberScope);
    }

    private final void addAnnotationValueParameter(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i11, JavaMethod javaMethod, KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType kotlinType3;
        Annotations empty = Annotations.Companion.getEMPTY();
        Name name2 = javaMethod.getName();
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(returnType)");
        boolean hasAnnotationParameterDefaultValue = javaMethod.getHasAnnotationParameterDefaultValue();
        if (kotlinType2 != null) {
            kotlinType3 = TypeUtils.makeNotNullable(kotlinType2);
        } else {
            kotlinType3 = null;
        }
        List<ValueParameterDescriptor> list2 = list;
        list.add(new ValueParameterDescriptorImpl(constructorDescriptor, (ValueParameterDescriptor) null, i11, empty, name2, makeNotNullable, hasAnnotationParameterDefaultValue, false, false, kotlinType3, i().getComponents().getSourceElementFactory().source(javaMethod)));
    }

    private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> collection, Name name2, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z11) {
        Collection<D> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name2, collection2, collection, getOwnerDescriptor(), i().getComponents().getErrorReporter(), i().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonSt….overridingUtil\n        )");
        if (!z11) {
            collection.addAll(resolveOverridesForNonStaticMembers);
            return;
        }
        Iterable<SimpleFunctionDescriptor> iterable = resolveOverridesForNonStaticMembers;
        List plus = CollectionsKt___CollectionsKt.plus(collection, iterable);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : iterable) {
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenSpecialBuiltin(simpleFunctionDescriptor);
            if (simpleFunctionDescriptor2 == null) {
                Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptor, "resolvedOverride");
            } else {
                Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptor, "resolvedOverride");
                simpleFunctionDescriptor = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(simpleFunctionDescriptor, simpleFunctionDescriptor2, plus);
            }
            arrayList.add(simpleFunctionDescriptor);
        }
        collection.addAll(arrayList);
    }

    private final void addOverriddenSpecialMethods(Name name2, Collection<? extends SimpleFunctionDescriptor> collection, Collection<? extends SimpleFunctionDescriptor> collection2, Collection<SimpleFunctionDescriptor> collection3, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : collection2) {
            CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltinWithDifferentJvmName(simpleFunctionDescriptor, function1, name2, collection));
            CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltInWithErasedValueParametersInJava(simpleFunctionDescriptor, function1, collection));
            CollectionsKt.addIfNotNull(collection3, obtainOverrideForSuspend(simpleFunctionDescriptor, function1));
        }
    }

    private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (PropertyDescriptor propertyDescriptor : set) {
            JavaPropertyDescriptor createPropertyDescriptorByMethods = createPropertyDescriptorByMethods(propertyDescriptor, function1);
            if (createPropertyDescriptorByMethods != null) {
                collection.add(createPropertyDescriptorByMethods);
                if (set2 != null) {
                    set2.add(propertyDescriptor);
                    return;
                }
                return;
            }
        }
    }

    private final void computeAnnotationProperties(Name name2, Collection<PropertyDescriptor> collection) {
        JavaMethod javaMethod = (JavaMethod) CollectionsKt___CollectionsKt.singleOrNull(((DeclaredMemberIndex) j().invoke()).findMethodsByName(name2));
        if (javaMethod != null) {
            collection.add(s(this, javaMethod, (KotlinType) null, Modality.FINAL, 2, (Object) null));
        }
    }

    private final Collection<KotlinType> computeSupertypes() {
        if (!this.skipRefinement) {
            return i().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
        }
        Collection<KotlinType> supertypes = getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        return supertypes;
    }

    private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl classConstructorDescriptorImpl) {
        Pair pair;
        Collection<JavaMethod> methods = this.jClass.getMethods();
        ArrayList arrayList = new ArrayList(methods.size());
        int i11 = 1;
        JavaTypeAttributes attributes$default = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, true, (TypeParameterDescriptor) null, 2, (Object) null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object next : methods) {
            if (Intrinsics.areEqual((Object) ((JavaMethod) next).getName(), (Object) JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                arrayList2.add(next);
            } else {
                arrayList3.add(next);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.component1();
        List<JavaMethod> list2 = (List) pair2.component2();
        list.size();
        JavaMethod javaMethod = (JavaMethod) CollectionsKt___CollectionsKt.firstOrNull(list);
        if (javaMethod != null) {
            JavaType returnType = javaMethod.getReturnType();
            if (returnType instanceof JavaArrayType) {
                JavaArrayType javaArrayType = (JavaArrayType) returnType;
                pair = new Pair(i().getTypeResolver().transformArrayType(javaArrayType, attributes$default, true), i().getTypeResolver().transformJavaType(javaArrayType.getComponentType(), attributes$default));
            } else {
                pair = new Pair(i().getTypeResolver().transformJavaType(returnType, attributes$default), null);
            }
            addAnnotationValueParameter(arrayList, classConstructorDescriptorImpl, 0, javaMethod, (KotlinType) pair.component1(), (KotlinType) pair.component2());
        }
        int i12 = 0;
        if (javaMethod == null) {
            i11 = 0;
        }
        for (JavaMethod javaMethod2 : list2) {
            addAnnotationValueParameter(arrayList, classConstructorDescriptorImpl, i12 + i11, javaMethod2, i().getTypeResolver().transformJavaType(javaMethod2.getReturnType(), attributes$default), (KotlinType) null);
            i12++;
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final ClassConstructorDescriptor createDefaultConstructor() {
        List<ValueParameterDescriptor> list;
        boolean isAnnotationType = this.jClass.isAnnotationType();
        if ((this.jClass.isInterface() || !this.jClass.hasDefaultConstructor()) && !isAnnotationType) {
            return null;
        }
        ClassDescriptor t11 = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(t11, Annotations.Companion.getEMPTY(), true, i().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(\n ….source(jClass)\n        )");
        if (isAnnotationType) {
            list = createAnnotationConstructorParameters(createJavaConstructor);
        } else {
            list = Collections.emptyList();
        }
        createJavaConstructor.setHasSynthesizedParameterNames(false);
        createJavaConstructor.initialize(list, getConstructorVisibility(t11));
        createJavaConstructor.setHasStableParameterNames(true);
        createJavaConstructor.setReturnType(t11.getDefaultType());
        i().getComponents().getJavaResolverCache().recordConstructor(this.jClass, createJavaConstructor);
        return createJavaConstructor;
    }

    /* access modifiers changed from: private */
    public final ClassConstructorDescriptor createDefaultRecordConstructor() {
        ClassDescriptor t11 = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(t11, Annotations.Companion.getEMPTY(), true, i().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<ValueParameterDescriptor> createRecordConstructorParameters = createRecordConstructorParameters(createJavaConstructor);
        createJavaConstructor.setHasSynthesizedParameterNames(false);
        createJavaConstructor.initialize(createRecordConstructorParameters, getConstructorVisibility(t11));
        createJavaConstructor.setHasStableParameterNames(false);
        createJavaConstructor.setReturnType(t11.getDefaultType());
        return createJavaConstructor;
    }

    private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        boolean z11;
        Iterable iterable = collection;
        boolean z12 = true;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
                if (Intrinsics.areEqual((Object) simpleFunctionDescriptor, (Object) simpleFunctionDescriptor2) || simpleFunctionDescriptor2.getInitialSignatureDescriptor() != null || !doesOverride(simpleFunctionDescriptor2, callableDescriptor)) {
                    z11 = false;
                    continue;
                } else {
                    z11 = true;
                    continue;
                }
                if (z11) {
                    z12 = false;
                    break;
                }
            }
        }
        if (z12) {
            return simpleFunctionDescriptor;
        }
        Object build = simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        Intrinsics.checkNotNull(build);
        return (SimpleFunctionDescriptor) build;
    }

    private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor functionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        Object obj;
        Name name2 = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "overridden.name");
        Iterator it = ((Iterable) function1.invoke(name2)).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (hasSameJvmDescriptorButDoesNotOverride((SimpleFunctionDescriptor) obj, functionDescriptor)) {
                break;
            }
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "overridden.valueParameters");
        Iterable<ValueParameterDescriptor> iterable = valueParameters;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ValueParameterDescriptor type : iterable) {
            arrayList.add(type.getType());
        }
        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "override.valueParameters");
        newCopyBuilder.setValueParameters(UtilKt.copyValueParameters(arrayList, valueParameters2, functionDescriptor));
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        newCopyBuilder.putUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS, Boolean.TRUE);
        return (SimpleFunctionDescriptor) newCopyBuilder.build();
    }

    private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = null;
        if (!doesClassOverridesProperty(propertyDescriptor, function1)) {
            return null;
        }
        SimpleFunctionDescriptor findGetterOverride = findGetterOverride(propertyDescriptor, function1);
        Intrinsics.checkNotNull(findGetterOverride);
        if (propertyDescriptor.isVar()) {
            simpleFunctionDescriptor = findSetterOverride(propertyDescriptor, function1);
            Intrinsics.checkNotNull(simpleFunctionDescriptor);
        } else {
            simpleFunctionDescriptor = null;
        }
        if (simpleFunctionDescriptor != null) {
            simpleFunctionDescriptor.getModality();
            findGetterOverride.getModality();
        }
        JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor = new JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), findGetterOverride, simpleFunctionDescriptor, propertyDescriptor);
        KotlinType returnType = findGetterOverride.getReturnType();
        Intrinsics.checkNotNull(returnType);
        JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor2 = javaForKotlinOverridePropertyDescriptor;
        javaForKotlinOverridePropertyDescriptor2.setType(returnType, CollectionsKt__CollectionsKt.emptyList(), k(), (ReceiverParameterDescriptor) null, CollectionsKt__CollectionsKt.emptyList());
        PropertyGetterDescriptorImpl createGetter = DescriptorFactory.createGetter(javaForKotlinOverridePropertyDescriptor2, findGetterOverride.getAnnotations(), false, false, false, findGetterOverride.getSource());
        createGetter.setInitialSignatureDescriptor(findGetterOverride);
        createGetter.initialize(javaForKotlinOverridePropertyDescriptor.getType());
        Intrinsics.checkNotNullExpressionValue(createGetter, "createGetter(\n          …escriptor.type)\n        }");
        if (simpleFunctionDescriptor != null) {
            List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "setterMethod.valueParameters");
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt___CollectionsKt.firstOrNull(valueParameters);
            if (valueParameterDescriptor != null) {
                propertySetterDescriptorImpl = DescriptorFactory.createSetter(javaForKotlinOverridePropertyDescriptor, simpleFunctionDescriptor.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor.getSource());
                propertySetterDescriptorImpl.setInitialSignatureDescriptor(simpleFunctionDescriptor);
            } else {
                throw new AssertionError("No parameter found for " + simpleFunctionDescriptor);
            }
        }
        javaForKotlinOverridePropertyDescriptor.initialize(createGetter, propertySetterDescriptorImpl);
        return javaForKotlinOverridePropertyDescriptor;
    }

    private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod javaMethod, KotlinType kotlinType, Modality modality) {
        KotlinType kotlinType2;
        JavaMethod javaMethod2 = javaMethod;
        JavaPropertyDescriptor create = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(i(), javaMethod2), modality, UtilsKt.toDescriptorVisibility(javaMethod.getVisibility()), false, javaMethod.getName(), i().getComponents().getSourceElementFactory().source(javaMethod2), false);
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            owne…inal = */ false\n        )");
        PropertyGetterDescriptorImpl createDefaultGetter = DescriptorFactory.createDefaultGetter(create, Annotations.Companion.getEMPTY());
        Intrinsics.checkNotNullExpressionValue(createDefaultGetter, "createDefaultGetter(prop…iptor, Annotations.EMPTY)");
        create.initialize(createDefaultGetter, (PropertySetterDescriptor) null);
        if (kotlinType == null) {
            kotlinType2 = d(javaMethod2, ContextKt.childForMethod$default(i(), create, javaMethod, 0, 4, (Object) null));
        } else {
            kotlinType2 = kotlinType;
        }
        create.setType(kotlinType2, CollectionsKt__CollectionsKt.emptyList(), k(), (ReceiverParameterDescriptor) null, CollectionsKt__CollectionsKt.emptyList());
        createDefaultGetter.initialize(kotlinType2);
        return create;
    }

    private final List<ValueParameterDescriptor> createRecordConstructorParameters(ClassConstructorDescriptorImpl classConstructorDescriptorImpl) {
        KotlinType kotlinType;
        Collection<JavaRecordComponent> recordComponents = this.jClass.getRecordComponents();
        ArrayList arrayList = new ArrayList(recordComponents.size());
        KotlinType kotlinType2 = null;
        JavaTypeAttributes attributes$default = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 2, (Object) null);
        int i11 = 0;
        for (JavaRecordComponent next : recordComponents) {
            int i12 = i11 + 1;
            KotlinType transformJavaType = i().getTypeResolver().transformJavaType(next.getType(), attributes$default);
            if (next.isVararg()) {
                kotlinType = i().getComponents().getModule().getBuiltIns().getArrayElementType(transformJavaType);
            } else {
                kotlinType = kotlinType2;
            }
            ValueParameterDescriptorImpl valueParameterDescriptorImpl = r7;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl2 = new ValueParameterDescriptorImpl(classConstructorDescriptorImpl, (ValueParameterDescriptor) null, i11, Annotations.Companion.getEMPTY(), next.getName(), transformJavaType, false, false, false, kotlinType, i().getComponents().getSourceElementFactory().source(next));
            arrayList.add(valueParameterDescriptorImpl);
            i11 = i12;
            kotlinType2 = null;
        }
        return arrayList;
    }

    private final SimpleFunctionDescriptor createRenamedCopy(SimpleFunctionDescriptor simpleFunctionDescriptor, Name name2) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setName(name2);
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        Object build = newCopyBuilder.build();
        Intrinsics.checkNotNull(build);
        return (SimpleFunctionDescriptor) build;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor createSuspendView(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.getValueParameters()
            java.lang.String r1 = "valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            r2 = 0
            if (r0 == 0) goto L_0x007e
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r0.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r3.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = r3.getDeclarationDescriptor()
            if (r3 == 0) goto L_0x0035
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(r3)
            if (r3 == 0) goto L_0x0035
            boolean r4 = r3.isSafe()
            if (r4 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r3 = r2
        L_0x002e:
            if (r3 == 0) goto L_0x0035
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = r3.toSafe()
            goto L_0x0036
        L_0x0035:
            r3 = r2
        L_0x0036:
            kotlin.reflect.jvm.internal.impl.name.FqName r4 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.CONTINUATION_INTERFACE_FQ_NAME
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r0 = r2
        L_0x0040:
            if (r0 != 0) goto L_0x0043
            goto L_0x007e
        L_0x0043:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r2 = r6.newCopyBuilder()
            java.util.List r6 = r6.getValueParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r1 = 1
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.dropLast(r6, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r2.setValueParameters(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            java.util.List r0 = r0.getArguments()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r6.setReturnType(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6 = r6.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r6
            r0 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl r0 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl) r0
            if (r0 != 0) goto L_0x007a
            goto L_0x007d
        L_0x007a:
            r0.setSuspend(r1)
        L_0x007d:
            return r6
        L_0x007e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.createSuspendView(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor");
    }

    private final boolean doesClassOverridesProperty(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor findGetterOverride = findGetterOverride(propertyDescriptor, function1);
        SimpleFunctionDescriptor findSetterOverride = findSetterOverride(propertyDescriptor, function1);
        if (findGetterOverride == null) {
            return false;
        }
        if (!propertyDescriptor.isVar()) {
            return true;
        }
        if (findSetterOverride == null || findSetterOverride.getModality() != findGetterOverride.getModality()) {
            return false;
        }
        return true;
    }

    private final boolean doesOverride(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(callableDescriptor2, callableDescriptor, true).getResult();
        Intrinsics.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByW…iptor, this, true).result");
        if (result != OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE || JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor2, callableDescriptor)) {
            return false;
        }
        return true;
    }

    private final boolean doesOverrideRenamedBuiltins(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        SpecialGenericSignatures.Companion companion = SpecialGenericSignatures.Companion;
        Name name2 = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "name");
        Name builtinFunctionNamesByJvmName = companion.getBuiltinFunctionNamesByJvmName(name2);
        if (builtinFunctionNamesByJvmName == null) {
            return false;
        }
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(builtinFunctionNamesByJvmName);
        ArrayList<SimpleFunctionDescriptor> arrayList = new ArrayList<>();
        for (T next : functionsFromSupertypes) {
            if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((SimpleFunctionDescriptor) next)) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        SimpleFunctionDescriptor createRenamedCopy = createRenamedCopy(simpleFunctionDescriptor, builtinFunctionNamesByJvmName);
        if (arrayList.isEmpty()) {
            return false;
        }
        for (SimpleFunctionDescriptor doesOverrideRenamedDescriptor : arrayList) {
            if (doesOverrideRenamedDescriptor(doesOverrideRenamedDescriptor, createRenamedCopy)) {
                return true;
            }
        }
        return false;
    }

    private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        Intrinsics.checkNotNullExpressionValue(functionDescriptor, "if (superDescriptor.isRe…iginal else subDescriptor");
        return doesOverride(functionDescriptor, simpleFunctionDescriptor);
    }

    private final boolean doesOverrideSuspendFunction(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z11;
        SimpleFunctionDescriptor createSuspendView = createSuspendView(simpleFunctionDescriptor);
        if (createSuspendView == null) {
            return false;
        }
        Name name2 = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name2);
        if ((functionsFromSupertypes instanceof Collection) && functionsFromSupertypes.isEmpty()) {
            return false;
        }
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : functionsFromSupertypes) {
            if (!simpleFunctionDescriptor2.isSuspend() || !doesOverride(createSuspendView, simpleFunctionDescriptor2)) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    private final SimpleFunctionDescriptor findGetterByName(PropertyDescriptor propertyDescriptor, String str, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        boolean z11;
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(getterName)");
        Iterator it = ((Iterable) function1.invoke(identifier)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                KotlinType returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null) {
                    z11 = false;
                } else {
                    z11 = kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType());
                }
                if (z11) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor findGetterOverride(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor propertyGetterDescriptor;
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        String str = null;
        if (getter != null) {
            propertyGetterDescriptor = (PropertyGetterDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(getter);
        } else {
            propertyGetterDescriptor = null;
        }
        if (propertyGetterDescriptor != null) {
            str = ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyGetterDescriptor);
        }
        if (str != null && !SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), propertyGetterDescriptor)) {
            return findGetterByName(propertyDescriptor, str, function1);
        }
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return findGetterByName(propertyDescriptor, JvmAbi.getterName(asString), function1);
    }

    private final SimpleFunctionDescriptor findSetterOverride(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        KotlinType returnType;
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        Name identifier = Name.identifier(JvmAbi.setterName(asString));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator it = ((Iterable) function1.invoke(identifier)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null && KotlinBuiltIns.isUnit(returnType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
                if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) CollectionsKt___CollectionsKt.single(valueParameters)).getType(), propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final DescriptorVisibility getConstructorVisibility(ClassDescriptor classDescriptor) {
        DescriptorVisibility visibility = classDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "classDescriptor.visibility");
        if (!Intrinsics.areEqual((Object) visibility, (Object) JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY)) {
            return visibility;
        }
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "PROTECTED_AND_PACKAGE");
        return descriptorVisibility;
    }

    private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name name2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (KotlinType memberScope : computeSupertypes()) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getContributedFunctions(name2, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name name2) {
        ArrayList arrayList = new ArrayList();
        for (KotlinType memberScope : computeSupertypes()) {
            Iterable<PropertyDescriptor> contributedVariables = memberScope.getMemberScope().getContributedVariables(name2, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(contributedVariables, 10));
            for (PropertyDescriptor add : contributedVariables) {
                arrayList2.add(add);
            }
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList);
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 2, (Object) null);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "builtinWithErasedParameters.original");
        if (!Intrinsics.areEqual((Object) computeJvmDescriptor$default, (Object) MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, (Object) null)) || doesOverride(simpleFunctionDescriptor, functionDescriptor)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        if (kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.isSetterName(r4) == false) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0079 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isVisibleAsFunctionInCurrentClass(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r7) {
        /*
            r6 = this;
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r7.getName()
            java.lang.String r1 = "function.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.List r0 = kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0020
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0020
        L_0x001e:
            r0 = r3
            goto L_0x007d
        L_0x0020:
            java.util.Iterator r0 = r0.iterator()
        L_0x0024:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x001e
            java.lang.Object r1 = r0.next()
            kotlin.reflect.jvm.internal.impl.name.Name r1 = (kotlin.reflect.jvm.internal.impl.name.Name) r1
            java.util.Set r1 = r6.getPropertiesFromSupertypes(r1)
            boolean r4 = r1 instanceof java.util.Collection
            if (r4 == 0) goto L_0x0040
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x0040
        L_0x003e:
            r1 = r3
            goto L_0x007a
        L_0x0040:
            java.util.Iterator r1 = r1.iterator()
        L_0x0044:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x003e
            java.lang.Object r4 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r4
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1 r5 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1
            r5.<init>(r7, r6)
            boolean r5 = r6.doesClassOverridesProperty(r4, r5)
            if (r5 == 0) goto L_0x0076
            boolean r4 = r4.isVar()
            if (r4 != 0) goto L_0x0074
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r7.getName()
            java.lang.String r4 = r4.asString()
            java.lang.String r5 = "function.name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r4 = kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.isSetterName(r4)
            if (r4 != 0) goto L_0x0076
        L_0x0074:
            r4 = r2
            goto L_0x0077
        L_0x0076:
            r4 = r3
        L_0x0077:
            if (r4 == 0) goto L_0x0044
            r1 = r2
        L_0x007a:
            if (r1 == 0) goto L_0x0024
            r0 = r2
        L_0x007d:
            if (r0 == 0) goto L_0x0080
            return r3
        L_0x0080:
            boolean r0 = r6.doesOverrideRenamedBuiltins(r7)
            if (r0 != 0) goto L_0x0093
            boolean r0 = r6.shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(r7)
            if (r0 != 0) goto L_0x0093
            boolean r7 = r6.doesOverrideSuspendFunction(r7)
            if (r7 != 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r2 = r3
        L_0x0094:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.isVisibleAsFunctionInCurrentClass(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):boolean");
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded;
        FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor);
        if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null || (createOverrideForBuiltinFunctionWithErasedParameterIfNeeded = createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(overriddenBuiltinFunctionWithErasedValueParametersInJava, function1)) == null) {
            return null;
        }
        if (!isVisibleAsFunctionInCurrentClass(createOverrideForBuiltinFunctionWithErasedParameterIfNeeded)) {
            createOverrideForBuiltinFunctionWithErasedParameterIfNeeded = null;
        }
        if (createOverrideForBuiltinFunctionWithErasedParameterIfNeeded != null) {
            return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(createOverrideForBuiltinFunctionWithErasedParameterIfNeeded, overriddenBuiltinFunctionWithErasedValueParametersInJava, collection);
        }
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Name name2, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(simpleFunctionDescriptor);
        if (simpleFunctionDescriptor2 == null) {
            return null;
        }
        String jvmMethodNameIfSpecial = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(simpleFunctionDescriptor2);
        Intrinsics.checkNotNull(jvmMethodNameIfSpecial);
        Name identifier = Name.identifier(jvmMethodNameIfSpecial);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(nameInJava)");
        for (SimpleFunctionDescriptor createRenamedCopy : (Collection) function1.invoke(identifier)) {
            SimpleFunctionDescriptor createRenamedCopy2 = createRenamedCopy(createRenamedCopy, name2);
            if (doesOverrideRenamedDescriptor(simpleFunctionDescriptor2, createRenamedCopy2)) {
                return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(createRenamedCopy2, simpleFunctionDescriptor2, collection);
            }
        }
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForSuspend(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (!simpleFunctionDescriptor.isSuspend()) {
            return null;
        }
        Name name2 = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name");
        for (SimpleFunctionDescriptor createSuspendView : (Iterable) function1.invoke(name2)) {
            SimpleFunctionDescriptor createSuspendView2 = createSuspendView(createSuspendView);
            if (createSuspendView2 == null || !doesOverride(createSuspendView2, simpleFunctionDescriptor)) {
                createSuspendView2 = null;
                continue;
            }
            if (createSuspendView2 != null) {
                return createSuspendView2;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor javaConstructor) {
        ClassDescriptor t11 = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(t11, LazyJavaAnnotationsKt.resolveAnnotations(i(), javaConstructor), false, i().getComponents().getSourceElementFactory().source(javaConstructor));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(\n …ce(constructor)\n        )");
        LazyJavaResolverContext childForMethod = ContextKt.childForMethod(i(), createJavaConstructor, javaConstructor, t11.getDeclaredTypeParameters().size());
        LazyJavaScope.ResolvedValueParameters p11 = p(childForMethod, createJavaConstructor, javaConstructor.getValueParameters());
        List<TypeParameterDescriptor> declaredTypeParameters = t11.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "classDescriptor.declaredTypeParameters");
        Collection collection = declaredTypeParameters;
        Iterable<JavaTypeParameter> typeParameters = javaConstructor.getTypeParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(typeParameters, 10));
        for (JavaTypeParameter resolveTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter2 = childForMethod.getTypeParameterResolver().resolveTypeParameter(resolveTypeParameter);
            Intrinsics.checkNotNull(resolveTypeParameter2);
            arrayList.add(resolveTypeParameter2);
        }
        createJavaConstructor.initialize(p11.getDescriptors(), UtilsKt.toDescriptorVisibility(javaConstructor.getVisibility()), CollectionsKt___CollectionsKt.plus(collection, arrayList));
        createJavaConstructor.setHasStableParameterNames(false);
        createJavaConstructor.setHasSynthesizedParameterNames(p11.getHasSynthesizedNames());
        createJavaConstructor.setReturnType(t11.getDefaultType());
        childForMethod.getComponents().getJavaResolverCache().recordConstructor(javaConstructor, createJavaConstructor);
        return createJavaConstructor;
    }

    private final JavaMethodDescriptor resolveRecordComponentToFunctionDescriptor(JavaRecordComponent javaRecordComponent) {
        JavaRecordComponent javaRecordComponent2 = javaRecordComponent;
        JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(i(), javaRecordComponent2), javaRecordComponent.getName(), i().getComponents().getSourceElementFactory().source(javaRecordComponent2), true);
        Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(\n      …omponent), true\n        )");
        JavaMethodDescriptor javaMethodDescriptor = createJavaMethod;
        javaMethodDescriptor.initialize((ReceiverParameterDescriptor) null, k(), CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), i().getTypeResolver().transformJavaType(javaRecordComponent.getType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 2, (Object) null)), Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, (Map<? extends CallableDescriptor.UserDataKey<?>, ?>) null);
        createJavaMethod.setParameterNamesStatus(false, false);
        i().getComponents().getJavaResolverCache().recordMethod(javaRecordComponent2, createJavaMethod);
        return createJavaMethod;
    }

    public static /* synthetic */ JavaPropertyDescriptor s(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaMethod javaMethod, KotlinType kotlinType, Modality modality, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            kotlinType = null;
        }
        return lazyJavaClassMemberScope.createPropertyDescriptorWithDefaultGetter(javaMethod, kotlinType, modality);
    }

    /* access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name name2) {
        Iterable<JavaMethod> findMethodsByName = ((DeclaredMemberIndex) j().invoke()).findMethodsByName(name2);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(findMethodsByName, 10));
        for (JavaMethod o11 : findMethodsByName) {
            arrayList.add(o(o11));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name name2) {
        boolean z11;
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name2);
        ArrayList arrayList = new ArrayList();
        for (T next : functionsFromSupertypes) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) next;
            if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(simpleFunctionDescriptor) || BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor) != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name name2 = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "name");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name2)) {
            return false;
        }
        Name name3 = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name3);
        ArrayList<FunctionDescriptor> arrayList = new ArrayList<>();
        for (SimpleFunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava : functionsFromSupertypes) {
            FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava2 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(overriddenBuiltinFunctionWithErasedValueParametersInJava);
            if (overriddenBuiltinFunctionWithErasedValueParametersInJava2 != null) {
                arrayList.add(overriddenBuiltinFunctionWithErasedValueParametersInJava2);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (FunctionDescriptor hasSameJvmDescriptorButDoesNotOverride : arrayList) {
            if (hasSameJvmDescriptorButDoesNotOverride(simpleFunctionDescriptor, hasSameJvmDescriptorButDoesNotOverride)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public Set<Name> a(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return SetsKt___SetsKt.plus((Set) this.nestedClassIndex.invoke(), ((Map) this.enumEntryIndex.invoke()).keySet());
    }

    public void c(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name2) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name2, "name");
        if (this.jClass.isRecord() && ((DeclaredMemberIndex) j().invoke()).findRecordComponentByName(name2) != null) {
            Iterable iterable = collection;
            boolean z11 = true;
            if (!((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                            z11 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z11) {
                JavaRecordComponent findRecordComponentByName = ((DeclaredMemberIndex) j().invoke()).findRecordComponentByName(name2);
                Intrinsics.checkNotNull(findRecordComponentByName);
                collection.add(resolveRecordComponentToFunctionDescriptor(findRecordComponentByName));
            }
        }
        i().getComponents().getSyntheticPartsProvider().generateMethods(getOwnerDescriptor(), name2, collection);
    }

    public void e(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name2, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name2);
        if (!SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(name2) && !BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name2)) {
            if (!(functionsFromSupertypes instanceof Collection) || !functionsFromSupertypes.isEmpty()) {
                Iterator<T> it = functionsFromSupertypes.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((FunctionDescriptor) it.next()).isSuspend()) {
                            z11 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z11 = true;
            if (z11) {
                ArrayList arrayList = new ArrayList();
                for (T next : functionsFromSupertypes) {
                    if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) next)) {
                        arrayList.add(next);
                    }
                }
                addFunctionFromSupertypes(collection, name2, arrayList, false);
                return;
            }
        }
        SmartSet create = SmartSet.Companion.create();
        Collection<D> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name2, functionsFromSupertypes, CollectionsKt__CollectionsKt.emptyList(), getOwnerDescriptor(), ErrorReporter.DO_NOTHING, i().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonSt….overridingUtil\n        )");
        Name name3 = name2;
        Collection<SimpleFunctionDescriptor> collection2 = collection;
        Collection<D> collection3 = resolveOverridesForNonStaticMembers;
        addOverriddenSpecialMethods(name3, collection2, collection3, collection, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(this));
        addOverriddenSpecialMethods(name3, collection2, collection3, create, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(this));
        ArrayList arrayList2 = new ArrayList();
        for (T next2 : functionsFromSupertypes) {
            if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) next2)) {
                arrayList2.add(next2);
            }
        }
        addFunctionFromSupertypes(collection, name2, CollectionsKt___CollectionsKt.plus(arrayList2, create), true);
    }

    public void f(@NotNull Name name2, @NotNull Collection<PropertyDescriptor> collection) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        if (this.jClass.isAnnotationType()) {
            computeAnnotationProperties(name2, collection);
        }
        Set<PropertyDescriptor> propertiesFromSupertypes = getPropertiesFromSupertypes(name2);
        if (!propertiesFromSupertypes.isEmpty()) {
            SmartSet.Companion companion = SmartSet.Companion;
            SmartSet create = companion.create();
            SmartSet create2 = companion.create();
            addPropertyOverrideByMethod(propertiesFromSupertypes, collection, create, new LazyJavaClassMemberScope$computeNonDeclaredProperties$1(this));
            addPropertyOverrideByMethod(SetsKt___SetsKt.minus(propertiesFromSupertypes, create), create2, (Set<PropertyDescriptor>) null, new LazyJavaClassMemberScope$computeNonDeclaredProperties$2(this));
            Collection<D> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name2, SetsKt___SetsKt.plus(propertiesFromSupertypes, create2), collection, getOwnerDescriptor(), i().getComponents().getErrorReporter(), i().getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonSt…rridingUtil\n            )");
            collection.addAll(resolveOverridesForNonStaticMembers);
        }
    }

    @NotNull
    public Set<Name> g(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        if (this.jClass.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((DeclaredMemberIndex) j().invoke()).getFieldNames());
        Collection<KotlinType> supertypes = getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        for (KotlinType memberScope : supertypes) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    @NotNull
    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.constructors;
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        MemoizedFunctionToNullable<Name, ClassDescriptorBase> memoizedFunctionToNullable;
        ClassDescriptorBase invoke;
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name2, lookupLocation);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = (LazyJavaClassMemberScope) l();
        if (lazyJavaClassMemberScope == null || (memoizedFunctionToNullable = lazyJavaClassMemberScope.nestedClasses) == null || (invoke = memoizedFunctionToNullable.invoke(name2)) == null) {
            return this.nestedClasses.invoke(name2);
        }
        return invoke;
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name2, lookupLocation);
        return super.getContributedFunctions(name2, lookupLocation);
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name2, lookupLocation);
        return super.getContributedVariables(name2, lookupLocation);
    }

    @Nullable
    public ReceiverParameterDescriptor k() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(getOwnerDescriptor());
    }

    public boolean m(@NotNull JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        if (this.jClass.isAnnotationType()) {
            return false;
        }
        return isVisibleAsFunctionInCurrentClass(javaMethodDescriptor);
    }

    @NotNull
    public LazyJavaScope.MethodSignatureData n(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull KotlinType kotlinType, @NotNull List<? extends ValueParameterDescriptor> list2) {
        Intrinsics.checkNotNullParameter(javaMethod, "method");
        Intrinsics.checkNotNullParameter(list, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(kotlinType, "returnType");
        Intrinsics.checkNotNullParameter(list2, "valueParameters");
        SignaturePropagator.PropagatedSignature resolvePropagatedSignature = i().getComponents().getSignaturePropagator().resolvePropagatedSignature(javaMethod, getOwnerDescriptor(), kotlinType, (KotlinType) null, list2, list);
        Intrinsics.checkNotNullExpressionValue(resolvePropagatedSignature, "c.components.signaturePr…dTypeParameters\n        )");
        KotlinType returnType = resolvePropagatedSignature.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "propagated.returnType");
        KotlinType receiverType = resolvePropagatedSignature.getReceiverType();
        List<ValueParameterDescriptor> valueParameters = resolvePropagatedSignature.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "propagated.valueParameters");
        List<TypeParameterDescriptor> typeParameters = resolvePropagatedSignature.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "propagated.typeParameters");
        boolean hasStableParameterNames = resolvePropagatedSignature.hasStableParameterNames();
        List<String> errors = resolvePropagatedSignature.getErrors();
        Intrinsics.checkNotNullExpressionValue(errors, "propagated.errors");
        return new LazyJavaScope.MethodSignatureData(returnType, receiverType, valueParameters, typeParameters, hasStableParameterNames, errors);
    }

    @NotNull
    /* renamed from: q */
    public LinkedHashSet<Name> computeFunctionNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Collection<KotlinType> supertypes = getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<Name> linkedHashSet = new LinkedHashSet<>();
        for (KotlinType memberScope : supertypes) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(((DeclaredMemberIndex) j().invoke()).getMethodNames());
        linkedHashSet.addAll(((DeclaredMemberIndex) j().invoke()).getRecordComponentNames());
        linkedHashSet.addAll(a(descriptorKindFilter, function1));
        linkedHashSet.addAll(i().getComponents().getSyntheticPartsProvider().getMethodNames(getOwnerDescriptor()));
        return linkedHashSet;
    }

    @NotNull
    /* renamed from: r */
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, LazyJavaClassMemberScope$computeMemberIndex$1.INSTANCE);
    }

    public void recordLookup(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(i().getComponents().getLookupTracker(), lookupLocation, getOwnerDescriptor(), name2);
    }

    @NotNull
    /* renamed from: t */
    public ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    @NotNull
    public String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull ClassDescriptor classDescriptor, @NotNull JavaClass javaClass, boolean z11, @Nullable LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(lazyJavaResolverContext, lazyJavaClassMemberScope);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(classDescriptor, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        this.ownerDescriptor = classDescriptor;
        this.jClass = javaClass;
        this.skipRefinement = z11;
        this.constructors = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$constructors$1(this, lazyJavaResolverContext));
        this.nestedClassIndex = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClassIndex$1(this));
        this.enumEntryIndex = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$enumEntryIndex$1(this));
        this.nestedClasses = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaClassMemberScope$nestedClasses$1(this, lazyJavaResolverContext));
    }
}
