package com.google.ads;

import androidx.annotation.RecentlyNonNull;

@Deprecated
public final class AdRequest {
    @RecentlyNonNull
    public static final String LOGTAG = "Ads";
    @RecentlyNonNull
    public static final String TEST_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    @RecentlyNonNull
    public static final String VERSION = "0.0.0";

    public enum ErrorCode {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        private final String zzb;

        private ErrorCode(String str) {
            this.zzb = str;
        }

        @RecentlyNonNull
        public String toString() {
            return this.zzb;
        }
    }

    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }

    private AdRequest() {
    }
}
