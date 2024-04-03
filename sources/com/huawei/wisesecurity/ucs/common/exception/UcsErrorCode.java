package com.huawei.wisesecurity.ucs.common.exception;

public class UcsErrorCode {
    public static final long BAD_PARAMETERS = 1005;
    public static final int CHECK_PKGNAME_CERTFP_ERROR = 1023;
    public static final long CREDENTIAL_EXPIRED = 1014;
    public static final int CREDENTIAL_NEED_REAPPLY_ERROR = 1020;
    public static final long CRYPTO_ERROR = 1003;
    public static final long DOWNLOAD_KEY_COMPONENT_ERROR = 1010;
    public static final int GET_CREDENTIAL_FAIL = 1006;
    public static final long GRS_ERROR = 1007;
    public static final int INNER_ERROR = 2001;
    public static final long JSON_ERROR = 1002;
    public static final int KEK_C1_VERSION_ERROR = 1021;
    public static final int KEYSTORE_ERROR = 1022;
    public static final long LACK_CAPABILITY_COMPONENT_ERROR = 1025;
    public static final long LOAD_KEY_COMPONENT_ERROR = 1009;
    public static final long LOAD_LIBRARY_ERROR = 1004;
    public static final long NETWORK_ERROR = 1008;
    public static final int OK = 0;
    public static final long PARAM_ILLEGAL = 1001;
    public static final int REQ_MAIN_THREAD = 1015;
    public static final long SAVE_KEY_COMPONENT_ERROR = 1011;
    public static final int SO_VERSION_ERROR = 1016;
    public static final long TSMS_HTTP_REQ_ERROR = 1013;
    public static final long TSMS_SERVICE_ERROR = 1024;
    public static final int UNENABLE_EXPIRE_ERROR = 1017;
    public static final long VERIFY_JWS_ERROR = 1012;
    public long errorCode;

    public UcsErrorCode(long j11) {
        this.errorCode = j11;
    }

    public long getCode() {
        return this.errorCode;
    }
}
