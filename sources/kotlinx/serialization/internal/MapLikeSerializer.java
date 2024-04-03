package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0014\b\u0003\u0010\u0005*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006B%\b\u0004\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u001b¢\u0006\u0004\b&\u0010'J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0014\u0010%\u001a\u00020\"8&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\u0001\u0002()¨\u0006*"}, d2 = {"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "builder", "", "startIndex", "size", "", "a", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "index", "", "checkIndex", "b", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/KSerializer;", "keySerializer", "Lkotlinx/serialization/KSerializer;", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "valueSerializer", "getValueSerializer", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "Lkotlinx/serialization/internal/HashMapSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@InternalSerializationApi
public abstract class MapLikeSerializer<Key, Value, Collection, Builder extends Map<Key, Value>> extends AbstractCollectionSerializer<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {
    @NotNull
    private final KSerializer<Key> keySerializer;
    @NotNull
    private final KSerializer<Value> valueSerializer;

    private MapLikeSerializer(KSerializer<Key> kSerializer, KSerializer<Value> kSerializer2) {
        super((DefaultConstructorMarker) null);
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }

    public /* synthetic */ MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    /* renamed from: a */
    public final void readAll(@NotNull CompositeDecoder compositeDecoder, @NotNull Builder builder, int i11, int i12) {
        boolean z11;
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (i12 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, i12 * 2), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    readElement(compositeDecoder, i11 + first, builder, false);
                    if (first != last) {
                        first += step2;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
    }

    /* renamed from: b */
    public final void readElement(@NotNull CompositeDecoder compositeDecoder, int i11, @NotNull Builder builder, boolean z11) {
        int i12;
        Value value;
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object decodeSerializableElement$default = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), i11, this.keySerializer, (Object) null, 8, (Object) null);
        boolean z12 = true;
        if (z11) {
            i12 = compositeDecoder.decodeElementIndex(getDescriptor());
            if (i12 != i11 + 1) {
                z12 = false;
            }
            if (!z12) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i11 + ", returned index for value: " + i12).toString());
            }
        } else {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (!builder.containsKey(decodeSerializableElement$default) || (this.valueSerializer.getDescriptor().getKind() instanceof PrimitiveKind)) {
            value = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), i13, this.valueSerializer, (Object) null, 8, (Object) null);
        } else {
            value = compositeDecoder.decodeSerializableElement(getDescriptor(), i13, this.valueSerializer, MapsKt__MapsKt.getValue(builder, decodeSerializableElement$default));
        }
        builder.put(decodeSerializableElement$default, value);
    }

    @NotNull
    public abstract SerialDescriptor getDescriptor();

    @NotNull
    public final KSerializer<Key> getKeySerializer() {
        return this.keySerializer;
    }

    @NotNull
    public final KSerializer<Value> getValueSerializer() {
        return this.valueSerializer;
    }

    public void serialize(@NotNull Encoder encoder, Collection collection) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int collectionSize = collectionSize(collection);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder beginCollection = encoder.beginCollection(descriptor, collectionSize);
        Iterator collectionIterator = collectionIterator(collection);
        int i11 = 0;
        while (collectionIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) collectionIterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i12 = i11 + 1;
            beginCollection.encodeSerializableElement(getDescriptor(), i11, getKeySerializer(), key);
            beginCollection.encodeSerializableElement(getDescriptor(), i12, getValueSerializer(), value);
            i11 = i12 + 1;
        }
        beginCollection.endStructure(descriptor);
    }
}
