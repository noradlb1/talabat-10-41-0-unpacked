package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tracking.ScreenNames;

@ShowFirstParty
@VisibleForTesting
public final class zzgk extends zzgh {
    private static final String ID = zza.UNIVERSAL_ANALYTICS.toString();
    private static final String zzalx = zzb.ACCOUNT.toString();
    private static final String zzaly = zzb.ANALYTICS_PASS_THROUGH.toString();
    private static final String zzalz = zzb.ENABLE_ECOMMERCE.toString();
    private static final String zzama = zzb.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String zzamb = zzb.ECOMMERCE_MACRO_DATA.toString();
    private static final String zzamc = zzb.ANALYTICS_FIELDS.toString();
    private static final String zzamd = zzb.TRACK_TRANSACTION.toString();
    private static final String zzame = zzb.TRANSACTION_DATALAYER_MAP.toString();
    private static final String zzamf = zzb.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List<String> zzamg = Arrays.asList(new String[]{ProductAction.ACTION_DETAIL, "checkout", ProductAction.ACTION_CHECKOUT_OPTION, "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, "purchase", "refund"});
    private static final Pattern zzamh = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzami = Pattern.compile("metric(\\d+)");
    private static Map<String, String> zzamj;
    private static Map<String, String> zzamk;
    private final DataLayer zzaed;
    private final Set<String> zzaml;
    private final zzgf zzamm;

    public zzgk(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new zzgf(context));
    }

    private final String zzbr(String str) {
        Object obj = this.zzaed.get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    private static boolean zzc(Map<String, zzl> map, String str) {
        zzl zzl = map.get(str);
        if (zzl == null) {
            return false;
        }
        return zzgj.zzg(zzl).booleanValue();
    }

    private static Product zzf(Map<String, Object> map) {
        String str;
        String str2;
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        Object obj2 = map.get("name");
        if (obj2 != null) {
            product.setName(String.valueOf(obj2));
        }
        Object obj3 = map.get(ScreenNames.SCREEN_TYPE_BRAND);
        if (obj3 != null) {
            product.setBrand(String.valueOf(obj3));
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.setCategory(String.valueOf(obj4));
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.setVariant(String.valueOf(obj5));
        }
        Object obj6 = map.get("coupon");
        if (obj6 != null) {
            product.setCouponCode(String.valueOf(obj6));
        }
        Object obj7 = map.get("position");
        if (obj7 != null) {
            product.setPosition(zzn(obj7).intValue());
        }
        Object obj8 = map.get(FirebaseAnalytics.Param.PRICE);
        if (obj8 != null) {
            product.setPrice(zzm(obj8).doubleValue());
        }
        Object obj9 = map.get(FirebaseAnalytics.Param.QUANTITY);
        if (obj9 != null) {
            product.setQuantity(zzn(obj9).intValue());
        }
        for (String next : map.keySet()) {
            Matcher matcher = zzamh.matcher(next);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(next)));
                } catch (NumberFormatException unused) {
                    String valueOf = String.valueOf(next);
                    if (valueOf.length() != 0) {
                        str2 = "illegal number in custom dimension value: ".concat(valueOf);
                    } else {
                        str2 = new String("illegal number in custom dimension value: ");
                    }
                    zzdi.zzac(str2);
                }
            } else {
                Matcher matcher2 = zzami.matcher(next);
                if (matcher2.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher2.group(1)), zzn(map.get(next)).intValue());
                    } catch (NumberFormatException unused2) {
                        String valueOf2 = String.valueOf(next);
                        if (valueOf2.length() != 0) {
                            str = "illegal number in custom metric value: ".concat(valueOf2);
                        } else {
                            str = new String("illegal number in custom metric value: ");
                        }
                        zzdi.zzac(str);
                    }
                }
            }
        }
        return product;
    }

    private static Map<String, String> zzi(zzl zzl) {
        Object zzh = zzgj.zzh(zzl);
        if (!(zzh instanceof Map)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) zzh).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private final Map<String, String> zzj(zzl zzl) {
        if (zzl == null) {
            return new HashMap();
        }
        Map<String, String> zzi = zzi(zzl);
        if (zzi == null) {
            return new HashMap();
        }
        String str = zzi.get("&aip");
        if (str != null && this.zzaml.contains(str.toLowerCase())) {
            zzi.remove("&aip");
        }
        return zzi;
    }

    private static Double zzm(Object obj) {
        String str;
        String str2;
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e11) {
                String valueOf = String.valueOf(e11.getMessage());
                if (valueOf.length() != 0) {
                    str2 = "Cannot convert the object to Double: ".concat(valueOf);
                } else {
                    str2 = new String("Cannot convert the object to Double: ");
                }
                throw new RuntimeException(str2);
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            if (valueOf2.length() != 0) {
                str = "Cannot convert the object to Double: ".concat(valueOf2);
            } else {
                str = new String("Cannot convert the object to Double: ");
            }
            throw new RuntimeException(str);
        }
    }

    private static Integer zzn(Object obj) {
        String str;
        String str2;
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e11) {
                String valueOf = String.valueOf(e11.getMessage());
                if (valueOf.length() != 0) {
                    str2 = "Cannot convert the object to Integer: ".concat(valueOf);
                } else {
                    str2 = new String("Cannot convert the object to Integer: ");
                }
                throw new RuntimeException(str2);
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            if (valueOf2.length() != 0) {
                str = "Cannot convert the object to Integer: ".concat(valueOf2);
            } else {
                str = new String("Cannot convert the object to Integer: ");
            }
            throw new RuntimeException(str);
        }
    }

    public final /* bridge */ /* synthetic */ zzl zzb(Map map) {
        return super.zzb(map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(java.util.Map<java.lang.String, com.google.android.gms.internal.gtm.zzl> r15) {
        /*
            r14 = this;
            java.lang.String r0 = "actionField"
            java.lang.String r1 = "&t"
            com.google.android.gms.tagmanager.zzgf r2 = r14.zzamm
            java.lang.String r3 = "_GTM_DEFAULT_TRACKER_"
            com.google.android.gms.analytics.Tracker r2 = r2.zzbm(r3)
            java.lang.String r3 = "collect_adid"
            boolean r3 = zzc(r15, r3)
            r2.enableAdvertisingIdCollection(r3)
            java.lang.String r3 = zzalz
            boolean r3 = zzc(r15, r3)
            r4 = 0
            java.lang.String r5 = "name"
            r6 = 0
            java.lang.String r7 = "&cu"
            if (r3 == 0) goto L_0x02a2
            com.google.android.gms.analytics.HitBuilders$ScreenViewBuilder r1 = new com.google.android.gms.analytics.HitBuilders$ScreenViewBuilder
            r1.<init>()
            java.lang.String r3 = zzamc
            java.lang.Object r3 = r15.get(r3)
            com.google.android.gms.internal.gtm.zzl r3 = (com.google.android.gms.internal.gtm.zzl) r3
            java.util.Map r3 = r14.zzj(r3)
            r1.setAll(r3)
            java.lang.String r8 = zzama
            boolean r8 = zzc(r15, r8)
            if (r8 == 0) goto L_0x004e
            com.google.android.gms.tagmanager.DataLayer r15 = r14.zzaed
            java.lang.String r8 = "ecommerce"
            java.lang.Object r15 = r15.get(r8)
            boolean r8 = r15 instanceof java.util.Map
            if (r8 == 0) goto L_0x0061
            java.util.Map r15 = (java.util.Map) r15
            goto L_0x0062
        L_0x004e:
            java.lang.String r8 = zzamb
            java.lang.Object r15 = r15.get(r8)
            com.google.android.gms.internal.gtm.zzl r15 = (com.google.android.gms.internal.gtm.zzl) r15
            java.lang.Object r15 = com.google.android.gms.tagmanager.zzgj.zzh((com.google.android.gms.internal.gtm.zzl) r15)
            boolean r8 = r15 instanceof java.util.Map
            if (r8 == 0) goto L_0x0061
            java.util.Map r15 = (java.util.Map) r15
            goto L_0x0062
        L_0x0061:
            r15 = r6
        L_0x0062:
            if (r15 == 0) goto L_0x029a
            java.lang.Object r3 = r3.get(r7)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0074
            java.lang.String r3 = "currencyCode"
            java.lang.Object r3 = r15.get(r3)
            java.lang.String r3 = (java.lang.String) r3
        L_0x0074:
            if (r3 == 0) goto L_0x0079
            r1.set(r7, r3)
        L_0x0079:
            java.lang.String r3 = "impressions"
            java.lang.Object r3 = r15.get(r3)
            boolean r7 = r3 instanceof java.util.List
            java.lang.String r8 = "Failed to extract a product from DataLayer. "
            java.lang.String r9 = "list"
            if (r7 == 0) goto L_0x00c4
            java.util.List r3 = (java.util.List) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x008d:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00c4
            java.lang.Object r7 = r3.next()
            java.util.Map r7 = (java.util.Map) r7
            com.google.android.gms.analytics.ecommerce.Product r10 = zzf(r7)     // Catch:{ RuntimeException -> 0x00a7 }
            java.lang.Object r7 = r7.get(r9)     // Catch:{ RuntimeException -> 0x00a7 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ RuntimeException -> 0x00a7 }
            r1.addImpression(r10, r7)     // Catch:{ RuntimeException -> 0x00a7 }
            goto L_0x008d
        L_0x00a7:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r10 = r7.length()
            if (r10 == 0) goto L_0x00bb
            java.lang.String r7 = r8.concat(r7)
            goto L_0x00c0
        L_0x00bb:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r8)
        L_0x00c0:
            com.google.android.gms.tagmanager.zzdi.zzav(r7)
            goto L_0x008d
        L_0x00c4:
            java.lang.String r3 = "promoClick"
            boolean r7 = r15.containsKey(r3)
            java.lang.String r10 = "promotions"
            if (r7 == 0) goto L_0x00db
            java.lang.Object r6 = r15.get(r3)
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r6.get(r10)
            java.util.List r6 = (java.util.List) r6
            goto L_0x00ef
        L_0x00db:
            java.lang.String r7 = "promoView"
            boolean r11 = r15.containsKey(r7)
            if (r11 == 0) goto L_0x00ef
            java.lang.Object r6 = r15.get(r7)
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r6.get(r10)
            java.util.List r6 = (java.util.List) r6
        L_0x00ef:
            java.lang.String r7 = "id"
            if (r6 == 0) goto L_0x016e
            java.util.Iterator r6 = r6.iterator()
        L_0x00f7:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x015b
            java.lang.Object r10 = r6.next()
            java.util.Map r10 = (java.util.Map) r10
            com.google.android.gms.analytics.ecommerce.Promotion r11 = new com.google.android.gms.analytics.ecommerce.Promotion     // Catch:{ RuntimeException -> 0x013c }
            r11.<init>()     // Catch:{ RuntimeException -> 0x013c }
            java.lang.Object r12 = r10.get(r7)     // Catch:{ RuntimeException -> 0x013c }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ RuntimeException -> 0x013c }
            if (r12 == 0) goto L_0x0113
            r11.setId(r12)     // Catch:{ RuntimeException -> 0x013c }
        L_0x0113:
            java.lang.Object r12 = r10.get(r5)     // Catch:{ RuntimeException -> 0x013c }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ RuntimeException -> 0x013c }
            if (r12 == 0) goto L_0x011e
            r11.setName(r12)     // Catch:{ RuntimeException -> 0x013c }
        L_0x011e:
            java.lang.String r12 = "creative"
            java.lang.Object r12 = r10.get(r12)     // Catch:{ RuntimeException -> 0x013c }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ RuntimeException -> 0x013c }
            if (r12 == 0) goto L_0x012b
            r11.setCreative(r12)     // Catch:{ RuntimeException -> 0x013c }
        L_0x012b:
            java.lang.String r12 = "position"
            java.lang.Object r10 = r10.get(r12)     // Catch:{ RuntimeException -> 0x013c }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ RuntimeException -> 0x013c }
            if (r10 == 0) goto L_0x0138
            r11.setPosition(r10)     // Catch:{ RuntimeException -> 0x013c }
        L_0x0138:
            r1.addPromotion(r11)     // Catch:{ RuntimeException -> 0x013c }
            goto L_0x00f7
        L_0x013c:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r11 = r10.length()
            java.lang.String r12 = "Failed to extract a promotion from DataLayer. "
            if (r11 == 0) goto L_0x0152
            java.lang.String r10 = r12.concat(r10)
            goto L_0x0157
        L_0x0152:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r12)
        L_0x0157:
            com.google.android.gms.tagmanager.zzdi.zzav(r10)
            goto L_0x00f7
        L_0x015b:
            boolean r3 = r15.containsKey(r3)
            java.lang.String r5 = "&promoa"
            if (r3 == 0) goto L_0x0169
            java.lang.String r3 = "click"
            r1.set(r5, r3)
            goto L_0x016f
        L_0x0169:
            java.lang.String r3 = "view"
            r1.set(r5, r3)
        L_0x016e:
            r4 = 1
        L_0x016f:
            if (r4 == 0) goto L_0x029a
            java.util.List<java.lang.String> r3 = zzamg
            java.util.Iterator r3 = r3.iterator()
        L_0x0177:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x029a
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = r15.containsKey(r4)
            if (r5 == 0) goto L_0x0177
            java.lang.Object r15 = r15.get(r4)
            java.util.Map r15 = (java.util.Map) r15
            java.lang.String r3 = "products"
            java.lang.Object r3 = r15.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x01ce
            java.util.Iterator r3 = r3.iterator()
        L_0x019d:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x01ce
            java.lang.Object r5 = r3.next()
            java.util.Map r5 = (java.util.Map) r5
            com.google.android.gms.analytics.ecommerce.Product r5 = zzf(r5)     // Catch:{ RuntimeException -> 0x01b1 }
            r1.addProduct(r5)     // Catch:{ RuntimeException -> 0x01b1 }
            goto L_0x019d
        L_0x01b1:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x01c5
            java.lang.String r5 = r8.concat(r5)
            goto L_0x01ca
        L_0x01c5:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r8)
        L_0x01ca:
            com.google.android.gms.tagmanager.zzdi.zzav(r5)
            goto L_0x019d
        L_0x01ce:
            boolean r3 = r15.containsKey(r0)     // Catch:{ RuntimeException -> 0x027c }
            if (r3 == 0) goto L_0x0273
            java.lang.Object r15 = r15.get(r0)     // Catch:{ RuntimeException -> 0x027c }
            java.util.Map r15 = (java.util.Map) r15     // Catch:{ RuntimeException -> 0x027c }
            com.google.android.gms.analytics.ecommerce.ProductAction r0 = new com.google.android.gms.analytics.ecommerce.ProductAction     // Catch:{ RuntimeException -> 0x027c }
            r0.<init>(r4)     // Catch:{ RuntimeException -> 0x027c }
            java.lang.Object r3 = r15.get(r7)     // Catch:{ RuntimeException -> 0x027c }
            if (r3 == 0) goto L_0x01ec
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ RuntimeException -> 0x027c }
            r0.setTransactionId(r3)     // Catch:{ RuntimeException -> 0x027c }
        L_0x01ec:
            java.lang.String r3 = "affiliation"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x027c }
            if (r3 == 0) goto L_0x01fb
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ RuntimeException -> 0x027c }
            r0.setTransactionAffiliation(r3)     // Catch:{ RuntimeException -> 0x027c }
        L_0x01fb:
            java.lang.String r3 = "coupon"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x027c }
            if (r3 == 0) goto L_0x020a
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ RuntimeException -> 0x027c }
            r0.setTransactionCouponCode(r3)     // Catch:{ RuntimeException -> 0x027c }
        L_0x020a:
            java.lang.Object r3 = r15.get(r9)     // Catch:{ RuntimeException -> 0x027c }
            if (r3 == 0) goto L_0x0217
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ RuntimeException -> 0x027c }
            r0.setProductActionList(r3)     // Catch:{ RuntimeException -> 0x027c }
        L_0x0217:
            java.lang.String r3 = "option"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x027c }
            if (r3 == 0) goto L_0x0226
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ RuntimeException -> 0x027c }
            r0.setCheckoutOptions(r3)     // Catch:{ RuntimeException -> 0x027c }
        L_0x0226:
            java.lang.String r3 = "revenue"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x027c }
            if (r3 == 0) goto L_0x0239
            java.lang.Double r3 = zzm(r3)     // Catch:{ RuntimeException -> 0x027c }
            double r3 = r3.doubleValue()     // Catch:{ RuntimeException -> 0x027c }
            r0.setTransactionRevenue(r3)     // Catch:{ RuntimeException -> 0x027c }
        L_0x0239:
            java.lang.String r3 = "tax"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x027c }
            if (r3 == 0) goto L_0x024c
            java.lang.Double r3 = zzm(r3)     // Catch:{ RuntimeException -> 0x027c }
            double r3 = r3.doubleValue()     // Catch:{ RuntimeException -> 0x027c }
            r0.setTransactionTax(r3)     // Catch:{ RuntimeException -> 0x027c }
        L_0x024c:
            java.lang.String r3 = "shipping"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x027c }
            if (r3 == 0) goto L_0x025f
            java.lang.Double r3 = zzm(r3)     // Catch:{ RuntimeException -> 0x027c }
            double r3 = r3.doubleValue()     // Catch:{ RuntimeException -> 0x027c }
            r0.setTransactionShipping(r3)     // Catch:{ RuntimeException -> 0x027c }
        L_0x025f:
            java.lang.String r3 = "step"
            java.lang.Object r15 = r15.get(r3)     // Catch:{ RuntimeException -> 0x027c }
            if (r15 == 0) goto L_0x0278
            java.lang.Integer r15 = zzn(r15)     // Catch:{ RuntimeException -> 0x027c }
            int r15 = r15.intValue()     // Catch:{ RuntimeException -> 0x027c }
            r0.setCheckoutStep(r15)     // Catch:{ RuntimeException -> 0x027c }
            goto L_0x0278
        L_0x0273:
            com.google.android.gms.analytics.ecommerce.ProductAction r0 = new com.google.android.gms.analytics.ecommerce.ProductAction     // Catch:{ RuntimeException -> 0x027c }
            r0.<init>(r4)     // Catch:{ RuntimeException -> 0x027c }
        L_0x0278:
            r1.setProductAction(r0)     // Catch:{ RuntimeException -> 0x027c }
            goto L_0x029a
        L_0x027c:
            r15 = move-exception
            java.lang.String r15 = r15.getMessage()
            java.lang.String r15 = java.lang.String.valueOf(r15)
            int r0 = r15.length()
            java.lang.String r3 = "Failed to extract a product action from DataLayer. "
            if (r0 == 0) goto L_0x0292
            java.lang.String r15 = r3.concat(r15)
            goto L_0x0297
        L_0x0292:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r3)
        L_0x0297:
            com.google.android.gms.tagmanager.zzdi.zzav(r15)
        L_0x029a:
            java.util.Map r15 = r1.build()
            r2.send(r15)
            return
        L_0x02a2:
            java.lang.String r0 = zzaly
            boolean r0 = zzc(r15, r0)
            if (r0 == 0) goto L_0x02ba
            java.lang.String r0 = zzamc
            java.lang.Object r15 = r15.get(r0)
            com.google.android.gms.internal.gtm.zzl r15 = (com.google.android.gms.internal.gtm.zzl) r15
            java.util.Map r15 = r14.zzj(r15)
            r2.send(r15)
            return
        L_0x02ba:
            java.lang.String r0 = zzamd
            boolean r0 = zzc(r15, r0)
            if (r0 == 0) goto L_0x0446
            java.lang.String r0 = "transactionId"
            java.lang.String r3 = r14.zzbr(r0)
            if (r3 != 0) goto L_0x02d0
            java.lang.String r15 = "Cannot find transactionId in data layer."
            com.google.android.gms.tagmanager.zzdi.zzav(r15)
            return
        L_0x02d0:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.String r9 = zzamc     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r9 = r15.get(r9)     // Catch:{ IllegalArgumentException -> 0x043f }
            com.google.android.gms.internal.gtm.zzl r9 = (com.google.android.gms.internal.gtm.zzl) r9     // Catch:{ IllegalArgumentException -> 0x043f }
            java.util.Map r9 = r14.zzj(r9)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r10 = "transaction"
            r9.put(r1, r10)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r10 = zzame     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r10 = r15.get(r10)     // Catch:{ IllegalArgumentException -> 0x043f }
            com.google.android.gms.internal.gtm.zzl r10 = (com.google.android.gms.internal.gtm.zzl) r10     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r11 = "&ti"
            if (r10 == 0) goto L_0x02f7
            java.util.Map r0 = zzi(r10)     // Catch:{ IllegalArgumentException -> 0x043f }
            goto L_0x0328
        L_0x02f7:
            java.util.Map<java.lang.String, java.lang.String> r10 = zzamj     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r10 != 0) goto L_0x0326
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ IllegalArgumentException -> 0x043f }
            r10.<init>()     // Catch:{ IllegalArgumentException -> 0x043f }
            r10.put(r0, r11)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r0 = "transactionAffiliation"
            java.lang.String r12 = "&ta"
            r10.put(r0, r12)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r0 = "transactionTax"
            java.lang.String r12 = "&tt"
            r10.put(r0, r12)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r0 = "transactionShipping"
            java.lang.String r12 = "&ts"
            r10.put(r0, r12)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r0 = "transactionTotal"
            java.lang.String r12 = "&tr"
            r10.put(r0, r12)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r0 = "transactionCurrency"
            r10.put(r0, r7)     // Catch:{ IllegalArgumentException -> 0x043f }
            zzamj = r10     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x0326:
            java.util.Map<java.lang.String, java.lang.String> r0 = zzamj     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x0328:
            java.util.Set r0 = r0.entrySet()     // Catch:{ IllegalArgumentException -> 0x043f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x0330:
            boolean r10 = r0.hasNext()     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r10 == 0) goto L_0x0350
            java.lang.Object r10 = r0.next()     // Catch:{ IllegalArgumentException -> 0x043f }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r12 = r10.getValue()     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r10 = r10.getKey()     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r10 = r14.zzbr(r10)     // Catch:{ IllegalArgumentException -> 0x043f }
            zzd(r9, r12, r10)     // Catch:{ IllegalArgumentException -> 0x043f }
            goto L_0x0330
        L_0x0350:
            r8.add(r9)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r0 = "transactionProducts"
            com.google.android.gms.tagmanager.DataLayer r9 = r14.zzaed     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r0 = r9.get(r0)     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r0 != 0) goto L_0x035e
            goto L_0x0383
        L_0x035e:
            boolean r6 = r0 instanceof java.util.List     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r6 == 0) goto L_0x0437
            r6 = r0
            java.util.List r6 = (java.util.List) r6     // Catch:{ IllegalArgumentException -> 0x043f }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x0369:
            boolean r9 = r6.hasNext()     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r9 == 0) goto L_0x0380
            java.lang.Object r9 = r6.next()     // Catch:{ IllegalArgumentException -> 0x043f }
            boolean r9 = r9 instanceof java.util.Map     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r9 == 0) goto L_0x0378
            goto L_0x0369
        L_0x0378:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r0 = "Each element of transactionProducts should be of type Map."
            r15.<init>(r0)     // Catch:{ IllegalArgumentException -> 0x043f }
            throw r15     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x0380:
            r6 = r0
            java.util.List r6 = (java.util.List) r6     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x0383:
            if (r6 == 0) goto L_0x0424
            java.util.Iterator r0 = r6.iterator()     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x0389:
            boolean r6 = r0.hasNext()     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r6 == 0) goto L_0x0424
            java.lang.Object r6 = r0.next()     // Catch:{ IllegalArgumentException -> 0x043f }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r9 = r6.get(r5)     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r9 != 0) goto L_0x03a1
            java.lang.String r15 = "Unable to send transaction item hit due to missing 'name' field."
            com.google.android.gms.tagmanager.zzdi.zzav(r15)     // Catch:{ IllegalArgumentException -> 0x043f }
            return
        L_0x03a1:
            java.lang.String r9 = zzamc     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r9 = r15.get(r9)     // Catch:{ IllegalArgumentException -> 0x043f }
            com.google.android.gms.internal.gtm.zzl r9 = (com.google.android.gms.internal.gtm.zzl) r9     // Catch:{ IllegalArgumentException -> 0x043f }
            java.util.Map r9 = r14.zzj(r9)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r10 = "item"
            r9.put(r1, r10)     // Catch:{ IllegalArgumentException -> 0x043f }
            r9.put(r11, r3)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r10 = zzamf     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r10 = r15.get(r10)     // Catch:{ IllegalArgumentException -> 0x043f }
            com.google.android.gms.internal.gtm.zzl r10 = (com.google.android.gms.internal.gtm.zzl) r10     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r10 == 0) goto L_0x03c4
            java.util.Map r10 = zzi(r10)     // Catch:{ IllegalArgumentException -> 0x043f }
            goto L_0x03f7
        L_0x03c4:
            java.util.Map<java.lang.String, java.lang.String> r10 = zzamk     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r10 != 0) goto L_0x03f5
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ IllegalArgumentException -> 0x043f }
            r10.<init>()     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r12 = "&in"
            r10.put(r5, r12)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r12 = "sku"
            java.lang.String r13 = "&ic"
            r10.put(r12, r13)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r12 = "category"
            java.lang.String r13 = "&iv"
            r10.put(r12, r13)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r12 = "price"
            java.lang.String r13 = "&ip"
            r10.put(r12, r13)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r12 = "quantity"
            java.lang.String r13 = "&iq"
            r10.put(r12, r13)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r12 = "currency"
            r10.put(r12, r7)     // Catch:{ IllegalArgumentException -> 0x043f }
            zzamk = r10     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x03f5:
            java.util.Map<java.lang.String, java.lang.String> r10 = zzamk     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x03f7:
            java.util.Set r10 = r10.entrySet()     // Catch:{ IllegalArgumentException -> 0x043f }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x03ff:
            boolean r12 = r10.hasNext()     // Catch:{ IllegalArgumentException -> 0x043f }
            if (r12 == 0) goto L_0x041f
            java.lang.Object r12 = r10.next()     // Catch:{ IllegalArgumentException -> 0x043f }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r13 = r12.getValue()     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r12 = r12.getKey()     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.Object r12 = r6.get(r12)     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IllegalArgumentException -> 0x043f }
            zzd(r9, r13, r12)     // Catch:{ IllegalArgumentException -> 0x043f }
            goto L_0x03ff
        L_0x041f:
            r8.add(r9)     // Catch:{ IllegalArgumentException -> 0x043f }
            goto L_0x0389
        L_0x0424:
            int r15 = r8.size()     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x0428:
            if (r4 >= r15) goto L_0x0436
            java.lang.Object r0 = r8.get(r4)     // Catch:{ IllegalArgumentException -> 0x043f }
            int r4 = r4 + 1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ IllegalArgumentException -> 0x043f }
            r2.send(r0)     // Catch:{ IllegalArgumentException -> 0x043f }
            goto L_0x0428
        L_0x0436:
            return
        L_0x0437:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x043f }
            java.lang.String r0 = "transactionProducts should be of type List."
            r15.<init>(r0)     // Catch:{ IllegalArgumentException -> 0x043f }
            throw r15     // Catch:{ IllegalArgumentException -> 0x043f }
        L_0x043f:
            r15 = move-exception
            java.lang.String r0 = "Unable to send transaction"
            com.google.android.gms.tagmanager.zzdi.zza(r0, r15)
            return
        L_0x0446:
            java.lang.String r15 = "Ignoring unknown tag."
            com.google.android.gms.tagmanager.zzdi.zzac(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzgk.zzd(java.util.Map):void");
    }

    public final /* bridge */ /* synthetic */ boolean zzgw() {
        return super.zzgw();
    }

    public final /* bridge */ /* synthetic */ String zzif() {
        return super.zzif();
    }

    public final /* bridge */ /* synthetic */ Set zzig() {
        return super.zzig();
    }

    @VisibleForTesting
    private zzgk(Context context, DataLayer dataLayer, zzgf zzgf) {
        super(ID, new String[0]);
        this.zzaed = dataLayer;
        this.zzamm = zzgf;
        HashSet hashSet = new HashSet();
        this.zzaml = hashSet;
        hashSet.add("");
        hashSet.add("0");
        hashSet.add("false");
    }

    private static void zzd(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }
}
