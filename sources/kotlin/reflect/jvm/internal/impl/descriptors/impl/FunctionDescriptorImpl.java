package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class FunctionDescriptorImpl extends DeclarationDescriptorNonRootImpl implements FunctionDescriptor {

    /* renamed from: b  reason: collision with root package name */
    public Map<CallableDescriptor.UserDataKey<?>, Object> f24523b;
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    /* access modifiers changed from: private */
    public ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private boolean hasStableParameterNames;
    private boolean hasSynthesizedParameterNames;
    @Nullable
    private FunctionDescriptor initialSignatureDescriptor;
    private boolean isActual;
    private boolean isExpect;
    private boolean isExternal;
    private boolean isHiddenForResolutionEverywhereBesideSupercalls;
    private boolean isHiddenToOvercomeSignatureClash;
    private boolean isInfix;
    private boolean isInline;
    private boolean isOperator;
    private boolean isSuspend;
    private boolean isTailrec;
    private final CallableMemberDescriptor.Kind kind;
    private volatile Function0<Collection<FunctionDescriptor>> lazyOverriddenFunctionsTask;
    private Modality modality;
    private final FunctionDescriptor original;
    private Collection<? extends FunctionDescriptor> overriddenFunctions;
    private List<TypeParameterDescriptor> typeParameters;
    private KotlinType unsubstitutedReturnType;
    private List<ValueParameterDescriptor> unsubstitutedValueParameters;
    private DescriptorVisibility visibility;

    public class CopyConfiguration implements FunctionDescriptor.CopyBuilder<FunctionDescriptor> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public TypeSubstitution f24527a;
        /* access modifiers changed from: private */
        public Annotations additionalAnnotations;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public DeclarationDescriptor f24528b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public Modality f24529c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public DescriptorVisibility f24530d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public FunctionDescriptor f24531e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        public CallableMemberDescriptor.Kind f24532f;
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        public List<ValueParameterDescriptor> f24533g;
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        public List<ReceiverParameterDescriptor> f24534h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public ReceiverParameterDescriptor f24535i;
        /* access modifiers changed from: private */
        public boolean isHiddenForResolutionEverywhereBesideSupercalls;
        /* access modifiers changed from: private */
        public boolean isHiddenToOvercomeSignatureClash;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public ReceiverParameterDescriptor f24536j;
        @NotNull

        /* renamed from: k  reason: collision with root package name */
        public KotlinType f24537k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        public Name f24538l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f24539m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f24540n;
        /* access modifiers changed from: private */
        public Boolean newHasSynthesizedParameterNames;
        /* access modifiers changed from: private */
        public List<TypeParameterDescriptor> newTypeParameters;

        /* renamed from: o  reason: collision with root package name */
        public boolean f24541o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f24542p;

        /* renamed from: q  reason: collision with root package name */
        public boolean f24543q;

        /* renamed from: r  reason: collision with root package name */
        public final /* synthetic */ FunctionDescriptorImpl f24544r;
        /* access modifiers changed from: private */
        public Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;

        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            String str;
            int i12;
            Throwable th2;
            switch (i11) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i11) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    i12 = 2;
                    break;
                default:
                    i12 = 3;
                    break;
            }
            Object[] objArr = new Object[i12];
            switch (i11) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 14:
                    objArr[0] = FWFConstants.EXPLANATION_TYPE_KIND;
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newContextReceiverParameters";
                    break;
                case 7:
                    objArr[0] = "newReturnType";
                    break;
                case 8:
                    objArr[0] = "owner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[0] = "modality";
                    break;
                case 12:
                    objArr[0] = "visibility";
                    break;
                case 17:
                    objArr[0] = "name";
                    break;
                case 19:
                case 21:
                    objArr[0] = "parameters";
                    break;
                case 23:
                    objArr[0] = "type";
                    break;
                case 25:
                    objArr[0] = "contextReceiverParameters";
                    break;
                case 35:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 39:
                    objArr[0] = "userDataKey";
                    break;
                default:
                    objArr[0] = "substitution";
                    break;
            }
            switch (i11) {
                case 9:
                    objArr[1] = "setOwner";
                    break;
                case 11:
                    objArr[1] = "setModality";
                    break;
                case 13:
                    objArr[1] = "setVisibility";
                    break;
                case 15:
                    objArr[1] = "setKind";
                    break;
                case 16:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 18:
                    objArr[1] = "setName";
                    break;
                case 20:
                    objArr[1] = "setValueParameters";
                    break;
                case 22:
                    objArr[1] = "setTypeParameters";
                    break;
                case 24:
                    objArr[1] = "setReturnType";
                    break;
                case 26:
                    objArr[1] = "setContextReceiverParameters";
                    break;
                case 27:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 28:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 29:
                    objArr[1] = "setOriginal";
                    break;
                case 30:
                    objArr[1] = "setSignatureChange";
                    break;
                case 31:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 32:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 33:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 34:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 36:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 38:
                    objArr[1] = "setSubstitution";
                    break;
                case 40:
                    objArr[1] = "putUserData";
                    break;
                case 41:
                    objArr[1] = "getSubstitution";
                    break;
                case 42:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
            }
            switch (i11) {
                case 8:
                    objArr[2] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    break;
                case 10:
                    objArr[2] = "setModality";
                    break;
                case 12:
                    objArr[2] = "setVisibility";
                    break;
                case 14:
                    objArr[2] = "setKind";
                    break;
                case 17:
                    objArr[2] = "setName";
                    break;
                case 19:
                    objArr[2] = "setValueParameters";
                    break;
                case 21:
                    objArr[2] = "setTypeParameters";
                    break;
                case 23:
                    objArr[2] = "setReturnType";
                    break;
                case 25:
                    objArr[2] = "setContextReceiverParameters";
                    break;
                case 35:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 37:
                    objArr[2] = "setSubstitution";
                    break;
                case 39:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                    break;
            }
            String format = String.format(str, objArr);
            switch (i11) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    th2 = new IllegalStateException(format);
                    break;
                default:
                    th2 = new IllegalArgumentException(format);
                    break;
            }
            throw th2;
        }

        public CopyConfiguration(@NotNull FunctionDescriptorImpl functionDescriptorImpl, @NotNull TypeSubstitution typeSubstitution, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @NotNull CallableMemberDescriptor.Kind kind, @NotNull List<ValueParameterDescriptor> list, @Nullable List<ReceiverParameterDescriptor> list2, @NotNull ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable KotlinType kotlinType, Name name2) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            if (modality == null) {
                $$$reportNull$$$0(2);
            }
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(3);
            }
            if (kind == null) {
                $$$reportNull$$$0(4);
            }
            if (list == null) {
                $$$reportNull$$$0(5);
            }
            if (list2 == null) {
                $$$reportNull$$$0(6);
            }
            if (kotlinType == null) {
                $$$reportNull$$$0(7);
            }
            this.f24544r = functionDescriptorImpl;
            this.f24531e = null;
            this.f24536j = functionDescriptorImpl.dispatchReceiverParameter;
            this.f24539m = true;
            this.f24540n = false;
            this.f24541o = false;
            this.f24542p = false;
            this.isHiddenToOvercomeSignatureClash = functionDescriptorImpl.isHiddenToOvercomeSignatureClash();
            this.newTypeParameters = null;
            this.additionalAnnotations = null;
            this.isHiddenForResolutionEverywhereBesideSupercalls = functionDescriptorImpl.isHiddenForResolutionEverywhereBesideSupercalls();
            this.userDataMap = new LinkedHashMap();
            this.newHasSynthesizedParameterNames = null;
            this.f24543q = false;
            this.f24527a = typeSubstitution;
            this.f24528b = declarationDescriptor;
            this.f24529c = modality;
            this.f24530d = descriptorVisibility;
            this.f24532f = kind;
            this.f24533g = list;
            this.f24534h = list2;
            this.f24535i = receiverParameterDescriptor;
            this.f24537k = kotlinType;
            this.f24538l = name2;
        }

        @Nullable
        public FunctionDescriptor build() {
            return this.f24544r.b(this);
        }

        @NotNull
        public <V> FunctionDescriptor.CopyBuilder<FunctionDescriptor> putUserData(@NotNull CallableDescriptor.UserDataKey<V> userDataKey, V v11) {
            if (userDataKey == null) {
                $$$reportNull$$$0(39);
            }
            this.userDataMap.put(userDataKey, v11);
            return this;
        }

        public CopyConfiguration setHasSynthesizedParameterNames(boolean z11) {
            this.newHasSynthesizedParameterNames = Boolean.valueOf(z11);
            return this;
        }

        @NotNull
        public CopyConfiguration setJustForTypeSubstitution(boolean z11) {
            this.f24543q = z11;
            return this;
        }

        @NotNull
        public CopyConfiguration setAdditionalAnnotations(@NotNull Annotations annotations) {
            if (annotations == null) {
                $$$reportNull$$$0(35);
            }
            this.additionalAnnotations = annotations;
            return this;
        }

        @NotNull
        public CopyConfiguration setCopyOverrides(boolean z11) {
            this.f24539m = z11;
            return this;
        }

        @NotNull
        public CopyConfiguration setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.f24536j = receiverParameterDescriptor;
            return this;
        }

        @NotNull
        public CopyConfiguration setDropOriginalInContainingParts() {
            this.f24542p = true;
            return this;
        }

        @NotNull
        public CopyConfiguration setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.f24535i = receiverParameterDescriptor;
            return this;
        }

        @NotNull
        public CopyConfiguration setHiddenForResolutionEverywhereBesideSupercalls() {
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            return this;
        }

        @NotNull
        public CopyConfiguration setHiddenToOvercomeSignatureClash() {
            this.isHiddenToOvercomeSignatureClash = true;
            return this;
        }

        @NotNull
        public CopyConfiguration setKind(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                $$$reportNull$$$0(14);
            }
            this.f24532f = kind;
            return this;
        }

        @NotNull
        public CopyConfiguration setModality(@NotNull Modality modality) {
            if (modality == null) {
                $$$reportNull$$$0(10);
            }
            this.f24529c = modality;
            return this;
        }

        @NotNull
        public CopyConfiguration setName(@NotNull Name name2) {
            if (name2 == null) {
                $$$reportNull$$$0(17);
            }
            this.f24538l = name2;
            return this;
        }

        @NotNull
        public CopyConfiguration setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.f24531e = (FunctionDescriptor) callableMemberDescriptor;
            return this;
        }

        @NotNull
        public CopyConfiguration setOwner(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(8);
            }
            this.f24528b = declarationDescriptor;
            return this;
        }

        @NotNull
        public CopyConfiguration setPreserveSourceElement() {
            this.f24541o = true;
            return this;
        }

        @NotNull
        public CopyConfiguration setReturnType(@NotNull KotlinType kotlinType) {
            if (kotlinType == null) {
                $$$reportNull$$$0(23);
            }
            this.f24537k = kotlinType;
            return this;
        }

        @NotNull
        public CopyConfiguration setSignatureChange() {
            this.f24540n = true;
            return this;
        }

        @NotNull
        public CopyConfiguration setSubstitution(@NotNull TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(37);
            }
            this.f24527a = typeSubstitution;
            return this;
        }

        @NotNull
        public CopyConfiguration setTypeParameters(@NotNull List<TypeParameterDescriptor> list) {
            if (list == null) {
                $$$reportNull$$$0(21);
            }
            this.newTypeParameters = list;
            return this;
        }

        @NotNull
        public CopyConfiguration setValueParameters(@NotNull List<ValueParameterDescriptor> list) {
            if (list == null) {
                $$$reportNull$$$0(19);
            }
            this.f24533g = list;
            return this;
        }

        @NotNull
        public CopyConfiguration setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(12);
            }
            this.f24530d = descriptorVisibility;
            return this;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str;
        int i12;
        Throwable th2;
        switch (i11) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i11) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                i12 = 2;
                break;
            default:
                i12 = 3;
                break;
        }
        Object[] objArr = new Object[i12];
        switch (i11) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = FWFConstants.EXPLANATION_TYPE_KIND;
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case 29:
            case 31:
                objArr[0] = "substitutor";
                break;
            case 25:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i11) {
            case 9:
                objArr[1] = "initialize";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getKind";
                break;
            case 23:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = "copy";
                break;
            case 27:
                objArr[1] = "getSourceToUseForCopy";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
        }
        switch (i11) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String format = String.format(str, objArr);
        switch (i11) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                th2 = new IllegalStateException(format);
                break;
            default:
                th2 = new IllegalArgumentException(format);
                break;
        }
        throw th2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionDescriptorImpl(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull Annotations annotations, @NotNull Name name2, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull SourceElement sourceElement) {
        super(declarationDescriptor, annotations, name2, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name2 == null) {
            $$$reportNull$$$0(2);
        }
        if (kind2 == null) {
            $$$reportNull$$$0(3);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(4);
        }
        this.visibility = DescriptorVisibilities.UNKNOWN;
        this.isOperator = false;
        this.isInfix = false;
        this.isExternal = false;
        this.isInline = false;
        this.isTailrec = false;
        this.isExpect = false;
        this.isActual = false;
        this.isHiddenToOvercomeSignatureClash = false;
        this.isHiddenForResolutionEverywhereBesideSupercalls = false;
        this.isSuspend = false;
        this.hasStableParameterNames = true;
        this.hasSynthesizedParameterNames = false;
        this.overriddenFunctions = null;
        this.lazyOverriddenFunctionsTask = null;
        this.initialSignatureDescriptor = null;
        this.f24523b = null;
        this.original = functionDescriptor == null ? this : functionDescriptor;
        this.kind = kind2;
    }

    @NotNull
    private SourceElement getSourceToUseForCopy(boolean z11, @Nullable FunctionDescriptor functionDescriptor) {
        SourceElement sourceElement;
        if (z11) {
            if (functionDescriptor == null) {
                functionDescriptor = getOriginal();
            }
            sourceElement = functionDescriptor.getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(27);
        }
        return sourceElement;
    }

    @Nullable
    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor functionDescriptor, @NotNull List<ValueParameterDescriptor> list, @NotNull TypeSubstitutor typeSubstitutor) {
        if (list == null) {
            $$$reportNull$$$0(28);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(29);
        }
        return getSubstitutedValueParameters(functionDescriptor, list, typeSubstitutor, false, false, (boolean[]) null);
    }

    private void performOverriddenLazyCalculationIfNeeded() {
        Function0<Collection<FunctionDescriptor>> function0 = this.lazyOverriddenFunctionsTask;
        if (function0 != null) {
            this.overriddenFunctions = function0.invoke();
            this.lazyOverriddenFunctionsTask = null;
        }
    }

    private void setHiddenForResolutionEverywhereBesideSupercalls(boolean z11) {
        this.isHiddenForResolutionEverywhereBesideSupercalls = z11;
    }

    private void setHiddenToOvercomeSignatureClash(boolean z11) {
        this.isHiddenToOvercomeSignatureClash = z11;
    }

    private void setInitialSignatureDescriptor(@Nullable FunctionDescriptor functionDescriptor) {
        this.initialSignatureDescriptor = functionDescriptor;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d11) {
        return declarationDescriptorVisitor.visitFunctionDescriptor(this, d11);
    }

    @Nullable
    public FunctionDescriptor b(@NotNull CopyConfiguration copyConfiguration) {
        Annotations annotations;
        List<TypeParameterDescriptor> list;
        ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        KotlinType substitute;
        boolean z11;
        boolean z12;
        FunctionDescriptor functionDescriptor;
        boolean z13;
        boolean z14;
        boolean z15;
        CopyConfiguration copyConfiguration2 = copyConfiguration;
        if (copyConfiguration2 == null) {
            $$$reportNull$$$0(25);
        }
        boolean[] zArr = new boolean[1];
        if (copyConfiguration.additionalAnnotations != null) {
            annotations = AnnotationsKt.composeAnnotations(getAnnotations(), copyConfiguration.additionalAnnotations);
        } else {
            annotations = getAnnotations();
        }
        DeclarationDescriptor declarationDescriptor = copyConfiguration2.f24528b;
        FunctionDescriptor functionDescriptor2 = copyConfiguration2.f24531e;
        FunctionDescriptorImpl createSubstitutedCopy = createSubstitutedCopy(declarationDescriptor, functionDescriptor2, copyConfiguration2.f24532f, copyConfiguration2.f24538l, annotations, getSourceToUseForCopy(copyConfiguration2.f24541o, functionDescriptor2));
        if (copyConfiguration.newTypeParameters == null) {
            list = getTypeParameters();
        } else {
            list = copyConfiguration.newTypeParameters;
        }
        zArr[0] = zArr[0] | (!list.isEmpty());
        ArrayList arrayList = new ArrayList(list.size());
        TypeSubstitutor substituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(list, copyConfiguration2.f24527a, createSubstitutedCopy, arrayList, zArr);
        if (substituteTypeParameters == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!copyConfiguration2.f24534h.isEmpty()) {
            for (ReceiverParameterDescriptor next : copyConfiguration2.f24534h) {
                KotlinType substitute2 = substituteTypeParameters.substitute(next.getType(), Variance.IN_VARIANCE);
                if (substitute2 == null) {
                    return null;
                }
                arrayList2.add(DescriptorFactory.createContextReceiverParameterForCallable(createSubstitutedCopy, substitute2, next.getAnnotations()));
                boolean z16 = zArr[0];
                if (substitute2 != next.getType()) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                zArr[0] = z15 | z16;
            }
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = copyConfiguration2.f24535i;
        if (receiverParameterDescriptor2 != null) {
            KotlinType substitute3 = substituteTypeParameters.substitute(receiverParameterDescriptor2.getType(), Variance.IN_VARIANCE);
            if (substitute3 == null) {
                return null;
            }
            ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl2 = new ReceiverParameterDescriptorImpl(createSubstitutedCopy, new ExtensionReceiver(createSubstitutedCopy, substitute3, copyConfiguration2.f24535i.getValue()), copyConfiguration2.f24535i.getAnnotations());
            boolean z17 = zArr[0];
            if (substitute3 != copyConfiguration2.f24535i.getType()) {
                z14 = true;
            } else {
                z14 = false;
            }
            zArr[0] = z14 | z17;
            receiverParameterDescriptorImpl = receiverParameterDescriptorImpl2;
        } else {
            receiverParameterDescriptorImpl = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = copyConfiguration2.f24536j;
        if (receiverParameterDescriptor3 != null) {
            ReceiverParameterDescriptor substitute4 = receiverParameterDescriptor3.substitute(substituteTypeParameters);
            if (substitute4 == null) {
                return null;
            }
            boolean z18 = zArr[0];
            if (substitute4 != copyConfiguration2.f24536j) {
                z13 = true;
            } else {
                z13 = false;
            }
            zArr[0] = z18 | z13;
            receiverParameterDescriptor = substitute4;
        } else {
            receiverParameterDescriptor = null;
        }
        List<ValueParameterDescriptor> substitutedValueParameters = getSubstitutedValueParameters(createSubstitutedCopy, copyConfiguration2.f24533g, substituteTypeParameters, copyConfiguration2.f24542p, copyConfiguration2.f24541o, zArr);
        if (substitutedValueParameters == null || (substitute = substituteTypeParameters.substitute(copyConfiguration2.f24537k, Variance.OUT_VARIANCE)) == null) {
            return null;
        }
        boolean z19 = zArr[0];
        if (substitute != copyConfiguration2.f24537k) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z21 = z19 | z11;
        zArr[0] = z21;
        if (!z21 && copyConfiguration2.f24543q) {
            return this;
        }
        final TypeSubstitutor typeSubstitutor = substituteTypeParameters;
        createSubstitutedCopy.initialize(receiverParameterDescriptorImpl, receiverParameterDescriptor, arrayList2, arrayList, substitutedValueParameters, substitute, copyConfiguration2.f24529c, copyConfiguration2.f24530d);
        createSubstitutedCopy.setOperator(this.isOperator);
        createSubstitutedCopy.setInfix(this.isInfix);
        createSubstitutedCopy.setExternal(this.isExternal);
        createSubstitutedCopy.setInline(this.isInline);
        createSubstitutedCopy.setTailrec(this.isTailrec);
        createSubstitutedCopy.setSuspend(this.isSuspend);
        createSubstitutedCopy.setExpect(this.isExpect);
        createSubstitutedCopy.setActual(this.isActual);
        createSubstitutedCopy.setHasStableParameterNames(this.hasStableParameterNames);
        createSubstitutedCopy.setHiddenToOvercomeSignatureClash(copyConfiguration.isHiddenToOvercomeSignatureClash);
        createSubstitutedCopy.setHiddenForResolutionEverywhereBesideSupercalls(copyConfiguration.isHiddenForResolutionEverywhereBesideSupercalls);
        if (copyConfiguration.newHasSynthesizedParameterNames != null) {
            z12 = copyConfiguration.newHasSynthesizedParameterNames.booleanValue();
        } else {
            z12 = this.hasSynthesizedParameterNames;
        }
        createSubstitutedCopy.setHasSynthesizedParameterNames(z12);
        if (!copyConfiguration.userDataMap.isEmpty() || this.f24523b != null) {
            Map<CallableDescriptor.UserDataKey<?>, Object> f11 = copyConfiguration.userDataMap;
            Map<CallableDescriptor.UserDataKey<?>, Object> map = this.f24523b;
            if (map != null) {
                for (Map.Entry next2 : map.entrySet()) {
                    if (!f11.containsKey(next2.getKey())) {
                        f11.put(next2.getKey(), next2.getValue());
                    }
                }
            }
            if (f11.size() == 1) {
                createSubstitutedCopy.f24523b = Collections.singletonMap(f11.keySet().iterator().next(), f11.values().iterator().next());
            } else {
                createSubstitutedCopy.f24523b = f11;
            }
        }
        if (copyConfiguration2.f24540n || getInitialSignatureDescriptor() != null) {
            if (getInitialSignatureDescriptor() != null) {
                functionDescriptor = getInitialSignatureDescriptor();
            } else {
                functionDescriptor = this;
            }
            createSubstitutedCopy.setInitialSignatureDescriptor(functionDescriptor.substitute(typeSubstitutor));
        }
        if (copyConfiguration2.f24539m && !getOriginal().getOverriddenDescriptors().isEmpty()) {
            if (copyConfiguration2.f24527a.isEmpty()) {
                Function0<Collection<FunctionDescriptor>> function0 = this.lazyOverriddenFunctionsTask;
                if (function0 != null) {
                    createSubstitutedCopy.lazyOverriddenFunctionsTask = function0;
                } else {
                    createSubstitutedCopy.setOverriddenDescriptors(getOverriddenDescriptors());
                }
            } else {
                createSubstitutedCopy.lazyOverriddenFunctionsTask = new Function0<Collection<FunctionDescriptor>>() {
                    public Collection<FunctionDescriptor> invoke() {
                        SmartList smartList = new SmartList();
                        for (FunctionDescriptor substitute : FunctionDescriptorImpl.this.getOverriddenDescriptors()) {
                            smartList.add(substitute.substitute(typeSubstitutor));
                        }
                        return smartList;
                    }
                };
            }
        }
        return createSubstitutedCopy;
    }

    @NotNull
    public CopyConfiguration c(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(24);
        }
        return new CopyConfiguration(this, typeSubstitutor.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getContextReceiverParameters(), getExtensionReceiverParameter(), getReturnType(), (Name) null);
    }

    @NotNull
    public abstract FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind2, @Nullable Name name2, @NotNull Annotations annotations, @NotNull SourceElement sourceElement);

    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> list = this.contextReceiverParameters;
        if (list == null) {
            $$$reportNull$$$0(13);
        }
        return list;
    }

    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Nullable
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind2 = this.kind;
        if (kind2 == null) {
            $$$reportNull$$$0(21);
        }
        return kind2;
    }

    @NotNull
    public Modality getModality() {
        Modality modality2 = this.modality;
        if (modality2 == null) {
            $$$reportNull$$$0(15);
        }
        return modality2;
    }

    @NotNull
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        performOverriddenLazyCalculationIfNeeded();
        Collection<? extends FunctionDescriptor> collection = this.overriddenFunctions;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            $$$reportNull$$$0(14);
        }
        return collection;
    }

    public KotlinType getReturnType() {
        return this.unsubstitutedReturnType;
    }

    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeParameters;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        Map map = this.f24523b;
        if (map == null) {
            return null;
        }
        return map.get(userDataKey);
    }

    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.unsubstitutedValueParameters;
        if (list == null) {
            $$$reportNull$$$0(19);
        }
        return list;
    }

    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(16);
        }
        return descriptorVisibility;
    }

    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames;
    }

    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames;
    }

    @NotNull
    public FunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<ReceiverParameterDescriptor> list, @NotNull List<? extends TypeParameterDescriptor> list2, @NotNull List<ValueParameterDescriptor> list3, @Nullable KotlinType kotlinType, @Nullable Modality modality2, @NotNull DescriptorVisibility descriptorVisibility) {
        if (list == null) {
            $$$reportNull$$$0(5);
        }
        if (list2 == null) {
            $$$reportNull$$$0(6);
        }
        if (list3 == null) {
            $$$reportNull$$$0(7);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(8);
        }
        this.typeParameters = CollectionsKt___CollectionsKt.toList(list2);
        this.unsubstitutedValueParameters = CollectionsKt___CollectionsKt.toList(list3);
        this.unsubstitutedReturnType = kotlinType;
        this.modality = modality2;
        this.visibility = descriptorVisibility;
        this.extensionReceiverParameter = receiverParameterDescriptor;
        this.dispatchReceiverParameter = receiverParameterDescriptor2;
        this.contextReceiverParameters = list;
        int i11 = 0;
        int i12 = 0;
        while (i12 < list2.size()) {
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) list2.get(i12);
            if (typeParameterDescriptor.getIndex() == i12) {
                i12++;
            } else {
                throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i12);
            }
        }
        while (i11 < list3.size()) {
            ValueParameterDescriptor valueParameterDescriptor = list3.get(i11);
            if (valueParameterDescriptor.getIndex() == i11 + 0) {
                i11++;
            } else {
                throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i11);
            }
        }
        return this;
    }

    public boolean isActual() {
        return this.isActual;
    }

    public boolean isExpect() {
        return this.isExpect;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.isHiddenForResolutionEverywhereBesideSupercalls;
    }

    public boolean isHiddenToOvercomeSignatureClash() {
        return this.isHiddenToOvercomeSignatureClash;
    }

    public boolean isInfix() {
        if (this.isInfix) {
            return true;
        }
        for (FunctionDescriptor isInfix2 : getOriginal().getOverriddenDescriptors()) {
            if (isInfix2.isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.isInline;
    }

    public boolean isOperator() {
        if (this.isOperator) {
            return true;
        }
        for (FunctionDescriptor isOperator2 : getOriginal().getOverriddenDescriptors()) {
            if (isOperator2.isOperator()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSuspend() {
        return this.isSuspend;
    }

    public boolean isTailrec() {
        return this.isTailrec;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        CopyConfiguration c11 = c(TypeSubstitutor.EMPTY);
        if (c11 == null) {
            $$$reportNull$$$0(23);
        }
        return c11;
    }

    public <V> void putInUserDataMap(CallableDescriptor.UserDataKey<V> userDataKey, Object obj) {
        if (this.f24523b == null) {
            this.f24523b = new LinkedHashMap();
        }
        this.f24523b.put(userDataKey, obj);
    }

    public void setActual(boolean z11) {
        this.isActual = z11;
    }

    public void setExpect(boolean z11) {
        this.isExpect = z11;
    }

    public void setExternal(boolean z11) {
        this.isExternal = z11;
    }

    public void setHasStableParameterNames(boolean z11) {
        this.hasStableParameterNames = z11;
    }

    public void setHasSynthesizedParameterNames(boolean z11) {
        this.hasSynthesizedParameterNames = z11;
    }

    public void setInfix(boolean z11) {
        this.isInfix = z11;
    }

    public void setInline(boolean z11) {
        this.isInline = z11;
    }

    public void setOperator(boolean z11) {
        this.isOperator = z11;
    }

    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            $$$reportNull$$$0(17);
        }
        this.overriddenFunctions = collection;
        Iterator<? extends CallableMemberDescriptor> it = collection.iterator();
        while (it.hasNext()) {
            if (((FunctionDescriptor) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                this.isHiddenForResolutionEverywhereBesideSupercalls = true;
                return;
            }
        }
    }

    public void setReturnType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(11);
        }
        this.unsubstitutedReturnType = kotlinType;
    }

    public void setSuspend(boolean z11) {
        this.isSuspend = z11;
    }

    public void setTailrec(boolean z11) {
        this.isTailrec = z11;
    }

    public void setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(10);
        }
        this.visibility = descriptorVisibility;
    }

    @Nullable
    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor functionDescriptor, @NotNull List<ValueParameterDescriptor> list, @NotNull TypeSubstitutor typeSubstitutor, boolean z11, boolean z12, @Nullable boolean[] zArr) {
        KotlinType kotlinType;
        AnonymousClass2 r17;
        TypeSubstitutor typeSubstitutor2 = typeSubstitutor;
        if (list == null) {
            $$$reportNull$$$0(30);
        }
        if (typeSubstitutor2 == null) {
            $$$reportNull$$$0(31);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ValueParameterDescriptor next : list) {
            KotlinType type = next.getType();
            Variance variance = Variance.IN_VARIANCE;
            KotlinType substitute = typeSubstitutor2.substitute(type, variance);
            KotlinType varargElementType = next.getVarargElementType();
            if (varargElementType == null) {
                kotlinType = null;
            } else {
                kotlinType = typeSubstitutor2.substitute(varargElementType, variance);
            }
            if (substitute == null) {
                return null;
            }
            if (!((substitute == next.getType() && varargElementType == kotlinType) || zArr == null)) {
                zArr[0] = true;
            }
            if (next instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration) {
                final List<VariableDescriptor> destructuringVariables = ((ValueParameterDescriptorImpl.WithDestructuringDeclaration) next).getDestructuringVariables();
                r17 = new Function0<List<VariableDescriptor>>() {
                    public List<VariableDescriptor> invoke() {
                        return destructuringVariables;
                    }
                };
            } else {
                r17 = null;
            }
            arrayList.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(functionDescriptor, z11 ? null : next, next.getIndex(), next.getAnnotations(), next.getName(), substitute, next.declaresDefaultValue(), next.isCrossinline(), next.isNoinline(), kotlinType, z12 ? next.getSource() : SourceElement.NO_SOURCE, r17));
        }
        return arrayList;
    }

    @NotNull
    public FunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality2, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind2, boolean z11) {
        FunctionDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality2).setVisibility(descriptorVisibility).setKind(kind2).setCopyOverrides(z11).build();
        if (build == null) {
            $$$reportNull$$$0(26);
        }
        return build;
    }

    public FunctionDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
        }
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return c(typeSubstitutor).setOriginal((CallableMemberDescriptor) getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
    }

    @NotNull
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.original;
        FunctionDescriptor original2 = functionDescriptor == this ? this : functionDescriptor.getOriginal();
        if (original2 == null) {
            $$$reportNull$$$0(20);
        }
        return original2;
    }
}
