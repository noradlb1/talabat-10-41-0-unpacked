package com.instabug.library.model.v3Session;

import com.instabug.library.util.TimeUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public abstract class u {

    /* renamed from: a  reason: collision with root package name */
    private final long f51625a;

    /* renamed from: b  reason: collision with root package name */
    private final long f51626b;

    private u(long j11, long j12) {
        this.f51625a = j11;
        this.f51626b = j12;
    }

    public /* synthetic */ u(long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12);
    }

    public final long a() {
        return this.f51626b;
    }

    public final long b() {
        return this.f51625a;
    }

    @NotNull
    public String toString() {
        if (this instanceof r) {
            return "End";
        }
        if (this instanceof s) {
            return "Start";
        }
        if (this instanceof t) {
            return "Stop";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? TimeUtils.currentTimeStampMicroSeconds() : j11, (i11 & 2) != 0 ? TimeUtils.nanoTime() : j12, (DefaultConstructorMarker) null);
    }
}
