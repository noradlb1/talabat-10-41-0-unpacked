package com.talabat.application.device.id.data.impl;

import android.content.Context;
import com.talabat.application.device.id.domain.DeviceIdProvider;
import com.talabat.helpers.TalabatUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/application/device/id/data/impl/DeviceIdProviderImpl;", "Lcom/talabat/application/device/id/domain/DeviceIdProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "id", "", "getId", "()Ljava/lang/String;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeviceIdProviderImpl implements DeviceIdProvider {
    @NotNull
    private final Context context;

    public DeviceIdProviderImpl(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @NotNull
    public String getId() {
        String deviceId = TalabatUtils.getDeviceId(this.context);
        Intrinsics.checkNotNullExpressionValue(deviceId, "getDeviceId(context)");
        return deviceId;
    }
}
