package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

public final class MemberDeserializer$getPropertyFieldAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MemberDeserializer f24834g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f24835h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ProtoBuf.Property f24836i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$getPropertyFieldAnnotations$1(MemberDeserializer memberDeserializer, boolean z11, ProtoBuf.Property property) {
        super(0);
        this.f24834g = memberDeserializer;
        this.f24835h = z11;
        this.f24836i = property;
    }

    @NotNull
    public final List<AnnotationDescriptor> invoke() {
        List<AnnotationDescriptor> list;
        MemberDeserializer memberDeserializer = this.f24834g;
        ProtoContainer access$asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f24830c.getContainingDeclaration());
        if (access$asProtoContainer != null) {
            boolean z11 = this.f24835h;
            MemberDeserializer memberDeserializer2 = this.f24834g;
            ProtoBuf.Property property = this.f24836i;
            list = z11 ? CollectionsKt___CollectionsKt.toList(memberDeserializer2.f24830c.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(access$asProtoContainer, property)) : CollectionsKt___CollectionsKt.toList(memberDeserializer2.f24830c.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(access$asProtoContainer, property));
        } else {
            list = null;
        }
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }
}
