package com.checkout.frames.error;

import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.base.error.CheckoutError;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/checkout/frames/error/FramesError;", "Lcom/checkout/base/error/CheckoutError;", "errorCode", "", "localizedMessage", "", "message", "throwable", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "getErrorCode", "()Ljava/lang/String;", "getLocalizedMessage", "()I", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class FramesError extends CheckoutError {
    public static final int $stable = 0;
    @NotNull
    private final String errorCode;
    private final int localizedMessage;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FramesError(@NotNull String str, @StringRes int i11) {
        this(str, i11, (String) null, (Throwable) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "errorCode");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FramesError(@NotNull String str, @StringRes int i11, @Nullable String str2) {
        this(str, i11, str2, (Throwable) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "errorCode");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FramesError(String str, int i11, String str2, Throwable th2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, (i12 & 4) != 0 ? null : str2, (i12 & 8) != 0 ? null : th2);
    }

    @NotNull
    public String getErrorCode() {
        return this.errorCode;
    }

    public final int getLocalizedMessage() {
        return this.localizedMessage;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FramesError(@NotNull String str, @StringRes int i11, @Nullable String str2, @Nullable Throwable th2) {
        super(str, str2, th2);
        Intrinsics.checkNotNullParameter(str, "errorCode");
        this.errorCode = str;
        this.localizedMessage = i11;
    }
}
