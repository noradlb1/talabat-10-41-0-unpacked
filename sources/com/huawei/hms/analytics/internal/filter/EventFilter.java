package com.huawei.hms.analytics.internal.filter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.analytics.aq;
import com.huawei.hms.analytics.bn;
import com.huawei.hms.analytics.bo;
import com.huawei.hms.analytics.bp;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.dl;
import com.huawei.hms.analytics.dt;
import com.talabat.wallet.features.UrlConstantsKt;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class EventFilter implements bo {
    private Context ghi;
    private Method hij;
    private Object ijk;
    private Method ikl;
    private Method klm;
    private bp lmn;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean klm(java.lang.String r6, android.os.Bundle r7) {
        /*
            r5 = this;
            java.lang.String r0 = "IncidentFilter"
            r1 = 0
            java.lang.reflect.Method r2 = r5.klm     // Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x001f }
            java.lang.Object r3 = r5.ijk     // Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x001f }
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x001f }
            r4[r1] = r6     // Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x001f }
            r6 = 1
            r4[r6] = r7     // Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x001f }
            java.lang.Object r6 = r2.invoke(r3, r4)     // Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x001f }
            boolean r2 = r6 instanceof java.lang.Boolean     // Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x001f }
            if (r2 == 0) goto L_0x0027
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x001f }
            boolean r6 = r6.booleanValue()     // Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x001f }
            r1 = r6
            goto L_0x0027
        L_0x001f:
            java.lang.String r6 = "Invocation target warning"
            goto L_0x0024
        L_0x0022:
            java.lang.String r6 = "Illegal access warning"
        L_0x0024:
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r6)
        L_0x0027:
            if (r1 != 0) goto L_0x002c
            lmn((android.os.Bundle) r7)
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.internal.filter.EventFilter.klm(java.lang.String, android.os.Bundle):boolean");
    }

    private static long lmn(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private static void lmn(Bundle bundle) {
        bundle.remove("$HA_FIXED_TAG");
        bundle.remove("$HA_FIXED_TYPE");
        bundle.remove("$HA_FIXED_SOURCE");
        bundle.remove("$HA_FIXED_TIMESTAMP");
    }

    private static boolean lmn(String str, String str2) {
        if (!TextUtils.isEmpty(str) && "oper".equals(str2)) {
            return true;
        }
        HiLog.e("IncidentFilter", "third callback params invalid");
        return false;
    }

    public String getUserProfile(String str) {
        HiLog.d("IncidentFilter", "get user property#".concat(String.valueOf(str)));
        bp bpVar = this.lmn;
        if (bpVar == null) {
            return null;
        }
        return bpVar.lmn(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c A[SYNTHETIC, Splitter:B:29:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087 A[Catch:{ IllegalAccessException -> 0x0097, InvocationTargetException -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lmn(android.content.Context r13) {
        /*
            r12 = this;
            java.lang.Class<android.os.Bundle> r0 = android.os.Bundle.class
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.String r2 = "Illegal access warning"
            java.lang.String r3 = "IncidentFilter"
            r12.ghi = r13
            r4 = 0
            r5 = 1
            r6 = 0
            java.lang.Class<com.huawei.hms.dtm.EventFilter> r7 = com.huawei.hms.dtm.EventFilter.class
            java.lang.Object r8 = r7.newInstance()     // Catch:{ ClassNotFoundException -> 0x0072, IllegalAccessException -> 0x006d, InstantiationException -> 0x0069, NoSuchMethodException -> 0x0065 }
            r12.ijk = r8     // Catch:{ ClassNotFoundException -> 0x0072, IllegalAccessException -> 0x006d, InstantiationException -> 0x0069, NoSuchMethodException -> 0x0065 }
            java.lang.String r8 = "setLogCallback"
            java.lang.Class[] r9 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x0072, IllegalAccessException -> 0x006d, InstantiationException -> 0x0069, NoSuchMethodException -> 0x0065 }
            java.lang.Class<java.lang.Object> r10 = java.lang.Object.class
            r9[r4] = r10     // Catch:{ ClassNotFoundException -> 0x0072, IllegalAccessException -> 0x006d, InstantiationException -> 0x0069, NoSuchMethodException -> 0x0065 }
            java.lang.reflect.Method r8 = r7.getDeclaredMethod(r8, r9)     // Catch:{ ClassNotFoundException -> 0x0072, IllegalAccessException -> 0x006d, InstantiationException -> 0x0069, NoSuchMethodException -> 0x0065 }
            java.lang.String r9 = "initialize"
            java.lang.Class[] r10 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            java.lang.Class<android.content.Context> r11 = android.content.Context.class
            r10[r4] = r11     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            java.lang.reflect.Method r6 = r7.getDeclaredMethod(r9, r10)     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            java.lang.String r9 = "logEvent"
            r10 = 2
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            r11[r4] = r1     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            r11[r5] = r0     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            java.lang.reflect.Method r9 = r7.getDeclaredMethod(r9, r11)     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            r12.klm = r9     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            java.lang.String r9 = "logAutoEvent"
            java.lang.Class[] r10 = new java.lang.Class[r10]     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            r10[r4] = r1     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            r10[r5] = r0     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            java.lang.reflect.Method r0 = r7.getDeclaredMethod(r9, r10)     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            r12.ikl = r0     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            java.lang.String r0 = "setParameter"
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            r1[r4] = r9     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            java.lang.reflect.Method r0 = r7.getDeclaredMethod(r0, r1)     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            r12.hij = r0     // Catch:{ ClassNotFoundException -> 0x0062, IllegalAccessException -> 0x005f, InstantiationException -> 0x005c, NoSuchMethodException -> 0x0059 }
            goto L_0x007a
        L_0x0059:
            r0 = r6
            r6 = r8
            goto L_0x0066
        L_0x005c:
            r0 = r6
            r6 = r8
            goto L_0x006a
        L_0x005f:
            r0 = r6
            r6 = r8
            goto L_0x006e
        L_0x0062:
            r0 = r6
            r6 = r8
            goto L_0x0073
        L_0x0065:
            r0 = r6
        L_0x0066:
            java.lang.String r1 = "No such method warning"
            goto L_0x0075
        L_0x0069:
            r0 = r6
        L_0x006a:
            java.lang.String r1 = "Instantiation warning"
            goto L_0x0075
        L_0x006d:
            r0 = r6
        L_0x006e:
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r2)
            goto L_0x0078
        L_0x0072:
            r0 = r6
        L_0x0073:
            java.lang.String r1 = "Class not found warning"
        L_0x0075:
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r1)
        L_0x0078:
            r8 = r6
            r6 = r0
        L_0x007a:
            if (r8 == 0) goto L_0x0085
            java.lang.Object r0 = r12.ijk     // Catch:{ IllegalAccessException -> 0x0097, InvocationTargetException -> 0x0091 }
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException -> 0x0097, InvocationTargetException -> 0x0091 }
            r1[r4] = r12     // Catch:{ IllegalAccessException -> 0x0097, InvocationTargetException -> 0x0091 }
            r8.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x0097, InvocationTargetException -> 0x0091 }
        L_0x0085:
            if (r6 == 0) goto L_0x009a
            java.lang.Object r0 = r12.ijk     // Catch:{ IllegalAccessException -> 0x0097, InvocationTargetException -> 0x0091 }
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException -> 0x0097, InvocationTargetException -> 0x0091 }
            r1[r4] = r13     // Catch:{ IllegalAccessException -> 0x0097, InvocationTargetException -> 0x0091 }
            r6.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x0097, InvocationTargetException -> 0x0091 }
            goto L_0x009a
        L_0x0091:
            java.lang.String r13 = "Invocation target warning"
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r13)
            return
        L_0x0097:
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r2)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.internal.filter.EventFilter.lmn(android.content.Context):void");
    }

    public final void lmn(bp bpVar) {
        this.lmn = bpVar;
    }

    public final void lmn(String str, Bundle bundle) {
        String str2;
        Method method = this.ikl;
        if (method != null) {
            try {
                method.invoke(this.ijk, new Object[]{str, bundle});
            } catch (IllegalAccessException unused) {
                str2 = "Illegal access warning";
                HiLog.w("IncidentFilter", str2);
            } catch (InvocationTargetException unused2) {
                str2 = "Invocation target warning";
                HiLog.w("IncidentFilter", str2);
            }
        }
    }

    public final void lmn(Map<Object, Object> map) {
        String str;
        if (this.hij == null) {
            str = "analytics callback init failed, pls check log.";
        } else if (map.size() <= 0) {
            str = "params is empty,Not need notify DTM";
        } else {
            try {
                this.hij.invoke(this.ijk, new Object[]{map});
                return;
            } catch (IllegalAccessException unused) {
                str = "Illegal access warning";
            } catch (InvocationTargetException unused2) {
                str = "Invocation target warning";
            }
        }
        HiLog.w("IncidentFilter", str);
    }

    public final boolean lmn(String str, String str2, String str3, Bundle bundle) {
        if (this.klm == null) {
            return false;
        }
        bundle.putString("$HA_FIXED_TAG", str);
        bundle.putString("$HA_FIXED_TYPE", str2);
        bundle.putString("$HA_FIXED_SOURCE", "Event");
        return klm(str3, bundle);
    }

    public final boolean lmn(String str, String str2, String str3, Bundle bundle, long j11) {
        if (this.klm == null) {
            return false;
        }
        bundle.putString("$HA_FIXED_TAG", str);
        bundle.putString("$HA_FIXED_TYPE", str2);
        bundle.putString("$HA_FIXED_SOURCE", "StreamEvent");
        bundle.putString("$HA_FIXED_TIMESTAMP", String.valueOf(j11));
        return klm(str3, bundle);
    }

    public void logFilteredEvent(String str, Bundle bundle) {
        HiLog.d("IncidentFilter", "log filtered evtID#".concat(String.valueOf(str)));
        if (this.lmn != null) {
            if (bundle != null) {
                String string = bundle.getString("$HA_FIXED_SOURCE");
                String string2 = bundle.getString("$HA_FIXED_TAG");
                if (str != null && str.length() <= 256 && dl.lmn(UrlConstantsKt.WALLET_EVENT_ID, str, aq.klm)) {
                    String string3 = bundle.getString("$HA_FIXED_TYPE");
                    lmn(bundle.getString("$HA_FIXED_TIMESTAMP"));
                    lmn(bundle);
                    dt dtVar = new dt(str, true);
                    if (!dtVar.lmn(bundle)) {
                        HiLog.w("IncidentFilter", "bundle params is invalid.");
                    } else if ("Event".equals(string)) {
                        HiLog.i("IncidentFilter", "begin onEventFiltered");
                        if (lmn(string2, string3)) {
                            this.lmn.lmn(string2, str, dtVar.ikl);
                            bn.lmn(this.ghi);
                            bn.klm().lmn(string2, "oper", str, dtVar.lmn);
                        }
                    } else if ("StreamEvent".equals(string)) {
                        HiLog.i("IncidentFilter", "begin onStreamEventFiltered");
                        if (lmn(string2, string3)) {
                            this.lmn.klm(string2, str, dtVar.ikl);
                            bn.lmn(this.ghi);
                            bn.klm().lmn(string2, "oper", str, dtVar.lmn, System.currentTimeMillis());
                        }
                    } else {
                        HiLog.i("IncidentFilter", "begin onEventFiltered with default");
                        this.lmn.lmn("_openness_config_tag", str, dtVar.ikl);
                        bn.lmn(this.ghi);
                        bn.klm().lmn(string2, "oper", str, dtVar.lmn);
                    }
                }
            } else {
                HiLog.e("IncidentFilter", "the params is null");
            }
        }
    }
}
