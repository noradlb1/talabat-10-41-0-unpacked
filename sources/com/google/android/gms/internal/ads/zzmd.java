package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.lang.reflect.Method;
import net.bytebuddy.jar.asm.Opcodes;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class zzmd {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private final zzmc zza;
    private final long[] zzb;
    @Nullable
    private AudioTrack zzc;
    private int zzd;
    private int zze;
    @Nullable
    private zzmb zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private float zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    @Nullable
    private Method zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzmd(zzmc zzmc) {
        this.zza = zzmc;
        if (zzfn.zza >= 18) {
            try {
                this.zzn = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.zzb = new long[10];
    }

    private final long zzm(long j11) {
        return (j11 * 1000000) / ((long) this.zzg);
    }

    private final long zzn() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        if (this.zzx != C.TIME_UNSET) {
            return Math.min(this.zzA, this.zzz + ((((SystemClock.elapsedRealtime() * 1000) - this.zzx) * ((long) this.zzg)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.zzh) {
            if (playState == 2) {
                if (playbackHeadPosition == 0) {
                    this.zzu = this.zzs;
                }
                playState = 2;
            }
            playbackHeadPosition += this.zzu;
        }
        if (zzfn.zza <= 29) {
            if (playbackHeadPosition == 0 && this.zzs > 0 && playState == 3) {
                if (this.zzy == C.TIME_UNSET) {
                    this.zzy = SystemClock.elapsedRealtime();
                }
                return this.zzs;
            }
            this.zzy = C.TIME_UNSET;
        }
        if (this.zzs > playbackHeadPosition) {
            this.zzt++;
        }
        this.zzs = playbackHeadPosition;
        return playbackHeadPosition + (this.zzt << 32);
    }

    private final void zzo() {
        this.zzl = 0;
        this.zzw = 0;
        this.zzv = 0;
        this.zzm = 0;
        this.zzC = 0;
        this.zzF = 0;
        this.zzk = false;
    }

    public final int zza(long j11) {
        return this.zze - ((int) (j11 - (zzn() * ((long) this.zzd))));
    }

    public final long zzb(boolean z11) {
        long j11;
        String str;
        Method method;
        zzmd zzmd = this;
        AudioTrack audioTrack = zzmd.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            long zzm2 = zzmd.zzm(zzn());
            if (zzm2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - zzmd.zzm >= 30000) {
                    long[] jArr = zzmd.zzb;
                    int i11 = zzmd.zzv;
                    jArr[i11] = zzm2 - nanoTime;
                    zzmd.zzv = (i11 + 1) % 10;
                    int i12 = zzmd.zzw;
                    if (i12 < 10) {
                        zzmd.zzw = i12 + 1;
                    }
                    zzmd.zzm = nanoTime;
                    zzmd.zzl = 0;
                    int i13 = 0;
                    while (true) {
                        int i14 = zzmd.zzw;
                        if (i13 >= i14) {
                            break;
                        }
                        zzmd.zzl += zzmd.zzb[i13] / ((long) i14);
                        i13++;
                    }
                }
                if (!zzmd.zzh) {
                    zzmb zzmb = zzmd.zzf;
                    zzmb.getClass();
                    if (!zzmb.zzg(nanoTime)) {
                        str = "DefaultAudioSink";
                    } else {
                        long zzb2 = zzmb.zzb();
                        long zza2 = zzmb.zza();
                        if (Math.abs(zzb2 - nanoTime) > 5000000) {
                            zzmn zzmn = (zzmn) zzmd.zza;
                            long zzw2 = zzmn.zza.zzD();
                            long zzx2 = zzmn.zza.zzE();
                            StringBuilder sb2 = new StringBuilder(180);
                            sb2.append("Spurious audio timestamp (system clock mismatch): ");
                            sb2.append(zza2);
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb2.append(zzb2);
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb2.append(nanoTime);
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb2.append(zzm2);
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb2.append(zzw2);
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb2.append(zzx2);
                            String str2 = "DefaultAudioSink";
                            Log.w(str2, sb2.toString());
                            zzmb.zzd();
                            zzmd = this;
                            str = str2;
                        } else {
                            String str3 = "DefaultAudioSink";
                            if (Math.abs(zzmd.zzm(zza2) - zzm2) > 5000000) {
                                zzmn zzmn2 = (zzmn) zzmd.zza;
                                long zzw3 = zzmn2.zza.zzD();
                                zzmb zzmb2 = zzmb;
                                long zzx3 = zzmn2.zza.zzE();
                                StringBuilder sb3 = new StringBuilder(Opcodes.INVOKEVIRTUAL);
                                sb3.append("Spurious audio timestamp (frame position mismatch): ");
                                sb3.append(zza2);
                                sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                                sb3.append(zzb2);
                                sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                                sb3.append(nanoTime);
                                sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                                sb3.append(zzm2);
                                sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                                sb3.append(zzw3);
                                sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                                sb3.append(zzx3);
                                str = str3;
                                Log.w(str, sb3.toString());
                                zzmb2.zzd();
                            } else {
                                str = str3;
                                zzmb.zzc();
                            }
                            zzmd = this;
                        }
                    }
                    if (zzmd.zzq && (method = zzmd.zzn) != null && nanoTime - zzmd.zzr >= 500000) {
                        try {
                            AudioTrack audioTrack2 = zzmd.zzc;
                            audioTrack2.getClass();
                            int i15 = zzfn.zza;
                            long intValue = (((long) ((Integer) method.invoke(audioTrack2, new Object[0])).intValue()) * 1000) - zzmd.zzi;
                            zzmd.zzo = intValue;
                            long max = Math.max(intValue, 0);
                            zzmd.zzo = max;
                            if (max > 5000000) {
                                StringBuilder sb4 = new StringBuilder(61);
                                sb4.append("Ignoring impossibly large audio latency: ");
                                sb4.append(max);
                                Log.w(str, sb4.toString());
                                zzmd.zzo = 0;
                            }
                        } catch (Exception unused) {
                            zzmd.zzn = null;
                        }
                        zzmd.zzr = nanoTime;
                    }
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        zzmb zzmb3 = zzmd.zzf;
        zzmb3.getClass();
        boolean zzf2 = zzmb3.zzf();
        if (zzf2) {
            j11 = zzmd.zzm(zzmb3.zza()) + zzfn.zzp(nanoTime2 - zzmb3.zzb(), zzmd.zzj);
        } else {
            if (zzmd.zzw == 0) {
                j11 = zzmd.zzm(zzn());
            } else {
                j11 = zzmd.zzl + nanoTime2;
            }
            if (!z11) {
                j11 = Math.max(0, j11 - zzmd.zzo);
            }
        }
        if (zzmd.zzD != zzf2) {
            zzmd.zzF = zzmd.zzC;
            zzmd.zzE = zzmd.zzB;
        }
        long j12 = nanoTime2 - zzmd.zzF;
        if (j12 < 1000000) {
            long j13 = (j12 * 1000) / 1000000;
            j11 = ((j11 * j13) + ((1000 - j13) * (zzmd.zzE + zzfn.zzp(j12, zzmd.zzj)))) / 1000;
        }
        if (!zzmd.zzk) {
            long j14 = zzmd.zzB;
            if (j11 > j14) {
                zzmd.zzk = true;
                long currentTimeMillis = System.currentTimeMillis() - zzk.zzd(zzfn.zzr(zzk.zzd(j11 - j14), zzmd.zzj));
                zzmn zzmn3 = (zzmn) zzmd.zza;
                if (zzmn3.zza.zzk != null) {
                    ((zzmu) zzmn3.zza.zzk).zza.zzc.zzr(currentTimeMillis);
                }
            }
        }
        zzmd.zzC = nanoTime2;
        zzmd.zzB = j11;
        zzmd.zzD = zzf2;
        return j11;
    }

    public final long zzc(long j11) {
        return zzk.zzd(zzm(-zzn()));
    }

    public final void zzd(long j11) {
        this.zzz = zzn();
        this.zzx = SystemClock.elapsedRealtime() * 1000;
        this.zzA = j11;
    }

    public final void zze() {
        zzo();
        this.zzc = null;
        this.zzf = null;
    }

    public final void zzf(AudioTrack audioTrack, boolean z11, int i11, int i12, int i13) {
        long j11;
        this.zzc = audioTrack;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = new zzmb(audioTrack);
        this.zzg = audioTrack.getSampleRate();
        this.zzh = false;
        boolean zzR = zzfn.zzR(i11);
        this.zzq = zzR;
        if (zzR) {
            j11 = zzm((long) (i13 / i12));
        } else {
            j11 = -9223372036854775807L;
        }
        this.zzi = j11;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzp = false;
        this.zzx = C.TIME_UNSET;
        this.zzy = C.TIME_UNSET;
        this.zzr = 0;
        this.zzo = 0;
        this.zzj = 1.0f;
    }

    public final void zzg() {
        zzmb zzmb = this.zzf;
        zzmb.getClass();
        zzmb.zze();
    }

    public final boolean zzh(long j11) {
        if (j11 > zzn()) {
            return true;
        }
        if (!this.zzh) {
            return false;
        }
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 2 && zzn() == 0) {
            return true;
        }
        return false;
    }

    public final boolean zzi() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            return true;
        }
        return false;
    }

    public final boolean zzj(long j11) {
        return this.zzy != C.TIME_UNSET && j11 > 0 && SystemClock.elapsedRealtime() - this.zzy >= 200;
    }

    public final boolean zzk(long j11) {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.zzh) {
            if (playState == 2) {
                this.zzp = false;
                return false;
            } else if (playState == 1) {
                if (zzn() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z11 = this.zzp;
        boolean zzh2 = zzh(j11);
        this.zzp = zzh2;
        if (z11 && !zzh2 && playState != 1) {
            zzmc zzmc = this.zza;
            int i11 = this.zze;
            long zzd2 = zzk.zzd(this.zzi);
            zzmn zzmn = (zzmn) zzmc;
            if (zzmn.zza.zzk != null) {
                ((zzmu) zzmn.zza.zzk).zza.zzc.zzt(i11, zzd2, SystemClock.elapsedRealtime() - zzmn.zza.zzM);
            }
        }
        return true;
    }

    public final boolean zzl() {
        zzo();
        if (this.zzx != C.TIME_UNSET) {
            return false;
        }
        zzmb zzmb = this.zzf;
        zzmb.getClass();
        zzmb.zze();
        return true;
    }
}
