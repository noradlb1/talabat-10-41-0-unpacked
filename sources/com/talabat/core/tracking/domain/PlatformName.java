package com.talabat.core.tracking.domain;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/core/tracking/domain/PlatformName;", "", "(Ljava/lang/String;I)V", "GOOGLE_ANALYTICS", "NEW_RELIC", "BRAZE", "ADJUST", "PERSEUS", "Companion", "com_talabat_core_tracking_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum PlatformName {
    GOOGLE_ANALYTICS,
    NEW_RELIC,
    BRAZE,
    ADJUST,
    PERSEUS;
    
    @NotNull
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/tracking/domain/PlatformName$Companion;", "", "()V", "from", "Lcom/talabat/core/tracking/domain/PlatformName;", "name", "", "com_talabat_core_tracking_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PlatformName from(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return PlatformName.valueOf((String) StringsKt__StringsKt.split$default((CharSequence) str, new String[]{RealDiscoveryConfigurationRepository.VERSION_DELIMETER}, false, 0, 6, (Object) null).get(1));
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }
}
