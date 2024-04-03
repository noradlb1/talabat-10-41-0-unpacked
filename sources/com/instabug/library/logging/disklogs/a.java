package com.instabug.library.logging.disklogs;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.ExoPlayer;
import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library.internal.resolver.c;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.model.d;
import com.instabug.library.model.g;
import com.instabug.library.model.h;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class a extends Thread {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f51451a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f51452b = "IBGDiskLoggingThread";
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f51453c = "End-session";

    /* renamed from: d  reason: collision with root package name */
    private long f51454d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final WeakReference f51455e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final h f51456f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private volatile StringBuilder f51457g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f51458h;

    /* renamed from: i  reason: collision with root package name */
    private final Executor f51459i;

    public a(@NotNull Context context) {
        long j11;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f51451a = context;
        h b11 = c.a().b();
        if (b11 == null) {
            j11 = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        } else {
            j11 = b11.c();
        }
        this.f51454d = j11;
        this.f51455e = new WeakReference(context);
        this.f51456f = new h(context);
        this.f51457g = new StringBuilder();
        this.f51459i = PoolProvider.getSingleThreadExecutor("LoggingExecutor");
        start();
    }

    /* access modifiers changed from: private */
    public static final void a(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        aVar.c();
    }

    @VisibleForTesting
    public final boolean b() {
        long length = (long) this.f51457g.length();
        h b11 = c.a().b();
        return length >= (b11 == null ? 10000 : b11.b());
    }

    @VisibleForTesting
    @WorkerThread
    public final void c() {
        if (InstabugStateProvider.getInstance().getState() != InstabugState.DISABLED) {
            File b11 = this.f51456f.b();
            Context context = (Context) this.f51455e.get();
            if (b11 != null && context != null) {
                DiskUtils.with(context).writeOperation(new k(b11, this.f51457g.toString())).execute();
                this.f51457g.setLength(0);
                this.f51456f.d();
                return;
            }
            return;
        }
        this.f51457g.setLength(0);
    }

    public void interrupt() {
        this.f51458h = true;
        super.interrupt();
    }

    public void run() {
        boolean z11;
        setName("IBGLoggingThread");
        while (true) {
            h b11 = c.a().b();
            boolean z12 = true;
            if (b11 != null && b11.d() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && !this.f51458h) {
                try {
                    Thread.sleep(this.f51454d);
                } catch (InterruptedException unused) {
                    InstabugSDKLogger.v(this.f51452b, "IBGDiskLoggingThread was interrupted");
                }
                if (this.f51457g.length() <= 0) {
                    z12 = false;
                }
                if (z12) {
                    this.f51459i.execute(new fd.a(this));
                }
            } else {
                return;
            }
        }
    }

    public final void a(@NotNull String str, @NotNull String str2, @NotNull String str3, long j11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        Intrinsics.checkNotNullParameter(str3, "currentThread");
        this.f51457g.append(new d().c(str).b(a(str2)).a(str3).a(j11).a().toString());
        a();
    }

    @VisibleForTesting
    public final void a() {
        if (b()) {
            c();
        }
    }

    @NotNull
    @VisibleForTesting
    public final String a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        h b11 = c.a().b();
        long g11 = b11 == null ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : b11.g();
        if (((long) str.length()) <= g11) {
            return str;
        }
        long length = ((long) str.length()) - g11;
        StringBuilder sb2 = new StringBuilder(str);
        sb2.delete((int) g11, str.length());
        sb2.append(Intrinsics.stringPlus("...", Long.valueOf(length)));
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "msgBuilder.toString()");
        return sb3;
    }

    public final void a(@NotNull g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "sessionDescriptor");
        this.f51457g.append(gVar);
    }

    public final void a(long j11) {
        a("", this.f51453c, "", j11);
    }
}
