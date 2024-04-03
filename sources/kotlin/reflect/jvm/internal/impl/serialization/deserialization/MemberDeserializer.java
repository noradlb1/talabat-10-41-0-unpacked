package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.apptimize.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class MemberDeserializer {
    @NotNull
    private final AnnotationDeserializer annotationDeserializer;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final DeserializationContext f24830c;

    public MemberDeserializer(@NotNull DeserializationContext deserializationContext) {
        Intrinsics.checkNotNullParameter(deserializationContext, c.f41585a);
        this.f24830c = deserializationContext;
        this.annotationDeserializer = new AnnotationDeserializer(deserializationContext.getComponents().getModuleDescriptor(), deserializationContext.getComponents().getNotFoundClasses());
    }

    /* access modifiers changed from: private */
    public final ProtoContainer asProtoContainer(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.Package(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.f24830c.getNameResolver(), this.f24830c.getTypeTable(), this.f24830c.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    private final Annotations getAnnotations(MessageLite messageLite, int i11, AnnotatedCallableKind annotatedCallableKind) {
        if (!Flags.HAS_ANNOTATIONS.get(i11).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.f24830c.getStorageManager(), new MemberDeserializer$getAnnotations$1(this, messageLite, annotatedCallableKind));
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor containingDeclaration = this.f24830c.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null) {
            return classDescriptor.getThisAsReceiverParameter();
        }
        return null;
    }

    private final Annotations getPropertyFieldAnnotations(ProtoBuf.Property property, boolean z11) {
        if (!Flags.HAS_ANNOTATIONS.get(property.getFlags()).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.f24830c.getStorageManager(), new MemberDeserializer$getPropertyFieldAnnotations$1(this, z11, property));
    }

    private final Annotations getReceiverParameterAnnotations(MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        return new DeserializedAnnotations(this.f24830c.getStorageManager(), new MemberDeserializer$getReceiverParameterAnnotations$1(this, messageLite, annotatedCallableKind));
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends ReceiverParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, List<? extends ValueParameterDescriptor> list3, KotlinType kotlinType, Modality modality, DescriptorVisibility descriptorVisibility, Map<? extends CallableDescriptor.UserDataKey<?>, ?> map) {
        deserializedSimpleFunctionDescriptor.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, list3, kotlinType, modality, descriptorVisibility, map);
    }

    private final int loadOldFlags(int i11) {
        return (i11 & 63) + ((i11 >> 8) << 6);
    }

    private final ReceiverParameterDescriptor toContextReceiver(ProtoBuf.Type type, DeserializationContext deserializationContext, CallableDescriptor callableDescriptor) {
        return DescriptorFactory.createContextReceiverParameterForCallable(callableDescriptor, deserializationContext.getTypeDeserializer().type(type), Annotations.Companion.getEMPTY());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters(java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> r26, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r27, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r28) {
        /*
            r25 = this;
            r7 = r25
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r7.f24830c
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r0.getContainingDeclaration()
            java.lang.String r1 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r20 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r20 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r20
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r20.getContainingDeclaration()
            java.lang.String r1 = "callableDescriptor.containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer r21 = r7.asProtoContainer(r0)
            r0 = r26
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r15 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r1)
            r15.<init>(r1)
            java.util.Iterator r22 = r0.iterator()
            r23 = 0
            r11 = r23
        L_0x0035:
            boolean r0 = r22.hasNext()
            if (r0 == 0) goto L_0x0113
            java.lang.Object r0 = r22.next()
            int r24 = r11 + 1
            if (r11 >= 0) goto L_0x0046
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x0046:
            r8 = r0
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r8 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r8
            boolean r0 = r8.hasFlags()
            if (r0 == 0) goto L_0x0055
            int r0 = r8.getFlags()
            r9 = r0
            goto L_0x0057
        L_0x0055:
            r9 = r23
        L_0x0057:
            if (r21 == 0) goto L_0x0087
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS
            java.lang.Boolean r0 = r0.get((int) r9)
            java.lang.String r1 = "HAS_ANNOTATIONS.get(flags)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0087
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations r10 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r7.f24830c
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r12 = r0.getStorageManager()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$valueParameters$1$annotations$1 r13 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$valueParameters$1$annotations$1
            r0 = r13
            r1 = r25
            r2 = r21
            r3 = r27
            r4 = r28
            r5 = r11
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r10.<init>(r12, r13)
            r12 = r10
            goto L_0x008e
        L_0x0087:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r0.getEMPTY()
            r12 = r0
        L_0x008e:
            r10 = 0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r7.f24830c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r0.getNameResolver()
            int r1 = r8.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r13 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r0, r1)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r7.f24830c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r0 = r0.getTypeDeserializer()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r1 = r7.f24830c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r1 = r1.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.type((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r8, (kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable) r1)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r14 = r0.type(r1)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.DECLARES_DEFAULT_VALUE
            java.lang.Boolean r0 = r0.get((int) r9)
            java.lang.String r1 = "DECLARES_DEFAULT_VALUE.get(flags)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = r0.booleanValue()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CROSSINLINE
            java.lang.Boolean r1 = r1.get((int) r9)
            java.lang.String r2 = "IS_CROSSINLINE.get(flags)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r16 = r1.booleanValue()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOINLINE
            java.lang.Boolean r1 = r1.get((int) r9)
            java.lang.String r2 = "IS_NOINLINE.get(flags)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r17 = r1.booleanValue()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r1 = r7.f24830c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r1 = r1.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.varargElementType(r8, r1)
            if (r1 == 0) goto L_0x00f5
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r7.f24830c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r2 = r2.getTypeDeserializer()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r2.type(r1)
            goto L_0x00f6
        L_0x00f5:
            r1 = 0
        L_0x00f6:
            r18 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r1 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            java.lang.String r2 = "NO_SOURCE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl r2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl
            r8 = r2
            r9 = r20
            r3 = r15
            r15 = r0
            r19 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r3.add(r2)
            r15 = r3
            r11 = r24
            goto L_0x0035
        L_0x0113:
            r3 = r15
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.valueParameters(java.util.List, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind):java.util.List");
    }

    @NotNull
    public final ClassConstructorDescriptor loadConstructor(@NotNull ProtoBuf.Constructor constructor, boolean z11) {
        ProtoBuf.Constructor constructor2 = constructor;
        Intrinsics.checkNotNullParameter(constructor2, "proto");
        DeclarationDescriptor containingDeclaration = this.f24830c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        int flags = constructor.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = r1;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor2 = new DeserializedClassConstructorDescriptor(classDescriptor, (ConstructorDescriptor) null, getAnnotations(constructor2, flags, annotatedCallableKind), z11, CallableMemberDescriptor.Kind.DECLARATION, constructor, this.f24830c.getNameResolver(), this.f24830c.getTypeTable(), this.f24830c.getVersionRequirementTable(), this.f24830c.getContainerSource(), (SourceElement) null, 1024, (DefaultConstructorMarker) null);
        MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(this.f24830c, deserializedClassConstructorDescriptor, CollectionsKt__CollectionsKt.emptyList(), (NameResolver) null, (TypeTable) null, (VersionRequirementTable) null, (BinaryVersion) null, 60, (Object) null).getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor3 = deserializedClassConstructorDescriptor;
        deserializedClassConstructorDescriptor3.initialize(memberDeserializer.valueParameters(valueParameterList, constructor2, annotatedCallableKind), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(constructor.getFlags())));
        deserializedClassConstructorDescriptor3.setReturnType(classDescriptor.getDefaultType());
        deserializedClassConstructorDescriptor3.setExpect(classDescriptor.isExpect());
        deserializedClassConstructorDescriptor3.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(constructor.getFlags()).booleanValue());
        return deserializedClassConstructorDescriptor3;
    }

    @NotNull
    public final SimpleFunctionDescriptor loadFunction(@NotNull ProtoBuf.Function function) {
        int i11;
        Annotations annotations;
        VersionRequirementTable versionRequirementTable;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        KotlinType type;
        ProtoBuf.Function function2 = function;
        Intrinsics.checkNotNullParameter(function2, "proto");
        if (function.hasFlags()) {
            i11 = function.getFlags();
        } else {
            i11 = loadOldFlags(function.getOldFlags());
        }
        int i12 = i11;
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        Annotations annotations2 = getAnnotations(function2, i12, annotatedCallableKind);
        if (ProtoTypeTableUtilKt.hasReceiver(function)) {
            annotations = getReceiverParameterAnnotations(function2, annotatedCallableKind);
        } else {
            annotations = Annotations.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual((Object) DescriptorUtilsKt.getFqNameSafe(this.f24830c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.f24830c.getNameResolver(), function.getName())), (Object) SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            versionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
        } else {
            versionRequirementTable = this.f24830c.getVersionRequirementTable();
        }
        ProtoBuf.Function function3 = function;
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(this.f24830c.getContainingDeclaration(), (SimpleFunctionDescriptor) null, annotations2, NameResolverUtilKt.getName(this.f24830c.getNameResolver(), function.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(i12)), function3, this.f24830c.getNameResolver(), this.f24830c.getTypeTable(), versionRequirementTable, this.f24830c.getContainerSource(), (SourceElement) null, 1024, (DefaultConstructorMarker) null);
        DeserializationContext deserializationContext = this.f24830c;
        List<ProtoBuf.TypeParameter> typeParameterList = function.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedSimpleFunctionDescriptor, typeParameterList, (NameResolver) null, (TypeTable) null, (VersionRequirementTable) null, (BinaryVersion) null, 60, (Object) null);
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(function2, this.f24830c.getTypeTable());
        if (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, type, annotations);
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = receiverParameterDescriptor;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<ProtoBuf.Type> contextReceiverTypeList = function.getContextReceiverTypeList();
        Intrinsics.checkNotNullExpressionValue(contextReceiverTypeList, "proto.contextReceiverTypeList");
        ArrayList arrayList = new ArrayList();
        for (ProtoBuf.Type type2 : contextReceiverTypeList) {
            Intrinsics.checkNotNullExpressionValue(type2, "it");
            ReceiverParameterDescriptor contextReceiver = toContextReceiver(type2, childContext$default, deserializedSimpleFunctionDescriptor);
            if (contextReceiver != null) {
                arrayList.add(contextReceiver);
            }
        }
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = childContext$default.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        List<ValueParameterDescriptor> valueParameters = memberDeserializer.valueParameters(valueParameterList, function2, AnnotatedCallableKind.FUNCTION);
        KotlinType type3 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(function2, this.f24830c.getTypeTable()));
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        Modality modality = protoEnumFlags.modality(Flags.MODALITY.get(i12));
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor2 = deserializedSimpleFunctionDescriptor;
        DeserializationContext deserializationContext2 = childContext$default;
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor3 = deserializedSimpleFunctionDescriptor;
        Modality modality2 = modality;
        int i13 = i12;
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, Flags.VISIBILITY.get(i12));
        initializeWithCoroutinesExperimentalityStatus(deserializedSimpleFunctionDescriptor2, receiverParameterDescriptor2, dispatchReceiverParameter, arrayList, ownTypeParameters, valueParameters, type3, modality2, descriptorVisibility, MapsKt__MapsKt.emptyMap());
        Boolean bool = Flags.IS_OPERATOR.get(i13);
        Intrinsics.checkNotNullExpressionValue(bool, "IS_OPERATOR.get(flags)");
        deserializedSimpleFunctionDescriptor3.setOperator(bool.booleanValue());
        Boolean bool2 = Flags.IS_INFIX.get(i13);
        Intrinsics.checkNotNullExpressionValue(bool2, "IS_INFIX.get(flags)");
        deserializedSimpleFunctionDescriptor3.setInfix(bool2.booleanValue());
        Boolean bool3 = Flags.IS_EXTERNAL_FUNCTION.get(i13);
        Intrinsics.checkNotNullExpressionValue(bool3, "IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor3.setExternal(bool3.booleanValue());
        Boolean bool4 = Flags.IS_INLINE.get(i13);
        Intrinsics.checkNotNullExpressionValue(bool4, "IS_INLINE.get(flags)");
        deserializedSimpleFunctionDescriptor3.setInline(bool4.booleanValue());
        Boolean bool5 = Flags.IS_TAILREC.get(i13);
        Intrinsics.checkNotNullExpressionValue(bool5, "IS_TAILREC.get(flags)");
        deserializedSimpleFunctionDescriptor3.setTailrec(bool5.booleanValue());
        Boolean bool6 = Flags.IS_SUSPEND.get(i13);
        Intrinsics.checkNotNullExpressionValue(bool6, "IS_SUSPEND.get(flags)");
        deserializedSimpleFunctionDescriptor3.setSuspend(bool6.booleanValue());
        Boolean bool7 = Flags.IS_EXPECT_FUNCTION.get(i13);
        Intrinsics.checkNotNullExpressionValue(bool7, "IS_EXPECT_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor3.setExpect(bool7.booleanValue());
        deserializedSimpleFunctionDescriptor3.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(i13).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction = this.f24830c.getComponents().getContractDeserializer().deserializeContractFromFunction(function2, deserializedSimpleFunctionDescriptor3, this.f24830c.getTypeTable(), deserializationContext2.getTypeDeserializer());
        if (deserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor3.putInUserDataMap(deserializeContractFromFunction.getFirst(), deserializeContractFromFunction.getSecond());
        }
        return deserializedSimpleFunctionDescriptor3;
    }

    @NotNull
    public final PropertyDescriptor loadProperty(@NotNull ProtoBuf.Property property) {
        int i11;
        ProtoBuf.Property property2;
        Annotations annotations;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        Flags.FlagField<ProtoBuf.Visibility> flagField;
        DeserializationContext deserializationContext;
        Flags.FlagField<ProtoBuf.Modality> flagField2;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        int i12;
        boolean z11;
        ProtoBuf.Property property3;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor2;
        ClassDescriptor classDescriptor;
        int i13;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl3;
        KotlinType type;
        ProtoBuf.Property property4 = property;
        Intrinsics.checkNotNullParameter(property4, "proto");
        if (property.hasFlags()) {
            i11 = property.getFlags();
        } else {
            i11 = loadOldFlags(property.getOldFlags());
        }
        int i14 = i11;
        DeclarationDescriptor containingDeclaration = this.f24830c.getContainingDeclaration();
        Annotations annotations2 = getAnnotations(property4, i14, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        Modality modality = protoEnumFlags.modality(Flags.MODALITY.get(i14));
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, Flags.VISIBILITY.get(i14));
        Boolean bool = Flags.IS_VAR.get(i14);
        Intrinsics.checkNotNullExpressionValue(bool, "IS_VAR.get(flags)");
        boolean booleanValue = bool.booleanValue();
        Name name2 = NameResolverUtilKt.getName(this.f24830c.getNameResolver(), property.getName());
        CallableMemberDescriptor.Kind memberKind = ProtoEnumFlagsUtilsKt.memberKind(protoEnumFlags, Flags.MEMBER_KIND.get(i14));
        Boolean bool2 = Flags.IS_LATEINIT.get(i14);
        Intrinsics.checkNotNullExpressionValue(bool2, "IS_LATEINIT.get(flags)");
        boolean booleanValue2 = bool2.booleanValue();
        Boolean bool3 = Flags.IS_CONST.get(i14);
        Intrinsics.checkNotNullExpressionValue(bool3, "IS_CONST.get(flags)");
        boolean booleanValue3 = bool3.booleanValue();
        Boolean bool4 = Flags.IS_EXTERNAL_PROPERTY.get(i14);
        Intrinsics.checkNotNullExpressionValue(bool4, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = bool4.booleanValue();
        Boolean bool5 = Flags.IS_DELEGATED.get(i14);
        Intrinsics.checkNotNullExpressionValue(bool5, "IS_DELEGATED.get(flags)");
        boolean booleanValue5 = bool5.booleanValue();
        DeserializedPropertyDescriptor deserializedPropertyDescriptor3 = r1;
        Boolean bool6 = Flags.IS_EXPECT_PROPERTY.get(i14);
        Intrinsics.checkNotNullExpressionValue(bool6, "IS_EXPECT_PROPERTY.get(flags)");
        ProtoBuf.Property property5 = property4;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor4 = new DeserializedPropertyDescriptor(containingDeclaration, (PropertyDescriptor) null, annotations2, modality, descriptorVisibility, booleanValue, name2, memberKind, booleanValue2, booleanValue3, booleanValue4, booleanValue5, bool6.booleanValue(), property, this.f24830c.getNameResolver(), this.f24830c.getTypeTable(), this.f24830c.getVersionRequirementTable(), this.f24830c.getContainerSource());
        DeserializationContext deserializationContext2 = this.f24830c;
        List<ProtoBuf.TypeParameter> typeParameterList = property.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext2, deserializedPropertyDescriptor3, typeParameterList, (NameResolver) null, (TypeTable) null, (VersionRequirementTable) null, (BinaryVersion) null, 60, (Object) null);
        int i15 = i14;
        Boolean bool7 = Flags.HAS_GETTER.get(i15);
        Intrinsics.checkNotNullExpressionValue(bool7, "HAS_GETTER.get(flags)");
        boolean booleanValue6 = bool7.booleanValue();
        if (!booleanValue6 || !ProtoTypeTableUtilKt.hasReceiver(property)) {
            property2 = property;
            annotations = Annotations.Companion.getEMPTY();
        } else {
            property2 = property;
            annotations = getReceiverParameterAnnotations(property2, AnnotatedCallableKind.PROPERTY_GETTER);
        }
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(property2, this.f24830c.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(property2, this.f24830c.getTypeTable());
        ClassKind classKind = null;
        if (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            receiverParameterDescriptor = null;
        } else {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedPropertyDescriptor, type, annotations);
        }
        List<ProtoBuf.Type> contextReceiverTypeList = property.getContextReceiverTypeList();
        Intrinsics.checkNotNullExpressionValue(contextReceiverTypeList, "proto.contextReceiverTypeList");
        Iterable<ProtoBuf.Type> iterable = contextReceiverTypeList;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Type type3 : iterable) {
            Intrinsics.checkNotNullExpressionValue(type3, "it");
            arrayList.add(toContextReceiver(type3, childContext$default, deserializedPropertyDescriptor));
        }
        deserializedPropertyDescriptor.setType(type2, ownTypeParameters, dispatchReceiverParameter, receiverParameterDescriptor, arrayList);
        Boolean bool8 = Flags.HAS_ANNOTATIONS.get(i15);
        Intrinsics.checkNotNullExpressionValue(bool8, "HAS_ANNOTATIONS.get(flags)");
        boolean booleanValue7 = bool8.booleanValue();
        Flags.FlagField<ProtoBuf.Visibility> flagField3 = Flags.VISIBILITY;
        Flags.FlagField<ProtoBuf.Modality> flagField4 = Flags.MODALITY;
        int accessorFlags = Flags.getAccessorFlags(booleanValue7, flagField3.get(i15), flagField4.get(i15), false, false, false);
        if (booleanValue6) {
            if (property.hasGetterFlags()) {
                i13 = property.getGetterFlags();
            } else {
                i13 = accessorFlags;
            }
            Boolean bool9 = Flags.IS_NOT_DEFAULT.get(i13);
            Intrinsics.checkNotNullExpressionValue(bool9, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean booleanValue8 = bool9.booleanValue();
            Boolean bool10 = Flags.IS_EXTERNAL_ACCESSOR.get(i13);
            Intrinsics.checkNotNullExpressionValue(bool10, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean booleanValue9 = bool10.booleanValue();
            Boolean bool11 = Flags.IS_INLINE_ACCESSOR.get(i13);
            Intrinsics.checkNotNullExpressionValue(bool11, "IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean booleanValue10 = bool11.booleanValue();
            Annotations annotations3 = getAnnotations(property2, i13, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue8) {
                ProtoEnumFlags protoEnumFlags2 = ProtoEnumFlags.INSTANCE;
                Modality modality2 = protoEnumFlags2.modality(flagField4.get(i13));
                DescriptorVisibility descriptorVisibility2 = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags2, flagField3.get(i13));
                deserializationContext = childContext$default;
                flagField2 = flagField4;
                flagField = flagField3;
                propertyGetterDescriptorImpl3 = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor, annotations3, modality2, descriptorVisibility2, !booleanValue8, booleanValue9, booleanValue10, deserializedPropertyDescriptor.getKind(), (PropertyGetterDescriptor) null, SourceElement.NO_SOURCE);
            } else {
                flagField = flagField3;
                deserializationContext = childContext$default;
                flagField2 = flagField4;
                propertyGetterDescriptorImpl3 = DescriptorFactory.createDefaultGetter(deserializedPropertyDescriptor, annotations3);
                Intrinsics.checkNotNullExpressionValue(propertyGetterDescriptorImpl3, "{\n                Descri…nnotations)\n            }");
            }
            propertyGetterDescriptorImpl3.initialize(deserializedPropertyDescriptor.getReturnType());
            propertyGetterDescriptorImpl = propertyGetterDescriptorImpl3;
        } else {
            flagField = flagField3;
            deserializationContext = childContext$default;
            flagField2 = flagField4;
            propertyGetterDescriptorImpl = null;
        }
        Boolean bool12 = Flags.HAS_SETTER.get(i15);
        Intrinsics.checkNotNullExpressionValue(bool12, "HAS_SETTER.get(flags)");
        if (bool12.booleanValue()) {
            if (property.hasSetterFlags()) {
                accessorFlags = property.getSetterFlags();
            }
            int i16 = accessorFlags;
            Boolean bool13 = Flags.IS_NOT_DEFAULT.get(i16);
            Intrinsics.checkNotNullExpressionValue(bool13, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean booleanValue11 = bool13.booleanValue();
            Boolean bool14 = Flags.IS_EXTERNAL_ACCESSOR.get(i16);
            Intrinsics.checkNotNullExpressionValue(bool14, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean booleanValue12 = bool14.booleanValue();
            Boolean bool15 = Flags.IS_INLINE_ACCESSOR.get(i16);
            Intrinsics.checkNotNullExpressionValue(bool15, "IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean booleanValue13 = bool15.booleanValue();
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            Annotations annotations4 = getAnnotations(property2, i16, annotatedCallableKind);
            if (booleanValue11) {
                ProtoEnumFlags protoEnumFlags3 = ProtoEnumFlags.INSTANCE;
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = r1;
                propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
                PropertySetterDescriptorImpl propertySetterDescriptorImpl3 = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor, annotations4, protoEnumFlags3.modality(flagField2.get(i16)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags3, flagField.get(i16)), !booleanValue11, booleanValue12, booleanValue13, deserializedPropertyDescriptor.getKind(), (PropertySetterDescriptor) null, SourceElement.NO_SOURCE);
                z11 = true;
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                property3 = property2;
                i12 = i15;
                PropertySetterDescriptorImpl propertySetterDescriptorImpl4 = propertySetterDescriptorImpl2;
                propertySetterDescriptorImpl4.initialize((ValueParameterDescriptor) CollectionsKt___CollectionsKt.single(DeserializationContext.childContext$default(deserializationContext, propertySetterDescriptorImpl2, CollectionsKt__CollectionsKt.emptyList(), (NameResolver) null, (TypeTable) null, (VersionRequirementTable) null, (BinaryVersion) null, 60, (Object) null).getMemberDeserializer().valueParameters(CollectionsKt__CollectionsJVMKt.listOf(property.getSetterValueParameter()), property3, annotatedCallableKind)));
                propertySetterDescriptorImpl = propertySetterDescriptorImpl4;
            } else {
                propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                property3 = property2;
                i12 = i15;
                z11 = true;
                propertySetterDescriptorImpl = DescriptorFactory.createDefaultSetter(deserializedPropertyDescriptor2, annotations4, Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNullExpressionValue(propertySetterDescriptorImpl, "{\n                Descri…          )\n            }");
            }
        } else {
            propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
            deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
            property3 = property2;
            i12 = i15;
            z11 = true;
            propertySetterDescriptorImpl = null;
        }
        Boolean bool16 = Flags.HAS_CONSTANT.get(i12);
        Intrinsics.checkNotNullExpressionValue(bool16, "HAS_CONSTANT.get(flags)");
        if (bool16.booleanValue()) {
            deserializedPropertyDescriptor2.setCompileTimeInitializerFactory(new MemberDeserializer$loadProperty$4(this, property3, deserializedPropertyDescriptor2));
        }
        DeclarationDescriptor containingDeclaration2 = this.f24830c.getContainingDeclaration();
        if (containingDeclaration2 instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) containingDeclaration2;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor != null) {
            classKind = classDescriptor.getKind();
        }
        if (classKind == ClassKind.ANNOTATION_CLASS) {
            deserializedPropertyDescriptor2.setCompileTimeInitializerFactory(new MemberDeserializer$loadProperty$5(this, property3, deserializedPropertyDescriptor2));
        }
        deserializedPropertyDescriptor2.initialize(propertyGetterDescriptorImpl2, propertySetterDescriptorImpl, new FieldDescriptorImpl(getPropertyFieldAnnotations(property3, false), deserializedPropertyDescriptor2), new FieldDescriptorImpl(getPropertyFieldAnnotations(property3, z11), deserializedPropertyDescriptor2));
        return deserializedPropertyDescriptor2;
    }

    @NotNull
    public final TypeAliasDescriptor loadTypeAlias(@NotNull ProtoBuf.TypeAlias typeAlias) {
        ProtoBuf.TypeAlias typeAlias2 = typeAlias;
        Intrinsics.checkNotNullParameter(typeAlias2, "proto");
        Annotations.Companion companion = Annotations.Companion;
        List<ProtoBuf.Annotation> annotationList = typeAlias.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "proto.annotationList");
        Iterable<ProtoBuf.Annotation> iterable = annotationList;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation annotation : iterable) {
            AnnotationDeserializer annotationDeserializer2 = this.annotationDeserializer;
            Intrinsics.checkNotNullExpressionValue(annotation, "it");
            arrayList.add(annotationDeserializer2.deserializeAnnotation(annotation, this.f24830c.getNameResolver()));
        }
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(this.f24830c.getStorageManager(), this.f24830c.getContainingDeclaration(), companion.create(arrayList), NameResolverUtilKt.getName(this.f24830c.getNameResolver(), typeAlias.getName()), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(typeAlias.getFlags())), typeAlias, this.f24830c.getNameResolver(), this.f24830c.getTypeTable(), this.f24830c.getVersionRequirementTable(), this.f24830c.getContainerSource());
        DeserializationContext deserializationContext = this.f24830c;
        List<ProtoBuf.TypeParameter> typeParameterList = typeAlias.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor2 = deserializedTypeAliasDescriptor;
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedTypeAliasDescriptor, typeParameterList, (NameResolver) null, (TypeTable) null, (VersionRequirementTable) null, (BinaryVersion) null, 60, (Object) null);
        deserializedTypeAliasDescriptor2.initialize(childContext$default.getTypeDeserializer().getOwnTypeParameters(), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(typeAlias2, this.f24830c.getTypeTable()), false), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(typeAlias2, this.f24830c.getTypeTable()), false));
        return deserializedTypeAliasDescriptor2;
    }
}
