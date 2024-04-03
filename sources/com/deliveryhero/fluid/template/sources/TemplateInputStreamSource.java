package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J'\u0010\n\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/TemplateInputStreamSource;", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "inputStream", "Lkotlin/Function0;", "Ljava/io/InputStream;", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "(Lkotlin/jvm/functions/Function0;Lcom/deliveryhero/fluid/ParseConfig;)V", "getParseConfig", "()Lcom/deliveryhero/fluid/ParseConfig;", "get", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "requests", "", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TemplateInputStreamSource implements ReadableTemplateSource {
    @NotNull
    private final Function0<InputStream> inputStream;
    @NotNull
    private final ParseConfig parseConfig;

    public TemplateInputStreamSource(@NotNull Function0<? extends InputStream> function0, @NotNull ParseConfig parseConfig2) {
        Intrinsics.checkNotNullParameter(function0, "inputStream");
        Intrinsics.checkNotNullParameter(parseConfig2, "parseConfig");
        this.inputStream = function0;
        this.parseConfig = parseConfig2;
    }

    @NotNull
    public TemplateBuilder get(@NotNull ReadableTemplateSource.Request request) throws Throwable {
        return ReadableTemplateSource.DefaultImpls.get(this, request);
    }

    @NotNull
    public String getDebugName() {
        return ReadableTemplateSource.DefaultImpls.getDebugName(this);
    }

    @NotNull
    public ParseConfig getParseConfig() {
        return this.parseConfig;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f9, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fa, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fd, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, com.deliveryhero.fluid.template.TemplateBuilder> get(@org.jetbrains.annotations.NotNull java.util.Set<com.deliveryhero.fluid.template.sources.ReadableTemplateSource.Request> r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "requests"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.jvm.functions.Function0<java.io.InputStream> r7 = r6.inputStream
            java.lang.Object r7 = r7.invoke()
            java.io.InputStream r7 = (java.io.InputStream) r7
            boolean r0 = r7 instanceof java.io.BufferedInputStream
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0016
            java.io.BufferedInputStream r7 = (java.io.BufferedInputStream) r7
            goto L_0x001c
        L_0x0016:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            r0.<init>(r7, r1)
            r7 = r0
        L_0x001c:
            com.deliveryhero.fluid.ParseConfig r0 = r6.getParseConfig()     // Catch:{ all -> 0x00f7 }
            kotlinx.serialization.SerialFormat r0 = r0.getSerialFormat()     // Catch:{ all -> 0x00f7 }
            boolean r2 = r0 instanceof kotlinx.serialization.json.Json     // Catch:{ all -> 0x00f7 }
            java.lang.Class<com.deliveryhero.fluid.template.TemplateBuilder> r3 = com.deliveryhero.fluid.template.TemplateBuilder.class
            java.lang.Class<java.util.List> r4 = java.util.List.class
            if (r2 == 0) goto L_0x0049
            kotlinx.serialization.json.Json r0 = (kotlinx.serialization.json.Json) r0     // Catch:{ all -> 0x00f7 }
            kotlinx.serialization.modules.SerializersModule r1 = r0.getSerializersModule()     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KTypeProjection$Companion r2 = kotlin.reflect.KTypeProjection.Companion     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r3)     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KTypeProjection r2 = r2.invariant(r3)     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r4, (kotlin.reflect.KTypeProjection) r2)     // Catch:{ all -> 0x00f7 }
            kotlinx.serialization.KSerializer r1 = kotlinx.serialization.SerializersKt.serializer((kotlinx.serialization.modules.SerializersModule) r1, (kotlin.reflect.KType) r2)     // Catch:{ all -> 0x00f7 }
            java.lang.Object r0 = kotlinx.serialization.json.JvmStreamsKt.decodeFromStream(r0, r1, r7)     // Catch:{ all -> 0x00f7 }
            goto L_0x00a6
        L_0x0049:
            boolean r2 = r0 instanceof kotlinx.serialization.StringFormat     // Catch:{ all -> 0x00f7 }
            if (r2 == 0) goto L_0x0082
            kotlinx.serialization.StringFormat r0 = (kotlinx.serialization.StringFormat) r0     // Catch:{ all -> 0x00f7 }
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x00f7 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x00f7 }
            r5.<init>(r7, r2)     // Catch:{ all -> 0x00f7 }
            boolean r2 = r5 instanceof java.io.BufferedReader     // Catch:{ all -> 0x00f7 }
            if (r2 == 0) goto L_0x005d
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch:{ all -> 0x00f7 }
            goto L_0x0063
        L_0x005d:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x00f7 }
            r2.<init>(r5, r1)     // Catch:{ all -> 0x00f7 }
            r5 = r2
        L_0x0063:
            java.lang.String r1 = kotlin.io.TextStreamsKt.readText(r5)     // Catch:{ all -> 0x00f7 }
            kotlinx.serialization.modules.SerializersModule r2 = r0.getSerializersModule()     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KTypeProjection$Companion r5 = kotlin.reflect.KTypeProjection.Companion     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r3)     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KTypeProjection r3 = r5.invariant(r3)     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r4, (kotlin.reflect.KTypeProjection) r3)     // Catch:{ all -> 0x00f7 }
            kotlinx.serialization.KSerializer r2 = kotlinx.serialization.SerializersKt.serializer((kotlinx.serialization.modules.SerializersModule) r2, (kotlin.reflect.KType) r3)     // Catch:{ all -> 0x00f7 }
            java.lang.Object r0 = r0.decodeFromString(r2, r1)     // Catch:{ all -> 0x00f7 }
            goto L_0x00a6
        L_0x0082:
            boolean r1 = r0 instanceof kotlinx.serialization.BinaryFormat     // Catch:{ all -> 0x00f7 }
            if (r1 == 0) goto L_0x00db
            kotlinx.serialization.BinaryFormat r0 = (kotlinx.serialization.BinaryFormat) r0     // Catch:{ all -> 0x00f7 }
            byte[] r1 = kotlin.io.ByteStreamsKt.readBytes(r7)     // Catch:{ all -> 0x00f7 }
            kotlinx.serialization.modules.SerializersModule r2 = r0.getSerializersModule()     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KTypeProjection$Companion r5 = kotlin.reflect.KTypeProjection.Companion     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r3)     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KTypeProjection r3 = r5.invariant(r3)     // Catch:{ all -> 0x00f7 }
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r4, (kotlin.reflect.KTypeProjection) r3)     // Catch:{ all -> 0x00f7 }
            kotlinx.serialization.KSerializer r2 = kotlinx.serialization.SerializersKt.serializer((kotlinx.serialization.modules.SerializersModule) r2, (kotlin.reflect.KType) r3)     // Catch:{ all -> 0x00f7 }
            java.lang.Object r0 = r0.decodeFromByteArray(r2, r1)     // Catch:{ all -> 0x00f7 }
        L_0x00a6:
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x00f7 }
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r1)     // Catch:{ all -> 0x00f7 }
            int r1 = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(r1)     // Catch:{ all -> 0x00f7 }
            r2 = 16
            int r1 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r1, (int) r2)     // Catch:{ all -> 0x00f7 }
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00f7 }
            r2.<init>(r1)     // Catch:{ all -> 0x00f7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00f7 }
        L_0x00c1:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00f7 }
            if (r1 == 0) goto L_0x00d6
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00f7 }
            r3 = r1
            com.deliveryhero.fluid.template.TemplateBuilder r3 = (com.deliveryhero.fluid.template.TemplateBuilder) r3     // Catch:{ all -> 0x00f7 }
            java.lang.String r3 = r3.getId()     // Catch:{ all -> 0x00f7 }
            r2.put(r3, r1)     // Catch:{ all -> 0x00f7 }
            goto L_0x00c1
        L_0x00d6:
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r7, r0)
            return r2
        L_0x00db:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x00f7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r2.<init>()     // Catch:{ all -> 0x00f7 }
            r3 = 96
            r2.append(r3)     // Catch:{ all -> 0x00f7 }
            r2.append(r0)     // Catch:{ all -> 0x00f7 }
            java.lang.String r0 = "` format is unsupported"
            r2.append(r0)     // Catch:{ all -> 0x00f7 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00f7 }
            r1.<init>(r0)     // Catch:{ all -> 0x00f7 }
            throw r1     // Catch:{ all -> 0x00f7 }
        L_0x00f7:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00f9 }
        L_0x00f9:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.template.sources.TemplateInputStreamSource.get(java.util.Set):java.util.Map");
    }
}
