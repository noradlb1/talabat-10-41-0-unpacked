package splitties.fragmentargs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\"\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0002\u0010\fJ*\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010R\u0010\u0010\u0005\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0011"}, d2 = {"Lsplitties/fragmentargs/FragmentArgOrDefaultDelegate;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "Landroidx/fragment/app/Fragment;", "defaultValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "splitties-fragmentargs_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class FragmentArgOrDefaultDelegate<T> implements ReadWriteProperty<Fragment, T> {
    @NotNull
    private final T defaultValue;

    public FragmentArgOrDefaultDelegate(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "defaultValue");
        this.defaultValue = t11;
    }

    @NotNull
    public T getValue(@NotNull Fragment fragment, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(fragment, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Bundle arguments = fragment.getArguments();
        T t11 = arguments == null ? null : arguments.get(kProperty.getName());
        return t11 == null ? this.defaultValue : t11;
    }

    public void setValue(@NotNull Fragment fragment, @NotNull KProperty<?> kProperty, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(fragment, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(t11, "value");
        FragmentArgsKt.putArg(fragment, kProperty.getName(), t11);
    }
}
