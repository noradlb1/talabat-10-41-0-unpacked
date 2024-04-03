package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005B\u0017\b\u0000\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,¢\u0006\u0004\b.\u0010/J\u0013\u0010\u0007\u001a\u00020\u0006*\u00028\u0002H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00028\u0001*\u00028\u0002H\u0004¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f*\u00028\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f*\u00028\u0001H\u0004¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u00020\f*\u00028\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00028\u0002H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00028\u0001H$¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\u0006H$¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001f2\u0006\u0010 \u001a\u00028\u0001¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00028\u00012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&R\u0017\u0010(\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u00060"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Element", "Array", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Builder", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "", "b", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)I", "e", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)Ljava/lang/Object;", "size", "", "c", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;I)V", "", "collectionIterator", "(Ljava/lang/Object;)Ljava/util/Iterator;", "index", "element", "d", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;ILjava/lang/Object;)V", "a", "()Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "empty", "()Ljava/lang/Object;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "writeContent", "(Lkotlinx/serialization/encoding/CompositeEncoder;Ljava/lang/Object;I)V", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/KSerializer;", "primitiveSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public abstract class PrimitiveArraySerializer<Element, Array, Builder extends PrimitiveArrayBuilder<Array>> extends CollectionLikeSerializer<Element, Array, Builder> {
    @NotNull
    private final SerialDescriptor descriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrimitiveArraySerializer(@NotNull KSerializer<Element> kSerializer) {
        super(kSerializer, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(kSerializer, "primitiveSerializer");
        this.descriptor = new PrimitiveArrayDescriptor(kSerializer.getDescriptor());
    }

    @NotNull
    /* renamed from: a */
    public final Builder builder() {
        return (PrimitiveArrayBuilder) toBuilder(empty());
    }

    /* renamed from: b */
    public final int builderSize(@NotNull Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.getPosition$kotlinx_serialization_core();
    }

    /* renamed from: c */
    public final void checkCapacity(@NotNull Builder builder, int i11) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.ensureCapacity$kotlinx_serialization_core(i11);
    }

    @NotNull
    public final Iterator<Element> collectionIterator(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    /* renamed from: d */
    public final void insert(@NotNull Builder builder, int i11, Element element) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    public final Array deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return merge(decoder, null);
    }

    /* renamed from: e */
    public final Array toResult(@NotNull Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.build$kotlinx_serialization_core();
    }

    public abstract Array empty();

    @NotNull
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final void serialize(@NotNull Encoder encoder, Array array) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int collectionSize = collectionSize(array);
        SerialDescriptor serialDescriptor = this.descriptor;
        CompositeEncoder beginCollection = encoder.beginCollection(serialDescriptor, collectionSize);
        writeContent(beginCollection, array, collectionSize);
        beginCollection.endStructure(serialDescriptor);
    }

    public abstract void writeContent(@NotNull CompositeEncoder compositeEncoder, Array array, int i11);
}
