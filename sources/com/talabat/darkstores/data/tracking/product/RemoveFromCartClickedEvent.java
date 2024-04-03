package com.talabat.darkstores.data.tracking.product;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005HÂ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005HÂ\u0003JC\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/data/tracking/product/RemoveFromCartClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "storeInfoParams", "", "", "", "additionalParams", "(Lcom/talabat/feature/darkstorescart/data/model/Product;Ljava/util/Map;Ljava/util/Map;)V", "attributes", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RemoveFromCartClickedEvent extends TalabatEvent {
    @NotNull
    private final Map<String, Object> additionalParams;
    @NotNull
    private final Product product;
    @NotNull
    private final Map<String, Object> storeInfoParams;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RemoveFromCartClickedEvent(Product product2, Map map, Map map2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(product2, map, (i11 & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map2);
    }

    private final Product component1() {
        return this.product;
    }

    private final Map<String, Object> component2() {
        return this.storeInfoParams;
    }

    private final Map<String, Object> component3() {
        return this.additionalParams;
    }

    public static /* synthetic */ RemoveFromCartClickedEvent copy$default(RemoveFromCartClickedEvent removeFromCartClickedEvent, Product product2, Map<String, Object> map, Map<String, Object> map2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            product2 = removeFromCartClickedEvent.product;
        }
        if ((i11 & 2) != 0) {
            map = removeFromCartClickedEvent.storeInfoParams;
        }
        if ((i11 & 4) != 0) {
            map2 = removeFromCartClickedEvent.additionalParams;
        }
        return removeFromCartClickedEvent.copy(product2, map, map2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.plus(MapsKt__MapsKt.plus(this.storeInfoParams, (Map<String, Object>) ProductEventsKt.getTrackingData(this.product)), (Map) this.additionalParams);
    }

    @NotNull
    public final RemoveFromCartClickedEvent copy(@NotNull Product product2, @NotNull Map<String, ? extends Object> map, @NotNull Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(product2, "product");
        Intrinsics.checkNotNullParameter(map, "storeInfoParams");
        Intrinsics.checkNotNullParameter(map2, "additionalParams");
        return new RemoveFromCartClickedEvent(product2, map, map2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoveFromCartClickedEvent)) {
            return false;
        }
        RemoveFromCartClickedEvent removeFromCartClickedEvent = (RemoveFromCartClickedEvent) obj;
        return Intrinsics.areEqual((Object) this.product, (Object) removeFromCartClickedEvent.product) && Intrinsics.areEqual((Object) this.storeInfoParams, (Object) removeFromCartClickedEvent.storeInfoParams) && Intrinsics.areEqual((Object) this.additionalParams, (Object) removeFromCartClickedEvent.additionalParams);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    public int hashCode() {
        return (((this.product.hashCode() * 31) + this.storeInfoParams.hashCode()) * 31) + this.additionalParams.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "remove_from_cart";
    }

    @NotNull
    public String toString() {
        Product product2 = this.product;
        Map<String, Object> map = this.storeInfoParams;
        Map<String, Object> map2 = this.additionalParams;
        return "RemoveFromCartClickedEvent(product=" + product2 + ", storeInfoParams=" + map + ", additionalParams=" + map2 + ")";
    }

    public RemoveFromCartClickedEvent(@NotNull Product product2, @NotNull Map<String, ? extends Object> map, @NotNull Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(product2, "product");
        Intrinsics.checkNotNullParameter(map, "storeInfoParams");
        Intrinsics.checkNotNullParameter(map2, "additionalParams");
        this.product = product2;
        this.storeInfoParams = map;
        this.additionalParams = map2;
    }
}
