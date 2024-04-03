package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbfi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbfi> CREATOR = new zzbfj();
    @SafeParcelable.Field(id = 2)
    public final String zza;
    @SafeParcelable.Field(id = 3)
    public final int zzb;
    @SafeParcelable.Field(id = 4)
    public final int zzc;
    @SafeParcelable.Field(id = 5)
    public final boolean zzd;
    @SafeParcelable.Field(id = 6)
    public final int zze;
    @SafeParcelable.Field(id = 7)
    public final int zzf;
    @SafeParcelable.Field(id = 8)
    public final zzbfi[] zzg;
    @SafeParcelable.Field(id = 9)
    public final boolean zzh;
    @SafeParcelable.Field(id = 10)
    public final boolean zzi;
    @SafeParcelable.Field(id = 11)
    public boolean zzj;
    @SafeParcelable.Field(id = 12)
    public boolean zzk;
    @SafeParcelable.Field(id = 13)
    public boolean zzl;
    @SafeParcelable.Field(id = 14)
    public boolean zzm;
    @SafeParcelable.Field(id = 15)
    public boolean zzn;
    @SafeParcelable.Field(id = 16)
    public boolean zzo;

    public zzbfi() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zzbfi[]) null, false, false, false, false, false, false, false, false);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return (int) (((float) zzf(displayMetrics)) * displayMetrics.density);
    }

    public static zzbfi zzb() {
        return new zzbfi("interstitial_mb", 0, 0, false, 0, 0, (zzbfi[]) null, false, false, false, false, true, false, false, false);
    }

    public static zzbfi zzc() {
        return new zzbfi("320x50_mb", 0, 0, false, 0, 0, (zzbfi[]) null, true, false, false, false, false, false, false, false);
    }

    public static zzbfi zzd() {
        return new zzbfi("reward_mb", 0, 0, true, 0, 0, (zzbfi[]) null, false, false, false, false, false, false, false, false);
    }

    public static zzbfi zze() {
        return new zzbfi("invalid", 0, 0, false, 0, 0, (zzbfi[]) null, false, false, false, true, false, false, false, false);
    }

    private static int zzf(DisplayMetrics displayMetrics) {
        int i11 = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i11 <= 400) {
            return 32;
        }
        return i11 <= 720 ? 50 : 90;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeInt(parcel, 6, this.zze);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzg, i11, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzbfi(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbfi(android.content.Context r14, com.google.android.gms.ads.AdSize[] r15) {
        /*
            r13 = this;
            java.lang.Class<android.view.Display> r0 = android.view.Display.class
            r13.<init>()
            r1 = 0
            r2 = r15[r1]
            r13.zzd = r1
            boolean r3 = r2.isFluid()
            r13.zzi = r3
            boolean r4 = com.google.android.gms.ads.zza.zzf(r2)
            r13.zzm = r4
            boolean r4 = com.google.android.gms.ads.zza.zzg(r2)
            r13.zzn = r4
            boolean r4 = com.google.android.gms.ads.zza.zzh(r2)
            r13.zzo = r4
            if (r3 == 0) goto L_0x0033
            com.google.android.gms.ads.AdSize r3 = com.google.android.gms.ads.AdSize.BANNER
            int r4 = r3.getWidth()
            r13.zze = r4
            int r3 = r3.getHeight()
            r13.zzb = r3
            goto L_0x005f
        L_0x0033:
            boolean r3 = r13.zzn
            if (r3 == 0) goto L_0x0044
            int r3 = r2.getWidth()
            r13.zze = r3
            int r3 = com.google.android.gms.ads.zza.zza(r2)
            r13.zzb = r3
            goto L_0x005f
        L_0x0044:
            if (r4 == 0) goto L_0x0053
            int r3 = r2.getWidth()
            r13.zze = r3
            int r3 = com.google.android.gms.ads.zza.zzb(r2)
            r13.zzb = r3
            goto L_0x005f
        L_0x0053:
            int r3 = r2.getWidth()
            r13.zze = r3
            int r3 = r2.getHeight()
            r13.zzb = r3
        L_0x005f:
            int r4 = r13.zze
            android.content.res.Resources r5 = r14.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            r6 = -1
            if (r4 != r6) goto L_0x0132
            com.google.android.gms.internal.ads.zzbgo.zzb()
            android.content.res.Resources r7 = r14.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            int r7 = r7.orientation
            r8 = 2
            if (r7 == r8) goto L_0x007e
            goto L_0x011a
        L_0x007e:
            android.content.res.Resources r7 = r14.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            int r8 = r7.heightPixels
            float r8 = (float) r8
            float r7 = r7.density
            float r8 = r8 / r7
            int r7 = (int) r8
            r8 = 600(0x258, float:8.41E-43)
            if (r7 >= r8) goto L_0x011a
            com.google.android.gms.internal.ads.zzbgo.zzb()
            android.content.res.Resources r7 = r14.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            java.lang.String r8 = "window"
            java.lang.Object r8 = r14.getSystemService(r8)
            android.view.WindowManager r8 = (android.view.WindowManager) r8
            if (r8 == 0) goto L_0x011a
            android.view.Display r8 = r8.getDefaultDisplay()
            boolean r9 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()
            if (r9 == 0) goto L_0x00b8
            r8.getRealMetrics(r7)
            int r0 = r7.heightPixels
            int r9 = r7.widthPixels
            goto L_0x00ec
        L_0x00b8:
            java.lang.String r9 = "getRawHeight"
            java.lang.Class[] r10 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x011a }
            java.lang.reflect.Method r9 = r0.getMethod(r9, r10)     // Catch:{ Exception -> 0x011a }
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x011a }
            java.lang.Object r9 = r9.invoke(r8, r10)     // Catch:{ Exception -> 0x011a }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ Exception -> 0x011a }
            java.lang.String r10 = "getRawWidth"
            java.lang.Class[] r11 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x011a }
            java.lang.reflect.Method r0 = r0.getMethod(r10, r11)     // Catch:{ Exception -> 0x011a }
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x011a }
            java.lang.Object r0 = r0.invoke(r8, r10)     // Catch:{ Exception -> 0x011a }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x011a }
            if (r9 != 0) goto L_0x00dc
            r9 = r1
            goto L_0x00e0
        L_0x00dc:
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x011a }
        L_0x00e0:
            if (r0 != 0) goto L_0x00e5
            r0 = r9
            r9 = r1
            goto L_0x00ec
        L_0x00e5:
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x011a }
            r12 = r9
            r9 = r0
            r0 = r12
        L_0x00ec:
            r8.getMetrics(r7)
            int r8 = r7.heightPixels
            int r7 = r7.widthPixels
            if (r8 != r0) goto L_0x011a
            if (r7 != r9) goto L_0x011a
            int r0 = r5.widthPixels
            com.google.android.gms.internal.ads.zzbgo.zzb()
            android.content.res.Resources r7 = r14.getResources()
            java.lang.String r8 = "dimen"
            java.lang.String r9 = "android"
            java.lang.String r10 = "navigation_bar_width"
            int r7 = r7.getIdentifier(r10, r8, r9)
            if (r7 <= 0) goto L_0x0115
            android.content.res.Resources r8 = r14.getResources()
            int r7 = r8.getDimensionPixelSize(r7)
            goto L_0x0116
        L_0x0115:
            r7 = r1
        L_0x0116:
            int r0 = r0 - r7
            r13.zzf = r0
            goto L_0x011e
        L_0x011a:
            int r0 = r5.widthPixels
            r13.zzf = r0
        L_0x011e:
            float r0 = (float) r0
            float r7 = r5.density
            float r0 = r0 / r7
            double r7 = (double) r0
            int r0 = (int) r7
            double r9 = (double) r0
            double r7 = r7 - r9
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L_0x013f
            int r0 = r0 + 1
            goto L_0x013f
        L_0x0132:
            int r0 = r13.zze
            com.google.android.gms.internal.ads.zzbgo.zzb()
            int r7 = r13.zze
            int r7 = com.google.android.gms.internal.ads.zzcis.zzk(r5, r7)
            r13.zzf = r7
        L_0x013f:
            r7 = -2
            if (r3 != r7) goto L_0x0147
            int r8 = zzf(r5)
            goto L_0x0149
        L_0x0147:
            int r8 = r13.zzb
        L_0x0149:
            com.google.android.gms.internal.ads.zzbgo.zzb()
            int r5 = com.google.android.gms.internal.ads.zzcis.zzk(r5, r8)
            r13.zzc = r5
            java.lang.String r5 = "_as"
            java.lang.String r9 = "x"
            r10 = 26
            if (r4 == r6) goto L_0x0190
            if (r3 != r7) goto L_0x015d
            goto L_0x0190
        L_0x015d:
            boolean r0 = r13.zzn
            if (r0 != 0) goto L_0x0174
            boolean r0 = r13.zzo
            if (r0 == 0) goto L_0x0166
            goto L_0x0174
        L_0x0166:
            boolean r0 = r13.zzi
            if (r0 == 0) goto L_0x016d
            java.lang.String r0 = "320x50_mb"
            goto L_0x018d
        L_0x016d:
            java.lang.String r0 = r2.toString()
            r13.zza = r0
            goto L_0x01a7
        L_0x0174:
            int r0 = r13.zze
            int r2 = r13.zzb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r10)
            r3.append(r0)
            r3.append(r9)
            r3.append(r2)
            r3.append(r5)
            java.lang.String r0 = r3.toString()
        L_0x018d:
            r13.zza = r0
            goto L_0x01a7
        L_0x0190:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r10)
            r2.append(r0)
            r2.append(r9)
            r2.append(r8)
            r2.append(r5)
            java.lang.String r0 = r2.toString()
            r13.zza = r0
        L_0x01a7:
            int r0 = r15.length
            r2 = 1
            if (r0 <= r2) goto L_0x01c1
            com.google.android.gms.internal.ads.zzbfi[] r0 = new com.google.android.gms.internal.ads.zzbfi[r0]
            r13.zzg = r0
            r0 = r1
        L_0x01b0:
            int r2 = r15.length
            if (r0 >= r2) goto L_0x01c4
            com.google.android.gms.internal.ads.zzbfi[] r2 = r13.zzg
            com.google.android.gms.internal.ads.zzbfi r3 = new com.google.android.gms.internal.ads.zzbfi
            r4 = r15[r0]
            r3.<init>((android.content.Context) r14, (com.google.android.gms.ads.AdSize) r4)
            r2[r0] = r3
            int r0 = r0 + 1
            goto L_0x01b0
        L_0x01c1:
            r14 = 0
            r13.zzg = r14
        L_0x01c4:
            r13.zzh = r1
            r13.zzj = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfi.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @SafeParcelable.Constructor
    public zzbfi(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i11, @SafeParcelable.Param(id = 4) int i12, @SafeParcelable.Param(id = 5) boolean z11, @SafeParcelable.Param(id = 6) int i13, @SafeParcelable.Param(id = 7) int i14, @SafeParcelable.Param(id = 8) zzbfi[] zzbfiArr, @SafeParcelable.Param(id = 9) boolean z12, @SafeParcelable.Param(id = 10) boolean z13, @SafeParcelable.Param(id = 11) boolean z14, @SafeParcelable.Param(id = 12) boolean z15, @SafeParcelable.Param(id = 13) boolean z16, @SafeParcelable.Param(id = 14) boolean z17, @SafeParcelable.Param(id = 15) boolean z18, @SafeParcelable.Param(id = 16) boolean z19) {
        this.zza = str;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = z11;
        this.zze = i13;
        this.zzf = i14;
        this.zzg = zzbfiArr;
        this.zzh = z12;
        this.zzi = z13;
        this.zzj = z14;
        this.zzk = z15;
        this.zzl = z16;
        this.zzm = z17;
        this.zzn = z18;
        this.zzo = z19;
    }
}
