package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.Nullable;

public final class DeserializedClassDescriptor$valueClassRepresentation$1 extends Lambda implements Function0<ValueClassRepresentation<SimpleType>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor f24884g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$valueClassRepresentation$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.f24884g = deserializedClassDescriptor;
    }

    @Nullable
    public final ValueClassRepresentation<SimpleType> invoke() {
        return this.f24884g.computeValueClassRepresentation();
    }
}
