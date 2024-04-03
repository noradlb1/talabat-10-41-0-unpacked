package com.deliveryhero.fluid.template.sources;

import android.util.LruCache;
import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import com.deliveryhero.fluid.template.sources.WritableTemplateSource;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J'\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J \u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016R\u001e\u0010\u0007\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/TemplateLruMemorySource;", "Lcom/deliveryhero/fluid/template/sources/WritableTemplateSource;", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "maxTemplates", "", "(Lcom/deliveryhero/fluid/ParseConfig;I)V", "lruCache", "Landroid/util/LruCache;", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "name", "getName", "()Ljava/lang/String;", "getParseConfig", "()Lcom/deliveryhero/fluid/ParseConfig;", "get", "", "requests", "", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "write", "", "templates", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateLruMemorySource implements WritableTemplateSource {
    @NotNull
    private final LruCache<String, TemplateBuilder> lruCache;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f30228name;
    @NotNull
    private final ParseConfig parseConfig;

    public TemplateLruMemorySource(@NotNull ParseConfig parseConfig2, int i11) {
        Intrinsics.checkNotNullParameter(parseConfig2, "parseConfig");
        this.parseConfig = parseConfig2;
        this.lruCache = new TemplateLruMemorySource$special$$inlined$lruCache$default$1(i11);
        this.f30228name = "lru_memory";
    }

    @NotNull
    public TemplateBuilder get(@NotNull ReadableTemplateSource.Request request) throws Throwable {
        return WritableTemplateSource.DefaultImpls.get(this, request);
    }

    @NotNull
    public String getDebugName() {
        return WritableTemplateSource.DefaultImpls.getDebugName(this);
    }

    @NotNull
    public String getName() {
        return this.f30228name;
    }

    @NotNull
    public ParseConfig getParseConfig() {
        return this.parseConfig;
    }

    public void write(@NotNull Map<String, TemplateBuilder> map) {
        Intrinsics.checkNotNullParameter(map, "templates");
        for (Map.Entry next : map.entrySet()) {
            this.lruCache.put(next.getKey(), next.getValue());
        }
    }

    @NotNull
    public Map<String, TemplateBuilder> get(@NotNull Set<ReadableTemplateSource.Request> set) {
        Intrinsics.checkNotNullParameter(set, "requests");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10)), 16));
        for (ReadableTemplateSource.Request request : set) {
            Pair pair = TuplesKt.to(request.getId(), this.lruCache.get(request.getId()));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((TemplateBuilder) entry.getValue()) != null) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TemplateLruMemorySource(ParseConfig parseConfig2, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(parseConfig2, (i12 & 2) != 0 ? 50 : i11);
    }
}
