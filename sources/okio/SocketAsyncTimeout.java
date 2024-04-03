package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class SocketAsyncTimeout extends AsyncTimeout {
    @NotNull
    private final Socket socket;

    public SocketAsyncTimeout(@NotNull Socket socket2) {
        Intrinsics.checkNotNullParameter(socket2, "socket");
        this.socket = socket2;
    }

    @NotNull
    public IOException newTimeoutException(@Nullable IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    public void timedOut() {
        try {
            this.socket.close();
        } catch (Exception e11) {
            Okio__JvmOkioKt.logger.log(Level.WARNING, Intrinsics.stringPlus("Failed to close timed out socket ", this.socket), e11);
        } catch (AssertionError e12) {
            if (Okio.isAndroidGetsocknameError(e12)) {
                Okio__JvmOkioKt.logger.log(Level.WARNING, Intrinsics.stringPlus("Failed to close timed out socket ", this.socket), e12);
                return;
            }
            throw e12;
        }
    }
}
