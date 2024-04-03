package kotlinx.serialization.internal;

import java.lang.Enum;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/internal/EnumSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "values", "", "(Ljava/lang/String;[Ljava/lang/Enum;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "[Ljava/lang/Enum;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PublishedApi
public final class EnumSerializer<T extends Enum<T>> implements KSerializer<T> {
    @NotNull
    private final SerialDescriptor descriptor;
    /* access modifiers changed from: private */
    @NotNull
    public final T[] values;

    public EnumSerializer(@NotNull String str, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(tArr, "values");
        this.values = tArr;
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor(str, SerialKind.ENUM.INSTANCE, new SerialDescriptor[0], new EnumSerializer$descriptor$1(this, str));
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().getSerialName() + Typography.greater;
    }

    @NotNull
    public T deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        int decodeEnum = decoder.decodeEnum(getDescriptor());
        boolean z11 = false;
        if (decodeEnum >= 0 && decodeEnum < this.values.length) {
            z11 = true;
        }
        if (z11) {
            return this.values[decodeEnum];
        }
        throw new SerializationException(decodeEnum + " is not among valid " + getDescriptor().getSerialName() + " enum values, values size is " + this.values.length);
    }

    public void serialize(@NotNull Encoder encoder, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t11, "value");
        int indexOf = ArraysKt___ArraysKt.indexOf(this.values, t11);
        if (indexOf != -1) {
            encoder.encodeEnum(getDescriptor(), indexOf);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(t11);
        sb2.append(" is not a valid enum ");
        sb2.append(getDescriptor().getSerialName());
        sb2.append(", must be one of ");
        String arrays = Arrays.toString(this.values);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb2.append(arrays);
        throw new SerializationException(sb2.toString());
    }
}
