package androidx.security.crypto;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.streamingaead.StreamingAeadConfig;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

public final class EncryptedFile {
    private static final String KEYSET_ALIAS = "__androidx_security_crypto_encrypted_file_keyset__";
    private static final String KEYSET_PREF_NAME = "__androidx_security_crypto_encrypted_file_pref__";

    /* renamed from: a  reason: collision with root package name */
    public final File f37561a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f37562b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37563c;

    /* renamed from: d  reason: collision with root package name */
    public final StreamingAead f37564d;

    public static final class EncryptedFileInputStream extends FileInputStream {
        private final InputStream mEncryptedInputStream;
        private final Object mLock = new Object();

        public EncryptedFileInputStream(FileDescriptor fileDescriptor, InputStream inputStream) {
            super(fileDescriptor);
            this.mEncryptedInputStream = inputStream;
        }

        public int available() throws IOException {
            return this.mEncryptedInputStream.available();
        }

        public void close() throws IOException {
            this.mEncryptedInputStream.close();
        }

        public FileChannel getChannel() {
            throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
        }

        public void mark(int i11) {
            synchronized (this.mLock) {
                this.mEncryptedInputStream.mark(i11);
            }
        }

        public boolean markSupported() {
            return this.mEncryptedInputStream.markSupported();
        }

        public int read() throws IOException {
            return this.mEncryptedInputStream.read();
        }

        public void reset() throws IOException {
            synchronized (this.mLock) {
                this.mEncryptedInputStream.reset();
            }
        }

        public long skip(long j11) throws IOException {
            return this.mEncryptedInputStream.skip(j11);
        }

        public int read(@NonNull byte[] bArr) throws IOException {
            return this.mEncryptedInputStream.read(bArr);
        }

        public int read(@NonNull byte[] bArr, int i11, int i12) throws IOException {
            return this.mEncryptedInputStream.read(bArr, i11, i12);
        }
    }

    public static final class EncryptedFileOutputStream extends FileOutputStream {
        private final OutputStream mEncryptedOutputStream;

        public EncryptedFileOutputStream(FileDescriptor fileDescriptor, OutputStream outputStream) {
            super(fileDescriptor);
            this.mEncryptedOutputStream = outputStream;
        }

        public void close() throws IOException {
            this.mEncryptedOutputStream.close();
        }

        public void flush() throws IOException {
            this.mEncryptedOutputStream.flush();
        }

        @NonNull
        public FileChannel getChannel() {
            throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
        }

        public void write(@NonNull byte[] bArr) throws IOException {
            this.mEncryptedOutputStream.write(bArr);
        }

        public void write(int i11) throws IOException {
            this.mEncryptedOutputStream.write(i11);
        }

        public void write(@NonNull byte[] bArr, int i11, int i12) throws IOException {
            this.mEncryptedOutputStream.write(bArr, i11, i12);
        }
    }

    public enum FileEncryptionScheme {
        AES256_GCM_HKDF_4KB("AES256_GCM_HKDF_4KB");
        
        private final String mKeyTemplateName;

        private FileEncryptionScheme(String str) {
            this.mKeyTemplateName = str;
        }

        public KeyTemplate a() throws GeneralSecurityException {
            return KeyTemplates.get(this.mKeyTemplateName);
        }
    }

    public EncryptedFile(@NonNull File file, @NonNull String str, @NonNull StreamingAead streamingAead, @NonNull Context context) {
        this.f37561a = file;
        this.f37562b = context;
        this.f37563c = str;
        this.f37564d = streamingAead;
    }

    @NonNull
    public FileInputStream openFileInput() throws GeneralSecurityException, IOException, FileNotFoundException {
        if (this.f37561a.exists()) {
            FileInputStream fileInputStream = new FileInputStream(this.f37561a);
            return new EncryptedFileInputStream(fileInputStream.getFD(), this.f37564d.newDecryptingStream(fileInputStream, this.f37561a.getName().getBytes(StandardCharsets.UTF_8)));
        }
        throw new FileNotFoundException("file doesn't exist: " + this.f37561a.getName());
    }

    @NonNull
    public FileOutputStream openFileOutput() throws GeneralSecurityException, IOException {
        if (!this.f37561a.exists()) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f37561a);
            return new EncryptedFileOutputStream(fileOutputStream.getFD(), this.f37564d.newEncryptingStream(fileOutputStream, this.f37561a.getName().getBytes(StandardCharsets.UTF_8)));
        }
        throw new IOException("output file already exists, please use a new file: " + this.f37561a.getName());
    }

    public static final class Builder {
        private static Object sLock = new Object();

        /* renamed from: a  reason: collision with root package name */
        public File f37565a;

        /* renamed from: b  reason: collision with root package name */
        public final FileEncryptionScheme f37566b;

        /* renamed from: c  reason: collision with root package name */
        public final Context f37567c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37568d;

        /* renamed from: e  reason: collision with root package name */
        public String f37569e = EncryptedFile.KEYSET_PREF_NAME;

        /* renamed from: f  reason: collision with root package name */
        public String f37570f = EncryptedFile.KEYSET_ALIAS;

        @Deprecated
        public Builder(@NonNull File file, @NonNull Context context, @NonNull String str, @NonNull FileEncryptionScheme fileEncryptionScheme) {
            this.f37565a = file;
            this.f37566b = fileEncryptionScheme;
            this.f37567c = context.getApplicationContext();
            this.f37568d = str;
        }

        @NonNull
        public EncryptedFile build() throws GeneralSecurityException, IOException {
            AndroidKeysetManager build;
            StreamingAeadConfig.register();
            AndroidKeysetManager.Builder withSharedPref = new AndroidKeysetManager.Builder().withKeyTemplate(this.f37566b.a()).withSharedPref(this.f37567c, this.f37570f, this.f37569e);
            AndroidKeysetManager.Builder withMasterKeyUri = withSharedPref.withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + this.f37568d);
            synchronized (sLock) {
                build = withMasterKeyUri.build();
            }
            return new EncryptedFile(this.f37565a, this.f37570f, (StreamingAead) build.getKeysetHandle().getPrimitive(StreamingAead.class), this.f37567c);
        }

        @NonNull
        public Builder setKeysetAlias(@NonNull String str) {
            this.f37570f = str;
            return this;
        }

        @NonNull
        public Builder setKeysetPrefName(@NonNull String str) {
            this.f37569e = str;
            return this;
        }

        @SuppressLint({"StreamFiles"})
        public Builder(@NonNull Context context, @NonNull File file, @NonNull MasterKey masterKey, @NonNull FileEncryptionScheme fileEncryptionScheme) {
            this.f37565a = file;
            this.f37566b = fileEncryptionScheme;
            this.f37567c = context.getApplicationContext();
            this.f37568d = masterKey.a();
        }
    }
}
