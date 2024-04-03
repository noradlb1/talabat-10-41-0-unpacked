package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class zacd implements OnCompleteListener {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey zac;
    private final long zad;
    private final long zae;

    @VisibleForTesting
    public zacd(GoogleApiManager googleApiManager, int i11, ApiKey apiKey, long j11, long j12, @Nullable String str, @Nullable String str2) {
        this.zaa = googleApiManager;
        this.zab = i11;
        this.zac = apiKey;
        this.zad = j11;
        this.zae = j12;
    }

    @Nullable
    public static zacd zaa(GoogleApiManager googleApiManager, int i11, ApiKey apiKey) {
        boolean z11;
        long j11;
        long j12;
        if (!googleApiManager.zaD()) {
            return null;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config == null) {
            z11 = true;
        } else if (!config.getMethodInvocationTelemetryEnabled()) {
            return null;
        } else {
            z11 = config.getMethodTimingTelemetryEnabled();
            zabq zai = googleApiManager.zai(apiKey);
            if (zai != null) {
                if (!(zai.zaf() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) zai.zaf();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration zab2 = zab(zai, baseGmsClient, i11);
                    if (zab2 == null) {
                        return null;
                    }
                    zai.zaq();
                    z11 = zab2.getMethodTimingTelemetryEnabled();
                }
            }
        }
        if (z11) {
            j11 = System.currentTimeMillis();
        } else {
            j11 = 0;
        }
        if (z11) {
            j12 = SystemClock.elapsedRealtime();
        } else {
            j12 = 0;
        }
        return new zacd(googleApiManager, i11, apiKey, j11, j12, (String) null, (String) null);
    }

    @Nullable
    private static ConnectionTelemetryConfiguration zab(zabq zabq, BaseGmsClient baseGmsClient, int i11) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i11) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i11))) || zabq.zac() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @WorkerThread
    public final void onComplete(@NonNull Task task) {
        zabq zai;
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long j11;
        long j12;
        if (this.zaa.zaD()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zai = this.zaa.zai(this.zac)) != null && (zai.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zai.zaf();
                boolean z12 = true;
                int i16 = 0;
                if (this.zad > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                int i17 = 100;
                if (config != null) {
                    boolean methodTimingTelemetryEnabled = z11 & config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    i13 = config.getVersion();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration zab2 = zab(zai, baseGmsClient, this.zab);
                        if (zab2 != null) {
                            if (!zab2.getMethodTimingTelemetryEnabled() || this.zad <= 0) {
                                z12 = false;
                            }
                            maxMethodInvocationsInBatch = zab2.getMaxMethodInvocationsLogged();
                            methodTimingTelemetryEnabled = z12;
                        } else {
                            return;
                        }
                    }
                    i12 = batchPeriodMillis;
                    i11 = maxMethodInvocationsInBatch;
                } else {
                    i13 = 0;
                    i11 = 100;
                    i12 = 5000;
                }
                GoogleApiManager googleApiManager = this.zaa;
                if (task.isSuccessful()) {
                    i14 = 0;
                } else {
                    if (!task.isCanceled()) {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            Status status = ((ApiException) exception).getStatus();
                            i17 = status.getStatusCode();
                            ConnectionResult connectionResult = status.getConnectionResult();
                            if (connectionResult != null) {
                                i14 = connectionResult.getErrorCode();
                                i16 = i17;
                            }
                        } else {
                            i16 = 101;
                            i14 = -1;
                        }
                    }
                    i16 = i17;
                    i14 = -1;
                }
                if (z11) {
                    long j13 = this.zad;
                    long currentTimeMillis = System.currentTimeMillis();
                    i15 = (int) (SystemClock.elapsedRealtime() - this.zae);
                    j12 = j13;
                    j11 = currentTimeMillis;
                } else {
                    j12 = 0;
                    j11 = 0;
                    i15 = -1;
                }
                googleApiManager.zaw(new MethodInvocation(this.zab, i16, i14, j12, j11, (String) null, (String) null, gCoreServiceId, i15), i13, (long) i12, i11);
            }
        }
    }
}
