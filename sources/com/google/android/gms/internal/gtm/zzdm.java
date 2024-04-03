package com.google.android.gms.internal.gtm;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzdm implements zzdo {
    private final /* synthetic */ zzdl zzamq;

    public zzdm(zzdl zzdl) {
        this.zzamq = zzdl;
    }

    public final AdvertisingIdClient.Info zzgv() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.zzamq.zzrm);
        } catch (IllegalStateException e11) {
            zzev.zzb("IllegalStateException getting Advertising Id Info", e11);
            return null;
        } catch (GooglePlayServicesRepairableException e12) {
            zzev.zzb("GooglePlayServicesRepairableException getting Advertising Id Info", e12);
            return null;
        } catch (IOException e13) {
            zzev.zzb("IOException getting Ad Id Info", e13);
            return null;
        } catch (GooglePlayServicesNotAvailableException e14) {
            boolean unused = this.zzamq.zzamn = false;
            zzev.zzb("GooglePlayServicesNotAvailableException getting Advertising Id Info", e14);
            return null;
        } catch (Exception e15) {
            zzev.zzb("Unknown exception. Could not get the Advertising Id Info.", e15);
            return null;
        }
    }
}
