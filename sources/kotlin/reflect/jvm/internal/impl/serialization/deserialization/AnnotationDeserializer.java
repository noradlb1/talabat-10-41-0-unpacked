package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

public final class AnnotationDeserializer {
    @NotNull
    private final ModuleDescriptor module;
    @NotNull
    private final NotFoundClasses notFoundClasses;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnnotationDeserializer(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses2) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses2, "notFoundClasses");
        this.module = moduleDescriptor;
        this.notFoundClasses = notFoundClasses2;
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> constantValue, KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value) {
        int i11;
        ClassDescriptor classDescriptor;
        boolean z11;
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i11 == 10) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                classDescriptor = (ClassDescriptor) declarationDescriptor;
            } else {
                classDescriptor = null;
            }
            if (classDescriptor != null && !KotlinBuiltIns.isKClass(classDescriptor)) {
                return false;
            }
        } else if (i11 != 13) {
            return Intrinsics.areEqual((Object) constantValue.getType(this.module), (Object) kotlinType);
        } else {
            if (!(constantValue instanceof ArrayValue) || ((List) ((ArrayValue) constantValue).getValue()).size() != value.getArrayElementList().size()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                KotlinType arrayElementType = getBuiltIns().getArrayElementType(kotlinType);
                Intrinsics.checkNotNullExpressionValue(arrayElementType, "builtIns.getArrayElementType(expectedType)");
                ArrayValue arrayValue = (ArrayValue) constantValue;
                IntRange indices = CollectionsKt__CollectionsKt.getIndices((Collection) arrayValue.getValue());
                if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                    Iterator it = indices.iterator();
                    while (it.hasNext()) {
                        int nextInt = ((IntIterator) it).nextInt();
                        ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(nextInt);
                        Intrinsics.checkNotNullExpressionValue(arrayElement, "value.getArrayElement(i)");
                        if (!doesValueConformToExpectedType((ConstantValue) ((List) arrayValue.getValue()).get(nextInt), arrayElementType, arrayElement)) {
                            return false;
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + constantValue).toString());
            }
        }
        return true;
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument argument, Map<Name, ? extends ValueParameterDescriptor> map, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) map.get(NameResolverUtilKt.getName(nameResolver, argument.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        Name name2 = NameResolverUtilKt.getName(nameResolver, argument.getNameId());
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "parameter.type");
        ProtoBuf.Annotation.Argument.Value value = argument.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "proto.value");
        return new Pair<>(name2, resolveValueAndCheckExpectedType(type, value, nameResolver));
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue<?> resolveValue = resolveValue(kotlinType, value, nameResolver);
        if (!doesValueConformToExpectedType(resolveValue, kotlinType, value)) {
            resolveValue = null;
        }
        if (resolveValue != null) {
            return resolveValue;
        }
        ErrorValue.Companion companion = ErrorValue.Companion;
        return companion.create("Unexpected argument value: actual type " + value.getType() + " != expected type " + kotlinType);
    }

    @NotNull
    public final AnnotationDescriptor deserializeAnnotation(@NotNull ProtoBuf.Annotation annotation, @NotNull NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(annotation, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        ClassDescriptor resolveClass = resolveClass(NameResolverUtilKt.getClassId(nameResolver, annotation.getId()));
        Map emptyMap = MapsKt__MapsKt.emptyMap();
        if (annotation.getArgumentCount() != 0 && !ErrorUtils.isError(resolveClass) && DescriptorUtils.isAnnotationClass(resolveClass)) {
            Collection<ClassConstructorDescriptor> constructors = resolveClass.getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "annotationClass.constructors");
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) CollectionsKt___CollectionsKt.singleOrNull(constructors);
            if (classConstructorDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
                Iterable iterable = valueParameters;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
                for (Object next : iterable) {
                    linkedHashMap.put(((ValueParameterDescriptor) next).getName(), next);
                }
                List<ProtoBuf.Annotation.Argument> argumentList = annotation.getArgumentList();
                Intrinsics.checkNotNullExpressionValue(argumentList, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf.Annotation.Argument argument : argumentList) {
                    Intrinsics.checkNotNullExpressionValue(argument, "it");
                    Pair<Name, ConstantValue<?>> resolveArgument = resolveArgument(argument, linkedHashMap, nameResolver);
                    if (resolveArgument != null) {
                        arrayList.add(resolveArgument);
                    }
                }
                emptyMap = MapsKt__MapsKt.toMap(arrayList);
            }
        }
        return new AnnotationDescriptorImpl(resolveClass.getDefaultType(), emptyMap, SourceElement.NO_SOURCE);
    }

    @NotNull
    public final ConstantValue<?> resolveValue(@NotNull KotlinType kotlinType, @NotNull ProtoBuf.Annotation.Argument.Value value, @NotNull NameResolver nameResolver) {
        int i11;
        ConstantValue<?> constantValue;
        ConstantValue<?> constantValue2;
        boolean z11;
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Boolean bool = Flags.IS_UNSIGNED.get(value.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = bool.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        switch (i11) {
            case 1:
                byte intValue = (byte) ((int) value.getIntValue());
                if (booleanValue) {
                    return new UByteValue(intValue);
                }
                return new ByteValue(intValue);
            case 2:
                constantValue = new CharValue((char) ((int) value.getIntValue()));
                break;
            case 3:
                short intValue2 = (short) ((int) value.getIntValue());
                if (booleanValue) {
                    return new UShortValue(intValue2);
                }
                return new ShortValue(intValue2);
            case 4:
                int intValue3 = (int) value.getIntValue();
                if (booleanValue) {
                    return new UIntValue(intValue3);
                }
                return new IntValue(intValue3);
            case 5:
                long intValue4 = value.getIntValue();
                if (booleanValue) {
                    constantValue2 = new ULongValue(intValue4);
                } else {
                    constantValue2 = new LongValue(intValue4);
                }
                return constantValue2;
            case 6:
                constantValue = new FloatValue(value.getFloatValue());
                break;
            case 7:
                constantValue = new DoubleValue(value.getDoubleValue());
                break;
            case 8:
                if (value.getIntValue() != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                constantValue = new BooleanValue(z11);
                break;
            case 9:
                constantValue = new StringValue(nameResolver.getString(value.getStringValue()));
                break;
            case 10:
                constantValue = new KClassValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), value.getArrayDimensionCount());
                break;
            case 11:
                constantValue = new EnumValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), NameResolverUtilKt.getName(nameResolver, value.getEnumValueId()));
                break;
            case 12:
                ProtoBuf.Annotation annotation = value.getAnnotation();
                Intrinsics.checkNotNullExpressionValue(annotation, "value.annotation");
                constantValue = new AnnotationValue(deserializeAnnotation(annotation, nameResolver));
                break;
            case 13:
                List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                Intrinsics.checkNotNullExpressionValue(arrayElementList, "value.arrayElementList");
                Iterable<ProtoBuf.Annotation.Argument.Value> iterable = arrayElementList;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (ProtoBuf.Annotation.Argument.Value value2 : iterable) {
                    SimpleType anyType = getBuiltIns().getAnyType();
                    Intrinsics.checkNotNullExpressionValue(anyType, "builtIns.anyType");
                    Intrinsics.checkNotNullExpressionValue(value2, "it");
                    arrayList.add(resolveValue(anyType, value2, nameResolver));
                }
                return new DeserializedArrayValue(arrayList, kotlinType);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + kotlinType + ')').toString());
        }
        return constantValue;
    }
}
