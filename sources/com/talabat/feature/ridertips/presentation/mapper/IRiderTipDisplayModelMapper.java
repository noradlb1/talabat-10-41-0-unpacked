package com.talabat.feature.ridertips.presentation.mapper;

import com.talabat.feature.ridertips.domain.model.Terms;
import com.talabat.feature.ridertips.domain.model.Tip;
import com.talabat.feature.ridertips.presentation.displaymodel.CtaMode;
import com.talabat.feature.ridertips.presentation.displaymodel.TermsDisplayModel;
import com.talabat.feature.ridertips.presentation.displaymodel.TipOptionsDetailsDisplayModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/mapper/IRiderTipDisplayModelMapper;", "", "getDisplayCustomTipValue", "", "tipValue", "", "(Ljava/lang/Double;)Ljava/lang/String;", "getDisplayTipValue", "tipEmoji", "(Ljava/lang/Double;Ljava/lang/String;)Ljava/lang/String;", "getStringBasedOnCta", "", "ctaMode", "Lcom/talabat/feature/ridertips/presentation/displaymodel/CtaMode;", "mapTermsToTermsDisplayModel", "Lcom/talabat/feature/ridertips/presentation/displaymodel/TermsDisplayModel;", "terms", "Lcom/talabat/feature/ridertips/domain/model/Terms;", "mapTipToTipOptionsViewState", "Lcom/talabat/feature/ridertips/presentation/displaymodel/TipOptionsDetailsDisplayModel;", "tip", "Lcom/talabat/feature/ridertips/domain/model/Tip;", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IRiderTipDisplayModelMapper {
    @NotNull
    String getDisplayCustomTipValue(@Nullable Double d11);

    @NotNull
    String getDisplayTipValue(@Nullable Double d11, @Nullable String str);

    int getStringBasedOnCta(@NotNull CtaMode ctaMode);

    @Nullable
    TermsDisplayModel mapTermsToTermsDisplayModel(@NotNull Terms terms);

    @Nullable
    TipOptionsDetailsDisplayModel mapTipToTipOptionsViewState(@NotNull Tip tip);
}
