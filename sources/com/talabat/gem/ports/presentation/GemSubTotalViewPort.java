package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.usecases.SubTotalLineOne;
import com.talabat.gem.domain.usecases.SubTotalLineTwo;
import com.talabat.gem.ports.presentation.GemTiersViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemSubTotalViewPort;", "Lcom/talabat/gem/ports/presentation/GemTiersViewPort;", "bindCurrency", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindCurrency", "()Lkotlin/Unit;", "bindSubTitleLineOne", "getBindSubTitleLineOne", "bindSubTitleLineTwo", "getBindSubTitleLineTwo", "bindSubTotalVisibility", "getBindSubTotalVisibility", "currency", "Lio/reactivex/subjects/BehaviorSubject;", "", "getCurrency", "()Lio/reactivex/subjects/BehaviorSubject;", "subTitleLineOne", "Lcom/talabat/gem/domain/usecases/SubTotalLineOne;", "getSubTitleLineOne", "subTitleLineTwo", "Lcom/talabat/gem/domain/usecases/SubTotalLineTwo;", "getSubTitleLineTwo", "subTotal", "", "getSubTotal", "subTotalVisibility", "", "getSubTotalVisibility", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemSubTotalViewPort extends GemTiersViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemSubTotalViewPort gemSubTotalViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemTiersViewPort.DefaultImpls.autoDispose(gemSubTotalViewPort, function0);
        }

        public static void onCleared(@NotNull GemSubTotalViewPort gemSubTotalViewPort) {
            GemTiersViewPort.DefaultImpls.onCleared(gemSubTotalViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemSubTotalViewPort gemSubTotalViewPort) {
            GemTiersViewPort.DefaultImpls.onClearedImplementation(gemSubTotalViewPort);
        }
    }

    @NotNull
    Unit getBindCurrency();

    @NotNull
    Unit getBindSubTitleLineOne();

    @NotNull
    Unit getBindSubTitleLineTwo();

    @NotNull
    Unit getBindSubTotalVisibility();

    @NotNull
    BehaviorSubject<String> getCurrency();

    @NotNull
    BehaviorSubject<SubTotalLineOne> getSubTitleLineOne();

    @NotNull
    BehaviorSubject<SubTotalLineTwo> getSubTitleLineTwo();

    @NotNull
    BehaviorSubject<Double> getSubTotal();

    @NotNull
    BehaviorSubject<Boolean> getSubTotalVisibility();
}
