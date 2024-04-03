package splitties.fragmentargs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J%\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¨\u0006\f"}, d2 = {"Lsplitties/fragmentargs/FragmentArgDelegate;", "Lkotlin/properties/ReadWriteProperty;", "Landroidx/fragment/app/Fragment;", "", "()V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "splitties-fragmentargs_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class FragmentArgDelegate implements ReadWriteProperty<Fragment, Object> {
    @NotNull
    public static final FragmentArgDelegate INSTANCE = new FragmentArgDelegate();

    private FragmentArgDelegate() {
    }

    @NotNull
    public Object getValue(@NotNull Fragment fragment, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(fragment, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        String name2 = kProperty.getName();
        Bundle arguments = fragment.getArguments();
        if (arguments != null) {
            Object obj = arguments.get(name2);
            if (obj != null) {
                return obj;
            }
            throw new IllegalStateException(("Property " + name2 + " could not be read").toString());
        }
        throw new IllegalStateException(("Cannot read property " + name2 + " if no arguments have been set").toString());
    }

    public void setValue(@NotNull Fragment fragment, @NotNull KProperty<?> kProperty, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(fragment, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(obj, "value");
        FragmentArgsKt.putArg(fragment, kProperty.getName(), obj);
    }
}
