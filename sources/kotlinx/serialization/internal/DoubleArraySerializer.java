package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0014J\f\u0010\b\u001a\u00020\u0005*\u00020\u0002H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0014¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/internal/DoubleArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/DoubleArrayBuilder;", "", "f", "i", "g", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "index", "builder", "", "checkIndex", "", "h", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "size", "j", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public final class DoubleArraySerializer extends PrimitiveArraySerializer<Double, double[], DoubleArrayBuilder> {
    @NotNull
    public static final DoubleArraySerializer INSTANCE = new DoubleArraySerializer();

    private DoubleArraySerializer() {
        super(BuiltinSerializersKt.serializer(DoubleCompanionObject.INSTANCE));
    }

    /* renamed from: f */
    public int collectionSize(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length;
    }

    @NotNull
    /* renamed from: g */
    public double[] empty() {
        return new double[0];
    }

    /* renamed from: h */
    public void readElement(@NotNull CompositeDecoder compositeDecoder, int i11, @NotNull DoubleArrayBuilder doubleArrayBuilder, boolean z11) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        Intrinsics.checkNotNullParameter(doubleArrayBuilder, "builder");
        doubleArrayBuilder.append$kotlinx_serialization_core(compositeDecoder.decodeDoubleElement(getDescriptor(), i11));
    }

    @NotNull
    /* renamed from: i */
    public DoubleArrayBuilder toBuilder(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new DoubleArrayBuilder(dArr);
    }

    /* renamed from: j */
    public void writeContent(@NotNull CompositeEncoder compositeEncoder, @NotNull double[] dArr, int i11) {
        Intrinsics.checkNotNullParameter(compositeEncoder, "encoder");
        Intrinsics.checkNotNullParameter(dArr, "content");
        for (int i12 = 0; i12 < i11; i12++) {
            compositeEncoder.encodeDoubleElement(getDescriptor(), i12, dArr[i12]);
        }
    }
}
