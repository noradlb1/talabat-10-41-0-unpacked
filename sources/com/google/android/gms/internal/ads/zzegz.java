package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.huawei.location.lite.common.util.filedownload.DownloadConstants;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;

@Instrumented
public final class zzegz {
    private final zzbay zza;
    private final Context zzb;
    private final zzegh zzc;
    private final zzcjf zzd;
    private final String zze;
    private final zzfio zzf;
    private final zzg zzg = zzt.zzo().zzh();

    public zzegz(Context context, zzcjf zzcjf, zzbay zzbay, zzegh zzegh, String str, zzfio zzfio) {
        this.zzb = context;
        this.zzd = zzcjf;
        this.zza = zzbay;
        this.zzc = zzegh;
        this.zze = str;
        this.zzf = zzfio;
    }

    private static final void zzc(SQLiteDatabase sQLiteDatabase, ArrayList<zzbdf> arrayList) {
        int size = arrayList.size();
        long j11 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            zzbdf zzbdf = arrayList.get(i11);
            if (zzbdf.zzv() == 2 && zzbdf.zze() > j11) {
                j11 = zzbdf.zze();
            }
        }
        if (j11 != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j11));
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
            } else {
                SQLiteInstrumentation.update(sQLiteDatabase, "offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
            }
        }
    }

    public final /* synthetic */ Void zza(boolean z11, SQLiteDatabase sQLiteDatabase) throws Exception {
        String str;
        String str2;
        String str3;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        if (z11) {
            this.zzb.deleteDatabase("OfflineUpload.db");
            return null;
        }
        int i11 = 2;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgq)).booleanValue()) {
            zzfin zzb2 = zzfin.zzb("oa_upload");
            zzb2.zza("oa_failed_reqs", String.valueOf(zzegu.zza(sQLiteDatabase2, 0)));
            zzb2.zza("oa_total_reqs", String.valueOf(zzegu.zza(sQLiteDatabase2, 1)));
            zzb2.zza("oa_upload_time", String.valueOf(zzt.zzA().currentTimeMillis()));
            zzb2.zza("oa_last_successful_time", String.valueOf(zzegu.zzb(sQLiteDatabase2, 2)));
            if (this.zzg.zzL()) {
                str = "";
            } else {
                str = this.zze;
            }
            zzb2.zza("oa_session_id", str);
            this.zzf.zzb(zzb2);
            ArrayList<zzbdf> zzc2 = zzegu.zzc(sQLiteDatabase);
            zzc(sQLiteDatabase2, zzc2);
            int size = zzc2.size();
            for (int i12 = 0; i12 < size; i12++) {
                zzbdf zzbdf = zzc2.get(i12);
                zzfin zzb3 = zzfin.zzb("oa_signals");
                if (this.zzg.zzL()) {
                    str2 = "";
                } else {
                    str2 = this.zze;
                }
                zzb3.zza("oa_session_id", str2);
                zzbda zzf2 = zzbdf.zzf();
                if (zzf2.zzf()) {
                    str3 = String.valueOf(zzf2.zzh() - 1);
                } else {
                    str3 = "-1";
                }
                String obj = zzftk.zzb(zzbdf.zzk(), zzegy.zza).toString();
                zzb3.zza("oa_sig_ts", String.valueOf(zzbdf.zze()));
                zzb3.zza("oa_sig_status", String.valueOf(zzbdf.zzv() - 1));
                zzb3.zza("oa_sig_resp_lat", String.valueOf(zzbdf.zzd()));
                zzb3.zza("oa_sig_render_lat", String.valueOf(zzbdf.zzc()));
                zzb3.zza("oa_sig_formats", obj);
                zzb3.zza("oa_sig_nw_type", str3);
                zzb3.zza("oa_sig_wifi", String.valueOf(zzbdf.zzw() - 1));
                zzb3.zza("oa_sig_airplane", String.valueOf(zzbdf.zzs() - 1));
                zzb3.zza("oa_sig_data", String.valueOf(zzbdf.zzt() - 1));
                zzb3.zza("oa_sig_nw_resp", String.valueOf(zzbdf.zza()));
                zzb3.zza("oa_sig_offline", String.valueOf(zzbdf.zzu() - 1));
                zzb3.zza("oa_sig_nw_state", String.valueOf(zzbdf.zzj().zza()));
                if (zzf2.zze() && zzf2.zzf() && zzf2.zzh() == 2) {
                    zzb3.zza("oa_sig_cell_type", String.valueOf(zzf2.zzg() - 1));
                }
                this.zzf.zzb(zzb3);
            }
        } else {
            ArrayList<zzbdf> zzc3 = zzegu.zzc(sQLiteDatabase);
            zzbdg zza2 = zzbdk.zza();
            zza2.zzb(this.zzb.getPackageName());
            zza2.zzc(Build.MODEL);
            zza2.zzd(zzegu.zza(sQLiteDatabase2, 0));
            zza2.zza(zzc3);
            zza2.zzf(zzegu.zza(sQLiteDatabase2, 1));
            zza2.zzg(zzt.zzA().currentTimeMillis());
            zza2.zze(zzegu.zzb(sQLiteDatabase2, 2));
            zzc(sQLiteDatabase2, zzc3);
            this.zza.zzb(new zzegv((zzbdk) zza2.zzah()));
            zzbdv zza3 = zzbdw.zza();
            zza3.zza(this.zzd.zzb);
            zza3.zzc(this.zzd.zzc);
            if (true == this.zzd.zzd) {
                i11 = 0;
            }
            zza3.zzb(i11);
            this.zza.zzb(new zzegw((zzbdw) zza3.zzah()));
            this.zza.zzc(DownloadConstants.DOWNLOAD_URL_ERROR_CODE);
        }
        boolean z12 = sQLiteDatabase2 instanceof SQLiteDatabase;
        if (!z12) {
            sQLiteDatabase2.delete("offline_signal_contents", (String) null, (String[]) null);
        } else {
            SQLiteInstrumentation.delete(sQLiteDatabase2, "offline_signal_contents", (String) null, (String[]) null);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", 0);
        String[] strArr = {"failed_requests"};
        if (!z12) {
            sQLiteDatabase2.update("offline_signal_statistics", contentValues, "statistic_name = ?", strArr);
        } else {
            SQLiteInstrumentation.update(sQLiteDatabase2, "offline_signal_statistics", contentValues, "statistic_name = ?", strArr);
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("value", 0);
        String[] strArr2 = {"total_requests"};
        if (!z12) {
            sQLiteDatabase2.update("offline_signal_statistics", contentValues2, "statistic_name = ?", strArr2);
            return null;
        }
        SQLiteInstrumentation.update(sQLiteDatabase2, "offline_signal_statistics", contentValues2, "statistic_name = ?", strArr2);
        return null;
    }

    public final void zzb(boolean z11) {
        String str;
        try {
            this.zzc.zza(new zzegx(this, z11));
        } catch (Exception e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "Error in offline signals database startup: ".concat(valueOf);
            } else {
                str = new String("Error in offline signals database startup: ");
            }
            zzciz.zzg(str);
        }
    }
}
