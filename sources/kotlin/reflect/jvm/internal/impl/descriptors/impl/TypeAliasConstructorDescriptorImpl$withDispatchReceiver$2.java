package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.Nullable;

public final class TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2 extends Lambda implements Function0<TypeAliasConstructorDescriptorImpl> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeAliasConstructorDescriptorImpl f24557g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ClassConstructorDescriptor f24558h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl, ClassConstructorDescriptor classConstructorDescriptor) {
        super(0);
        this.f24557g = typeAliasConstructorDescriptorImpl;
        this.f24558h = classConstructorDescriptor;
    }

    @Nullable
    public final TypeAliasConstructorDescriptorImpl invoke() {
        StorageManager storageManager = this.f24557g.getStorageManager();
        TypeAliasDescriptor typeAliasDescriptor = this.f24557g.getTypeAliasDescriptor();
        ClassConstructorDescriptor classConstructorDescriptor = this.f24558h;
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = this.f24557g;
        Annotations annotations = classConstructorDescriptor.getAnnotations();
        CallableMemberDescriptor.Kind kind = this.f24558h.getKind();
        Intrinsics.checkNotNullExpressionValue(kind, "underlyingConstructorDescriptor.kind");
        SourceElement source = this.f24557g.getTypeAliasDescriptor().getSource();
        Intrinsics.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl2 = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptorImpl, annotations, kind, source, (DefaultConstructorMarker) null);
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl3 = this.f24557g;
        ClassConstructorDescriptor classConstructorDescriptor2 = this.f24558h;
        TypeSubstitutor access$getTypeSubstitutorForUnderlyingClass = TypeAliasConstructorDescriptorImpl.Companion.getTypeSubstitutorForUnderlyingClass(typeAliasConstructorDescriptorImpl3.getTypeAliasDescriptor());
        ReceiverParameterDescriptor receiverParameterDescriptor = null;
        if (access$getTypeSubstitutorForUnderlyingClass == null) {
            return null;
        }
        ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor2.getDispatchReceiverParameter();
        if (dispatchReceiverParameter != null) {
            receiverParameterDescriptor = dispatchReceiverParameter.substitute(access$getTypeSubstitutorForUnderlyingClass);
        }
        List<ReceiverParameterDescriptor> contextReceiverParameters = classConstructorDescriptor2.getContextReceiverParameters();
        Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "underlyingConstructorDes…contextReceiverParameters");
        Iterable<ReceiverParameterDescriptor> iterable = contextReceiverParameters;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ReceiverParameterDescriptor substitute : iterable) {
            arrayList.add(substitute.substitute(access$getTypeSubstitutorForUnderlyingClass));
        }
        typeAliasConstructorDescriptorImpl2.initialize((ReceiverParameterDescriptor) null, receiverParameterDescriptor, arrayList, typeAliasConstructorDescriptorImpl3.getTypeAliasDescriptor().getDeclaredTypeParameters(), typeAliasConstructorDescriptorImpl3.getValueParameters(), typeAliasConstructorDescriptorImpl3.getReturnType(), Modality.FINAL, typeAliasConstructorDescriptorImpl3.getTypeAliasDescriptor().getVisibility());
        return typeAliasConstructorDescriptorImpl2;
    }
}
