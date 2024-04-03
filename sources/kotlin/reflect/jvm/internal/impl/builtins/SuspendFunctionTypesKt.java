package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class SuspendFunctionTypesKt {
    @NotNull
    private static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR;

    static {
        EmptyPackageFragmentDescriptor emptyPackageFragmentDescriptor = new EmptyPackageFragmentDescriptor(ErrorUtils.INSTANCE.getErrorModule(), StandardNames.COROUTINES_PACKAGE_FQ_NAME);
        ClassKind classKind = ClassKind.INTERFACE;
        Name shortName = StandardNames.CONTINUATION_INTERFACE_FQ_NAME.shortName();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
        MutableClassDescriptor mutableClassDescriptor = new MutableClassDescriptor(emptyPackageFragmentDescriptor, classKind, false, false, shortName, sourceElement, storageManager);
        mutableClassDescriptor.setModality(Modality.ABSTRACT);
        mutableClassDescriptor.setVisibility(DescriptorVisibilities.PUBLIC);
        mutableClassDescriptor.setTypeParameterDescriptors(CollectionsKt__CollectionsJVMKt.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor, Annotations.Companion.getEMPTY(), false, Variance.IN_VARIANCE, Name.identifier("T"), 0, storageManager)));
        mutableClassDescriptor.createTypeConstructor();
        FAKE_CONTINUATION_CLASS_DESCRIPTOR = mutableClassDescriptor;
    }

    @NotNull
    public static final SimpleType transformSuspendFunctionToRuntimeFunctionType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "suspendFunType");
        FunctionTypesKt.isSuspendFunctionType(kotlinType);
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
        Annotations annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        List<KotlinType> contextReceiverTypesFromFunctionType = FunctionTypesKt.getContextReceiverTypesFromFunctionType(kotlinType);
        Iterable<TypeProjection> valueParameterTypesFromFunctionType = FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueParameterTypesFromFunctionType, 10));
        for (TypeProjection type : valueParameterTypesFromFunctionType) {
            arrayList.add(type.getType());
        }
        TypeAttributes empty = TypeAttributes.Companion.getEmpty();
        TypeConstructor typeConstructor = FAKE_CONTINUATION_CLASS_DESCRIPTOR.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        List plus = CollectionsKt___CollectionsKt.plus(arrayList, KotlinTypeFactory.simpleType$default(empty, typeConstructor, CollectionsKt__CollectionsJVMKt.listOf(TypeUtilsKt.asTypeProjection(FunctionTypesKt.getReturnTypeFromFunctionType(kotlinType))), false, (KotlinTypeRefiner) null, 16, (Object) null));
        SimpleType nullableAnyType = TypeUtilsKt.getBuiltIns(kotlinType).getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(nullableAnyType, "suspendFunType.builtIns.nullableAnyType");
        return FunctionTypesKt.createFunctionType$default(builtIns, annotations, receiverTypeFromFunctionType, contextReceiverTypesFromFunctionType, plus, (List) null, nullableAnyType, false, 128, (Object) null).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }
}
