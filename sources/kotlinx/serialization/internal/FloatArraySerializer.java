package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0014J\f\u0010\b\u001a\u00020\u0005*\u00020\u0002H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0014¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/internal/FloatArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/FloatArrayBuilder;", "", "f", "i", "g", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "index", "builder", "", "checkIndex", "", "h", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "size", "j", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public final class FloatArraySerializer extends PrimitiveArraySerializer<Float, float[], FloatArrayBuilder> {
    @NotNull
    public static final FloatArraySerializer INSTANCE = new FloatArraySerializer();

    private FloatArraySerializer() {
        super(BuiltinSerializersKt.serializer(FloatCompanionObject.INSTANCE));
    }

    /* renamed from: f */
    public int collectionSize(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length;
    }

    @NotNull
    /* renamed from: g */
    public float[] empty() {
        return new float[0];
    }

    /* renamed from: h */
    public void readElement(@NotNull CompositeDecoder compositeDecoder, int i11, @NotNull FloatArrayBuilder floatArrayBuilder, boolean z11) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        Intrinsics.checkNotNullParameter(floatArrayBuilder, "builder");
        floatArrayBuilder.append$kotlinx_serialization_core(compositeDecoder.decodeFloatElement(getDescriptor(), i11));
    }

    @NotNull
    /* renamed from: i */
    public FloatArrayBuilder toBuilder(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new FloatArrayBuilder(fArr);
    }

    /* renamed from: j */
    public void writeContent(@NotNull CompositeEncoder compositeEncoder, @NotNull float[] fArr, int i11) {
        Intrinsics.checkNotNullParameter(compositeEncoder, "encoder");
        Intrinsics.checkNotNullParameter(fArr, "content");
        for (int i12 = 0; i12 < i11; i12++) {
            compositeEncoder.encodeFloatElement(getDescriptor(), i12, fArr[i12]);
        }
    }
}
