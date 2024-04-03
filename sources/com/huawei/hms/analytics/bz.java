package com.huawei.hms.analytics;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.RomAttributeCollector;
import org.json.JSONException;
import org.json.JSONObject;

public final class bz implements RomAttributeCollector {
    int A;
    int B;

    /* renamed from: a  reason: collision with root package name */
    String f47879a;
    String abc;

    /* renamed from: b  reason: collision with root package name */
    String f47880b;
    String bcd;

    /* renamed from: c  reason: collision with root package name */
    int f47881c;
    String cde;

    /* renamed from: d  reason: collision with root package name */
    int f47882d;
    String def;

    /* renamed from: e  reason: collision with root package name */
    String f47883e;
    String efg;

    /* renamed from: f  reason: collision with root package name */
    boolean f47884f;
    String fgh;

    /* renamed from: g  reason: collision with root package name */
    Boolean f47885g;
    String ghi;

    /* renamed from: h  reason: collision with root package name */
    String f47886h;
    String hij;

    /* renamed from: i  reason: collision with root package name */
    String f47887i;
    String ijk;
    String ikl;

    /* renamed from: j  reason: collision with root package name */
    String f47888j;

    /* renamed from: k  reason: collision with root package name */
    long f47889k;
    String klm;

    /* renamed from: l  reason: collision with root package name */
    long f47890l;
    String lmn;

    /* renamed from: m  reason: collision with root package name */
    long f47891m;

    /* renamed from: n  reason: collision with root package name */
    long f47892n;

    /* renamed from: o  reason: collision with root package name */
    int f47893o;

    /* renamed from: p  reason: collision with root package name */
    String f47894p;

    /* renamed from: q  reason: collision with root package name */
    boolean f47895q;

    /* renamed from: r  reason: collision with root package name */
    String f47896r;

    /* renamed from: s  reason: collision with root package name */
    String f47897s;

    /* renamed from: t  reason: collision with root package name */
    String f47898t;

    /* renamed from: u  reason: collision with root package name */
    Integer f47899u;

    /* renamed from: v  reason: collision with root package name */
    Integer f47900v;

    /* renamed from: w  reason: collision with root package name */
    Boolean f47901w;

    /* renamed from: x  reason: collision with root package name */
    Boolean f47902x;

    /* renamed from: y  reason: collision with root package name */
    String f47903y;

    /* renamed from: z  reason: collision with root package name */
    int f47904z;

    public final JSONObject doCollector() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_is_testdevice", this.A);
            jSONObject.put("_new_user_flag", this.f47904z);
            jSONObject.put("_signed", this.B);
            jSONObject.put("_rom_ver", (Object) this.lmn);
            jSONObject.put("_emui_ver", (Object) this.klm);
            jSONObject.put("_user_agent", (Object) this.f47897s);
            jSONObject.put("_model", (Object) this.ikl);
            jSONObject.put("_package_name", (Object) this.ijk);
            jSONObject.put("_app_ver", (Object) this.hij);
            jSONObject.put("_lib_ver", (Object) this.ghi);
            jSONObject.put("_lib_name", (Object) this.def);
            jSONObject.put("_lib_type", (Object) this.cde);
            jSONObject.put("_channel", (Object) this.efg);
            jSONObject.put("_restriction_enabled", this.f47884f);
            jSONObject.put("_restriction_shared", (Object) this.f47885g);
            jSONObject.put("_terminal_name", (Object) this.fgh);
            jSONObject.put("_sys_language", (Object) this.f47879a);
            jSONObject.put("_manufacturer", (Object) this.f47880b);
            jSONObject.put("_os", (Object) this.bcd);
            jSONObject.put("_os_ver", (Object) this.abc);
            jSONObject.put("_screen_height", this.f47881c);
            jSONObject.put("_screen_width", this.f47882d);
            jSONObject.put("_device_category", (Object) this.f47883e);
            jSONObject.put("_ab_info", (Object) this.f47886h);
            jSONObject.put("_oaid_tracking_flag", (Object) this.f47887i);
            jSONObject.put("_network_type", (Object) this.f47888j);
            jSONObject.put("_total_storage", this.f47889k);
            jSONObject.put("_free_storage", this.f47890l);
            jSONObject.put("_free_memory", this.f47892n);
            jSONObject.put("_total_memory", this.f47891m);
            jSONObject.put("_battery_level", this.f47893o);
            jSONObject.put("_battery_state", (Object) this.f47894p);
            jSONObject.put("_allow_push", this.f47895q);
            jSONObject.put("_first_open_time", (Object) this.f47896r);
            jSONObject.put("_font_family", (Object) "");
            jSONObject.put("_font_size", (Object) this.f47898t);
            jSONObject.put("_font_weight", (Object) "");
            jSONObject.put("_font_style", (Object) "");
            jSONObject.put("_screen_brightness", (Object) this.f47899u);
            jSONObject.put("_ringer_mode", (Object) this.f47900v);
            jSONObject.put("_dark_mode", (Object) this.f47901w);
            jSONObject.put("_auto_rotate", (Object) this.f47902x);
            jSONObject.put("_campaign_info", (Object) this.f47903y);
        } catch (JSONException unused) {
            HiLog.w("OpennessRomGathering", "doCollector JSONException");
        }
        return jSONObject;
    }
}
