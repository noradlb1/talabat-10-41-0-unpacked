package com.adyen.checkout.util;

import android.support.annotation.NonNull;

public final class PaymentMethodTypes {
    @NonNull
    public static final String AFTERPAY = "afterpay_default";
    @Deprecated
    @NonNull
    public static final String ANDROID_PAY = "androidpay";
    @NonNull
    public static final String BCMC = "bcmc";
    @NonNull
    public static final String CARD = "card";
    @NonNull
    public static final String CUP = "cup";
    @NonNull
    public static final String DOKU = "doku";
    @NonNull
    public static final String GIROPAY = "giropay";
    @NonNull
    public static final String GOOGLE_PAY = "paywithgoogle";
    @NonNull
    public static final String IDEAL = "ideal";
    @NonNull
    public static final String KLARNA = "klarna";
    @NonNull
    public static final String MOLPAY_EBANKING_FPX_MY = "molpay_ebanking_fpx_MY";
    @NonNull
    public static final String MOLPAY_EBANKING_TH = "molpay_ebanking_TH";
    @NonNull
    public static final String PAYPAL = "paypal";
    @NonNull
    public static final String QIWIWALLET = "qiwiwallet";
    @NonNull
    public static final String SAMSUNG_PAY = "samsungpay";
    @NonNull
    public static final String SEPA_DIRECT_DEBIT = "sepadirectdebit";
    @NonNull
    public static final String WECHAT_PAY = "wechatpay";
    @NonNull
    public static final String WECHAT_PAY_QR = "wechatpayQR";
    @NonNull
    public static final String WECHAT_PAY_SDK = "wechatpaySDK";
    @NonNull
    public static final String WECHAT_PAY_WEB = "wechatpayWeb";

    private PaymentMethodTypes() {
        throw new IllegalStateException("No instances.");
    }
}
