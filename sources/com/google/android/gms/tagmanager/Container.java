package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzi;
import com.google.android.gms.internal.gtm.zzj;
import com.google.android.gms.internal.gtm.zzk;
import com.google.android.gms.internal.gtm.zzor;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzoz;
import com.google.android.gms.tagmanager.zzeh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
public class Container {
    private final String zzaec;
    private final DataLayer zzaed;
    private zzfb zzaee;
    private Map<String, FunctionCallMacroCallback> zzaef = new HashMap();
    private Map<String, FunctionCallTagCallback> zzaeg = new HashMap();
    private volatile long zzaeh;
    private volatile String zzaei = "";
    private final Context zzrm;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    public class zza implements zzan {
        private zza() {
        }

        public final Object zza(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzal = Container.this.zzal(str);
            if (zzal == null) {
                return null;
            }
            return zzal.getValue(str, map);
        }
    }

    public class zzb implements zzan {
        private zzb() {
        }

        public final Object zza(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzam = Container.this.zzam(str);
            if (zzam != null) {
                zzam.execute(str, map);
            }
            return zzgj.zzkb();
        }
    }

    public Container(Context context, DataLayer dataLayer, String str, long j11, zzov zzov) {
        this.zzrm = context;
        this.zzaed = dataLayer;
        this.zzaec = str;
        this.zzaeh = 0;
        zza(zzov);
    }

    private final void zza(zzov zzov) {
        this.zzaei = zzov.getVersion();
        zzeh.zziy().zziz().equals(zzeh.zza.CONTAINER_DEBUG);
        zzov zzov2 = zzov;
        zza(new zzfb(this.zzrm, zzov2, this.zzaed, new zza(), new zzb(), new zzdq()));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzaed.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzaec));
        }
    }

    private final synchronized zzfb zzhb() {
        return this.zzaee;
    }

    public boolean getBoolean(String str) {
        zzfb zzhb = zzhb();
        if (zzhb == null) {
            zzdi.zzav("getBoolean called for closed container.");
            return zzgj.zzjz().booleanValue();
        }
        try {
            return zzgj.zzg(zzhb.zzbj(str).getObject()).booleanValue();
        } catch (Exception e11) {
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 66);
            sb2.append("Calling getBoolean() threw an exception: ");
            sb2.append(message);
            sb2.append(" Returning default value.");
            zzdi.zzav(sb2.toString());
            return zzgj.zzjz().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzaec;
    }

    public double getDouble(String str) {
        zzfb zzhb = zzhb();
        if (zzhb == null) {
            zzdi.zzav("getDouble called for closed container.");
            return zzgj.zzjy().doubleValue();
        }
        try {
            return zzgj.zzf(zzhb.zzbj(str).getObject()).doubleValue();
        } catch (Exception e11) {
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 65);
            sb2.append("Calling getDouble() threw an exception: ");
            sb2.append(message);
            sb2.append(" Returning default value.");
            zzdi.zzav(sb2.toString());
            return zzgj.zzjy().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzaeh;
    }

    public long getLong(String str) {
        zzfb zzhb = zzhb();
        if (zzhb == null) {
            zzdi.zzav("getLong called for closed container.");
            return zzgj.zzjx().longValue();
        }
        try {
            return zzgj.zze(zzhb.zzbj(str).getObject()).longValue();
        } catch (Exception e11) {
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 63);
            sb2.append("Calling getLong() threw an exception: ");
            sb2.append(message);
            sb2.append(" Returning default value.");
            zzdi.zzav(sb2.toString());
            return zzgj.zzjx().longValue();
        }
    }

    public String getString(String str) {
        zzfb zzhb = zzhb();
        if (zzhb == null) {
            zzdi.zzav("getString called for closed container.");
            return zzgj.zzkb();
        }
        try {
            return zzgj.zzc(zzhb.zzbj(str).getObject());
        } catch (Exception e11) {
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 65);
            sb2.append("Calling getString() threw an exception: ");
            sb2.append(message);
            sb2.append(" Returning default value.");
            zzdi.zzav(sb2.toString());
            return zzgj.zzkb();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback != null) {
            synchronized (this.zzaef) {
                this.zzaef.put(str, functionCallMacroCallback);
            }
            return;
        }
        throw new NullPointerException("Macro handler must be non-null");
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback != null) {
            synchronized (this.zzaeg) {
                this.zzaeg.put(str, functionCallTagCallback);
            }
            return;
        }
        throw new NullPointerException("Tag callback must be non-null");
    }

    public final void release() {
        this.zzaee = null;
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zzaef) {
            this.zzaef.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzaeg) {
            this.zzaeg.remove(str);
        }
    }

    @VisibleForTesting
    public final FunctionCallMacroCallback zzal(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzaef) {
            functionCallMacroCallback = this.zzaef.get(str);
        }
        return functionCallMacroCallback;
    }

    @VisibleForTesting
    public final FunctionCallTagCallback zzam(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzaeg) {
            functionCallTagCallback = this.zzaeg.get(str);
        }
        return functionCallTagCallback;
    }

    @VisibleForTesting
    public final void zzan(String str) {
        zzhb().zzan(str);
    }

    @VisibleForTesting
    public final String zzha() {
        return this.zzaei;
    }

    public Container(Context context, DataLayer dataLayer, String str, long j11, zzk zzk) {
        this.zzrm = context;
        this.zzaed = dataLayer;
        this.zzaec = str;
        this.zzaeh = j11;
        zzi zzi = zzk.zzqk;
        zzi.getClass();
        try {
            zza(zzor.zza(zzi));
        } catch (zzoz e11) {
            String valueOf = String.valueOf(zzi);
            String obj = e11.toString();
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 46 + String.valueOf(obj).length());
            sb2.append("Not loading resource: ");
            sb2.append(valueOf);
            sb2.append(" because it is invalid: ");
            sb2.append(obj);
            zzdi.zzav(sb2.toString());
        }
        zzj[] zzjArr = zzk.zzqj;
        if (zzjArr != null) {
            ArrayList arrayList = new ArrayList();
            for (zzj add : zzjArr) {
                arrayList.add(add);
            }
            zzhb().zze(arrayList);
        }
    }

    private final synchronized void zza(zzfb zzfb) {
        this.zzaee = zzfb;
    }
}
