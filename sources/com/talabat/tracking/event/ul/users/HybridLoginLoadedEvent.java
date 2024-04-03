package com.talabat.tracking.event.ul.users;

import com.talabat.configuration.country.Country;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.domain.address.Address;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.jetbrains.annotations.NotNull;
import tracking.ScreenNames;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u001a\u0012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/tracking/event/ul/users/HybridLoginLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "originEvent", "", "Lorg/jetbrains/annotations/NotNull;", "country", "Lcom/talabat/configuration/country/Country;", "(Ljava/lang/String;Lcom/talabat/configuration/country/Country;)V", "getCountry", "()Lcom/talabat/configuration/country/Country;", "getOriginEvent", "()Ljava/lang/String;", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HybridLoginLoadedEvent extends TalabatEvent {
    @NotNull
    private final Country country;
    @NotNull
    private final String originEvent;

    public HybridLoginLoadedEvent(@NotNull String str, @NotNull Country country2) {
        Intrinsics.checkNotNullParameter(str, "originEvent");
        Intrinsics.checkNotNullParameter(country2, "country");
        this.originEvent = str;
        this.country = country2;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Integer num;
        Integer num2;
        Double d11;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[9];
        pairArr[0] = TuplesKt.to("screenType", ScreenNames.getScreenType(ScreenNames.LOGIN_SCREEN));
        pairArr[1] = TuplesKt.to("screenName", ScreenNames.LOGIN_SCREEN);
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        Address tempAddress = homeMapTemp.getTempAddress();
        Double d12 = null;
        if (tempAddress != null) {
            num = Integer.valueOf(tempAddress.cityId);
        } else {
            num = null;
        }
        pairArr[2] = TuplesKt.to("locationCity", num);
        Address tempAddress2 = homeMapTemp.getTempAddress();
        if (tempAddress2 != null) {
            num2 = Integer.valueOf(tempAddress2.areaId);
        } else {
            num2 = null;
        }
        pairArr[3] = TuplesKt.to("locationArea", num2);
        String upperCase = this.country.getThreeLetterCode().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        pairArr[4] = TuplesKt.to("locationCountry", upperCase);
        Address tempAddress3 = homeMapTemp.getTempAddress();
        if (tempAddress3 != null) {
            d11 = Double.valueOf(tempAddress3.latitude);
        } else {
            d11 = null;
        }
        pairArr[5] = TuplesKt.to("locationLat", d11);
        Address tempAddress4 = homeMapTemp.getTempAddress();
        if (tempAddress4 != null) {
            d12 = Double.valueOf(tempAddress4.longitude);
        }
        pairArr[6] = TuplesKt.to("locationLon", d12);
        pairArr[7] = TuplesKt.to("userLoggedIn", Boolean.FALSE);
        pairArr[8] = TuplesKt.to("eventOrigin", this.originEvent);
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "talabat";
    }

    @NotNull
    public final Country getCountry() {
        return this.country;
    }

    @NotNull
    public final String getOriginEvent() {
        return this.originEvent;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "hybrid_login_loaded";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }
}
