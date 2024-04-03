package com.deliveryhero.fluid.serialization;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JvmStreamsKt;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\b¢\u0006\u0002\u0010\b\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\b¢\u0006\u0002\u0010\u000b\u001a*\u0010\f\u001a\u00020\r\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u0002H\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\b¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"fluidDeserialize", "T", "Lkotlinx/serialization/SerialFormat;", "inputStream", "Ljava/io/InputStream;", "(Lkotlinx/serialization/SerialFormat;Ljava/io/InputStream;)Ljava/lang/Object;", "value", "", "(Lkotlinx/serialization/SerialFormat;Ljava/lang/String;)Ljava/lang/Object;", "jsonElement", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/SerialFormat;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "fluidSerialize", "", "data", "outputStream", "Ljava/io/OutputStream;", "(Lkotlinx/serialization/SerialFormat;Ljava/lang/Object;Ljava/io/OutputStream;)V", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SerialFormatUtilsKt {
    public static final /* synthetic */ <T> T fluidDeserialize(SerialFormat serialFormat, InputStream inputStream) {
        Intrinsics.checkNotNullParameter(serialFormat, "<this>");
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        if (serialFormat instanceof Json) {
            Json json = (Json) serialFormat;
            SerializersModule serializersModule = json.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            return JvmStreamsKt.decodeFromStream(json, SerializersKt.serializer(serializersModule, (KType) null), inputStream);
        } else if (serialFormat instanceof StringFormat) {
            StringFormat stringFormat = (StringFormat) serialFormat;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            String readText = TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
            SerializersModule serializersModule2 = stringFormat.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            return stringFormat.decodeFromString(SerializersKt.serializer(serializersModule2, (KType) null), readText);
        } else if (serialFormat instanceof BinaryFormat) {
            BinaryFormat binaryFormat = (BinaryFormat) serialFormat;
            byte[] readBytes = ByteStreamsKt.readBytes(inputStream);
            SerializersModule serializersModule3 = binaryFormat.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            return binaryFormat.decodeFromByteArray(SerializersKt.serializer(serializersModule3, (KType) null), readBytes);
        } else {
            throw new UnsupportedOperationException('`' + serialFormat + "` format is unsupported");
        }
    }

    public static final /* synthetic */ <T> void fluidSerialize(SerialFormat serialFormat, T t11, OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream;
        BufferedWriter bufferedWriter;
        Intrinsics.checkNotNullParameter(serialFormat, "<this>");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        if (serialFormat instanceof Json) {
            Json json = (Json) serialFormat;
            SerializersModule serializersModule = json.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            JvmStreamsKt.encodeToStream(json, SerializersKt.serializer(serializersModule, (KType) null), t11, outputStream);
        } else if (serialFormat instanceof StringFormat) {
            StringFormat stringFormat = (StringFormat) serialFormat;
            SerializersModule serializersModule2 = stringFormat.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            String encodeToString = stringFormat.encodeToString(SerializersKt.serializer(serializersModule2, (KType) null), t11);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, Charsets.UTF_8);
            if (outputStreamWriter instanceof BufferedWriter) {
                bufferedWriter = (BufferedWriter) outputStreamWriter;
            } else {
                bufferedWriter = new BufferedWriter(outputStreamWriter, 8192);
            }
            bufferedWriter.write(encodeToString);
        } else if (serialFormat instanceof BinaryFormat) {
            BinaryFormat binaryFormat = (BinaryFormat) serialFormat;
            SerializersModule serializersModule3 = binaryFormat.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            byte[] encodeToByteArray = binaryFormat.encodeToByteArray(SerializersKt.serializer(serializersModule3, (KType) null), t11);
            if (outputStream instanceof BufferedOutputStream) {
                bufferedOutputStream = (BufferedOutputStream) outputStream;
            } else {
                bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
            }
            bufferedOutputStream.write(encodeToByteArray);
        } else {
            throw new UnsupportedOperationException('`' + serialFormat + "` format is unsupported");
        }
    }

    public static final /* synthetic */ <T> T fluidDeserialize(SerialFormat serialFormat, String str) {
        Intrinsics.checkNotNullParameter(serialFormat, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        if (serialFormat instanceof Json) {
            StringFormat stringFormat = (StringFormat) serialFormat;
            SerializersModule serializersModule = stringFormat.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            return stringFormat.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), str);
        } else if (serialFormat instanceof StringFormat) {
            StringFormat stringFormat2 = (StringFormat) serialFormat;
            SerializersModule serializersModule2 = stringFormat2.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            return stringFormat2.decodeFromString(SerializersKt.serializer(serializersModule2, (KType) null), str);
        } else if (serialFormat instanceof BinaryFormat) {
            BinaryFormat binaryFormat = (BinaryFormat) serialFormat;
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            SerializersModule serializersModule3 = binaryFormat.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            return binaryFormat.decodeFromByteArray(SerializersKt.serializer(serializersModule3, (KType) null), bytes);
        } else {
            throw new UnsupportedOperationException('`' + serialFormat + "` format is unsupported");
        }
    }

    public static final /* synthetic */ <T> T fluidDeserialize(SerialFormat serialFormat, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(serialFormat, "<this>");
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        if (serialFormat instanceof Json) {
            Json json = (Json) serialFormat;
            SerializersModule serializersModule = json.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            return json.decodeFromJsonElement(SerializersKt.serializer(serializersModule, (KType) null), jsonElement);
        } else if (serialFormat instanceof StringFormat) {
            StringFormat stringFormat = (StringFormat) serialFormat;
            String obj = jsonElement.toString();
            SerializersModule serializersModule2 = stringFormat.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            return stringFormat.decodeFromString(SerializersKt.serializer(serializersModule2, (KType) null), obj);
        } else {
            throw new UnsupportedOperationException('`' + serialFormat + "` format is unsupported");
        }
    }
}
