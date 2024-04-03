package com.talabat.core.wearable.huawei.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.wearengine.HiWear;
import com.huawei.wearengine.auth.AuthClient;
import com.huawei.wearengine.device.DeviceClient;
import com.huawei.wearengine.p2p.P2pClient;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit;
import com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit;
import com.talabat.core.wearable.huawei.data.impl.DefaultTalabatHuaweiWatch;
import com.talabat.core.wearable.huawei.domain.TalabatHuaweiWatch;
import com.talabat.talabatcore.cache.Cache;
import com.talabat.talabatcore.cache.impl.DiskCache;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/wearable/huawei/data/di/HuaweiWatchModule;", "", "huaweiWearEngineKit", "Lcom/talabat/core/wearable/huawei/data/HuaweiWearEngineKit;", "real", "Lcom/talabat/core/wearable/huawei/data/impl/DefaultHuaweiWearEngineKit;", "Companion", "com_talabat_core_wearable_huawei_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface HuaweiWatchModule {
    @NotNull
    public static final Companion Companion = Companion.f56008a;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/wearable/huawei/data/di/HuaweiWatchModule$Companion;", "", "()V", "PACKAGE_NAME", "", "PEER_FINGERPRINT", "authClient", "Lcom/huawei/wearengine/auth/AuthClient;", "context", "Landroid/content/Context;", "deviceClient", "Lcom/huawei/wearengine/device/DeviceClient;", "diskCache", "Lcom/talabat/talabatcore/cache/Cache;", "huaweiWatch", "Lcom/talabat/core/wearable/huawei/domain/TalabatHuaweiWatch;", "wearEngineKit", "Lcom/talabat/core/wearable/huawei/data/HuaweiWearEngineKit;", "p2pClient", "Lcom/huawei/wearengine/p2p/P2pClient;", "com_talabat_core_wearable_huawei_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        private static final String PACKAGE_NAME = "com.talabat.huawei.watch";
        @NotNull
        private static final String PEER_FINGERPRINT = "com.talabat.huawei.watch_BC0iGYHLk8GaL1+Ix8fDXoazEozCMOVbETCx3kqjEfkdpnqUTKj08Xau34pGi4X0vsEQn9Db1bPD86J4aBvYP+g=";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f56008a = new Companion();

        private Companion() {
        }

        @NotNull
        @Reusable
        @Provides
        public final AuthClient authClient(@NotNull @ApplicationContext Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AuthClient authClient = HiWear.getAuthClient(context);
            Intrinsics.checkNotNullExpressionValue(authClient, "getAuthClient(context)");
            return authClient;
        }

        @NotNull
        @Reusable
        @Provides
        public final DeviceClient deviceClient(@NotNull @ApplicationContext Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            DeviceClient deviceClient = HiWear.getDeviceClient(context);
            Intrinsics.checkNotNullExpressionValue(deviceClient, "getDeviceClient(context)");
            return deviceClient;
        }

        @NotNull
        @Reusable
        @Provides
        public final Cache diskCache() {
            return new DiskCache((String) null, (SharedPreferences) null, 3, (DefaultConstructorMarker) null);
        }

        @NotNull
        @Reusable
        @Provides
        public final TalabatHuaweiWatch huaweiWatch(@NotNull HuaweiWearEngineKit huaweiWearEngineKit) {
            Intrinsics.checkNotNullParameter(huaweiWearEngineKit, "wearEngineKit");
            return new DefaultTalabatHuaweiWatch(huaweiWearEngineKit);
        }

        @NotNull
        @Reusable
        @Provides
        public final P2pClient p2pClient(@NotNull @ApplicationContext Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            P2pClient p2pClient = HiWear.getP2pClient(context);
            p2pClient.setPeerPkgName(PACKAGE_NAME).setPeerFingerPrint(PEER_FINGERPRINT);
            Intrinsics.checkNotNullExpressionValue(p2pClient, "p2pClient");
            return p2pClient;
        }
    }

    @NotNull
    @Binds
    @Reusable
    HuaweiWearEngineKit huaweiWearEngineKit(@NotNull DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit);
}
