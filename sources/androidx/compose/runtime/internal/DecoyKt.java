package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"illegalDecoyCallException", "", "fName", "", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DecoyKt {
    @NotNull
    @ComposeCompilerApi
    public static final Void illegalDecoyCallException(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "fName");
        throw new IllegalStateException("Function " + str + " should have been replaced by compiler.");
    }
}
