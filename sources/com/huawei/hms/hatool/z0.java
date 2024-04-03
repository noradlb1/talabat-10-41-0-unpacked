package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

public class z0 {

    /* renamed from: a  reason: collision with root package name */
    private String f49150a;

    /* renamed from: b  reason: collision with root package name */
    public l1 f49151b;

    public z0(String str) {
        this.f49150a = str;
        this.f49151b = new l1(str);
        s.c().a(this.f49150a, this.f49151b);
    }

    private s0 b(int i11) {
        if (i11 == 0) {
            return this.f49151b.c();
        }
        if (i11 == 1) {
            return this.f49151b.b();
        }
        if (i11 == 2) {
            return this.f49151b.d();
        }
        if (i11 != 3) {
            return null;
        }
        return this.f49151b.a();
    }

    private boolean c(int i11) {
        String str;
        if (i11 != 2) {
            s0 b11 = b(i11);
            if (b11 != null && !TextUtils.isEmpty(b11.h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i11;
        } else if ("_default_config_tag".equals(this.f49150a)) {
            return true;
        } else {
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        v.e("hmsSdk", str);
        return false;
    }

    public void a(int i11) {
        v.d("hmsSdk", "onReport. TAG: " + this.f49150a + ", TYPE: " + i11);
        g0.a().a(this.f49150a, i11);
    }

    public void a(int i11, String str, LinkedHashMap<String, String> linkedHashMap) {
        v.d("hmsSdk", "onEvent. TAG: " + this.f49150a + ", TYPE: " + i11 + ", eventId : " + str);
        if (e1.a(str) || !c(i11)) {
            v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f49150a + ", TYPE: " + i11);
            return;
        }
        if (!e1.a((Map<String, String>) linkedHashMap)) {
            v.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f49150a + ", TYPE: " + i11);
            linkedHashMap = null;
        }
        g0.a().a(this.f49150a, i11, str, linkedHashMap);
    }

    public void a(Context context, String str, String str2) {
        v.d("hmsSdk", "onEvent(context). TAG: " + this.f49150a + ", eventId : " + str);
        if (context == null) {
            v.e("hmsSdk", "context is null in onevent ");
        } else if (e1.a(str) || !c(0)) {
            v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f49150a);
        } else {
            if (!e1.a("value", str2, 65536)) {
                v.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f49150a);
                str2 = "";
            }
            g0.a().a(this.f49150a, context, str, str2);
        }
    }

    public void a(s0 s0Var) {
        v.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f49150a);
        if (s0Var == null) {
            v.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.f49151b.a((s0) null);
            return;
        }
        this.f49151b.a(s0Var);
    }

    public void b(int i11, String str, LinkedHashMap<String, String> linkedHashMap) {
        v.d("hmsSdk", "onStreamEvent. TAG: " + this.f49150a + ", TYPE: " + i11 + ", eventId : " + str);
        if (e1.a(str) || !c(i11)) {
            v.e("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f49150a + ", TYPE: " + i11);
            return;
        }
        if (!e1.a((Map<String, String>) linkedHashMap)) {
            v.e("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f49150a + ", TYPE: " + i11);
            linkedHashMap = null;
        }
        g0.a().b(this.f49150a, i11, str, linkedHashMap);
    }

    public void b(s0 s0Var) {
        v.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f49150a);
        if (s0Var == null) {
            this.f49151b.b((s0) null);
            v.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
            return;
        }
        this.f49151b.b(s0Var);
    }
}
