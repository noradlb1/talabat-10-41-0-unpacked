package com.talabat.core.deeplink.data;

import androidx.webkit.ProxyConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/deeplink/data/Schemes;", "", "(Ljava/lang/String;I)V", "DEEPLINK", "URL", "UNKNOWN", "Companion", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum Schemes {
    DEEPLINK,
    URL,
    UNKNOWN;
    
    @NotNull
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/deeplink/data/Schemes$Companion;", "", "()V", "from", "Lcom/talabat/core/deeplink/data/Schemes;", "value", "", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Schemes from(@Nullable String str) {
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1544000461) {
                    if (hashCode == 3213448 ? str.equals(ProxyConfig.MATCH_HTTP) : hashCode == 99617003 && str.equals("https")) {
                        return Schemes.URL;
                    }
                } else if (str.equals("talabat")) {
                    return Schemes.DEEPLINK;
                }
            }
            return Schemes.UNKNOWN;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }
}
