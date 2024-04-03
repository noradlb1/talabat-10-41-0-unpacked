package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetQPayDeflectionSavedCardUseCase$invoke$binsCsv$1 extends Lambda implements Function1<TokenisationCreditCard, CharSequence> {
    public static final GetQPayDeflectionSavedCardUseCase$invoke$binsCsv$1 INSTANCE = new GetQPayDeflectionSavedCardUseCase$invoke$binsCsv$1();

    public GetQPayDeflectionSavedCardUseCase$invoke$binsCsv$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull TokenisationCreditCard tokenisationCreditCard) {
        Intrinsics.checkNotNullParameter(tokenisationCreditCard, "it");
        String str = tokenisationCreditCard.binNumber;
        Intrinsics.checkNotNullExpressionValue(str, "it.binNumber");
        return str;
    }
}
