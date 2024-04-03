package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

@VisibleForTesting
public final class zzad extends zzan {
    private static boolean zzvo;
    private AdvertisingIdClient.Info zzvp;
    private final zzcv zzvq;
    private String zzvr;
    private boolean zzvs = false;
    private final Object zzvt = new Object();

    public zzad(zzap zzap) {
        super(zzap);
        this.zzvq = new zzcv(zzap.zzcn());
    }

    private final boolean zza(AdvertisingIdClient.Info info, AdvertisingIdClient.Info info2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        if (info2 == null) {
            str = null;
        } else {
            str = info2.getId();
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String zzeh = zzcw().zzeh();
        synchronized (this.zzvt) {
            if (!this.zzvs) {
                this.zzvr = zzcg();
                this.zzvs = true;
            } else if (TextUtils.isEmpty(this.zzvr)) {
                if (info != null) {
                    str6 = info.getId();
                }
                if (str6 == null) {
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(zzeh);
                    if (valueOf2.length() != 0) {
                        str5 = valueOf.concat(valueOf2);
                    } else {
                        str5 = new String(valueOf);
                    }
                    boolean zzp = zzp(str5);
                    return zzp;
                }
                String valueOf3 = String.valueOf(zzeh);
                if (valueOf3.length() != 0) {
                    str4 = str6.concat(valueOf3);
                } else {
                    str4 = new String(str6);
                }
                this.zzvr = zzo(str4);
            }
            String valueOf4 = String.valueOf(str);
            String valueOf5 = String.valueOf(zzeh);
            if (valueOf5.length() != 0) {
                str2 = valueOf4.concat(valueOf5);
            } else {
                str2 = new String(valueOf4);
            }
            String zzo = zzo(str2);
            if (TextUtils.isEmpty(zzo)) {
                return false;
            }
            if (zzo.equals(this.zzvr)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.zzvr)) {
                zzq("Resetting the client id because Advertising Id changed.");
                zzeh = zzcw().zzei();
                zza("New client Id", zzeh);
            }
            String valueOf6 = String.valueOf(str);
            String valueOf7 = String.valueOf(zzeh);
            if (valueOf7.length() != 0) {
                str3 = valueOf6.concat(valueOf7);
            } else {
                str3 = new String(valueOf6);
            }
            boolean zzp2 = zzp(str3);
            return zzp2;
        }
    }

    private final synchronized AdvertisingIdClient.Info zzce() {
        if (this.zzvq.zzj(1000)) {
            this.zzvq.start();
            AdvertisingIdClient.Info zzcf = zzcf();
            if (zza(this.zzvp, zzcf)) {
                this.zzvp = zzcf;
            } else {
                zzu("Failed to reset client id on adid change. Not using adid");
                this.zzvp = new AdvertisingIdClient.Info("", false);
            }
        }
        return this.zzvp;
    }

    private final AdvertisingIdClient.Info zzcf() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        } catch (IllegalStateException unused) {
            zzt("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Exception e11) {
            if (!zzvo) {
                zzvo = true;
                zzd("Error getting advertiser id", e11);
            }
            return null;
        }
    }

    private final String zzcg() {
        String str = null;
        try {
            FileInputStream openFileInput = getContext().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzt("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                getContext().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                zzq("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                } catch (FileNotFoundException unused) {
                } catch (IOException e11) {
                    e = e11;
                    str = str2;
                    zzd("Error reading Hash file, deleting it", e);
                    getContext().deleteFile("gaClientIdData");
                    return str;
                }
                return str2;
            }
        } catch (FileNotFoundException unused2) {
            return null;
        } catch (IOException e12) {
            e = e12;
            zzd("Error reading Hash file, deleting it", e);
            getContext().deleteFile("gaClientIdData");
            return str;
        }
    }

    private static String zzo(String str) {
        MessageDigest zzai = zzcz.zzai("MD5");
        if (zzai == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzai.digest(str.getBytes()))});
    }

    private final boolean zzp(String str) {
        try {
            String zzo = zzo(str);
            zzq("Storing hashed adid.");
            FileOutputStream openFileOutput = getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zzo.getBytes());
            openFileOutput.close();
            this.zzvr = zzo;
            return true;
        } catch (IOException e11) {
            zze("Error creating hash file", e11);
            return false;
        }
    }

    public final void zzaw() {
    }

    public final boolean zzbw() {
        zzdb();
        AdvertisingIdClient.Info zzce = zzce();
        if (zzce == null || zzce.isLimitAdTrackingEnabled()) {
            return false;
        }
        return true;
    }

    public final String zzcd() {
        String str;
        zzdb();
        AdvertisingIdClient.Info zzce = zzce();
        if (zzce != null) {
            str = zzce.getId();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }
}
