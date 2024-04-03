package com.deliveryhero.fluid.widgets.collections;

import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.fluid.template.Template;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0005¢\u0006\u0002\u0010\tJ\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\u0019\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0005HÂ\u0003J-\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010\u0010\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u0007j\u0002`\bJ\u0012\u0010\u0012\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0013\u001a\u00020\u0006J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/CollectionState;", "", "viewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "viewTypes", "", "Lcom/deliveryhero/fluid/template/Template;", "", "Lcom/deliveryhero/fluid/widgets/collections/ViewType;", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Ljava/util/Map;)V", "component1", "component2", "copy", "equals", "", "other", "getTemplate", "viewType", "getViewType", "template", "hashCode", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionState {
    @NotNull
    private final RecyclerView.RecycledViewPool viewPool;
    @NotNull
    private final Map<Template, Integer> viewTypes;

    public CollectionState() {
        this((RecyclerView.RecycledViewPool) null, (Map) null, 3, (DefaultConstructorMarker) null);
    }

    public CollectionState(@NotNull RecyclerView.RecycledViewPool recycledViewPool, @NotNull Map<Template, Integer> map) {
        Intrinsics.checkNotNullParameter(recycledViewPool, "viewPool");
        Intrinsics.checkNotNullParameter(map, "viewTypes");
        this.viewPool = recycledViewPool;
        this.viewTypes = map;
    }

    private final RecyclerView.RecycledViewPool component1() {
        return this.viewPool;
    }

    private final Map<Template, Integer> component2() {
        return this.viewTypes;
    }

    public static /* synthetic */ CollectionState copy$default(CollectionState collectionState, RecyclerView.RecycledViewPool recycledViewPool, Map<Template, Integer> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            recycledViewPool = collectionState.viewPool;
        }
        if ((i11 & 2) != 0) {
            map = collectionState.viewTypes;
        }
        return collectionState.copy(recycledViewPool, map);
    }

    @NotNull
    public final CollectionState copy(@NotNull RecyclerView.RecycledViewPool recycledViewPool, @NotNull Map<Template, Integer> map) {
        Intrinsics.checkNotNullParameter(recycledViewPool, "viewPool");
        Intrinsics.checkNotNullParameter(map, "viewTypes");
        return new CollectionState(recycledViewPool, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectionState)) {
            return false;
        }
        CollectionState collectionState = (CollectionState) obj;
        return Intrinsics.areEqual((Object) this.viewPool, (Object) collectionState.viewPool) && Intrinsics.areEqual((Object) this.viewTypes, (Object) collectionState.viewTypes);
    }

    @NotNull
    public final Template getTemplate(int i11) {
        boolean z11;
        for (Map.Entry entry : this.viewTypes.entrySet()) {
            if (((Number) entry.getValue()).intValue() == i11) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                return (Template) entry.getKey();
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final int getViewType(@NotNull Template template) {
        Intrinsics.checkNotNullParameter(template, "template");
        Map<Template, Integer> map = this.viewTypes;
        Integer num = map.get(template);
        if (num == null) {
            num = Integer.valueOf(this.viewTypes.size() + 1);
            map.put(template, num);
        }
        return num.intValue();
    }

    public int hashCode() {
        return (this.viewPool.hashCode() * 31) + this.viewTypes.hashCode();
    }

    @NotNull
    public String toString() {
        return "CollectionState(viewPool=" + this.viewPool + ", viewTypes=" + this.viewTypes + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CollectionState(RecyclerView.RecycledViewPool recycledViewPool, Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new RecyclerView.RecycledViewPool() : recycledViewPool, (i11 & 2) != 0 ? new LinkedHashMap() : map);
    }
}
