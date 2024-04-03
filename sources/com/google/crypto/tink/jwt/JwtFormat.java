package com.google.crypto.tink.jwt;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonObject;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.Optional;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;

final class JwtFormat {

    public static class Parts {
        String header;
        String payload;
        byte[] signatureOrMac;
        String unsignedCompact;

        public Parts(String str, byte[] bArr, String str2, String str3) {
            this.unsignedCompact = str;
            this.signatureOrMac = bArr;
            this.header = str2;
            this.payload = str3;
        }
    }

    private JwtFormat() {
    }

    public static String createHeader(String str, Optional<String> optional, Optional<String> optional2) throws InvalidAlgorithmParameterException {
        validateAlgorithm(str);
        JsonObject jsonObject = new JsonObject();
        if (optional2.isPresent()) {
            jsonObject.addProperty("kid", optional2.get());
        }
        jsonObject.addProperty("alg", str);
        if (optional.isPresent()) {
            jsonObject.addProperty(ClientData.KEY_TYPE, optional.get());
        }
        return Base64.urlSafeEncode(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
    }

    public static String createSignedCompact(String str, byte[] bArr) {
        return str + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + encodeSignature(bArr);
    }

    public static String createUnsignedCompact(String str, Optional<String> optional, RawJwt rawJwt) throws InvalidAlgorithmParameterException, JwtInvalidException {
        Optional optional2;
        String jsonPayload = rawJwt.getJsonPayload();
        if (rawJwt.hasTypeHeader()) {
            optional2 = Optional.of(rawJwt.getTypeHeader());
        } else {
            optional2 = Optional.empty();
        }
        return createHeader(str, optional2, optional) + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + encodePayload(jsonPayload);
    }

    public static String decodeHeader(String str) throws JwtInvalidException {
        byte[] strictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(strictUrlSafeDecode);
        return new String(strictUrlSafeDecode, StandardCharsets.UTF_8);
    }

    public static String decodePayload(String str) throws JwtInvalidException {
        byte[] strictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(strictUrlSafeDecode);
        return new String(strictUrlSafeDecode, StandardCharsets.UTF_8);
    }

    public static byte[] decodeSignature(String str) throws JwtInvalidException {
        return strictUrlSafeDecode(str);
    }

    public static String encodePayload(String str) {
        return Base64.urlSafeEncode(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String encodeSignature(byte[] bArr) {
        return Base64.urlSafeEncode(bArr);
    }

    public static Optional<Integer> getKeyId(String str) {
        byte[] urlSafeDecode = Base64.urlSafeDecode(str);
        if (urlSafeDecode.length != 4) {
            return Optional.empty();
        }
        return Optional.of(Integer.valueOf(ByteBuffer.wrap(urlSafeDecode).getInt()));
    }

    public static Optional<String> getKid(int i11, OutputPrefixType outputPrefixType) throws JwtInvalidException {
        if (outputPrefixType == OutputPrefixType.RAW) {
            return Optional.empty();
        }
        if (outputPrefixType == OutputPrefixType.TINK) {
            return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(i11).array()));
        }
        throw new JwtInvalidException("unsupported output prefix type");
    }

    private static String getStringHeader(JsonObject jsonObject, String str) throws JwtInvalidException {
        if (!jsonObject.has(str)) {
            throw new JwtInvalidException("header " + str + " does not exist");
        } else if (jsonObject.get(str).isJsonPrimitive() && jsonObject.get(str).getAsJsonPrimitive().isString()) {
            return jsonObject.get(str).getAsString();
        } else {
            throw new JwtInvalidException("header " + str + " is not a string");
        }
    }

    public static Optional<String> getTypeHeader(JsonObject jsonObject) throws JwtInvalidException {
        if (jsonObject.has(ClientData.KEY_TYPE)) {
            return Optional.of(getStringHeader(jsonObject, ClientData.KEY_TYPE));
        }
        return Optional.empty();
    }

    public static boolean isValidUrlsafeBase64Char(char c11) {
        return (c11 >= 'a' && c11 <= 'z') || (c11 >= 'A' && c11 <= 'Z') || ((c11 >= '0' && c11 <= '9') || c11 == '-' || c11 == '_');
    }

    public static Parts splitSignedCompact(String str) throws JwtInvalidException {
        validateASCII(str);
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String substring = str.substring(0, lastIndexOf);
            byte[] decodeSignature = decodeSignature(str.substring(lastIndexOf + 1));
            int indexOf = substring.indexOf(46);
            if (indexOf >= 0) {
                String substring2 = substring.substring(0, indexOf);
                String substring3 = substring.substring(indexOf + 1);
                if (substring3.indexOf(46) <= 0) {
                    return new Parts(substring, decodeSignature, decodeHeader(substring2), decodePayload(substring3));
                }
                throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
            }
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
    }

    public static byte[] strictUrlSafeDecode(String str) throws JwtInvalidException {
        int i11 = 0;
        while (i11 < str.length()) {
            if (isValidUrlsafeBase64Char(str.charAt(i11))) {
                i11++;
            } else {
                throw new JwtInvalidException("invalid encoding");
            }
        }
        try {
            return Base64.urlSafeDecode(str);
        } catch (IllegalArgumentException e11) {
            throw new JwtInvalidException("invalid encoding: " + e11);
        }
    }

    public static void validateASCII(String str) throws JwtInvalidException {
        int i11 = 0;
        while (i11 < str.length()) {
            if ((str.charAt(i11) & 128) <= 0) {
                i11++;
            } else {
                throw new JwtInvalidException("Non ascii character");
            }
        }
    }

    private static String validateAlgorithm(String str) throws InvalidAlgorithmParameterException {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 66245349:
                if (str.equals("ES256")) {
                    c11 = 0;
                    break;
                }
                break;
            case 66246401:
                if (str.equals("ES384")) {
                    c11 = 1;
                    break;
                }
                break;
            case 66248104:
                if (str.equals("ES512")) {
                    c11 = 2;
                    break;
                }
                break;
            case 69015912:
                if (str.equals("HS256")) {
                    c11 = 3;
                    break;
                }
                break;
            case 69016964:
                if (str.equals("HS384")) {
                    c11 = 4;
                    break;
                }
                break;
            case 69018667:
                if (str.equals("HS512")) {
                    c11 = 5;
                    break;
                }
                break;
            case 76404080:
                if (str.equals("PS256")) {
                    c11 = 6;
                    break;
                }
                break;
            case 76405132:
                if (str.equals("PS384")) {
                    c11 = 7;
                    break;
                }
                break;
            case 76406835:
                if (str.equals("PS512")) {
                    c11 = 8;
                    break;
                }
                break;
            case 78251122:
                if (str.equals("RS256")) {
                    c11 = 9;
                    break;
                }
                break;
            case 78252174:
                if (str.equals("RS384")) {
                    c11 = 10;
                    break;
                }
                break;
            case 78253877:
                if (str.equals("RS512")) {
                    c11 = 11;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return str;
            default:
                throw new InvalidAlgorithmParameterException("invalid algorithm: " + str);
        }
    }

    public static void validateHeader(String str, Optional<String> optional, Optional<String> optional2, JsonObject jsonObject) throws InvalidAlgorithmParameterException, JwtInvalidException {
        validateAlgorithm(str);
        String stringHeader = getStringHeader(jsonObject, "alg");
        if (!stringHeader.equals(str)) {
            throw new InvalidAlgorithmParameterException(String.format("invalid algorithm; expected %s, got %s", new Object[]{str, stringHeader}));
        } else if (jsonObject.has("crit")) {
            throw new JwtInvalidException("all tokens with crit headers are rejected");
        } else if (!optional.isPresent() || !optional2.isPresent()) {
            boolean has = jsonObject.has("kid");
            if (optional.isPresent()) {
                if (has) {
                    validateKidInHeader(optional.get(), jsonObject);
                } else {
                    throw new JwtInvalidException("missing kid in header");
                }
            }
            if (optional2.isPresent() && has) {
                validateKidInHeader(optional2.get(), jsonObject);
            }
        } else {
            throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
        }
    }

    private static void validateKidInHeader(String str, JsonObject jsonObject) throws JwtInvalidException {
        if (!getStringHeader(jsonObject, "kid").equals(str)) {
            throw new JwtInvalidException("invalid kid in header");
        }
    }

    public static void validateUtf8(byte[] bArr) throws JwtInvalidException {
        try {
            StandardCharsets.UTF_8.newDecoder().decode(ByteBuffer.wrap(bArr));
        } catch (CharacterCodingException e11) {
            throw new JwtInvalidException(e11.getMessage());
        }
    }
}
