package com.google.crypto.tink;

import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

@Alpha
class KeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite> implements KeyManager<PrimitiveT> {
    private final KeyTypeManager<KeyProtoT> keyTypeManager;
    private final Class<PrimitiveT> primitiveClass;

    public static class KeyFactoryHelper<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite> {
        final KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory;

        public KeyFactoryHelper(KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory2) {
            this.keyFactory = keyFactory2;
        }

        private KeyProtoT validateCreate(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException {
            this.keyFactory.validateKeyFormat(keyformatprotot);
            return this.keyFactory.createKey(keyformatprotot);
        }

        public KeyProtoT castValidateCreate(MessageLite messageLite) throws GeneralSecurityException {
            return validateCreate((MessageLite) KeyManagerImpl.castOrThrowSecurityException(messageLite, "Expected proto of type " + this.keyFactory.getKeyFormatClass().getName(), this.keyFactory.getKeyFormatClass()));
        }

        public KeyProtoT parseValidateCreate(ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException {
            return validateCreate(this.keyFactory.parseKeyFormat(byteString));
        }
    }

    public KeyManagerImpl(KeyTypeManager<KeyProtoT> keyTypeManager2, Class<PrimitiveT> cls) {
        if (keyTypeManager2.supportedPrimitives().contains(cls) || Void.class.equals(cls)) {
            this.keyTypeManager = keyTypeManager2;
            this.primitiveClass = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{keyTypeManager2.toString(), cls.getName()}));
    }

    /* access modifiers changed from: private */
    public static <CastedT> CastedT castOrThrowSecurityException(Object obj, String str, Class<CastedT> cls) throws GeneralSecurityException {
        if (cls.isInstance(obj)) {
            return obj;
        }
        throw new GeneralSecurityException(str);
    }

    private KeyFactoryHelper<?, KeyProtoT> keyFactoryHelper() {
        return new KeyFactoryHelper<>(this.keyTypeManager.keyFactory());
    }

    private PrimitiveT validateKeyAndGetPrimitive(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.primitiveClass)) {
            this.keyTypeManager.validateKey(keyprotot);
            return this.keyTypeManager.getPrimitive(keyprotot, this.primitiveClass);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    public final boolean doesSupport(String str) {
        return str.equals(getKeyType());
    }

    public final String getKeyType() {
        return this.keyTypeManager.getKeyType();
    }

    public final PrimitiveT getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return validateKeyAndGetPrimitive(this.keyTypeManager.parseKey(byteString));
        } catch (InvalidProtocolBufferException e11) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.keyTypeManager.getKeyClass().getName(), e11);
        }
    }

    public final Class<PrimitiveT> getPrimitiveClass() {
        return this.primitiveClass;
    }

    public int getVersion() {
        return this.keyTypeManager.getVersion();
    }

    public final MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return keyFactoryHelper().parseValidateCreate(byteString);
        } catch (InvalidProtocolBufferException e11) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.keyTypeManager.keyFactory().getKeyFormatClass().getName(), e11);
        }
    }

    public final KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        try {
            return (KeyData) KeyData.newBuilder().setTypeUrl(getKeyType()).setValue(keyFactoryHelper().parseValidateCreate(byteString).toByteString()).setKeyMaterialType(this.keyTypeManager.keyMaterialType()).build();
        } catch (InvalidProtocolBufferException e11) {
            throw new GeneralSecurityException("Unexpected proto", e11);
        }
    }

    public final MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        return keyFactoryHelper().castValidateCreate(messageLite);
    }

    public final PrimitiveT getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        return validateKeyAndGetPrimitive((MessageLite) castOrThrowSecurityException(messageLite, "Expected proto of type " + this.keyTypeManager.getKeyClass().getName(), this.keyTypeManager.getKeyClass()));
    }
}
