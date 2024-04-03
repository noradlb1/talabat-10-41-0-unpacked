package kotlinx.serialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.internal.InternalHexConverter;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u0006\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\b¢\u0006\u0002\u0010\t\u001a+\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\f\u001a\"\u0010\r\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\b¢\u0006\u0002\u0010\u0010\u001a\"\u0010\u0011\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0012\u001a\u0002H\u0001H\b¢\u0006\u0002\u0010\u0013\u001a\"\u0010\u0014\u001a\u00020\b\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0012\u001a\u0002H\u0001H\b¢\u0006\u0002\u0010\u0015\u001a+\u0010\u0014\u001a\u00020\b\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00172\u0006\u0010\u0012\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0018\u001a\"\u0010\u0019\u001a\u00020\b\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u000e2\u0006\u0010\u0012\u001a\u0002H\u0001H\b¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"decodeFromByteArray", "T", "Lkotlinx/serialization/BinaryFormat;", "bytes", "", "(Lkotlinx/serialization/BinaryFormat;[B)Ljava/lang/Object;", "decodeFromHexString", "hex", "", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/String;)Ljava/lang/Object;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "decodeFromString", "Lkotlinx/serialization/StringFormat;", "string", "(Lkotlinx/serialization/StringFormat;Ljava/lang/String;)Ljava/lang/Object;", "encodeToByteArray", "value", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)[B", "encodeToHexString", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)Ljava/lang/String;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "encodeToString", "(Lkotlinx/serialization/StringFormat;Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SerialFormatKt {
    public static final /* synthetic */ <T> T decodeFromByteArray(BinaryFormat binaryFormat, byte[] bArr) {
        Intrinsics.checkNotNullParameter(binaryFormat, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        SerializersModule serializersModule = binaryFormat.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        return binaryFormat.decodeFromByteArray(SerializersKt.serializer(serializersModule, (KType) null), bArr);
    }

    public static final <T> T decodeFromHexString(@NotNull BinaryFormat binaryFormat, @NotNull DeserializationStrategy<T> deserializationStrategy, @NotNull String str) {
        Intrinsics.checkNotNullParameter(binaryFormat, "<this>");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(str, "hex");
        return binaryFormat.decodeFromByteArray(deserializationStrategy, InternalHexConverter.INSTANCE.parseHexBinary(str));
    }

    public static final /* synthetic */ <T> T decodeFromString(StringFormat stringFormat, String str) {
        Intrinsics.checkNotNullParameter(stringFormat, "<this>");
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        SerializersModule serializersModule = stringFormat.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        return stringFormat.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), str);
    }

    public static final /* synthetic */ <T> byte[] encodeToByteArray(BinaryFormat binaryFormat, T t11) {
        Intrinsics.checkNotNullParameter(binaryFormat, "<this>");
        SerializersModule serializersModule = binaryFormat.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        return binaryFormat.encodeToByteArray(SerializersKt.serializer(serializersModule, (KType) null), t11);
    }

    @NotNull
    public static final <T> String encodeToHexString(@NotNull BinaryFormat binaryFormat, @NotNull SerializationStrategy<? super T> serializationStrategy, T t11) {
        Intrinsics.checkNotNullParameter(binaryFormat, "<this>");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        return InternalHexConverter.INSTANCE.printHexBinary(binaryFormat.encodeToByteArray(serializationStrategy, t11), true);
    }

    public static final /* synthetic */ <T> String encodeToString(StringFormat stringFormat, T t11) {
        Intrinsics.checkNotNullParameter(stringFormat, "<this>");
        SerializersModule serializersModule = stringFormat.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        return stringFormat.encodeToString(SerializersKt.serializer(serializersModule, (KType) null), t11);
    }

    public static final /* synthetic */ <T> T decodeFromHexString(BinaryFormat binaryFormat, String str) {
        Intrinsics.checkNotNullParameter(binaryFormat, "<this>");
        Intrinsics.checkNotNullParameter(str, "hex");
        SerializersModule serializersModule = binaryFormat.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        return decodeFromHexString(binaryFormat, SerializersKt.serializer(serializersModule, (KType) null), str);
    }

    public static final /* synthetic */ <T> String encodeToHexString(BinaryFormat binaryFormat, T t11) {
        Intrinsics.checkNotNullParameter(binaryFormat, "<this>");
        SerializersModule serializersModule = binaryFormat.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        return encodeToHexString(binaryFormat, SerializersKt.serializer(serializersModule, (KType) null), t11);
    }
}
