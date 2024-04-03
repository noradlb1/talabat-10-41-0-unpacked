package com.talabat.data.googleclientid;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/data/googleclientid/GoogleClientIdLocalStorage;", "Lcom/talabat/data/googleclientid/GoogleClientIdProvider;", "()V", "googleClientId", "", "getGoogleClientId", "setGoogleClientId", "", "id", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GoogleClientIdLocalStorage implements GoogleClientIdProvider {
    @NotNull
    public static final GoogleClientIdLocalStorage INSTANCE = new GoogleClientIdLocalStorage();
    @Nullable
    private static String googleClientId;

    private GoogleClientIdLocalStorage() {
    }

    @NotNull
    public String getGoogleClientId() {
        String str = googleClientId;
        if (str != null) {
            return str;
        }
        throw new NullPointerException("Google client id must be initialized on App start");
    }

    public final void setGoogleClientId(@Nullable String str) {
        googleClientId = str;
    }
}
