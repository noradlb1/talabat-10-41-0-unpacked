package com.talabat.feature.ridertips.presentation.mapper;

import androidx.compose.runtime.internal.StabilityInferred;
import com.talabat.feature.ridertips.domain.model.Term;
import com.talabat.feature.ridertips.domain.model.Terms;
import com.talabat.feature.ridertips.domain.model.Tip;
import com.talabat.feature.ridertips.domain.model.TipChoices;
import com.talabat.feature.ridertips.presentation.IResourceProvider;
import com.talabat.feature.ridertips.presentation.displaymodel.CtaMode;
import com.talabat.feature.ridertips.presentation.displaymodel.TermDisplayModel;
import com.talabat.feature.ridertips.presentation.displaymodel.TermsDisplayModel;
import com.talabat.feature.ridertips.presentation.displaymodel.TipOptionDisplayModel;
import com.talabat.feature.ridertips.presentation.displaymodel.TipOptionsDetailsDisplayModel;
import com.talabat.localization.R;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatlife.features.UrlConstantsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B-\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ!\u0010\u0011\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J)\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/mapper/RiderTipDisplayModelMapperImpl;", "Lcom/talabat/feature/ridertips/presentation/mapper/IRiderTipDisplayModelMapper;", "currencySymbol", "", "numOfDecimalPlaces", "", "decimalPattern", "resourceProvider", "Lcom/talabat/feature/ridertips/presentation/IResourceProvider;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/feature/ridertips/presentation/IResourceProvider;)V", "getDecimalPatternFor", "tipValue", "", "(Ljava/lang/Double;)Ljava/lang/String;", "getDecimalPlacesFor", "(Ljava/lang/Double;)I", "getDisplayCustomTipValue", "getDisplayTipValue", "tipEmoji", "(Ljava/lang/Double;Ljava/lang/String;)Ljava/lang/String;", "getEmojiByUnicode", "unicode", "getPreferredTipIndex", "choices", "", "preferred", "(Ljava/util/List;Ljava/lang/Double;)Ljava/lang/Integer;", "getStringBasedOnCta", "ctaMode", "Lcom/talabat/feature/ridertips/presentation/displaymodel/CtaMode;", "mapTermsToTermsDisplayModel", "Lcom/talabat/feature/ridertips/presentation/displaymodel/TermsDisplayModel;", "terms", "Lcom/talabat/feature/ridertips/domain/model/Terms;", "mapTipToTipOptionsViewState", "Lcom/talabat/feature/ridertips/presentation/displaymodel/TipOptionsDetailsDisplayModel;", "tip", "Lcom/talabat/feature/ridertips/domain/model/Tip;", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipDisplayModelMapperImpl implements IRiderTipDisplayModelMapper {
    public static final int $stable = 8;
    @NotNull
    private final String currencySymbol;
    @NotNull
    private final String decimalPattern;
    private final int numOfDecimalPlaces;
    @NotNull
    private final IResourceProvider resourceProvider;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CtaMode.values().length];
            iArr[CtaMode.CLOSE.ordinal()] = 1;
            iArr[CtaMode.APPLY.ordinal()] = 2;
            iArr[CtaMode.Remove.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public RiderTipDisplayModelMapperImpl(@NotNull @Named("currencySymbol") String str, @Named("numOfDecimalPlaces") int i11, @NotNull @Named("decimalPattern") String str2, @NotNull IResourceProvider iResourceProvider) {
        Intrinsics.checkNotNullParameter(str, "currencySymbol");
        Intrinsics.checkNotNullParameter(str2, "decimalPattern");
        Intrinsics.checkNotNullParameter(iResourceProvider, "resourceProvider");
        this.currencySymbol = str;
        this.numOfDecimalPlaces = i11;
        this.decimalPattern = str2;
        this.resourceProvider = iResourceProvider;
    }

    private final String getDecimalPatternFor(Double d11) {
        boolean z11;
        String str = this.decimalPattern;
        if (d11 == null) {
            return str;
        }
        d11.doubleValue();
        if (d11.doubleValue() % 1.0d == 0.0d) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "";
        }
        return str;
    }

    private final int getDecimalPlacesFor(Double d11) {
        boolean z11;
        int i11 = this.numOfDecimalPlaces;
        if (d11 == null) {
            return i11;
        }
        d11.doubleValue();
        if (d11.doubleValue() % 1.0d == 0.0d) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return 0;
        }
        return i11;
    }

    private final String getEmojiByUnicode(String str) {
        try {
            String substring = str.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            char[] chars = Character.toChars(Integer.parseInt(substring, CharsKt__CharJVMKt.checkRadix(16)));
            Intrinsics.checkNotNullExpressionValue(chars, "toChars(code)");
            return new String(chars);
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    private final Integer getPreferredTipIndex(List<Double> list, Double d11) {
        if (d11 == null) {
            return null;
        }
        d11.doubleValue();
        if (list == null) {
            return null;
        }
        Iterator<Double> it = list.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().doubleValue(), d11)) {
                break;
            } else {
                i11++;
            }
        }
        return Integer.valueOf(i11);
    }

    @NotNull
    public String getDisplayCustomTipValue(@Nullable Double d11) {
        if (d11 == null) {
            return this.resourceProvider.getStringForEmptyCustomTip();
        }
        d11.doubleValue();
        return getDisplayTipValue(d11, (String) null);
    }

    @NotNull
    public String getDisplayTipValue(@Nullable Double d11, @Nullable String str) {
        if (d11 == null) {
            return "";
        }
        String formattedCurrency = CurrencyFormatter.Companion.getFormattedCurrency(d11.doubleValue(), true, this.currencySymbol, getDecimalPlacesFor(d11), getDecimalPatternFor(d11));
        if (str == null || !(!StringsKt__StringsJVMKt.isBlank(str))) {
            return formattedCurrency;
        }
        String emojiByUnicode = getEmojiByUnicode(str);
        return formattedCurrency + " " + emojiByUnicode;
    }

    public int getStringBasedOnCta(@NotNull CtaMode ctaMode) {
        Intrinsics.checkNotNullParameter(ctaMode, "ctaMode");
        int i11 = WhenMappings.$EnumSwitchMapping$0[ctaMode.ordinal()];
        if (i11 == 1) {
            return R.string.rider_tip_custom_tip_input_cta_close;
        }
        if (i11 == 2) {
            return R.string.rider_tip_custom_tip_input_cta_apply;
        }
        if (i11 == 3) {
            return R.string.rider_tip_custom_tip_input_cta_remove;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Nullable
    public TermsDisplayModel mapTermsToTermsDisplayModel(@NotNull Terms terms) {
        int i11;
        Intrinsics.checkNotNullParameter(terms, UrlConstantsKt.TLIFE_TERMS_AND_CONDITION_PATH);
        List<Term> contents = terms.getContents();
        if (contents == null) {
            return null;
        }
        String title = terms.getTitle();
        if (title == null) {
            title = "";
        }
        String description = terms.getDescription();
        if (description == null) {
            description = "";
        }
        Iterable<Term> iterable = contents;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Term term : iterable) {
            String text = term.getText();
            if (text == null) {
                text = "";
            }
            String keyword = term.getKeyword();
            if (keyword != null) {
                int hashCode = keyword.hashCode();
                if (hashCode != 3046160) {
                    if (hashCode != 3046195) {
                        if (hashCode == 3172656 && keyword.equals("gift")) {
                            i11 = com.talabat.talabatcommon.R.drawable.ic_tip_rider_gift;
                            arrayList.add(new TermDisplayModel(i11, text));
                        }
                    } else if (keyword.equals("cash")) {
                        i11 = com.talabat.talabatcommon.R.drawable.ic_to_tip_cash;
                        arrayList.add(new TermDisplayModel(i11, text));
                    }
                } else if (keyword.equals("card")) {
                    i11 = com.talabat.talabatcommon.R.drawable.ic_to_tip_rider;
                    arrayList.add(new TermDisplayModel(i11, text));
                }
            }
            i11 = com.talabat.talabatcommon.R.drawable.ic_cancel_primary;
            arrayList.add(new TermDisplayModel(i11, text));
        }
        return new TermsDisplayModel(title, description, arrayList);
    }

    @Nullable
    public TipOptionsDetailsDisplayModel mapTipToTipOptionsViewState(@NotNull Tip tip) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(tip, "tip");
        List<TipChoices> tipChoices = tip.getTipChoices();
        Double d11 = null;
        if (tipChoices == null) {
            return null;
        }
        Iterable<TipChoices> iterable = tipChoices;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TipChoices tipAmount : iterable) {
            arrayList.add(Double.valueOf(tipAmount.getTipAmount()));
        }
        Integer preferredTipIndex = getPreferredTipIndex(arrayList, tip.getPreferred());
        if (preferredTipIndex != null && preferredTipIndex.intValue() == -1) {
            d11 = tip.getPreferred();
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        boolean z13 = false;
        int i11 = 0;
        while (true) {
            boolean z14 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TipChoices tipChoices2 = (TipChoices) next;
            Double valueOf = Double.valueOf(tipChoices2.getTipAmount());
            String displayTipValue = getDisplayTipValue(Double.valueOf(tipChoices2.getTipAmount()), tipChoices2.getEmoji());
            if (preferredTipIndex == null || i11 != preferredTipIndex.intValue()) {
                z14 = false;
            }
            arrayList2.add(new TipOptionDisplayModel(valueOf, displayTipValue, z14, false));
            i11 = i12;
        }
        String displayCustomTipValue = getDisplayCustomTipValue(d11);
        if (d11 != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        List plus = CollectionsKt___CollectionsKt.plus(arrayList2, new TipOptionDisplayModel(d11, displayCustomTipValue, z11, true));
        if (preferredTipIndex != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (preferredTipIndex != null) {
            z13 = true;
        }
        return new TipOptionsDetailsDisplayModel(plus, z12, z13, R.string.rider_tip_reuse_tip);
    }
}
