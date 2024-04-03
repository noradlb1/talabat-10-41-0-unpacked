package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B%\b\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00028\u00022\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H$¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00028\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0004X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0005\u001a\u00028\u0000*\u00028\u00028$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0006\u001a\u00028\u0001*\u00028\u00028$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019\u0001\u0002\u001d\u001e¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "key", "value", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "keySerializer", "Lkotlinx/serialization/KSerializer;", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "valueSerializer", "getValueSerializer", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public abstract class KeyValueSerializer<K, V, R> implements KSerializer<R> {
    @NotNull
    private final KSerializer<K> keySerializer;
    @NotNull
    private final KSerializer<V> valueSerializer;

    private KeyValueSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }

    public /* synthetic */ KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    public R deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        CompositeDecoder beginStructure = decoder.beginStructure(getDescriptor());
        if (beginStructure.decodeSequentially()) {
            CompositeDecoder compositeDecoder = beginStructure;
            return toResult(CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), 0, this.keySerializer, (Object) null, 8, (Object) null), CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), 1, this.valueSerializer, (Object) null, 8, (Object) null));
        }
        Object access$getNULL$p = TuplesKt.NULL;
        Object access$getNULL$p2 = TuplesKt.NULL;
        while (true) {
            int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
            if (decodeElementIndex == -1) {
                beginStructure.endStructure(getDescriptor());
                if (access$getNULL$p == TuplesKt.NULL) {
                    throw new SerializationException("Element 'key' is missing");
                } else if (access$getNULL$p2 != TuplesKt.NULL) {
                    return toResult(access$getNULL$p, access$getNULL$p2);
                } else {
                    throw new SerializationException("Element 'value' is missing");
                }
            } else if (decodeElementIndex == 0) {
                access$getNULL$p = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(beginStructure, getDescriptor(), 0, this.keySerializer, (Object) null, 8, (Object) null);
            } else if (decodeElementIndex == 1) {
                access$getNULL$p2 = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(beginStructure, getDescriptor(), 1, this.valueSerializer, (Object) null, 8, (Object) null);
            } else {
                throw new SerializationException("Invalid index: " + decodeElementIndex);
            }
        }
    }

    public abstract K getKey(R r11);

    public abstract V getValue(R r11);

    public void serialize(@NotNull Encoder encoder, R r11) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        CompositeEncoder beginStructure = encoder.beginStructure(getDescriptor());
        beginStructure.encodeSerializableElement(getDescriptor(), 0, this.keySerializer, getKey(r11));
        beginStructure.encodeSerializableElement(getDescriptor(), 1, this.valueSerializer, getValue(r11));
        beginStructure.endStructure(getDescriptor());
    }

    public abstract R toResult(K k11, V v11);
}
