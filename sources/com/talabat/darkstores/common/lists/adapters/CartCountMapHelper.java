package com.talabat.darkstores.common.lists.adapters;

import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00032\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002J5\u0010\u0015\u001a\u00020\u00162\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00032\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R<\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/common/lists/adapters/CartCountMapHelper;", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "value", "", "", "", "cartCountMap", "getCartCountMap", "()Ljava/util/Map;", "setCartCountMap", "(Ljava/util/Map;)V", "positionMap", "", "getPositionMap", "getValue", "cartMapProductListAdapter", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "map", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartCountMapHelper {
    @NotNull
    private final RecyclerView.Adapter<?> adapter;
    @NotNull
    private Map<String, Integer> cartCountMap = MapsKt__MapsKt.emptyMap();
    @NotNull
    private final Map<String, Integer> positionMap = new LinkedHashMap();

    public CartCountMapHelper(@NotNull RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "adapter");
        this.adapter = adapter2;
    }

    @NotNull
    public final Map<String, Integer> getCartCountMap() {
        return this.cartCountMap;
    }

    @NotNull
    public final Map<String, Integer> getPositionMap() {
        return this.positionMap;
    }

    @NotNull
    public final Map<String, Integer> getValue(@NotNull RecyclerView.Adapter<?> adapter2, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(adapter2, "cartMapProductListAdapter");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.cartCountMap;
    }

    public final void setCartCountMap(@NotNull Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (!Intrinsics.areEqual((Object) this.cartCountMap.get(str), (Object) map.get(str))) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (String str2 : linkedHashMap.keySet()) {
            Integer num = this.positionMap.get(str2);
            if (num != null) {
                this.adapter.notifyItemChanged(num.intValue(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("count", map.get(str2))));
            }
        }
        Map<String, Integer> map2 = this.cartCountMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry next2 : map2.entrySet()) {
            if (!map.containsKey((String) next2.getKey())) {
                linkedHashMap2.put(next2.getKey(), next2.getValue());
            }
        }
        for (String str3 : linkedHashMap2.keySet()) {
            Integer num2 = this.positionMap.get(str3);
            if (num2 != null) {
                this.adapter.notifyItemChanged(num2.intValue(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("count", 0)));
            }
        }
        this.cartCountMap = map;
    }

    public final void setValue(@NotNull RecyclerView.Adapter<?> adapter2, @NotNull KProperty<?> kProperty, @NotNull Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(adapter2, "cartMapProductListAdapter");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        setCartCountMap(map);
    }
}
