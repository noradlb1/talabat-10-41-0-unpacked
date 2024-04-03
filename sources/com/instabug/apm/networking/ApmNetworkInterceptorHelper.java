package com.instabug.apm.networking;

import com.instabug.apm.configuration.c;
import com.instabug.apm.di.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class ApmNetworkInterceptorHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isGraphQlEnabled() {
            c c11 = a.c();
            if (c11 == null) {
                return false;
            }
            return c11.f0();
        }

        public final boolean isGrpcInterceptionEnabled() {
            c c11 = a.c();
            if (c11 == null) {
                return false;
            }
            return c11.t();
        }
    }
}
