package com.instabug.library.util.threading;

import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.settings.f;
import com.instabug.library.util.TimeUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final long f52103a;

    /* renamed from: b  reason: collision with root package name */
    private final long f52104b;

    /* renamed from: c  reason: collision with root package name */
    private final long f52105c = 86400000;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private Map f52106d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    private int f52107e;

    public e(long j11, long j12) {
        this.f52103a = j11;
        this.f52104b = j12;
    }

    @NotNull
    public final Map a() {
        return this.f52106d;
    }

    public final int b() {
        return this.f52107e;
    }

    public final void c(@Nullable String str) {
        if (str != null) {
            a().put(str, Long.valueOf(System.currentTimeMillis()));
            a(b() + 1);
        }
    }

    public final void a(int i11) {
        this.f52107e = i11;
    }

    public final void b(@Nullable String str) {
        if (str != null) {
            a(str, System.currentTimeMillis(), b.DEQUEUED);
        }
    }

    public final void a(@Nullable String str) {
        if (str != null) {
            a(str, System.currentTimeMillis(), b.COMPLETED);
            a(b() - 1);
            Long l11 = (Long) a().remove(str);
        }
    }

    private final void a(String str, long j11, b bVar) {
        Long l11;
        f s11 = f.s();
        if (TimeUtils.hasXHoursPassed(s11 == null ? 0 : s11.y(), this.f52105c) && (l11 = (Long) this.f52106d.get(str)) != null) {
            long longValue = j11 - l11.longValue();
            Feature.State featureState = InstabugCore.getFeatureState(Feature.DB_ENCRYPTION);
            int i11 = d.f52102a[bVar.ordinal()];
            if (i11 == 1) {
                long j12 = this.f52103a;
                if (j12 != 0 && longValue > j12) {
                    c cVar = new c();
                    IBGDiagnostics.reportNonFatal(cVar, "Job exceeded took " + longValue + " milliseconds. in queue before being " + bVar.name() + "  Queue length: " + b() + ", DB Encryption state: " + featureState);
                    f s12 = f.s();
                    if (s12 != null) {
                        s12.c(System.currentTimeMillis());
                    }
                }
            } else if (i11 == 2) {
                long j13 = this.f52104b;
                if (j13 != 0 && longValue > j13) {
                    c cVar2 = new c();
                    IBGDiagnostics.reportNonFatal(cVar2, "Job exceeded took " + longValue + " milliseconds. in queue before being " + bVar.name() + "  Queue length: " + b() + ", DB Encryption state: " + featureState);
                    f s13 = f.s();
                    if (s13 != null) {
                        s13.c(System.currentTimeMillis());
                    }
                }
            }
        }
    }
}
