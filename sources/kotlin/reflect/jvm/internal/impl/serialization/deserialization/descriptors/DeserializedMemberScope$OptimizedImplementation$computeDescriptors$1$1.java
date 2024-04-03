package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import org.jetbrains.annotations.Nullable;

public final class DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Parser f24903g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ByteArrayInputStream f24904h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope f24905i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(Parser parser, ByteArrayInputStream byteArrayInputStream, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.f24903g = parser;
        this.f24904h = byteArrayInputStream;
        this.f24905i = deserializedMemberScope;
    }

    @Nullable
    public final MessageLite invoke() {
        return (MessageLite) this.f24903g.parseDelimitedFrom(this.f24904h, this.f24905i.f().getComponents().getExtensionRegistryLite());
    }
}
