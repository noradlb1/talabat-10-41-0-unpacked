package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "encodeJsonElement", "", "element", "Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface JsonEncoder extends Encoder, CompositeEncoder {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static CompositeEncoder beginCollection(@NotNull JsonEncoder jsonEncoder, @NotNull SerialDescriptor serialDescriptor, int i11) {
            Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
            return Encoder.DefaultImpls.beginCollection(jsonEncoder, serialDescriptor, i11);
        }

        @ExperimentalSerializationApi
        public static void encodeNotNullMark(@NotNull JsonEncoder jsonEncoder) {
            Encoder.DefaultImpls.encodeNotNullMark(jsonEncoder);
        }

        @ExperimentalSerializationApi
        public static <T> void encodeNullableSerializableValue(@NotNull JsonEncoder jsonEncoder, @NotNull SerializationStrategy<? super T> serializationStrategy, @Nullable T t11) {
            Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
            Encoder.DefaultImpls.encodeNullableSerializableValue(jsonEncoder, serializationStrategy, t11);
        }

        public static <T> void encodeSerializableValue(@NotNull JsonEncoder jsonEncoder, @NotNull SerializationStrategy<? super T> serializationStrategy, T t11) {
            Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
            Encoder.DefaultImpls.encodeSerializableValue(jsonEncoder, serializationStrategy, t11);
        }

        @ExperimentalSerializationApi
        public static boolean shouldEncodeElementDefault(@NotNull JsonEncoder jsonEncoder, @NotNull SerialDescriptor serialDescriptor, int i11) {
            Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
            return CompositeEncoder.DefaultImpls.shouldEncodeElementDefault(jsonEncoder, serialDescriptor, i11);
        }
    }

    void encodeJsonElement(@NotNull JsonElement jsonElement);

    @NotNull
    Json getJson();
}
