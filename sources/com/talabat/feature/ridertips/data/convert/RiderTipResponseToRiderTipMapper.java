package com.talabat.feature.ridertips.data.convert;

import com.talabat.feature.ridertips.data.remote.dto.RiderTipDto;
import com.talabat.feature.ridertips.data.remote.dto.TermDto;
import com.talabat.feature.ridertips.data.remote.dto.TermsDto;
import com.talabat.feature.ridertips.data.remote.dto.TipChoices;
import com.talabat.feature.ridertips.data.remote.dto.TipDto;
import com.talabat.feature.ridertips.domain.model.RiderTip;
import com.talabat.feature.ridertips.domain.model.Term;
import com.talabat.feature.ridertips.domain.model.Terms;
import com.talabat.feature.ridertips.domain.model.Tip;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/ridertips/data/convert/RiderTipResponseToRiderTipMapper;", "Lcom/talabat/feature/ridertips/data/convert/IRiderTipResponseToRiderTipMapper;", "()V", "map", "Lcom/talabat/feature/ridertips/domain/model/RiderTip;", "source", "Lcom/talabat/feature/ridertips/data/remote/dto/RiderTipDto;", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipResponseToRiderTipMapper implements IRiderTipResponseToRiderTipMapper {
    @NotNull
    public RiderTip map(@NotNull RiderTipDto riderTipDto) {
        Double d11;
        Double d12;
        Double d13;
        ArrayList arrayList;
        Boolean bool;
        String str;
        String str2;
        List<TermDto> contents;
        List<TipChoices> tipChoices;
        TipDto tip;
        Intrinsics.checkNotNullParameter(riderTipDto, "source");
        String title = riderTipDto.getTitle();
        String subtitle = riderTipDto.getSubtitle();
        TipDto tip2 = riderTipDto.getTip();
        ArrayList arrayList2 = null;
        if (tip2 != null) {
            d11 = tip2.getPreferred();
        } else {
            d11 = null;
        }
        if (!Intrinsics.areEqual(d11, 0.0d) && (tip = riderTipDto.getTip()) != null) {
            d12 = tip.getPreferred();
        } else {
            d12 = null;
        }
        TipDto tip3 = riderTipDto.getTip();
        if (tip3 != null) {
            d13 = tip3.getThreshold();
        } else {
            d13 = null;
        }
        TipDto tip4 = riderTipDto.getTip();
        if (tip4 == null || (tipChoices = tip4.getTipChoices()) == null) {
            arrayList = null;
        } else {
            Iterable<TipChoices> iterable = tipChoices;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (TipChoices tipChoices2 : iterable) {
                arrayList.add(new com.talabat.feature.ridertips.domain.model.TipChoices(tipChoices2.getAmount(), tipChoices2.getEmoji()));
            }
        }
        TipDto tip5 = riderTipDto.getTip();
        if (tip5 != null) {
            bool = tip5.isDefaultTipEnabled();
        } else {
            bool = null;
        }
        Tip tip6 = new Tip(d13, d12, arrayList, bool);
        TermsDto terms = riderTipDto.getTerms();
        if (terms != null) {
            str = terms.getTitle();
        } else {
            str = null;
        }
        TermsDto terms2 = riderTipDto.getTerms();
        if (terms2 != null) {
            str2 = terms2.getDescription();
        } else {
            str2 = null;
        }
        TermsDto terms3 = riderTipDto.getTerms();
        if (!(terms3 == null || (contents = terms3.getContents()) == null)) {
            Iterable<TermDto> iterable2 = contents;
            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
            for (TermDto termDto : iterable2) {
                arrayList2.add(new Term(termDto.getKeyword(), termDto.getText()));
            }
        }
        return new RiderTip(title, subtitle, tip6, new Terms(str, str2, arrayList2));
    }
}
