package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.apptimize.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeDeserializer {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final DeserializationContext f24858c;
    @NotNull
    private final Function1<Integer, ClassifierDescriptor> classifierDescriptors;
    @NotNull
    private final String containerPresentableName;
    @NotNull
    private final String debugName;
    @Nullable
    private final TypeDeserializer parent;
    @NotNull
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    @NotNull
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(@NotNull DeserializationContext deserializationContext, @Nullable TypeDeserializer typeDeserializer, @NotNull List<ProtoBuf.TypeParameter> list, @NotNull String str, @NotNull String str2) {
        Map<Integer, TypeParameterDescriptor> map;
        Intrinsics.checkNotNullParameter(deserializationContext, c.f41585a);
        Intrinsics.checkNotNullParameter(list, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(str, "debugName");
        Intrinsics.checkNotNullParameter(str2, "containerPresentableName");
        this.f24858c = deserializationContext;
        this.parent = typeDeserializer;
        this.debugName = str;
        this.containerPresentableName = str2;
        this.classifierDescriptors = deserializationContext.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$classifierDescriptors$1(this));
        this.typeAliasDescriptors = deserializationContext.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$typeAliasDescriptors$1(this));
        if (list.isEmpty()) {
            map = MapsKt__MapsKt.emptyMap();
        } else {
            map = new LinkedHashMap<>();
            int i11 = 0;
            for (ProtoBuf.TypeParameter next : list) {
                map.put(Integer.valueOf(next.getId()), new DeserializedTypeParameterDescriptor(this.f24858c, next, i11));
                i11++;
            }
        }
        this.typeParameterDescriptors = map;
    }

    /* access modifiers changed from: private */
    public final ClassifierDescriptor computeClassifierDescriptor(int i11) {
        ClassId classId = NameResolverUtilKt.getClassId(this.f24858c.getNameResolver(), i11);
        if (classId.isLocal()) {
            return this.f24858c.getComponents().deserializeClass(classId);
        }
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.f24858c.getComponents().getModuleDescriptor(), classId);
    }

    private final SimpleType computeLocalClassifierReplacementType(int i11) {
        if (NameResolverUtilKt.getClassId(this.f24858c.getNameResolver(), i11).isLocal()) {
            return this.f24858c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final ClassifierDescriptor computeTypeAliasDescriptor(int i11) {
        ClassId classId = NameResolverUtilKt.getClassId(this.f24858c.getNameResolver(), i11);
        if (classId.isLocal()) {
            return null;
        }
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.f24858c.getComponents().getModuleDescriptor(), classId);
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
        Annotations annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        List<KotlinType> contextReceiverTypesFromFunctionType = FunctionTypesKt.getContextReceiverTypesFromFunctionType(kotlinType);
        Iterable<TypeProjection> dropLast = CollectionsKt___CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType), 1);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(dropLast, 10));
        for (TypeProjection type : dropLast) {
            arrayList.add(type.getType());
        }
        return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, contextReceiverTypesFromFunctionType, arrayList, (List<Name>) null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    private final SimpleType createSuspendFunctionType(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z11) {
        SimpleType simpleType;
        int size;
        int size2 = typeConstructor.getParameters().size() - list.size();
        if (size2 != 0) {
            simpleType = null;
            if (size2 == 1 && (size = list.size() - 1) >= 0) {
                TypeConstructor typeConstructor2 = typeConstructor.getBuiltIns().getSuspendFunction(size).getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor2, "functionTypeConstructor.…on(arity).typeConstructor");
                simpleType = KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor2, (List) list, z11, (KotlinTypeRefiner) null, 16, (Object) null);
            }
        } else {
            simpleType = createSuspendFunctionTypeForBasicCase(typeAttributes, typeConstructor, list, z11);
        }
        if (simpleType == null) {
            return ErrorUtils.INSTANCE.createErrorTypeWithArguments(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, list, typeConstructor, new String[0]);
        }
        return simpleType;
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z11) {
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor, (List) list, z11, (KotlinTypeRefiner) null, 16, (Object) null);
        if (!FunctionTypesKt.isFunctionType(simpleType$default)) {
            return null;
        }
        return transformRuntimeFunctionTypeToSuspendFunction(simpleType$default);
    }

    private final TypeParameterDescriptor loadTypeParameter(int i11) {
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptors.get(Integer.valueOf(i11));
        if (typeParameterDescriptor != null) {
            return typeParameterDescriptor;
        }
        TypeDeserializer typeDeserializer = this.parent;
        if (typeDeserializer != null) {
            return typeDeserializer.loadTypeParameter(i11);
        }
        return null;
    }

    private static final List<ProtoBuf.Type.Argument> simpleType$collectAllArguments(ProtoBuf.Type type, TypeDeserializer typeDeserializer) {
        List<ProtoBuf.Type.Argument> argumentList = type.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(argumentList, "argumentList");
        Collection collection = argumentList;
        ProtoBuf.Type outerType = ProtoTypeTableUtilKt.outerType(type, typeDeserializer.f24858c.getTypeTable());
        List<ProtoBuf.Type.Argument> simpleType$collectAllArguments = outerType != null ? simpleType$collectAllArguments(outerType, typeDeserializer) : null;
        if (simpleType$collectAllArguments == null) {
            simpleType$collectAllArguments = CollectionsKt__CollectionsKt.emptyList();
        }
        return CollectionsKt___CollectionsKt.plus(collection, simpleType$collectAllArguments);
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer typeDeserializer, ProtoBuf.Type type, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return typeDeserializer.simpleType(type, z11);
    }

    private final TypeAttributes toAttributes(List<? extends TypeAttributeTranslator> list, Annotations annotations, TypeConstructor typeConstructor, DeclarationDescriptor declarationDescriptor) {
        Iterable<TypeAttributeTranslator> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TypeAttributeTranslator attributes : iterable) {
            arrayList.add(attributes.toAttributes(annotations, typeConstructor, declarationDescriptor));
        }
        return TypeAttributes.Companion.create(CollectionsKt__IterablesKt.flatten(arrayList));
    }

    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType kotlinType) {
        KotlinType type;
        FqName fqName;
        TypeProjection typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.lastOrNull(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType));
        FqName fqName2 = null;
        if (typeProjection == null || (type = typeProjection.getType()) == null) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = type.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor != null) {
            fqName = DescriptorUtilsKt.getFqNameSafe(declarationDescriptor);
        } else {
            fqName = null;
        }
        if (type.getArguments().size() != 1 || (!Intrinsics.areEqual((Object) fqName, (Object) StandardNames.CONTINUATION_INTERFACE_FQ_NAME) && !Intrinsics.areEqual((Object) fqName, (Object) TypeDeserializerKt.EXPERIMENTAL_CONTINUATION_FQ_NAME))) {
            return (SimpleType) kotlinType;
        }
        KotlinType type2 = ((TypeProjection) CollectionsKt___CollectionsKt.single(type.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(type2, "continuationArgumentType.arguments.single().type");
        DeclarationDescriptor containingDeclaration = this.f24858c.getContainingDeclaration();
        if (!(containingDeclaration instanceof CallableDescriptor)) {
            containingDeclaration = null;
        }
        CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
        if (callableDescriptor != null) {
            fqName2 = DescriptorUtilsKt.fqNameOrNull(callableDescriptor);
        }
        if (Intrinsics.areEqual((Object) fqName2, (Object) SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return createSimpleSuspendFunctionType(kotlinType, type2);
        }
        return createSimpleSuspendFunctionType(kotlinType, type2);
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor typeParameterDescriptor, ProtoBuf.Type.Argument argument) {
        if (argument.getProjection() != ProtoBuf.Type.Argument.Projection.STAR) {
            ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
            ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
            Intrinsics.checkNotNullExpressionValue(projection, "typeArgumentProto.projection");
            Variance variance = protoEnumFlags.variance(projection);
            ProtoBuf.Type type = ProtoTypeTableUtilKt.type(argument, this.f24858c.getTypeTable());
            if (type != null) {
                return new TypeProjectionImpl(variance, type(type));
            }
            return new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.NO_RECORDED_TYPE, argument.toString()));
        } else if (typeParameterDescriptor == null) {
            return new StarProjectionForAbsentTypeParameter(this.f24858c.getComponents().getModuleDescriptor().getBuiltIns());
        } else {
            return new StarProjectionImpl(typeParameterDescriptor);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type r7) {
        /*
            r6 = this;
            boolean r0 = r7.hasClassName()
            if (r0 == 0) goto L_0x0022
            kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor> r0 = r6.classifierDescriptors
            int r1 = r7.getClassName()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.invoke(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r0
            if (r0 != 0) goto L_0x00c7
            int r0 = r7.getClassName()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = typeConstructor$notFoundClass(r6, r7, r0)
            goto L_0x00c7
        L_0x0022:
            boolean r0 = r7.hasTypeParameter()
            r1 = 1
            r2 = 2
            r3 = 0
            if (r0 == 0) goto L_0x004e
            int r0 = r7.getTypeParameter()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r0 = r6.loadTypeParameter(r0)
            if (r0 != 0) goto L_0x00c7
            kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r4 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER
            java.lang.String[] r2 = new java.lang.String[r2]
            int r7 = r7.getTypeParameter()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r2[r3] = r7
            java.lang.String r7 = r6.containerPresentableName
            r2[r1] = r7
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor r7 = r0.createErrorTypeConstructor(r4, r2)
            return r7
        L_0x004e:
            boolean r0 = r7.hasTypeParameterName()
            if (r0 == 0) goto L_0x00a7
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r6.f24858c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r0.getNameResolver()
            int r7 = r7.getTypeParameterName()
            java.lang.String r7 = r0.getString(r7)
            java.util.List r0 = r6.getOwnTypeParameters()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x006c:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0088
            java.lang.Object r4 = r0.next()
            r5 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5
            kotlin.reflect.jvm.internal.impl.name.Name r5 = r5.getName()
            java.lang.String r5 = r5.asString()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 == 0) goto L_0x006c
            goto L_0x0089
        L_0x0088:
            r4 = 0
        L_0x0089:
            r0 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r0
            if (r0 != 0) goto L_0x00c7
            kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r4 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME
            java.lang.String[] r2 = new java.lang.String[r2]
            r2[r3] = r7
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r7 = r6.f24858c
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r7 = r7.getContainingDeclaration()
            java.lang.String r7 = r7.toString()
            r2[r1] = r7
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor r7 = r0.createErrorTypeConstructor(r4, r2)
            return r7
        L_0x00a7:
            boolean r0 = r7.hasTypeAliasName()
            if (r0 == 0) goto L_0x00d1
            kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor> r0 = r6.typeAliasDescriptors
            int r1 = r7.getTypeAliasName()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.invoke(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r0
            if (r0 != 0) goto L_0x00c7
            int r0 = r7.getTypeAliasName()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = typeConstructor$notFoundClass(r6, r7, r0)
        L_0x00c7:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r0.getTypeConstructor()
            java.lang.String r0 = "classifier.typeConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            return r7
        L_0x00d1:
            kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils r7 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.UNKNOWN_TYPE
            java.lang.String[] r1 = new java.lang.String[r3]
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor r7 = r7.createErrorTypeConstructor(r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.typeConstructor(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type):kotlin.reflect.jvm.internal.impl.types.TypeConstructor");
    }

    private static final ClassDescriptor typeConstructor$notFoundClass(TypeDeserializer typeDeserializer, ProtoBuf.Type type, int i11) {
        ClassId classId = NameResolverUtilKt.getClassId(typeDeserializer.f24858c.getNameResolver(), i11);
        List mutableList = SequencesKt___SequencesKt.toMutableList(SequencesKt___SequencesKt.map(SequencesKt__SequencesKt.generateSequence(type, new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(typeDeserializer)), TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2.INSTANCE));
        int count = SequencesKt___SequencesKt.count(SequencesKt__SequencesKt.generateSequence(classId, TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1.INSTANCE));
        while (mutableList.size() < count) {
            mutableList.add(0);
        }
        return typeDeserializer.f24858c.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }

    @NotNull
    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt___CollectionsKt.toList(this.typeParameterDescriptors.values());
    }

    @NotNull
    public final SimpleType simpleType(@NotNull ProtoBuf.Type type, boolean z11) {
        SimpleType simpleType;
        SimpleType simpleType2;
        SimpleType withAbbreviation;
        Intrinsics.checkNotNullParameter(type, "proto");
        if (type.hasClassName()) {
            simpleType = computeLocalClassifierReplacementType(type.getClassName());
        } else if (type.hasTypeAliasName()) {
            simpleType = computeLocalClassifierReplacementType(type.getTypeAliasName());
        } else {
            simpleType = null;
        }
        if (simpleType != null) {
            return simpleType;
        }
        TypeConstructor typeConstructor = typeConstructor(type);
        boolean z12 = true;
        if (ErrorUtils.isError(typeConstructor.getDeclarationDescriptor())) {
            return ErrorUtils.INSTANCE.createErrorType(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, typeConstructor, typeConstructor.toString());
        }
        DeserializedAnnotations deserializedAnnotations = new DeserializedAnnotations(this.f24858c.getStorageManager(), new TypeDeserializer$simpleType$annotations$1(this, type));
        TypeAttributes attributes = toAttributes(this.f24858c.getComponents().getTypeAttributeTranslators(), deserializedAnnotations, typeConstructor, this.f24858c.getContainingDeclaration());
        Iterable simpleType$collectAllArguments = simpleType$collectAllArguments(type, this);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(simpleType$collectAllArguments, 10));
        int i11 = 0;
        for (Object next : simpleType$collectAllArguments) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
            arrayList.add(typeArgument((TypeParameterDescriptor) CollectionsKt___CollectionsKt.getOrNull(parameters, i11), (ProtoBuf.Type.Argument) next));
            i11 = i12;
        }
        List list = CollectionsKt___CollectionsKt.toList(arrayList);
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (!z11 || !(declarationDescriptor instanceof TypeAliasDescriptor)) {
            Boolean bool = Flags.SUSPEND_TYPE.get(type.getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "SUSPEND_TYPE.get(proto.flags)");
            if (bool.booleanValue()) {
                simpleType2 = createSuspendFunctionType(attributes, typeConstructor, list, type.getNullable());
            } else {
                simpleType2 = KotlinTypeFactory.simpleType$default(attributes, typeConstructor, list, type.getNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
                Boolean bool2 = Flags.DEFINITELY_NOT_NULL_TYPE.get(type.getFlags());
                Intrinsics.checkNotNullExpressionValue(bool2, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
                if (bool2.booleanValue()) {
                    DefinitelyNotNullType makeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, simpleType2, false, 2, (Object) null);
                    if (makeDefinitelyNotNull$default != null) {
                        simpleType2 = makeDefinitelyNotNull$default;
                    } else {
                        throw new IllegalStateException(("null DefinitelyNotNullType for '" + simpleType2 + '\'').toString());
                    }
                }
            }
        } else {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType computeExpandedType = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) declarationDescriptor, list);
            TypeAttributes attributes2 = toAttributes(this.f24858c.getComponents().getTypeAttributeTranslators(), Annotations.Companion.create(CollectionsKt___CollectionsKt.plus(deserializedAnnotations, (DeserializedAnnotations) computeExpandedType.getAnnotations())), typeConstructor, this.f24858c.getContainingDeclaration());
            if (!KotlinTypeKt.isNullable(computeExpandedType) && !type.getNullable()) {
                z12 = false;
            }
            simpleType2 = computeExpandedType.makeNullableAsSpecified(z12).replaceAttributes(attributes2);
        }
        ProtoBuf.Type abbreviatedType = ProtoTypeTableUtilKt.abbreviatedType(type, this.f24858c.getTypeTable());
        if (!(abbreviatedType == null || (withAbbreviation = SpecialTypesKt.withAbbreviation(simpleType2, simpleType(abbreviatedType, false))) == null)) {
            simpleType2 = withAbbreviation;
        }
        if (!type.hasClassName()) {
            return simpleType2;
        }
        return this.f24858c.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(NameResolverUtilKt.getClassId(this.f24858c.getNameResolver(), type.getClassName()), simpleType2);
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.debugName);
        if (this.parent == null) {
            str = "";
        } else {
            str = ". Child of " + this.parent.debugName;
        }
        sb2.append(str);
        return sb2.toString();
    }

    @NotNull
    public final KotlinType type(@NotNull ProtoBuf.Type type) {
        Intrinsics.checkNotNullParameter(type, "proto");
        if (!type.hasFlexibleTypeCapabilitiesId()) {
            return simpleType(type, true);
        }
        String string = this.f24858c.getNameResolver().getString(type.getFlexibleTypeCapabilitiesId());
        SimpleType simpleType$default = simpleType$default(this, type, false, 2, (Object) null);
        ProtoBuf.Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(type, this.f24858c.getTypeTable());
        Intrinsics.checkNotNull(flexibleUpperBound);
        return this.f24858c.getComponents().getFlexibleTypeDeserializer().create(type, string, simpleType$default, simpleType$default(this, flexibleUpperBound, false, 2, (Object) null));
    }
}
