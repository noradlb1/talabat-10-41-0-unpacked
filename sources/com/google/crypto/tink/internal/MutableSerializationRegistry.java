package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.SerializationRegistry;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

public final class MutableSerializationRegistry {
    private static final MutableSerializationRegistry GLOBAL_INSTANCE = new MutableSerializationRegistry();
    private final AtomicReference<SerializationRegistry> registry = new AtomicReference<>(new SerializationRegistry.Builder().build());

    public static MutableSerializationRegistry globalInstance() {
        return GLOBAL_INSTANCE;
    }

    public <SerializationT extends Serialization> Key parseKey(SerializationT serializationt, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return this.registry.get().parseKey(serializationt, secretKeyAccess);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        return new com.google.crypto.tink.internal.LegacyProtoKey(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.google.crypto.tink.internal.TinkBugException("Creating a LegacyProtoKey failed", r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.crypto.tink.Key parseKeyWithLegacyFallback(com.google.crypto.tink.internal.ProtoKeySerialization r2, com.google.crypto.tink.SecretKeyAccess r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0016
            com.google.crypto.tink.Key r2 = r1.parseKey(r2, r3)     // Catch:{ GeneralSecurityException -> 0x0007 }
            return r2
        L_0x0007:
            com.google.crypto.tink.internal.LegacyProtoKey r0 = new com.google.crypto.tink.internal.LegacyProtoKey     // Catch:{ GeneralSecurityException -> 0x000d }
            r0.<init>(r2, r3)     // Catch:{ GeneralSecurityException -> 0x000d }
            return r0
        L_0x000d:
            r2 = move-exception
            com.google.crypto.tink.internal.TinkBugException r3 = new com.google.crypto.tink.internal.TinkBugException
            java.lang.String r0 = "Creating a LegacyProtoKey failed"
            r3.<init>(r0, r2)
            throw r3
        L_0x0016:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "access cannot be null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.internal.MutableSerializationRegistry.parseKeyWithLegacyFallback(com.google.crypto.tink.internal.ProtoKeySerialization, com.google.crypto.tink.SecretKeyAccess):com.google.crypto.tink.Key");
    }

    public <SerializationT extends Serialization> Parameters parseParameters(SerializationT serializationt) throws GeneralSecurityException {
        return this.registry.get().parseParameters(serializationt);
    }

    public Parameters parseParametersWithLegacyFallback(ProtoParametersSerialization protoParametersSerialization) {
        try {
            return parseParameters(protoParametersSerialization);
        } catch (GeneralSecurityException unused) {
            return new LegacyProtoParameters(protoParametersSerialization);
        }
    }

    public synchronized <SerializationT extends Serialization> void registerKeyParser(KeyParser<SerializationT> keyParser) throws GeneralSecurityException {
        this.registry.set(new SerializationRegistry.Builder(this.registry.get()).registerKeyParser(keyParser).build());
    }

    public synchronized <KeyT extends Key, SerializationT extends Serialization> void registerKeySerializer(KeySerializer<KeyT, SerializationT> keySerializer) throws GeneralSecurityException {
        this.registry.set(new SerializationRegistry.Builder(this.registry.get()).registerKeySerializer(keySerializer).build());
    }

    public synchronized <SerializationT extends Serialization> void registerParametersParser(ParametersParser<SerializationT> parametersParser) throws GeneralSecurityException {
        this.registry.set(new SerializationRegistry.Builder(this.registry.get()).registerParametersParser(parametersParser).build());
    }

    public synchronized <ParametersT extends Parameters, SerializationT extends Serialization> void registerParametersSerializer(ParametersSerializer<ParametersT, SerializationT> parametersSerializer) throws GeneralSecurityException {
        this.registry.set(new SerializationRegistry.Builder(this.registry.get()).registerParametersSerializer(parametersSerializer).build());
    }

    public <KeyT extends Key, SerializationT extends Serialization> SerializationT serializeKey(KeyT keyt, Class<SerializationT> cls, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return this.registry.get().serializeKey(keyt, cls, secretKeyAccess);
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> SerializationT serializeParameters(ParametersT parameterst, Class<SerializationT> cls) throws GeneralSecurityException {
        return this.registry.get().serializeParameters(parameterst, cls);
    }
}
