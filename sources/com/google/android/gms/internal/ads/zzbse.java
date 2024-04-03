package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import com.apptimize.c;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbuk;
import com.google.android.gms.internal.ads.zzcog;
import com.google.android.gms.internal.ads.zzcop;
import com.google.android.gms.internal.ads.zzcpm;
import com.google.android.gms.internal.ads.zzcpq;
import com.google.android.gms.internal.ads.zzcpu;
import com.google.android.gms.internal.ads.zzcpx;
import com.google.android.gms.internal.ads.zzcpz;
import com.google.android.gms.internal.ads.zzdmd;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.bytebuddy.pool.TypePool;

public final class zzbse<T extends zzbes & zzcog & zzcop & zzbuk & zzcpm & zzcpq & zzcpu & zzdmd & zzcpx & zzcpz> implements zzbrt<T> {
    @Nullable
    private final zzb zza;
    @Nullable
    private final zzdyz zzb;
    @Nullable
    private final zzfio zzc;
    private final zzcje zzd;
    @Nullable
    private final zzcak zze;
    @Nullable
    private final zzehh zzf;
    private zzu zzg = null;

    public zzbse(zzb zzb2, zzcak zzcak, zzehh zzehh, zzdyz zzdyz, zzfio zzfio) {
        this.zza = zzb2;
        this.zze = zzcak;
        this.zzf = zzehh;
        this.zzb = zzdyz;
        this.zzc = zzfio;
        this.zzd = new zzcje((String) null);
    }

    public static int zzb(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        if (c.f41585a.equalsIgnoreCase(str)) {
            return zzt.zzq().zzg();
        }
        return -1;
    }

