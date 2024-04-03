package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0002H\u0000\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b*\u0006\u0012\u0002\b\u00030\nH\b\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\u0006\u0012\u0002\b\u00030\fH\b\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r\"\u0004\b\u0000\u0010\u000b*\u0006\u0012\u0002\b\u00030\rH\b\u001a\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0000¢\u0006\u0002\u0010\u0010\u001a6\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u000b0\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00130\u0016H\bø\u0001\u0000\u001a\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\u00020\u001aH\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u001c*\u0006\u0012\u0002\b\u00030\u0018H\u0000\"\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0004¢\u0006\n\n\u0002\u0010\u0005\u0012\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001d"}, d2 = {"EMPTY_DESCRIPTOR_ARRAY", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getEMPTY_DESCRIPTOR_ARRAY$annotations", "()V", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "cachedSerialNames", "", "", "cast", "Lkotlinx/serialization/DeserializationStrategy;", "T", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/SerializationStrategy;", "compactArray", "", "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsHashCodeBy", "", "K", "", "selector", "Lkotlin/Function1;", "kclass", "Lkotlin/reflect/KClass;", "", "Lkotlin/reflect/KType;", "serializerNotRegistered", "", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class Platform_commonKt {
    @NotNull
    private static final SerialDescriptor[] EMPTY_DESCRIPTOR_ARRAY = new SerialDescriptor[0];

    @NotNull
    public static final Set<String> cachedSerialNames(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor instanceof CachedNames) {
            return ((CachedNames) serialDescriptor).getSerialNames();
        }
        HashSet hashSet = new HashSet(serialDescriptor.getElementsCount());
        int elementsCount = serialDescriptor.getElementsCount();
        for (int i11 = 0; i11 < elementsCount; i11++) {
            hashSet.add(serialDescriptor.getElementName(i11));
        }
        return hashSet;
    }

    @NotNull
    @PublishedApi
    public static final <T> DeserializationStrategy<T> cast(@NotNull DeserializationStrategy<?> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "<this>");
        return deserializationStrategy;
    }

    @NotNull
    @PublishedApi
    public static final <T> KSerializer<T> cast(@NotNull KSerializer<?> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        return kSerializer;
    }

    @NotNull
    @PublishedApi
    public static final <T> SerializationStrategy<T> cast(@NotNull SerializationStrategy<?> serializationStrategy) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "<this>");
        return serializationStrategy;
    }

    @NotNull
    public static final SerialDescriptor[] compactArray(@Nullable List<? extends SerialDescriptor> list) {
        boolean z11;
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            list = null;
        }
        if (list == null) {
            return EMPTY_DESCRIPTOR_ARRAY;
        }
        Object[] array = list.toArray(new SerialDescriptor[0]);
        if (array != null) {
            return (SerialDescriptor[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final <T, K> int elementsHashCodeBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1) {
        int i11;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i12 = 1;
        for (Object invoke : iterable) {
            int i13 = i12 * 31;
            Object invoke2 = function1.invoke(invoke);
            if (invoke2 != null) {
                i11 = invoke2.hashCode();
            } else {
                i11 = 0;
            }
            i12 = i13 + i11;
        }
        return i12;
    }

    private static /* synthetic */ void getEMPTY_DESCRIPTOR_ARRAY$annotations() {
    }

    @NotNull
    public static final KClass<Object> kclass(@NotNull KType kType) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KClass) {
            return (KClass) classifier;
        }
        if (classifier instanceof KTypeParameter) {
            throw new IllegalStateException(("Captured type paramerer " + classifier + " from generic non-reified function. Such functionality cannot be supported as " + classifier + " is erased, either specify serializer explicitly or make calling function inline with reified " + classifier).toString());
        }
        throw new IllegalStateException(("Only KClass supported as classifier, got " + classifier).toString());
    }

    @NotNull
    public static final Void serializerNotRegistered(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        throw new SerializationException("Serializer for class '" + kClass.getSimpleName() + "' is not found.\nMark the class as @Serializable or provide the serializer explicitly.");
    }
}
