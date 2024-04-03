package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.a;
import com.huawei.hms.framework.network.grs.g.j.c;
import com.huawei.hms.framework.network.grs.h.e;
import org.json.JSONException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f48881a;

    /* renamed from: b  reason: collision with root package name */
    private final GrsBaseInfo f48882b;

    /* renamed from: c  reason: collision with root package name */
    private final a f48883c;

    public b(Context context, a aVar, GrsBaseInfo grsBaseInfo) {
        this.f48881a = context;
        this.f48882b = grsBaseInfo;
        this.f48883c = aVar;
    }

    public String a(boolean z11) {
        String str;
        String str2 = com.huawei.hms.framework.network.grs.a.a(this.f48883c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.i("GeoipCountry", "geoIpCountry is: " + str2);
        String a11 = this.f48883c.a().a("geoipCountryCodetime", "0");
        long j11 = 0;
        if (!TextUtils.isEmpty(a11) && a11.matches("\\d+")) {
            try {
                j11 = Long.parseLong(a11);
            } catch (NumberFormatException e11) {
                Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", (Throwable) e11);
            }
        }
        if (TextUtils.isEmpty(str2) || e.a(Long.valueOf(j11))) {
            c cVar = new c(this.f48882b, this.f48881a);
            cVar.a("geoip.countrycode");
            com.huawei.hms.framework.network.grs.e.c c11 = this.f48883c.c();
            if (c11 != null) {
                try {
                    str = h.a(c11.a("services", ""), cVar.c());
                } catch (JSONException e12) {
                    Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e12.getMessage()));
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    c11.b("services", str);
                }
            }
            if (z11) {
                d a12 = this.f48883c.b().a(cVar, "geoip.countrycode", c11, -1);
                if (a12 != null) {
                    str2 = com.huawei.hms.framework.network.grs.a.a(a12.j(), "geoip.countrycode").get("ROOT");
                }
                Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str2);
            } else {
                Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.f48883c.b().a(cVar, (com.huawei.hms.framework.network.grs.b) null, "geoip.countrycode", c11, -1);
            }
        }
        return str2;
    }
}
