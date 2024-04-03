package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class CheckResult {
    private final boolean isSuccess;

    public static final class IllegalFunctionName extends CheckResult {
        @NotNull
        public static final IllegalFunctionName INSTANCE = new IllegalFunctionName();

        private IllegalFunctionName() {
            super(false, (DefaultConstructorMarker) null);
        }
    }

    public static final class IllegalSignature extends CheckResult {
        @NotNull
        private final String error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IllegalSignature(@NotNull String str) {
            super(false, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "error");
            this.error = str;
        }
    }

    public static final class SuccessCheck extends CheckResult {
        @NotNull
        public static final SuccessCheck INSTANCE = new SuccessCheck();

        private SuccessCheck() {
            super(true, (DefaultConstructorMarker) null);
        }
    }

    private CheckResult(boolean z11) {
        this.isSuccess = z11;
    }

    public /* synthetic */ CheckResult(boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
