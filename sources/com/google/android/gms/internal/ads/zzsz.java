package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class zzsz extends zzdf {
    private final AssetManager zza;
    @Nullable
    private Uri zzb;
    @Nullable
    private InputStream zzc;
    private long zzd;
    private boolean zze;

    public zzsz(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws zzsy {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.zzd;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, (long) i12);
            } catch (IOException e11) {
                throw new zzsy(e11, 2000);
            }
        }
        InputStream inputStream = this.zzc;
        int i13 = zzfn.zza;
        int read = inputStream.read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        long j12 = this.zzd;
        if (j12 != -1) {
            this.zzd = j12 - ((long) read);
        }
        zzc(read);
        return read;
    }

    public final long zzh(zzdm zzdm) throws zzsy {
        int i11;
        try {
            Uri uri = zzdm.zza;
            this.zzb = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            zze(zzdm);
            InputStream open = this.zza.open(path, 1);
            this.zzc = open;
            if (open.skip(zzdm.zzf) >= zzdm.zzf) {
                long j11 = zzdm.zzg;
                if (j11 != -1) {
                    this.zzd = j11;
                } else {
                    long available = (long) this.zzc.available();
                    this.zzd = available;
                    if (available == 2147483647L) {
                        this.zzd = -1;
                    }
                }
                this.zze = true;
                zzf(zzdm);
                return this.zzd;
            }
            throw new zzsy((Throwable) null, 2008);
        } catch (zzsy e11) {
            throw e11;
        } catch (IOException e12) {
            if (true != (e12 instanceof FileNotFoundException)) {
                i11 = 2000;
            } else {
                i11 = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
            }
            throw new zzsy(e12, i11);
        }
    }

    @Nullable
    public final Uri zzi() {
        return this.zzb;
    }

    public final void zzj() throws zzsy {
        this.zzb = null;
        try {
            InputStream inputStream = this.zzc;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzd();
            }
        } catch (IOException e11) {
            throw new zzsy(e11, 2000);
        } catch (Throwable th2) {
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzd();
            }
            throw th2;
        }
    }
}
