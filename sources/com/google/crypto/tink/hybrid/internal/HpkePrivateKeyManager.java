package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.HpkeAead;
import com.google.crypto.tink.proto.HpkeKdf;
import com.google.crypto.tink.proto.HpkeKem;
import com.google.crypto.tink.proto.HpkeKeyFormat;
import com.google.crypto.tink.proto.HpkeParams;
import com.google.crypto.tink.proto.HpkePrivateKey;
import com.google.crypto.tink.proto.HpkePublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.subtle.X25519;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class HpkePrivateKeyManager extends PrivateKeyTypeManager<HpkePrivateKey, HpkePublicKey> {
    public HpkePrivateKeyManager() {
        super(HpkePrivateKey.class, HpkePublicKey.class, new PrimitiveFactory<HybridDecrypt, HpkePrivateKey>(HybridDecrypt.class) {
            public HybridDecrypt getPrimitive(HpkePrivateKey hpkePrivateKey) throws GeneralSecurityException {
                return HpkeDecrypt.createHpkeDecrypt(hpkePrivateKey);
            }
        });
    }

    /* access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<HpkeKeyFormat> createKeyFormat(HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>((HpkeKeyFormat) HpkeKeyFormat.newBuilder().setParams((HpkeParams) HpkeParams.newBuilder().setKem(hpkeKem).setKdf(hpkeKdf).setAead(hpkeAead).build()).build(), outputPrefixType);
    }

    public static void registerPair(boolean z11) throws GeneralSecurityException {
        Registry.registerAsymmetricKeyManagers(new HpkePrivateKeyManager(), new HpkePublicKeyManager(), z11);
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    public int getVersion() {
        return 0;
    }

    public KeyTypeManager.KeyFactory<HpkeKeyFormat, HpkePrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<HpkeKeyFormat, HpkePrivateKey>(HpkeKeyFormat.class) {
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<HpkeKeyFormat>> keyFormats() {
                HashMap hashMap = new HashMap();
                HpkeKem hpkeKem = HpkeKem.DHKEM_X25519_HKDF_SHA256;
                HpkeKdf hpkeKdf = HpkeKdf.HKDF_SHA256;
                HpkeAead hpkeAead = HpkeAead.AES_128_GCM;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", HpkePrivateKeyManager.createKeyFormat(hpkeKem, hpkeKdf, hpkeAead, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(hpkeKem, hpkeKdf, hpkeAead, outputPrefixType2));
                HpkeAead hpkeAead2 = HpkeAead.AES_256_GCM;
                hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", HpkePrivateKeyManager.createKeyFormat(hpkeKem, hpkeKdf, hpkeAead2, outputPrefixType));
                hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(hpkeKem, hpkeKdf, hpkeAead2, outputPrefixType2));
                HpkeAead hpkeAead3 = HpkeAead.CHACHA20_POLY1305;
                hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", HpkePrivateKeyManager.createKeyFormat(hpkeKem, hpkeKdf, hpkeAead3, outputPrefixType));
                hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", HpkePrivateKeyManager.createKeyFormat(hpkeKem, hpkeKdf, hpkeAead3, outputPrefixType2));
                HpkeKem hpkeKem2 = HpkeKem.DHKEM_P256_HKDF_SHA256;
                hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", HpkePrivateKeyManager.createKeyFormat(hpkeKem2, hpkeKdf, hpkeAead, outputPrefixType));
                hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(hpkeKem2, hpkeKdf, hpkeAead, outputPrefixType2));
                hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", HpkePrivateKeyManager.createKeyFormat(hpkeKem2, hpkeKdf, hpkeAead2, outputPrefixType));
                hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(hpkeKem2, hpkeKdf, hpkeAead2, outputPrefixType2));
                HpkeKem hpkeKem3 = HpkeKem.DHKEM_P384_HKDF_SHA384;
                HpkeKdf hpkeKdf2 = HpkeKdf.HKDF_SHA384;
                hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", HpkePrivateKeyManager.createKeyFormat(hpkeKem3, hpkeKdf2, hpkeAead, outputPrefixType));
                hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(hpkeKem3, hpkeKdf2, hpkeAead, outputPrefixType2));
                hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", HpkePrivateKeyManager.createKeyFormat(hpkeKem3, hpkeKdf2, hpkeAead2, outputPrefixType));
                hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(hpkeKem3, hpkeKdf2, hpkeAead2, outputPrefixType2));
                HpkeKem hpkeKem4 = HpkeKem.DHKEM_P521_HKDF_SHA512;
                HpkeKdf hpkeKdf3 = HpkeKdf.HKDF_SHA512;
                hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", HpkePrivateKeyManager.createKeyFormat(hpkeKem4, hpkeKdf3, hpkeAead, outputPrefixType));
                hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(hpkeKem4, hpkeKdf3, hpkeAead, outputPrefixType2));
                hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", HpkePrivateKeyManager.createKeyFormat(hpkeKem4, hpkeKdf3, hpkeAead2, outputPrefixType));
                hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(hpkeKem4, hpkeKdf3, hpkeAead2, outputPrefixType2));
                return Collections.unmodifiableMap(hashMap);
            }

            public HpkePrivateKey createKey(HpkeKeyFormat hpkeKeyFormat) throws GeneralSecurityException {
                byte[] generatePrivateKey = X25519.generatePrivateKey();
                byte[] publicFromPrivate = X25519.publicFromPrivate(generatePrivateKey);
                return (HpkePrivateKey) HpkePrivateKey.newBuilder().setVersion(HpkePrivateKeyManager.this.getVersion()).setPublicKey((HpkePublicKey) HpkePublicKey.newBuilder().setVersion(HpkePrivateKeyManager.this.getVersion()).setParams(hpkeKeyFormat.getParams()).setPublicKey(ByteString.copyFrom(publicFromPrivate)).build()).setPrivateKey(ByteString.copyFrom(generatePrivateKey)).build();
            }

            public HpkeKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return HpkeKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(HpkeKeyFormat hpkeKeyFormat) throws GeneralSecurityException {
                HpkeUtil.validateParams(hpkeKeyFormat.getParams());
            }
        };
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    public HpkePublicKey getPublicKey(HpkePrivateKey hpkePrivateKey) {
        return hpkePrivateKey.getPublicKey();
    }

    public HpkePrivateKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return HpkePrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(HpkePrivateKey hpkePrivateKey) throws GeneralSecurityException {
        if (hpkePrivateKey.getPrivateKey().isEmpty()) {
            throw new GeneralSecurityException("Private key is empty.");
        } else if (hpkePrivateKey.hasPublicKey()) {
            Validators.validateVersion(hpkePrivateKey.getVersion(), getVersion());
            HpkeUtil.validateParams(hpkePrivateKey.getPublicKey().getParams());
        } else {
            throw new GeneralSecurityException("Missing public key.");
        }
    }
}
