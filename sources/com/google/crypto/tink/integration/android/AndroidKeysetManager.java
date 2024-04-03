package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.util.Log;
import androidx.annotation.ChecksSdkIntAtLeast;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.annotation.concurrent.GuardedBy;

public final class AndroidKeysetManager {
    /* access modifiers changed from: private */
    public static final String TAG = "AndroidKeysetManager";
    @GuardedBy("this")
    private KeysetManager keysetManager;
    private final Aead masterKey;
    private final KeysetWriter writer;

    /* renamed from: com.google.crypto.tink.integration.android.AndroidKeysetManager$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.crypto.tink.proto.OutputPrefixType[] r0 = com.google.crypto.tink.proto.OutputPrefixType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r0
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.TINK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.LEGACY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.RAW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeysetManager.AnonymousClass1.<clinit>():void");
        }
    }

    public /* synthetic */ AndroidKeysetManager(Builder builder, AnonymousClass1 r22) throws GeneralSecurityException, IOException {
        this(builder);
    }

    /* access modifiers changed from: private */
    public static KeyTemplate.OutputPrefixType fromProto(OutputPrefixType outputPrefixType) {
        int i11 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i11 == 1) {
            return KeyTemplate.OutputPrefixType.TINK;
        }
        if (i11 == 2) {
            return KeyTemplate.OutputPrefixType.LEGACY;
        }
        if (i11 == 3) {
            return KeyTemplate.OutputPrefixType.RAW;
        }
        if (i11 == 4) {
            return KeyTemplate.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    /* access modifiers changed from: private */
    @ChecksSdkIntAtLeast(api = 23)
    public static boolean isAtLeastM() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 23)
    private boolean shouldUseKeystore() {
        return this.masterKey != null && isAtLeastM();
    }

    private void write(KeysetManager keysetManager2) throws GeneralSecurityException {
        try {
            if (shouldUseKeystore()) {
                keysetManager2.getKeysetHandle().write(this.writer, this.masterKey);
            } else {
                CleartextKeysetHandle.write(keysetManager2.getKeysetHandle(), this.writer);
            }
        } catch (IOException e11) {
            throw new GeneralSecurityException(e11);
        }
    }

