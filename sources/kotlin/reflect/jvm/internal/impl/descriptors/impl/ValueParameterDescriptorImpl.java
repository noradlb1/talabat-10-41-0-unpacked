package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ValueParameterDescriptorImpl extends VariableDescriptorImpl implements ValueParameterDescriptor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean declaresDefaultValue;
    private final int index;
    private final boolean isCrossinline;
    private final boolean isNoinline;
    @NotNull
    private final ValueParameterDescriptor original;
    @Nullable
    private final KotlinType varargElementType;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ValueParameterDescriptorImpl createWithDestructuringDeclarations(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i11, @NotNull Annotations annotations, @NotNull Name name2, @NotNull KotlinType kotlinType, boolean z11, boolean z12, boolean z13, @Nullable KotlinType kotlinType2, @NotNull SourceElement sourceElement, @Nullable Function0<? extends List<? extends VariableDescriptor>> function0) {
            CallableDescriptor callableDescriptor2 = callableDescriptor;
            Intrinsics.checkNotNullParameter(callableDescriptor, "containingDeclaration");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(kotlinType, "outType");
            Intrinsics.checkNotNullParameter(sourceElement, "source");
            if (function0 == null) {
                return new ValueParameterDescriptorImpl(callableDescriptor, valueParameterDescriptor, i11, annotations, name2, kotlinType, z11, z12, z13, kotlinType2, sourceElement);
            }
            return new WithDestructuringDeclaration(callableDescriptor, valueParameterDescriptor, i11, annotations, name2, kotlinType, z11, z12, z13, kotlinType2, sourceElement, function0);
        }
    }

    public static final class WithDestructuringDeclaration extends ValueParameterDescriptorImpl {
        @NotNull
        private final Lazy destructuringVariables$delegate;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WithDestructuringDeclaration(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i11, @NotNull Annotations annotations, @NotNull Name name2, @NotNull KotlinType kotlinType, boolean z11, boolean z12, boolean z13, @Nullable KotlinType kotlinType2, @NotNull SourceElement sourceElement, @NotNull Function0<? extends List<? extends VariableDescriptor>> function0) {
            super(callableDescriptor, valueParameterDescriptor, i11, annotations, name2, kotlinType, z11, z12, z13, kotlinType2, sourceElement);
            Intrinsics.checkNotNullParameter(callableDescriptor, "containingDeclaration");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(kotlinType, "outType");
            Intrinsics.checkNotNullParameter(sourceElement, "source");
            Intrinsics.checkNotNullParameter(function0, "destructuringVariables");
            this.destructuringVariables$delegate = LazyKt__LazyJVMKt.lazy(function0);
        }

        @NotNull
        public ValueParameterDescriptor copy(@NotNull CallableDescriptor callableDescriptor, @NotNull Name name2, int i11) {
            CallableDescriptor callableDescriptor2 = callableDescriptor;
            Intrinsics.checkNotNullParameter(callableDescriptor2, "newOwner");
            Name name3 = name2;
            Intrinsics.checkNotNullParameter(name3, "newName");
            Annotations annotations = getAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
            KotlinType type = getType();
            Intrinsics.checkNotNullExpressionValue(type, "type");
            boolean declaresDefaultValue = declaresDefaultValue();
            boolean isCrossinline = isCrossinline();
            boolean isNoinline = isNoinline();
            KotlinType varargElementType = getVarargElementType();
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            return new WithDestructuringDeclaration(callableDescriptor2, (ValueParameterDescriptor) null, i11, annotations, name3, type, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, sourceElement, new ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(this));
        }

        @NotNull
        public final List<VariableDescriptor> getDestructuringVariables() {
            return (List) this.destructuringVariables$delegate.getValue();
        }
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor] */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ValueParameterDescriptorImpl(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r8, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r9, int r10, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.Name r12, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.KotlinType r13, boolean r14, boolean r15, boolean r16, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.types.KotlinType r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r18) {
        /*
            r7 = this;
            r6 = r7
            java.lang.String r0 = "containingDeclaration"
            r1 = r8
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "annotations"
            r2 = r11
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "name"
            r3 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "outType"
            r4 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "source"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r10
            r6.index = r0
            r0 = r14
            r6.declaresDefaultValue = r0
            r0 = r15
            r6.isCrossinline = r0
            r0 = r16
            r6.isNoinline = r0
            r0 = r17
            r6.varargElementType = r0
            if (r9 != 0) goto L_0x0039
            r0 = r6
            goto L_0x003a
        L_0x0039:
            r0 = r9
        L_0x003a:
            r6.original = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, int, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.types.KotlinType, boolean, boolean, boolean, kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement):void");
    }

    @JvmStatic
    @NotNull
    public static final ValueParameterDescriptorImpl createWithDestructuringDeclarations(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i11, @NotNull Annotations annotations, @NotNull Name name2, @NotNull KotlinType kotlinType, boolean z11, boolean z12, boolean z13, @Nullable KotlinType kotlinType2, @NotNull SourceElement sourceElement, @Nullable Function0<? extends List<? extends VariableDescriptor>> function0) {
        return Companion.createWithDestructuringDeclarations(callableDescriptor, valueParameterDescriptor, i11, annotations, name2, kotlinType, z11, z12, z13, kotlinType2, sourceElement, function0);
    }

    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d11) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitValueParameterDescriptor(this, d11);
    }

    @NotNull
    public ValueParameterDescriptor copy(@NotNull CallableDescriptor callableDescriptor, @NotNull Name name2, int i11) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(name2, "newName");
        Annotations annotations = getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
        KotlinType type = getType();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        boolean declaresDefaultValue2 = declaresDefaultValue();
        boolean isCrossinline2 = isCrossinline();
        boolean isNoinline2 = isNoinline();
        KotlinType varargElementType2 = getVarargElementType();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return new ValueParameterDescriptorImpl(callableDescriptor, (ValueParameterDescriptor) null, i11, annotations, name2, type, declaresDefaultValue2, isCrossinline2, isNoinline2, varargElementType2, sourceElement);
    }

    public boolean declaresDefaultValue() {
        if (this.declaresDefaultValue) {
            CallableDescriptor containingDeclaration = getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
            if (((CallableMemberDescriptor) containingDeclaration).getKind().isReal()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Void getCompileTimeInitializer() {
        return null;
    }

    public int getIndex() {
        return this.index;
    }

    @NotNull
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        Collection<? extends CallableDescriptor> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "containingDeclaration.overriddenDescriptors");
        Iterable<CallableDescriptor> iterable = overriddenDescriptors;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (CallableDescriptor valueParameters : iterable) {
            arrayList.add(valueParameters.getValueParameters().get(getIndex()));
        }
        return arrayList;
    }

    @Nullable
    public KotlinType getVarargElementType() {
        return this.varargElementType;
    }

    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.LOCAL;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "LOCAL");
        return descriptorVisibility;
    }

    public boolean isCrossinline() {
        return this.isCrossinline;
    }

    public boolean isLateInit() {
        return ValueParameterDescriptor.DefaultImpls.isLateInit(this);
    }

    public boolean isNoinline() {
        return this.isNoinline;
    }

    public boolean isVar() {
        return false;
    }

    @NotNull
    public CallableDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = super.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (CallableDescriptor) containingDeclaration;
    }

    @NotNull
    public ValueParameterDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @NotNull
    public ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor valueParameterDescriptor = this.original;
        return valueParameterDescriptor == this ? this : valueParameterDescriptor.getOriginal();
    }
}
