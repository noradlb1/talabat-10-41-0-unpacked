package com.google.crypto.tink;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.LegacyProtoParameters;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.monitoring.MonitoringAnnotations;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.internal.InternalKeyHandle;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

public final class KeysetHandle {
    private final MonitoringAnnotations annotations;
    private final Keyset keyset;

    /* renamed from: com.google.crypto.tink.KeysetHandle$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.crypto.tink.proto.KeyStatusType[] r0 = com.google.crypto.tink.proto.KeyStatusType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = r0
                com.google.crypto.tink.proto.KeyStatusType r1 = com.google.crypto.tink.proto.KeyStatusType.ENABLED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$KeyStatusType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.proto.KeyStatusType r1 = com.google.crypto.tink.proto.KeyStatusType.DISABLED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$KeyStatusType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.proto.KeyStatusType r1 = com.google.crypto.tink.proto.KeyStatusType.DESTROYED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.KeysetHandle.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder {
        private final List<Entry> entries = new ArrayList();

        public static final class Entry {
            /* access modifiers changed from: private */
            @Nullable
            public Builder builder;
            /* access modifiers changed from: private */
            public boolean isPrimary;
            /* access modifiers changed from: private */
            @Nullable
            public final Key key;
            /* access modifiers changed from: private */
            public KeyStatus keyStatus;
            /* access modifiers changed from: private */
            @Nullable
            public final Parameters parameters;
            /* access modifiers changed from: private */
            public KeyIdStrategy strategy;

            public /* synthetic */ Entry(Key key2, AnonymousClass1 r22) {
                this(key2);
            }

            public KeyStatus getStatus() {
                return this.keyStatus;
            }

            public boolean isPrimary() {
                return this.isPrimary;
            }

            public Entry makePrimary() {
                Builder builder2 = this.builder;
                if (builder2 != null) {
                    builder2.clearPrimary();
                }
                this.isPrimary = true;
                return this;
            }

            public Entry setStatus(KeyStatus keyStatus2) {
                this.keyStatus = keyStatus2;
                return this;
            }

            public Entry withFixedId(int i11) {
                this.strategy = KeyIdStrategy.fixedId(i11);
                return this;
            }

            public Entry withRandomId() {
                this.strategy = KeyIdStrategy.randomId();
                return this;
            }

            public /* synthetic */ Entry(Parameters parameters2, AnonymousClass1 r22) {
                this(parameters2);
            }

            private Entry(Key key2) {
                this.keyStatus = KeyStatus.ENABLED;
                this.strategy = null;
                this.builder = null;
                this.key = key2;
                this.parameters = null;
            }

