package kotlinx.serialization.json;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Typography;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\b\u001a\u00020\u00072\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00152\u0006\u0010\u0014\u001a\u00020\u0013H$R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/json/JsonContentPolymorphicSerializer;", "", "T", "Lkotlinx/serialization/KSerializer;", "Lkotlin/reflect/KClass;", "subClass", "baseClass", "", "throwSubtypeNotRegistered", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/json/JsonElement;", "element", "Lkotlinx/serialization/DeserializationStrategy;", "a", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "(Lkotlin/reflect/KClass;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
public abstract class JsonContentPolymorphicSerializer<T> implements KSerializer<T> {
    @NotNull
    private final KClass<T> baseClass;
    @NotNull
    private final SerialDescriptor descriptor;

    public JsonContentPolymorphicSerializer(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        this.baseClass = kClass;
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor$default("JsonContentPolymorphicSerializer<" + kClass.getSimpleName() + Typography.greater, PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], (Function1) null, 8, (Object) null);
    }

    private final Void throwSubtypeNotRegistered(KClass<?> kClass, KClass<?> kClass2) {
        String simpleName = kClass.getSimpleName();
        if (simpleName == null) {
            simpleName = String.valueOf(kClass);
        }
        throw new SerializationException("Class '" + simpleName + "' is not registered for polymorphic serialization " + ("in the scope of '" + kClass2.getSimpleName() + '\'') + ".\nMark the base class as 'sealed' or register the serializer explicitly.");
    }

    @NotNull
    public abstract DeserializationStrategy<? extends T> a(@NotNull JsonElement jsonElement);

    @NotNull
    public final T deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder asJsonDecoder = JsonElementSerializersKt.asJsonDecoder(decoder);
        JsonElement decodeJsonElement = asJsonDecoder.decodeJsonElement();
        return asJsonDecoder.getJson().decodeFromJsonElement((KSerializer) a(decodeJsonElement), decodeJsonElement);
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final void serialize(@NotNull Encoder encoder, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t11, "value");
        SerializationStrategy<T> polymorphic = encoder.getSerializersModule().getPolymorphic(this.baseClass, t11);
        if (polymorphic == null && (polymorphic = SerializersKt.serializerOrNull(Reflection.getOrCreateKotlinClass(t11.getClass()))) == null) {
            throwSubtypeNotRegistered(Reflection.getOrCreateKotlinClass(t11.getClass()), this.baseClass);
            throw new KotlinNothingValueException();
        } else {
            ((KSerializer) polymorphic).serialize(encoder, t11);
        }
    }
}
