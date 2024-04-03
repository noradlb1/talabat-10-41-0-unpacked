package com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.mapper;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.mapper.ModelMappingIntegrationKt;
import com.talabat.talabatcommon.utils.DateConstants;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.dto.BenefitBinDetailRemoteDto;
import com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.dto.BenefitBinDetailRemoteResultDto;
import com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.dto.BenefitBinRemoteDto;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBin;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/mapper/BenefitBinMapper;", "", "()V", "filterBenefitBins", "", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "benefitBinsDetail", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/BenefitBinsDetail;", "list", "getBenefitBins", "", "hasSavedCardDeflectionExpired", "", "expiryDate", "stringFormat", "mapToBenefitBin", "benefitBinDetailRemoteDto", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinDetailRemoteDto;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitBinMapper {
    @NotNull
    public static final BenefitBinMapper INSTANCE = new BenefitBinMapper();

    private BenefitBinMapper() {
    }

    @JvmStatic
    public static final boolean hasSavedCardDeflectionExpired(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "expiryDate");
        Intrinsics.checkNotNullParameter(str2, "stringFormat");
        Date date = new Date();
        Date convertFromStringToDate = DateUtils.Companion.convertFromStringToDate(str, str2);
        if (convertFromStringToDate == null || date.getTime() > convertFromStringToDate.getTime()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<TokenisationCreditCard> filterBenefitBins(@NotNull BenefitBinsDetail benefitBinsDetail, @NotNull List<? extends TokenisationCreditCard> list) {
        Intrinsics.checkNotNullParameter(benefitBinsDetail, "benefitBinsDetail");
        Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
        ArrayList arrayList = new ArrayList();
        if (!hasSavedCardDeflectionExpired(benefitBinsDetail.getBenefitCardDeflectionExpiryDate(), DateConstants.DEFAULT_UTC_FORMAT)) {
            return list;
        }
        List<String> benefitBins = getBenefitBins(benefitBinsDetail);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String add : benefitBins) {
            linkedHashSet.add(add);
        }
        for (TokenisationCreditCard tokenisationCreditCard : list) {
            if (!linkedHashSet.contains(tokenisationCreditCard.binNumber)) {
                arrayList.add(tokenisationCreditCard);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<String> getBenefitBins(@NotNull BenefitBinsDetail benefitBinsDetail) {
        Intrinsics.checkNotNullParameter(benefitBinsDetail, "benefitBinsDetail");
        ArrayList arrayList = new ArrayList();
        for (BenefitBin next : benefitBinsDetail.getBinsDetails()) {
            if (next.isBenefitBin()) {
                arrayList.add(next.getBinNumber());
            }
        }
        return arrayList;
    }

    @NotNull
    public final BenefitBinsDetail mapToBenefitBin(@Nullable BenefitBinDetailRemoteDto benefitBinDetailRemoteDto) {
        List<BenefitBinRemoteDto> list;
        BenefitBinDetailRemoteResultDto remoteResultDto;
        BenefitBinDetailRemoteResultDto remoteResultDto2;
        String str = null;
        if (benefitBinDetailRemoteDto == null || (remoteResultDto2 = benefitBinDetailRemoteDto.getRemoteResultDto()) == null) {
            list = null;
        } else {
            list = remoteResultDto2.getBenefitBinRemotes();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (BenefitBinRemoteDto parseFromNullable : list) {
            arrayList.add(ModelMappingIntegrationKt.parseFromNullable(new BenefitBin((String) null, false, (String) null, (String) null, 15, (DefaultConstructorMarker) null), parseFromNullable));
        }
        if (!(benefitBinDetailRemoteDto == null || (remoteResultDto = benefitBinDetailRemoteDto.getRemoteResultDto()) == null)) {
            str = remoteResultDto.getBenefitCardDeflectionExpiryDate();
        }
        if (str == null) {
            str = "";
        }
        return new BenefitBinsDetail(arrayList, str);
    }
}
