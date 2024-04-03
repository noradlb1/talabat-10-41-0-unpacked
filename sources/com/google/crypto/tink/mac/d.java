package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.Serialization;

public final /* synthetic */ class d implements KeyParser.KeyParsingFunction {
    public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
        return AesCmacProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
    }
}
