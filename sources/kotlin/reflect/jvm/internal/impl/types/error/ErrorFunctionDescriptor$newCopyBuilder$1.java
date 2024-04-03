package kotlin.reflect.jvm.internal.impl.types.error;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ErrorFunctionDescriptor$newCopyBuilder$1 implements FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ErrorFunctionDescriptor f24972a;

    public ErrorFunctionDescriptor$newCopyBuilder$1(ErrorFunctionDescriptor errorFunctionDescriptor) {
        this.f24972a = errorFunctionDescriptor;
    }

    @NotNull
    public <V> FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> putUserData(@NotNull CallableDescriptor.UserDataKey<V> userDataKey, V v11) {
        Intrinsics.checkNotNullParameter(userDataKey, "userDataKey");
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setAdditionalAnnotations(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "additionalAnnotations");
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setCopyOverrides(boolean z11) {
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDropOriginalInContainingParts() {
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenToOvercomeSignatureClash() {
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setKind(@NotNull CallableMemberDescriptor.Kind kind) {
        Intrinsics.checkNotNullParameter(kind, FWFConstants.EXPLANATION_TYPE_KIND);
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setModality(@NotNull Modality modality) {
        Intrinsics.checkNotNullParameter(modality, "modality");
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setName(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOwner(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "owner");
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setPreserveSourceElement() {
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setReturnType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSignatureChange() {
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSubstitution(@NotNull TypeSubstitution typeSubstitution) {
        Intrinsics.checkNotNullParameter(typeSubstitution, "substitution");
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setTypeParameters(@NotNull List<? extends TypeParameterDescriptor> list) {
        Intrinsics.checkNotNullParameter(list, "parameters");
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setValueParameters(@NotNull List<? extends ValueParameterDescriptor> list) {
        Intrinsics.checkNotNullParameter(list, "parameters");
        return this;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
        Intrinsics.checkNotNullParameter(descriptorVisibility, "visibility");
        return this;
    }

    @NotNull
    public SimpleFunctionDescriptor build() {
        return this.f24972a;
    }
}
