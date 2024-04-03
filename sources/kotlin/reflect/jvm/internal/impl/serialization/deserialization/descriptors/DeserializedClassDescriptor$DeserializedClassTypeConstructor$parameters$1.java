package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1 extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor f24872g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.f24872g = deserializedClassDescriptor;
    }

    @NotNull
    public final List<TypeParameterDescriptor> invoke() {
        return TypeParameterUtilsKt.computeConstructorTypeParameters(this.f24872g);
    }
}
