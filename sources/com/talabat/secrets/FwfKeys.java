package com.talabat.secrets;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b:\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u000b\u001a\u00020\u0005H J\t\u0010\u000e\u001a\u00020\u0005H J\t\u0010\u0010\u001a\u00020\u0005H J\t\u0010\u0012\u001a\u00020\u0005H J\t\u0010\u0014\u001a\u00020\u0005H J\t\u0010\u0016\u001a\u00020\u0005H J\t\u0010\u0018\u001a\u00020\u0005H J\t\u0010\u001a\u001a\u00020\u0005H J\t\u0010\u001c\u001a\u00020\u0005H J\t\u0010\u001e\u001a\u00020\u0005H J\t\u0010 \u001a\u00020\u0005H J\t\u0010\"\u001a\u00020\u0005H J\t\u0010$\u001a\u00020\u0005H J\t\u0010&\u001a\u00020\u0005H J\t\u0010(\u001a\u00020\u0005H J\t\u0010*\u001a\u00020\u0005H J\t\u0010,\u001a\u00020\u0005H J\t\u0010.\u001a\u00020\u0005H J\t\u00100\u001a\u00020\u0005H J\t\u00102\u001a\u00020\u0005H J\t\u00104\u001a\u00020\u0005H J\t\u00106\u001a\u00020\u0005H J\t\u00108\u001a\u00020\u0005H J\t\u0010:\u001a\u00020\u0005H J\t\u0010<\u001a\u00020\u0005H J\t\u0010>\u001a\u00020\u0005H R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR#\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\rR\u0011\u0010&\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b'\u0010\rR\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\rR\u0011\u0010*\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b+\u0010\rR\u0011\u0010,\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b-\u0010\rR\u0011\u0010.\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b/\u0010\rR\u0011\u00100\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b1\u0010\rR\u0011\u00102\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b3\u0010\rR\u0011\u00104\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b5\u0010\rR\u0011\u00106\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b7\u0010\rR\u0011\u00108\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b9\u0010\rR\u0011\u0010:\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b;\u0010\rR\u0011\u0010<\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b=\u0010\rR\u0011\u0010>\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b?\u0010\r¨\u0006@"}, d2 = {"Lcom/talabat/secrets/FwfKeys;", "", "()V", "fwfKeysProd", "", "", "Lkotlin/Function0;", "getFwfKeysProd", "()Ljava/util/Map;", "fwfKeysQA", "getFwfKeysQA", "getFwfAdExProdToken", "getGetFwfAdExProdToken", "()Ljava/lang/String;", "getFwfAdExQaToken", "getGetFwfAdExQaToken", "getFwfDefaultProdToken", "getGetFwfDefaultProdToken", "getFwfDefaultQaToken", "getGetFwfDefaultQaToken", "getFwfEcosystemsProdToken", "getGetFwfEcosystemsProdToken", "getFwfEcosystemsQaToken", "getGetFwfEcosystemsQaToken", "getFwfHomePageProdToken", "getGetFwfHomePageProdToken", "getFwfHomePageQaToken", "getGetFwfHomePageQaToken", "getFwfKillSwitchFlagsProdToken", "getGetFwfKillSwitchFlagsProdToken", "getFwfKillSwitchFlagsQaToken", "getGetFwfKillSwitchFlagsQaToken", "getFwfMenuProdToken", "getGetFwfMenuProdToken", "getFwfMenuQaToken", "getGetFwfMenuQaToken", "getFwfOrderingProdToken", "getGetFwfOrderingProdToken", "getFwfOrderingQaToken", "getGetFwfOrderingQaToken", "getFwfPlatformProdToken", "getGetFwfPlatformProdToken", "getFwfPlatformQaToken", "getGetFwfPlatformQaToken", "getFwfPoeProdToken", "getGetFwfPoeProdToken", "getFwfPoeQaToken", "getGetFwfPoeQaToken", "getFwfQCommerceProdToken", "getGetFwfQCommerceProdToken", "getFwfQCommerceQaToken", "getGetFwfQCommerceQaToken", "getFwfSearchProdToken", "getGetFwfSearchProdToken", "getFwfSearchQaToken", "getGetFwfSearchQaToken", "getFwfUserProdToken", "getGetFwfUserProdToken", "getFwfUserQaToken", "getGetFwfUserQaToken", "getFwfVendorListProdToken", "getGetFwfVendorListProdToken", "getFwfVendorListQaToken", "getGetFwfVendorListQaToken", "secrets_release"}, k = 1, mv = {1, 4, 2})
public final class FwfKeys {
    @NotNull
    private final Map<String, Function0<String>> fwfKeysProd = MapsKt__MapsKt.mapOf(TuplesKt.to("FWF_PROJECT_DEFAULT_KEY", new FwfKeys$fwfKeysProd$1(this)), TuplesKt.to("FWF_PROJECT_HOME_KEY", new FwfKeys$fwfKeysProd$2(this)), TuplesKt.to("FWF_PROJECT_VENDORLIST_KEY", new FwfKeys$fwfKeysProd$3(this)), TuplesKt.to("FWF_PROJECT_SEARCH_KEY", new FwfKeys$fwfKeysProd$4(this)), TuplesKt.to("FWF_PROJECT_MENU_KEY", new FwfKeys$fwfKeysProd$5(this)), TuplesKt.to("FWF_PROJECT_ORDERING_KEY", new FwfKeys$fwfKeysProd$6(this)), TuplesKt.to("FWF_PROJECT_QCOMMERCE_KEY", new FwfKeys$fwfKeysProd$7(this)), TuplesKt.to("FWF_PROJECT_POE_KEY", new FwfKeys$fwfKeysProd$8(this)), TuplesKt.to("FWF_PROJECT_ECOSYSTEMS_KEY", new FwfKeys$fwfKeysProd$9(this)), TuplesKt.to("FWF_PROJECT_USER_KEY", new FwfKeys$fwfKeysProd$10(this)), TuplesKt.to("FWF_PROJECT_KILL_SWITCH_KEY", new FwfKeys$fwfKeysProd$11(this)), TuplesKt.to("FWF_PROJECT_PLATFORM_KEY", new FwfKeys$fwfKeysProd$12(this)), TuplesKt.to("FWF_PROJECT_ECO_LOGISTICS_KEY", new FwfKeys$fwfKeysProd$13(this)), TuplesKt.to("FWF_PROJECT_ADEX_KEY", new FwfKeys$fwfKeysProd$14(this)));
    @NotNull
    private final Map<String, Function0<String>> fwfKeysQA = MapsKt__MapsKt.mapOf(TuplesKt.to("FWF_PROJECT_DEFAULT_KEY", new FwfKeys$fwfKeysQA$1(this)), TuplesKt.to("FWF_PROJECT_HOME_KEY", new FwfKeys$fwfKeysQA$2(this)), TuplesKt.to("FWF_PROJECT_VENDORLIST_KEY", new FwfKeys$fwfKeysQA$3(this)), TuplesKt.to("FWF_PROJECT_SEARCH_KEY", new FwfKeys$fwfKeysQA$4(this)), TuplesKt.to("FWF_PROJECT_MENU_KEY", new FwfKeys$fwfKeysQA$5(this)), TuplesKt.to("FWF_PROJECT_ORDERING_KEY", new FwfKeys$fwfKeysQA$6(this)), TuplesKt.to("FWF_PROJECT_QCOMMERCE_KEY", new FwfKeys$fwfKeysQA$7(this)), TuplesKt.to("FWF_PROJECT_POE_KEY", new FwfKeys$fwfKeysQA$8(this)), TuplesKt.to("FWF_PROJECT_ECOSYSTEMS_KEY", new FwfKeys$fwfKeysQA$9(this)), TuplesKt.to("FWF_PROJECT_USER_KEY", new FwfKeys$fwfKeysQA$10(this)), TuplesKt.to("FWF_PROJECT_KILL_SWITCH_KEY", new FwfKeys$fwfKeysQA$11(this)), TuplesKt.to("FWF_PROJECT_PLATFORM_KEY", new FwfKeys$fwfKeysQA$12(this)), TuplesKt.to("FWF_PROJECT_ECO_LOGISTICS_KEY", new FwfKeys$fwfKeysQA$13(this)), TuplesKt.to("FWF_PROJECT_ADEX_KEY", new FwfKeys$fwfKeysQA$14(this)));

