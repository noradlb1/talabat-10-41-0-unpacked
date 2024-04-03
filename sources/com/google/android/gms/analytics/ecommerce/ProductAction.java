package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
public class ProductAction {
    public static final String ACTION_ADD = "add";
    public static final String ACTION_CHECKOUT = "checkout";
    public static final String ACTION_CHECKOUT_OPTION = "checkout_option";
    @Deprecated
    public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_DETAIL = "detail";
    public static final String ACTION_PURCHASE = "purchase";
    public static final String ACTION_REFUND = "refund";
    public static final String ACTION_REMOVE = "remove";
    private Map<String, String> zzvn = new HashMap();

    public ProductAction(String str) {
        put("&pa", str);
    }

    private final void put(String str, String str2) {
        Preconditions.checkNotNull(str, "Name should be non-null");
        this.zzvn.put(str, str2);
    }

    @VisibleForTesting
    public final Map<String, String> build() {
        return new HashMap(this.zzvn);
    }

    public ProductAction setCheckoutOptions(String str) {
        put("&col", str);
        return this;
    }

    public ProductAction setCheckoutStep(int i11) {
        put("&cos", Integer.toString(i11));
        return this;
    }

    public ProductAction setProductActionList(String str) {
        put("&pal", str);
        return this;
    }

    public ProductAction setProductListSource(String str) {
        put("&pls", str);
        return this;
    }

    public ProductAction setTransactionAffiliation(String str) {
        put("&ta", str);
        return this;
    }

    public ProductAction setTransactionCouponCode(String str) {
        put("&tcc", str);
        return this;
    }

    public ProductAction setTransactionId(String str) {
        put("&ti", str);
        return this;
    }

    public ProductAction setTransactionRevenue(double d11) {
        put("&tr", Double.toString(d11));
        return this;
    }

    public ProductAction setTransactionShipping(double d11) {
        put("&ts", Double.toString(d11));
        return this;
    }

    public ProductAction setTransactionTax(double d11) {
        put("&tt", Double.toString(d11));
        return this;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.zzvn.entrySet()) {
            if (((String) next.getKey()).startsWith(ContainerUtils.FIELD_DELIMITER)) {
                hashMap.put(((String) next.getKey()).substring(1), (String) next.getValue());
            } else {
                hashMap.put((String) next.getKey(), (String) next.getValue());
            }
        }
        return zzi.zza((Map) hashMap);
    }
}
