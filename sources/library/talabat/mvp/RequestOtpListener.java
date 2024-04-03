package library.talabat.mvp;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Llibrary/talabat/mvp/RequestOtpListener;", "", "onFailedToRequestOtp", "", "message", "", "onMaxOtpRequestsReached", "onRequestOtpMobileNumberValidationError", "onRequestOtpSuccess", "remainingRequests", "", "onRequestOtpUnknownError", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RequestOtpListener {
    void onFailedToRequestOtp(@NotNull String str);

    void onMaxOtpRequestsReached(@NotNull String str);

    void onRequestOtpMobileNumberValidationError(@NotNull String str);

    void onRequestOtpSuccess(@NotNull String str, int i11);

    void onRequestOtpUnknownError();
}
