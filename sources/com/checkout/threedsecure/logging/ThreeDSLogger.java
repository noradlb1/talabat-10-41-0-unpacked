package com.checkout.threedsecure.logging;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/checkout/threedsecure/logging/ThreeDSLogger;", "", "logCompletedEvent", "", "success", "", "token", "", "error", "", "logLoadedEvent", "logPresentedEvent", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ThreeDSLogger {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void logCompletedEvent$default(ThreeDSLogger threeDSLogger, boolean z11, String str, Throwable th2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    str = null;
                }
                if ((i11 & 4) != 0) {
                    th2 = null;
                }
                threeDSLogger.logCompletedEvent(z11, str, th2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logCompletedEvent");
        }

        public static /* synthetic */ void logLoadedEvent$default(ThreeDSLogger threeDSLogger, boolean z11, Throwable th2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    th2 = null;
                }
                threeDSLogger.logLoadedEvent(z11, th2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logLoadedEvent");
        }
    }

    void logCompletedEvent(boolean z11, @Nullable String str, @Nullable Throwable th2);

    void logLoadedEvent(boolean z11, @Nullable Throwable th2);

    void logPresentedEvent();
}
