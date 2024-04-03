package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor f24876g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ProtoBuf.EnumEntry f24877h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf.EnumEntry enumEntry) {
        super(0);
        this.f24876g = deserializedClassDescriptor;
        this.f24877h = enumEntry;
    }

    @NotNull
    public final List<AnnotationDescriptor> invoke() {
        return CollectionsKt___CollectionsKt.toList(this.f24876g.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(this.f24876g.getThisAsProtoContainer$deserialization(), this.f24877h));
    }
}
