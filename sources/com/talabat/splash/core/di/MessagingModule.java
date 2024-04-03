package com.talabat.splash.core.di;

import com.talabat.core.gms.base.domain.IsGmsAvailable;
import com.talabat.core.hms.base.domain.IsHmsAvailable;
import com.talabat.messaging.MessagingServiceType;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/splash/core/di/MessagingModule;", "", "()V", "messagingServiceType", "Lcom/talabat/messaging/MessagingServiceType;", "isGmsAvailable", "", "isHmsAvailable", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class MessagingModule {
    @NotNull
    @Provides
    public final MessagingServiceType messagingServiceType(@IsGmsAvailable boolean z11, @IsHmsAvailable boolean z12) {
        if (z11 || !z12) {
            return MessagingServiceType.DEFAULT;
        }
        return MessagingServiceType.HUAWEI;
    }
}
