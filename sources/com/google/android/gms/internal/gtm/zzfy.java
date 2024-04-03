package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcg;
import com.google.android.gms.tagmanager.zzcj;
import com.google.android.gms.tagmanager.zzcm;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzfy {
    private static final Pattern zzapq = Pattern.compile("(gtm-[a-z0-9]{1,10})\\.json", 2);
    private static volatile zzfy zzapr;
    private static zzc zzaqa = new zzfz();
    private String zzaec;
    /* access modifiers changed from: private */
    public final ExecutorService zzamv;
    private final ScheduledExecutorService zzamw;
    /* access modifiers changed from: private */
    public final zzcm zzamx;
    private final zzcd zzanh;
    /* access modifiers changed from: private */
    public final zzgt zzaps;
    /* access modifiers changed from: private */
    public final zzfd zzapt;
    private final zza zzapu;
    /* access modifiers changed from: private */
    public final Object zzapv = new Object();
    private String zzapw;
    /* access modifiers changed from: private */
    public int zzapx = 1;
    /* access modifiers changed from: private */
    public final Queue<Runnable> zzapy = new LinkedList();
    private volatile boolean zzapz = false;
    /* access modifiers changed from: private */
    public final Context zzrm;
    /* access modifiers changed from: private */
    public volatile boolean zzrq = false;

    @VisibleForTesting
    public static class zza {
        private final Context zzrm;

        public zza(Context context) {
            this.zzrm = context;
        }

        public final String[] zzcb(String str) throws IOException {
            return this.zzrm.getAssets().list(str);
        }

        public final String[] zzkx() throws IOException {
            return this.zzrm.getAssets().list("");
        }
    }

    public class zzb extends zzep {
        private zzb() {
        }

        public final void zza(boolean z11, String str) throws RemoteException {
            zzfy.this.zzamv.execute(new zzgk(this, z11, str));
        }

        public /* synthetic */ zzb(zzfy zzfy, zzfz zzfz) {
            this();
        }
    }

    @VisibleForTesting
    public interface zzc {
        zzfy zzb(Context context, zzcm zzcm, zzcd zzcd);
    }

    @VisibleForTesting
    public zzfy(Context context, zzcm zzcm, zzcd zzcd, zzgt zzgt, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, zzfd zzfd, zza zza2) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(zzcm);
        this.zzrm = context;
        this.zzamx = zzcm;
        this.zzanh = zzcd;
        this.zzaps = zzgt;
        this.zzamv = executorService;
        this.zzamw = scheduledExecutorService;
        this.zzapt = zzfd;
        this.zzapu = zza2;
    }

    public static zzfy zza(Context context, zzcm zzcm, zzcd zzcd) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context);
        zzfy zzfy = zzapr;
        if (zzfy == null) {
            synchronized (zzfy.class) {
                zzfy = zzapr;
                if (zzfy == null) {
                    zzfy zzb2 = zzaqa.zzb(context, zzcm, zzcd);
                    zzapr = zzb2;
                    zzfy = zzb2;
                }
            }
        }
        return zzfy;
    }

    /* access modifiers changed from: private */
    public final Pair<String, String> zzc(String[] strArr) {
        String str;
        zzev.zzab("Looking up container asset.");
        String str2 = this.zzaec;
        if (str2 != null && (str = this.zzapw) != null) {
            return Pair.create(str2, str);
        }
        try {
            String[] zzcb = this.zzapu.zzcb("containers");
            boolean z11 = false;
            for (int i11 = 0; i11 < zzcb.length; i11++) {
                Pattern pattern = zzapq;
                Matcher matcher = pattern.matcher(zzcb[i11]);
                if (!matcher.matches()) {
                    zzev.zzac(String.format("Ignoring container asset %s (does not match %s)", new Object[]{zzcb[i11], pattern.pattern()}));
                } else if (!z11) {
                    this.zzaec = matcher.group(1);
                    String str3 = File.separator;
                    String str4 = zzcb[i11];
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 10 + String.valueOf(str4).length());
                    sb2.append("containers");
                    sb2.append(str3);
                    sb2.append(str4);
                    this.zzapw = sb2.toString();
                    String valueOf = String.valueOf(this.zzaec);
                    zzev.zzab(valueOf.length() != 0 ? "Asset found for container ".concat(valueOf) : new String("Asset found for container "));
                    z11 = true;
                } else {
                    String valueOf2 = String.valueOf(zzcb[i11]);
                    zzev.zzac(valueOf2.length() != 0 ? "Extra container asset found, will not be loaded: ".concat(valueOf2) : new String("Extra container asset found, will not be loaded: "));
                }
            }
            if (!z11) {
                zzev.zzac("No container asset found in /assets/containers. Checking top level /assets directory for container assets.");
                try {
                    String[] zzkx = this.zzapu.zzkx();
                    for (int i12 = 0; i12 < zzkx.length; i12++) {
                        Matcher matcher2 = zzapq.matcher(zzkx[i12]);
                        if (matcher2.matches()) {
                            if (!z11) {
                                String group = matcher2.group(1);
                                this.zzaec = group;
                                this.zzapw = zzkx[i12];
                                String valueOf3 = String.valueOf(group);
                                zzev.zzab(valueOf3.length() != 0 ? "Asset found for container ".concat(valueOf3) : new String("Asset found for container "));
                                zzev.zzac("Loading container assets from top level /assets directory. Please move the container asset to /assets/containers");
                                z11 = true;
                            } else {
                                String valueOf4 = String.valueOf(zzkx[i12]);
                                zzev.zzac(valueOf4.length() != 0 ? "Extra container asset found, will not be loaded: ".concat(valueOf4) : new String("Extra container asset found, will not be loaded: "));
                            }
                        }
                    }
                } catch (IOException e11) {
                    zzev.zza("Failed to enumerate assets.", e11);
                    return Pair.create((Object) null, (Object) null);
                }
            }
            return Pair.create(this.zzaec, this.zzapw);
        } catch (IOException e12) {
            zzev.zza(String.format("Failed to enumerate assets in folder %s", new Object[]{"containers"}), e12);
            return Pair.create((Object) null, (Object) null);
        }
    }

    @WorkerThread
    public final void zzag() {
        String str;
        zzev.zzab("Initializing Tag Manager.");
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.zzapv) {
            if (!this.zzrq) {
                try {
                    if (!zzc(this.zzrm, "com.google.android.gms.tagmanager.TagManagerService")) {
                        zzev.zzac("Tag Manager fails to initialize (TagManagerService not enabled in the manifest)");
                        this.zzrq = true;
                        return;
                    }
                    Pair<String, String> zzc2 = zzc((String[]) null);
                    String str2 = (String) zzc2.first;
                    String str3 = (String) zzc2.second;
                    if (str2 == null || str3 == null) {
                        zzev.zzac("Tag Manager's event handler WILL NOT be installed (no container loaded)");
                    } else {
                        if (str2.length() != 0) {
                            str = "Loading container ".concat(str2);
                        } else {
                            str = new String("Loading container ");
                        }
                        zzev.zzaw(str);
                        this.zzamv.execute(new zzge(this, str2, str3, (String) null));
                        this.zzamw.schedule(new zzgf(this), 5000, TimeUnit.MILLISECONDS);
                        if (!this.zzapz) {
                            zzev.zzaw("Installing Tag Manager event handler.");
                            this.zzapz = true;
                            this.zzamx.zza((zzcj) new zzga(this));
                            try {
                                this.zzamx.zza((zzcg) new zzgc(this));
                            } catch (RemoteException e11) {
                                zzea.zza("Error communicating with measurement proxy: ", e11, this.zzrm);
                            }
                            this.zzrm.registerComponentCallbacks(new zzgh(this));
                            zzev.zzaw("Tag Manager event handler installed.");
                        }
                    }
                    this.zzrq = true;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    StringBuilder sb2 = new StringBuilder(53);
                    sb2.append("Tag Manager initilization took ");
                    sb2.append(currentTimeMillis2);
                    sb2.append("ms");
                    zzev.zzaw(sb2.toString());
                } catch (RemoteException e12) {
                    zzea.zza("Error communicating with measurement proxy: ", e12, this.zzrm);
                } catch (Throwable th2) {
                    this.zzrq = true;
                    throw th2;
                }
            }
        }
    }

    @WorkerThread
    @VisibleForTesting
    public final void zzb(String[] strArr) {
        zzev.zzab("Initializing Tag Manager.");
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.zzapv) {
            if (!this.zzrq) {
                try {
                    if (!zzc(this.zzrm, "com.google.android.gms.tagmanager.TagManagerService")) {
                        zzev.zzac("Tag Manager fails to initialize (TagManagerService not enabled in the manifest)");
                        this.zzrq = true;
                        return;
                    }
                    Pair<String, String> zzc2 = zzc((String[]) null);
                    String str = (String) zzc2.first;
                    String str2 = (String) zzc2.second;
                    if (str == null || str2 == null) {
                        zzev.zzac("Tag Manager's event handler WILL NOT be installed (no container loaded)");
                    } else {
                        zzev.zzaw(str.length() != 0 ? "Loading container ".concat(str) : new String("Loading container "));
                        this.zzamv.execute(new zzge(this, str, str2, (String) null));
                        this.zzamw.schedule(new zzgf(this), 5000, TimeUnit.MILLISECONDS);
                        if (!this.zzapz) {
                            zzev.zzaw("Installing Tag Manager event handler.");
                            this.zzapz = true;
                            this.zzamx.zza((zzcj) new zzga(this));
                            try {
                                this.zzamx.zza((zzcg) new zzgc(this));
                            } catch (RemoteException e11) {
                                zzea.zza("Error communicating with measurement proxy: ", e11, this.zzrm);
                            }
                            this.zzrm.registerComponentCallbacks(new zzgh(this));
                            zzev.zzaw("Tag Manager event handler installed.");
                        }
                    }
                    this.zzrq = true;
                    StringBuilder sb2 = new StringBuilder(53);
                    sb2.append("Tag Manager initilization took ");
                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                    sb2.append("ms");
                    zzev.zzaw(sb2.toString());
                } catch (RemoteException e12) {
                    zzea.zza("Error communicating with measurement proxy: ", e12, this.zzrm);
                } catch (Throwable th2) {
                    this.zzrq = true;
                    throw th2;
                }
            }
        }
    }

    public final void zzb(Uri uri) {
        this.zzamv.execute(new zzgj(this, uri));
    }

    private static boolean zzc(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 0);
            if (serviceInfo == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
