package com.talabat.authentication.aaa.secrets;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "", "getClientSecret", "", "getDarkstoresAPIKey", "getGoogleApiKey", "getKey", "keyName", "getSubscriptionsKey", "getTMartAPIKey", "getTproSubscriptionProductId", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SecretProvider {
    @NotNull
    String getClientSecret();

    @NotNull
    String getDarkstoresAPIKey();

    @NotNull
    String getGoogleApiKey();

    @Nullable
    String getKey(@NotNull String str);

    @NotNull
    String getSubscriptionsKey();

    @NotNull
    String getTMartAPIKey();

    @NotNull
    String getTproSubscriptionProductId();
}
