package com.huawei.wisesecurity.kfs.crypto.codec;

import android.util.Base64;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.util.HexUtil;
import java.nio.charset.StandardCharsets;

public interface Decoder {
    public static final Decoder BASE64 = new Decoder() {
        public byte[] decode(String str) throws CodecException {
            try {
                return Base64.decode(str, 0);
            } catch (Exception e11) {
                throw new CodecException("Base64 decode fail : " + e11.getMessage());
            }
        }
    };
    public static final Decoder BASE64Url = new Decoder() {
        public byte[] decode(String str) throws CodecException {
            try {
                return Base64.decode(str, 8);
            } catch (Exception e11) {
                throw new CodecException("Base64 decode fail : " + e11.getMessage());
            }
        }
    };
    public static final Decoder HEX = new Decoder() {
        public byte[] decode(String str) throws CodecException {
            return HexUtil.decodeHexString(str);
        }
    };
    public static final Decoder RAW_BYTES = new Decoder() {
        public byte[] decode(String str) throws CodecException {
            return str.getBytes(StandardCharsets.UTF_8);
        }
    };

    byte[] decode(String str) throws CodecException;
}
