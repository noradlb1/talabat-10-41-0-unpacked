package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionTypesKt {
    public static final int contextFunctionTypeParamsCount(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        AnnotationDescriptor findAnnotation = kotlinType.getAnnotations().findAnnotation(StandardNames.FqNames.contextFunctionTypeParams);
        if (findAnnotation == null) {
            return 0;
        }
        ConstantValue constantValue = (ConstantValue) MapsKt__MapsKt.getValue(findAnnotation.getAllValueArguments(), StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME);
        Intrinsics.checkNotNull(constantValue, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((Number) ((IntValue) constantValue).getValue()).intValue();
    }

    @NotNull
    @JvmOverloads
    public static final SimpleType createFunctionType(@NotNull KotlinBuiltIns kotlinBuiltIns, @NotNull Annotations annotations, @Nullable KotlinType kotlinType, @NotNull List<? extends KotlinType> list, @NotNull List<? extends KotlinType> list2, @Nullable List<Name> list3, @NotNull KotlinType kotlinType2, boolean z11) {
        int i11;
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(list, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(list2, "parameterTypes");
        Intrinsics.checkNotNullParameter(kotlinType2, "returnType");
        List<TypeProjection> functionTypeArgumentProjections = getFunctionTypeArgumentProjections(kotlinType, list, list2, list3, kotlinType2, kotlinBuiltIns);
        int size = list2.size() + list.size();
        if (kotlinType == null) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        ClassDescriptor functionDescriptor = getFunctionDescriptor(kotlinBuiltIns, size + i11, z11);
        if (kotlinType != null) {
            annotations = withExtensionFunctionAnnotation(annotations, kotlinBuiltIns);
        }
        if (!list.isEmpty()) {
            annotations = withContextReceiversFunctionAnnotation(annotations, kotlinBuiltIns, list.size());
        }
        return KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(annotations), functionDescriptor, functionTypeArgumentProjections);
    }

    public static /* synthetic */ SimpleType createFunctionType$default(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List list, List list2, List list3, KotlinType kotlinType2, boolean z11, int i11, Object obj) {
        return createFunctionType(kotlinBuiltIns, annotations, kotlinType, list, list2, list3, kotlinType2, (i11 & 128) != 0 ? false : z11);
    }

    @Nullable
    public static final Name extractParameterNameFromFunctionTypeArgument(@NotNull KotlinType kotlinType) {
        StringValue stringValue;
        String str;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        AnnotationDescriptor findAnnotation = kotlinType.getAnnotations().findAnnotation(StandardNames.FqNames.parameterName);
        if (findAnnotation == null) {
            return null;
        }
        Object singleOrNull = CollectionsKt___CollectionsKt.singleOrNull(findAnnotation.getAllValueArguments().values());
        if (singleOrNull instanceof StringValue) {
            stringValue = (StringValue) singleOrNull;
        } else {
            stringValue = null;
        }
        if (!(stringValue == null || (str = (String) stringValue.getValue()) == null)) {
            if (!Name.isValidIdentifier(str)) {
                str = null;
            }
            if (str != null) {
                return Name.identifier(str);
            }
        }
        return null;
    }

    @NotNull
    public static final List<KotlinType> getContextReceiverTypesFromFunctionType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        int contextFunctionTypeParamsCount = contextFunctionTypeParamsCount(kotlinType);
        if (contextFunctionTypeParamsCount == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<TypeProjection> subList = kotlinType.getArguments().subList(0, contextFunctionTypeParamsCount);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subList, 10));
        for (TypeProjection type : subList) {
            KotlinType type2 = type.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "it.type");
            arrayList.add(type2);
        }
        return arrayList;
    }

    @NotNull
    public static final ClassDescriptor getFunctionDescriptor(@NotNull KotlinBuiltIns kotlinBuiltIns, int i11, boolean z11) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (z11) {
            classDescriptor = kotlinBuiltIns.getSuspendFunction(i11);
        } else {
            classDescriptor = kotlinBuiltIns.getFunction(i11);
        }
        Intrinsics.checkNotNullExpressionValue(classDescriptor, "if (isSuspendFunction) b…tFunction(parameterCount)");
        return classDescriptor;
    }

    @NotNull
    public static final List<TypeProjection> getFunctionTypeArgumentProjections(@Nullable KotlinType kotlinType, @NotNull List<? extends KotlinType> list, @NotNull List<? extends KotlinType> list2, @Nullable List<Name> list3, @NotNull KotlinType kotlinType2, @NotNull KotlinBuiltIns kotlinBuiltIns) {
        int i11;
        TypeProjection typeProjection;
        Name name2;
        Intrinsics.checkNotNullParameter(list, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(list2, "parameterTypes");
        Intrinsics.checkNotNullParameter(kotlinType2, "returnType");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        int size = list2.size() + list.size();
        int i12 = 0;
        if (kotlinType != null) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        ArrayList arrayList = new ArrayList(size + i11 + 1);
        Iterable<KotlinType> iterable = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (KotlinType asTypeProjection : iterable) {
            arrayList2.add(TypeUtilsKt.asTypeProjection(asTypeProjection));
        }
        arrayList.addAll(arrayList2);
        if (kotlinType != null) {
            typeProjection = TypeUtilsKt.asTypeProjection(kotlinType);
        } else {
            typeProjection = null;
        }
        CollectionsKt.addIfNotNull(arrayList, typeProjection);
        for (Object next : list2) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            KotlinType kotlinType3 = (KotlinType) next;
            if (list3 == null || (name2 = list3.get(i12)) == null || name2.isSpecial()) {
                name2 = null;
            }
            if (name2 != null) {
                FqName fqName = StandardNames.FqNames.parameterName;
                Name identifier = Name.identifier("name");
                String asString = name2.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
                kotlinType3 = TypeUtilsKt.replaceAnnotations(kotlinType3, Annotations.Companion.create(CollectionsKt___CollectionsKt.plus(kotlinType3.getAnnotations(), new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt__MapsJVMKt.mapOf(TuplesKt.to(identifier, new StringValue(asString)))))));
            }
            arrayList.add(TypeUtilsKt.asTypeProjection(kotlinType3));
            i12 = i13;
        }
        arrayList.add(TypeUtilsKt.asTypeProjection(kotlinType2));
        return arrayList;
    }

    @Nullable
    public static final FunctionClassKind getFunctionalClassKind(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        if ((declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return getFunctionalClassKind(DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor));
        }
        return null;
    }

    @Nullable
    public static final KotlinType getReceiverTypeFromFunctionType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        if (!isTypeAnnotatedWithExtensionFunctionType(kotlinType)) {
            return null;
        }
        return kotlinType.getArguments().get(contextFunctionTypeParamsCount(kotlinType)).getType();
    }

    @NotNull
    public static final KotlinType getReturnTypeFromFunctionType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        KotlinType type = ((TypeProjection) CollectionsKt___CollectionsKt.last(kotlinType.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(type, "arguments.last().type");
        return type;
    }

    @NotNull
    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        List<TypeProjection> arguments = kotlinType.getArguments();
        return arguments.subList(contextFunctionTypeParamsCount(kotlinType) + (isBuiltinExtensionFunctionalType(kotlinType) ? 1 : 0), arguments.size() - 1);
    }

    public static final boolean isBuiltinExtensionFunctionalType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (!isBuiltinFunctionalType(kotlinType) || !isTypeAnnotatedWithExtensionFunctionType(kotlinType)) {
            return false;
        }
        return true;
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        FunctionClassKind functionalClassKind = getFunctionalClassKind(declarationDescriptor);
        if (functionalClassKind == FunctionClassKind.Function || functionalClassKind == FunctionClassKind.SuspendFunction) {
            return true;
        }
        return false;
    }

    public static final boolean isBuiltinFunctionalType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null || !isBuiltinFunctionalClassDescriptor(declarationDescriptor)) {
            return false;
        }
        return true;
    }

    public static final boolean isFunctionType(@NotNull KotlinType kotlinType) {
        FunctionClassKind functionClassKind;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor != null) {
            functionClassKind = getFunctionalClassKind((DeclarationDescriptor) declarationDescriptor);
        } else {
            functionClassKind = null;
        }
        if (functionClassKind == FunctionClassKind.Function) {
            return true;
        }
        return false;
    }

    public static final boolean isSuspendFunctionType(@NotNull KotlinType kotlinType) {
        FunctionClassKind functionClassKind;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor != null) {
            functionClassKind = getFunctionalClassKind((DeclarationDescriptor) declarationDescriptor);
        } else {
            functionClassKind = null;
        }
        if (functionClassKind == FunctionClassKind.SuspendFunction) {
            return true;
        }
        return false;
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType kotlinType) {
        return kotlinType.getAnnotations().findAnnotation(StandardNames.FqNames.extensionFunctionType) != null;
    }

    @NotNull
    public static final Annotations withContextReceiversFunctionAnnotation(@NotNull Annotations annotations, @NotNull KotlinBuiltIns kotlinBuiltIns, int i11) {
        Intrinsics.checkNotNullParameter(annotations, "<this>");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        FqName fqName = StandardNames.FqNames.contextFunctionTypeParams;
        if (annotations.hasAnnotation(fqName)) {
            return annotations;
        }
        return Annotations.Companion.create(CollectionsKt___CollectionsKt.plus(annotations, new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt__MapsJVMKt.mapOf(TuplesKt.to(StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME, new IntValue(i11))))));
    }

    @NotNull
    public static final Annotations withExtensionFunctionAnnotation(@NotNull Annotations annotations, @NotNull KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.checkNotNullParameter(annotations, "<this>");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        FqName fqName = StandardNames.FqNames.extensionFunctionType;
        if (annotations.hasAnnotation(fqName)) {
            return annotations;
        }
        return Annotations.Companion.create(CollectionsKt___CollectionsKt.plus(annotations, new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt__MapsKt.emptyMap())));
    }

    private static final FunctionClassKind getFunctionalClassKind(FqNameUnsafe fqNameUnsafe) {
        if (!fqNameUnsafe.isSafe() || fqNameUnsafe.isRoot()) {
            return null;
        }
        FunctionClassKind.Companion companion = FunctionClassKind.Companion;
        String asString = fqNameUnsafe.shortName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "shortName().asString()");
        FqName parent = fqNameUnsafe.toSafe().parent();
        Intrinsics.checkNotNullExpressionValue(parent, "toSafe().parent()");
        return companion.getFunctionalClassKind(asString, parent);
    }
}
