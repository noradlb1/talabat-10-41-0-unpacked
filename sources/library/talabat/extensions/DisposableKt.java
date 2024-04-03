package library.talabat.extensions;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"plusAssign", "", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lio/reactivex/disposables/Disposable;", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DisposableKt {
    public static final void plusAssign(@NotNull CompositeDisposable compositeDisposable, @NotNull Disposable disposable) {
        Intrinsics.checkNotNullParameter(compositeDisposable, "<this>");
        Intrinsics.checkNotNullParameter(disposable, "disposable");
        compositeDisposable.add(disposable);
    }
}
