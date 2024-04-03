package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzpf;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

final class zzbz extends Thread implements zzby {
    private static zzbz zzahd;
    private volatile boolean closed = false;
    private final LinkedBlockingQueue<Runnable> zzahb = new LinkedBlockingQueue<>();
    private volatile boolean zzahc = false;
    /* access modifiers changed from: private */
    public volatile zzcb zzahe;
    /* access modifiers changed from: private */
    public final Context zzrm;

    private zzbz(Context context) {
        super("GAThread");
        if (context != null) {
            this.zzrm = context.getApplicationContext();
        } else {
            this.zzrm = context;
        }
        start();
    }

    public static zzbz zzm(Context context) {
        if (zzahd == null) {
            zzahd = new zzbz(context);
        }
        return zzahd;
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
                    zzdi.zzaw(e11.toString());
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
                    zzdi.zzav(str);
                    zzdi.zzav("Google TagManager is shutting down.");
                    this.zzahc = true;
                }
            }
        }
    }

    public final void zzbd(String str) {
        zzc(new zzca(this, this, System.currentTimeMillis(), str));
    }

    public final void zzc(Runnable runnable) {
        this.zzahb.add(runnable);
    }
}
