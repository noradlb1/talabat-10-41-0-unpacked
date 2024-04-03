package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8VX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0006\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/internal/ObjectSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "objectInstance", "classAnnotations", "", "", "(Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/annotation/Annotation;)V", "(Ljava/lang/String;Ljava/lang/Object;)V", "_annotations", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PublishedApi
public final class ObjectSerializer<T> implements KSerializer<T> {
    /* access modifiers changed from: private */
    @NotNull
    public List<? extends Annotation> _annotations;
    @NotNull
    private final Lazy descriptor$delegate;
    @NotNull
    private final T objectInstance;

    public ObjectSerializer(@NotNull String str, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(t11, "objectInstance");
        this.objectInstance = t11;
        this._annotations = CollectionsKt__CollectionsKt.emptyList();
        this.descriptor$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ObjectSerializer$descriptor$2(str, this));
    }

    @NotNull
    public T deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor);
        int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
        if (decodeElementIndex == -1) {
            Unit unit = Unit.INSTANCE;
            beginStructure.endStructure(descriptor);
            return this.objectInstance;
        }
        throw new SerializationException("Unexpected index " + decodeElementIndex);
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    public void serialize(@NotNull Encoder encoder, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t11, "value");
        encoder.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @PublishedApi
    public ObjectSerializer(@NotNull String str, @NotNull T t11, @NotNull Annotation[] annotationArr) {
        this(str, t11);
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(t11, "objectInstance");
        Intrinsics.checkNotNullParameter(annotationArr, "classAnnotations");
        this._annotations = ArraysKt___ArraysJvmKt.asList((T[]) annotationArr);
    }
}
