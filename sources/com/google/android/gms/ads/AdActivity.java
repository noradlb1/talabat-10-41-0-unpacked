package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzcbs;
import com.google.android.gms.internal.ads.zzciz;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
@KeepForSdk
public final class AdActivity extends Activity implements TraceFieldInterface {
    @RecentlyNonNull
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public Trace _nr_trace;
    @Nullable
    private zzcbs zza;

    private final void zza() {
        zzcbs zzcbs = this.zza;
        if (zzcbs != null) {
            try {
                zzcbs.zzv();
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
    }

    public final void onActivityResult(int i11, int i12, @RecentlyNonNull Intent intent) {
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null) {
                zzcbs.zzg(i11, i12, intent);
            }
        } catch (Exception e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
        super.onActivityResult(i11, i12, intent);
    }

    public final void onBackPressed() {
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null && !zzcbs.zzE()) {
                return;
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
        super.onBackPressed();
        try {
            zzcbs zzcbs2 = this.zza;
            if (zzcbs2 != null) {
                zzcbs2.zzh();
            }
        } catch (RemoteException e12) {
            zzciz.zzl("#007 Could not call remote method.", e12);
        }
    }

    public final void onConfigurationChanged(@RecentlyNonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null) {
                zzcbs.zzj(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("AdActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "AdActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "AdActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        zzcbs zzn = zzbgo.zza().zzn(this);
        this.zza = zzn;
        if (zzn != null) {
            try {
                zzn.zzk(bundle);
                TraceMachine.exitMethod();
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
                finish();
                TraceMachine.exitMethod();
            }
        } else {
            zzciz.zzl("#007 Could not call remote method.", (Throwable) null);
            finish();
            TraceMachine.exitMethod();
        }
    }

    public final void onDestroy() {
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null) {
                zzcbs.zzl();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
        super.onDestroy();
    }

    public final void onPause() {
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null) {
                zzcbs.zzn();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            finish();
        }
        super.onPause();
    }

    public final void onRestart() {
        super.onRestart();
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null) {
                zzcbs.zzo();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            finish();
        }
    }

    public final void onResume() {
        super.onResume();
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null) {
                zzcbs.zzp();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            finish();
        }
    }

    public final void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null) {
                zzcbs.zzq(bundle);
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    public final void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null) {
                zzcbs.zzr();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            finish();
        }
    }

    public final void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null) {
                zzcbs.zzs();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            finish();
        }
        super.onStop();
    }

    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzcbs zzcbs = this.zza;
            if (zzcbs != null) {
                zzcbs.zzt();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void setContentView(int i11) {
        super.setContentView(i11);
        zza();
    }

    public final void setContentView(@RecentlyNonNull View view) {
        super.setContentView(view);
        zza();
    }

    public final void setContentView(@RecentlyNonNull View view, @RecentlyNonNull ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
