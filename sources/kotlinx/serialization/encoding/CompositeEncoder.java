package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH&J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H&J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H&J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0015H&J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u001aH&J?\u0010\u001b\u001a\u00020\u0007\"\b\b\u0000\u0010\u001c*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e2\b\u0010\f\u001a\u0004\u0018\u0001H\u001cH'¢\u0006\u0002\u0010\u001fJ9\u0010 \u001a\u00020\u0007\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e2\u0006\u0010\f\u001a\u0002H\u001cH&¢\u0006\u0002\u0010\u001fJ \u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\"H&J \u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020$H&J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010&\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006'"}, d2 = {"Lkotlinx/serialization/encoding/CompositeEncoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeBooleanElement", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "value", "", "encodeByteElement", "", "encodeCharElement", "", "encodeDoubleElement", "", "encodeFloatElement", "", "encodeInlineElement", "Lkotlinx/serialization/encoding/Encoder;", "encodeIntElement", "encodeLongElement", "", "encodeNullableSerializableElement", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShortElement", "", "encodeStringElement", "", "endStructure", "shouldEncodeElementDefault", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CompositeEncoder {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        public static boolean shouldEncodeElementDefault(@NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor, int i11) {
            Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
            return true;
        }
    }

    void encodeBooleanElement(@NotNull SerialDescriptor serialDescriptor, int i11, boolean z11);

    void encodeByteElement(@NotNull SerialDescriptor serialDescriptor, int i11, byte b11);

    void encodeCharElement(@NotNull SerialDescriptor serialDescriptor, int i11, char c11);

    void encodeDoubleElement(@NotNull SerialDescriptor serialDescriptor, int i11, double d11);

    void encodeFloatElement(@NotNull SerialDescriptor serialDescriptor, int i11, float f11);

    @ExperimentalSerializationApi
    @NotNull
    Encoder encodeInlineElement(@NotNull SerialDescriptor serialDescriptor, int i11);

    void encodeIntElement(@NotNull SerialDescriptor serialDescriptor, int i11, int i12);

    void encodeLongElement(@NotNull SerialDescriptor serialDescriptor, int i11, long j11);

    @ExperimentalSerializationApi
    <T> void encodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull SerializationStrategy<? super T> serializationStrategy, @Nullable T t11);

    <T> void encodeSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull SerializationStrategy<? super T> serializationStrategy, T t11);

    void encodeShortElement(@NotNull SerialDescriptor serialDescriptor, int i11, short s11);

    void encodeStringElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull String str);

    void endStructure(@NotNull SerialDescriptor serialDescriptor);

    @NotNull
    SerializersModule getSerializersModule();

    @ExperimentalSerializationApi
    boolean shouldEncodeElementDefault(@NotNull SerialDescriptor serialDescriptor, int i11);
}
