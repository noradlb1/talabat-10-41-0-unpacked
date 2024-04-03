package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.Set;
import javax.annotation.Nullable;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@ShowFirstParty
@KeepForSdk
@CheckReturnValue
public class GoogleSignatureVerifier {
    @Nullable
    private static GoogleSignatureVerifier zza;
    @Nullable
    private static volatile Set zzb;
    private final Context zzc;
    private volatile String zzd;

    public GoogleSignatureVerifier(@NonNull Context context) {
        this.zzc = context.getApplicationContext();
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzn.zze(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    @Nullable
    public static final zzj zza(PackageInfo packageInfo, zzj... zzjArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
        for (int i11 = 0; i11 < zzjArr.length; i11++) {
            if (zzjArr[i11].equals(zzk)) {
                return zzjArr[i11];
            }
        }
        return null;
    }

    public static final boolean zzb(@NonNull PackageInfo packageInfo, boolean z11) {
        zzj zzj;
        if (z11 && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || (applicationInfo.flags & 129) == 0) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z11) {
                zzj = zza(packageInfo, zzm.zza);
            } else {
                zzj = zza(packageInfo, zzm.zza[0]);
            }
            if (zzj != null) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final zzx zzc(String str, boolean z11, boolean z12) {
        zzx zzx;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return zzx.zzc("null pkg");
        }
        if (str.equals(this.zzd)) {
            return zzx.zzb();
        }
        if (zzn.zzg()) {
            zzx = zzn.zzb(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.zzc.getPackageManager().getPackageInfo(str, 64);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc);
                if (packageInfo == null) {
                    zzx = zzx.zzc("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        zzx = zzx.zzc("single cert required");
                    } else {
                        zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        zzx zza2 = zzn.zza(str2, zzk, honorsDebugCertificates, false);
                        if (!zza2.zza || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !zzn.zza(str2, zzk, false, true).zza) {
                            zzx = zza2;
                        } else {
                            zzx = zzx.zzc("debuggable release cert app rejected");
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e11) {
                return zzx.zzd("no pkg ".concat(str), e11);
            }
        }
        if (zzx.zza) {
            this.zzd = str;
        }
        return zzx;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(@NonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(@NonNull String str) {
        zzx zzc2 = zzc(str, false, false);
        zzc2.zze();
        return zzc2.zza;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i11) {
        zzx zzx;
        int length;
        String[] packagesForUid = this.zzc.getPackageManager().getPackagesForUid(i11);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzx = null;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    Preconditions.checkNotNull(zzx);
                    break;
                }
                zzx = zzc(packagesForUid[i12], false, false);
                if (zzx.zza) {
                    break;
                }
                i12++;
            }
        } else {
            zzx = zzx.zzc("no pkgs");
        }
        zzx.zze();
        return zzx.zza;
    }
}
