package com.talabat.uxcam;

import com.uxcam.UXCam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fJ\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rJ\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006¨\u0006\u000e"}, d2 = {"Lcom/talabat/uxcam/UXCamUser;", "", "()V", "setUserIdentity", "", "id", "", "setUserProperty", "key", "Lcom/talabat/uxcam/UXCamUserProperty;", "value", "", "", "", "com_talabat_ThirdPartyLibs_uxcam-wrapper_uxcam-wrapper"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UXCamUser {
    public final void setUserIdentity(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        UXCam.setUserIdentity(str);
    }

    public final void setUserProperty(@NotNull UXCamUserProperty uXCamUserProperty, int i11) {
        Intrinsics.checkNotNullParameter(uXCamUserProperty, "key");
        UXCam.setUserProperty(uXCamUserProperty.getTitle(), i11);
    }

    public final void setUserProperty(@NotNull UXCamUserProperty uXCamUserProperty, float f11) {
        Intrinsics.checkNotNullParameter(uXCamUserProperty, "key");
        UXCam.setUserProperty(uXCamUserProperty.getTitle(), f11);
    }

    public final void setUserProperty(@NotNull UXCamUserProperty uXCamUserProperty, boolean z11) {
        Intrinsics.checkNotNullParameter(uXCamUserProperty, "key");
        UXCam.setUserProperty(uXCamUserProperty.getTitle(), z11);
    }

    public final void setUserProperty(@NotNull UXCamUserProperty uXCamUserProperty, @NotNull String str) {
        Intrinsics.checkNotNullParameter(uXCamUserProperty, "key");
        Intrinsics.checkNotNullParameter(str, "value");
        UXCam.setUserProperty(uXCamUserProperty.getTitle(), str);
    }
}
