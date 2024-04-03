package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public enum ReportLevel {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String description;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private ReportLevel(String str) {
        this.description = str;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }
}
