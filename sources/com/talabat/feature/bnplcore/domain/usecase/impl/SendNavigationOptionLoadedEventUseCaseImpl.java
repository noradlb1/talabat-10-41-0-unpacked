package com.talabat.feature.bnplcore.domain.usecase.impl;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.bnplcore.domain.model.BnplNavigationOptionLoadedEvent;
import com.talabat.feature.bnplcore.domain.model.BnplNavigationOptionLoadedEventKt;
import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pl.b;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/impl/SendNavigationOptionLoadedEventUseCaseImpl;", "Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "invoke", "Lio/reactivex/Completable;", "eventOrigin", "", "screenName", "screenType", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendNavigationOptionLoadedEventUseCaseImpl implements SendNavigationOptionLoadedEventUseCase {
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public SendNavigationOptionLoadedEventUseCaseImpl(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m10144invoke$lambda1(SendNavigationOptionLoadedEventUseCaseImpl sendNavigationOptionLoadedEventUseCaseImpl, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(sendNavigationOptionLoadedEventUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$eventOrigin");
        Intrinsics.checkNotNullParameter(str2, "$screenName");
        Intrinsics.checkNotNullParameter(str3, "$screenType");
        sendNavigationOptionLoadedEventUseCaseImpl.talabatTracker.track(new BnplNavigationOptionLoadedEvent(str, BnplNavigationOptionLoadedEventKt.VALUE_NAVIGATION_OPTION_BNPL_MISSED_PAYMENT, str2, str3));
    }

    @NotNull
    public Completable invoke(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "screenType");
        Completable fromAction = Completable.fromAction(new b(this, str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(fromAction, "fromAction {\n        tal…        )\n        }\n    }");
        return fromAction;
    }
}
