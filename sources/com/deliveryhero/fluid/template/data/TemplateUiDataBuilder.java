package com.deliveryhero.fluid.template.data;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.expression.placeholder.PlaceholderValueDecoder;
import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\b¢\u0006\u0002\u0010\tJ,\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0001\u0012\u0002\b\u00030\u00140\u00052\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\bHÆ\u0003JY\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\bHÆ\u0001J0\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\u0010\u0010\u001e\u001a\f\u0012\u0004\u0012\u00020\u0001\u0012\u0002\b\u00030\u00142\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006&"}, d2 = {"Lcom/deliveryhero/fluid/template/data/TemplateUiDataBuilder;", "", "id", "", "values", "", "cells", "metadata", "Lcom/deliveryhero/fluid/template/data/TemplateMetadata;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getCells", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "getMetadata", "placeholderValues", "getValues", "build", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "decoders", "Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderValueDecoder;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "component1", "component2", "component3", "component4", "copy", "decodeValue", "Lcom/deliveryhero/fluid/expression/Expression;", "decoder", "key", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateUiDataBuilder {
    @NotNull
    private final Map<String, Object> cells;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f30212id;
    @NotNull
    private final Map<String, Object> metadata;
    @NotNull
    private final Map<String, Object> placeholderValues;
    @NotNull
    private final Map<String, String> values;

    public TemplateUiDataBuilder(@NotNull String str, @NotNull Map<String, String> map, @NotNull Map<String, ? extends Object> map2, @NotNull Map<String, ? extends Object> map3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(map, "values");
        Intrinsics.checkNotNullParameter(map2, ComponentMapper.CELLS);
        Intrinsics.checkNotNullParameter(map3, TtmlNode.TAG_METADATA);
        this.f30212id = str;
        this.values = map;
        this.cells = map2;
        this.metadata = map3;
        this.placeholderValues = MapsKt__MapsKt.plus(map, (Map<String, String>) map2);
    }

    public static /* synthetic */ TemplateUiDataBuilder copy$default(TemplateUiDataBuilder templateUiDataBuilder, String str, Map<String, String> map, Map<String, Object> map2, Map<String, Object> map3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = templateUiDataBuilder.f30212id;
        }
        if ((i11 & 2) != 0) {
            map = templateUiDataBuilder.values;
        }
        if ((i11 & 4) != 0) {
            map2 = templateUiDataBuilder.cells;
        }
        if ((i11 & 8) != 0) {
            map3 = templateUiDataBuilder.metadata;
        }
        return templateUiDataBuilder.copy(str, map, map2, map3);
    }

    private final Expression<Object> decodeValue(PlaceholderValueDecoder<Object, ?> placeholderValueDecoder, String str, Logger logger) {
        try {
            Object obj = this.placeholderValues.get(str);
            if (obj != null) {
                if ((obj instanceof String) && StringsKt__StringsJVMKt.startsWith$default((String) obj, "$", false, 2, (Object) null)) {
                    obj = '\\' + ((String) obj);
                }
                return placeholderValueDecoder.decode(obj);
            }
            throw new NoSuchElementException('`' + str + "` placeholder value not found");
        } catch (Throwable th2) {
            LoggerKt.error(logger, th2, ErrorTypes.PLACEHOLDER, MapsKt__MapsKt.mapOf(TuplesKt.to("placeholder", str), TuplesKt.to("builder", this), TuplesKt.to("type", placeholderValueDecoder.getType()), TuplesKt.to("codec", placeholderValueDecoder.getCodec()), TuplesKt.to(StepData.ARGS, placeholderValueDecoder.getArgs())));
            return new Literal(null);
        }
    }

    @NotNull
    public final TemplateUiData build(@NotNull Map<String, ? extends PlaceholderValueDecoder<Object, ?>> map, @NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(map, "decoders");
        Intrinsics.checkNotNullParameter(logger, "logger");
        String str = this.f30212id;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), decodeValue((PlaceholderValueDecoder) entry.getValue(), (String) entry.getKey(), logger));
        }
        return new TemplateUiData(str, linkedHashMap, this.metadata);
    }

    @NotNull
    public final String component1() {
        return this.f30212id;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.values;
    }

    @NotNull
    public final Map<String, Object> component3() {
        return this.cells;
    }

    @NotNull
    public final Map<String, Object> component4() {
        return this.metadata;
    }

    @NotNull
    public final TemplateUiDataBuilder copy(@NotNull String str, @NotNull Map<String, String> map, @NotNull Map<String, ? extends Object> map2, @NotNull Map<String, ? extends Object> map3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(map, "values");
        Intrinsics.checkNotNullParameter(map2, ComponentMapper.CELLS);
        Intrinsics.checkNotNullParameter(map3, TtmlNode.TAG_METADATA);
        return new TemplateUiDataBuilder(str, map, map2, map3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemplateUiDataBuilder)) {
            return false;
        }
        TemplateUiDataBuilder templateUiDataBuilder = (TemplateUiDataBuilder) obj;
        return Intrinsics.areEqual((Object) this.f30212id, (Object) templateUiDataBuilder.f30212id) && Intrinsics.areEqual((Object) this.values, (Object) templateUiDataBuilder.values) && Intrinsics.areEqual((Object) this.cells, (Object) templateUiDataBuilder.cells) && Intrinsics.areEqual((Object) this.metadata, (Object) templateUiDataBuilder.metadata);
    }

    @NotNull
    public final Map<String, Object> getCells() {
        return this.cells;
    }

    @NotNull
    public final String getId() {
        return this.f30212id;
    }

    @NotNull
    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final Map<String, String> getValues() {
        return this.values;
    }

    public int hashCode() {
        return (((((this.f30212id.hashCode() * 31) + this.values.hashCode()) * 31) + this.cells.hashCode()) * 31) + this.metadata.hashCode();
    }

    @NotNull
    public String toString() {
        return "TemplateUiDataBuilder(id=" + this.f30212id + ", values=" + this.values + ", cells=" + this.cells + ", metadata=" + this.metadata + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TemplateUiDataBuilder(String str, Map map, Map map2, Map map3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i11 & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map2, (i11 & 8) != 0 ? MapsKt__MapsKt.emptyMap() : map3);
    }
}