    @GuardedBy("this")
    @Deprecated
    public synchronized AndroidKeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeysetManager add = this.keysetManager.add(keyTemplate);
        this.keysetManager = add;
        write(add);
        return this;
    }

    public synchronized AndroidKeysetManager delete(int i11) throws GeneralSecurityException {
        KeysetManager delete = this.keysetManager.delete(i11);
        this.keysetManager = delete;
        write(delete);
        return this;
    }

    public synchronized AndroidKeysetManager destroy(int i11) throws GeneralSecurityException {
        KeysetManager destroy = this.keysetManager.destroy(i11);
        this.keysetManager = destroy;
        write(destroy);
        return this;
    }

    public synchronized AndroidKeysetManager disable(int i11) throws GeneralSecurityException {
        KeysetManager disable = this.keysetManager.disable(i11);
        this.keysetManager = disable;
        write(disable);
        return this;
    }

    public synchronized AndroidKeysetManager enable(int i11) throws GeneralSecurityException {
        KeysetManager enable = this.keysetManager.enable(i11);
        this.keysetManager = enable;
        write(enable);
        return this;
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        return this.keysetManager.getKeysetHandle();
    }

    public synchronized boolean isUsingKeystore() {
        return shouldUseKeystore();
    }

    @Deprecated
    public synchronized AndroidKeysetManager promote(int i11) throws GeneralSecurityException {
        return setPrimary(i11);
    }

    @Deprecated
    public synchronized AndroidKeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeysetManager rotate = this.keysetManager.rotate(keyTemplate);
        this.keysetManager = rotate;
        write(rotate);
        return this;
    }

    public synchronized AndroidKeysetManager setPrimary(int i11) throws GeneralSecurityException {
        KeysetManager primary = this.keysetManager.setPrimary(i11);
        this.keysetManager = primary;
        write(primary);
        return this;
    }

    public static final class Builder {
        private KeyStore keyStore = null;
        private KeyTemplate keyTemplate = null;
        /* access modifiers changed from: private */
        @GuardedBy("this")
        public KeysetManager keysetManager;
        /* access modifiers changed from: private */
        public Aead masterKey = null;
        private String masterKeyUri = null;
        private KeysetReader reader = null;
        private boolean useKeystore = true;
        /* access modifiers changed from: private */
        public KeysetWriter writer = null;

        private KeysetManager read() throws GeneralSecurityException, IOException {
            Aead aead = this.masterKey;
            if (aead != null) {
                try {
                    return KeysetManager.withKeysetHandle(KeysetHandle.read(this.reader, aead));
                } catch (InvalidProtocolBufferException | GeneralSecurityException e11) {
                    Log.w(AndroidKeysetManager.TAG, "cannot decrypt keyset: ", e11);
                }
            }
            return KeysetManager.withKeysetHandle(CleartextKeysetHandle.read(this.reader));
        }

        private KeysetManager readOrGenerateNewKeyset() throws GeneralSecurityException, IOException {
            try {
                return read();
            } catch (FileNotFoundException e11) {
                if (Log.isLoggable(AndroidKeysetManager.TAG, 4)) {
                    Log.i(AndroidKeysetManager.TAG, String.format("keyset not found, will generate a new one. %s", new Object[]{e11.getMessage()}));
                }
                if (this.keyTemplate != null) {
                    KeysetManager add = KeysetManager.withEmptyKeyset().add(this.keyTemplate);
                    KeysetManager primary = add.setPrimary(add.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
                    if (this.masterKey != null) {
                        primary.getKeysetHandle().write(this.writer, this.masterKey);
                    } else {
                        CleartextKeysetHandle.write(primary.getKeysetHandle(), this.writer);
                    }
                    return primary;
                }
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
        }

        private Aead readOrGenerateNewMasterKey() throws GeneralSecurityException {
            AndroidKeystoreKmsClient androidKeystoreKmsClient;
            if (!AndroidKeysetManager.isAtLeastM()) {
                Log.w(AndroidKeysetManager.TAG, "Android Keystore requires at least Android M");
                return null;
            }
            if (this.keyStore != null) {
                androidKeystoreKmsClient = new AndroidKeystoreKmsClient.Builder().setKeyStore(this.keyStore).build();
            } else {
                androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
            }
            boolean hasKey = androidKeystoreKmsClient.hasKey(this.masterKeyUri);
            if (!hasKey) {
                try {
                    AndroidKeystoreKmsClient.generateNewAeadKey(this.masterKeyUri);
                } catch (GeneralSecurityException | ProviderException e11) {
                    Log.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e11);
                    return null;
                }
            }
            try {
                return androidKeystoreKmsClient.getAead(this.masterKeyUri);
            } catch (GeneralSecurityException | ProviderException e12) {
                if (!hasKey) {
                    Log.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e12);
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.masterKeyUri}), e12);
            }
        }

        public synchronized AndroidKeysetManager build() throws GeneralSecurityException, IOException {
            if (this.masterKeyUri != null) {
                this.masterKey = readOrGenerateNewMasterKey();
            }
            this.keysetManager = readOrGenerateNewKeyset();
            return new AndroidKeysetManager(this, (AnonymousClass1) null);
        }

        @Deprecated
        public Builder doNotUseKeystore() {
            this.masterKeyUri = null;
            this.useKeystore = false;
            return this;
        }

        public Builder withKeyStore(KeyStore keyStore2) {
            this.keyStore = keyStore2;
            return this;
        }

        @Deprecated
        public Builder withKeyTemplate(com.google.crypto.tink.proto.KeyTemplate keyTemplate2) {
            this.keyTemplate = KeyTemplate.create(keyTemplate2.getTypeUrl(), keyTemplate2.getValue().toByteArray(), AndroidKeysetManager.fromProto(keyTemplate2.getOutputPrefixType()));
            return this;
        }

        public Builder withMasterKeyUri(String str) {
            if (!str.startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            } else if (this.useKeystore) {
                this.masterKeyUri = str;
                return this;
            } else {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
        }

        public Builder withSharedPref(Context context, String str, String str2) throws IOException {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            } else if (str != null) {
                this.reader = new SharedPrefKeysetReader(context, str, str2);
                this.writer = new SharedPrefKeysetWriter(context, str, str2);
                return this;
            } else {
                throw new IllegalArgumentException("need a keyset name");
            }
        }

        public Builder withKeyTemplate(KeyTemplate keyTemplate2) {
            this.keyTemplate = keyTemplate2;
            return this;
        }
    }

    private AndroidKeysetManager(Builder builder) throws GeneralSecurityException, IOException {
        this.writer = builder.writer;
        this.masterKey = builder.masterKey;
        this.keysetManager = builder.keysetManager;
    }

    @GuardedBy("this")
    public synchronized AndroidKeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeysetManager add = this.keysetManager.add(keyTemplate);
        this.keysetManager = add;
        write(add);
        return this;
    }
}
