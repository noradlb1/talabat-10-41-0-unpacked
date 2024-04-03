package com.talabat.core.facebook.login.data;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/core/facebook/login/data/FacebookLoginRequestException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "requestStatusCode", "", "errorCode", "errorType", "", "(ILjava/lang/Integer;Ljava/lang/String;)V", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FacebookLoginRequestException extends RuntimeException {
    public FacebookLoginRequestException(int i11, @Nullable Integer num, @Nullable String str) {
        super("requestStatusCode: " + i11 + ", errorCode: " + num + ", errorType: " + str);
    }
}
