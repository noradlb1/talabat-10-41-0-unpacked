package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzawi;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class zzawh<T extends zzawi> extends Handler implements Runnable {
    public final int zza;
    final /* synthetic */ zzawk zzb;
    private final T zzc;
    private final zzawg<T> zzd;
    private final long zze;
    private IOException zzf;
    private int zzg;
    private volatile Thread zzh;
    private volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzawh(zzawk zzawk, Looper looper, T t11, zzawg<T> zzawg, int i11, long j11) {
        super(looper);
        this.zzb = zzawk;
        this.zzc = t11;
        this.zzd = zzawg;
        this.zza = i11;
        this.zze = j11;
    }

    private final void zzd() {
        this.zzf = null;
        this.zzb.zza.execute(this.zzb.zzb);
    }

    public final void handleMessage(Message message) {
        if (!this.zzi) {
            int i11 = message.what;
            if (i11 == 0) {
                zzd();
            } else if (i11 != 4) {
                this.zzb.zzb = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j11 = elapsedRealtime - this.zze;
                if (this.zzc.zze()) {
                    this.zzd.zzt(this.zzc, elapsedRealtime, j11, false);
                    return;
                }
                int i12 = message.what;
                int i13 = 1;
                if (i12 == 1) {
                    this.zzd.zzt(this.zzc, elapsedRealtime, j11, false);
                } else if (i12 == 2) {
                    this.zzd.zzu(this.zzc, elapsedRealtime, j11);
                } else if (i12 == 3) {
                    IOException iOException = (IOException) message.obj;
                    this.zzf = iOException;
                    int zzd2 = this.zzd.zzd(this.zzc, elapsedRealtime, j11, iOException);
                    if (zzd2 == 3) {
                        this.zzb.zzc = this.zzf;
                    } else if (zzd2 != 2) {
                        if (zzd2 != 1) {
                            i13 = 1 + this.zzg;
                        }
                        this.zzg = i13;
                        zzc((long) Math.min((i13 - 1) * 1000, 5000));
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        String str;
        try {
            this.zzh = Thread.currentThread();
            if (!this.zzc.zze()) {
                String simpleName = this.zzc.getClass().getSimpleName();
                if (simpleName.length() != 0) {
                    str = "load:".concat(simpleName);
                } else {
                    str = new String("load:");
                }
                zzawz.zza(str);
                this.zzc.zzc();
                zzawz.zzb();
            }
            if (!this.zzi) {
                sendEmptyMessage(2);
            }
        } catch (IOException e11) {
            if (!this.zzi) {
                obtainMessage(3, e11).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzawm.zze(this.zzc.zze());
            if (!this.zzi) {
                sendEmptyMessage(2);
            }
        } catch (Exception e12) {
            Log.e("LoadTask", "Unexpected exception loading stream", e12);
            if (!this.zzi) {
                obtainMessage(3, new zzawj(e12)).sendToTarget();
            }
        } catch (OutOfMemoryError e13) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e13);
            if (!this.zzi) {
                obtainMessage(3, new zzawj(e13)).sendToTarget();
            }
        } catch (Error e14) {
            Log.e("LoadTask", "Unexpected error loading stream", e14);
            if (!this.zzi) {
                obtainMessage(4, e14).sendToTarget();
            }
            throw e14;
        } catch (Throwable th2) {
            zzawz.zzb();
            throw th2;
        }
    }

    public final void zza(boolean z11) {
        this.zzi = z11;
        this.zzf = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z11) {
                sendEmptyMessage(1);
                return;
            }
        } else {
            this.zzc.zzb();
            if (this.zzh != null) {
                this.zzh.interrupt();
            }
            if (!z11) {
                return;
            }
        }
        this.zzb.zzb = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.zzd.zzt(this.zzc, elapsedRealtime, elapsedRealtime - this.zze, true);
    }

    public final void zzb(int i11) throws IOException {
        IOException iOException = this.zzf;
        if (iOException != null && this.zzg > i11) {
            throw iOException;
        }
    }

    public final void zzc(long j11) {
        boolean z11;
        if (this.zzb.zzb == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zze(z11);
        this.zzb.zzb = this;
        if (j11 > 0) {
            sendEmptyMessageDelayed(0, j11);
        } else {
            zzd();
        }
    }
}
