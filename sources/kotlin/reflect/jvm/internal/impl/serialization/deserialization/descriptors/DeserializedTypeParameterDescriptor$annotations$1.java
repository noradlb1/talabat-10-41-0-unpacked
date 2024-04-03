package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;

public final class DeserializedTypeParameterDescriptor$annotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedTypeParameterDescriptor f24916g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedTypeParameterDescriptor$annotations$1(DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        super(0);
        this.f24916g = deserializedTypeParameterDescriptor;
    }

    @NotNull
    public final List<AnnotationDescriptor> invoke() {
        return CollectionsKt___CollectionsKt.toList(this.f24916g.f24915c.getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(this.f24916g.getProto(), this.f24916g.f24915c.getNameResolver()));
    }
}
