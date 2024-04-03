package com.instabug.bug.model;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.BaseReport;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class d extends BaseReport implements Cacheable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f45659a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f45660b;

    /* renamed from: c  reason: collision with root package name */
    private String f45661c;

    /* renamed from: d  reason: collision with root package name */
    private String f45662d;

    /* renamed from: e  reason: collision with root package name */
    private List f45663e;

    /* renamed from: f  reason: collision with root package name */
    private a f45664f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private String f45665g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f45666h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private c f45667i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private transient List f45668j;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList f45669k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private String f45670l;

    public d() {
        this.f45664f = a.NOT_AVAILABLE;
        this.f45661c = "not-available";
    }

    public d(@NonNull String str, @Nullable State state, @NonNull a aVar) {
        this.f45659a = str;
        this.f51503n = state;
        this.f45664f = aVar;
        this.f45661c = "not-available";
        this.f45663e = new CopyOnWriteArrayList();
        this.f45669k = new ArrayList();
    }

    public d a(Uri uri, Attachment.Type type) {
        return a(uri, type, false);
    }

    public d a(@Nullable Uri uri, Attachment.Type type, boolean z11) {
        InstabugSDKLogger.v("IBG-BR", "Started adding attchments to bug");
        if (uri == null) {
            InstabugSDKLogger.w("IBG-BR", "Adding attachment with a null Uri, ignored.");
            return this;
        } else if (type == null) {
            InstabugSDKLogger.w("IBG-BR", "Adding attachment with a null Attachment.Type, ignored.");
            return this;
        } else {
            Attachment attachment = new Attachment();
            if (uri.getLastPathSegment() != null) {
                attachment.setName(uri.getLastPathSegment());
            }
            if (uri.getPath() != null) {
                attachment.setLocalPath(uri.getPath());
            }
            attachment.setType(type);
            if (attachment.getLocalPath() != null && attachment.getLocalPath().contains(InstabugDbContract.AttachmentEntry.TABLE_NAME)) {
                attachment.setEncrypted(true);
            }
            if (type == Attachment.Type.VISUAL_USER_STEPS) {
                attachment.setEncrypted(z11);
                InstabugSDKLogger.i("IBG-BR", "Adding  visual user steps attachments to bug");
            }
            this.f45663e.add(attachment);
            return this;
        }
    }

    public d a(a aVar) {
        this.f45664f = aVar;
        return this;
    }

    public d a(c cVar) {
        this.f45667i = cVar;
        return this;
    }

    /* renamed from: a */
    public d setState(@Nullable State state) {
        this.f51503n = state;
        return this;
    }

    public d a(List list) {
        this.f45663e = new CopyOnWriteArrayList(list);
        return this;
    }

    public d a(boolean z11) {
        this.f45666h = z11;
        return this;
    }

    public synchronized List a() {
        return this.f45663e;
    }

    public void a(String str) {
        this.f45669k.add(str);
    }

    public void a(ArrayList arrayList) {
        this.f45669k = arrayList;
    }

    public void a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            arrayList.add(jSONArray.getString(i11));
        }
        a(arrayList);
    }

    public a b() {
        return this.f45664f;
    }

    /* renamed from: b */
    public d setId(@Nullable String str) {
        this.f45659a = str;
        return this;
    }

    public void b(@Nullable List list) {
        this.f45668j = list;
    }

    public JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f45669k.iterator();
        while (it.hasNext()) {
            jSONArray.put((Object) (String) it.next());
        }
        return jSONArray;
    }

    public void c(@Nullable String str) {
        this.f45670l = str;
    }

    public d d(String str) {
        this.f45662d = str;
        return this;
    }

    public String d() {
        return StringUtility.toCommaSeparated(this.f45669k);
    }

    public d e(@Nullable String str) {
        this.f45660b = str;
        return this;
    }

    @Nullable
    public List e() {
        return this.f45668j;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            if (String.valueOf(dVar.getId()).equals(String.valueOf(getId())) && String.valueOf(dVar.g()).equals(String.valueOf(g())) && String.valueOf(dVar.h()).equals(String.valueOf(h())) && dVar.b() == b() && dVar.getState() != null && dVar.getState().equals(getState()) && dVar.i() != null && dVar.i().equals(i()) && dVar.a() != null && dVar.a().size() == a().size()) {
                for (int i11 = 0; i11 < dVar.a().size(); i11++) {
                    if (!((Attachment) dVar.a().get(i11)).equals(a().get(i11))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public d f(String str) {
        this.f45661c = str;
        return this;
    }

    @Nullable
    public String f() {
        return this.f45670l;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            setId(jSONObject.getString("id"));
        }
        if (jSONObject.has("temporary_server_token")) {
            e(jSONObject.getString("temporary_server_token"));
        }
        if (jSONObject.has("type")) {
            String string = jSONObject.getString("type");
            string.hashCode();
            String str2 = "ask a question";
            char c11 = 65535;
            switch (string.hashCode()) {
                case -191501435:
                    if (string.equals("feedback")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 97908:
                    if (string.equals("bug")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1621082316:
                    if (string.equals(str2)) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    str2 = "feedback";
                    break;
                case 1:
                    str2 = "bug";
                    break;
                case 2:
                    break;
                default:
                    str2 = "not-available";
                    break;
            }
            f(str2);
        }
        if (jSONObject.has("message")) {
            d(jSONObject.getString("message"));
        }
        if (jSONObject.has(InstabugDbContract.BugEntry.COLUMN_BUG_STATE)) {
            a(a.valueOf(jSONObject.getString(InstabugDbContract.BugEntry.COLUMN_BUG_STATE)));
        }
        if (jSONObject.has("state")) {
            State state = new State();
            state.fromJson(jSONObject.getString("state"));
            setState(state);
        }
        if (jSONObject.has(InstabugDbContract.AttachmentEntry.TABLE_NAME)) {
            a((List) Attachment.fromJson(jSONObject.getJSONArray(InstabugDbContract.AttachmentEntry.TABLE_NAME)));
        }
        if (jSONObject.has(InstabugDbContract.BugEntry.COLUMN_VIEW_HIERARCHY)) {
            g(jSONObject.getString(InstabugDbContract.BugEntry.COLUMN_VIEW_HIERARCHY));
        }
        if (jSONObject.has(InstabugDbContract.BugEntry.COLUMN_CATEGORIES_LIST)) {
            a(jSONObject.getJSONArray(InstabugDbContract.BugEntry.COLUMN_CATEGORIES_LIST));
        }
    }

    public d g(String str) {
        this.f45665g = str;
        return this;
    }

    public String g() {
        return this.f45662d;
    }

    @Nullable
    public String getId() {
        return this.f45659a;
    }

    @Nullable
    public String h() {
        return this.f45660b;
    }

    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        }
        return -1;
    }

    public String i() {
        return this.f45661c;
    }

    @Nullable
    public String j() {
        return this.f45665g;
    }

    @Nullable
    public c k() {
        return this.f45667i;
    }

    public int l() {
        int i11 = 0;
        for (Attachment attachment : a()) {
            if (attachment.getType() == Attachment.Type.MAIN_SCREENSHOT || attachment.getType() == Attachment.Type.EXTRA_IMAGE || attachment.getType() == Attachment.Type.GALLERY_IMAGE || attachment.getType() == Attachment.Type.EXTRA_VIDEO || attachment.getType() == Attachment.Type.GALLERY_VIDEO || attachment.getType() == Attachment.Type.AUDIO) {
                i11++;
            }
        }
        return i11;
    }

    public boolean m() {
        for (Attachment type : a()) {
            if (type.getType() == Attachment.Type.MAIN_SCREENSHOT) {
                return true;
            }
        }
        return false;
    }

    public boolean n() {
        return this.f45666h;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", (Object) getId()).put("temporary_server_token", (Object) h()).put("type", (Object) i().toString()).put("message", (Object) g()).put(InstabugDbContract.BugEntry.COLUMN_BUG_STATE, (Object) b().toString()).put(InstabugDbContract.AttachmentEntry.TABLE_NAME, (Object) Attachment.toJson(a())).put(InstabugDbContract.BugEntry.COLUMN_VIEW_HIERARCHY, (Object) j()).put(InstabugDbContract.BugEntry.COLUMN_CATEGORIES_LIST, (Object) c());
        if (getState() != null) {
            jSONObject.put("state", (Object) getState().toJson());
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public String toString() {
        return "Internal Id: " + this.f45659a + ", TemporaryServerToken:" + this.f45660b + ", Message:" + this.f45662d + ", Type:" + this.f45661c;
    }
}
