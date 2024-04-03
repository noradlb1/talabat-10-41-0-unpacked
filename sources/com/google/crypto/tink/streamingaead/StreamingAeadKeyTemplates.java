package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

@Deprecated
public final class StreamingAeadKeyTemplates {
    public static final KeyTemplate AES128_CTR_HMAC_SHA256_1MB;
    public static final KeyTemplate AES128_CTR_HMAC_SHA256_4KB;
    public static final KeyTemplate AES128_GCM_HKDF_1MB;
    public static final KeyTemplate AES128_GCM_HKDF_4KB;
    public static final KeyTemplate AES256_CTR_HMAC_SHA256_1MB;
    public static final KeyTemplate AES256_CTR_HMAC_SHA256_4KB;
    public static final KeyTemplate AES256_GCM_HKDF_1MB;
    public static final KeyTemplate AES256_GCM_HKDF_4KB;

    static {
        HashType hashType = HashType.SHA256;
        AES128_CTR_HMAC_SHA256_4KB = createAesCtrHmacStreamingKeyTemplate(16, hashType, 16, hashType, 32, 4096);
        HashType hashType2 = hashType;
        HashType hashType3 = hashType;
        AES128_CTR_HMAC_SHA256_1MB = createAesCtrHmacStreamingKeyTemplate(16, hashType2, 16, hashType3, 32, 1048576);
        AES256_CTR_HMAC_SHA256_4KB = createAesCtrHmacStreamingKeyTemplate(32, hashType2, 32, hashType3, 32, 4096);
        AES256_CTR_HMAC_SHA256_1MB = createAesCtrHmacStreamingKeyTemplate(32, hashType2, 32, hashType3, 32, 1048576);
        AES128_GCM_HKDF_4KB = createAesGcmHkdfStreamingKeyTemplate(16, hashType, 16, 4096);
        AES128_GCM_HKDF_1MB = createAesGcmHkdfStreamingKeyTemplate(16, hashType, 16, 1048576);
        AES256_GCM_HKDF_4KB = createAesGcmHkdfStreamingKeyTemplate(32, hashType, 32, 4096);
        AES256_GCM_HKDF_1MB = createAesGcmHkdfStreamingKeyTemplate(32, hashType, 32, 1048576);
    }

    private StreamingAeadKeyTemplates() {
    }

    public static KeyTemplate createAesCtrHmacStreamingKeyTemplate(int i11, HashType hashType, int i12, HashType hashType2, int i13, int i14) {
        AesCtrHmacStreamingParams.Builder hkdfHashType = AesCtrHmacStreamingParams.newBuilder().setCiphertextSegmentSize(i14).setDerivedKeySize(i12).setHkdfHashType(hashType);
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((AesCtrHmacStreamingKeyFormat) AesCtrHmacStreamingKeyFormat.newBuilder().setParams((AesCtrHmacStreamingParams) hkdfHashType.setHmacParams((HmacParams) HmacParams.newBuilder().setHash(hashType2).setTagSize(i13).build()).build()).setKeySize(i11).build()).toByteString()).setTypeUrl(new AesCtrHmacStreamingKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    public static KeyTemplate createAesGcmHkdfStreamingKeyTemplate(int i11, HashType hashType, int i12, int i13) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((AesGcmHkdfStreamingKeyFormat) AesGcmHkdfStreamingKeyFormat.newBuilder().setKeySize(i11).setParams((AesGcmHkdfStreamingParams) AesGcmHkdfStreamingParams.newBuilder().setCiphertextSegmentSize(i13).setDerivedKeySize(i12).setHkdfHashType(hashType).build()).build()).toByteString()).setTypeUrl(new AesGcmHkdfStreamingKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }
}
