package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.PermissionStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatusInfrastrctureListener;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus;", "", "handlePermissionCheck", "e", "Landroid/content/Context;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0})
public final class PermissionStatusInfrastrctureListener extends MutableLiveData<PermissionStatus> {
    @NotNull
    private final Context context;

    public PermissionStatusInfrastrctureListener(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final void handlePermissionCheck() {
        boolean z11;
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            postValue(new PermissionStatus.Granted(0, 1, (DefaultConstructorMarker) null));
        } else {
            postValue(new PermissionStatus.Denied(0, 1, (DefaultConstructorMarker) null));
        }
    }

    public void e() {
        handlePermissionCheck();
    }
}
