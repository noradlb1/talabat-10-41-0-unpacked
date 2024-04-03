package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

public final class TypeDeserializer$simpleType$annotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeDeserializer f24860g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ProtoBuf.Type f24861h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeDeserializer$simpleType$annotations$1(TypeDeserializer typeDeserializer, ProtoBuf.Type type) {
        super(0);
        this.f24860g = typeDeserializer;
        this.f24861h = type;
    }

    @NotNull
    public final List<AnnotationDescriptor> invoke() {
        return this.f24860g.f24858c.getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(this.f24861h, this.f24860g.f24858c.getNameResolver());
    }
}
