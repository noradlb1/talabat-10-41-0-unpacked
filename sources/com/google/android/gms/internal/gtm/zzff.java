package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.os.RemoteException;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomMasterTable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
public final class zzff {
    private final String zzaec;
    private int zzaka;
    private final zzcm zzamx;
    /* access modifiers changed from: private */
    public final zzcd zzanh;
    private final zznm zzaov;
    private final zzfl zzaow;
    private final zzok zzaox;
    private final zzok zzaoy;
    private final Set<String> zzaoz = new HashSet();
    private zzkz zzapa;
    /* access modifiers changed from: private */
    public zzee zzapb;
    private final zzfj zzapc;
    private final Context zzrm;

    @VisibleForTesting
    public zzff(Context context, String str, zznm zznm, zznu zznu, zzcm zzcm, zzcd zzcd) {
        zzfl zzfl = new zzfl();
        this.zzaow = zzfl;
        zzok zzok = new zzok(new HashMap(50));
        this.zzaox = zzok;
        zzok zzok2 = new zzok(new HashMap(10));
        this.zzaoy = zzok2;
        zzfg zzfg = new zzfg(this);
        this.zzapc = zzfg;
        Preconditions.checkNotNull(zznm, "Internal Error: Container resource cannot be null");
        Preconditions.checkNotNull(zznu, "Internal Error: Runtime resource cannot be null");
        Preconditions.checkNotEmpty(str, "Internal Error: ContainerId cannot be empty");
        Preconditions.checkNotNull(zzcm);
        Preconditions.checkNotNull(zzcd);
        this.zzrm = context;
        this.zzaec = str;
        this.zzaov = zznm;
        this.zzamx = zzcm;
        this.zzanh = zzcd;
        zzfl.zza("1", new zzof(new zzhy()));
        zzfl.zza("12", new zzof(new zzhz()));
        zzfl.zza("18", new zzof(new zzia()));
        zzfl.zza("19", new zzof(new zzib()));
        zzfl.zza("20", new zzof(new zzic()));
        zzfl.zza("21", new zzof(new zzid()));
        zzfl.zza("23", new zzof(new zzie()));
        zzfl.zza("24", new zzof(new zzif()));
        zzfl.zza("27", new zzof(new zzig()));
        zzfl.zza("28", new zzof(new zzih()));
        zzfl.zza("29", new zzof(new zzii()));
        zzfl.zza("30", new zzof(new zzij()));
        zzfl.zza("32", new zzof(new zzik()));
        zzfl.zza("33", new zzof(new zzik()));
        zzfl.zza("34", new zzof(new zzil()));
        zzfl.zza("35", new zzof(new zzil()));
        zzfl.zza("39", new zzof(new zzim()));
        zzfl.zza("40", new zzof(new zzin()));
        zzfl.zza("0", new zzof(new zzjk()));
        zzfl.zza("10", new zzof(new zzjl()));
        zzfl.zza("25", new zzof(new zzjm()));
        zzfl.zza("26", new zzof(new zzjn()));
        zzfl.zza("37", new zzof(new zzjo()));
        zzfl.zza(ExifInterface.GPS_MEASUREMENT_2D, new zzof(new zzio()));
        zzfl.zza(ExifInterface.GPS_MEASUREMENT_3D, new zzof(new zzip()));
        zzfl.zza(OnlineLocationService.SRC_DEFAULT, new zzof(new zziq()));
        zzfl.zza("5", new zzof(new zzir()));
        zzfl.zza("6", new zzof(new zzis()));
        zzfl.zza("7", new zzof(new zzit()));
        zzfl.zza("8", new zzof(new zziu()));
        zzfl.zza("9", new zzof(new zzir()));
        zzfl.zza("13", new zzof(new zziv()));
        zzfl.zza("47", new zzof(new zziw()));
        zzfl.zza("15", new zzof(new zzix()));
        zzfl.zza("48", new zzof(new zziy(this)));
        zziz zziz = new zziz();
        zzfl.zza("16", new zzof(zziz));
        zzfl.zza("17", new zzof(zziz));
        zzfl.zza("22", new zzof(new zzjb()));
        zzfl.zza("45", new zzof(new zzjc()));
        zzfl.zza("46", new zzof(new zzjd()));
        zzfl.zza("36", new zzof(new zzje()));
        zzfl.zza("43", new zzof(new zzjf()));
        zzfl.zza("38", new zzof(new zzjg()));
        zzfl.zza("44", new zzof(new zzjh()));
        zzfl.zza("41", new zzof(new zzji()));
        zzfl.zza(RoomMasterTable.DEFAULT_ID, new zzof(new zzjj()));
        zza(zza.CONTAINS, new zzlw());
        zza(zza.ENDS_WITH, new zzlx());
        zza(zza.EQUALS, new zzly());
        zza(zza.GREATER_EQUALS, new zzlz());
        zza(zza.GREATER_THAN, new zzma());
        zza(zza.LESS_EQUALS, new zzmb());
        zza(zza.LESS_THAN, new zzmc());
        zza(zza.REGEX, new zzme());
        zza(zza.STARTS_WITH, new zzmf());
        zzok.zzc("advertiserId", new zzof(new zzkp(context)));
        zzok.zzc("advertiserTrackingEnabled", new zzof(new zzkq(context)));
        zzok.zzc("adwordsClickReferrer", new zzof(new zzkr(context, zzfg)));
        zzok.zzc("applicationId", new zzof(new zzks(context)));
        zzok.zzc("applicationName", new zzof(new zzkt(context)));
        zzok.zzc("applicationVersion", new zzof(new zzku(context)));
        zzok.zzc("applicationVersionName", new zzof(new zzkv(context)));
        zzok.zzc("arbitraryPixieMacro", new zzof(new zzkm(1, zzfl)));
        zzok.zzc("carrier", new zzof(new zzkw(context)));
        zzok.zzc("constant", new zzof(new zzje()));
        zzok.zzc("containerId", new zzof(new zzkx(new zzom(str))));
        zzok.zzc("containerVersion", new zzof(new zzkx(new zzom(zznm.getVersion()))));
        zzok.zzc("customMacro", new zzof(new zzkk(new zzfi(this, (zzfg) null))));
        zzok.zzc("deviceBrand", new zzof(new zzla()));
        zzok.zzc("deviceId", new zzof(new zzlb(context)));
        zzok.zzc(AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE, new zzof(new zzlc()));
        zzok.zzc("deviceName", new zzof(new zzld()));
        zzok.zzc("encode", new zzof(new zzle()));
        zzok.zzc("encrypt", new zzof(new zzlf()));
        zzok.zzc("event", new zzof(new zzky()));
        zzok.zzc("eventParameters", new zzof(new zzlg(zzfg)));
        zzok.zzc("version", new zzof(new zzlh()));
        zzok.zzc("hashcode", new zzof(new zzli()));
        zzok.zzc("installReferrer", new zzof(new zzlj(context)));
        zzok.zzc("join", new zzof(new zzlk()));
        zzok.zzc(ConstantsKt.ADJUST_LANGUAGE, new zzof(new zzll()));
        zzok.zzc("locale", new zzof(new zzlm()));
        zzok.zzc("adWordsUniqueId", new zzof(new zzlo(context)));
        zzok.zzc(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, new zzof(new zzlp()));
        zzok.zzc("platform", new zzof(new zzlq()));
        zzok.zzc("random", new zzof(new zzlr()));
        zzok.zzc("regexGroup", new zzof(new zzls()));
        zzok.zzc("resolution", new zzof(new zzlu(context)));
        zzok.zzc("runtimeVersion", new zzof(new zzlt()));
        zzok.zzc(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, new zzof(new zzlv()));
        this.zzapa = new zzkz();
        zzok.zzc("currentTime", new zzof(this.zzapa));
        zzok.zzc("userProperty", new zzof(new zzln(context, zzfg)));
        zzok.zzc("arbitraryPixel", new zzof(new zzmi(zzec.zzp(context))));
        zzok.zzc("customTag", new zzof(new zzkk(new zzfh(this, (zzfg) null))));
        zzok.zzc("universalAnalytics", new zzof(new zzmj(context, (zzfj) zzfg)));
        zzok.zzc("queueRequest", new zzof(new zzmg(zzec.zzp(context))));
        zzok.zzc("sendMeasurement", new zzof(new zzmh(zzcm, zzfg)));
        zzok.zzc("arbitraryPixieTag", new zzof(new zzkm(0, zzfl)));
        zzok.zzc("suppressPassthrough", new zzof(new zzko(context, zzfg)));
        zzok2.zzc("decodeURI", new zzof(new zzkf()));
        zzok2.zzc("decodeURIComponent", new zzof(new zzkg()));
        zzok2.zzc("encodeURI", new zzof(new zzkh()));
        zzok2.zzc("encodeURIComponent", new zzof(new zzki()));
        zzok2.zzc(LogWriteConstants.LOG_TYPE, new zzof(new zzkn()));
        zzok2.zzc("isArray", new zzof(new zzkj()));
        for (zzgy next : zznu.zzmb()) {
            next.zza(this.zzaow);
            this.zzaow.zza(next.getName(), new zzof(next));
        }
        zzok zzok3 = new zzok(new HashMap(1));
        zzok3.zzc("mobile", this.zzaox);
        zzok3.zzc("common", this.zzaoy);
        this.zzaow.zza("gtmUtils", zzok3);
        zzok zzok4 = new zzok(new HashMap((Map) this.zzaox.value()));
        zzok4.zzmi();
        zzok zzok5 = new zzok(new HashMap((Map) this.zzaoy.value()));
        zzok5.zzmi();
        if (this.zzaow.has("main") && (this.zzaow.zzca("main") instanceof zzof)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzok3);
            zzoo.zza(this.zzaow, new zzol("main", arrayList));
        }
        this.zzaox.zzc(TtmlNode.RUBY_BASE, zzok4);
        this.zzaoy.zzc(TtmlNode.RUBY_BASE, zzok5);
        zzok3.zzmi();
        this.zzaox.zzmi();
        this.zzaoy.zzmi();
    }

    private final void zza(zza zza, zzgz zzgz) {
        this.zzaox.zzc(zzgw.zza(zza), new zzof(zzgz));
    }

    private final zzoa<?> zzby(String str) {
        this.zzaka++;
        String zzjg = zzjg();
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzjg).length() + 31 + String.valueOf(str).length());
        sb2.append(zzjg);
        sb2.append("Beginning to evaluate variable ");
        sb2.append(str);
        zzev.zzab(sb2.toString());
        if (!this.zzaoz.contains(str)) {
            this.zzaoz.add(str);
            zzno zzck = this.zzaov.zzck(str);
            if (zzck != null) {
                zzoa<?> zzi = zzi(zzh(zzck.zzlu()));
                String zzjg2 = zzjg();
                StringBuilder sb3 = new StringBuilder(String.valueOf(zzjg2).length() + 25 + String.valueOf(str).length());
                sb3.append(zzjg2);
                sb3.append("Done evaluating variable ");
                sb3.append(str);
                zzev.zzab(sb3.toString());
                this.zzaka--;
                this.zzaoz.remove(str);
                return zzi;
            }
            this.zzaka--;
            this.zzaoz.remove(str);
            String zzjg3 = zzjg();
            StringBuilder sb4 = new StringBuilder(String.valueOf(zzjg3).length() + 36 + String.valueOf(str).length());
            sb4.append(zzjg3);
            sb4.append("Attempting to resolve unknown macro ");
            sb4.append(str);
            throw new IllegalStateException(sb4.toString());
        }
        this.zzaka--;
        String obj = this.zzaoz.toString();
        StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 77 + String.valueOf(obj).length());
        sb5.append("Macro cycle detected.  Current macro reference: ");
        sb5.append(str);
        sb5.append(". Previous macro references: ");
        sb5.append(obj);
        throw new IllegalStateException(sb5.toString());
    }

    private static String zzbz(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e11) {
            zzev.zza("Escape URI: unsupported encoding", e11);
            return str;
        }
    }

    private final zzol zzd(String str, Map<String, zzoa<?>> map) {
        try {
            return zzgw.zza(str, map, this.zzaow);
        } catch (RuntimeException e11) {
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 30 + String.valueOf(message).length());
            sb2.append("Incorrect keys for function ");
            sb2.append(str);
            sb2.append(". ");
            sb2.append(message);
            zzev.zzav(sb2.toString());
            return null;
        }
    }

    private final Map<String, zzoa<?>> zzh(Map<String, zznx> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put((String) next.getKey(), zza((zznx) next.getValue()));
        }
        return hashMap;
    }

    private final zzoa zzi(Map<String, zzoa<?>> map) {
        zzol zzol;
        String str;
        boolean z11;
        if (map == null) {
            zzea.zza("executeFunctionCall: cannot access the function parameters.", this.zzrm);
            return zzog.zzaum;
        }
        zzoa zzoa = map.get(zzb.FUNCTION.toString());
        if (!(zzoa instanceof zzom)) {
            zzea.zza("No function id in properties", this.zzrm);
            return zzog.zzaum;
        }
        String str2 = (String) ((zzom) zzoa).value();
        if (this.zzaow.has(str2)) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).startsWith("vtp_")) {
                    hashMap.put(((String) next.getKey()).substring(4), (zzoa) next.getValue());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new zzok(hashMap));
            zzol = new zzol(str2, arrayList);
        } else {
            String zzcc = zzgw.zzcc(str2);
            if (zzcc == null || !this.zzaox.zzcn(zzcc)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                zzol = zzd(str2, map);
            } else {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 30);
                sb2.append("functionId '");
                sb2.append(str2);
                sb2.append("' is not supported");
                zzea.zza(sb2.toString(), this.zzrm);
                return zzog.zzaum;
            }
        }
        if (zzol == null) {
            zzea.zza("Internal error: failed to convert function to a valid statement", this.zzrm);
            return zzog.zzaum;
        }
        String valueOf = String.valueOf(zzol.zzmj());
        if (valueOf.length() != 0) {
            str = "Executing: ".concat(valueOf);
        } else {
            str = new String("Executing: ");
        }
        zzev.zzab(str);
        zzoa zza = zzoo.zza(this.zzaow, zzol);
        if (!(zza instanceof zzog)) {
            return zza;
        }
        zzog zzog = (zzog) zza;
        if (zzog.zzmh()) {
            return (zzoa) zzog.value();
        }
        return zza;
    }

    private final String zzjg() {
        if (this.zzaka <= 1) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Integer.toString(this.zzaka));
        for (int i11 = 2; i11 < this.zzaka; i11++) {
            sb2.append(' ');
        }
        sb2.append(": ");
        return sb2.toString();
    }

    public final void dispatch() {
        zzec.zzp(this.zzrm).dispatch();
    }

    public final void zzb(zzee zzee) {
        zzoa<?> zzod;
        this.zzaow.zza("gtm.globals.eventName", new zzom(zzee.zzkf()));
        this.zzapa.zza(zzee);
        this.zzapb = zzee;
        HashSet<zzno> hashSet = new HashSet<>();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap = new HashMap();
        for (zznr next : this.zzaov.zzls()) {
            if (!next.zzly().isEmpty() || !next.zzlz().isEmpty()) {
                String valueOf = String.valueOf(next);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
                sb2.append("Evaluating trigger ");
                sb2.append(valueOf);
                zzev.zzab(sb2.toString());
                Iterator<zzno> it = next.zzlx().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator<zzno> it2 = next.zzlw().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                zzod = new zzod(Boolean.TRUE);
                                break;
                            }
                            zzno next2 = it2.next();
                            zzoa<?> zzoa = (zzoa) hashMap.get(next2);
                            if (zzoa == null) {
                                zzoa = zza(next2);
                                hashMap.put(next2, zzoa);
                            }
                            zzod = zzog.zzaul;
                            if (zzoa != zzod) {
                                if (!((Boolean) ((zzod) zzoa).value()).booleanValue()) {
                                    zzod = new zzod(Boolean.FALSE);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    } else {
                        zzno next3 = it.next();
                        zzoa<?> zzoa2 = (zzoa) hashMap.get(next3);
                        if (zzoa2 == null) {
                            zzoa2 = zza(next3);
                            hashMap.put(next3, zzoa2);
                        }
                        zzod = zzog.zzaul;
                        if (zzoa2 != zzod) {
                            if (((Boolean) ((zzod) zzoa2).value()).booleanValue()) {
                                zzod = new zzod(Boolean.FALSE);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (zzod == zzog.zzaul) {
                    String valueOf2 = String.valueOf(next);
                    StringBuilder sb3 = new StringBuilder(valueOf2.length() + 41);
                    sb3.append("Error encounted while evaluating trigger ");
                    sb3.append(valueOf2);
                    zzea.zzb(sb3.toString(), this.zzrm);
                    if (!next.zzlz().isEmpty()) {
                        String valueOf3 = String.valueOf(next.zzlz());
                        StringBuilder sb4 = new StringBuilder(valueOf3.length() + 15);
                        sb4.append("Blocking tags: ");
                        sb4.append(valueOf3);
                        zzev.zzab(sb4.toString());
                        hashSet2.addAll(next.zzlz());
                    }
                } else if (((Boolean) ((zzod) zzod).value()).booleanValue()) {
                    String valueOf4 = String.valueOf(next);
                    StringBuilder sb5 = new StringBuilder(valueOf4.length() + 19);
                    sb5.append("Trigger is firing: ");
                    sb5.append(valueOf4);
                    zzev.zzab(sb5.toString());
                    if (!next.zzly().isEmpty()) {
                        String valueOf5 = String.valueOf(next.zzly());
                        StringBuilder sb6 = new StringBuilder(valueOf5.length() + 34);
                        sb6.append("Adding tags to firing candidates: ");
                        sb6.append(valueOf5);
                        zzev.zzab(sb6.toString());
                        hashSet.addAll(next.zzly());
                    }
                    if (!next.zzlz().isEmpty()) {
                        String valueOf6 = String.valueOf(next.zzlz());
                        StringBuilder sb7 = new StringBuilder(valueOf6.length() + 24);
                        sb7.append("Blocking disabled tags: ");
                        sb7.append(valueOf6);
                        zzev.zzab(sb7.toString());
                        hashSet2.addAll(next.zzlz());
                    }
                }
            } else {
                String valueOf7 = String.valueOf(next);
                StringBuilder sb8 = new StringBuilder(valueOf7.length() + 64);
                sb8.append("Trigger is not being evaluated since it has no associated tags: ");
                sb8.append(valueOf7);
                zzev.zzab(sb8.toString());
            }
        }
        hashSet.removeAll(hashSet2);
        boolean z11 = false;
        for (zzno zzno : hashSet) {
            this.zzaoz.clear();
            String valueOf8 = String.valueOf(zzno);
            StringBuilder sb9 = new StringBuilder(valueOf8.length() + 21);
            sb9.append("Executing firing tag ");
            sb9.append(valueOf8);
            zzev.zzab(sb9.toString());
            try {
                zzi(zzh(zzno.zzlu()));
                zznx zznx = zzno.zzlu().get(zzb.DISPATCH_ON_FIRE.toString());
                if (zznx != null && zznx.getType() == 8 && ((Boolean) zznx.getValue()).booleanValue()) {
                    try {
                        String valueOf9 = String.valueOf(zzno);
                        StringBuilder sb10 = new StringBuilder(valueOf9.length() + 36);
                        sb10.append("Tag configured to dispatch on fire: ");
                        sb10.append(valueOf9);
                        zzev.zzab(sb10.toString());
                        z11 = true;
                    } catch (IllegalStateException e11) {
                        e = e11;
                        z11 = true;
                        String valueOf10 = String.valueOf(zzno);
                        StringBuilder sb11 = new StringBuilder(valueOf10.length() + 19);
                        sb11.append("Error firing tag ");
                        sb11.append(valueOf10);
                        sb11.append(": ");
                        zzea.zza(sb11.toString(), e, this.zzrm);
                    }
                }
            } catch (IllegalStateException e12) {
                e = e12;
                String valueOf102 = String.valueOf(zzno);
                StringBuilder sb112 = new StringBuilder(valueOf102.length() + 19);
                sb112.append("Error firing tag ");
                sb112.append(valueOf102);
                sb112.append(": ");
                zzea.zza(sb112.toString(), e, this.zzrm);
            }
        }
        this.zzaow.remove("gtm.globals.eventName");
        if (zzee.zzki()) {
            String zzkf = zzee.zzkf();
            StringBuilder sb12 = new StringBuilder(String.valueOf(zzkf).length() + 35);
            sb12.append("Log passthrough event ");
            sb12.append(zzkf);
            sb12.append(" to Firebase.");
            zzev.zzab(sb12.toString());
            try {
                this.zzamx.logEventInternalNoInterceptor(zzee.zzkh(), zzee.zzkf(), zzee.zzkg(), zzee.currentTimeMillis());
            } catch (RemoteException e13) {
                zzea.zza("Error calling measurement proxy: ", e13, this.zzrm);
            }
        } else {
            String zzkf2 = zzee.zzkf();
            StringBuilder sb13 = new StringBuilder(String.valueOf(zzkf2).length() + 63);
            sb13.append("Non-passthrough event ");
            sb13.append(zzkf2);
            sb13.append(" doesn't get logged to Firebase directly.");
            zzev.zzab(sb13.toString());
        }
        if (z11) {
            zzev.zzab("Dispatch called for dispatchOnFire tags.");
            dispatch();
        }
    }

    public final zzoa<?> zzbx(String str) {
        if (!this.zzaoz.contains(str)) {
            this.zzaka = 0;
            return zzby(str);
        }
        String obj = this.zzaoz.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 77 + String.valueOf(obj).length());
        sb2.append("Macro cycle detected.  Current macro reference: ");
        sb2.append(str);
        sb2.append(". Previous macro references: ");
        sb2.append(obj);
        throw new IllegalStateException(sb2.toString());
    }

    private final zzoa<?> zza(zznx zznx) {
        switch (zznx.getType()) {
            case 1:
                try {
                    return new zzoe(Double.valueOf(Double.parseDouble((String) zznx.getValue())));
                } catch (NumberFormatException unused) {
                    return new zzom((String) zznx.getValue());
                }
            case 2:
                List<zznx> list = (List) zznx.getValue();
                ArrayList arrayList = new ArrayList(list.size());
                for (zznx zza : list) {
                    arrayList.add(zza(zza));
                }
                return new zzoh(arrayList);
            case 3:
                Map map = (Map) zznx.getValue();
                HashMap hashMap = new HashMap(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    zzoa<?> zza2 = zza((zznx) entry.getKey());
                    hashMap.put(zzha.zzd(zza2), zza((zznx) entry.getValue()));
                }
                return new zzok(hashMap);
            case 4:
                zzoa<?> zzby = zzby((String) zznx.getValue());
                if (!(zzby instanceof zzom) || zznx.zzmd().isEmpty()) {
                    return zzby;
                }
                String str = (String) ((zzom) zzby).value();
                for (Integer intValue : zznx.zzmd()) {
                    int intValue2 = intValue.intValue();
                    if (intValue2 != 12) {
                        StringBuilder sb2 = new StringBuilder(39);
                        sb2.append("Unsupported Value Escaping: ");
                        sb2.append(intValue2);
                        zzev.zzav(sb2.toString());
                    } else {
                        str = zzbz(str);
                    }
                }
                return new zzom(str);
            case 5:
                return new zzom((String) zznx.getValue());
            case 6:
                return new zzoe(Double.valueOf(((Integer) zznx.getValue()).doubleValue()));
            case 7:
                StringBuilder sb3 = new StringBuilder();
                for (zznx zza3 : (List) zznx.getValue()) {
                    sb3.append(zzha.zzd(zza(zza3)));
                }
                return new zzom(sb3.toString());
            case 8:
                return new zzod((Boolean) zznx.getValue());
            default:
                int type = zznx.getType();
                StringBuilder sb4 = new StringBuilder(52);
                sb4.append("Attempting to expand unknown Value type ");
                sb4.append(type);
                sb4.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                throw new IllegalStateException(sb4.toString());
        }
    }

    @VisibleForTesting
    private final zzoa<?> zza(zzno zzno) {
        this.zzaoz.clear();
        try {
            zzoa<?> zzi = zzi(zzh(zzno.zzlu()));
            if (zzi instanceof zzod) {
                return zzi;
            }
            zzea.zza("Predicate must return a boolean value", this.zzrm);
            return new zzod(Boolean.FALSE);
        } catch (IllegalStateException unused) {
            zzev.zzav("Error evaluating predicate.");
            return zzog.zzaul;
        }
    }
}
