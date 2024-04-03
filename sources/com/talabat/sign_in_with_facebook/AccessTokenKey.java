package com.talabat.sign_in_with_facebook;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;

public enum AccessTokenKey {
    TOKEN(LegacyTokenLocalDataSourceImpl.KEY),
    USER_ID("userId"),
    EXPIRES("expires"),
    APPLICATION_ID("applicationId"),
    LAST_REFRESH("lastRefresh"),
    IS_EXPIRED("isExpired"),
    GRANTED_PERMISSIONS("grantedPermissions"),
    DECLINED_PERMISSIONS("declinedPermissions"),
    DATA_ACCESS_EXPIRATION_TIME("dataAccessExpirationTime");
    
    private final String key;

    private AccessTokenKey(String str) {
        this.key = str;
    }

    public String toString() {
        return this.key;
    }
}
