package tracking.events;

import com.adyen.checkout.core.model.Address;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.gem.adapters.analytics.GemApiCallEvent;
import com.visa.checkout.PurchaseInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;
import tracking.TrackingHelperKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltracking/events/ShopImpressionLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "location", "Ltracking/events/ShopImpressionLoadedEvent$LocationAttributes;", "screen", "Ltracking/events/ShopImpressionLoadedEvent$ScreenAttributes;", "swimlane", "Ltracking/events/ShopImpressionLoadedEvent$SwimlaneAttributes;", "shop", "Ltracking/events/ShopImpressionLoadedEvent$ShopAttributes;", "(Ltracking/events/ShopImpressionLoadedEvent$LocationAttributes;Ltracking/events/ShopImpressionLoadedEvent$ScreenAttributes;Ltracking/events/ShopImpressionLoadedEvent$SwimlaneAttributes;Ltracking/events/ShopImpressionLoadedEvent$ShopAttributes;)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "LocationAttributes", "ScreenAttributes", "ShopAttributes", "SwimlaneAttributes", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopImpressionLoadedEvent extends TalabatEvent {
    @NotNull
    private final LocationAttributes location;
    @NotNull
    private final ScreenAttributes screen;
    @NotNull
    private final ShopAttributes shop;
    @NotNull
    private final SwimlaneAttributes swimlane;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Ltracking/events/ShopImpressionLoadedEvent$LocationAttributes;", "", "address", "", "latitude", "longitude", "city", "area", "country", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getArea", "getCity", "getCountry", "getLatitude", "getLongitude", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LocationAttributes {
        @NotNull
        private final String address;
        @NotNull
        private final String area;
        @NotNull
        private final String city;
        @NotNull
        private final String country;
        @NotNull
        private final String latitude;
        @NotNull
        private final String longitude;

        public LocationAttributes(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
            Intrinsics.checkNotNullParameter(str, "address");
            Intrinsics.checkNotNullParameter(str2, "latitude");
            Intrinsics.checkNotNullParameter(str3, "longitude");
            Intrinsics.checkNotNullParameter(str4, Address.KEY_CITY);
            Intrinsics.checkNotNullParameter(str5, "area");
            Intrinsics.checkNotNullParameter(str6, "country");
            this.address = str;
            this.latitude = str2;
            this.longitude = str3;
            this.city = str4;
            this.area = str5;
            this.country = str6;
        }

        public static /* synthetic */ LocationAttributes copy$default(LocationAttributes locationAttributes, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = locationAttributes.address;
            }
            if ((i11 & 2) != 0) {
                str2 = locationAttributes.latitude;
            }
            String str7 = str2;
            if ((i11 & 4) != 0) {
                str3 = locationAttributes.longitude;
            }
            String str8 = str3;
            if ((i11 & 8) != 0) {
                str4 = locationAttributes.city;
            }
            String str9 = str4;
            if ((i11 & 16) != 0) {
                str5 = locationAttributes.area;
            }
            String str10 = str5;
            if ((i11 & 32) != 0) {
                str6 = locationAttributes.country;
            }
            return locationAttributes.copy(str, str7, str8, str9, str10, str6);
        }

        @NotNull
        public final String component1() {
            return this.address;
        }

        @NotNull
        public final String component2() {
            return this.latitude;
        }

        @NotNull
        public final String component3() {
            return this.longitude;
        }

        @NotNull
        public final String component4() {
            return this.city;
        }

        @NotNull
        public final String component5() {
            return this.area;
        }

        @NotNull
        public final String component6() {
            return this.country;
        }

        @NotNull
        public final LocationAttributes copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
            Intrinsics.checkNotNullParameter(str, "address");
            Intrinsics.checkNotNullParameter(str2, "latitude");
            Intrinsics.checkNotNullParameter(str3, "longitude");
            Intrinsics.checkNotNullParameter(str4, Address.KEY_CITY);
            Intrinsics.checkNotNullParameter(str5, "area");
            Intrinsics.checkNotNullParameter(str6, "country");
            return new LocationAttributes(str, str2, str3, str4, str5, str6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocationAttributes)) {
                return false;
            }
            LocationAttributes locationAttributes = (LocationAttributes) obj;
            return Intrinsics.areEqual((Object) this.address, (Object) locationAttributes.address) && Intrinsics.areEqual((Object) this.latitude, (Object) locationAttributes.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) locationAttributes.longitude) && Intrinsics.areEqual((Object) this.city, (Object) locationAttributes.city) && Intrinsics.areEqual((Object) this.area, (Object) locationAttributes.area) && Intrinsics.areEqual((Object) this.country, (Object) locationAttributes.country);
        }

        @NotNull
        public final String getAddress() {
            return this.address;
        }

        @NotNull
        public final String getArea() {
            return this.area;
        }

        @NotNull
        public final String getCity() {
            return this.city;
        }

        @NotNull
        public final String getCountry() {
            return this.country;
        }

        @NotNull
        public final String getLatitude() {
            return this.latitude;
        }

        @NotNull
        public final String getLongitude() {
            return this.longitude;
        }

        public int hashCode() {
            return (((((((((this.address.hashCode() * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode()) * 31) + this.city.hashCode()) * 31) + this.area.hashCode()) * 31) + this.country.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.address;
            String str2 = this.latitude;
            String str3 = this.longitude;
            String str4 = this.city;
            String str5 = this.area;
            String str6 = this.country;
            return "LocationAttributes(address=" + str + ", latitude=" + str2 + ", longitude=" + str3 + ", city=" + str4 + ", area=" + str5 + ", country=" + str6 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltracking/events/ShopImpressionLoadedEvent$ScreenAttributes;", "", "type", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ScreenAttributes {
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f63538name;
        @NotNull
        private final String type;

        public ScreenAttributes(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(str2, "name");
            this.type = str;
            this.f63538name = str2;
        }

        public static /* synthetic */ ScreenAttributes copy$default(ScreenAttributes screenAttributes, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = screenAttributes.type;
            }
            if ((i11 & 2) != 0) {
                str2 = screenAttributes.f63538name;
            }
            return screenAttributes.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.type;
        }

        @NotNull
        public final String component2() {
            return this.f63538name;
        }

        @NotNull
        public final ScreenAttributes copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(str2, "name");
            return new ScreenAttributes(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScreenAttributes)) {
                return false;
            }
            ScreenAttributes screenAttributes = (ScreenAttributes) obj;
            return Intrinsics.areEqual((Object) this.type, (Object) screenAttributes.type) && Intrinsics.areEqual((Object) this.f63538name, (Object) screenAttributes.f63538name);
        }

        @NotNull
        public final String getName() {
            return this.f63538name;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.f63538name.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.type;
            String str2 = this.f63538name;
            return "ScreenAttributes(type=" + str + ", name=" + str2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jw\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006-"}, d2 = {"Ltracking/events/ShopImpressionLoadedEvent$ShopAttributes;", "", "chainId", "", "chainName", "type", "id", "name", "position", "vendorSponsoringPlacement", "sponsoring", "ncrRequestToken", "clickOrigin", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChainId", "()Ljava/lang/String;", "getChainName", "getClickOrigin", "getEventOrigin", "getId", "getName", "getNcrRequestToken", "getPosition", "getSponsoring", "getType", "getVendorSponsoringPlacement", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShopAttributes {
        @NotNull
        private final String chainId;
        @NotNull
        private final String chainName;
        @NotNull
        private final String clickOrigin;
        @NotNull
        private final String eventOrigin;
        @NotNull

        /* renamed from: id  reason: collision with root package name */
        private final String f63539id;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f63540name;
        @NotNull
        private final String ncrRequestToken;
        @NotNull
        private final String position;
        @NotNull
        private final String sponsoring;
        @NotNull
        private final String type;
        @NotNull
        private final String vendorSponsoringPlacement;

        public ShopAttributes(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11) {
            Intrinsics.checkNotNullParameter(str, "chainId");
            Intrinsics.checkNotNullParameter(str2, "chainName");
            Intrinsics.checkNotNullParameter(str3, "type");
            Intrinsics.checkNotNullParameter(str4, "id");
            Intrinsics.checkNotNullParameter(str5, "name");
            Intrinsics.checkNotNullParameter(str6, "position");
            Intrinsics.checkNotNullParameter(str7, "vendorSponsoringPlacement");
            Intrinsics.checkNotNullParameter(str8, "sponsoring");
            Intrinsics.checkNotNullParameter(str9, "ncrRequestToken");
            Intrinsics.checkNotNullParameter(str10, ConstantsKt.CLICK_CLICK_ORIGIN);
            Intrinsics.checkNotNullParameter(str11, "eventOrigin");
            this.chainId = str;
            this.chainName = str2;
            this.type = str3;
            this.f63539id = str4;
            this.f63540name = str5;
            this.position = str6;
            this.vendorSponsoringPlacement = str7;
            this.sponsoring = str8;
            this.ncrRequestToken = str9;
            this.clickOrigin = str10;
            this.eventOrigin = str11;
        }

        public static /* synthetic */ ShopAttributes copy$default(ShopAttributes shopAttributes, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i11, Object obj) {
            ShopAttributes shopAttributes2 = shopAttributes;
            int i12 = i11;
            return shopAttributes.copy((i12 & 1) != 0 ? shopAttributes2.chainId : str, (i12 & 2) != 0 ? shopAttributes2.chainName : str2, (i12 & 4) != 0 ? shopAttributes2.type : str3, (i12 & 8) != 0 ? shopAttributes2.f63539id : str4, (i12 & 16) != 0 ? shopAttributes2.f63540name : str5, (i12 & 32) != 0 ? shopAttributes2.position : str6, (i12 & 64) != 0 ? shopAttributes2.vendorSponsoringPlacement : str7, (i12 & 128) != 0 ? shopAttributes2.sponsoring : str8, (i12 & 256) != 0 ? shopAttributes2.ncrRequestToken : str9, (i12 & 512) != 0 ? shopAttributes2.clickOrigin : str10, (i12 & 1024) != 0 ? shopAttributes2.eventOrigin : str11);
        }

        @NotNull
        public final String component1() {
            return this.chainId;
        }

        @NotNull
        public final String component10() {
            return this.clickOrigin;
        }

        @NotNull
        public final String component11() {
            return this.eventOrigin;
        }

        @NotNull
        public final String component2() {
            return this.chainName;
        }

        @NotNull
        public final String component3() {
            return this.type;
        }

        @NotNull
        public final String component4() {
            return this.f63539id;
        }

        @NotNull
        public final String component5() {
            return this.f63540name;
        }

        @NotNull
        public final String component6() {
            return this.position;
        }

        @NotNull
        public final String component7() {
            return this.vendorSponsoringPlacement;
        }

        @NotNull
        public final String component8() {
            return this.sponsoring;
        }

        @NotNull
        public final String component9() {
            return this.ncrRequestToken;
        }

        @NotNull
        public final ShopAttributes copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11) {
            Intrinsics.checkNotNullParameter(str, "chainId");
            Intrinsics.checkNotNullParameter(str2, "chainName");
            String str12 = str3;
            Intrinsics.checkNotNullParameter(str12, "type");
            String str13 = str4;
            Intrinsics.checkNotNullParameter(str13, "id");
            String str14 = str5;
            Intrinsics.checkNotNullParameter(str14, "name");
            String str15 = str6;
            Intrinsics.checkNotNullParameter(str15, "position");
            String str16 = str7;
            Intrinsics.checkNotNullParameter(str16, "vendorSponsoringPlacement");
            String str17 = str8;
            Intrinsics.checkNotNullParameter(str17, "sponsoring");
            String str18 = str9;
            Intrinsics.checkNotNullParameter(str18, "ncrRequestToken");
            String str19 = str10;
            Intrinsics.checkNotNullParameter(str19, ConstantsKt.CLICK_CLICK_ORIGIN);
            String str20 = str11;
            Intrinsics.checkNotNullParameter(str20, "eventOrigin");
            return new ShopAttributes(str, str2, str12, str13, str14, str15, str16, str17, str18, str19, str20);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShopAttributes)) {
                return false;
            }
            ShopAttributes shopAttributes = (ShopAttributes) obj;
            return Intrinsics.areEqual((Object) this.chainId, (Object) shopAttributes.chainId) && Intrinsics.areEqual((Object) this.chainName, (Object) shopAttributes.chainName) && Intrinsics.areEqual((Object) this.type, (Object) shopAttributes.type) && Intrinsics.areEqual((Object) this.f63539id, (Object) shopAttributes.f63539id) && Intrinsics.areEqual((Object) this.f63540name, (Object) shopAttributes.f63540name) && Intrinsics.areEqual((Object) this.position, (Object) shopAttributes.position) && Intrinsics.areEqual((Object) this.vendorSponsoringPlacement, (Object) shopAttributes.vendorSponsoringPlacement) && Intrinsics.areEqual((Object) this.sponsoring, (Object) shopAttributes.sponsoring) && Intrinsics.areEqual((Object) this.ncrRequestToken, (Object) shopAttributes.ncrRequestToken) && Intrinsics.areEqual((Object) this.clickOrigin, (Object) shopAttributes.clickOrigin) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) shopAttributes.eventOrigin);
        }

        @NotNull
        public final String getChainId() {
            return this.chainId;
        }

        @NotNull
        public final String getChainName() {
            return this.chainName;
        }

        @NotNull
        public final String getClickOrigin() {
            return this.clickOrigin;
        }

        @NotNull
        public final String getEventOrigin() {
            return this.eventOrigin;
        }

        @NotNull
        public final String getId() {
            return this.f63539id;
        }

        @NotNull
        public final String getName() {
            return this.f63540name;
        }

        @NotNull
        public final String getNcrRequestToken() {
            return this.ncrRequestToken;
        }

        @NotNull
        public final String getPosition() {
            return this.position;
        }

        @NotNull
        public final String getSponsoring() {
            return this.sponsoring;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final String getVendorSponsoringPlacement() {
            return this.vendorSponsoringPlacement;
        }

        public int hashCode() {
            return (((((((((((((((((((this.chainId.hashCode() * 31) + this.chainName.hashCode()) * 31) + this.type.hashCode()) * 31) + this.f63539id.hashCode()) * 31) + this.f63540name.hashCode()) * 31) + this.position.hashCode()) * 31) + this.vendorSponsoringPlacement.hashCode()) * 31) + this.sponsoring.hashCode()) * 31) + this.ncrRequestToken.hashCode()) * 31) + this.clickOrigin.hashCode()) * 31) + this.eventOrigin.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.chainId;
            String str2 = this.chainName;
            String str3 = this.type;
            String str4 = this.f63539id;
            String str5 = this.f63540name;
            String str6 = this.position;
            String str7 = this.vendorSponsoringPlacement;
            String str8 = this.sponsoring;
            String str9 = this.ncrRequestToken;
            String str10 = this.clickOrigin;
            String str11 = this.eventOrigin;
            return "ShopAttributes(chainId=" + str + ", chainName=" + str2 + ", type=" + str3 + ", id=" + str4 + ", name=" + str5 + ", position=" + str6 + ", vendorSponsoringPlacement=" + str7 + ", sponsoring=" + str8 + ", ncrRequestToken=" + str9 + ", clickOrigin=" + str10 + ", eventOrigin=" + str11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, d2 = {"Ltracking/events/ShopImpressionLoadedEvent$SwimlaneAttributes;", "", "title", "", "titleList", "total", "position", "strategy", "strategyList", "tilesDisplayed", "length", "requestId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLength", "()Ljava/lang/String;", "getPosition", "getRequestId", "getStrategy", "getStrategyList", "getTilesDisplayed", "getTitle", "getTitleList", "getTotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SwimlaneAttributes {
        @NotNull
        private final String length;
        @NotNull
        private final String position;
        @NotNull
        private final String requestId;
        @NotNull
        private final String strategy;
        @NotNull
        private final String strategyList;
        @NotNull
        private final String tilesDisplayed;
        @NotNull
        private final String title;
        @NotNull
        private final String titleList;
        @NotNull
        private final String total;

        public SwimlaneAttributes(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "titleList");
            Intrinsics.checkNotNullParameter(str3, PurchaseInfo.TOTAL);
            Intrinsics.checkNotNullParameter(str4, "position");
            Intrinsics.checkNotNullParameter(str5, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
            Intrinsics.checkNotNullParameter(str6, "strategyList");
            Intrinsics.checkNotNullParameter(str7, "tilesDisplayed");
            Intrinsics.checkNotNullParameter(str8, "length");
            Intrinsics.checkNotNullParameter(str9, PurchaseInfo.REQUEST_ID);
            this.title = str;
            this.titleList = str2;
            this.total = str3;
            this.position = str4;
            this.strategy = str5;
            this.strategyList = str6;
            this.tilesDisplayed = str7;
            this.length = str8;
            this.requestId = str9;
        }

        public static /* synthetic */ SwimlaneAttributes copy$default(SwimlaneAttributes swimlaneAttributes, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i11, Object obj) {
            SwimlaneAttributes swimlaneAttributes2 = swimlaneAttributes;
            int i12 = i11;
            return swimlaneAttributes.copy((i12 & 1) != 0 ? swimlaneAttributes2.title : str, (i12 & 2) != 0 ? swimlaneAttributes2.titleList : str2, (i12 & 4) != 0 ? swimlaneAttributes2.total : str3, (i12 & 8) != 0 ? swimlaneAttributes2.position : str4, (i12 & 16) != 0 ? swimlaneAttributes2.strategy : str5, (i12 & 32) != 0 ? swimlaneAttributes2.strategyList : str6, (i12 & 64) != 0 ? swimlaneAttributes2.tilesDisplayed : str7, (i12 & 128) != 0 ? swimlaneAttributes2.length : str8, (i12 & 256) != 0 ? swimlaneAttributes2.requestId : str9);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final String component2() {
            return this.titleList;
        }

        @NotNull
        public final String component3() {
            return this.total;
        }

        @NotNull
        public final String component4() {
            return this.position;
        }

        @NotNull
        public final String component5() {
            return this.strategy;
        }

        @NotNull
        public final String component6() {
            return this.strategyList;
        }

        @NotNull
        public final String component7() {
            return this.tilesDisplayed;
        }

        @NotNull
        public final String component8() {
            return this.length;
        }

        @NotNull
        public final String component9() {
            return this.requestId;
        }

        @NotNull
        public final SwimlaneAttributes copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "titleList");
            Intrinsics.checkNotNullParameter(str3, PurchaseInfo.TOTAL);
            Intrinsics.checkNotNullParameter(str4, "position");
            String str10 = str5;
            Intrinsics.checkNotNullParameter(str10, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
            String str11 = str6;
            Intrinsics.checkNotNullParameter(str11, "strategyList");
            String str12 = str7;
            Intrinsics.checkNotNullParameter(str12, "tilesDisplayed");
            String str13 = str8;
            Intrinsics.checkNotNullParameter(str13, "length");
            String str14 = str9;
            Intrinsics.checkNotNullParameter(str14, PurchaseInfo.REQUEST_ID);
            return new SwimlaneAttributes(str, str2, str3, str4, str10, str11, str12, str13, str14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SwimlaneAttributes)) {
                return false;
            }
            SwimlaneAttributes swimlaneAttributes = (SwimlaneAttributes) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) swimlaneAttributes.title) && Intrinsics.areEqual((Object) this.titleList, (Object) swimlaneAttributes.titleList) && Intrinsics.areEqual((Object) this.total, (Object) swimlaneAttributes.total) && Intrinsics.areEqual((Object) this.position, (Object) swimlaneAttributes.position) && Intrinsics.areEqual((Object) this.strategy, (Object) swimlaneAttributes.strategy) && Intrinsics.areEqual((Object) this.strategyList, (Object) swimlaneAttributes.strategyList) && Intrinsics.areEqual((Object) this.tilesDisplayed, (Object) swimlaneAttributes.tilesDisplayed) && Intrinsics.areEqual((Object) this.length, (Object) swimlaneAttributes.length) && Intrinsics.areEqual((Object) this.requestId, (Object) swimlaneAttributes.requestId);
        }

        @NotNull
        public final String getLength() {
            return this.length;
        }

        @NotNull
        public final String getPosition() {
            return this.position;
        }

        @NotNull
        public final String getRequestId() {
            return this.requestId;
        }

        @NotNull
        public final String getStrategy() {
            return this.strategy;
        }

        @NotNull
        public final String getStrategyList() {
            return this.strategyList;
        }

        @NotNull
        public final String getTilesDisplayed() {
            return this.tilesDisplayed;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getTitleList() {
            return this.titleList;
        }

        @NotNull
        public final String getTotal() {
            return this.total;
        }

        public int hashCode() {
            return (((((((((((((((this.title.hashCode() * 31) + this.titleList.hashCode()) * 31) + this.total.hashCode()) * 31) + this.position.hashCode()) * 31) + this.strategy.hashCode()) * 31) + this.strategyList.hashCode()) * 31) + this.tilesDisplayed.hashCode()) * 31) + this.length.hashCode()) * 31) + this.requestId.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.title;
            String str2 = this.titleList;
            String str3 = this.total;
            String str4 = this.position;
            String str5 = this.strategy;
            String str6 = this.strategyList;
            String str7 = this.tilesDisplayed;
            String str8 = this.length;
            String str9 = this.requestId;
            return "SwimlaneAttributes(title=" + str + ", titleList=" + str2 + ", total=" + str3 + ", position=" + str4 + ", strategy=" + str5 + ", strategyList=" + str6 + ", tilesDisplayed=" + str7 + ", length=" + str8 + ", requestId=" + str9 + ")";
        }
    }

    public ShopImpressionLoadedEvent(@NotNull LocationAttributes locationAttributes, @NotNull ScreenAttributes screenAttributes, @NotNull SwimlaneAttributes swimlaneAttributes, @NotNull ShopAttributes shopAttributes) {
        Intrinsics.checkNotNullParameter(locationAttributes, "location");
        Intrinsics.checkNotNullParameter(screenAttributes, "screen");
        Intrinsics.checkNotNullParameter(swimlaneAttributes, "swimlane");
        Intrinsics.checkNotNullParameter(shopAttributes, "shop");
        this.location = locationAttributes;
        this.screen = screenAttributes;
        this.swimlane = swimlaneAttributes;
        this.shop = shopAttributes;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("userId", TrackingHelperKt.getUserId());
        linkedHashMap.put("userTimeStamp", TrackingHelperKt.getUserTimestamp());
        linkedHashMap.put("locationAddress", this.location.getAddress());
        linkedHashMap.put("locationLat", this.location.getLatitude());
        linkedHashMap.put("locationLon", this.location.getLongitude());
        linkedHashMap.put("locationCity", this.location.getCity());
        linkedHashMap.put("locationArea", this.location.getArea());
        linkedHashMap.put("locationCountry", this.location.getCountry());
        linkedHashMap.put("screenType", this.screen.getType());
        linkedHashMap.put("screenName", this.screen.getName());
        linkedHashMap.put("swimlaneTitle", this.swimlane.getTitle());
        linkedHashMap.put("swimlaneTitleList", this.swimlane.getTitleList());
        linkedHashMap.put("swimlaneTotal", this.swimlane.getTotal());
        linkedHashMap.put("swimlanePosition", this.swimlane.getPosition());
        linkedHashMap.put("swimlaneStrategy", this.swimlane.getStrategy());
        linkedHashMap.put("swimlaneStrategyList", this.swimlane.getStrategyList());
        linkedHashMap.put("swimlaneTilesDisplayed", this.swimlane.getTilesDisplayed());
        linkedHashMap.put("swimlaneLength", this.swimlane.getLength());
        linkedHashMap.put("swimlaneRequestId", this.swimlane.getRequestId());
        linkedHashMap.put("chainName", this.shop.getChainName());
        linkedHashMap.put("chainId", this.shop.getChainId());
        linkedHashMap.put("shopType", this.shop.getType());
        linkedHashMap.put("shopId", this.shop.getId());
        linkedHashMap.put("shopName", this.shop.getName());
        linkedHashMap.put("shopPosition", this.shop.getPosition());
        linkedHashMap.put("shopSponsoring", this.shop.getSponsoring());
        linkedHashMap.put("shopClickOrigin", this.shop.getClickOrigin());
        linkedHashMap.put("eventOrigin", this.shop.getEventOrigin());
        linkedHashMap.put("ncrRequestToken", this.shop.getNcrRequestToken());
        linkedHashMap.put("vendorSponsoringPlacement", this.shop.getVendorSponsoringPlacement());
        return linkedHashMap;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return GemApiCallEvent.FEATURE_NAME;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "shop_impressions_loaded";
    }
}
