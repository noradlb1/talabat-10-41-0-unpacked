package com.deliveryhero.fluid.template.sources;

import android.util.AtomicFile;
import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.template.TemplateBuilder;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Charsets;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JvmStreamsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/TemplateDiskSource;", "Lcom/deliveryhero/fluid/template/sources/TemplateInputStreamSource;", "Lcom/deliveryhero/fluid/template/sources/WritableTemplateSource;", "config", "Lcom/deliveryhero/fluid/ParseConfig;", "file", "Ljava/io/File;", "(Lcom/deliveryhero/fluid/ParseConfig;Ljava/io/File;)V", "parseConfig", "Landroid/util/AtomicFile;", "(Lcom/deliveryhero/fluid/ParseConfig;Landroid/util/AtomicFile;)V", "getFile", "()Landroid/util/AtomicFile;", "name", "", "getName", "()Ljava/lang/String;", "write", "", "templates", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateDiskSource extends TemplateInputStreamSource implements WritableTemplateSource {
    @NotNull
    private final AtomicFile file;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f30226name;

    private TemplateDiskSource(ParseConfig parseConfig, final AtomicFile atomicFile) {
        super(new Function0<InputStream>() {
            @NotNull
            public final InputStream invoke() {
                atomicFile.getBaseFile().createNewFile();
                FileInputStream openRead = atomicFile.openRead();
                Intrinsics.checkNotNullExpressionValue(openRead, "file.openRead()");
                return openRead;
            }
        }, parseConfig);
        this.file = atomicFile;
        this.f30226name = "disk";
    }

    @NotNull
    public final AtomicFile getFile() {
        return this.file;
    }

    @NotNull
    public String getName() {
        return this.f30226name;
    }

    public void write(@NotNull Map<String, TemplateBuilder> map) {
        BufferedOutputStream bufferedOutputStream;
        BufferedWriter bufferedWriter;
        Intrinsics.checkNotNullParameter(map, "templates");
        AtomicFile atomicFile = this.file;
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            Intrinsics.checkNotNullExpressionValue(startWrite, "stream");
            SerialFormat serialFormat = getParseConfig().getSerialFormat();
            List list = CollectionsKt___CollectionsKt.toList(map.values());
            Class<TemplateBuilder> cls = TemplateBuilder.class;
            Class<List> cls2 = List.class;
            if (serialFormat instanceof Json) {
                Json json = (Json) serialFormat;
                JvmStreamsKt.encodeToStream(json, SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf((Class) cls2, KTypeProjection.Companion.invariant(Reflection.typeOf((Class) cls)))), list, startWrite);
            } else if (serialFormat instanceof StringFormat) {
                StringFormat stringFormat = (StringFormat) serialFormat;
                String encodeToString = stringFormat.encodeToString(SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf((Class) cls2, KTypeProjection.Companion.invariant(Reflection.typeOf((Class) cls)))), list);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(startWrite, Charsets.UTF_8);
                if (outputStreamWriter instanceof BufferedWriter) {
                    bufferedWriter = (BufferedWriter) outputStreamWriter;
                } else {
                    bufferedWriter = new BufferedWriter(outputStreamWriter, 8192);
                }
                bufferedWriter.write(encodeToString);
            } else if (serialFormat instanceof BinaryFormat) {
                BinaryFormat binaryFormat = (BinaryFormat) serialFormat;
                byte[] encodeToByteArray = binaryFormat.encodeToByteArray(SerializersKt.serializer(binaryFormat.getSerializersModule(), Reflection.typeOf((Class) cls2, KTypeProjection.Companion.invariant(Reflection.typeOf((Class) cls)))), list);
                if (startWrite instanceof BufferedOutputStream) {
                    bufferedOutputStream = (BufferedOutputStream) startWrite;
                } else {
                    bufferedOutputStream = new BufferedOutputStream(startWrite, 8192);
                }
                bufferedOutputStream.write(encodeToByteArray);
            } else {
                throw new UnsupportedOperationException('`' + serialFormat + "` format is unsupported");
            }
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th2) {
            atomicFile.failWrite(startWrite);
            throw th2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TemplateDiskSource(@NotNull ParseConfig parseConfig, @NotNull File file2) {
        this(parseConfig, new AtomicFile(file2));
        Intrinsics.checkNotNullParameter(parseConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(file2, "file");
    }
}
