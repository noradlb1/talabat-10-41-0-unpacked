package com.instabug.fatalhangs.model;

import android.net.Uri;
import com.instabug.commons.models.Incident;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c implements Incident {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final IncidentMetadata f46481a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f46482b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f46483c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f46484d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private List f46485e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private int f46486f = 1;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private String f46487g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private State f46488h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Uri f46489i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private String f46490j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private String f46491k = "NA";
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final Incident.Type f46492l = Incident.Type.FatalHang;

    static {
        new a((DefaultConstructorMarker) null);
    }

    public c(@NotNull IncidentMetadata incidentMetadata) {
        Intrinsics.checkNotNullParameter(incidentMetadata, TtmlNode.TAG_METADATA);
        this.f46481a = incidentMetadata;
    }

    public final int b() {
        return this.f46486f;
    }

    @Nullable
    public final String c() {
        return this.f46482b;
    }

    public final void d(@Nullable String str) {
        this.f46490j = str;
    }

    @Nullable
    public final String e() {
        return this.f46483c;
    }

    public final void f(@Nullable String str) {
        this.f46487g = str;
    }

    @Nullable
    public final String g() {
        return this.f46484d;
    }

    @NotNull
    public IncidentMetadata getMetadata() {
        return this.f46481a;
    }

    @NotNull
    public Incident.Type getType() {
        return this.f46492l;
    }

    @Nullable
    public final State h() {
        return this.f46488h;
    }

    @Nullable
    public final Uri i() {
        return this.f46489i;
    }

    @Nullable
    public final String j() {
        return this.f46487g;
    }

    public final void a(@Nullable String str) {
        this.f46482b = str;
    }

    public final void b(@Nullable Uri uri) {
        this.f46489i = uri;
    }

    public final void c(@Nullable String str) {
        this.f46483c = str;
    }

    @NotNull
    public final String d() {
        return this.f46491k;
    }

    public final void e(@Nullable String str) {
        this.f46484d = str;
    }

    @Nullable
    public final String f() {
        return this.f46490j;
    }

    @NotNull
    public final List a() {
        return this.f46485e;
    }

    public final void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f46491k = str;
    }

    public final void a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f46485e = list;
    }

    public final void a(int i11) {
        this.f46486f = i11;
    }

    public final void a(@Nullable State state) {
        this.f46488h = state;
    }

    /* access modifiers changed from: private */
    public final void a(Uri uri) {
        if (uri == null) {
            InstabugSDKLogger.w("IBG-CR", "Adding attachment with a null Uri, ignored.");
            return;
        }
        Attachment attachment = new Attachment();
        if (uri.getLastPathSegment() != null) {
            attachment.setName(uri.getLastPathSegment());
        }
        if (uri.getPath() != null) {
            attachment.setLocalPath(uri.getPath());
        }
        attachment.setType(Attachment.Type.ATTACHMENT_FILE);
        this.f46485e.add(attachment);
    }
}
