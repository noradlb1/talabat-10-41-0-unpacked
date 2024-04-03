package okhttp3;

import com.instabug.library.networkv2.request.Request;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lokhttp3/Credentials;", "", "()V", "basic", "", "username", "password", "charset", "Ljava/nio/charset/Charset;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Credentials {
    @NotNull
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final String basic(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "username");
        Intrinsics.checkNotNullParameter(str2, "password");
        return basic$default(str, str2, (Charset) null, 4, (Object) null);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final String basic(@NotNull String str, @NotNull String str2, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, "username");
        Intrinsics.checkNotNullParameter(str2, "password");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return Intrinsics.stringPlus(Request.BASIC_AUTH_VALUE_PREFIX, ByteString.Companion.encodeString(str + AbstractJsonLexerKt.COLON + str2, charset).base64());
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
            Intrinsics.checkNotNullExpressionValue(charset, "ISO_8859_1");
        }
        return basic(str, str2, charset);
    }
}
