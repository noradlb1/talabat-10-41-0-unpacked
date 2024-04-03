package com.instabug.crash.models;

import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IBGNonFatalException {
    @Nullable
    private final String fingerprint;
    @NotNull
    private final Level level;
    @NotNull
    private final Throwable throwable;
    @NotNull
    private final Map<String, String> userAttributes;

    public static final class Builder {
        @Nullable
        private String fingerprint;
        @NotNull
        private Level level = Level.ERROR;
        @NotNull
        private final Throwable throwable;
        @NotNull
        private Map<String, String> userAttributes = MapsKt__MapsKt.emptyMap();

        public Builder(@NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(th2, "throwable");
            this.throwable = th2;
        }

        @NotNull
        public final IBGNonFatalException build() {
            return new IBGNonFatalException(this.throwable, this.userAttributes, this.fingerprint, this.level, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final Builder setFingerprint(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "fingerprint");
            this.fingerprint = str;
            return this;
        }

        @NotNull
        public final Builder setLevel(@NotNull Level level2) {
            Intrinsics.checkNotNullParameter(level2, "level");
            this.level = level2;
            return this;
        }

        @NotNull
        public final Builder setUserAttributes(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "userAttributes");
            this.userAttributes = map;
            return this;
        }
    }

    public enum Level {
        INFO(0),
        WARNING(1),
        ERROR(2),
        CRITICAL(3);
        
        @NotNull
        public static final a Companion = null;
        private final int severity;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final Level a(int i11) {
                boolean z11;
                Level[] values = Level.values();
                int length = values.length;
                int i12 = 0;
                while (i12 < length) {
                    Level level = values[i12];
                    i12++;
                    if (level.getSeverity() == i11) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (z11) {
                        return level;
                    }
                }
                return null;
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new a((DefaultConstructorMarker) null);
        }

        private Level(int i11) {
            this.severity = i11;
        }

        @JvmStatic
        @Nullable
        public static final Level parse(int i11) {
            return Companion.a(i11);
        }

        public final int getSeverity() {
            return this.severity;
        }
    }

    private IBGNonFatalException(Throwable th2, Map<String, String> map, String str, Level level2) {
        this.throwable = th2;
        this.userAttributes = map;
        this.fingerprint = str;
        this.level = level2;
    }

    public /* synthetic */ IBGNonFatalException(Throwable th2, Map map, String str, Level level2, DefaultConstructorMarker defaultConstructorMarker) {
        this(th2, map, str, level2);
    }

    @Nullable
    public final String getFingerprint() {
        return this.fingerprint;
    }

    @NotNull
    public final Level getLevel() {
        return this.level;
    }

    @NotNull
    public final Throwable getThrowable() {
        return this.throwable;
    }

    @NotNull
    public final Map<String, String> getUserAttributes() {
        return this.userAttributes;
    }
}
