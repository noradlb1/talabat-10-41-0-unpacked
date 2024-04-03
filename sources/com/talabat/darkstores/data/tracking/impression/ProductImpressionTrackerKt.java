package com.talabat.darkstores.data.tracking.impression;

import com.talabat.darkstores.model.Banner;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import com.talabat.talabatcommon.extentions.StringUtils;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0017*\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u001b"}, d2 = {"BANNER", "", "BANNER_IMPRESSION_EVENT_NAME", "FEATURE_NAME", "KEY_BANNER_ID", "KEY_BANNER_NAME", "KEY_BANNER_POSITION", "KEY_BANNER_TYPE", "KEY_EVENT_NAME", "KEY_EVENT_ORIGIN", "KEY_FEATURE_NAME", "KEY_NMR_AD_ID", "KEY_SHOP_SPONSORING", "KEY_SHOP_SPONSORING_PLACEMENT", "KEY_SWIMLANE_REQUEST_ID", "KEY_SWIMLANE_STRATEGY", "KEY_SWIMLANE_STRATEGY_LIST", "VALUE_SHOP_SPONSORING_PLACEMENT", "VALUE_SWIMLANE", "isSponsoredCapitalized", "Lcom/talabat/darkstores/model/Banner;", "(Lcom/talabat/darkstores/model/Banner;)Ljava/lang/String;", "nmrAdClickEventData", "", "position", "", "bannerType", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ProductImpressionTrackerKt {
    @NotNull
    private static final String BANNER = "banner";
    @NotNull
    private static final String BANNER_IMPRESSION_EVENT_NAME = "banner_impressions_loaded";
    @NotNull
    private static final String FEATURE_NAME = "darkstores";
    @NotNull
    private static final String KEY_BANNER_ID = "bannerId";
    @NotNull
    private static final String KEY_BANNER_NAME = "bannerName";
    @NotNull
    private static final String KEY_BANNER_POSITION = "bannerPosition";
    @NotNull
    private static final String KEY_BANNER_TYPE = "bannerType";
    @NotNull
    private static final String KEY_EVENT_NAME = "eventName";
    @NotNull
    private static final String KEY_EVENT_ORIGIN = "eventOrigin";
    @NotNull
    private static final String KEY_FEATURE_NAME = "featureName";
    @NotNull
    private static final String KEY_NMR_AD_ID = "nmrAdId";
    @NotNull
    private static final String KEY_SHOP_SPONSORING = "shopSponsoring";
    @NotNull
    private static final String KEY_SHOP_SPONSORING_PLACEMENT = "shopSponsoringPlacement";
    @NotNull
    private static final String KEY_SWIMLANE_REQUEST_ID = "swimlaneRequestId";
    @NotNull
    private static final String KEY_SWIMLANE_STRATEGY = "swimlaneStrategy";
    @NotNull
    private static final String KEY_SWIMLANE_STRATEGY_LIST = "swimlaneStrategyList";
    @NotNull
    private static final String VALUE_SHOP_SPONSORING_PLACEMENT = "storefront:swimlane";
    @NotNull
    private static final String VALUE_SWIMLANE = "swimlane";

    @NotNull
    public static final String isSponsoredCapitalized(@NotNull Banner banner) {
        boolean z11;
        String str;
        Intrinsics.checkNotNullParameter(banner, "<this>");
        String valueOf = String.valueOf(banner.isSponsored());
        if (valueOf.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            StringBuilder sb2 = new StringBuilder();
            char charAt = valueOf.charAt(0);
            if (Character.isLowerCase(charAt)) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                str = CharsKt__CharJVMKt.titlecase(charAt, locale);
            } else {
                str = String.valueOf(charAt);
            }
            sb2.append(str);
            String substring = valueOf.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            sb2.append(substring);
            valueOf = sb2.toString();
        }
        return valueOf + ":nmr_NA__NA";
    }

    @NotNull
    public static final Map<String, String> nmrAdClickEventData(@NotNull Banner banner, int i11, @NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(banner, "<this>");
        Intrinsics.checkNotNullParameter(str, "bannerType");
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("bannerId", banner.getGlobalId());
        pairArr[1] = TuplesKt.to("bannerName", banner.getName());
        pairArr[2] = TuplesKt.to("bannerType", str);
        pairArr[3] = TuplesKt.to("bannerPosition", String.valueOf(i11));
        Tracking tracking2 = banner.getTracking();
        if (tracking2 == null || (str2 = tracking2.getNmrAdId()) == null) {
            str2 = StringUtils.notAvailable(StringCompanionObject.INSTANCE);
        }
        pairArr[4] = TuplesKt.to("nmrAdId", str2);
        pairArr[5] = TuplesKt.to("shopSponsoring", isSponsoredCapitalized(banner));
        return MapsKt__MapsKt.mapOf(pairArr);
    }
}
