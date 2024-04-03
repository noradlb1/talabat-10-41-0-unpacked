package com.instabug.chat.model;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.chat.util.b;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.encryption.EncryptionManager;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.model.BaseReport;
import com.instabug.library.model.State;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

@Instrumented
@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class d extends BaseReport implements Cacheable {

    /* renamed from: a  reason: collision with root package name */
    private String f46024a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private State f46025b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f46026c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private b f46027d;

    public d() {
        this.f46027d = b.NOT_AVAILABLE;
        this.f46026c = new ArrayList();
    }

    public d(@NonNull String str) {
        this.f46024a = str;
        this.f46026c = new ArrayList();
        a(b.SENT);
    }

    @Nullable
    private k d() {
        k e11 = e();
        if (e11 == null || !e11.o()) {
            return e11;
        }
        Iterator it = this.f46026c.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (!kVar.o()) {
                return kVar;
            }
        }
        return null;
    }

    private void l() {
        for (int i11 = 0; i11 < f().size(); i11++) {
            ((k) f().get(i11)).b(this.f46024a);
        }
    }

    @Nullable
    public b a() {
        return this.f46027d;
    }

    public d a(@Nullable b bVar) {
        this.f46027d = bVar;
        return this;
    }

    /* renamed from: a */
    public d setState(@Nullable State state) {
        this.f46025b = state;
        return this;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    /* renamed from: a */
    public d setId(String str) {
        this.f46024a = str;
        l();
        return this;
    }

    public d a(ArrayList arrayList) {
        this.f46026c = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add((Object) null);
        arrayList.removeAll(arrayList2);
        l();
        return this;
    }

    @Nullable
    public k b() {
        ArrayList arrayList = this.f46026c;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        Collections.sort(this.f46026c, new h(2));
        ArrayList arrayList2 = this.f46026c;
        return (k) arrayList2.get(arrayList2.size() - 1);
    }

    public long c() {
        if (b() != null) {
            return b().i();
        }
        return 0;
    }

    @Nullable
    public k e() {
        for (int size = this.f46026c.size() - 1; size >= 0; size--) {
            if (((k) this.f46026c.get(size)).h() == j.SYNCED) {
                return (k) this.f46026c.get(size);
            }
        }
        return null;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (String.valueOf(dVar.getId()).equals(getId()) && dVar.a() == a() && ((dVar.getState() == null && getState() == null) || !(getState() == null || dVar.getState() == null || !dVar.getState().equals(getState())))) {
                for (int i11 = 0; i11 < dVar.f().size(); i11++) {
                    if (!((k) dVar.f().get(i11)).equals(f().get(i11))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public ArrayList f() {
        return this.f46026c;
    }

    public void fromJson(String str) {
        String decrypt = EncryptionManager.decrypt(str);
        if (decrypt != null) {
            JSONObject jSONObject = new JSONObject(decrypt);
            if (jSONObject.has("id")) {
                setId(jSONObject.getString("id"));
            }
            if (jSONObject.has("messages")) {
                a(k.a(jSONObject.getJSONArray("messages")));
            }
            if (jSONObject.has("chat_state")) {
                a(b.valueOf(jSONObject.getString("chat_state")));
            }
            if (jSONObject.has("state")) {
                State state = new State();
                state.fromJson(jSONObject.getString("state"));
                setState(state);
            }
        }
    }

    @Nullable
    public String g() {
        k d11 = d();
        if (d11 != null) {
            return d11.m();
        }
        return null;
    }

    public String getId() {
        return this.f46024a;
    }

    @Nullable
    public State getState() {
        return this.f46025b;
    }

    @Nullable
    public String h() {
        k d11 = d();
        if (d11 != null) {
            return d11.n();
        }
        if (this.f46026c.size() == 0) {
            return "";
        }
        ArrayList arrayList = this.f46026c;
        return ((k) arrayList.get(arrayList.size() - 1)).n();
    }

    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        }
        return -1;
    }

    public String i() {
        String h11 = h();
        return (h11 == null || h11.equals("") || h11.equals(" ") || h11.equals("null") || b() == null || b().o()) ? b.a() : h11;
    }

    public int j() {
        Iterator it = this.f46026c.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (!((k) it.next()).p()) {
                i11++;
            }
        }
        return i11;
    }

    public void k() {
        for (int size = this.f46026c.size() - 1; size >= 0; size--) {
            ((k) this.f46026c.get(size)).a(true);
        }
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", (Object) getId()).put("messages", (Object) k.c(f()));
        if (a() != null) {
            jSONObject.put("chat_state", (Object) a().toString());
        }
        if (getState() != null) {
            jSONObject.put("state", (Object) getState().toJson());
        }
        if (InstabugCore.getEncryptionState() != Feature.State.ENABLED) {
            return JSONObjectInstrumentation.toString(jSONObject);
        }
        String encrypt = EncryptionManager.encrypt(JSONObjectInstrumentation.toString(jSONObject));
        return encrypt != null ? encrypt : JSONObjectInstrumentation.toString(jSONObject);
    }

    @NonNull
    public String toString() {
        return "Chat:[" + this.f46024a + " chatState: " + a() + "]";
    }
}
