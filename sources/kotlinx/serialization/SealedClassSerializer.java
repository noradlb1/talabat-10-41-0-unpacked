package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BW\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0002\u0010\u000eBG\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\t¢\u0006\u0002\u0010\u000fJ$\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J%\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010&R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u0015X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178VX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlinx/serialization/SealedClassSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "serialName", "", "baseClass", "Lkotlin/reflect/KClass;", "subclasses", "", "subclassSerializers", "Lkotlinx/serialization/KSerializer;", "classAnnotations", "", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;[Ljava/lang/annotation/Annotation;)V", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "_annotations", "", "getBaseClass", "()Lkotlin/reflect/KClass;", "class2Serializer", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "serialName2Serializer", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "klassName", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@InternalSerializationApi
public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {
    /* access modifiers changed from: private */
    @NotNull
    public List<? extends Annotation> _annotations;
    @NotNull
    private final KClass<T> baseClass;
    @NotNull
    private final Map<KClass<? extends T>, KSerializer<? extends T>> class2Serializer;
    @NotNull
    private final Lazy descriptor$delegate;
    @NotNull
    private final Map<String, KSerializer<? extends T>> serialName2Serializer;

    public SealedClassSerializer(@NotNull String str, @NotNull KClass<T> kClass, @NotNull KClass<? extends T>[] kClassArr, @NotNull KSerializer<? extends T>[] kSerializerArr) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClassArr, "subclasses");
        Intrinsics.checkNotNullParameter(kSerializerArr, "subclassSerializers");
        this.baseClass = kClass;
        this._annotations = CollectionsKt__CollectionsKt.emptyList();
        this.descriptor$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new SealedClassSerializer$descriptor$2(str, this, kSerializerArr));
        if (kClassArr.length == kSerializerArr.length) {
            Map<KClass<? extends T>, KSerializer<? extends T>> map = MapsKt__MapsKt.toMap(ArraysKt___ArraysKt.zip((T[]) kClassArr, (R[]) kSerializerArr));
            this.class2Serializer = map;
            SealedClassSerializer$special$$inlined$groupingBy$1 sealedClassSerializer$special$$inlined$groupingBy$1 = new SealedClassSerializer$special$$inlined$groupingBy$1(map.entrySet());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator sourceIterator = sealedClassSerializer$special$$inlined$groupingBy$1.sourceIterator();
            while (sourceIterator.hasNext()) {
                Object next = sourceIterator.next();
                Object keyOf = sealedClassSerializer$special$$inlined$groupingBy$1.keyOf(next);
                Object obj = linkedHashMap.get(keyOf);
                if (obj == null) {
                    linkedHashMap.containsKey(keyOf);
                }
                Map.Entry entry = (Map.Entry) next;
                Map.Entry entry2 = (Map.Entry) obj;
                String str2 = (String) keyOf;
                if (entry2 == null) {
                    linkedHashMap.put(keyOf, entry);
                } else {
                    throw new IllegalStateException(("Multiple sealed subclasses of '" + getBaseClass() + "' have the same serial name '" + str2 + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
            }
            this.serialName2Serializer = linkedHashMap2;
            return;
        }
        throw new IllegalArgumentException("All subclasses of sealed class " + getBaseClass().getSimpleName() + " should be marked @Serializable");
    }

    @Nullable
    public DeserializationStrategy<? extends T> findPolymorphicSerializerOrNull(@NotNull CompositeDecoder compositeDecoder, @Nullable String str) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        KSerializer kSerializer = this.serialName2Serializer.get(str);
        return kSerializer != null ? kSerializer : super.findPolymorphicSerializerOrNull(compositeDecoder, str);
    }

    @NotNull
    public KClass<T> getBaseClass() {
        return this.baseClass;
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @Nullable
    public SerializationStrategy<T> findPolymorphicSerializerOrNull(@NotNull Encoder encoder, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t11, "value");
        SerializationStrategy<T> serializationStrategy = this.class2Serializer.get(Reflection.getOrCreateKotlinClass(t11.getClass()));
        if (serializationStrategy == null) {
            serializationStrategy = super.findPolymorphicSerializerOrNull(encoder, t11);
        }
        if (serializationStrategy != null) {
            return serializationStrategy;
        }
        return null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @PublishedApi
    public SealedClassSerializer(@NotNull String str, @NotNull KClass<T> kClass, @NotNull KClass<? extends T>[] kClassArr, @NotNull KSerializer<? extends T>[] kSerializerArr, @NotNull Annotation[] annotationArr) {
        this(str, kClass, kClassArr, kSerializerArr);
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClassArr, "subclasses");
        Intrinsics.checkNotNullParameter(kSerializerArr, "subclassSerializers");
        Intrinsics.checkNotNullParameter(annotationArr, "classAnnotations");
        this._annotations = ArraysKt___ArraysJvmKt.asList((T[]) annotationArr);
    }
}
