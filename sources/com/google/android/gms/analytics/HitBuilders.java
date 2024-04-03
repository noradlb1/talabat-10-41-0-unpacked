package com.google.android.gms.analytics;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzch;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@VisibleForTesting
public class HitBuilders {

    @Deprecated
    @VisibleForTesting
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            set("&t", "screenview");
        }
    }

    @VisibleForTesting
    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z11) {
            set("&exf", zzcz.zzc(z11));
            return this;
        }
    }

    @VisibleForTesting
    public static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> map = new HashMap();
        private ProductAction zzrx;
        private Map<String, List<Product>> zzry = new HashMap();
        private List<Promotion> zzrz = new ArrayList();
        private List<Product> zzsa = new ArrayList();

        private final T zza(String str, String str2) {
            if (str2 != null) {
                this.map.put(str, str2);
            }
            return this;
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                zzch.zzac("product should be non-null");
                return this;
            }
            if (str == null) {
                str = "";
            }
            if (!this.zzry.containsKey(str)) {
                this.zzry.put(str, new ArrayList());
            }
            this.zzry.get(str).add(product);
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzch.zzac("product should be non-null");
                return this;
            }
            this.zzsa.add(product);
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzch.zzac("promotion should be non-null");
                return this;
            }
            this.zzrz.add(promotion);
            return this;
        }

        public Map<String, String> build() {
            String str;
            String str2;
            HashMap hashMap = new HashMap(this.map);
            ProductAction productAction = this.zzrx;
            if (productAction != null) {
                hashMap.putAll(productAction.build());
            }
            int i11 = 1;
            for (Promotion zzn : this.zzrz) {
                hashMap.putAll(zzn.zzn(zzd.zzj(i11)));
                i11++;
            }
            int i12 = 1;
            for (Product zzn2 : this.zzsa) {
                hashMap.putAll(zzn2.zzn(zzd.zzh(i12)));
                i12++;
            }
            int i13 = 1;
            for (Map.Entry next : this.zzry.entrySet()) {
                String zzm = zzd.zzm(i13);
                int i14 = 1;
                for (Product product : (List) next.getValue()) {
                    String valueOf = String.valueOf(zzm);
                    String valueOf2 = String.valueOf(zzd.zzl(i14));
                    if (valueOf2.length() != 0) {
                        str2 = valueOf.concat(valueOf2);
                    } else {
                        str2 = new String(valueOf);
                    }
                    hashMap.putAll(product.zzn(str2));
                    i14++;
                }
                if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                    String valueOf3 = String.valueOf(zzm);
                    if ("nm".length() != 0) {
                        str = valueOf3.concat("nm");
                    } else {
                        str = new String(valueOf3);
                    }
                    hashMap.put(str, (String) next.getKey());
                }
                i13++;
            }
            return hashMap;
        }

        @VisibleForTesting
        public String get(String str) {
            return this.map.get(str);
        }

        public final T set(String str, String str2) {
            if (str != null) {
                this.map.put(str, str2);
            } else {
                zzch.zzac("HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> map2) {
            if (map2 == null) {
                return this;
            }
            this.map.putAll(new HashMap(map2));
            return this;
        }

        public T setCampaignParamsFromUrl(String str) {
            String zzah = zzcz.zzah(str);
            if (TextUtils.isEmpty(zzah)) {
                return this;
            }
            Map<String, String> zzaf = zzcz.zzaf(zzah);
            zza("&cc", zzaf.get(ConstantsKt.DEEPLINK_UTM_CONTENT));
            zza("&cm", zzaf.get(ConstantsKt.DEEPLINK_UTM_MEDIUM));
            zza("&cn", zzaf.get(ConstantsKt.DEEPLINK_UTM_CAMPAIGN));
            zza("&cs", zzaf.get(ConstantsKt.DEEPLINK_UTM_SOURCE));
            zza("&ck", zzaf.get(ConstantsKt.DEEPLINK_UTM_TERM));
            zza("&ci", zzaf.get(ConstantsKt.DEEPLINK_UTM_ID));
            zza("&anid", zzaf.get("anid"));
            zza("&gclid", zzaf.get("gclid"));
            zza("&dclid", zzaf.get("dclid"));
            zza("&aclid", zzaf.get(FirebaseAnalytics.Param.ACLID));
            zza("&gmob_t", zzaf.get("gmob_t"));
            return this;
        }

        public T setCustomDimension(int i11, String str) {
            set(zzd.zzd(i11), str);
            return this;
        }

        public T setCustomMetric(int i11, float f11) {
            set(zzd.zzf(i11), Float.toString(f11));
            return this;
        }

        public T setHitType(String str) {
            set("&t", str);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z11) {
            set("&ni", zzcz.zzc(z11));
            return this;
        }

        public T setProductAction(ProductAction productAction) {
            this.zzrx = productAction;
            return this;
        }

        public T setPromotionAction(String str) {
            this.map.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    @VisibleForTesting
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            set("&t", "item");
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setPrice(double d11) {
            set("&ip", Double.toString(d11));
            return this;
        }

        public ItemBuilder setQuantity(long j11) {
            set("&iq", Long.toString(j11));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    @VisibleForTesting
    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }
    }

    @VisibleForTesting
    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            set("&t", NotificationCompat.CATEGORY_SOCIAL);
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    @Deprecated
    @VisibleForTesting
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d11) {
            set("&tr", Double.toString(d11));
            return this;
        }

        public TransactionBuilder setShipping(double d11) {
            set("&ts", Double.toString(d11));
            return this;
        }

        public TransactionBuilder setTax(double d11) {
            set("&tt", Double.toString(d11));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    @VisibleForTesting
    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            set("&t", "event");
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j11) {
            set("&ev", Long.toString(j11));
            return this;
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }
    }

    @VisibleForTesting
    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public TimingBuilder setValue(long j11) {
            set("&utt", Long.toString(j11));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }

        public TimingBuilder(String str, String str2, long j11) {
            this();
            setVariable(str2);
            setValue(j11);
            setCategory(str);
        }
    }
}
