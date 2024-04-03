package com.instabug.chat.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public class a implements Cacheable, Serializable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f46011a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f46012b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f46013c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f46014d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f46015e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f46016f = false;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private String f46017g;

    public a() {
        e("not_available");
        d("not_available");
    }

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            a aVar = new a();
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            aVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public static JSONArray a(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            jSONArray.put((Object) new JSONObject(((a) arrayList.get(i11)).toJson()));
        }
        return jSONArray;
    }

    public a a(boolean z11) {
        this.f46016f = z11;
        return this;
    }

    @Nullable
    public String a() {
        return this.f46017g;
    }

    public void a(@Nullable String str) {
        this.f46017g = str;
    }

    public a b(@Nullable String str) {
        this.f46012b = str;
        return this;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public String b() {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(d());
        if (fileExtensionFromUrl == null || TextUtils.isEmpty(fileExtensionFromUrl)) {
            return f();
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        return (mimeTypeFromExtension == null || mimeTypeFromExtension.equals("")) ? f() : mimeTypeFromExtension;
    }

    public a c(@Nullable String str) {
        this.f46011a = str;
        return this;
    }

    @Nullable
    public String c() {
        return this.f46012b;
    }

    public a d(String str) {
        this.f46015e = str;
        return this;
    }

    @Nullable
    public String d() {
        return this.f46011a;
    }

    public a e(String str) {
        this.f46014d = str;
        return this;
    }

    @Nullable
    public String e() {
        return this.f46015e;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return String.valueOf(aVar.d()).equals(String.valueOf(d())) && String.valueOf(aVar.c()).equals(String.valueOf(c())) && String.valueOf(aVar.g()).equals(String.valueOf(g())) && aVar.f() != null && f() != null && aVar.f().equals(f()) && aVar.e() != null && e() != null && aVar.e().equals(e()) && aVar.h() == h() && String.valueOf(aVar.a()).equals(String.valueOf(a()));
    }

    public a f(String str) {
        this.f46013c = str;
        return this;
    }

    @Nullable
    public String f() {
        return this.f46014d;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("name")) {
            c(jSONObject.getString("name"));
        }
        if (jSONObject.has(InstabugDbContract.AttachmentEntry.COLUMN_LOCALE_PATH)) {
            b(jSONObject.getString(InstabugDbContract.AttachmentEntry.COLUMN_LOCALE_PATH));
        }
        if (jSONObject.has("url")) {
            f(jSONObject.getString("url"));
        }
        if (jSONObject.has("type")) {
            String string = jSONObject.getString("type");
            string.hashCode();
            char c11 = 65535;
            switch (string.hashCode()) {
                case -831439762:
                    if (string.equals("image_gallery")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 93166550:
                    if (string.equals(MimeTypes.BASE_TYPE_AUDIO)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 100313435:
                    if (string.equals("image")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 112202875:
                    if (string.equals("video")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1698911340:
                    if (string.equals("extra_image")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1710800780:
                    if (string.equals("extra_video")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1830389646:
                    if (string.equals("video_gallery")) {
                        c11 = 6;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    e("image_gallery");
                    break;
                case 1:
                    e(MimeTypes.BASE_TYPE_AUDIO);
                    break;
                case 2:
                    e("image");
                    break;
                case 3:
                    e("video");
                    break;
                case 4:
                    e("extra_image");
                    break;
                case 5:
                    e("extra_video");
                    break;
                case 6:
                    e("video_gallery");
                    break;
                default:
                    e("not_available");
                    break;
            }
        }
        if (jSONObject.has(InstabugDbContract.AttachmentEntry.COLUMN_ATTACHMENT_STATE)) {
            String string2 = jSONObject.getString(InstabugDbContract.AttachmentEntry.COLUMN_ATTACHMENT_STATE);
            string2.hashCode();
            String str2 = "offline";
            if (!string2.equals(str2)) {
                str2 = CalibrationDiagnosticEvent.Action.Synced;
                if (!string2.equals(str2)) {
                    d("not_available");
                }
            }
            d(str2);
        }
        if (jSONObject.has(InstabugDbContract.AttachmentEntry.COLUMN_VIDEO_ENCODED)) {
            a(jSONObject.getBoolean(InstabugDbContract.AttachmentEntry.COLUMN_VIDEO_ENCODED));
        }
        if (jSONObject.has("duration")) {
            a(jSONObject.getString("duration"));
        }
    }

    @Nullable
    public String g() {
        return this.f46013c;
    }

    public boolean h() {
        return this.f46016f;
    }

    public int hashCode() {
        if (d() != null) {
            return d().hashCode();
        }
        return -1;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", (Object) d()).put(InstabugDbContract.AttachmentEntry.COLUMN_LOCALE_PATH, (Object) c()).put("url", (Object) g()).put("type", (Object) f()).put(InstabugDbContract.AttachmentEntry.COLUMN_VIDEO_ENCODED, h()).put("duration", (Object) a());
        if (e() != null) {
            jSONObject.put(InstabugDbContract.AttachmentEntry.COLUMN_ATTACHMENT_STATE, (Object) e().toString());
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @NonNull
    public String toString() {
        return "Name: " + d() + ", Local Path: " + c() + ", Type: " + f() + ", Url: " + g() + ", Attachment State: " + e();
    }
}
