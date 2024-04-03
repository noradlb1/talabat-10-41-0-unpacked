package com.google.android.gms.internal.icing;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.zip.CRC32;

@ShowFirstParty
@SafeParcelable.Class(creator = "UsageInfoCreator")
@SafeParcelable.Reserved({1000})
public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    @SafeParcelable.Field(id = 1)
    final zzi zza;
    @SafeParcelable.Field(id = 2)
    final long zzb;
    @SafeParcelable.Field(id = 3)
    int zzc;
    @SafeParcelable.Field(id = 4)
    @Nullable
    public final String zzd;
    @SafeParcelable.Field(id = 5)
    @Nullable
    final zzg zze;
    @SafeParcelable.Field(defaultValue = "false", id = 6)
    final boolean zzf;
    @SafeParcelable.Field(defaultValue = "-1", id = 7)
    int zzg;
    @SafeParcelable.Field(id = 8)
    int zzh;
    @SafeParcelable.Field(id = 9)
    @Nullable
    public final String zzi;

    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(id = 1) zzi zzi2, @SafeParcelable.Param(id = 2) long j11, @SafeParcelable.Param(id = 3) int i11, @SafeParcelable.Param(id = 4) @Nullable String str, @SafeParcelable.Param(id = 5) @Nullable zzg zzg2, @SafeParcelable.Param(id = 6) boolean z11, @SafeParcelable.Param(id = 7) int i12, @SafeParcelable.Param(id = 8) int i13, @SafeParcelable.Param(id = 9) @Nullable String str2) {
        this.zza = zzi2;
        this.zzb = j11;
        this.zzc = i11;
        this.zzd = str;
        this.zze = zzg2;
        this.zzf = z11;
        this.zzg = i12;
        this.zzh = i13;
        this.zzi = str2;
    }

    public static zzi zza(String str, Intent intent) {
        return zzc(str, zze(intent));
    }

    @VisibleForTesting
    public static zzf zzb(Intent intent, @Nullable String str, @Nullable Uri uri, @Nullable String str2, @Nullable List<AppIndexApi.AppIndexingLink> list) {
        String string;
        zzf zzf2 = new zzf();
        if (str != null) {
            zzr zzr = new zzr("title");
            zzr.zzc(true);
            zzr.zzd("name");
            zzf2.zza(new zzk(str, zzr.zze(), zzq.zzb("text1"), (byte[]) null));
        }
        if (uri != null) {
            String uri2 = uri.toString();
            zzr zzr2 = new zzr("web_url");
            zzr2.zzb(true);
            zzr2.zzd("url");
            zzf2.zza(new zzk(uri2, zzr2.zze(), zzk.zza, (byte[]) null));
        }
        if (list != null) {
            zzan zza2 = zzaq.zza();
            int size = list.size();
            zzap[] zzapArr = new zzap[size];
            for (int i11 = 0; i11 < size; i11++) {
                zzao zza3 = zzap.zza();
                AppIndexApi.AppIndexingLink appIndexingLink = list.get(i11);
                zza3.zza(appIndexingLink.appIndexingUrl.toString());
                zza3.zzc(appIndexingLink.viewId);
                Uri uri3 = appIndexingLink.webUrl;
                if (uri3 != null) {
                    zza3.zzb(uri3.toString());
                }
                zzapArr[i11] = (zzap) zza3.zzj();
            }
            zza2.zza(Arrays.asList(zzapArr));
            byte[] zzh2 = ((zzaq) zza2.zzj()).zzh();
            zzr zzr3 = new zzr("outlinks");
            zzr3.zzb(true);
            zzr3.zzd(".private:outLinks");
            zzr3.zza("blob");
            zzf2.zza(new zzk((String) null, zzr3.zze(), zzk.zza, zzh2));
        }
        String action = intent.getAction();
        if (action != null) {
            zzf2.zza(zzd("intent_action", action));
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            zzf2.zza(zzd("intent_data", dataString));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            zzf2.zza(zzd("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (!(extras == null || (string = extras.getString("intent_extra_data_key")) == null)) {
            zzf2.zza(zzd("intent_extra_data", string));
        }
        if (str2 != null) {
            zzf2.zzb(str2);
        }
        zzf2.zzc(true);
        return zzf2;
    }

    private static zzi zzc(String str, String str2) {
        return new zzi(str, "", str2);
    }

    private static zzk zzd(String str, String str2) {
        zzr zzr = new zzr(str);
        zzr.zzb(true);
        return new zzk(str2, zzr.zze(), zzq.zzb(str), (byte[]) null);
    }

    private static String zze(Intent intent) {
        String uri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(uri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (UnsupportedEncodingException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public final String toString() {
        return String.format(Locale.US, "UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.zza, Long.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzh)});
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i11, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i11, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzh);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public zzx(String str, Intent intent, String str2, Uri uri, @Nullable String str3, List<AppIndexApi.AppIndexingLink> list, int i11) {
        this(zzc(str, zze(intent)), System.currentTimeMillis(), 0, (String) null, zzb(intent, str2, uri, (String) null, list).zze(), false, -1, 1, (String) null);
        String str4 = str;
        Intent intent2 = intent;
        String str5 = str2;
    }
}
