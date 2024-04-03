package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;

public final class MemberDeserializer$getAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MemberDeserializer f24831g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MessageLite f24832h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AnnotatedCallableKind f24833i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$getAnnotations$1(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        super(0);
        this.f24831g = memberDeserializer;
        this.f24832h = messageLite;
        this.f24833i = annotatedCallableKind;
    }

    @NotNull
    public final List<AnnotationDescriptor> invoke() {
        List<AnnotationDescriptor> list;
        MemberDeserializer memberDeserializer = this.f24831g;
        ProtoContainer access$asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f24830c.getContainingDeclaration());
        if (access$asProtoContainer != null) {
            list = CollectionsKt___CollectionsKt.toList(this.f24831g.f24830c.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(access$asProtoContainer, this.f24832h, this.f24833i));
        } else {
            list = null;
        }
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }
}
