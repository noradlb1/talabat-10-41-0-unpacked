package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeAliasConstructorDescriptorImpl extends FunctionDescriptorImpl implements TypeAliasConstructorDescriptor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24556d = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TypeAliasConstructorDescriptorImpl.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final TypeAliasDescriptor typeAliasDescriptor;
    @NotNull
    private ClassConstructorDescriptor underlyingConstructorDescriptor;
    @NotNull
    private final NullableLazyValue withDispatchReceiver$delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final TypeSubstitutor getTypeSubstitutorForUnderlyingClass(TypeAliasDescriptor typeAliasDescriptor) {
            if (typeAliasDescriptor.getClassDescriptor() == null) {
                return null;
            }
            return TypeSubstitutor.create((KotlinType) typeAliasDescriptor.getExpandedType());
        }

        @Nullable
        public final TypeAliasConstructorDescriptor createIfAvailable(@NotNull StorageManager storageManager, @NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull ClassConstructorDescriptor classConstructorDescriptor) {
            ClassConstructorDescriptor substitute;
            List list;
            TypeAliasDescriptor typeAliasDescriptor2 = typeAliasDescriptor;
            ClassConstructorDescriptor classConstructorDescriptor2 = classConstructorDescriptor;
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(typeAliasDescriptor2, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(classConstructorDescriptor2, "constructor");
            TypeSubstitutor typeSubstitutorForUnderlyingClass = getTypeSubstitutorForUnderlyingClass(typeAliasDescriptor2);
            ReceiverParameterDescriptor receiverParameterDescriptor = null;
            if (typeSubstitutorForUnderlyingClass == null || (substitute = classConstructorDescriptor2.substitute(typeSubstitutorForUnderlyingClass)) == null) {
                return null;
            }
            Annotations annotations = classConstructorDescriptor.getAnnotations();
            CallableMemberDescriptor.Kind kind = classConstructorDescriptor.getKind();
            Intrinsics.checkNotNullExpressionValue(kind, "constructor.kind");
            SourceElement source = typeAliasDescriptor.getSource();
            Intrinsics.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, substitute, (TypeAliasConstructorDescriptor) null, annotations, kind, source, (DefaultConstructorMarker) null);
            List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(typeAliasConstructorDescriptorImpl, classConstructorDescriptor.getValueParameters(), typeSubstitutorForUnderlyingClass);
            if (substitutedValueParameters == null) {
                return null;
            }
            SimpleType lowerIfFlexible = FlexibleTypesKt.lowerIfFlexible(substitute.getReturnType().unwrap());
            SimpleType defaultType = typeAliasDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "typeAliasDescriptor.defaultType");
            SimpleType withAbbreviation = SpecialTypesKt.withAbbreviation(lowerIfFlexible, defaultType);
            ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor.getDispatchReceiverParameter();
            if (dispatchReceiverParameter != null) {
                receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(typeAliasConstructorDescriptorImpl, typeSubstitutorForUnderlyingClass.safeSubstitute(dispatchReceiverParameter.getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY());
            }
            ReceiverParameterDescriptor receiverParameterDescriptor2 = receiverParameterDescriptor;
            ClassDescriptor classDescriptor = typeAliasDescriptor.getClassDescriptor();
            if (classDescriptor != null) {
                List<ReceiverParameterDescriptor> contextReceiverParameters = classConstructorDescriptor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "constructor.contextReceiverParameters");
                Iterable<ReceiverParameterDescriptor> iterable = contextReceiverParameters;
                list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (ReceiverParameterDescriptor type : iterable) {
                    list.add(DescriptorFactory.createContextReceiverParameterForClass(classDescriptor, typeSubstitutorForUnderlyingClass.safeSubstitute(type.getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY()));
                }
            } else {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            typeAliasConstructorDescriptorImpl.initialize(receiverParameterDescriptor2, (ReceiverParameterDescriptor) null, list, typeAliasDescriptor.getDeclaredTypeParameters(), substitutedValueParameters, withAbbreviation, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return typeAliasConstructorDescriptorImpl;
        }
    }

    private TypeAliasConstructorDescriptorImpl(StorageManager storageManager2, TypeAliasDescriptor typeAliasDescriptor2, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, CallableMemberDescriptor.Kind kind, SourceElement sourceElement) {
        super(typeAliasDescriptor2, typeAliasConstructorDescriptor, annotations, SpecialNames.INIT, kind, sourceElement);
        this.storageManager = storageManager2;
        this.typeAliasDescriptor = typeAliasDescriptor2;
        setActual(getTypeAliasDescriptor().isActual());
        this.withDispatchReceiver$delegate = storageManager2.createNullableLazyValue(new TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(this, classConstructorDescriptor));
        this.underlyingConstructorDescriptor = classConstructorDescriptor;
    }

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(StorageManager storageManager2, TypeAliasDescriptor typeAliasDescriptor2, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, CallableMemberDescriptor.Kind kind, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager2, typeAliasDescriptor2, classConstructorDescriptor, typeAliasConstructorDescriptor, annotations, kind, sourceElement);
    }

    @NotNull
    /* renamed from: d */
    public TypeAliasConstructorDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name2, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind != kind2) {
            CallableMemberDescriptor.Kind kind3 = CallableMemberDescriptor.Kind.SYNTHESIZED;
        }
        return new TypeAliasConstructorDescriptorImpl(this.storageManager, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, annotations, kind2, sourceElement);
    }

    @NotNull
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    @NotNull
    public KotlinType getReturnType() {
        KotlinType returnType = super.getReturnType();
        Intrinsics.checkNotNull(returnType);
        return returnType;
    }

    @NotNull
    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    @NotNull
    public TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.typeAliasDescriptor;
    }

    @NotNull
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.underlyingConstructorDescriptor;
    }

    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    @NotNull
    public TypeAliasConstructorDescriptor copy(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @NotNull CallableMemberDescriptor.Kind kind, boolean z11) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(modality, "modality");
        Intrinsics.checkNotNullParameter(descriptorVisibility, "visibility");
        Intrinsics.checkNotNullParameter(kind, FWFConstants.EXPLANATION_TYPE_KIND);
        Object build = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(descriptorVisibility).setKind(kind).setCopyOverrides(z11).build();
        Intrinsics.checkNotNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) build;
    }

    @NotNull
    public TypeAliasDescriptor getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Nullable
    public TypeAliasConstructorDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
        FunctionDescriptor substitute = super.substitute(typeSubstitutor);
        Intrinsics.checkNotNull(substitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = (TypeAliasConstructorDescriptorImpl) substitute;
        TypeSubstitutor create = TypeSubstitutor.create(typeAliasConstructorDescriptorImpl.getReturnType());
        Intrinsics.checkNotNullExpressionValue(create, "create(substitutedTypeAliasConstructor.returnType)");
        ClassConstructorDescriptor substitute2 = getUnderlyingConstructorDescriptor().getOriginal().substitute(create);
        if (substitute2 == null) {
            return null;
        }
        typeAliasConstructorDescriptorImpl.underlyingConstructorDescriptor = substitute2;
        return typeAliasConstructorDescriptorImpl;
    }

    @NotNull
    public TypeAliasConstructorDescriptor getOriginal() {
        FunctionDescriptor original = super.getOriginal();
        Intrinsics.checkNotNull(original, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) original;
    }
}