            private Entry(Parameters parameters2) {
                this.keyStatus = KeyStatus.ENABLED;
                this.strategy = null;
                this.builder = null;
                this.key = null;
                this.parameters = parameters2;
            }
        }

        private static void checkIdAssignments(List<Entry> list) throws GeneralSecurityException {
            int i11 = 0;
            while (i11 < list.size() - 1) {
                if (list.get(i11).strategy != KeyIdStrategy.RANDOM_ID || list.get(i11 + 1).strategy == KeyIdStrategy.RANDOM_ID) {
                    i11++;
                } else {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
        }

        /* access modifiers changed from: private */
        public void clearPrimary() {
            for (Entry access$302 : this.entries) {
                boolean unused = access$302.isPrimary = false;
            }
        }

        private static Keyset.Key createKeyFromParameters(Parameters parameters, int i11, KeyStatusType keyStatusType) throws GeneralSecurityException {
            ProtoParametersSerialization protoParametersSerialization;
            if (parameters instanceof LegacyProtoParameters) {
                protoParametersSerialization = ((LegacyProtoParameters) parameters).getSerialization();
            } else {
                protoParametersSerialization = (ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(parameters, ProtoParametersSerialization.class);
            }
            return (Keyset.Key) Keyset.Key.newBuilder().setKeyId(i11).setStatus(keyStatusType).setKeyData(Registry.newKeyData(protoParametersSerialization.getKeyTemplate())).setOutputPrefixType(protoParametersSerialization.getKeyTemplate().getOutputPrefixType()).build();
        }

        private static Keyset.Key createKeysetKeyFromBuilderEntry(Entry entry, int i11) throws GeneralSecurityException {
            ProtoKeySerialization protoKeySerialization;
            if (entry.key == null) {
                return createKeyFromParameters(entry.parameters, i11, KeysetHandle.serializeStatus(entry.getStatus()));
            }
            if (entry.key instanceof LegacyProtoKey) {
                protoKeySerialization = ((LegacyProtoKey) entry.key).getSerialization(InsecureSecretKeyAccess.get());
            } else {
                protoKeySerialization = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(entry.key, ProtoKeySerialization.class, InsecureSecretKeyAccess.get());
            }
            Integer idRequirementOrNull = protoKeySerialization.getIdRequirementOrNull();
            if (idRequirementOrNull == null || idRequirementOrNull.intValue() == i11) {
                return KeysetHandle.toKeysetKey(i11, KeysetHandle.serializeStatus(entry.getStatus()), protoKeySerialization);
            }
            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
        }

        private static int getNextIdFromBuilderEntry(Entry entry, Set<Integer> set) throws GeneralSecurityException {
            if (entry.strategy == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            } else if (entry.strategy == KeyIdStrategy.RANDOM_ID) {
                return randomIdNotInSet(set);
            } else {
                return entry.strategy.getFixedId();
            }
        }

        private static int randomIdNotInSet(Set<Integer> set) {
            int i11 = 0;
            while (true) {
                if (i11 != 0 && !set.contains(Integer.valueOf(i11))) {
                    return i11;
                }
                i11 = Util.randKeyId();
            }
        }

        public Builder addEntry(Entry entry) {
            if (entry.builder == null) {
                if (entry.isPrimary) {
                    clearPrimary();
                }
                Builder unused = entry.builder = this;
                this.entries.add(entry);
                return this;
            }
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }

        public KeysetHandle build() throws GeneralSecurityException {
            Keyset.Builder newBuilder = Keyset.newBuilder();
            checkIdAssignments(this.entries);
            HashSet hashSet = new HashSet();
            Integer num = null;
            for (Entry next : this.entries) {
                if (next.keyStatus != null) {
                    int nextIdFromBuilderEntry = getNextIdFromBuilderEntry(next, hashSet);
                    if (!hashSet.contains(Integer.valueOf(nextIdFromBuilderEntry))) {
                        hashSet.add(Integer.valueOf(nextIdFromBuilderEntry));
                        newBuilder.addKey(createKeysetKeyFromBuilderEntry(next, nextIdFromBuilderEntry));
                        if (next.isPrimary) {
                            if (num == null) {
                                num = Integer.valueOf(nextIdFromBuilderEntry);
                            } else {
                                throw new GeneralSecurityException("Two primaries were set");
                            }
                        }
                    } else {
                        throw new GeneralSecurityException("Id " + nextIdFromBuilderEntry + " is used twice in the keyset");
                    }
                } else {
                    throw new GeneralSecurityException("Key Status not set.");
                }
            }
            if (num != null) {
                newBuilder.setPrimaryKeyId(num.intValue());
                return new KeysetHandle((Keyset) newBuilder.build(), (AnonymousClass1) null);
            }
            throw new GeneralSecurityException("No primary was set");
        }

        public Entry getAt(int i11) {
            return this.entries.get(i11);
        }

        public Entry removeAt(int i11) {
            return this.entries.remove(i11);
        }

        public int size() {
            return this.entries.size();
        }

        public static class KeyIdStrategy {
            /* access modifiers changed from: private */
            public static final KeyIdStrategy RANDOM_ID = new KeyIdStrategy();
            private final int fixedId;

            private KeyIdStrategy() {
                this.fixedId = 0;
            }

            /* access modifiers changed from: private */
            public static KeyIdStrategy fixedId(int i11) {
                return new KeyIdStrategy(i11);
            }

            /* access modifiers changed from: private */
            public int getFixedId() {
                return this.fixedId;
            }

            /* access modifiers changed from: private */
            public static KeyIdStrategy randomId() {
                return RANDOM_ID;
            }

            private KeyIdStrategy(int i11) {
                this.fixedId = i11;
            }
        }
    }

    @Immutable
    @Alpha
    public static final class Entry {

        /* renamed from: id  reason: collision with root package name */
        private final int f47301id;
        private final boolean isPrimary;
        private final Key key;
        private final KeyStatus keyStatus;

        public /* synthetic */ Entry(Key key2, KeyStatus keyStatus2, int i11, boolean z11, AnonymousClass1 r52) {
            this(key2, keyStatus2, i11, z11);
        }

        public int getId() {
            return this.f47301id;
        }

        public Key getKey() {
            return this.key;
        }

        public KeyStatus getStatus() {
            return this.keyStatus;
        }

        public boolean isPrimary() {
            return this.isPrimary;
        }

        private Entry(Key key2, KeyStatus keyStatus2, int i11, boolean z11) {
            this.key = key2;
            this.keyStatus = keyStatus2;
            this.f47301id = i11;
            this.isPrimary = z11;
        }
    }

    public /* synthetic */ KeysetHandle(Keyset keyset2, AnonymousClass1 r22) {
        this(keyset2);
    }

    private static void assertEnoughEncryptedKeyMaterial(EncryptedKeyset encryptedKeyset) throws GeneralSecurityException {
        if (encryptedKeyset == null || encryptedKeyset.getEncryptedKeyset().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static void assertEnoughKeyMaterial(Keyset keyset2) throws GeneralSecurityException {
        if (keyset2 == null || keyset2.getKeyCount() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void assertNoSecretKeyMaterial(com.google.crypto.tink.proto.Keyset r4) throws java.security.GeneralSecurityException {
        /*
            java.util.List r4 = r4.getKeyList()
            java.util.Iterator r4 = r4.iterator()
        L_0x0008:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0062
            java.lang.Object r0 = r4.next()
            com.google.crypto.tink.proto.Keyset$Key r0 = (com.google.crypto.tink.proto.Keyset.Key) r0
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL
            if (r1 == r2) goto L_0x0039
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.SYMMETRIC
            if (r1 == r2) goto L_0x0039
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE
            if (r1 == r2) goto L_0x0039
            goto L_0x0008
        L_0x0039:
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.google.crypto.tink.proto.KeyData r2 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = r2.getKeyMaterialType()
            java.lang.String r2 = r2.name()
            r3 = 0
            r1[r3] = r2
            com.google.crypto.tink.proto.KeyData r0 = r0.getKeyData()
            java.lang.String r0 = r0.getTypeUrl()
            r2 = 1
            r1[r2] = r0
            java.lang.String r0 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r0, r1)
            r4.<init>(r0)
            throw r4
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.KeysetHandle.assertNoSecretKeyMaterial(com.google.crypto.tink.proto.Keyset):void");
    }

    @Deprecated
    public static final KeysetHandle createFromKey(KeyHandle keyHandle, KeyAccess keyAccess) throws GeneralSecurityException {
        KeysetManager add = KeysetManager.withEmptyKeyset().add(keyHandle);
        add.setPrimary(add.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
        return add.getKeysetHandle();
    }

    private static KeyData createPublicKeyData(KeyData keyData) throws GeneralSecurityException {
        if (keyData.getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
            KeyData publicKeyData = Registry.getPublicKeyData(keyData.getTypeUrl(), keyData.getValue());
            validate(publicKeyData);
            return publicKeyData;
        }
        throw new GeneralSecurityException("The keyset contains a non-private key");
    }

    private static Keyset decrypt(EncryptedKeyset encryptedKeyset, Aead aead, byte[] bArr) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(aead.decrypt(encryptedKeyset.getEncryptedKeyset().toByteArray(), bArr), ExtensionRegistryLite.getEmptyRegistry());
            assertEnoughKeyMaterial(parseFrom);
            return parseFrom;
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static EncryptedKeyset encrypt(Keyset keyset2, Aead aead, byte[] bArr) throws GeneralSecurityException {
        byte[] encrypt = aead.encrypt(keyset2.toByteArray(), bArr);
        try {
            if (Keyset.parseFrom(aead.decrypt(encrypt, bArr), ExtensionRegistryLite.getEmptyRegistry()).equals(keyset2)) {
                return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(encrypt)).setKeysetInfo(Util.getKeysetInfo(keyset2)).build();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private Entry entryByIndex(int i11) {
        boolean z11;
        Keyset.Key key = this.keyset.getKey(i11);
        int keyId = key.getKeyId();
        Key parseKeyWithLegacyFallback = MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(toProtoKeySerialization(key), InsecureSecretKeyAccess.get());
        try {
            KeyStatus parseStatus = parseStatus(key.getStatus());
            if (keyId == this.keyset.getPrimaryKeyId()) {
                z11 = true;
            } else {
                z11 = false;
            }
            return new Entry(parseKeyWithLegacyFallback, parseStatus, keyId, z11, (AnonymousClass1) null);
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException("Creating an entry failed", e11);
        }
    }

    public static final KeysetHandle fromKeyset(Keyset keyset2) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset2);
        return new KeysetHandle(keyset2);
    }

    public static final KeysetHandle fromKeysetAndAnnotations(Keyset keyset2, MonitoringAnnotations monitoringAnnotations) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset2);
        return new KeysetHandle(keyset2, monitoringAnnotations);
    }

    public static Builder.Entry generateEntryFromParameters(Parameters parameters) {
        return new Builder.Entry(parameters, (AnonymousClass1) null);
    }

    public static Builder.Entry generateEntryFromParametersName(String str) throws GeneralSecurityException {
        if (Registry.keyTemplateMap().containsKey(str)) {
            return new Builder.Entry(MutableSerializationRegistry.globalInstance().parseParametersWithLegacyFallback(ProtoParametersSerialization.create(Registry.keyTemplateMap().get(str).getProto())), (AnonymousClass1) null);
        }
        throw new GeneralSecurityException("cannot find key template: " + str);
    }

    @Deprecated
    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return KeysetManager.withEmptyKeyset().rotate(keyTemplate).getKeysetHandle();
    }

    private <B, P> P getPrimitiveWithKnownInputPrimitive(Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        Util.validateKeyset(this.keyset);
        PrimitiveSet.Builder<P> newBuilder = PrimitiveSet.newBuilder(cls2);
        newBuilder.setAnnotations(this.annotations);
        for (Keyset.Key next : this.keyset.getKeyList()) {
            if (next.getStatus() == KeyStatusType.ENABLED) {
                Object primitive = Registry.getPrimitive(next.getKeyData(), cls2);
                if (next.getKeyId() == this.keyset.getPrimaryKeyId()) {
                    newBuilder.addPrimaryPrimitive(primitive, next);
                } else {
                    newBuilder.addPrimitive(primitive, next);
                }
            }
        }
        return Registry.wrap(newBuilder.build(), cls);
    }

    public static Builder.Entry importKey(Key key) {
        Builder.Entry entry = new Builder.Entry(key, (AnonymousClass1) null);
        Integer idRequirementOrNull = key.getIdRequirementOrNull();
        if (idRequirementOrNull != null) {
            entry.withFixedId(idRequirementOrNull.intValue());
        }
        return entry;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private static KeyStatus parseStatus(KeyStatusType keyStatusType) throws GeneralSecurityException {
        int i11 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusType.ordinal()];
        if (i11 == 1) {
            return KeyStatus.ENABLED;
        }
        if (i11 == 2) {
            return KeyStatus.DISABLED;
        }
        if (i11 == 3) {
            return KeyStatus.DESTROYED;
        }
        throw new GeneralSecurityException("Unknown key status");
    }

    public static final KeysetHandle read(KeysetReader keysetReader, Aead aead) throws GeneralSecurityException, IOException {
        return readWithAssociatedData(keysetReader, aead, new byte[0]);
    }

    public static final KeysetHandle readNoSecret(KeysetReader keysetReader) throws GeneralSecurityException, IOException {
        try {
            Keyset read = keysetReader.read();
            assertNoSecretKeyMaterial(read);
            return fromKeyset(read);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final KeysetHandle readWithAssociatedData(KeysetReader keysetReader, Aead aead, byte[] bArr) throws GeneralSecurityException, IOException {
        EncryptedKeyset readEncrypted = keysetReader.readEncrypted();
        assertEnoughEncryptedKeyMaterial(readEncrypted);
        return new KeysetHandle(decrypt(readEncrypted, aead, bArr));
    }

    /* access modifiers changed from: private */
    public static KeyStatusType serializeStatus(KeyStatus keyStatus) {
        if (KeyStatus.ENABLED.equals(keyStatus)) {
            return KeyStatusType.ENABLED;
        }
        if (KeyStatus.DISABLED.equals(keyStatus)) {
            return KeyStatusType.DISABLED;
        }
        if (KeyStatus.DESTROYED.equals(keyStatus)) {
            return KeyStatusType.DESTROYED;
        }
        throw new IllegalStateException("Unknown key status");
    }

    /* access modifiers changed from: private */
    public static Keyset.Key toKeysetKey(int i11, KeyStatusType keyStatusType, ProtoKeySerialization protoKeySerialization) {
        return (Keyset.Key) Keyset.Key.newBuilder().setKeyData(KeyData.newBuilder().setTypeUrl(protoKeySerialization.getTypeUrl()).setValue(protoKeySerialization.getValue()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType())).setStatus(keyStatusType).setKeyId(i11).setOutputPrefixType(protoKeySerialization.getOutputPrefixType()).build();
    }

    public static ProtoKeySerialization toProtoKeySerialization(Keyset.Key key) {
        Integer num;
        int keyId = key.getKeyId();
        if (key.getOutputPrefixType() == OutputPrefixType.RAW) {
            num = null;
        } else {
            num = Integer.valueOf(keyId);
        }
        try {
            return ProtoKeySerialization.create(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), key.getKeyData().getKeyMaterialType(), key.getOutputPrefixType(), num);
        } catch (GeneralSecurityException e11) {
            throw new TinkBugException("Creating a protokey serialization failed", e11);
        }
    }

    private static void validate(KeyData keyData) throws GeneralSecurityException {
        Registry.getPrimitive(keyData);
    }

    public Entry getAt(int i11) {
        if (i11 >= 0 && i11 < size()) {
            return entryByIndex(i11);
        }
        throw new IndexOutOfBoundsException("Invalid index " + i11 + " for keyset of size " + size());
    }

    public List<KeyHandle> getKeys() {
        ArrayList arrayList = new ArrayList();
        for (Keyset.Key next : this.keyset.getKeyList()) {
            arrayList.add(new InternalKeyHandle(new ProtoKey(next.getKeyData(), KeyTemplate.fromProto(next.getOutputPrefixType())), next.getStatus(), next.getKeyId()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Keyset getKeyset() {
        return this.keyset;
    }

    public KeysetInfo getKeysetInfo() {
        return Util.getKeysetInfo(this.keyset);
    }

    public Entry getPrimary() {
        for (int i11 = 0; i11 < this.keyset.getKeyCount(); i11++) {
            if (this.keyset.getKey(i11).getKeyId() == this.keyset.getPrimaryKeyId()) {
                Entry entryByIndex = entryByIndex(i11);
                if (entryByIndex.getStatus() == KeyStatus.ENABLED) {
                    return entryByIndex;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no primary");
    }

    public <P> P getPrimitive(Class<P> cls) throws GeneralSecurityException {
        Class<?> inputPrimitive = Registry.getInputPrimitive(cls);
        if (inputPrimitive != null) {
            return getPrimitiveWithKnownInputPrimitive(cls, inputPrimitive);
        }
        throw new GeneralSecurityException("No wrapper found for " + cls.getName());
    }

    public KeysetHandle getPublicKeysetHandle() throws GeneralSecurityException {
        if (this.keyset != null) {
            Keyset.Builder newBuilder = Keyset.newBuilder();
            for (Keyset.Key next : this.keyset.getKeyList()) {
                newBuilder.addKey((Keyset.Key) ((Keyset.Key.Builder) next.toBuilder()).setKeyData(createPublicKeyData(next.getKeyData())).build());
            }
            newBuilder.setPrimaryKeyId(this.keyset.getPrimaryKeyId());
            return new KeysetHandle((Keyset) newBuilder.build());
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    public KeyHandle primaryKey() throws GeneralSecurityException {
        int primaryKeyId = this.keyset.getPrimaryKeyId();
        for (Keyset.Key next : this.keyset.getKeyList()) {
            if (next.getKeyId() == primaryKeyId) {
                return new InternalKeyHandle(new ProtoKey(next.getKeyData(), KeyTemplate.fromProto(next.getOutputPrefixType())), next.getStatus(), next.getKeyId());
            }
        }
        throw new GeneralSecurityException("No primary key found in keyset.");
    }

    public int size() {
        return this.keyset.getKeyCount();
    }

    public String toString() {
        return getKeysetInfo().toString();
    }

    public void write(KeysetWriter keysetWriter, Aead aead) throws GeneralSecurityException, IOException {
        writeWithAssociatedData(keysetWriter, aead, new byte[0]);
    }

    public void writeNoSecret(KeysetWriter keysetWriter) throws GeneralSecurityException, IOException {
        assertNoSecretKeyMaterial(this.keyset);
        keysetWriter.write(this.keyset);
    }

    public void writeWithAssociatedData(KeysetWriter keysetWriter, Aead aead, byte[] bArr) throws GeneralSecurityException, IOException {
        keysetWriter.write(encrypt(this.keyset, aead, bArr));
    }

    private KeysetHandle(Keyset keyset2) {
        this.keyset = keyset2;
        this.annotations = MonitoringAnnotations.EMPTY;
    }

    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return KeysetManager.withEmptyKeyset().rotate(keyTemplate.getProto()).getKeysetHandle();
    }

    public static Builder newBuilder(KeysetHandle keysetHandle) {
        Builder builder = new Builder();
        for (int i11 = 0; i11 < keysetHandle.size(); i11++) {
            Entry entryByIndex = keysetHandle.entryByIndex(i11);
            Builder.Entry withFixedId = importKey(entryByIndex.getKey()).withFixedId(entryByIndex.getId());
            withFixedId.setStatus(entryByIndex.getStatus());
            if (entryByIndex.isPrimary()) {
                withFixedId.makePrimary();
            }
            builder.addEntry(withFixedId);
        }
        return builder;
    }

    private KeysetHandle(Keyset keyset2, MonitoringAnnotations monitoringAnnotations) {
        this.keyset = keyset2;
        this.annotations = monitoringAnnotations;
    }

    public static final KeysetHandle readNoSecret(byte[] bArr) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry());
            assertNoSecretKeyMaterial(parseFrom);
            return fromKeyset(parseFrom);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
