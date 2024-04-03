package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

final class zzek extends Thread implements zzej {
    private static zzek zzanw;
    private volatile boolean closed = false;
    private final LinkedBlockingQueue<Runnable> zzahb = new LinkedBlockingQueue<>();
    private volatile boolean zzahc = false;
    /* access modifiers changed from: private */
    public volatile zzem zzanx;
    /* access modifiers changed from: private */
    public final Context zzrm;
    private final Clock zzsd = DefaultClock.getInstance();

    private zzek(Context context) {
        super("GAThread");
        if (context != null) {
            this.zzrm = context.getApplicationContext();
        } else {
            this.zzrm = context;
        }
        start();
    }

    public static zzek zzq(Context context) {
        if (zzanw == null) {
            zzanw = new zzek(context);
        }
        return zzanw;
    }

    public final void run() {
        String str;
        while (true) {
            try {
                Runnable take = this.zzahb.take();
                if (!this.zzahc) {
                    take.run();
                }
            } catch (InterruptedException e11) {
                try {
                    zzev.zzaw(e11.toString());
                } catch (Exception e12) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    PrintStream printStream = new PrintStream(byteArrayOutputStream);
                    zzpf.zza(e12, printStream);
                    printStream.flush();
                    String str2 = new String(byteArrayOutputStream.toByteArray());
                    if (str2.length() != 0) {
                        str = "Error on Google TagManager Thread: ".concat(str2);
                    } else {
                        str = new String("Error on Google TagManager Thread: ");
                    }
                    zzev.zzav(str);
                    zzev.zzav("Google TagManager is shutting down.");
                    this.zzahc = true;
                }
            }
        }
    }

    public final void zzb(String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4) {
        zzc(new zzel(this, this, this.zzsd.currentTimeMillis(), str, str2, str3, map, str4));
    }

    public final void zzc(Runnable runnable) {
        this.zzahb.add(runnable);
    }
}
