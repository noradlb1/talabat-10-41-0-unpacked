package androidx.navigation;

import android.os.Bundle;
import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"androidx/navigation/NavType$Companion$LongType$1", "Landroidx/navigation/NavType;", "", "name", "", "getName", "()Ljava/lang/String;", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Long;", "put", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavType$Companion$LongType$1 extends NavType<Long> {
    public NavType$Companion$LongType$1() {
        super(false);
    }

    @NotNull
    public String getName() {
        return Constants.LONG;
    }

    public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Object obj) {
        put(bundle, str, ((Number) obj).longValue());
    }

    @NotNull
    public Long get(@NotNull Bundle bundle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = bundle.get(str);
        if (obj != null) {
            return Long.valueOf(((Long) obj).longValue());
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    @NotNull
    public Long parseValue(@NotNull String str) {
        String str2;
        long j11;
        Intrinsics.checkNotNullParameter(str, "value");
        if (StringsKt__StringsJVMKt.endsWith$default(str, "L", false, 2, (Object) null)) {
            str2 = str.substring(0, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str2 = str;
        }
        if (StringsKt__StringsJVMKt.startsWith$default(str, "0x", false, 2, (Object) null)) {
            String substring = str2.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            j11 = Long.parseLong(substring, CharsKt__CharJVMKt.checkRadix(16));
        } else {
            j11 = Long.parseLong(str2);
        }
        return Long.valueOf(j11);
    }

    public void put(@NotNull Bundle bundle, @NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putLong(str, j11);
    }
}
