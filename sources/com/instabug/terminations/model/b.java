package com.instabug.terminations.model;

import android.content.Context;
import android.net.Uri;
import com.instabug.commons.models.Incident;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.library.model.State;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b implements Incident {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final IncidentMetadata f52633a;

    /* renamed from: b  reason: collision with root package name */
    private final long f52634b;

    /* renamed from: c  reason: collision with root package name */
    private int f52635c = 1;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f52636d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private State f52637e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Uri f52638f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private String f52639g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final Incident.Type f52640h = Incident.Type.Termination;

    public b(@NotNull IncidentMetadata incidentMetadata, long j11) {
        Intrinsics.checkNotNullParameter(incidentMetadata, TtmlNode.TAG_METADATA);
        this.f52633a = incidentMetadata;
        this.f52634b = j11;
    }

    public final void a(int i11) {
        this.f52635c = i11;
    }

    public final long b() {
        return this.f52634b;
    }

    public final int c() {
        return this.f52635c;
    }

    @Nullable
    public final String d() {
        return this.f52639g;
    }

    @Nullable
    public final State e() {
        return this.f52637e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual((Object) getMetadata(), (Object) bVar.getMetadata()) && this.f52634b == bVar.f52634b;
    }

    @Nullable
    public final Uri f() {
        return this.f52638f;
    }

    @Nullable
    public final String g() {
        return this.f52636d;
    }

    @NotNull
    public IncidentMetadata getMetadata() {
        return this.f52633a;
    }

    @NotNull
    public Incident.Type getType() {
        return this.f52640h;
    }

    public final int h() {
        int i11 = this.f52635c + 1;
        this.f52635c = i11;
        return i11;
    }

    public int hashCode() {
        return (getMetadata().hashCode() * 31) + a.a(this.f52634b);
    }

    @NotNull
    public String toString() {
        return "Termination(metadata=" + getMetadata() + ", id=" + this.f52634b + ')';
    }

    public final void a(@Nullable Uri uri) {
        this.f52638f = uri;
    }

    public final void b(@Nullable String str) {
        this.f52636d = str;
    }

    public final void a(@Nullable String str) {
        this.f52639g = str;
    }

    public final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f52637e = State.getState(context, this.f52638f);
    }

    public final void a() {
        this.f52637e = null;
    }
}
