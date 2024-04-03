package com.instabug.chat.model;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.user.UserManagerWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Instrumented
public class k implements Cacheable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f46058a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f46059b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f46060c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f46061d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f46062e;

    /* renamed from: f  reason: collision with root package name */
    private long f46063f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f46064g;

    /* renamed from: h  reason: collision with root package name */
    private long f46065h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList f46066i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList f46067j;

    /* renamed from: k  reason: collision with root package name */
    private i f46068k;

    /* renamed from: l  reason: collision with root package name */
    private j f46069l;

    /* renamed from: m  reason: collision with root package name */
    private String f46070m;

    /* renamed from: n  reason: collision with root package name */
    private String f46071n;

    /* renamed from: o  reason: collision with root package name */
    private String f46072o;

    public k(String str, String str2, String str3) {
        this(String.valueOf(System.currentTimeMillis()), str, str2, str3);
    }

    public k(String str, String str2, String str3, String str4) {
        this.f46058a = str;
        this.f46066i = new ArrayList();
        this.f46067j = new ArrayList();
        this.f46068k = i.NOT_AVAILABLE;
        this.f46069l = j.NOT_AVAILABLE;
        this.f46070m = str2;
        this.f46071n = str3;
        this.f46072o = str4;
    }

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            k kVar = new k(UserManagerWrapper.getUserName(), UserManagerWrapper.getUserEmail(), InstabugCore.getPushNotificationToken());
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            kVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            arrayList.add(kVar);
        }
        return arrayList;
    }

    public static JSONArray c(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            jSONArray.put((Object) new JSONObject(((k) arrayList.get(i11)).toJson()));
        }
        return jSONArray;
    }

    public k a(long j11) {
        this.f46063f = j11;
        return this;
    }

    public k a(a aVar) {
        this.f46066i.add(aVar);
        return this;
    }

    public k a(i iVar) {
        this.f46068k = iVar;
        if (iVar == i.INBOUND) {
            this.f46064g = true;
        }
        return this;
    }

    public k a(j jVar) {
        this.f46069l = jVar;
        return this;
    }

    public k a(m mVar) {
        this.f46067j.add(mVar);
        return this;
    }

    public k a(String str) {
        this.f46060c = str;
        return this;
    }

    public k a(ArrayList arrayList) {
        this.f46067j = arrayList;
        return this;
    }

    public k a(boolean z11) {
        this.f46064g = z11;
        return this;
    }

    public ArrayList a() {
        return this.f46067j;
    }

    public k b(long j11) {
        this.f46065h = j11;
        if (j11 != 0) {
            this.f46064g = true;
        }
        return this;
    }

    public k b(String str) {
        this.f46059b = str;
        return this;
    }

    public k b(@NonNull ArrayList arrayList) {
        this.f46066i = arrayList;
        return this;
    }

    public ArrayList b() {
        return this.f46066i;
    }

    public k c(String str) {
        this.f46058a = str;
        return this;
    }

    @Nullable
    public String c() {
        return this.f46060c;
    }

    public k d(String str) {
        this.f46062e = str;
        return this;
    }

    @Nullable
    public String d() {
        return this.f46059b;
    }

    public k e(String str) {
        this.f46061d = str;
        return this;
    }

    public String e() {
        return this.f46072o;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof k)) {
            k kVar = (k) obj;
            if (String.valueOf(kVar.f()).equals(String.valueOf(f())) && String.valueOf(kVar.d()).equals(String.valueOf(d())) && String.valueOf(kVar.n()).equals(String.valueOf(n())) && String.valueOf(kVar.m()).equals(String.valueOf(m())) && String.valueOf(kVar.c()).equals(String.valueOf(c())) && kVar.i() == i() && kVar.h() == h() && kVar.g() == g() && kVar.o() == o() && kVar.p() == p() && kVar.j() == j() && kVar.b() != null && kVar.b().size() == b().size() && kVar.a() != null && kVar.a().size() == a().size()) {
                for (int i11 = 0; i11 < kVar.b().size(); i11++) {
                    if (!((a) kVar.b().get(i11)).equals(b().get(i11))) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < kVar.a().size(); i12++) {
                    if (!((m) kVar.a().get(i12)).equals(a().get(i12))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f46058a;
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            c(jSONObject.getString("id"));
        }
        if (jSONObject.has("chat_id")) {
            b(jSONObject.getString("chat_id"));
        }
        if (jSONObject.has("body")) {
            a(jSONObject.getString("body"));
        }
        if (jSONObject.has(PushNotificationParser.SENDER_NAME_KEY)) {
            e(jSONObject.getString(PushNotificationParser.SENDER_NAME_KEY));
        }
        if (jSONObject.has("sender_avatar_url")) {
            d(jSONObject.getString("sender_avatar_url"));
        }
        if (jSONObject.has("messaged_at")) {
            a(jSONObject.getLong("messaged_at"));
        }
        if (jSONObject.has("read")) {
            a(jSONObject.getBoolean("read"));
        }
        if (jSONObject.has("read_at")) {
            b(jSONObject.getLong("read_at"));
        }
        if (jSONObject.has(InstabugDbContract.AttachmentEntry.TABLE_NAME)) {
            b(a.a(jSONObject.getJSONArray(InstabugDbContract.AttachmentEntry.TABLE_NAME)));
        }
        if (jSONObject.has("actions")) {
            a(m.a(jSONObject.getJSONArray("actions")));
        }
        if (jSONObject.has(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)) {
            String string = jSONObject.getString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
            string.hashCode();
            a(!string.equals("outbound") ? !string.equals("inbound") ? i.NOT_AVAILABLE : i.INBOUND : i.OUTBOUND);
        }
        if (jSONObject.has("messages_state")) {
            a(j.valueOf(jSONObject.getString("messages_state")));
        }
    }

    public i g() {
        return this.f46068k;
    }

    public j h() {
        return this.f46069l;
    }

    public int hashCode() {
        if (f() != null) {
            return f().hashCode();
        }
        return -1;
    }

    public long i() {
        return this.f46063f;
    }

    public long j() {
        return this.f46065h;
    }

    public String k() {
        return this.f46071n;
    }

    public String l() {
        return this.f46070m;
    }

    @Nullable
    public String m() {
        return this.f46062e;
    }

    @Nullable
    public String n() {
        return this.f46061d;
    }

    public boolean o() {
        i iVar = this.f46068k;
        return iVar != null && iVar == i.INBOUND;
    }

    public boolean p() {
        return this.f46064g;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", (Object) f()).put("chat_id", (Object) d()).put("body", (Object) c()).put(PushNotificationParser.SENDER_NAME_KEY, (Object) n()).put("sender_avatar_url", (Object) m()).put("messaged_at", i()).put("read", p()).put("read_at", j()).put("messages_state", (Object) h().toString()).put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, (Object) g().toString()).put(InstabugDbContract.AttachmentEntry.TABLE_NAME, (Object) a.a(b())).put("actions", (Object) m.a(a()));
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @NonNull
    public String toString() {
        return "Message:[" + this.f46058a + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f46059b + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f46060c + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f46063f + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f46065h + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f46061d + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f46062e + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f46069l + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f46068k + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f46064g + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f46066i + "]";
    }
}
