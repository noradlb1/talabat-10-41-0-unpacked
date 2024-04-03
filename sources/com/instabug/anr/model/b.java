package com.instabug.anr.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.instabug.commons.models.Incident;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class b implements Incident {

    /* renamed from: a  reason: collision with root package name */
    private String f45067a;

    /* renamed from: b  reason: collision with root package name */
    private String f45068b;

    /* renamed from: c  reason: collision with root package name */
    private String f45069c;

    /* renamed from: d  reason: collision with root package name */
    private List f45070d;

    /* renamed from: e  reason: collision with root package name */
    private int f45071e;

    /* renamed from: f  reason: collision with root package name */
    private String f45072f;

    /* renamed from: g  reason: collision with root package name */
    private State f45073g;

    /* renamed from: h  reason: collision with root package name */
    private String f45074h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private IncidentMetadata f45075i;

    @SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
    public b(@NonNull IncidentMetadata incidentMetadata) {
        this.f45075i = incidentMetadata;
    }

    public void a(String str) {
        this.f45067a = str;
    }

    public List b() {
        return this.f45070d;
    }

    public String c() {
        return this.f45067a;
    }

    public void d(String str) {
        this.f45069c = str;
    }

    public String e() {
        return this.f45068b;
    }

    public String f() {
        return this.f45069c;
    }

    public State g() {
        return this.f45073g;
    }

    @NonNull
    public IncidentMetadata getMetadata() {
        return this.f45075i;
    }

    @NonNull
    public Incident.Type getType() {
        return Incident.Type.ANR;
    }

    public String h() {
        return this.f45072f;
    }

    public b a(Uri uri) {
        return a(uri, Attachment.Type.ATTACHMENT_FILE);
    }

    public void b(String str) {
        this.f45074h = str;
    }

    public void c(String str) {
        this.f45068b = str;
    }

    public String d() {
        return this.f45074h;
    }

    public void e(String str) {
        this.f45072f = str;
    }

    public b(Context context, String str, String str2, String str3, @NonNull IncidentMetadata incidentMetadata) {
        this(String.valueOf(System.currentTimeMillis()), str, str2, State.getState(context), incidentMetadata);
        this.f45070d = new ArrayList();
        this.f45074h = str3;
    }

    public b a(Uri uri, Attachment.Type type) {
        if (uri == null) {
            InstabugSDKLogger.w("IBG-CR", "Adding attachment with a null Uri, ignored.");
            return this;
        }
        Attachment attachment = new Attachment();
        if (uri.getLastPathSegment() != null) {
            attachment.setName(uri.getLastPathSegment());
        }
        if (uri.getPath() != null) {
            attachment.setLocalPath(uri.getPath());
        }
        attachment.setType(type);
        if (type == Attachment.Type.VISUAL_USER_STEPS) {
            attachment.setEncrypted(true);
        }
        this.f45070d.add(attachment);
        return this;
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
    private b(String str, String str2, String str3, State state, @NonNull IncidentMetadata incidentMetadata) {
        this(incidentMetadata);
        this.f45067a = str;
        this.f45073g = state;
        this.f45068b = str2;
        this.f45069c = str3;
        this.f45070d = new ArrayList();
    }

    public b a(@NonNull List list) {
        this.f45070d = new CopyOnWriteArrayList(list);
        return this;
    }

    public void a(State state) {
        this.f45073g = state;
    }

    public int a() {
        return this.f45071e;
    }

    public void a(int i11) {
        this.f45071e = i11;
    }
}
