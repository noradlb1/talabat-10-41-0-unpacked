package com.talabat.feature.darkstorescart.data.local;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/local/CartDatabaseEnvironment;", "", "(Ljava/lang/String;I)V", "STAGING", "PRODUCTION", "MOCKING", "Companion", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum CartDatabaseEnvironment {
    STAGING,
    PRODUCTION,
    MOCKING;
    
    @NotNull
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/local/CartDatabaseEnvironment$Companion;", "", "()V", "get", "Lcom/talabat/feature/darkstorescart/data/local/CartDatabaseEnvironment;", "instrumentationServer", "", "buildType", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CartDatabaseEnvironment get(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "instrumentationServer");
            Intrinsics.checkNotNullParameter(str2, "buildType");
            if (Intrinsics.areEqual((Object) str, (Object) "prod") && Intrinsics.areEqual((Object) str2, (Object) "release")) {
                return CartDatabaseEnvironment.PRODUCTION;
            }
            if (Intrinsics.areEqual((Object) str, (Object) "mock")) {
                return CartDatabaseEnvironment.MOCKING;
            }
            return CartDatabaseEnvironment.STAGING;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }
}
