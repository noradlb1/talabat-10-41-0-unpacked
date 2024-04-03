package com.talabat.gem.adapters.presentation;

import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/gem/adapters/presentation/GemView;", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "initialize", "", "getInitialize", "()Ljava/lang/Object;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemView extends AutoDisposable {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemView gemView, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            AutoDisposable.DefaultImpls.autoDispose(gemView, function0);
        }

        public static void onCleared(@NotNull GemView gemView) {
            AutoDisposable.DefaultImpls.onCleared(gemView);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemView gemView) {
            AutoDisposable.DefaultImpls.onClearedImplementation(gemView);
        }
    }

    @NotNull
    Object getInitialize();
}
