package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzbh extends zzan {
    private volatile String zzut;
    private Future<String> zzyh;

    public zzbh(zzap zzap) {
        super(zzap);
    }

    private final boolean zzb(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotMainThread("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            zza("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e11) {
                zze("Failed to close clientId writing stream", e11);
                return true;
            }
        } catch (FileNotFoundException e12) {
            zze("Error creating clientId file", e12);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e13) {
                    zze("Failed to close clientId writing stream", e13);
                }
            }
            return false;
        } catch (IOException e14) {
            zze("Error writing to clientId file", e14);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e15) {
                    zze("Failed to close clientId writing stream", e15);
                }
            }
            return false;
        } catch (Throwable th2) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e16) {
                    zze("Failed to close clientId writing stream", e16);
                }
            }
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x006f A[SYNTHETIC, Splitter:B:38:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007c A[SYNTHETIC, Splitter:B:46:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0088 A[SYNTHETIC, Splitter:B:55:0x0088] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzd(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "gaClientId"
            java.lang.String r1 = "Failed to close client id reading stream"
            java.lang.String r2 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r2)
            r2 = 0
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0063, all -> 0x0061 }
            r4 = 36
            byte[] r5 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            r6 = 0
            int r4 = r3.read(r5, r6, r4)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            int r7 = r3.available()     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            if (r7 <= 0) goto L_0x0031
            java.lang.String r4 = "clientId file seems corrupted, deleting it."
            r8.zzt(r4)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            r3.close()     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            r9.deleteFile(r0)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            r3.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0030:
            return r2
        L_0x0031:
            r7 = 14
            if (r4 >= r7) goto L_0x0049
            java.lang.String r4 = "clientId file is empty, deleting it."
            r8.zzt(r4)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            r3.close()     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            r9.deleteFile(r0)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            r3.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0048:
            return r2
        L_0x0049:
            r3.close()     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            r7.<init>(r5, r6, r4)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            java.lang.String r4 = "Read client id from disk"
            r8.zza(r4, r7)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x005f }
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x005e:
            return r7
        L_0x005f:
            r4 = move-exception
            goto L_0x0065
        L_0x0061:
            r9 = move-exception
            goto L_0x007a
        L_0x0063:
            r4 = move-exception
            r3 = r2
        L_0x0065:
            java.lang.String r5 = "Error reading client id file, deleting it"
            r8.zze(r5, r4)     // Catch:{ all -> 0x0078 }
            r9.deleteFile(r0)     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0077
            r3.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0077:
            return r2
        L_0x0078:
            r9 = move-exception
            r2 = r3
        L_0x007a:
            if (r2 == 0) goto L_0x0084
            r2.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r0 = move-exception
            r8.zze(r1, r0)
        L_0x0084:
            throw r9
        L_0x0085:
            r3 = r2
        L_0x0086:
            if (r3 == 0) goto L_0x0090
            r3.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0090:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbh.zzd(android.content.Context):java.lang.String");
    }

    /* access modifiers changed from: private */
    @VisibleForTesting
    public final String zzek() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            if (!zzb(zzcq().getContext(), lowerCase)) {
                return "0";
            }
            return lowerCase;
        } catch (Exception e11) {
            zze("Error saving clientId file", e11);
            return "0";
        }
    }

    public final void zzaw() {
    }

    public final String zzeh() {
        String str;
        zzdb();
        synchronized (this) {
            if (this.zzut == null) {
                this.zzyh = zzcq().zza(new zzbi(this));
            }
            Future<String> future = this.zzyh;
            if (future != null) {
                try {
                    this.zzut = future.get();
                } catch (InterruptedException e11) {
                    zzd("ClientId loading or generation was interrupted", e11);
                    this.zzut = "0";
                } catch (ExecutionException e12) {
                    zze("Failed to load or generate client id", e12);
                    this.zzut = "0";
                }
                if (this.zzut == null) {
                    this.zzut = "0";
                }
                zza("Loaded clientId", this.zzut);
                this.zzyh = null;
            }
            str = this.zzut;
        }
        return str;
    }

    public final String zzei() {
        synchronized (this) {
            this.zzut = null;
            this.zzyh = zzcq().zza(new zzbj(this));
        }
        return zzeh();
    }

    @VisibleForTesting
    public final String zzej() {
        String zzd = zzd(zzcq().getContext());
        if (zzd == null) {
            return zzek();
        }
        return zzd;
    }
}
