package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\f\u0010\u0006\u001a\u00020\u0004*\u00020\u0002H\u0014J\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0014J \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0004H\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/internal/IntArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/IntArrayBuilder;", "f", "i", "g", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "index", "builder", "", "checkIndex", "", "h", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "size", "j", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public final class IntArraySerializer extends PrimitiveArraySerializer<Integer, int[], IntArrayBuilder> {
    @NotNull
    public static final IntArraySerializer INSTANCE = new IntArraySerializer();

    private IntArraySerializer() {
        super(BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE));
    }

    /* renamed from: f */
    public int collectionSize(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length;
    }

    @NotNull
    /* renamed from: g */
    public int[] empty() {
        return new int[0];
    }

    /* renamed from: h */
    public void readElement(@NotNull CompositeDecoder compositeDecoder, int i11, @NotNull IntArrayBuilder intArrayBuilder, boolean z11) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        Intrinsics.checkNotNullParameter(intArrayBuilder, "builder");
        intArrayBuilder.append$kotlinx_serialization_core(compositeDecoder.decodeIntElement(getDescriptor(), i11));
    }

    @NotNull
    /* renamed from: i */
    public IntArrayBuilder toBuilder(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new IntArrayBuilder(iArr);
    }

    /* renamed from: j */
    public void writeContent(@NotNull CompositeEncoder compositeEncoder, @NotNull int[] iArr, int i11) {
        Intrinsics.checkNotNullParameter(compositeEncoder, "encoder");
        Intrinsics.checkNotNullParameter(iArr, "content");
        for (int i12 = 0; i12 < i11; i12++) {
            compositeEncoder.encodeIntElement(getDescriptor(), i12, iArr[i12]);
        }
    }
}
