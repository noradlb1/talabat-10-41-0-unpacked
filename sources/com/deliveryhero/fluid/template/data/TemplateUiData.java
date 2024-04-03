package com.deliveryhero.fluid.template.data;

import com.deliveryhero.fluid.expression.Expression;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0005HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\bHÆ\u0003JI\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "", "id", "", "placeholderValues", "", "Lcom/deliveryhero/fluid/expression/Expression;", "metadata", "Lcom/deliveryhero/fluid/template/data/TemplateMetadata;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getMetadata", "()Ljava/util/Map;", "getPlaceholderValues", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateUiData {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f30211id;
    @NotNull
    private final Map<String, Object> metadata;
    @NotNull
    private final Map<String, Expression<Object>> placeholderValues;

    public TemplateUiData(@NotNull String str, @NotNull Map<String, ? extends Expression<Object>> map, @NotNull Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(map, "placeholderValues");
        Intrinsics.checkNotNullParameter(map2, TtmlNode.TAG_METADATA);
        this.f30211id = str;
        this.placeholderValues = map;
        this.metadata = map2;
    }

    public static /* synthetic */ TemplateUiData copy$default(TemplateUiData templateUiData, String str, Map<String, Expression<Object>> map, Map<String, Object> map2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = templateUiData.f30211id;
        }
        if ((i11 & 2) != 0) {
            map = templateUiData.placeholderValues;
        }
        if ((i11 & 4) != 0) {
            map2 = templateUiData.metadata;
        }
        return templateUiData.copy(str, map, map2);
    }

    @NotNull
    public final String component1() {
        return this.f30211id;
    }

    @NotNull
    public final Map<String, Expression<Object>> component2() {
        return this.placeholderValues;
    }

    @NotNull
    public final Map<String, Object> component3() {
        return this.metadata;
    }

    @NotNull
    public final TemplateUiData copy(@NotNull String str, @NotNull Map<String, ? extends Expression<Object>> map, @NotNull Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(map, "placeholderValues");
        Intrinsics.checkNotNullParameter(map2, TtmlNode.TAG_METADATA);
        return new TemplateUiData(str, map, map2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemplateUiData)) {
            return false;
        }
        TemplateUiData templateUiData = (TemplateUiData) obj;
        return Intrinsics.areEqual((Object) this.f30211id, (Object) templateUiData.f30211id) && Intrinsics.areEqual((Object) this.placeholderValues, (Object) templateUiData.placeholderValues) && Intrinsics.areEqual((Object) this.metadata, (Object) templateUiData.metadata);
    }

    @NotNull
    public final String getId() {
        return this.f30211id;
    }

    @NotNull
    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final Map<String, Expression<Object>> getPlaceholderValues() {
        return this.placeholderValues;
    }

    public int hashCode() {
        return (((this.f30211id.hashCode() * 31) + this.placeholderValues.hashCode()) * 31) + this.metadata.hashCode();
    }

    @NotNull
    public String toString() {
        return "TemplateUiData(id=" + this.f30211id + ", placeholderValues=" + this.placeholderValues + ", metadata=" + this.metadata + ')';
    }
}
