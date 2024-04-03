package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.internal.ads.zztz;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@SuppressLint({"HandlerLeak"})
final class zzty<T extends zztz> extends Handler implements Runnable {
    final /* synthetic */ zzud zza;
    private final T zzb;
    private final long zzc;
    @Nullable
    private zztv<T> zzd;
    @Nullable
    private IOException zze;
    private int zzf;
    @Nullable
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzty(zzud zzud, Looper looper, T t11, zztv<T> zztv, int i11, long j11) {
        super(looper);
        this.zza = zzud;
        this.zzb = t11;
        this.zzd = zztv;
        this.zzc = j11;
    }

    private final void zzd() {
        this.zze = null;
        ExecutorService zzd2 = this.zza.zze;
        zzty zzc2 = this.zza.zzf;
        zzc2.getClass();
        zzd2.execute(zzc2);
    }

    public final void handleMessage(Message message) {
        long j11;
        if (!this.zzi) {
            int i11 = message.what;
            if (i11 == 0) {
                zzd();
            } else if (i11 != 3) {
                this.zza.zzf = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j12 = elapsedRealtime - this.zzc;
                zztv<T> zztv = this.zzd;
                zztv.getClass();
                if (this.zzh) {
                    zztv.zzG(this.zzb, elapsedRealtime, j12, false);
                    return;
                }
                int i12 = message.what;
                if (i12 == 1) {
                    try {
                        zztv.zzH(this.zzb, elapsedRealtime, j12);
                    } catch (RuntimeException e11) {
                        zzep.zza("LoadTask", "Unexpected exception handling load completed", e11);
                        this.zza.zzg = new zzuc(e11);
                    }
                } else if (i12 == 2) {
                    IOException iOException = (IOException) message.obj;
                    this.zze = iOException;
                    int i13 = this.zzf + 1;
                    this.zzf = i13;
                    zztx zzt = zztv.zzt(this.zzb, elapsedRealtime, j12, iOException, i13);
                    if (zzt.zza == 3) {
                        this.zza.zzg = this.zze;
                    } else if (zzt.zza != 2) {
                        if (zzt.zza == 1) {
                            this.zzf = 1;
                        }
                        if (zzt.zzb != C.TIME_UNSET) {
                            j11 = zzt.zzb;
                        } else {
                            j11 = (long) Math.min((this.zzf - 1) * 1000, 5000);
                        }
                        zzc(j11);
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        boolean z11;
        String str;
        try {
            synchronized (this) {
                z11 = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z11) {
                String simpleName = this.zzb.getClass().getSimpleName();
                if (simpleName.length() != 0) {
                    str = "load:".concat(simpleName);
                } else {
                    str = new String("load:");
                }
                zzfl.zza(str);
                this.zzb.zzi();
                zzfl.zzb();
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (!this.zzi) {
                sendEmptyMessage(1);
            }
        } catch (IOException e11) {
            if (!this.zzi) {
                obtainMessage(2, e11).sendToTarget();
            }
        } catch (Exception e12) {
            if (!this.zzi) {
                zzep.zza("LoadTask", "Unexpected exception loading stream", e12);
                obtainMessage(2, new zzuc(e12)).sendToTarget();
            }
        } catch (OutOfMemoryError e13) {
            if (!this.zzi) {
                zzep.zza("LoadTask", "OutOfMemory error loading stream", e13);
                obtainMessage(2, new zzuc(e13)).sendToTarget();
            }
        } catch (Error e14) {
            if (!this.zzi) {
                zzep.zza("LoadTask", "Unexpected error loading stream", e14);
                obtainMessage(3, e14).sendToTarget();
            }
            throw e14;
        } catch (Throwable th2) {
            zzfl.zzb();
            throw th2;
        }
    }

    public final void zza(boolean z11) {
        this.zzi = z11;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z11) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzh();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z11) {
            this.zza.zzf = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zztv<T> zztv = this.zzd;
            zztv.getClass();
            zztv.zzG(this.zzb, elapsedRealtime, elapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i11) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i11) {
            throw iOException;
        }
    }

    public final void zzc(long j11) {
        boolean z11;
        if (this.zza.zzf == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        this.zza.zzf = this;
        if (j11 > 0) {
            sendEmptyMessageDelayed(0, j11);
        } else {
            zzd();
        }
    }
}
