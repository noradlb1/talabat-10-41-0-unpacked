package com.deliveryhero.customerchat.commons.encryption;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/deliveryhero/customerchat/commons/encryption/CryptoManager;", "", "decrypt", "", "inputStream", "Ljava/io/InputStream;", "encrypt", "", "bytes", "outputStream", "Ljava/io/OutputStream;", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CryptoManager {
    @NotNull
    public static final String ALGORITHM = "AES";
    @NotNull
    public static final String ALIAS = "ChatSDKCrypto";
    public static final int BYTES_TO_BITS = 8;
    public static final int CHUNK_SIZE = 4096;
    @NotNull
    public static final Companion Companion = Companion.f29817a;
    @NotNull
    public static final String KEYSTORE = "AndroidKeyStore";
    public static final int KEY_SIZE = 16;
    @NotNull
    public static final String TRANSFORMATION = "AES/CBC/PKCS7Padding";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deliveryhero/customerchat/commons/encryption/CryptoManager$Companion;", "", "()V", "ALGORITHM", "", "ALIAS", "BYTES_TO_BITS", "", "CHUNK_SIZE", "KEYSTORE", "KEY_SIZE", "TRANSFORMATION", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        public static final String ALGORITHM = "AES";
        @NotNull
        public static final String ALIAS = "ChatSDKCrypto";
        public static final int BYTES_TO_BITS = 8;
        public static final int CHUNK_SIZE = 4096;
        @NotNull
        public static final String KEYSTORE = "AndroidKeyStore";
        public static final int KEY_SIZE = 16;
        @NotNull
        public static final String TRANSFORMATION = "AES/CBC/PKCS7Padding";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f29817a = new Companion();

        private Companion() {
        }
    }

    @NotNull
    byte[] decrypt(@NotNull InputStream inputStream);

    void encrypt(@NotNull byte[] bArr, @NotNull OutputStream outputStream);
}
