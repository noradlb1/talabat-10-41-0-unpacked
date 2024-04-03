package kotlinx.serialization.json;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.internal.JsonIteratorKt;
import kotlinx.serialization.json.internal.JsonStringBuilder;
import kotlinx.serialization.json.internal.JsonToWriterStringBuilder;
import kotlinx.serialization.json.internal.ReaderJsonLexer;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StreamingJsonEncoder;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\b\u001a8\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\fH\b\u001a*\u0010\r\u001a\u00020\u000e\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u0010H\b¢\u0006\u0002\u0010\u0011\u001a5\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00132\u0006\u0010\u000f\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"decodeFromStream", "T", "Lkotlinx/serialization/json/Json;", "stream", "Ljava/io/InputStream;", "(Lkotlinx/serialization/json/Json;Ljava/io/InputStream;)Ljava/lang/Object;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/DeserializationStrategy;Ljava/io/InputStream;)Ljava/lang/Object;", "decodeToSequence", "Lkotlin/sequences/Sequence;", "format", "Lkotlinx/serialization/json/DecodeSequenceMode;", "encodeToStream", "", "value", "Ljava/io/OutputStream;", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;Ljava/io/OutputStream;)V", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Ljava/io/OutputStream;)V", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class JvmStreamsKt {
    @ExperimentalSerializationApi
    public static final <T> T decodeFromStream(@NotNull Json json, @NotNull DeserializationStrategy<T> deserializationStrategy, @NotNull InputStream inputStream) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(inputStream, "stream");
        ReaderJsonLexer readerJsonLexer = new ReaderJsonLexer(inputStream, (Charset) null, 2, (DefaultConstructorMarker) null);
        T decodeSerializableValue = new StreamingJsonDecoder(json, WriteMode.OBJ, readerJsonLexer, deserializationStrategy.getDescriptor()).decodeSerializableValue(deserializationStrategy);
        readerJsonLexer.expectEof();
        return decodeSerializableValue;
    }

    @ExperimentalSerializationApi
    @NotNull
    public static final <T> Sequence<T> decodeToSequence(@NotNull Json json, @NotNull InputStream inputStream, @NotNull DeserializationStrategy<T> deserializationStrategy, @NotNull DecodeSequenceMode decodeSequenceMode) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(inputStream, "stream");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(decodeSequenceMode, "format");
        return SequencesKt__SequencesKt.constrainOnce(new JvmStreamsKt$decodeToSequence$$inlined$Sequence$1(JsonIteratorKt.JsonIterator(decodeSequenceMode, json, new ReaderJsonLexer(inputStream, (Charset) null, 2, (DefaultConstructorMarker) null), deserializationStrategy)));
    }

    public static /* synthetic */ Sequence decodeToSequence$default(Json json, InputStream inputStream, DeserializationStrategy deserializationStrategy, DecodeSequenceMode decodeSequenceMode, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        return decodeToSequence(json, inputStream, deserializationStrategy, decodeSequenceMode);
    }

    @ExperimentalSerializationApi
    public static final <T> void encodeToStream(@NotNull Json json, @NotNull SerializationStrategy<? super T> serializationStrategy, T t11, @NotNull OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        Intrinsics.checkNotNullParameter(outputStream, "stream");
        JsonToWriterStringBuilder jsonToWriterStringBuilder = new JsonToWriterStringBuilder(outputStream, (Charset) null, 2, (DefaultConstructorMarker) null);
        try {
            new StreamingJsonEncoder((JsonStringBuilder) jsonToWriterStringBuilder, json, WriteMode.OBJ, new JsonEncoder[WriteMode.values().length]).encodeSerializableValue(serializationStrategy, t11);
        } finally {
            jsonToWriterStringBuilder.release();
        }
    }

    public static /* synthetic */ Sequence decodeToSequence$default(Json json, InputStream inputStream, DecodeSequenceMode decodeSequenceMode, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(inputStream, "stream");
        Intrinsics.checkNotNullParameter(decodeSequenceMode, "format");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        return decodeToSequence(json, inputStream, SerializersKt.serializer(serializersModule, (KType) null), decodeSequenceMode);
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> Sequence<T> decodeToSequence(Json json, InputStream inputStream, DecodeSequenceMode decodeSequenceMode) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(inputStream, "stream");
        Intrinsics.checkNotNullParameter(decodeSequenceMode, "format");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        return decodeToSequence(json, inputStream, SerializersKt.serializer(serializersModule, (KType) null), decodeSequenceMode);
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> T decodeFromStream(Json json, InputStream inputStream) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(inputStream, "stream");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        return decodeFromStream(json, SerializersKt.serializer(serializersModule, (KType) null), inputStream);
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> void encodeToStream(Json json, T t11, OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(outputStream, "stream");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        encodeToStream(json, SerializersKt.serializer(serializersModule, (KType) null), t11, outputStream);
    }
}
