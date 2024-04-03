package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.NoOpEncoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0015H\u0016J\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0015J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u001bJ\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0016\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0016J\u001e\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rJ\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020#H\u0016J\u001e\u0010$\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020#J\b\u0010%\u001a\u00020\bH\u0016J?\u0010&\u001a\u00020\b\"\b\b\u0000\u0010'*\u00020(2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H'0*2\b\u0010\t\u001a\u0004\u0018\u0001H'H\u0016¢\u0006\u0002\u0010+J9\u0010,\u001a\u00020\b\"\u0004\b\u0000\u0010'2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H'0*2\u0006\u0010\t\u001a\u0002H'H\u0016¢\u0006\u0002\u0010+J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020.H\u0016J\u001e\u0010/\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020.J\u0010\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u000201H\u0016J\u001e\u00102\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u000201J\u0010\u00103\u001a\u00020\b2\u0006\u0010\t\u001a\u00020(H\u0016J\u0010\u00104\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u00065"}, d2 = {"Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "()V", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "encodeBoolean", "", "value", "", "encodeBooleanElement", "index", "", "encodeByte", "", "encodeByteElement", "encodeChar", "", "encodeCharElement", "encodeDouble", "", "encodeDoubleElement", "encodeElement", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeFloatElement", "encodeInline", "inlineDescriptor", "encodeInlineElement", "encodeInt", "encodeIntElement", "encodeLong", "", "encodeLongElement", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShort", "", "encodeShortElement", "encodeString", "", "encodeStringElement", "encodeValue", "endStructure", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalSerializationApi
public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    @NotNull
    public CompositeEncoder beginCollection(@NotNull SerialDescriptor serialDescriptor, int i11) {
        return Encoder.DefaultImpls.beginCollection(this, serialDescriptor, i11);
    }

    @NotNull
    public CompositeEncoder beginStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this;
    }

    public void encodeBoolean(boolean z11) {
        encodeValue(Boolean.valueOf(z11));
    }

    public final void encodeBooleanElement(@NotNull SerialDescriptor serialDescriptor, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (encodeElement(serialDescriptor, i11)) {
            encodeBoolean(z11);
        }
    }

    public void encodeByte(byte b11) {
        encodeValue(Byte.valueOf(b11));
    }

    public final void encodeByteElement(@NotNull SerialDescriptor serialDescriptor, int i11, byte b11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (encodeElement(serialDescriptor, i11)) {
            encodeByte(b11);
        }
    }

    public void encodeChar(char c11) {
        encodeValue(Character.valueOf(c11));
    }

    public final void encodeCharElement(@NotNull SerialDescriptor serialDescriptor, int i11, char c11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (encodeElement(serialDescriptor, i11)) {
            encodeChar(c11);
        }
    }

    public void encodeDouble(double d11) {
        encodeValue(Double.valueOf(d11));
    }

    public final void encodeDoubleElement(@NotNull SerialDescriptor serialDescriptor, int i11, double d11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (encodeElement(serialDescriptor, i11)) {
            encodeDouble(d11);
        }
    }

    public boolean encodeElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return true;
    }

    public void encodeEnum(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        encodeValue(Integer.valueOf(i11));
    }

    public void encodeFloat(float f11) {
        encodeValue(Float.valueOf(f11));
    }

    public final void encodeFloatElement(@NotNull SerialDescriptor serialDescriptor, int i11, float f11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (encodeElement(serialDescriptor, i11)) {
            encodeFloat(f11);
        }
    }

    @NotNull
    public Encoder encodeInline(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        return this;
    }

    @NotNull
    public final Encoder encodeInlineElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (encodeElement(serialDescriptor, i11)) {
            return encodeInline(serialDescriptor.getElementDescriptor(i11));
        }
        return NoOpEncoder.INSTANCE;
    }

    public void encodeInt(int i11) {
        encodeValue(Integer.valueOf(i11));
    }

    public final void encodeIntElement(@NotNull SerialDescriptor serialDescriptor, int i11, int i12) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (encodeElement(serialDescriptor, i11)) {
            encodeInt(i12);
        }
    }

    public void encodeLong(long j11) {
        encodeValue(Long.valueOf(j11));
    }

    public final void encodeLongElement(@NotNull SerialDescriptor serialDescriptor, int i11, long j11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (encodeElement(serialDescriptor, i11)) {
            encodeLong(j11);
        }
    }

    @ExperimentalSerializationApi
    public void encodeNotNullMark() {
        Encoder.DefaultImpls.encodeNotNullMark(this);
    }

    public void encodeNull() {
        throw new SerializationException("'null' is not supported by default");
    }

    public <T> void encodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull SerializationStrategy<? super T> serializationStrategy, @Nullable T t11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (encodeElement(serialDescriptor, i11)) {
            encodeNullableSerializableValue(serializationStrategy, t11);
        }
    }

    @ExperimentalSerializationApi
    public <T> void encodeNullableSerializableValue(@NotNull SerializationStrategy<? super T> serializationStrategy, @Nullable T t11) {
        Encoder.DefaultImpls.encodeNullableSerializableValue(this, serializationStrategy, t11);
    }

    public <T> void encodeSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull SerializationStrategy<? super T> serializationStrategy, T t11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (encodeElement(serialDescriptor, i11)) {
            encodeSerializableValue(serializationStrategy, t11);
        }
    }

    public <T> void encodeSerializableValue(@NotNull SerializationStrategy<? super T> serializationStrategy, T t11) {
        Encoder.DefaultImpls.encodeSerializableValue(this, serializationStrategy, t11);
    }

    public void encodeShort(short s11) {
        encodeValue(Short.valueOf(s11));
    }

    public final void encodeShortElement(@NotNull SerialDescriptor serialDescriptor, int i11, short s11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (encodeElement(serialDescriptor, i11)) {
            encodeShort(s11);
        }
    }

    public void encodeString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        encodeValue(str);
    }

    public final void encodeStringElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(str, "value");
        if (encodeElement(serialDescriptor, i11)) {
            encodeString(str);
        }
    }

    public void encodeValue(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(obj.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    public void endStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    @ExperimentalSerializationApi
    public boolean shouldEncodeElementDefault(@NotNull SerialDescriptor serialDescriptor, int i11) {
        return CompositeEncoder.DefaultImpls.shouldEncodeElementDefault(this, serialDescriptor, i11);
    }
}
