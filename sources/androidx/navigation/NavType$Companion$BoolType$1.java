package androidx.navigation;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"androidx/navigation/NavType$Companion$BoolType$1", "Landroidx/navigation/NavType;", "", "name", "", "getName", "()Ljava/lang/String;", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Boolean;", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Boolean;", "put", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavType$Companion$BoolType$1 extends NavType<Boolean> {
    public NavType$Companion$BoolType$1() {
        super(false);
    }

    @NotNull
    public String getName() {
        return TypedValues.Custom.S_BOOLEAN;
    }

    public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Object obj) {
        put(bundle, str, ((Boolean) obj).booleanValue());
    }

    @Nullable
    public Boolean get(@NotNull Bundle bundle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        return (Boolean) bundle.get(str);
    }

    @NotNull
    public Boolean parseValue(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "value");
        if (Intrinsics.areEqual((Object) str, (Object) "true")) {
            z11 = true;
        } else if (Intrinsics.areEqual((Object) str, (Object) "false")) {
            z11 = false;
        } else {
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }
        return Boolean.valueOf(z11);
    }

    public void put(@NotNull Bundle bundle, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putBoolean(str, z11);
    }
}
