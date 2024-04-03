package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesEaxKey;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesEaxJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class AesEaxKeyManager extends KeyTypeManager<AesEaxKey> {
    public AesEaxKeyManager() {
        super(AesEaxKey.class, new PrimitiveFactory<Aead, AesEaxKey>(Aead.class) {
            public Aead getPrimitive(AesEaxKey aesEaxKey) throws GeneralSecurityException {
                return new AesEaxJce(aesEaxKey.getKeyValue().toByteArray(), aesEaxKey.getParams().getIvSize());
            }
        });
    }

    @Deprecated
    public static final KeyTemplate aes128EaxTemplate() {
        return createKeyTemplate(16, 16, KeyTemplate.OutputPrefixType.TINK);
    }

    @Deprecated
    public static final KeyTemplate aes256EaxTemplate() {
        return createKeyTemplate(32, 16, KeyTemplate.OutputPrefixType.TINK);
    }

    /* access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<AesEaxKeyFormat> createKeyFormat(int i11, int i12, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>((AesEaxKeyFormat) AesEaxKeyFormat.newBuilder().setKeySize(i11).setParams((AesEaxParams) AesEaxParams.newBuilder().setIvSize(i12).build()).build(), outputPrefixType);
    }

    private static KeyTemplate createKeyTemplate(int i11, int i12, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.create(new AesEaxKeyManager().getKeyType(), ((AesEaxKeyFormat) AesEaxKeyFormat.newBuilder().setKeySize(i11).setParams((AesEaxParams) AesEaxParams.newBuilder().setIvSize(i12).build()).build()).toByteArray(), outputPrefixType);
    }

    @Deprecated
    public static final KeyTemplate rawAes128EaxTemplate() {
        return createKeyTemplate(16, 16, KeyTemplate.OutputPrefixType.RAW);
    }

    @Deprecated
    public static final KeyTemplate rawAes256EaxTemplate() {
        return createKeyTemplate(32, 16, KeyTemplate.OutputPrefixType.RAW);
    }

    public static void register(boolean z11) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesEaxKeyManager(), z11);
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public int getVersion() {
        return 0;
    }

    public KeyTypeManager.KeyFactory<AesEaxKeyFormat, AesEaxKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesEaxKeyFormat, AesEaxKey>(AesEaxKeyFormat.class) {
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<AesEaxKeyFormat>> keyFormats() throws GeneralSecurityException {
                HashMap hashMap = new HashMap();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                hashMap.put("AES128_EAX", AesEaxKeyManager.createKeyFormat(16, 16, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                hashMap.put("AES128_EAX_RAW", AesEaxKeyManager.createKeyFormat(16, 16, outputPrefixType2));
                hashMap.put("AES256_EAX", AesEaxKeyManager.createKeyFormat(32, 16, outputPrefixType));
                hashMap.put("AES256_EAX_RAW", AesEaxKeyManager.createKeyFormat(32, 16, outputPrefixType2));
                return Collections.unmodifiableMap(hashMap);
            }

            public AesEaxKey createKey(AesEaxKeyFormat aesEaxKeyFormat) throws GeneralSecurityException {
                return (AesEaxKey) AesEaxKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesEaxKeyFormat.getKeySize()))).setParams(aesEaxKeyFormat.getParams()).setVersion(AesEaxKeyManager.this.getVersion()).build();
            }

            public AesEaxKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesEaxKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(AesEaxKeyFormat aesEaxKeyFormat) throws GeneralSecurityException {
                Validators.validateAesKeySize(aesEaxKeyFormat.getKeySize());
                if (aesEaxKeyFormat.getParams().getIvSize() != 12 && aesEaxKeyFormat.getParams().getIvSize() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
            }
        };
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public AesEaxKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesEaxKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(AesEaxKey aesEaxKey) throws GeneralSecurityException {
        Validators.validateVersion(aesEaxKey.getVersion(), getVersion());
        Validators.validateAesKeySize(aesEaxKey.getKeyValue().size());
        if (aesEaxKey.getParams().getIvSize() != 12 && aesEaxKey.getParams().getIvSize() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
