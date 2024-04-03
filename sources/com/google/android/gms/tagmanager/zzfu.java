package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.util.VisibleForTesting;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

final class zzfu implements zzbe {
    private final String zzabp;
    private final zzfx zzalb;
    private final zzfw zzalc;
    private final Context zzrm;

    @VisibleForTesting
    private zzfu(zzfx zzfx, Context context, zzfw zzfw) {
        this.zzalb = zzfx;
        this.zzrm = context.getApplicationContext();
        this.zzalc = zzfw;
        String str = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String str2 = null;
        if (!(locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(locale.getLanguage().toLowerCase());
            if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
                sb2.append(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
                sb2.append(locale.getCountry().toLowerCase());
            }
            str2 = sb2.toString();
        }
        this.zzabp = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleTagManager", "4.00", str, str2, Build.MODEL, Build.ID});
    }

    public final void zzd(List<zzbw> list) {
        HttpURLConnection zzc;
        InputStream inputStream;
        int min = Math.min(list.size(), 40);
        boolean z11 = true;
        for (int i11 = 0; i11 < min; i11++) {
            zzbw zzbw = list.get(i11);
            URL zzd = zzd(zzbw);
            if (zzd == null) {
                zzdi.zzac("No destination: discarding hit.");
                this.zzalc.zzb(zzbw);
            } else {
                try {
                    zzc = this.zzalb.zzc(zzd);
                    inputStream = null;
                    if (z11) {
                        zzdn.zzn(this.zzrm);
                        z11 = false;
                    }
                    zzc.setRequestProperty("User-Agent", this.zzabp);
                    int responseCode = zzc.getResponseCode();
                    InputStream inputStream2 = zzc.getInputStream();
                    if (responseCode != 200) {
                        StringBuilder sb2 = new StringBuilder(25);
                        sb2.append("Bad response: ");
                        sb2.append(responseCode);
                        zzdi.zzac(sb2.toString());
                        this.zzalc.zzc(zzbw);
                    } else {
                        this.zzalc.zza(zzbw);
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    zzc.disconnect();
                } catch (IOException e11) {
                    String simpleName = e11.getClass().getSimpleName();
                    zzdi.zzac(simpleName.length() != 0 ? "Exception sending hit: ".concat(simpleName) : new String("Exception sending hit: "));
                    zzdi.zzac(e11.getMessage());
                    this.zzalc.zzc(zzbw);
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    zzc.disconnect();
                    throw th2;
                }
            }
        }
    }

    public final boolean zzhy() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzrm.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzdi.zzab("...no network connectivity");
        return false;
    }

    @VisibleForTesting
    public zzfu(Context context, zzfw zzfw) {
        this(new zzfv(), context, zzfw);
    }

    @VisibleForTesting
    private static URL zzd(zzbw zzbw) {
        try {
            return new URL(zzbw.zzij());
        } catch (MalformedURLException unused) {
            zzdi.zzav("Error trying to parse the GTM url.");
            return null;
        }
    }
}
