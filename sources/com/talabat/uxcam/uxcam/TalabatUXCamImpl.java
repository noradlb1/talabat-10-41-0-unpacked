package com.talabat.uxcam.uxcam;

import android.app.Activity;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.talabat.secrets.Secrets;
import com.uxcam.UXCam;
import com.uxcam.datamodel.UXCamOccludeAllTextFields;
import com.uxcam.datamodel.UXConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016¨\u0006\u0016"}, d2 = {"Lcom/talabat/uxcam/uxcam/TalabatUXCamImpl;", "Lcom/talabat/uxcam/uxcam/TalabatUXCam;", "()V", "blockScreenRecording", "", "blockViewRecording", "view", "Landroid/view/View;", "cancelScreenRecording", "getUXCamKey", "", "secrets", "Lcom/talabat/secrets/Secrets;", "isDebugBuild", "", "hideAllTextFields", "removeViewBlocking", "startScreenRecording", "activity", "Landroid/app/Activity;", "stopScreenRecording", "unBlockScreenRecording", "com_talabat_ThirdPartyLibs_uxcam-wrapper_uxcam-wrapper"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatUXCamImpl implements TalabatUXCam {
    public void blockScreenRecording() {
        UXCam.occludeSensitiveScreen(true);
    }

    public void blockViewRecording(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        UXCam.occludeSensitiveViewWithoutGesture(view);
    }

    public void cancelScreenRecording() {
        UXCam.cancelCurrentSession();
        UXCam.deletePendingUploads();
    }

    @NotNull
    @VisibleForTesting
    public final String getUXCamKey(@NotNull Secrets secrets, boolean z11) {
        Intrinsics.checkNotNullParameter(secrets, "secrets");
        if (z11) {
            return secrets.getUxcamDebugKey();
        }
        return secrets.getUxCamReleaseKey();
    }

    public void hideAllTextFields() {
        UXCam.applyOcclusion(new UXCamOccludeAllTextFields.Builder().build());
    }

    public void removeViewBlocking(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        UXCam.unOccludeSensitiveView(view);
    }

    public void startScreenRecording(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        UXCam.startWithConfiguration(new UXConfig.Builder(getUXCamKey(new Secrets(), false)).enableAutomaticScreenNameTagging(true).enableImprovedScreenCapture(true).enableMultiSessionRecord(true).enableCrashHandling(false).build(), activity, true);
        hideAllTextFields();
    }

    public void stopScreenRecording() {
        UXCam.stopSessionAndUploadData();
    }

    public void unBlockScreenRecording() {
        UXCam.occludeSensitiveScreen(false);
    }
}