    @VisibleForTesting
    public static Uri zzc(Context context, zzalt zzalt, Uri uri, View view, @Nullable Activity activity) {
        if (zzalt == null) {
            return uri;
        }
        try {
            if (zzalt.zze(uri)) {
                return zzalt.zza(uri, context, view, activity);
            }
            return uri;
        } catch (zzalu unused) {
            return uri;
        } catch (Exception e11) {
            zzt.zzo().zzs(e11, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    @VisibleForTesting
    public static Uri zzd(Uri uri) {
        String str;
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e11) {
            String valueOf = String.valueOf(uri.toString());
            if (valueOf.length() != 0) {
                str = "Error adding click uptime parameter to url: ".concat(valueOf);
            } else {
                str = new String("Error adding click uptime parameter to url: ");
            }
            zzciz.zzh(str, e11);
        }
        return uri;
    }

    public static boolean zzf(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: android.net.Uri} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1, types: [android.content.Intent] */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: type inference failed for: r11v18 */
    /* JADX WARNING: type inference failed for: r11v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00df, code lost:
        if (r3 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzh(T r18, java.util.Map<java.lang.String, java.lang.String> r19, boolean r20, java.lang.String r21, boolean r22) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = 1
            r1.zzi(r3)
            r4 = r0
            com.google.android.gms.internal.ads.zzcop r4 = (com.google.android.gms.internal.ads.zzcop) r4
            android.content.Context r5 = r4.getContext()
            com.google.android.gms.internal.ads.zzalt r6 = r4.zzK()
            android.view.View r7 = r4.zzH()
            java.lang.String r8 = "activity"
            java.lang.Object r8 = r5.getSystemService(r8)
            android.app.ActivityManager r8 = (android.app.ActivityManager) r8
            java.lang.String r9 = "u"
            java.lang.Object r9 = r2.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            r11 = 0
            if (r10 == 0) goto L_0x0032
            goto L_0x0133
        L_0x0032:
            android.net.Uri r9 = android.net.Uri.parse(r9)
            android.net.Uri r9 = zzc(r5, r6, r9, r7, r11)
            android.net.Uri r9 = zzd(r9)
            java.lang.String r10 = "use_first_package"
            java.lang.Object r10 = r2.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            boolean r10 = java.lang.Boolean.parseBoolean(r10)
            java.lang.String r12 = "use_running_process"
            java.lang.Object r12 = r2.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            java.lang.String r13 = "use_custom_tabs"
            java.lang.Object r2 = r2.get(r13)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            if (r2 != 0) goto L_0x0078
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzblj.zzda
            com.google.android.gms.internal.ads.zzblh r14 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r2 = r14.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r3 = 0
        L_0x0078:
            java.lang.String r2 = r9.getScheme()
            java.lang.String r14 = "http"
            boolean r2 = r14.equalsIgnoreCase(r2)
            java.lang.String r15 = "https"
            if (r2 == 0) goto L_0x0093
            android.net.Uri$Builder r2 = r9.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r15)
            android.net.Uri r11 = r2.build()
            goto L_0x00a9
        L_0x0093:
            java.lang.String r2 = r9.getScheme()
            boolean r2 = r15.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00a9
            android.net.Uri$Builder r2 = r9.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r14)
            android.net.Uri r11 = r2.build()
        L_0x00a9:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.content.Intent r9 = com.google.android.gms.internal.ads.zzbsd.zza(r9, r5, r6, r7)
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbsd.zza(r11, r5, r6, r7)
            if (r3 == 0) goto L_0x00c4
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.util.zzt.zzu(r5, r9)
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.util.zzt.zzu(r5, r11)
        L_0x00c4:
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbsd.zzd(r9, r2, r5, r6, r7)
            if (r3 == 0) goto L_0x00cf
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbsd.zzb(r9, r3, r5, r6, r7)
            goto L_0x0133
        L_0x00cf:
            if (r11 == 0) goto L_0x00e1
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbsd.zzc(r11, r5, r6, r7)
            if (r3 == 0) goto L_0x00e1
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbsd.zzb(r9, r3, r5, r6, r7)
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbsd.zzc(r11, r5, r6, r7)
            if (r3 != 0) goto L_0x0133
        L_0x00e1:
            int r3 = r2.size()
            if (r3 != 0) goto L_0x00e8
            goto L_0x0132
        L_0x00e8:
            if (r12 == 0) goto L_0x0124
            if (r8 == 0) goto L_0x0124
            java.util.List r3 = r8.getRunningAppProcesses()
            if (r3 == 0) goto L_0x0124
            int r8 = r2.size()
            r11 = 0
        L_0x00f7:
            if (r11 >= r8) goto L_0x0124
            java.lang.Object r12 = r2.get(r11)
            android.content.pm.ResolveInfo r12 = (android.content.pm.ResolveInfo) r12
            java.util.Iterator r14 = r3.iterator()
        L_0x0103:
            int r15 = r11 + 1
            boolean r16 = r14.hasNext()
            if (r16 == 0) goto L_0x0122
            java.lang.Object r15 = r14.next()
            android.app.ActivityManager$RunningAppProcessInfo r15 = (android.app.ActivityManager.RunningAppProcessInfo) r15
            java.lang.String r15 = r15.processName
            android.content.pm.ActivityInfo r13 = r12.activityInfo
            java.lang.String r13 = r13.packageName
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x0103
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbsd.zzb(r9, r12, r5, r6, r7)
            goto L_0x0133
        L_0x0122:
            r11 = r15
            goto L_0x00f7
        L_0x0124:
            if (r10 == 0) goto L_0x0132
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbsd.zzb(r9, r2, r5, r6, r7)
            goto L_0x0133
        L_0x0132:
            r11 = r9
        L_0x0133:
            if (r20 == 0) goto L_0x0151
            com.google.android.gms.internal.ads.zzehh r2 = r1.zzf
            if (r2 == 0) goto L_0x0151
            if (r11 == 0) goto L_0x0151
            android.content.Context r2 = r4.getContext()
            android.net.Uri r3 = r11.getData()
            java.lang.String r3 = r3.toString()
            r4 = r21
            boolean r2 = r1.zzj(r0, r2, r3, r4)
            if (r2 != 0) goto L_0x0150
            goto L_0x0151
        L_0x0150:
            return
        L_0x0151:
            com.google.android.gms.internal.ads.zzcpu r0 = (com.google.android.gms.internal.ads.zzcpu) r0     // Catch:{ ActivityNotFoundException -> 0x0160 }
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc     // Catch:{ ActivityNotFoundException -> 0x0160 }
            com.google.android.gms.ads.internal.overlay.zzu r3 = r1.zzg     // Catch:{ ActivityNotFoundException -> 0x0160 }
            r2.<init>(r11, r3)     // Catch:{ ActivityNotFoundException -> 0x0160 }
            r3 = r22
            r0.zzaF(r2, r3)     // Catch:{ ActivityNotFoundException -> 0x0160 }
            return
        L_0x0160:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.google.android.gms.internal.ads.zzciz.zzj(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbse.zzh(com.google.android.gms.internal.ads.zzbes, java.util.Map, boolean, java.lang.String, boolean):void");
    }

    private final void zzi(boolean z11) {
        zzcak zzcak = this.zze;
        if (zzcak != null) {
            zzcak.zza(z11);
        }
    }

    private final boolean zzj(T t11, Context context, String str, String str2) {
        boolean z11;
        String str3 = str2;
        zzt.zzp();
        boolean zzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(context);
        zzt.zzp();
        zzbv zzE = com.google.android.gms.ads.internal.util.zzt.zzE(context);
        zzdyz zzdyz = this.zzb;
        if (zzdyz != null) {
            zzehp.zzc(context, zzdyz, this.zzc, this.zzf, str2, "offline_open");
        }
        zzcop zzcop = (zzcop) t11;
        if (!zzcop.zzQ().zzi() || zzcop.zzk() != null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (zzJ) {
            this.zzf.zzh(this.zzd, str3);
            return false;
        }
        zzt.zzp();
        if (NotificationManagerCompat.from(context).areNotificationsEnabled() && zzE != null && !z11) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgi)).booleanValue()) {
                if (zzcop.zzQ().zzi()) {
                    zzehp.zzh(zzcop.zzk(), (zzl) null, zzE, this.zzf, this.zzb, this.zzc, str2, str);
                } else {
                    ((zzcpu) t11).zzaG(zzE, this.zzf, this.zzb, this.zzc, str2, str, zzt.zzq().zzg());
                }
                zzdyz zzdyz2 = this.zzb;
                if (zzdyz2 != null) {
                    zzehp.zzc(context, zzdyz2, this.zzc, this.zzf, str2, "dialog_impression");
                }
                t11.onAdClicked();
                return true;
            }
        }
        this.zzf.zzc(str3);
        if (this.zzb != null) {
            HashMap hashMap = new HashMap();
            zzt.zzp();
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                hashMap.put("dialog_not_shown_reason", "notifications_disabled");
            } else if (zzE == null) {
                hashMap.put("dialog_not_shown_reason", "work_manager_unavailable");
            } else {
                if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzgi)).booleanValue()) {
                    hashMap.put("dialog_not_shown_reason", "notification_flow_disabled");
                } else if (z11) {
                    hashMap.put("dialog_not_shown_reason", "fullscreen_no_activity");
                }
            }
            zzehp.zzd(context, this.zzb, this.zzc, this.zzf, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void zzk(int i11) {
        if (this.zzb != null) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgq)).booleanValue()) {
                zzfio zzfio = this.zzc;
                zzfin zzb2 = zzfin.zzb("cct_action");
                zzb2.zza("cct_open_status", zzbmg.zza(i11));
                zzfio.zzb(zzb2);
                return;
            }
            zzdyy zza2 = this.zzb.zza();
            zza2.zzb(NativeProtocol.WEB_DIALOG_ACTION, "cct_action");
            zza2.zzb("cct_open_status", zzbmg.zza(i11));
            zza2.zzf();
        }
    }

    /* renamed from: zze */
    public final void zza(T t11, Map<String, String> map) {
        String str;
        boolean z11;
        boolean z12;
        boolean z13;
        Object obj;
        HashMap hashMap;
        String str2;
        T t12 = t11;
        Map<String, String> map2 = map;
        zzcop zzcop = (zzcop) t12;
        String zzc2 = zzchj.zzc(map2.get("u"), zzcop.getContext(), true);
        String str3 = map2.get("a");
        if (str3 == null) {
            zzciz.zzj("Action missing from an open GMSG.");
            return;
        }
        zzb zzb2 = this.zza;
        if (zzb2 == null || zzb2.zzc()) {
            zzfdn zzF = zzcop.zzF();
            zzfdq zzR = zzcop.zzR();
            boolean z14 = false;
            if (zzF == null || zzR == null) {
                str = "";
                z11 = false;
            } else {
                z11 = zzF.zzag;
                str = zzR.zzb;
            }
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzhk)).booleanValue() || !map2.containsKey("sc") || !map2.get("sc").equals("0")) {
                z12 = true;
            } else {
                z12 = false;
            }
            if ("expand".equalsIgnoreCase(str3)) {
                if (zzcop.zzaC()) {
                    zzciz.zzj("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzi(false);
                ((zzcpu) t12).zzaH(zzf(map), zzb(map), z12);
            } else if ("webapp".equalsIgnoreCase(str3)) {
                zzi(false);
                if (zzc2 != null) {
                    ((zzcpu) t12).zzaI(zzf(map), zzb(map), zzc2, z12);
                } else {
                    ((zzcpu) t12).zzaJ(zzf(map), zzb(map), map2.get("html"), map2.get("baseurl"), z12);
                }
            } else if ("chrome_custom_tab".equalsIgnoreCase(str3)) {
                Context context = zzcop.getContext();
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdc)).booleanValue()) {
                    if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdi)).booleanValue()) {
                        zze.zza("User opt out chrome custom tab.");
                    } else {
                        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzdg)).booleanValue()) {
                            z14 = true;
                        } else {
                            String str4 = (String) zzbgq.zzc().zzb(zzblj.zzdh);
                            if (!str4.isEmpty() && context != null) {
                                String packageName = context.getPackageName();
                                Iterator<String> it = zzfqp.zzc(zzfps.zzb(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER)).zzd(str4).iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (it.next().equals(packageName)) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                z14 = true;
                            }
                        }
                    }
                }
                boolean zzg2 = zzbmh.zzg(zzcop.getContext());
                if (z14) {
                    if (!zzg2) {
                        zzk(4);
                    } else {
                        zzi(true);
                        if (TextUtils.isEmpty(zzc2)) {
                            zzciz.zzj("Cannot open browser with null or empty url");
                            zzk(7);
                            return;
                        }
                        Uri zzd2 = zzd(zzc(zzcop.getContext(), zzcop.zzK(), Uri.parse(zzc2), zzcop.zzH(), zzcop.zzk()));
                        if (!z11 || this.zzf == null || !zzj(t12, zzcop.getContext(), zzd2.toString(), str)) {
                            this.zzg = new zzbsb(this);
                            ((zzcpu) t12).zzaF(new zzc((String) null, zzd2.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (Intent) null, ObjectWrapper.wrap(this.zzg).asBinder(), true), z12);
                            return;
                        }
                        return;
                    }
                }
                map2.put("use_first_package", "true");
                map2.put("use_running_process", "true");
                zzh(t11, map, z11, str, z12);
            } else if ("app".equalsIgnoreCase(str3) && "true".equalsIgnoreCase(map2.get("system_browser"))) {
                zzh(t11, map, z11, str, z12);
            } else if ("open_app".equalsIgnoreCase(str3)) {
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfZ)).booleanValue()) {
                    zzi(true);
                    String str5 = map2.get("p");
                    if (str5 == null) {
                        zzciz.zzj("Package name missing from open app action.");
                    } else if (!z11 || this.zzf == null || !zzj(t12, zzcop.getContext(), str5, str)) {
                        PackageManager packageManager = zzcop.getContext().getPackageManager();
                        if (packageManager == null) {
                            zzciz.zzj("Cannot get package manager from open app action.");
                            return;
                        }
                        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str5);
                        if (launchIntentForPackage != null) {
                            ((zzcpu) t12).zzaF(new zzc(launchIntentForPackage, this.zzg), z12);
                        }
                    }
                }
            } else {
                zzi(true);
                String str6 = map2.get("intent_url");
                Intent intent = null;
                if (!TextUtils.isEmpty(str6)) {
                    try {
                        intent = Intent.parseUri(str6, 0);
                    } catch (URISyntaxException e11) {
                        URISyntaxException uRISyntaxException = e11;
                        String valueOf = String.valueOf(str6);
                        if (valueOf.length() != 0) {
                            str2 = "Error parsing the url: ".concat(valueOf);
                        } else {
                            str2 = new String("Error parsing the url: ");
                        }
                        zzciz.zzh(str2, uRISyntaxException);
                    }
                }
                Intent intent2 = intent;
                if (!(intent2 == null || intent2.getData() == null)) {
                    Uri data = intent2.getData();
                    if (!Uri.EMPTY.equals(data)) {
                        Uri zzd3 = zzd(zzc(zzcop.getContext(), zzcop.zzK(), data, zzcop.zzH(), zzcop.zzk()));
                        if (!TextUtils.isEmpty(intent2.getType())) {
                            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzga)).booleanValue()) {
                                intent2.setDataAndType(zzd3, intent2.getType());
                            }
                        }
                        intent2.setData(zzd3);
                    }
                }
                if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzgm)).booleanValue() || !"intent_async".equalsIgnoreCase(str3) || !map2.containsKey("event_id")) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                HashMap hashMap2 = new HashMap();
                if (z13) {
                    hashMap = hashMap2;
                    obj = "p";
                    zzbsc zzbsc = r1;
                    zzbsc zzbsc2 = new zzbsc(this, z12, t11, hashMap2, map);
                    this.zzg = zzbsc;
                    z12 = false;
                } else {
                    hashMap = hashMap2;
                    obj = "p";
                }
                if (intent2 == null) {
                    HashMap hashMap3 = hashMap;
                    if (!TextUtils.isEmpty(zzc2)) {
                        zzc2 = zzd(zzc(zzcop.getContext(), zzcop.zzK(), Uri.parse(zzc2), zzcop.zzH(), zzcop.zzk())).toString();
                    }
                    if (!z11 || this.zzf == null || !zzj(t12, zzcop.getContext(), zzc2, str)) {
                        ((zzcpu) t12).zzaF(new zzc(map2.get("i"), zzc2, map2.get("m"), map2.get(obj), map2.get(c.f41585a), map2.get("f"), map2.get("e"), this.zzg), z12);
                    } else if (z13) {
                        hashMap3.put(map2.get("event_id"), Boolean.TRUE);
                        ((zzbuk) t12).zzd("openIntentAsync", hashMap3);
                    }
                } else if (!z11 || this.zzf == null || !zzj(t12, zzcop.getContext(), intent2.getData().toString(), str)) {
                    ((zzcpu) t12).zzaF(new zzc(intent2, this.zzg), z12);
                } else if (z13) {
                    HashMap hashMap4 = hashMap;
                    hashMap4.put(map2.get("event_id"), Boolean.TRUE);
                    ((zzbuk) t12).zzd("openIntentAsync", hashMap4);
                }
            }
        } else {
            this.zza.zzb(zzc2);
        }
    }
}
