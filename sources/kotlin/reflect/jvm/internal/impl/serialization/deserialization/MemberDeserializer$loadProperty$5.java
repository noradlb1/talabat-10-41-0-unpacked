package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.Nullable;

public final class MemberDeserializer$loadProperty$5 extends Lambda implements Function0<NullableLazyValue<? extends ConstantValue<?>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MemberDeserializer f24846g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ProtoBuf.Property f24847h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DeserializedPropertyDescriptor f24848i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$loadProperty$5(MemberDeserializer memberDeserializer, ProtoBuf.Property property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        super(0);
        this.f24846g = memberDeserializer;
        this.f24847h = property;
        this.f24848i = deserializedPropertyDescriptor;
    }

    public final NullableLazyValue<ConstantValue<?>> invoke() {
        StorageManager storageManager = this.f24846g.f24830c.getStorageManager();
        final MemberDeserializer memberDeserializer = this.f24846g;
        final ProtoBuf.Property property = this.f24847h;
        final DeserializedPropertyDescriptor deserializedPropertyDescriptor = this.f24848i;
        return storageManager.createNullableLazyValue(new Function0<ConstantValue<?>>() {
            @Nullable
            public final ConstantValue<?> invoke() {
                MemberDeserializer memberDeserializer = memberDeserializer;
                ProtoContainer access$asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f24830c.getContainingDeclaration());
                Intrinsics.checkNotNull(access$asProtoContainer);
                AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = memberDeserializer.f24830c.getComponents().getAnnotationAndConstantLoader();
                ProtoBuf.Property property = property;
                KotlinType returnType = deserializedPropertyDescriptor.getReturnType();
                Intrinsics.checkNotNullExpressionValue(returnType, "property.returnType");
                return annotationAndConstantLoader.loadAnnotationDefaultValue(access$asProtoContainer, property, returnType);
            }
        });
    }
}
