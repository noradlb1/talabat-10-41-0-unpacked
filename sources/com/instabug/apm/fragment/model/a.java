package com.instabug.apm.fragment.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f45334a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private String f45335b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final List f45336c;

    public a(@NotNull String str, @NotNull String str2, @NotNull List list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        Intrinsics.checkNotNullParameter(list, "events");
        this.f45334a = str;
        this.f45335b = str2;
        this.f45336c = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(String str, String str2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? new ArrayList() : list);
    }

    @NotNull
    public final List a() {
        return this.f45336c;
    }

    @NotNull
    public final String b() {
        return this.f45334a;
    }

    @NotNull
    public final String c() {
        return this.f45335b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual((Object) this.f45334a, (Object) aVar.f45334a) && Intrinsics.areEqual((Object) this.f45335b, (Object) aVar.f45335b) && Intrinsics.areEqual((Object) this.f45336c, (Object) aVar.f45336c);
    }

    public int hashCode() {
        return (((this.f45334a.hashCode() * 31) + this.f45335b.hashCode()) * 31) + this.f45336c.hashCode();
    }

    @NotNull
    public String toString() {
        return "FragmentSpans(name=" + this.f45334a + ", sessionId=" + this.f45335b + ", events=" + this.f45336c + ')';
    }
}
