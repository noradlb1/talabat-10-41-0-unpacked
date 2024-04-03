package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0016¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0014"}, d2 = {"kotlinx/serialization/internal/InlineClassDescriptorKt$InlinePrimitiveDescriptor$1", "Lkotlinx/serialization/internal/GeneratedSerializer;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InlineClassDescriptorKt$InlinePrimitiveDescriptor$1 implements GeneratedSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KSerializer<T> f26416a;

    public InlineClassDescriptorKt$InlinePrimitiveDescriptor$1(KSerializer<T> kSerializer) {
        this.f26416a = kSerializer;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlinx.serialization.KSerializer<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.KSerializer<?>[] childSerializers() {
        /*
            r3 = this;
            r0 = 1
            kotlinx.serialization.KSerializer[] r0 = new kotlinx.serialization.KSerializer[r0]
            r1 = 0
            kotlinx.serialization.KSerializer<T> r2 = r3.f26416a
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.InlineClassDescriptorKt$InlinePrimitiveDescriptor$1.childSerializers():kotlinx.serialization.KSerializer[]");
    }

    public T deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        throw new IllegalStateException("unsupported".toString());
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        throw new IllegalStateException("unsupported".toString());
    }

    public void serialize(@NotNull Encoder encoder, T t11) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        throw new IllegalStateException("unsupported".toString());
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
