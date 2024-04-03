package com.huawei.location.lite.common.http.exception;

import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ErrorCode {
    public static final int CHECK_CERT_FAIL = 105;
    public static final int CHECK_SIGN_FAIL = 117;
    public static final int CHECK_SK_FAILED = 116;
    public static final int DECRYPT_DK_FROM_TSS_FAIL = 86;
    public static final int DECRYPT_KEK_FAIL = 90;
    public static final int DECRYPT_RSA_FAIL = 95;
    public static final int DECRYPT_SK_FROM_TSS_FAIL = 85;
    public static final int DECRYPT_SK_OR_DK_WITH_KEK_FAIL = 91;
    public static final int ENCRYPT_WITH_DK_FAIL = 94;
    public static final int ERROR = 1;
    private static final Map<Integer, String> ERROR_CODE_DESC_MAP;
    public static final int GET_CERT_FAIL = 40;
    public static final int GET_CERT_FROM_TSS_FAIL = 82;
    public static final int GET_KEY_VERSION_FAIL = 87;
    public static final int GET_NO_TA_AK_SK_FAIL = 96;
    public static final int GET_RESPONSE_FAILED = 10300;
    public static final int GET_TA_AK_SK_FAIL = 92;
    public static final int GET_TA_STATUS_FAIL = 80;
    public static final int HTTP_ACCEPTED = 202;
    public static final int HTTP_BAD_GATEWAY = 502;
    public static final int HTTP_BAD_METHOD = 405;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_CLIENT_TIMEOUT = 408;
    public static final int HTTP_CONFLICT = 409;
    public static final int HTTP_CREATED = 201;
    public static final int HTTP_ENTITY_TOO_LARGE = 413;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_GATEWAY_TIMEOUT = 504;
    public static final int HTTP_GONE = 410;
    public static final int HTTP_INTERNAL_ERROR = 500;
    public static final int HTTP_LENGTH_REQUIRED = 411;
    public static final int HTTP_MOVED_PERM = 301;
    public static final int HTTP_MOVED_TEMP = 302;
    public static final int HTTP_MULT_CHOICE = 300;
    public static final int HTTP_NOT_ACCEPTABLE = 406;
    public static final int HTTP_NOT_AUTHORITATIVE = 203;
    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_NOT_IMPLEMENTED = 501;
    public static final int HTTP_NOT_MODIFIED = 304;
    public static final int HTTP_NO_CONTENT = 204;
    public static final int HTTP_OK = 200;
    public static final int HTTP_PARTIAL = 206;
    public static final int HTTP_PAYMENT_REQUIRED = 402;
    public static final int HTTP_PRECON_FAILED = 412;
    public static final int HTTP_PROXY_AUTH = 407;
    public static final int HTTP_REQ_TOO_LONG = 414;
    public static final int HTTP_RESET = 205;
    public static final int HTTP_SEE_OTHER = 303;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_UNAVAILABLE = 503;
    public static final int HTTP_UNSUPPORTED_TYPE = 415;
    public static final int HTTP_USE_PROXY = 305;
    public static final int HTTP_VERSION = 505;
    public static final int INTERNAL_ERROR = 10000;
    public static final int JSON_PARSE_FAILED = 10304;
    public static final int KEY_VERSION_INVALID = 110;
    public static final int KEY_VERSION_UNMATCHED = 88;
    public static final int LOCATION_SERVER_ERROR = 10315;
    public static final int NO_NETWORK = 10302;
    public static final int PARAM_ERROR_EMPTY = 10309;
    public static final int PERSISTENCE_FAIL = 98;
    public static final int REMOTE_CHECK_SIGN_FAIL = 106;
    public static final int RESPONSE_IS_NULL = 10307;
    public static final int SIGN_FAIL = 41;
    public static final int SIGN_FROM_TSS_FAIL = 81;
    public static final int SIGN_WITH_SK_FAIL = 93;
    public static final int STRING_PARSE_FAILED = 10301;
    public static final int SUCCESS = 0;
    public static final int TSS_AES_DECRYPT_FAIL = 97;
    public static final int TSS_AES_ENCRYPT_FAIL = 99;
    public static final int UPDATE_KEY_COMPONENT_FAIL = 89;
    public int code;
    public String msg;

    static {
        HashMap hashMap = new HashMap();
        ERROR_CODE_DESC_MAP = hashMap;
        hashMap.put(0, "success");
        hashMap.put(1, "inner error");
        hashMap.put(200, "HTTP_OK");
        hashMap.put(201, "HTTP_CREATED");
        hashMap.put(202, "HTTP_ACCEPTED");
        hashMap.put(203, "HTTP_NOT_AUTHORITATIVE");
        hashMap.put(204, "HTTP_NO_CONTENT");
        hashMap.put(205, "HTTP_RESET");
        hashMap.put(206, "HTTP_PARTIAL");
        hashMap.put(300, "HTTP_MULT_CHOICE");
        hashMap.put(301, "HTTP_MOVED_PERM");
        hashMap.put(302, "HTTP_MOVED_TEMP");
        hashMap.put(303, "HTTP_SEE_OTHER");
        hashMap.put(304, "HTTP_NOT_MODIFIED");
        hashMap.put(305, "HTTP_USE_PROXY");
        hashMap.put(400, "HTTP_BAD_REQUEST");
        hashMap.put(401, "HTTP_UNAUTHORIZED");
        hashMap.put(402, "HTTP_PAYMENT_REQUIRED");
        hashMap.put(403, "HTTP_FORBIDDEN");
        hashMap.put(404, "HTTP_NOT_FOUND");
        hashMap.put(Integer.valueOf(HTTP_BAD_METHOD), "HTTP_BAD_METHOD");
        hashMap.put(Integer.valueOf(HTTP_NOT_ACCEPTABLE), "HTTP_NOT_ACCEPTABLE");
        hashMap.put(Integer.valueOf(HTTP_PROXY_AUTH), "HTTP_PROXY_AUTH");
        hashMap.put(Integer.valueOf(HTTP_CLIENT_TIMEOUT), "HTTP_CLIENT_TIMEOUT");
        hashMap.put(409, "HTTP_CONFLICT");
        hashMap.put(Integer.valueOf(HTTP_GONE), "HTTP_GONE");
        hashMap.put(Integer.valueOf(HTTP_LENGTH_REQUIRED), "HTTP_LENGTH_REQUIRED");
        hashMap.put(412, "HTTP_PRECON_FAILED");
        hashMap.put(Integer.valueOf(HTTP_ENTITY_TOO_LARGE), "HTTP_ENTITY_TOO_LARGE");
        hashMap.put(414, "HTTP_REQ_TOO_LONG");
        hashMap.put(Integer.valueOf(HTTP_UNSUPPORTED_TYPE), "HTTP_UNSUPPORTED_TYPE");
        hashMap.put(500, "HTTP_INTERNAL_ERROR");
        hashMap.put(501, "HTTP_NOT_IMPLEMENTED");
        hashMap.put(502, "HTTP_BAD_GATEWAY");
        hashMap.put(503, "HTTP_UNAVAILABLE");
        hashMap.put(504, "HTTP_GATEWAY_TIMEOUT");
        hashMap.put(505, "HTTP_VERSION");
        hashMap.put(10000, "internal error");
        hashMap.put(10300, "connect server exception access denied connection timed out");
        hashMap.put(Integer.valueOf(NO_NETWORK), "no network");
        hashMap.put(Integer.valueOf(JSON_PARSE_FAILED), "json parse failed");
        hashMap.put(10301, "server response format is error");
        hashMap.put(Integer.valueOf(LOCATION_SERVER_ERROR), "server response error code");
        hashMap.put(Integer.valueOf(RESPONSE_IS_NULL), "okHttp Response is null");
        hashMap.put(Integer.valueOf(PARAM_ERROR_EMPTY), "param error");
        hashMap.put(40, "get device cert info fail");
        hashMap.put(41, "sign fail");
        hashMap.put(80, "Get ta status from tss fail");
        hashMap.put(81, "sign str from tss fail");
        hashMap.put(82, "get cert chain from tss fail");
        hashMap.put(85, "decrypt sk from Tss with RSA algorithm fail");
        hashMap.put(86, "decrypt dk from Tss with RSA algorithm fail");
        hashMap.put(87, "get key version fail");
        hashMap.put(88, "key version from device does not match remote");
        hashMap.put(89, "get ak/sk info fail");
        hashMap.put(90, "decrypt kek from tss fail");
        hashMap.put(91, "decrypt sk or dk with kek fail");
        hashMap.put(92, "Get ta ak sk fail");
        hashMap.put(93, "sign message with sk fail");
        hashMap.put(94, "encrypt message with dk fail");
        hashMap.put(95, "decrypt data with tss using rsa algorithm fail");
        hashMap.put(96, "Get no ta ak sk fail");
        hashMap.put(98, "persistence fail");
        hashMap.put(99, "tss aes encrypt data fail");
        hashMap.put(97, "tss aes decrypt data fail");
        hashMap.put(105, "check certified credential fail");
        hashMap.put(106, "remote check signature fail");
        hashMap.put(110, "key version invalid");
        hashMap.put(116, "check sk failed");
        hashMap.put(117, "remote check signature using sk generate fail");
    }

    public ErrorCode(int i11, String str) {
        this.code = i11;
        this.msg = str;
    }

    public static ErrorCode valueOf(int i11) {
        Map<Integer, String> map = ERROR_CODE_DESC_MAP;
        return map.containsKey(Integer.valueOf(i11)) ? new ErrorCode(i11, map.get(Integer.valueOf(i11))) : new ErrorCode(10000, map.get(10000));
    }

    public static String valueOfKey(int i11) {
        Map<Integer, String> map = ERROR_CODE_DESC_MAP;
        if (!map.containsKey(Integer.valueOf(i11))) {
            i11 = 10000;
        }
        return map.get(Integer.valueOf(i11));
    }

    public String toString() {
        return "ErrorCode{code=" + this.code + ", msg='" + this.msg + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