    public FwfKeys() {
    }

    /* access modifiers changed from: private */
    public final native String getFwfAdExProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfAdExQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfDefaultProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfDefaultQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfEcosystemsProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfEcosystemsQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfHomePageProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfHomePageQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfKillSwitchFlagsProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfKillSwitchFlagsQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfMenuProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfMenuQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfOrderingProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfOrderingQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfPlatformProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfPlatformQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfPoeProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfPoeQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfQCommerceProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfQCommerceQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfSearchProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfSearchQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfUserProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfUserQaToken();

    /* access modifiers changed from: private */
    public final native String getFwfVendorListProdToken();

    /* access modifiers changed from: private */
    public final native String getFwfVendorListQaToken();

    @NotNull
    public final Map<String, Function0<String>> getFwfKeysProd() {
        return this.fwfKeysProd;
    }

    @NotNull
    public final Map<String, Function0<String>> getFwfKeysQA() {
        return this.fwfKeysQA;
    }

    @NotNull
    public final String getGetFwfAdExProdToken() {
        return getFwfAdExProdToken();
    }

    @NotNull
    public final String getGetFwfAdExQaToken() {
        return getFwfAdExQaToken();
    }

    @NotNull
    public final String getGetFwfDefaultProdToken() {
        return getFwfDefaultProdToken();
    }

