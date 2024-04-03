package com.talabat.feature.tpro.presentation.util;

import android.content.res.Resources;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\b\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/tpro/presentation/util/TproImageResources;", "", "isQaEnvironment", "", "countryIso3166", "", "isRTL", "(ZLjava/lang/String;Z)V", "baseUrl", "benefitsUrl", "appendPathBasedOnConfigs", "getBenefitsHeaderImage", "res", "Landroid/content/res/Resources;", "imageName", "getResourceSize", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproImageResources {
    @NotNull
    private final String baseUrl;
    @NotNull
    private final String benefitsUrl;
    @NotNull
    private final String countryIso3166;
    private final boolean isQaEnvironment;
    private final boolean isRTL;

    public TproImageResources() {
        this(false, (String) null, false, 7, (DefaultConstructorMarker) null);
    }

    public TproImageResources(boolean z11, @NotNull String str, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "countryIso3166");
        this.isQaEnvironment = z11;
        this.countryIso3166 = str;
        this.isRTL = z12;
        this.baseUrl = "https://images.deliveryhero.io/image/talabat/TPro";
        this.benefitsUrl = "https://images.deliveryhero.io/image/talabat/TPro" + "/tproBenefitsPage/v2";
    }

    private final String appendPathBasedOnConfigs(String str) {
        String str2;
        String str3;
        if (this.isQaEnvironment) {
            str2 = str + "/qa";
        } else {
            str2 = str + "/prod";
        }
        String str4 = this.countryIso3166;
        if (Intrinsics.areEqual((Object) str4, (Object) Profile.Country.KW)) {
            str3 = str2 + "/kwt";
        } else if (Intrinsics.areEqual((Object) str4, (Object) Profile.Country.AE)) {
            str3 = str2 + "/uae";
        } else {
            str3 = str2 + "/default";
        }
        if (this.isRTL) {
            return str3 + "/ar";
        }
        return str3 + "/en";
    }

    private final String getResourceSize(Resources resources) {
        int i11 = resources.getDisplayMetrics().densityDpi;
        return (i11 == 120 || i11 == 160) ? "" : (i11 == 240 || i11 == 320) ? "@2x" : i11 != 480 ? "@3x" : "@3x";
    }

    @NotNull
    public final String getBenefitsHeaderImage(@NotNull Resources resources, @NotNull String str) {
        Intrinsics.checkNotNullParameter(resources, "res");
        Intrinsics.checkNotNullParameter(str, "imageName");
        String appendPathBasedOnConfigs = appendPathBasedOnConfigs(this.benefitsUrl);
        String resourceSize = getResourceSize(resources);
        return appendPathBasedOnConfigs + "/" + str + resourceSize + ".png";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TproImageResources(boolean r1, java.lang.String r2, boolean r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0005
            r1 = 0
        L_0x0005:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x0012
            java.lang.String r2 = com.talabat.helpers.TalabatUtils.getSelectedCountryIso3166()
            java.lang.String r5 = "getSelectedCountryIso3166()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
        L_0x0012:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x001a
            boolean r3 = com.talabat.helpers.TalabatUtils.isRTL()
        L_0x001a:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.util.TproImageResources.<init>(boolean, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
