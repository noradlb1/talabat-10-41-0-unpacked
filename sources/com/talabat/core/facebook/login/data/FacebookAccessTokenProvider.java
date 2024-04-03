package com.talabat.core.facebook.login.data;

import com.facebook.AccessToken;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/facebook/login/data/FacebookAccessTokenProvider;", "", "getAccessTokenOrNull", "Lcom/facebook/AccessToken;", "isCurrentAccessTokenActive", "", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FacebookAccessTokenProvider {
    @Nullable
    AccessToken getAccessTokenOrNull();

    boolean isCurrentAccessTokenActive();
}
