package com.talabat.screenrecorder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.fwfprojectskeys.domain.projects.killswitch.KillSwitchFeatureFlagsKeys;
import com.talabat.uxcam.uxcam.TalabatUXCam;
import com.talabat.uxcam.uxcam.TalabatUXCamImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/talabat/screenrecorder/ScreenRecorder;", "", "()V", "isRecording", "", "()Z", "setRecording", "(Z)V", "talabatUXCam", "Lcom/talabat/uxcam/uxcam/TalabatUXCam;", "getTalabatUXCam", "()Lcom/talabat/uxcam/uxcam/TalabatUXCam;", "setTalabatUXCam", "(Lcom/talabat/uxcam/uxcam/TalabatUXCam;)V", "blockScreenRecording", "", "blockViewRecording", "view", "Landroid/view/View;", "cancelScreenRecording", "isFeatureEnabled", "activity", "Landroid/app/Activity;", "removeViewBlocking", "startScreenRecording", "stopScreenRecording", "unBlockScreenRecording", "com_talabat_screenrecorder_screenrecorder"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenRecorder {
    @NotNull
    public static final ScreenRecorder INSTANCE = new ScreenRecorder();
    private static boolean isRecording;
    @NotNull
    private static TalabatUXCam talabatUXCam = new TalabatUXCamImpl();

    private ScreenRecorder() {
    }

    private final boolean isFeatureEnabled(Activity activity) {
        Context applicationContext = activity.getApplicationContext();
        if (applicationContext != null) {
            return ((FeatureFlagCoreLibApi) ((ApiContainer) applicationContext).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag().getFeatureFlag(KillSwitchFeatureFlagsKeys.UX_CAM, false);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    public final void blockScreenRecording() {
        if (isRecording) {
            talabatUXCam.blockScreenRecording();
        }
    }

    public final void blockViewRecording(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (isRecording) {
            talabatUXCam.blockViewRecording(view);
        }
    }

    public final void cancelScreenRecording() {
        if (isRecording) {
            talabatUXCam.cancelScreenRecording();
            isRecording = false;
        }
    }

    @NotNull
    public final TalabatUXCam getTalabatUXCam() {
        return talabatUXCam;
    }

    public final boolean isRecording() {
        return isRecording;
    }

    public final void removeViewBlocking(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (isRecording) {
            talabatUXCam.removeViewBlocking(view);
        }
    }

    public final void setRecording(boolean z11) {
        isRecording = z11;
    }

    public final void setTalabatUXCam(@NotNull TalabatUXCam talabatUXCam2) {
        Intrinsics.checkNotNullParameter(talabatUXCam2, "<set-?>");
        talabatUXCam = talabatUXCam2;
    }

    public final void startScreenRecording(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (isFeatureEnabled(activity) && !isRecording) {
            talabatUXCam.startScreenRecording(activity);
            isRecording = true;
        }
    }

    public final void stopScreenRecording() {
        if (isRecording) {
            talabatUXCam.stopScreenRecording();
            isRecording = false;
        }
    }

    public final void unBlockScreenRecording() {
        if (isRecording) {
            talabatUXCam.unBlockScreenRecording();
        }
    }
}
