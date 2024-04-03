package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.ports.presentation.GemAutoTriggerOfferViewPort;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u001a\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004*\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"bindAutoTriggerOffer", "", "Lcom/talabat/gem/ports/presentation/GemAutoTriggerOfferViewPort;", "createGemMode", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/domain/entities/GemMode;", "kotlin.jvm.PlatformType", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemAutoTriggerOfferBusinessRulesKt {
    @BusinessRules
    public static final void bindAutoTriggerOffer(@NotNull GemAutoTriggerOfferViewPort gemAutoTriggerOfferViewPort) {
        Intrinsics.checkNotNullParameter(gemAutoTriggerOfferViewPort, "<this>");
        gemAutoTriggerOfferViewPort.autoDispose(new GemAutoTriggerOfferBusinessRulesKt$bindAutoTriggerOffer$1(gemAutoTriggerOfferViewPort));
    }

    @NotNull
    @BusinessRules
    public static final BehaviorSubject<GemMode> createGemMode(@NotNull GemAutoTriggerOfferViewPort gemAutoTriggerOfferViewPort) {
        Intrinsics.checkNotNullParameter(gemAutoTriggerOfferViewPort, "<this>");
        BehaviorSubject<GemMode> createDefault = BehaviorSubject.createDefault(GemMode.DISABLED);
        Intrinsics.checkNotNullExpressionValue(createDefault, "createDefault(GemMode.DISABLED)");
        return createDefault;
    }
}
