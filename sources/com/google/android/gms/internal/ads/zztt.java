package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class zztt extends zzdf {
    @Nullable
    private RandomAccessFile zza;
    @Nullable
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zztt() {
        super(false);
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws zzts {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.zzc;
        if (j11 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            int i13 = zzfn.zza;
            int read = randomAccessFile.read(bArr, i11, (int) Math.min(j11, (long) i12));
            if (read > 0) {
                this.zzc -= (long) read;
                zzc(read);
            }
            return read;
        } catch (IOException e11) {
            throw new zzts(e11, 2000);
        }
    }

    public final long zzh(zzdm zzdm) throws zzts {
        Uri uri = zzdm.zza;
        this.zzb = uri;
        zze(zzdm);
        int i11 = PlaybackException.ERROR_CODE_IO_NO_PERMISSION;
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.zza = randomAccessFile;
            try {
                randomAccessFile.seek(zzdm.zzf);
                long j11 = zzdm.zzg;
                if (j11 == -1) {
                    j11 = this.zza.length() - zzdm.zzf;
                }
                this.zzc = j11;
                if (j11 >= 0) {
                    this.zzd = true;
                    zzf(zzdm);
                    return this.zzc;
                }
                throw new zzts((String) null, (Throwable) null, 2008);
            } catch (IOException e11) {
                throw new zzts(e11, 2000);
            }
        } catch (FileNotFoundException e12) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new zzts(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e12, 1004);
            }
            if (zzfn.zza < 21 || !zztr.zzb(e12.getCause())) {
                i11 = 2005;
            }
            throw new zzts(e12, i11);
        } catch (SecurityException e13) {
            throw new zzts(e13, PlaybackException.ERROR_CODE_IO_NO_PERMISSION);
        } catch (RuntimeException e14) {
            throw new zzts(e14, 2000);
        }
    }

    @Nullable
    public final Uri zzi() {
        return this.zzb;
    }

    public final void zzj() throws zzts {
        this.zzb = null;
        try {
            RandomAccessFile randomAccessFile = this.zza;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzd();
            }
        } catch (IOException e11) {
            throw new zzts(e11, 2000);
        } catch (Throwable th2) {
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzd();
            }
            throw th2;
        }
    }
}
