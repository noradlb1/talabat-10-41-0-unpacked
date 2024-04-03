package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\b\u0000¢\u0006\u0002\u0010\u0004J\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J%\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cR\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "()V", "baseClass", "Lkotlin/reflect/KClass;", "getBaseClass", "()Lkotlin/reflect/KClass;", "decodeSequentially", "compositeDecoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "klassName", "", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serialize", "", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@InternalSerializationApi
public abstract class AbstractPolymorphicSerializer<T> implements KSerializer<T> {
    /* access modifiers changed from: private */
    public final T decodeSequentially(CompositeDecoder compositeDecoder) {
        return CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), 1, PolymorphicSerializerKt.findPolymorphicSerializer(this, compositeDecoder, compositeDecoder.decodeStringElement(getDescriptor(), 0)), (Object) null, 8, (Object) null);
    }

    @NotNull
    public final T deserialize(@NotNull Decoder decoder) {
        T t11;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (beginStructure.decodeSequentially()) {
            t11 = decodeSequentially(beginStructure);
        } else {
            t11 = null;
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
                if (decodeElementIndex != -1) {
                    if (decodeElementIndex == 0) {
                        objectRef.element = beginStructure.decodeStringElement(getDescriptor(), decodeElementIndex);
                    } else if (decodeElementIndex != 1) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Invalid index in polymorphic deserialization of ");
                        String str = (String) objectRef.element;
                        if (str == null) {
                            str = "unknown class";
                        }
                        sb2.append(str);
                        sb2.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                        sb2.append(decodeElementIndex);
                        throw new SerializationException(sb2.toString());
                    } else {
                        T t12 = objectRef.element;
                        if (t12 != null) {
                            objectRef.element = t12;
                            DeserializationStrategy findPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(this, beginStructure, (String) t12);
                            t11 = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(beginStructure, getDescriptor(), decodeElementIndex, findPolymorphicSerializer, (Object) null, 8, (Object) null);
                        } else {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                        }
                    }
                } else if (t11 == null) {
                    throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) objectRef.element)).toString());
                }
            }
        }
        beginStructure.endStructure(descriptor);
        return t11;
    }

    @Nullable
    @InternalSerializationApi
    public DeserializationStrategy<? extends T> findPolymorphicSerializerOrNull(@NotNull CompositeDecoder compositeDecoder, @Nullable String str) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        return compositeDecoder.getSerializersModule().getPolymorphic(getBaseClass(), str);
    }

    @NotNull
    public abstract KClass<T> getBaseClass();

    public final void serialize(@NotNull Encoder encoder, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t11, "value");
        SerializationStrategy findPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(this, encoder, t11);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor);
        beginStructure.encodeStringElement(getDescriptor(), 0, findPolymorphicSerializer.getDescriptor().getSerialName());
        beginStructure.encodeSerializableElement(getDescriptor(), 1, findPolymorphicSerializer, t11);
        beginStructure.endStructure(descriptor);
    }

    @Nullable
    @InternalSerializationApi
    public SerializationStrategy<T> findPolymorphicSerializerOrNull(@NotNull Encoder encoder, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t11, "value");
        return encoder.getSerializersModule().getPolymorphic(getBaseClass(), t11);
    }
}
