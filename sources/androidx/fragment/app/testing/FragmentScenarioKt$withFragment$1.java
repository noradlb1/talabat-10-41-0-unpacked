package androidx.fragment.app.testing;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.testing.FragmentScenario;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "F", "Landroidx/fragment/app/Fragment;", "T", "", "fragment", "perform", "(Landroidx/fragment/app/Fragment;)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class FragmentScenarioKt$withFragment$1<F extends Fragment> implements FragmentScenario.FragmentAction {
    final /* synthetic */ Function1<F, T> $block;
    final /* synthetic */ Ref.ObjectRef<Throwable> $err;
    final /* synthetic */ Ref.ObjectRef<T> $value;

    public FragmentScenarioKt$withFragment$1(Ref.ObjectRef<T> objectRef, Function1<? super F, ? extends T> function1, Ref.ObjectRef<Throwable> objectRef2) {
        this.$value = objectRef;
        this.$block = function1;
        this.$err = objectRef2;
    }

    public final void perform(@NotNull F f11) {
        Intrinsics.checkNotNullParameter(f11, "fragment");
        try {
            this.$value.element = this.$block.invoke(f11);
        } catch (Throwable th2) {
            this.$err.element = th2;
        }
    }
}
