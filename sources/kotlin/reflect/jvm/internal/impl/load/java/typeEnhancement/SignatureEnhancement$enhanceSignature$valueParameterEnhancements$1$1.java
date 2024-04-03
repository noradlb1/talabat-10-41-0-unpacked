package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1 extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ValueParameterDescriptor f24703g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1(ValueParameterDescriptor valueParameterDescriptor) {
        super(1);
        this.f24703g = valueParameterDescriptor;
    }

    @NotNull
    public final KotlinType invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "it");
        KotlinType type = callableMemberDescriptor.getValueParameters().get(this.f24703g.getIndex()).getType();
        Intrinsics.checkNotNullExpressionValue(type, "it.valueParameters[p.index].type");
        return type;
    }
}
