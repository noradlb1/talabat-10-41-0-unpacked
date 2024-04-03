package com.google.android.gms.tagmanager;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzb implements zzd {
    private final /* synthetic */ zza zzads;

    public zzb(zza zza) {
        this.zzads = zza;
    }

    public final AdvertisingIdClient.Info zzgv() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.zzads.zzrm);
        } catch (IllegalStateException e11) {
            zzdi.zzb("IllegalStateException getting Advertising Id Info", e11);
            return null;
        } catch (GooglePlayServicesRepairableException e12) {
            zzdi.zzb("GooglePlayServicesRepairableException getting Advertising Id Info", e12);
            return null;
        } catch (IOException e13) {
            zzdi.zzb("IOException getting Ad Id Info", e13);
            return null;
        } catch (GooglePlayServicesNotAvailableException e14) {
            this.zzads.close();
            zzdi.zzb("GooglePlayServicesNotAvailableException getting Advertising Id Info", e14);
            return null;
        } catch (Exception e15) {
            zzdi.zzb("Unknown exception. Could not get the Advertising Id Info.", e15);
            return null;
        }
    }
}
