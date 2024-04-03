package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

public final class zzmz {
    private final ExecutorService zzajm;
    private final zzne zzate;
    private final Context zzrm;

    public zzmz(Context context) {
        this(context, zzdf.zzgp().zzr(zzdi.zzadg), new zzna(context));
    }

    @VisibleForTesting
    private final File zzch(String str) {
        return new File(this.zzrm.getDir("google_tagmanager", 0), zzci(str));
    }

    private static String zzci(String str) {
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            return "resource_".concat(valueOf);
        }
        return new String("resource_");
    }

    public final void zza(String str, zzmn zzmn) {
        this.zzajm.execute(new zznb(this, str, zzmn));
    }

    @VisibleForTesting
    public final void zzb(String str, zzmn zzmn) {
        zzev.zzab("Starting to load a saved resource file from Disk.");
        try {
            zzmn.zzc(zza(new FileInputStream(zzch(str))));
        } catch (FileNotFoundException unused) {
            String valueOf = String.valueOf(zzci(str));
            zzev.zzav(valueOf.length() != 0 ? "Saved resource not found: ".concat(valueOf) : new String("Saved resource not found: "));
            zzmn.zzb(0, 1);
        }
    }

    public final long zzcg(String str) {
        File zzch = zzch(str);
        if (zzch.exists()) {
            return zzch.lastModified();
        }
        return 0;
    }

    public final void zza(String str, String str2, zzmn zzmn) {
        this.zzajm.execute(new zznc(this, str, str2, zzmn));
    }

    @VisibleForTesting
    private zzmz(Context context, ExecutorService executorService, zzne zzne) {
        this.zzrm = context;
        this.zzajm = executorService;
        this.zzate = zzne;
    }

    public final void zza(String str, byte[] bArr) {
        this.zzajm.execute(new zznd(this, str, bArr));
    }

    private static byte[] zza(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            IOUtils.copyStream(inputStream, byteArrayOutputStream);
            try {
                inputStream.close();
            } catch (IOException unused) {
                zzev.zzac("Error closing stream for reading resource from disk");
                return null;
            }
        } catch (IOException unused2) {
            zzev.zzac("Failed to read the resource from disk");
            try {
                inputStream.close();
            } catch (IOException unused3) {
                zzev.zzac("Error closing stream for reading resource from disk");
                return null;
            }
        } catch (Throwable th2) {
            try {
                inputStream.close();
                throw th2;
            } catch (IOException unused4) {
                zzev.zzac("Error closing stream for reading resource from disk");
                return null;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    @VisibleForTesting
    public final void zzb(String str, String str2, zzmn zzmn) {
        zzev.zzab("Starting to load a default asset file from Disk.");
        if (str2 == null) {
            zzev.zzab("Default asset file is not specified. Not proceeding with the loading");
            zzmn.zzb(0, 2);
            return;
        }
        try {
            InputStream open = this.zzate.open(str2);
            if (open != null) {
                zzmn.zzc(zza(open));
            } else {
                zzmn.zzb(0, 2);
            }
        } catch (IOException unused) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 42 + str2.length());
            sb2.append("Default asset file not found. ");
            sb2.append(str);
            sb2.append(". Filename: ");
            sb2.append(str2);
            zzev.zzav(sb2.toString());
            zzmn.zzb(0, 2);
        }
    }

    @VisibleForTesting
    public final void zzb(String str, byte[] bArr) {
        File zzch = zzch(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzch);
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 24);
                    sb2.append("Resource ");
                    sb2.append(str);
                    sb2.append(" saved on Disk.");
                    zzev.zzab(sb2.toString());
                } catch (IOException unused) {
                    zzev.zzav("Error closing stream for writing resource to disk");
                }
            } catch (IOException unused2) {
                zzev.zzav("Error writing resource to disk. Removing resource from disk");
                zzch.delete();
                try {
                    fileOutputStream.close();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 24);
                    sb3.append("Resource ");
                    sb3.append(str);
                    sb3.append(" saved on Disk.");
                    zzev.zzab(sb3.toString());
                } catch (IOException unused3) {
                    zzev.zzav("Error closing stream for writing resource to disk");
                }
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                    StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 24);
                    sb4.append("Resource ");
                    sb4.append(str);
                    sb4.append(" saved on Disk.");
                    zzev.zzab(sb4.toString());
                } catch (IOException unused4) {
                    zzev.zzav("Error closing stream for writing resource to disk");
                }
                throw th2;
            }
        } catch (FileNotFoundException unused5) {
            zzev.zzav("Error opening resource file for writing");
        }
    }
}
