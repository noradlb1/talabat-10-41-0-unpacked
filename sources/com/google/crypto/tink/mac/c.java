package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.Serialization;

public final /* synthetic */ class c implements KeySerializer.KeySerializationFunction {
    public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
        return AesCmacProtoSerialization.serializeKey((AesCmacKey) key, secretKeyAccess);
    }
}
