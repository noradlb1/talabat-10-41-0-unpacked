package com.talabat.gem.ports.presentation;

import com.talabat.gem.ports.presentation.GemViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemHelpViewPort;", "Lcom/talabat/gem/ports/presentation/GemViewPort;", "howItWorksVisibility", "Lio/reactivex/subjects/BehaviorSubject;", "", "getHowItWorksVisibility$annotations", "()V", "getHowItWorksVisibility", "()Lio/reactivex/subjects/BehaviorSubject;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "removed in the new component")
public interface GemHelpViewPort extends GemViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemHelpViewPort gemHelpViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemViewPort.DefaultImpls.autoDispose(gemHelpViewPort, function0);
        }

        @Deprecated(message = "not active any more")
        public static /* synthetic */ void getHowItWorksVisibility$annotations() {
        }

        public static void onCleared(@NotNull GemHelpViewPort gemHelpViewPort) {
            GemViewPort.DefaultImpls.onCleared(gemHelpViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemHelpViewPort gemHelpViewPort) {
            GemViewPort.DefaultImpls.onClearedImplementation(gemHelpViewPort);
        }
    }

    @NotNull
    BehaviorSubject<Boolean> getHowItWorksVisibility();
}
