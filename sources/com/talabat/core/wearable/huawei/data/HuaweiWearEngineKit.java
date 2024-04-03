package com.talabat.core.wearable.huawei.data;

import com.huawei.wearengine.device.Device;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\b\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0003H&J\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H&\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/wearable/huawei/data/HuaweiWearEngineKit;", "", "authenticateUser", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBondedDevice", "Lcom/huawei/wearengine/device/Device;", "hasAvailableDevices", "isAuthenticated", "isSyncEnabled", "ping", "bondedDevice", "(Lcom/huawei/wearengine/device/Device;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "", "message", "", "com_talabat_core_wearable_huawei_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HuaweiWearEngineKit {
    @Nullable
    Object authenticateUser(@NotNull Continuation<? super Boolean> continuation);

    @Nullable
    Object getBondedDevice(@NotNull Continuation<? super Device> continuation);

    @Nullable
    Object hasAvailableDevices(@NotNull Continuation<? super Boolean> continuation);

    @Nullable
    Object isAuthenticated(@NotNull Continuation<? super Boolean> continuation);

    boolean isSyncEnabled();

    @Nullable
    Object ping(@NotNull Device device, @NotNull Continuation<? super Boolean> continuation);

    void send(@NotNull String str, @NotNull Device device);
}
