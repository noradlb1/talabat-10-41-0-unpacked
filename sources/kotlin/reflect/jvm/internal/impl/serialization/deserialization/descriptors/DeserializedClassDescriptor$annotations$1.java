package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$annotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor f24879g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$annotations$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.f24879g = deserializedClassDescriptor;
    }

    @NotNull
    public final List<AnnotationDescriptor> invoke() {
        return CollectionsKt___CollectionsKt.toList(this.f24879g.getC().getComponents().getAnnotationAndConstantLoader().loadClassAnnotations(this.f24879g.getThisAsProtoContainer$deserialization()));
    }
}
