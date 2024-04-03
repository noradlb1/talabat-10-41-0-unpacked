package splitties.fragmentargs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import splitties.bundle.BundleKt;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u0002\u001a-\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u00022\u0006\u0010\u0006\u001a\u0002H\u0003¢\u0006\u0002\u0010\u0007\u001a.\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\t\u001a\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0002\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0000¨\u0006\u0010"}, d2 = {"arg", "Lkotlin/properties/ReadWriteProperty;", "Landroidx/fragment/app/Fragment;", "T", "", "argOrDefault", "defaultValue", "(Landroidx/fragment/app/Fragment;Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "argOrElse", "Lkotlin/Function0;", "argOrNull", "putArg", "", "key", "", "value", "splitties-fragmentargs_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FragmentArgsKt {
    @NotNull
    public static final <T> ReadWriteProperty<Fragment, T> arg(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return FragmentArgDelegate.INSTANCE;
    }

    @NotNull
    public static final <T> ReadWriteProperty<Fragment, T> argOrDefault(@NotNull Fragment fragment, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(t11, "defaultValue");
        return new FragmentArgOrDefaultDelegate(t11);
    }

    @NotNull
    public static final <T> ReadWriteProperty<Fragment, T> argOrElse(@NotNull Fragment fragment, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return new FragmentArgOrElseDelegate(function0);
    }

    @NotNull
    public static final <T> ReadWriteProperty<Fragment, T> argOrNull(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return FragmentArgOrNullDelegate.INSTANCE;
    }

    public static final void putArg(@NotNull Fragment fragment, @NotNull String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            fragment.setArguments(arguments);
        }
        BundleKt.put(arguments, str, obj);
    }
}
