package com.talabat.gem.ports.presentation;

import com.talabat.gem.ports.presentation.GemTiersViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemOfferTitleViewPort;", "Lcom/talabat/gem/ports/presentation/GemTiersViewPort;", "bindTitleData", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindTitleData", "()Lkotlin/Unit;", "bindUserName", "getBindUserName", "titleData", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/ports/presentation/TitleData;", "getTitleData", "()Lio/reactivex/subjects/BehaviorSubject;", "userName", "", "getUserName", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemOfferTitleViewPort extends GemTiersViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemOfferTitleViewPort gemOfferTitleViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemTiersViewPort.DefaultImpls.autoDispose(gemOfferTitleViewPort, function0);
        }

        public static void onCleared(@NotNull GemOfferTitleViewPort gemOfferTitleViewPort) {
            GemTiersViewPort.DefaultImpls.onCleared(gemOfferTitleViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemOfferTitleViewPort gemOfferTitleViewPort) {
            GemTiersViewPort.DefaultImpls.onClearedImplementation(gemOfferTitleViewPort);
        }
    }

    @NotNull
    Unit getBindTitleData();

    @NotNull
    Unit getBindUserName();

    @NotNull
    BehaviorSubject<TitleData> getTitleData();

    @NotNull
    BehaviorSubject<String> getUserName();
}
