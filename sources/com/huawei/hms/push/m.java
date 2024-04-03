package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class m {
    private String A = "";
    private int B;
    private String C = "";
    private String D;
    private String E = "";
    private String F = "";

    /* renamed from: a  reason: collision with root package name */
    private String f49750a = "";

    /* renamed from: b  reason: collision with root package name */
    private int f49751b;

    /* renamed from: c  reason: collision with root package name */
    private String f49752c;

    /* renamed from: d  reason: collision with root package name */
    private String f49753d;

    /* renamed from: e  reason: collision with root package name */
    private String f49754e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f49755f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f49756g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f49757h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f49758i = "";

    /* renamed from: j  reason: collision with root package name */
    private String f49759j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f49760k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f49761l;

    /* renamed from: m  reason: collision with root package name */
    private String f49762m;

    /* renamed from: n  reason: collision with root package name */
    private String f49763n;

    /* renamed from: o  reason: collision with root package name */
    private String f49764o;

    /* renamed from: p  reason: collision with root package name */
    private String f49765p;

    /* renamed from: q  reason: collision with root package name */
    private String f49766q = "";

    /* renamed from: r  reason: collision with root package name */
    private String f49767r;

    /* renamed from: s  reason: collision with root package name */
    private String f49768s;

    /* renamed from: t  reason: collision with root package name */
    private int f49769t = i.STYLE_DEFAULT.ordinal();

    /* renamed from: u  reason: collision with root package name */
    private String f49770u = "";

    /* renamed from: v  reason: collision with root package name */
    private String f49771v = "";

    /* renamed from: w  reason: collision with root package name */
    private String f49772w = "";

    /* renamed from: x  reason: collision with root package name */
    private int f49773x = 0;

    /* renamed from: y  reason: collision with root package name */
    private int f49774y = 0;

    /* renamed from: z  reason: collision with root package name */
    private String f49775z;

    public m(byte[] bArr, byte[] bArr2) {
        Charset charset = k.f49748a;
        this.f49767r = new String(bArr, charset);
        this.f49768s = new String(bArr2, charset);
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, (Object) jSONObject);
        jSONObject2.put("group", (Object) this.f49750a);
        jSONObject2.put("tag", (Object) this.A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.f49773x);
        jSONObject2.put("visibility", this.f49774y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, (Object) this.f49775z);
        return jSONObject2;
    }

    private JSONObject b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cmd", (Object) this.f49756g);
        jSONObject2.put("content", (Object) this.f49757h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, (Object) this.f49758i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, (Object) this.f49759j);
        jSONObject2.put("notifySummary", (Object) this.f49760k);
        jSONObject2.put(RemoteMessageConst.MessageBody.PARAM, (Object) jSONObject);
        return jSONObject2;
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb2 = new StringBuilder();
            if (TextUtils.isEmpty(string) || string.length() >= 48) {
                this.f49753d = string.substring(0, 48);
                return;
            }
            int length = 48 - string.length();
            for (int i11 = 0; i11 < length; i11++) {
                sb2.append("0");
            }
            sb2.append(string);
            this.f49753d = sb2.toString();
        }
    }

    private boolean d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f49762m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f49752c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has("appPackageName")) {
            this.f49761l = jSONObject.getString("appPackageName");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    private boolean e(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MSGID)) {
            Object obj = jSONObject.get(RemoteMessageConst.MSGID);
            if (obj instanceof String) {
                this.f49754e = (String) obj;
                return true;
            } else if (!(obj instanceof Integer)) {
                return true;
            } else {
                this.f49754e = String.valueOf(((Integer) obj).intValue());
                return true;
            }
        } else {
            HMSLog.i("PushSelfShowLog", "msgId == null");
            return false;
        }
    }

    private boolean f(JSONObject jSONObject) {
        HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has("style")) {
                this.f49769t = jSONObject2.getInt("style");
            }
            this.f49770u = jSONObject2.optString("bigTitle");
            this.f49771v = jSONObject2.optString("bigContent");
            this.E = jSONObject2.optString("icon");
            return true;
        } catch (JSONException e11) {
            HMSLog.i("PushSelfShowLog", e11.toString());
            return false;
        }
    }

    private void g(JSONObject jSONObject) {
        this.f49750a = jSONObject.optString("group");
        HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f49750a);
        this.f49773x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.d("PushSelfShowLog", "autoCancel: " + this.f49773x);
        this.f49774y = jSONObject.optInt("visibility", 0);
        this.f49775z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.A = jSONObject.optString("tag");
    }

    private boolean h(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PARAM);
            if (jSONObject2.has("autoClear")) {
                this.f49751b = jSONObject2.getInt("autoClear");
            } else {
                this.f49751b = 0;
            }
            if (!"app".equals(this.f49756g)) {
                if (!"cosa".equals(this.f49756g)) {
                    if ("url".equals(this.f49756g)) {
                        k(jSONObject2);
                        return true;
                    } else if (!"rp".equals(this.f49756g)) {
                        return true;
                    } else {
                        j(jSONObject2);
                        return true;
                    }
                }
            }
            d(jSONObject2);
            return true;
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", "ParseParam error ", (Throwable) e11);
            return false;
        }
    }

    private boolean i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f49756g = jSONObject2.getString("cmd");
            this.f49757h = jSONObject2.optString("content");
            this.f49758i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f49759j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f49760k = jSONObject2.optString("notifySummary");
            this.D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || f(jSONObject2)) && jSONObject2.has(RemoteMessageConst.MessageBody.PARAM)) {
                return h(jSONObject2);
            }
        }
        return false;
    }

    private boolean j(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.f49761l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
            return false;
        }
        this.f49764o = jSONObject.getString("rpl");
        this.f49765p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.f49766q = jSONObject.getString("rpct");
        return true;
    }

    private boolean k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("url")) {
            this.f49763n = jSONObject.getString("url");
            if (jSONObject.has("appPackageName")) {
                this.f49761l = jSONObject.getString("appPackageName");
            }
            if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
                return true;
            }
            this.f49764o = jSONObject.getString("rpl");
            this.f49765p = jSONObject.getString("rpt");
            if (!jSONObject.has("rpct")) {
                return true;
            }
            this.f49766q = jSONObject.getString("rpct");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "url is null");
        return false;
    }

    private JSONObject r() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.f49769t);
        jSONObject.put("bigTitle", (Object) this.f49770u);
        jSONObject.put("bigContent", (Object) this.f49771v);
        jSONObject.put("bigPic", (Object) this.f49772w);
        return jSONObject;
    }

    private JSONObject v() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.f49751b);
        jSONObject.put("url", (Object) this.f49763n);
        jSONObject.put("rpl", (Object) this.f49764o);
        jSONObject.put("rpt", (Object) this.f49765p);
        jSONObject.put("rpct", (Object) this.f49766q);
        jSONObject.put("appPackageName", (Object) this.f49761l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, (Object) this.f49762m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, (Object) this.f49752c);
        return jSONObject;
    }

    public String l() {
        return this.f49750a;
    }

    public String m() {
        return this.E;
    }

    public String n() {
        return this.f49752c;
    }

    public byte[] o() {
        String str;
        try {
            JSONObject a11 = a(a(b(v()), r()));
            if (!(a11 instanceof JSONObject)) {
                str = a11.toString();
            } else {
                str = JSONObjectInstrumentation.toString(a11);
            }
            return str.getBytes(k.f49748a);
        } catch (JSONException e11) {
            HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", (Throwable) e11);
            return new byte[0];
        }
    }

    public String p() {
        HMSLog.d("PushSelfShowLog", "msgId =" + this.f49754e);
        return this.f49754e;
    }

    public String q() {
        return this.A;
    }

    public int s() {
        return this.B;
    }

    public String t() {
        return this.f49760k;
    }

    public String u() {
        return this.f49759j;
    }

    public int w() {
        return this.f49769t;
    }

    public String x() {
        return this.D;
    }

    public byte[] y() {
        return this.f49768s.getBytes(k.f49748a);
    }

    public boolean z() {
        try {
            if (TextUtils.isEmpty(this.f49767r)) {
                HMSLog.d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.f49767r);
            g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!e(jSONObject2)) {
                return false;
            }
            this.f49755f = jSONObject2.optString("dispPkgName");
            c(jSONObject2);
            this.B = jSONObject2.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);
            this.C = jSONObject2.optString("data");
            this.F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
            return i(jSONObject2);
        } catch (JSONException unused) {
            HMSLog.d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e11) {
            HMSLog.d("PushSelfShowLog", e11.toString());
            return false;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", (Object) this.f49755f);
        jSONObject3.put(RemoteMessageConst.MSGID, (Object) this.f49754e);
        jSONObject3.put("ap", (Object) this.f49753d);
        jSONObject3.put(RemoteMessageConst.Notification.NOTIFY_ID, this.B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, (Object) jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, (Object) jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, (Object) this.D);
        jSONObject3.put("data", (Object) this.C);
        return jSONObject3;
    }

    public String b() {
        return this.F;
    }

    public String d() {
        return this.f49761l;
    }

    public String g() {
        return this.f49771v;
    }

    public int e() {
        return this.f49773x;
    }

    public int f() {
        return this.f49751b;
    }

    public String j() {
        return this.f49757h;
    }

    public String c() {
        return this.f49753d;
    }

    public String k() {
        return this.f49755f;
    }

    public String h() {
        return this.f49770u;
    }

    public String i() {
        return this.f49756g;
    }

    public String a() {
        return this.f49762m;
    }

    public void a(int i11) {
        this.B = i11;
    }
}
