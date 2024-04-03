package com.instabug.library.internal.video;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.instabug.library.Feature;
import com.instabug.library._InstabugActivity;
import com.instabug.library.broadcast.a;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.screenshot.ScreenshotProvider;
import com.instabug.library.screenshot.f;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.StatusBarUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
@TargetApi(21)
public class RequestPermissionActivity extends AppCompatActivity implements _InstabugActivity, a.C0004a, TraceFieldInterface {
    private static final int CREATE_SCREENSHOT = 101;
    private static final int CREATE_SCREEN_CAPTURE = 2020;
    public static final String KEY_IS_PERMISSION_GRANDTED = "isPermissionGranted";
    public static final int REQUEST_MEDIA_PROJECTION_PERMISSION = 2030;
    private static final int REQUEST_SCREEN_RECORDING_MIC_PERMISSION = 2022;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public static ScreenshotProvider.ScreenshotCapturingListener f51125k;
    public Trace _nr_trace;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51126i = true;

    /* renamed from: j  reason: collision with root package name */
    public boolean f51127j = true;
    private a sdkInvokedBroadcast = new a(this);

    private void requestAudioRecordingPermission() {
        boolean z11;
        if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, REQUEST_SCREEN_RECORDING_MIC_PERMISSION);
        } else {
            requestScreenRecording();
        }
    }

    private void requestScreenRecording() {
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService("media_projection");
        if (InternalAutoScreenRecorderHelper.c() != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                startForegroundService(ScreenRecordingService.a(this, InternalAutoScreenRecorderHelper.d(), InternalAutoScreenRecorderHelper.c(), false));
            } else {
                startService(ScreenRecordingService.a(this, InternalAutoScreenRecorderHelper.d(), InternalAutoScreenRecorderHelper.c(), false));
            }
            finish();
            return;
        }
        startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), CREATE_SCREEN_CAPTURE);
    }

    private void requestScreenShot(Intent intent) {
        if (InternalAutoScreenRecorderHelper.c() != null) {
            if (!this.f51127j) {
                Intent intent2 = new Intent();
                intent2.putExtra(KEY_IS_PERMISSION_GRANDTED, true);
                setResult(REQUEST_MEDIA_PROJECTION_PERMISSION, intent2);
            }
            f.f51740c.a(InternalAutoScreenRecorderHelper.d(), InternalAutoScreenRecorderHelper.c(), this.f51127j, f51125k);
            finish();
            return;
        }
        startActivityForResult(intent, 101);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == CREATE_SCREEN_CAPTURE) {
            if (i12 == -1) {
                try {
                    if (InternalAutoScreenRecorderHelper.d() == 0 && InternalAutoScreenRecorderHelper.c() == null) {
                        InternalAutoScreenRecorderHelper.e(intent);
                        InternalAutoScreenRecorderHelper.f(i12);
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        startForegroundService(ScreenRecordingService.a(this, InternalAutoScreenRecorderHelper.d(), InternalAutoScreenRecorderHelper.c(), false));
                    } else {
                        startService(ScreenRecordingService.a(this, InternalAutoScreenRecorderHelper.d(), InternalAutoScreenRecorderHelper.c(), false));
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                } catch (Throwable th2) {
                    finish();
                    throw th2;
                }
            } else if (i12 == 0) {
                SettingsManager.getInstance().setAutoScreenRecordingDenied(true);
                ScreenRecordingEventBus.getInstance().post(new ScreenRecordingEvent(0, (Uri) null));
            }
        } else if (i11 == 101) {
            if (i12 == -1) {
                if (InternalAutoScreenRecorderHelper.d() == 0 && InternalAutoScreenRecorderHelper.c() == null) {
                    InternalAutoScreenRecorderHelper.e(intent);
                    InternalAutoScreenRecorderHelper.f(i12);
                }
                SettingsManager.getInstance().setProcessingForeground(true);
                if (!this.f51127j) {
                    Intent intent2 = new Intent();
                    intent2.putExtra(KEY_IS_PERMISSION_GRANDTED, true);
                    setResult(REQUEST_MEDIA_PROJECTION_PERMISSION, intent2);
                }
                f.f51740c.a(i12, intent, this.f51127j, f51125k);
            } else {
                ScreenshotProvider.ScreenshotCapturingListener screenshotCapturingListener = f51125k;
                if (screenshotCapturingListener != null) {
                    screenshotCapturingListener.onScreenshotCapturingFailed(new Exception("User declined media-projection permission"));
                }
            }
        }
        finish();
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("RequestPermissionActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "RequestPermissionActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RequestPermissionActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        StatusBarUtils.darkenStatusBarColor(this, InstabugCore.getPrimaryColor());
        if (bundle == null) {
            this.f51126i = getIntent().getBooleanExtra("isVideo", true);
            this.f51127j = getIntent().getBooleanExtra("isInitial", true);
            Intent createScreenCaptureIntent = ((MediaProjectionManager) getSystemService("media_projection")).createScreenCaptureIntent();
            if (!this.f51126i) {
                requestScreenShot(createScreenCaptureIntent);
            } else if (SettingsManager.getInstance().getAutoScreenRecordingAudioCapturingState() == Feature.State.ENABLED) {
                requestAudioRecordingPermission();
            } else {
                requestScreenRecording();
            }
        }
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        super.onDestroy();
        f51125k = null;
    }

    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.sdkInvokedBroadcast);
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        if (iArr.length <= 0 || iArr[0] != 0) {
            if (i11 == REQUEST_SCREEN_RECORDING_MIC_PERMISSION) {
                requestScreenRecording();
            }
        } else if (i11 != REQUEST_SCREEN_RECORDING_MIC_PERMISSION) {
            super.onRequestPermissionsResult(i11, strArr, iArr);
        } else {
            requestScreenRecording();
        }
    }

    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.sdkInvokedBroadcast, new IntentFilter("SDK invoked"));
    }

    public void onSDKInvoked(boolean z11) {
        if (z11) {
            finish();
        }
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        SettingsManager.getInstance().setRequestPermissionScreenShown(true);
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        SettingsManager.getInstance().setRequestPermissionScreenShown(false);
        finish();
    }
}
