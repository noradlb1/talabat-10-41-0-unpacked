package com.talabat.uxcam.uxcam;

import android.app.Activity;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/talabat/uxcam/uxcam/TalabatUXCam;", "", "blockScreenRecording", "", "blockViewRecording", "view", "Landroid/view/View;", "cancelScreenRecording", "hideAllTextFields", "removeViewBlocking", "startScreenRecording", "activity", "Landroid/app/Activity;", "stopScreenRecording", "unBlockScreenRecording", "com_talabat_ThirdPartyLibs_uxcam-wrapper_uxcam-wrapper"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TalabatUXCam {
    void blockScreenRecording();

    void blockViewRecording(@NotNull View view);

    void cancelScreenRecording();

    void hideAllTextFields();

    void removeViewBlocking(@NotNull View view);

    void startScreenRecording(@NotNull Activity activity);

    void stopScreenRecording();

    void unBlockScreenRecording();
}
