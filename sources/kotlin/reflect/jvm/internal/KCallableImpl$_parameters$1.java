package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KCallableImpl$_parameters$1 extends Lambda implements Function0<ArrayList<KParameter>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KCallableImpl<R> f24357g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KCallableImpl$_parameters$1(KCallableImpl<? extends R> kCallableImpl) {
        super(0);
        this.f24357g = kCallableImpl;
    }

    public final ArrayList<KParameter> invoke() {
        int i11;
        final CallableMemberDescriptor descriptor = this.f24357g.getDescriptor();
        ArrayList<KParameter> arrayList = new ArrayList<>();
        final int i12 = 0;
        if (!this.f24357g.isBound()) {
            final ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(descriptor);
            if (instanceReceiverParameter != null) {
                arrayList.add(new KParameterImpl(this.f24357g, 0, KParameter.Kind.INSTANCE, new Function0<ParameterDescriptor>() {
                    @NotNull
                    public final ParameterDescriptor invoke() {
                        return instanceReceiverParameter;
                    }
                }));
                i11 = 1;
            } else {
                i11 = 0;
            }
            final ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                arrayList.add(new KParameterImpl(this.f24357g, i11, KParameter.Kind.EXTENSION_RECEIVER, new Function0<ParameterDescriptor>() {
                    @NotNull
                    public final ParameterDescriptor invoke() {
                        return extensionReceiverParameter;
                    }
                }));
                i11++;
            }
        } else {
            i11 = 0;
        }
        int size = descriptor.getValueParameters().size();
        while (i12 < size) {
            arrayList.add(new KParameterImpl(this.f24357g, i11, KParameter.Kind.VALUE, new Function0<ParameterDescriptor>() {
                @NotNull
                public final ParameterDescriptor invoke() {
                    ValueParameterDescriptor valueParameterDescriptor = descriptor.getValueParameters().get(i12);
                    Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "descriptor.valueParameters[i]");
                    return valueParameterDescriptor;
                }
            }));
            i12++;
            i11++;
        }
        if (this.f24357g.a() && (descriptor instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new KCallableImpl$_parameters$1$invoke$$inlined$sortBy$1());
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
