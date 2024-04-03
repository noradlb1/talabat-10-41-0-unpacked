package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;

public final class MemberDeserializer$valueParameters$1$annotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MemberDeserializer f24852g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ProtoContainer f24853h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MessageLite f24854i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AnnotatedCallableKind f24855j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f24856k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ProtoBuf.ValueParameter f24857l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$valueParameters$1$annotations$1(MemberDeserializer memberDeserializer, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i11, ProtoBuf.ValueParameter valueParameter) {
        super(0);
        this.f24852g = memberDeserializer;
        this.f24853h = protoContainer;
        this.f24854i = messageLite;
        this.f24855j = annotatedCallableKind;
        this.f24856k = i11;
        this.f24857l = valueParameter;
    }

    @NotNull
    public final List<AnnotationDescriptor> invoke() {
        return CollectionsKt___CollectionsKt.toList(this.f24852g.f24830c.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(this.f24853h, this.f24854i, this.f24855j, this.f24856k, this.f24857l));
    }
}