    @NotNull
    public final String getGetFwfDefaultQaToken() {
        return getFwfDefaultQaToken();
    }

    @NotNull
    public final String getGetFwfEcosystemsProdToken() {
        return getFwfEcosystemsProdToken();
    }

    @NotNull
    public final String getGetFwfEcosystemsQaToken() {
        return getFwfEcosystemsQaToken();
    }

    @NotNull
    public final String getGetFwfHomePageProdToken() {
        return getFwfHomePageProdToken();
    }

    @NotNull
    public final String getGetFwfHomePageQaToken() {
        return getFwfHomePageQaToken();
    }

    @NotNull
    public final String getGetFwfKillSwitchFlagsProdToken() {
        return getFwfKillSwitchFlagsProdToken();
    }

    @NotNull
    public final String getGetFwfKillSwitchFlagsQaToken() {
        return getFwfKillSwitchFlagsQaToken();
    }

    @NotNull
    public final String getGetFwfMenuProdToken() {
        return getFwfMenuProdToken();
    }

    @NotNull
    public final String getGetFwfMenuQaToken() {
        return getFwfMenuQaToken();
    }

    @NotNull
    public final String getGetFwfOrderingProdToken() {
        return getFwfOrderingProdToken();
    }

    @NotNull
    public final String getGetFwfOrderingQaToken() {
        return getFwfOrderingQaToken();
    }

    @NotNull
    public final String getGetFwfPlatformProdToken() {
        return getFwfPlatformProdToken();
    }

    @NotNull
    public final String getGetFwfPlatformQaToken() {
        return getFwfPlatformQaToken();
    }

    @NotNull
    public final String getGetFwfPoeProdToken() {
        return getFwfPoeProdToken();
    }

    @NotNull
    public final String getGetFwfPoeQaToken() {
        return getFwfPoeQaToken();
    }

    @NotNull
    public final String getGetFwfQCommerceProdToken() {
        return getFwfQCommerceProdToken();
    }

    @NotNull
    public final String getGetFwfQCommerceQaToken() {
        return getFwfQCommerceQaToken();
    }

    @NotNull
    public final String getGetFwfSearchProdToken() {
        return getFwfSearchProdToken();
    }

    @NotNull
    public final String getGetFwfSearchQaToken() {
        return getFwfSearchQaToken();
    }

    @NotNull
    public final String getGetFwfUserProdToken() {
        return getFwfUserProdToken();
    }

    @NotNull
    public final String getGetFwfUserQaToken() {
        return getFwfUserQaToken();
    }

    @NotNull
    public final String getGetFwfVendorListProdToken() {
        return getFwfVendorListProdToken();
    }

    @NotNull
    public final String getGetFwfVendorListQaToken() {
        return getFwfVendorListQaToken();
    }
}
