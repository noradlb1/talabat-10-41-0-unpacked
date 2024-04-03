package library.talabat.mvp.checkout.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Llibrary/talabat/mvp/checkout/tracking/PickupBrazeCheckoutLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "restaurantName", "", "restaurantCuisine", "cartValue", "", "(Ljava/lang/String;Ljava/lang/String;D)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupBrazeCheckoutLoadedEvent extends TalabatEvent {
    @NotNull
    public static final String CART_VALUE = "cart_value";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "app_pickup_checkout_load";
    @NotNull
    public static final String FEATURE_NAME = "pickup";
    @NotNull
    public static final String RESTAURANT_CUISINES = "restaurant_cuisine";
    @NotNull
    public static final String RESTAURANT_NAME = "restaurant_name";
    private final double cartValue;
    @NotNull
    private final String restaurantCuisine;
    @NotNull
    private final String restaurantName;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Llibrary/talabat/mvp/checkout/tracking/PickupBrazeCheckoutLoadedEvent$Companion;", "", "()V", "CART_VALUE", "", "EVENT_NAME", "FEATURE_NAME", "RESTAURANT_CUISINES", "RESTAURANT_NAME", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PickupBrazeCheckoutLoadedEvent(@NotNull String str, @NotNull String str2, double d11) {
        Intrinsics.checkNotNullParameter(str, "restaurantName");
        Intrinsics.checkNotNullParameter(str2, "restaurantCuisine");
        this.restaurantName = str;
        this.restaurantCuisine = str2;
        this.cartValue = d11;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("restaurant_name", this.restaurantName), TuplesKt.to("restaurant_cuisine", this.restaurantCuisine), TuplesKt.to(CART_VALUE, Double.valueOf(this.cartValue)));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pickup";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.BRAZE);
    }
}
