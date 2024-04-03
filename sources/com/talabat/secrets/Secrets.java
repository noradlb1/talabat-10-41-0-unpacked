package com.talabat.secrets;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b4\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010B\u001a\u00020\u0004H J\t\u0010C\u001a\u00020\u0004H J\t\u0010D\u001a\u00020\u0004H J\t\u0010E\u001a\u00020\u0004H J\t\u0010F\u001a\u00020\u0004H J\t\u0010G\u001a\u00020\u0004H J\t\u0010\u0013\u001a\u00020\u0004H J\t\u0010\u0015\u001a\u00020\u0004H J\t\u0010\u0017\u001a\u00020\u0004H J\t\u0010\u0019\u001a\u00020\u0004H J\t\u0010H\u001a\u00020\u0004H J\t\u0010I\u001a\u00020\u0004H J\t\u0010J\u001a\u00020\u0004H J\t\u0010K\u001a\u00020\u0004H J\t\u0010L\u001a\u00020\u0004H J\t\u0010M\u001a\u00020\u0004H J\t\u0010N\u001a\u00020\u0004H J\t\u0010O\u001a\u00020\u0004H J\t\u0010P\u001a\u00020\u0004H J\t\u0010Q\u001a\u00020\u0004H J\t\u0010R\u001a\u00020\u0004H J\t\u0010S\u001a\u00020\u0004H J\t\u0010T\u001a\u00020\u0004H J\t\u0010U\u001a\u00020\u0004H J\t\u0010V\u001a\u00020\u0004H J\t\u0010W\u001a\u00020\u0004H J\t\u0010X\u001a\u00020\u0004H J\t\u0010Y\u001a\u00020\u0004H J\t\u0010Z\u001a\u00020\u0004H R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b$\u0010\u0006R#\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'0&8F¢\u0006\u0006\u001a\u0004\b(\u0010)R#\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'0&8F¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0011\u0010,\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b-\u0010\u0006R\u0011\u0010.\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b/\u0010\u0006R\u0011\u00100\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b1\u0010\u0006R\u0011\u00102\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b3\u0010\u0006R\u0011\u00104\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b5\u0010\u0006R\u0011\u00106\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b7\u0010\u0006R\u001a\u00108\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0002\u001a\u0004\b:\u0010\u0006R\u001a\u0010;\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0002\u001a\u0004\b=\u0010\u0006R\u0011\u0010>\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b?\u0010\u0006R\u0011\u0010@\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bA\u0010\u0006¨\u0006["}, d2 = {"Lcom/talabat/secrets/Secrets;", "", "()V", "aaaClientSecretProd", "", "getAaaClientSecretProd", "()Ljava/lang/String;", "aaaClientSecretQa", "getAaaClientSecretQa", "darkstoresAPIProdKey", "getDarkstoresAPIProdKey$annotations", "getDarkstoresAPIProdKey", "darkstoresAPIQaKey", "getDarkstoresAPIQaKey$annotations", "getDarkstoresAPIQaKey", "fwfKeys", "Lcom/talabat/secrets/FwfKeys;", "getFwfKeys", "()Lcom/talabat/secrets/FwfKeys;", "getDataLayerProdAuthEmail", "getGetDataLayerProdAuthEmail", "getDataLayerProdAuthPassword", "getGetDataLayerProdAuthPassword", "getDataLayerQaAuthEmail", "getGetDataLayerQaAuthEmail", "getDataLayerQaAuthPassword", "getGetDataLayerQaAuthPassword", "googleMapsKeyProd", "getGoogleMapsKeyProd", "googleMapsKeyQa", "getGoogleMapsKeyQa", "huaweiAPIProdKey", "getHuaweiAPIProdKey", "instabugDebugKey", "getInstabugDebugKey", "instabugRelaseKey", "getInstabugRelaseKey", "keysProd", "", "Lkotlin/Function0;", "getKeysProd", "()Ljava/util/Map;", "keysQA", "getKeysQA", "newrelicDebugKey", "getNewrelicDebugKey", "newrelicReleaseKey", "getNewrelicReleaseKey", "proSubscriptionProdProductI", "getProSubscriptionProdProductI", "proSubscriptionQAProductId", "getProSubscriptionQAProductId", "subscriptionQAKey", "getSubscriptionQAKey", "subscriptionReleaseKey", "getSubscriptionReleaseKey", "tmartAPIKeyProd", "getTmartAPIKeyProd$annotations", "getTmartAPIKeyProd", "tmartAPIKeyQa", "getTmartAPIKeyQa$annotations", "getTmartAPIKeyQa", "uxCamReleaseKey", "getUxCamReleaseKey", "uxcamDebugKey", "getUxcamDebugKey", "getAaaProdClientSecret", "getAaaQaClientSecret", "getDarkstoresAPIKeyProd", "getDarkstoresAPIKeyProdBase64", "getDarkstoresAPIKeyQa", "getDarkstoresAPIKeyQaBase64", "getGoogleMapsProdKey", "getGoogleMapsQaKey", "getHuaweiAPIKeyProd", "getInstabugDebugToken", "getInstabugRelaseToken", "getNewrelicKeyProd", "getNewrelicKeyQa", "getProSubscriptionProdProductIdSecret", "getProSubscriptionQAProductIdSecret", "getSubscriptionQASecret", "getSubscriptionReleaseSecret", "getTMartAPIKeyProd", "getTMartAPIKeyProdBase64", "getTMartAPIKeyQa", "getTMartAPIKeyQaBase64", "getUxcamDebugSecret", "getUxcamReleaseSecret", "getWfpAPIKeyProd", "getWfpAPIKeyQa", "secrets_release"}, k = 1, mv = {1, 4, 2})
public final class Secrets {
    public Secrets() {
        try {
            System.loadLibrary("secrets");
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public final native String getAaaProdClientSecret();

    /* access modifiers changed from: private */
    public final native String getAaaQaClientSecret();

    /* access modifiers changed from: private */
    public final native String getDarkstoresAPIKeyProd();

    private final native String getDarkstoresAPIKeyProdBase64();

    /* access modifiers changed from: private */
    public final native String getDarkstoresAPIKeyQa();

    private final native String getDarkstoresAPIKeyQaBase64();

    @Deprecated(message = "Use plain text key from keysQA/keysProd")
    public static /* synthetic */ void getDarkstoresAPIProdKey$annotations() {
    }

    @Deprecated(message = "Use plain text key from keysQA/keysProd")
    public static /* synthetic */ void getDarkstoresAPIQaKey$annotations() {
    }

    /* access modifiers changed from: private */
    public final native String getDataLayerProdAuthEmail();

    /* access modifiers changed from: private */
    public final native String getDataLayerProdAuthPassword();

    /* access modifiers changed from: private */
    public final native String getDataLayerQaAuthEmail();

    /* access modifiers changed from: private */
    public final native String getDataLayerQaAuthPassword();

    private final native String getGoogleMapsProdKey();

    private final native String getGoogleMapsQaKey();

    private final native String getHuaweiAPIKeyProd();

    private final native String getInstabugDebugToken();

    private final native String getInstabugRelaseToken();

    /* access modifiers changed from: private */
    public final native String getNewrelicKeyProd();

    /* access modifiers changed from: private */
    public final native String getNewrelicKeyQa();

    /* access modifiers changed from: private */
    public final native String getProSubscriptionProdProductIdSecret();

    /* access modifiers changed from: private */
    public final native String getProSubscriptionQAProductIdSecret();

    /* access modifiers changed from: private */
    public final native String getSubscriptionQASecret();

    /* access modifiers changed from: private */
    public final native String getSubscriptionReleaseSecret();

    /* access modifiers changed from: private */
    public final native String getTMartAPIKeyProd();

    private final native String getTMartAPIKeyProdBase64();

    /* access modifiers changed from: private */
    public final native String getTMartAPIKeyQa();

    private final native String getTMartAPIKeyQaBase64();

    @Deprecated(message = "Use plain text key from keysQA/keysProd")
    public static /* synthetic */ void getTmartAPIKeyProd$annotations() {
    }

    @Deprecated(message = "Use plain text key from keysQA/keysProd")
    public static /* synthetic */ void getTmartAPIKeyQa$annotations() {
    }

    private final native String getUxcamDebugSecret();

    private final native String getUxcamReleaseSecret();

    /* access modifiers changed from: private */
    public final native String getWfpAPIKeyProd();

    /* access modifiers changed from: private */
    public final native String getWfpAPIKeyQa();

    @NotNull
    public final String getAaaClientSecretProd() {
        return getAaaProdClientSecret();
    }

    @NotNull
    public final String getAaaClientSecretQa() {
        return getAaaQaClientSecret();
    }

    @NotNull
    public final String getDarkstoresAPIProdKey() {
        return getDarkstoresAPIKeyProdBase64();
    }

    @NotNull
    public final String getDarkstoresAPIQaKey() {
        return getDarkstoresAPIKeyQaBase64();
    }

    @NotNull
    public final FwfKeys getFwfKeys() {
        return new FwfKeys();
    }

    @NotNull
    public final String getGetDataLayerProdAuthEmail() {
        return getDataLayerProdAuthEmail();
    }

    @NotNull
    public final String getGetDataLayerProdAuthPassword() {
        return getDataLayerProdAuthPassword();
    }

    @NotNull
    public final String getGetDataLayerQaAuthEmail() {
        return getDataLayerQaAuthEmail();
    }

    @NotNull
    public final String getGetDataLayerQaAuthPassword() {
        return getDataLayerQaAuthPassword();
    }

    @NotNull
    public final String getGoogleMapsKeyProd() {
        return getGoogleMapsProdKey();
    }

    @NotNull
    public final String getGoogleMapsKeyQa() {
        return getGoogleMapsQaKey();
    }

    @NotNull
    public final String getHuaweiAPIProdKey() {
        return getHuaweiAPIKeyProd();
    }

    @NotNull
    public final String getInstabugDebugKey() {
        return getInstabugDebugToken();
    }

    @NotNull
    public final String getInstabugRelaseKey() {
        return getInstabugRelaseToken();
    }

    @NotNull
    public final Map<String, Function0<String>> getKeysProd() {
        return MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(TuplesKt.to("CLIENT_SECRET_AAA", new Secrets$keysProd$1(this)), TuplesKt.to("GROWTH_XAPI_KEY", new Secrets$keysProd$2(this)), TuplesKt.to("VERTICALS_XAPI_KEY", new Secrets$keysProd$3(this)), TuplesKt.to("WFP_API_KEY", new Secrets$keysProd$4(this)), TuplesKt.to("NEWRELIC_KEY", new Secrets$keysProd$5(this)), TuplesKt.to("SUBSCRIPTION_ORGANIZATION_ID", new Secrets$keysProd$6(this)), TuplesKt.to("SUBSCRIPTION_PRODUCT_ID", new Secrets$keysProd$7(this)), TuplesKt.to("DATALAYER_AUTH_EMAIL", new Secrets$keysProd$8(this)), TuplesKt.to("DATALAYER_AUTH_PASSWORD", new Secrets$keysProd$9(this))), (Map) getFwfKeys().getFwfKeysProd());
    }

    @NotNull
    public final Map<String, Function0<String>> getKeysQA() {
        return MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(TuplesKt.to("CLIENT_SECRET_AAA", new Secrets$keysQA$1(this)), TuplesKt.to("GROWTH_XAPI_KEY", new Secrets$keysQA$2(this)), TuplesKt.to("VERTICALS_XAPI_KEY", new Secrets$keysQA$3(this)), TuplesKt.to("WFP_API_KEY", new Secrets$keysQA$4(this)), TuplesKt.to("NEWRELIC_KEY", new Secrets$keysQA$5(this)), TuplesKt.to("SUBSCRIPTION_ORGANIZATION_ID", new Secrets$keysQA$6(this)), TuplesKt.to("SUBSCRIPTION_PRODUCT_ID", new Secrets$keysQA$7(this)), TuplesKt.to("DATALAYER_AUTH_EMAIL", new Secrets$keysQA$8(this)), TuplesKt.to("DATALAYER_AUTH_PASSWORD", new Secrets$keysQA$9(this))), (Map) getFwfKeys().getFwfKeysQA());
    }

    @NotNull
    public final String getNewrelicDebugKey() {
        return getNewrelicKeyQa();
    }

    @NotNull
    public final String getNewrelicReleaseKey() {
        return getNewrelicKeyProd();
    }

    @NotNull
    public final String getProSubscriptionProdProductI() {
        return getProSubscriptionProdProductIdSecret();
    }

    @NotNull
    public final String getProSubscriptionQAProductId() {
        return getProSubscriptionQAProductIdSecret();
    }

    @NotNull
    public final String getSubscriptionQAKey() {
        return getSubscriptionQASecret();
    }

    @NotNull
    public final String getSubscriptionReleaseKey() {
        return getSubscriptionReleaseSecret();
    }

    @NotNull
    public final String getTmartAPIKeyProd() {
        return getTMartAPIKeyProdBase64();
    }

    @NotNull
    public final String getTmartAPIKeyQa() {
        return getTMartAPIKeyQaBase64();
    }

    @NotNull
    public final String getUxCamReleaseKey() {
        return getUxcamReleaseSecret();
    }

    @NotNull
    public final String getUxcamDebugKey() {
        return getUxcamDebugSecret();
    }
}
