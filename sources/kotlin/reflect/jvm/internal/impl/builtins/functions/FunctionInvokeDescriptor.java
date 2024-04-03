package kotlin.reflect.jvm.internal.impl.builtins.functions;

import androidx.exifinterface.media.ExifInterface;
import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    @NotNull
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor functionInvokeDescriptor, int i11, TypeParameterDescriptor typeParameterDescriptor) {
            String str;
            String asString = typeParameterDescriptor.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "typeParameter.name.asString()");
            if (Intrinsics.areEqual((Object) asString, (Object) "T")) {
                str = "instance";
            } else if (Intrinsics.areEqual((Object) asString, (Object) ExifInterface.LONGITUDE_EAST)) {
                str = "receiver";
            } else {
                str = asString.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            Annotations empty = Annotations.Companion.getEMPTY();
            Name identifier = Name.identifier(str);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
            SimpleType defaultType = typeParameterDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(functionInvokeDescriptor, (ValueParameterDescriptor) null, i11, empty, identifier, defaultType, false, false, false, (KotlinType) null, sourceElement);
        }

        @NotNull
        public final FunctionInvokeDescriptor create(@NotNull FunctionClassDescriptor functionClassDescriptor, boolean z11) {
            boolean z12;
            Intrinsics.checkNotNullParameter(functionClassDescriptor, "functionClass");
            List<TypeParameterDescriptor> declaredTypeParameters = functionClassDescriptor.getDeclaredTypeParameters();
            FunctionInvokeDescriptor functionInvokeDescriptor = new FunctionInvokeDescriptor(functionClassDescriptor, (FunctionInvokeDescriptor) null, CallableMemberDescriptor.Kind.DECLARATION, z11, (DefaultConstructorMarker) null);
            ReceiverParameterDescriptor thisAsReceiverParameter = functionClassDescriptor.getThisAsReceiverParameter();
            List emptyList = CollectionsKt__CollectionsKt.emptyList();
            List emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            ArrayList arrayList = new ArrayList();
            for (Object next : declaredTypeParameters) {
                if (((TypeParameterDescriptor) next).getVariance() == Variance.IN_VARIANCE) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    break;
                }
                arrayList.add(next);
            }
            Iterable<IndexedValue> withIndex = CollectionsKt___CollectionsKt.withIndex(arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10));
            for (IndexedValue indexedValue : withIndex) {
                arrayList2.add(FunctionInvokeDescriptor.Factory.createValueParameter(functionInvokeDescriptor, indexedValue.getIndex(), (TypeParameterDescriptor) indexedValue.getValue()));
            }
            functionInvokeDescriptor.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, emptyList, emptyList2, (List) arrayList2, (KotlinType) ((TypeParameterDescriptor) CollectionsKt___CollectionsKt.last(declaredTypeParameters)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            functionInvokeDescriptor.setHasSynthesizedParameterNames(true);
            return functionInvokeDescriptor;
        }
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z11) {
        super(declarationDescriptor, functionInvokeDescriptor, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, kind, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(z11);
        setHasStableParameterNames(false);
    }

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, functionInvokeDescriptor, kind, z11);
    }

    private final FunctionDescriptor replaceParameterNames(List<Name> list) {
        boolean z11;
        Name name2;
        boolean z12;
        int size = getValueParameters().size() - list.size();
        boolean z13 = true;
        if (size == 0) {
            List<ValueParameterDescriptor> valueParameters = getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "valueParameters");
            Iterable zip = CollectionsKt___CollectionsKt.zip(list, valueParameters);
            if (!(zip instanceof Collection) || !((Collection) zip).isEmpty()) {
                Iterator it = zip.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (!Intrinsics.areEqual((Object) (Name) pair.component1(), (Object) ((ValueParameterDescriptor) pair.component2()).getName())) {
                        z12 = false;
                        break;
                    }
                }
            }
            z12 = true;
            if (z12) {
                return this;
            }
        }
        List<ValueParameterDescriptor> valueParameters2 = getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "valueParameters");
        Iterable<ValueParameterDescriptor> iterable = valueParameters2;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ValueParameterDescriptor valueParameterDescriptor : iterable) {
            Name name3 = valueParameterDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "it.name");
            int index = valueParameterDescriptor.getIndex();
            int i11 = index - size;
            if (i11 >= 0 && (name2 = list.get(i11)) != null) {
                name3 = name2;
            }
            arrayList.add(valueParameterDescriptor.copy(this, name3, index));
        }
        FunctionDescriptorImpl.CopyConfiguration c11 = c(TypeSubstitutor.EMPTY);
        Iterable iterable2 = list;
        if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
            Iterator it2 = iterable2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (((Name) it2.next()) == null) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
        }
        z13 = false;
        FunctionDescriptorImpl.CopyConfiguration original = c11.setHasSynthesizedParameterNames(z13).setValueParameters((List) arrayList).setOriginal((CallableMemberDescriptor) getOriginal());
        Intrinsics.checkNotNullExpressionValue(original, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        FunctionDescriptor b11 = super.b(original);
        Intrinsics.checkNotNull(b11);
        return b11;
    }

    @Nullable
    public FunctionDescriptor b(@NotNull FunctionDescriptorImpl.CopyConfiguration copyConfiguration) {
        boolean z11;
        Intrinsics.checkNotNullParameter(copyConfiguration, "configuration");
        FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor) super.b(copyConfiguration);
        if (functionInvokeDescriptor == null) {
            return null;
        }
        List<ValueParameterDescriptor> valueParameters = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "substituted.valueParameters");
        Iterable iterable = valueParameters;
        boolean z12 = true;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                KotlinType type = ((ValueParameterDescriptor) it.next()).getType();
                Intrinsics.checkNotNullExpressionValue(type, "it.type");
                if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    z12 = false;
                    break;
                }
            }
        }
        if (z12) {
            return functionInvokeDescriptor;
        }
        List<ValueParameterDescriptor> valueParameters2 = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "substituted.valueParameters");
        Iterable<ValueParameterDescriptor> iterable2 = valueParameters2;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (ValueParameterDescriptor type2 : iterable2) {
            KotlinType type3 = type2.getType();
            Intrinsics.checkNotNullExpressionValue(type3, "it.type");
            arrayList.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type3));
        }
        return functionInvokeDescriptor.replaceParameterNames(arrayList);
    }

    @NotNull
    public FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name2, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        return new FunctionInvokeDescriptor(declarationDescriptor, (FunctionInvokeDescriptor) functionDescriptor, kind, isSuspend());
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isTailrec() {
        return false;
    }
}
