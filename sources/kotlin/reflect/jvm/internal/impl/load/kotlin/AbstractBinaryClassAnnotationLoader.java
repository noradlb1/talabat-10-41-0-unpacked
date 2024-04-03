package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.compose.material3.TextFieldImplKt;
import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractBinaryClassAnnotationLoader<A, S extends AnnotationsContainer<? extends A>> implements AnnotationLoader<A> {
    @NotNull
    private final KotlinClassFinder kotlinClassFinder;

    public static abstract class AnnotationsContainer<A> {
        @NotNull
        public abstract Map<MemberSignature, List<A>> getMemberAnnotations();
    }

    public enum PropertyRelatedElement {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AbstractBinaryClassAnnotationLoader(@NotNull KotlinClassFinder kotlinClassFinder2) {
        Intrinsics.checkNotNullParameter(kotlinClassFinder2, "kotlinClassFinder");
        this.kotlinClassFinder = kotlinClassFinder2;
    }

    public static /* synthetic */ List a(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean z11, boolean z12, Boolean bool, boolean z13, int i11, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationLoader.findClassAndLoadMemberAnnotations(protoContainer, memberSignature, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? false : z12, (i11 & 16) != 0 ? null : bool, (i11 & 32) != 0 ? false : z13);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    private final int computeJvmParameterIndexShift(ProtoContainer protoContainer, MessageLite messageLite) {
        if (messageLite instanceof ProtoBuf.Function) {
            if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf.Property) {
            if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf.Constructor) {
            Intrinsics.checkNotNull(protoContainer, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
            ProtoContainer.Class classR = (ProtoContainer.Class) protoContainer;
            if (classR.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS) {
                return 2;
            }
            if (classR.isInner()) {
                return 1;
            }
        } else {
            throw new UnsupportedOperationException("Unsupported message: " + messageLite.getClass());
        }
        return 0;
    }

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer protoContainer, MemberSignature memberSignature, boolean z11, boolean z12, Boolean bool, boolean z13) {
        KotlinJvmBinaryClass b11 = b(protoContainer, f(protoContainer, z11, z12, bool, z13));
        if (b11 == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<A> list = (List) getAnnotationsContainer(b11).getMemberAnnotations().get(memberSignature);
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    public static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 16) != 0) {
                z11 = false;
            }
            return abstractBinaryClassAnnotationLoader.d(messageLite, nameResolver, typeTable, annotatedCallableKind, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    public static /* synthetic */ MemberSignature getPropertySignature$default(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationLoader.e(property, nameResolver, typeTable, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? false : z12, (i11 & 32) != 0 ? true : z13);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final List<A> loadPropertyAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property, PropertyRelatedElement propertyRelatedElement) {
        PropertyRelatedElement propertyRelatedElement2 = propertyRelatedElement;
        Boolean bool = Flags.IS_CONST.get(property.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_CONST.get(proto.flags)");
        boolean booleanValue = bool.booleanValue();
        boolean isMovedFromInterfaceCompanion = JvmProtoBufUtil.isMovedFromInterfaceCompanion(property);
        if (propertyRelatedElement2 == PropertyRelatedElement.PROPERTY) {
            MemberSignature propertySignature$default = getPropertySignature$default(this, property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), false, true, false, 40, (Object) null);
            if (propertySignature$default == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return a(this, protoContainer, propertySignature$default, true, false, Boolean.valueOf(booleanValue), isMovedFromInterfaceCompanion, 8, (Object) null);
        }
        MemberSignature propertySignature$default2 = getPropertySignature$default(this, property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), true, false, false, 48, (Object) null);
        if (propertySignature$default2 == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        boolean z11 = false;
        boolean contains$default = StringsKt__StringsKt.contains$default((CharSequence) propertySignature$default2.getSignature(), (CharSequence) "$delegate", false, 2, (Object) null);
        if (propertyRelatedElement2 == PropertyRelatedElement.DELEGATE_FIELD) {
            z11 = true;
        }
        if (contains$default != z11) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return findClassAndLoadMemberAnnotations(protoContainer, propertySignature$default2, true, true, Boolean.valueOf(booleanValue), isMovedFromInterfaceCompanion);
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class classR) {
        SourceElement source = classR.getSource();
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = source instanceof KotlinJvmBinarySourceElement ? (KotlinJvmBinarySourceElement) source : null;
        if (kotlinJvmBinarySourceElement != null) {
            return kotlinJvmBinarySourceElement.getBinaryClass();
        }
        return null;
    }

    @Nullable
    public final KotlinJvmBinaryClass b(@NotNull ProtoContainer protoContainer, @Nullable KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        if (kotlinJvmBinaryClass != null) {
            return kotlinJvmBinaryClass;
        }
        if (protoContainer instanceof ProtoContainer.Class) {
            return toBinaryClass((ProtoContainer.Class) protoContainer);
        }
        return null;
    }

    @Nullable
    public byte[] c(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        return null;
    }

    @Nullable
    public final MemberSignature d(@NotNull MessageLite messageLite, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull AnnotatedCallableKind annotatedCallableKind, boolean z11) {
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, FWFConstants.EXPLANATION_TYPE_KIND);
        if (messageLite instanceof ProtoBuf.Constructor) {
            MemberSignature.Companion companion = MemberSignature.Companion;
            JvmMemberSignature.Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) messageLite, nameResolver, typeTable);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return companion.fromJvmMemberSignature(jvmConstructorSignature);
        } else if (messageLite instanceof ProtoBuf.Function) {
            MemberSignature.Companion companion2 = MemberSignature.Companion;
            JvmMemberSignature.Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) messageLite, nameResolver, typeTable);
            if (jvmMethodSignature == null) {
                return null;
            }
            return companion2.fromJvmMemberSignature(jvmMethodSignature);
        } else if (!(messageLite instanceof ProtoBuf.Property)) {
            return null;
        } else {
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
            Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) messageLite, generatedExtension);
            if (jvmPropertySignature == null) {
                return null;
            }
            int i11 = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        return null;
                    }
                    return e((ProtoBuf.Property) messageLite, nameResolver, typeTable, true, true, z11);
                } else if (!jvmPropertySignature.hasSetter()) {
                    return null;
                } else {
                    MemberSignature.Companion companion3 = MemberSignature.Companion;
                    JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
                    Intrinsics.checkNotNullExpressionValue(setter, "signature.setter");
                    return companion3.fromMethod(nameResolver, setter);
                }
            } else if (!jvmPropertySignature.hasGetter()) {
                return null;
            } else {
                MemberSignature.Companion companion4 = MemberSignature.Companion;
                JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                Intrinsics.checkNotNullExpressionValue(getter, "signature.getter");
                return companion4.fromMethod(nameResolver, getter);
            }
        }
    }

    @Nullable
    public final MemberSignature e(@NotNull ProtoBuf.Property property, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, boolean z11, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(property, generatedExtension);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z11) {
            JvmMemberSignature.Field jvmFieldSignature = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(property, nameResolver, typeTable, z13);
            if (jvmFieldSignature == null) {
                return null;
            }
            return MemberSignature.Companion.fromJvmMemberSignature(jvmFieldSignature);
        } else if (!z12 || !jvmPropertySignature.hasSyntheticMethod()) {
            return null;
        } else {
            MemberSignature.Companion companion = MemberSignature.Companion;
            JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
            Intrinsics.checkNotNullExpressionValue(syntheticMethod, "signature.syntheticMethod");
            return companion.fromMethod(nameResolver, syntheticMethod);
        }
    }

    @Nullable
    public final KotlinJvmBinaryClass f(@NotNull ProtoContainer protoContainer, boolean z11, boolean z12, @Nullable Boolean bool, boolean z13) {
        ProtoContainer.Class outerClass;
        JvmPackagePartSource jvmPackagePartSource;
        JvmClassName jvmClassName;
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        if (z11) {
            if (bool != null) {
                if (protoContainer instanceof ProtoContainer.Class) {
                    ProtoContainer.Class classR = (ProtoContainer.Class) protoContainer;
                    if (classR.getKind() == ProtoBuf.Class.Kind.INTERFACE) {
                        KotlinClassFinder kotlinClassFinder2 = this.kotlinClassFinder;
                        ClassId createNestedClassId = classR.getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
                        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder2, createNestedClassId);
                    }
                }
                if (bool.booleanValue() && (protoContainer instanceof ProtoContainer.Package)) {
                    SourceElement source = protoContainer.getSource();
                    if (source instanceof JvmPackagePartSource) {
                        jvmPackagePartSource = (JvmPackagePartSource) source;
                    } else {
                        jvmPackagePartSource = null;
                    }
                    if (jvmPackagePartSource != null) {
                        jvmClassName = jvmPackagePartSource.getFacadeClassName();
                    } else {
                        jvmClassName = null;
                    }
                    if (jvmClassName != null) {
                        KotlinClassFinder kotlinClassFinder3 = this.kotlinClassFinder;
                        String internalName = jvmClassName.getInternalName();
                        Intrinsics.checkNotNullExpressionValue(internalName, "facadeClassName.internalName");
                        ClassId classId = ClassId.topLevel(new FqName(StringsKt__StringsJVMKt.replace$default(internalName, '/', '.', false, 4, (Object) null)));
                        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(facadeCl…lName.replace('/', '.')))");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder3, classId);
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + protoContainer + ')').toString());
            }
        }
        if (z12 && (protoContainer instanceof ProtoContainer.Class)) {
            ProtoContainer.Class classR2 = (ProtoContainer.Class) protoContainer;
            if (classR2.getKind() == ProtoBuf.Class.Kind.COMPANION_OBJECT && (outerClass = classR2.getOuterClass()) != null && (outerClass.getKind() == ProtoBuf.Class.Kind.CLASS || outerClass.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS || (z13 && (outerClass.getKind() == ProtoBuf.Class.Kind.INTERFACE || outerClass.getKind() == ProtoBuf.Class.Kind.ANNOTATION_CLASS)))) {
                return toBinaryClass(outerClass);
            }
        }
        if (!(protoContainer instanceof ProtoContainer.Package) || !(protoContainer.getSource() instanceof JvmPackagePartSource)) {
            return null;
        }
        SourceElement source2 = protoContainer.getSource();
        Intrinsics.checkNotNull(source2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        JvmPackagePartSource jvmPackagePartSource2 = (JvmPackagePartSource) source2;
        KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource2.getKnownJvmBinaryClass();
        if (knownJvmBinaryClass == null) {
            return KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, jvmPackagePartSource2.getClassId());
        }
        return knownJvmBinaryClass;
    }

    public final boolean g(@NotNull ClassId classId) {
        KotlinJvmBinaryClass findKotlinClass;
        Intrinsics.checkNotNullParameter(classId, "classId");
        if (classId.getOuterClassId() == null || !Intrinsics.areEqual((Object) classId.getShortClassName().asString(), (Object) TextFieldImplKt.ContainerId) || (findKotlinClass = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, classId)) == null || !SpecialJvmAnnotations.INSTANCE.isAnnotatedWithContainerMetaAnnotation(findKotlinClass)) {
            return false;
        }
        return true;
    }

    @NotNull
    public abstract S getAnnotationsContainer(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass);

    @Nullable
    public abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor h(@NotNull ClassId classId, @NotNull SourceElement sourceElement, @NotNull List<A> list);

    @Nullable
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor i(@NotNull ClassId classId, @NotNull SourceElement sourceElement, @NotNull List<A> list) {
        Intrinsics.checkNotNullParameter(classId, "annotationClassId");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        Intrinsics.checkNotNullParameter(list, "result");
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(classId)) {
            return null;
        }
        return h(classId, sourceElement, list);
    }

    @NotNull
    public List<A> loadCallableAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, FWFConstants.EXPLANATION_TYPE_KIND);
        if (annotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
            return loadPropertyAnnotations(protoContainer, (ProtoBuf.Property) messageLite, PropertyRelatedElement.PROPERTY);
        }
        MemberSignature callableSignature$default = getCallableSignature$default(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, (Object) null);
        if (callableSignature$default == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return a(this, protoContainer, callableSignature$default, false, false, (Boolean) null, false, 60, (Object) null);
    }

    @NotNull
    public List<A> loadClassAnnotations(@NotNull ProtoContainer.Class classR) {
        Intrinsics.checkNotNullParameter(classR, TtmlNode.RUBY_CONTAINER);
        KotlinJvmBinaryClass binaryClass = toBinaryClass(classR);
        if (binaryClass != null) {
            ArrayList arrayList = new ArrayList(1);
            binaryClass.loadClassAnnotations(new AbstractBinaryClassAnnotationLoader$loadClassAnnotations$1(this, arrayList), c(binaryClass));
            return arrayList;
        }
        throw new IllegalStateException(("Class for loading annotations is not found: " + classR.debugFqName()).toString());
    }

    @NotNull
    public List<A> loadEnumEntryAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.EnumEntry enumEntry) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(enumEntry, "proto");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String string = protoContainer.getNameResolver().getString(enumEntry.getName());
        String asString = ((ProtoContainer.Class) protoContainer).getClassId().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "container as ProtoContai…Class).classId.asString()");
        return a(this, protoContainer, companion.fromFieldNameAndDesc(string, ClassMapperLite.mapClass(asString)), false, false, (Boolean) null, false, 60, (Object) null);
    }

    @NotNull
    public List<A> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, FWFConstants.EXPLANATION_TYPE_KIND);
        MemberSignature callableSignature$default = getCallableSignature$default(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, (Object) null);
        if (callableSignature$default == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return a(this, protoContainer, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, 0), false, false, (Boolean) null, false, 60, (Object) null);
    }

    @NotNull
    public List<A> loadPropertyBackingFieldAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(property, "proto");
        return loadPropertyAnnotations(protoContainer, property, PropertyRelatedElement.BACKING_FIELD);
    }

    @NotNull
    public List<A> loadPropertyDelegateFieldAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(property, "proto");
        return loadPropertyAnnotations(protoContainer, property, PropertyRelatedElement.DELEGATE_FIELD);
    }

    @NotNull
    public abstract A loadTypeAnnotation(@NotNull ProtoBuf.Annotation annotation, @NotNull NameResolver nameResolver);

    @NotNull
    public List<A> loadTypeAnnotations(@NotNull ProtoBuf.Type type, @NotNull NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(type, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = type.getExtension(JvmProtoBuf.typeAnnotation);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation annotation : iterable) {
            Intrinsics.checkNotNullExpressionValue(annotation, "it");
            arrayList.add(loadTypeAnnotation(annotation, nameResolver));
        }
        return arrayList;
    }

    @NotNull
    public List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter typeParameter, @NotNull NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(typeParameter, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = typeParameter.getExtension(JvmProtoBuf.typeParameterAnnotation);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation annotation : iterable) {
            Intrinsics.checkNotNullExpressionValue(annotation, "it");
            arrayList.add(loadTypeAnnotation(annotation, nameResolver));
        }
        return arrayList;
    }

    @NotNull
    public List<A> loadValueParameterAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind, int i11, @NotNull ProtoBuf.ValueParameter valueParameter) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(messageLite, "callableProto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(valueParameter, "proto");
        MemberSignature callableSignature$default = getCallableSignature$default(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, (Object) null);
        if (callableSignature$default == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return a(this, protoContainer, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, i11 + computeJvmParameterIndexShift(protoContainer, messageLite)), false, false, (Boolean) null, false, 60, (Object) null);
    }
}
