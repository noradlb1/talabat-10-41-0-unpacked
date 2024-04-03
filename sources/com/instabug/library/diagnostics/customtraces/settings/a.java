package com.instabug.library.diagnostics.customtraces.settings;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f34233a;

    /* renamed from: b  reason: collision with root package name */
    private int f34234b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34235c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f34236d;

    public a(boolean z11, int i11, boolean z12, boolean z13) {
        this.f34233a = z11;
        this.f34234b = i11;
        this.f34235c = z12;
        this.f34236d = z13;
    }

    public final boolean a() {
        return this.f34233a;
    }

    public final int b() {
        return this.f34234b;
    }

    public final boolean c() {
        return this.f34236d;
    }

    public final boolean d() {
        return this.f34235c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f34233a == aVar.f34233a && this.f34234b == aVar.f34234b && this.f34235c == aVar.f34235c && this.f34236d == aVar.f34236d;
    }

    public int hashCode() {
        boolean z11 = this.f34233a;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (((z11 ? 1 : 0) * true) + this.f34234b) * 31;
        boolean z13 = this.f34235c;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.f34236d;
        if (!z14) {
            z12 = z14;
        }
        return i12 + (z12 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "CustomTracesSettings(enabled=" + this.f34233a + ", maxCount=" + this.f34234b + ", recordLaunchTrace=" + this.f34235c + ", recordFeatureTrace=" + this.f34236d + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(boolean z11, int i11, boolean z12, boolean z13, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? false : z11, (i12 & 2) != 0 ? 15 : i11, (i12 & 4) != 0 ? false : z12, (i12 & 8) != 0 ? false : z13);
    }
}
