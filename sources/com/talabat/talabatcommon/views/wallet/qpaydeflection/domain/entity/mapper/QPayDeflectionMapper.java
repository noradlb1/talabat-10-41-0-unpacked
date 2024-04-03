package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.mapper;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.mapper.ModelMappingIntegrationKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.utils.DateConstants;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto.QPayDeflectionBinDto;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto.QPayDeflectionBinsResponseDto;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto.QPayDeflectionBinsResultDto;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBin;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/entity/mapper/QPayDeflectionMapper;", "", "()V", "filterQPayBins", "", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "qPayDeflectionBinDetail", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/entity/QPayDeflectionBinDetail;", "cardList", "hasSavedCardDeflectionExpired", "", "expiryDate", "", "stringFormat", "mapToQPayDeflectionBinDetail", "qPayDeflectionBinsResponseDto", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayDeflectionBinsResponseDto;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayDeflectionMapper {
    @NotNull
    public static final QPayDeflectionMapper INSTANCE = new QPayDeflectionMapper();

    private QPayDeflectionMapper() {
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
    public final List<TokenisationCreditCard> filterQPayBins(@NotNull QPayDeflectionBinDetail qPayDeflectionBinDetail, @NotNull List<? extends TokenisationCreditCard> list) {
        Boolean bool;
        Object obj;
        Intrinsics.checkNotNullParameter(qPayDeflectionBinDetail, "qPayDeflectionBinDetail");
        Intrinsics.checkNotNullParameter(list, "cardList");
        if (!hasSavedCardDeflectionExpired(qPayDeflectionBinDetail.getQPayBinDeflectionExpiryDate(), DateConstants.DEFAULT_UTC_FORMAT)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            TokenisationCreditCard tokenisationCreditCard = (TokenisationCreditCard) next;
            Iterator it = qPayDeflectionBinDetail.getBinsDetails().iterator();
            while (true) {
                bool = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((QPayDeflectionBin) obj).getBinNumber(), (Object) tokenisationCreditCard.binNumber)) {
                    break;
                }
            }
            QPayDeflectionBin qPayDeflectionBin = (QPayDeflectionBin) obj;
            if (qPayDeflectionBin != null) {
                bool = Boolean.valueOf(!qPayDeflectionBin.isQPayBin());
            }
            if (BooleanKt.orFalse(bool)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public final QPayDeflectionBinDetail mapToQPayDeflectionBinDetail(@Nullable QPayDeflectionBinsResponseDto qPayDeflectionBinsResponseDto) {
        List list;
        QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto;
        QPayDeflectionBinsResultDto qPayDeflectionBinsResultDto2;
        List<QPayDeflectionBinDto> binsDto;
        String str = null;
        if (qPayDeflectionBinsResponseDto == null || (qPayDeflectionBinsResultDto2 = qPayDeflectionBinsResponseDto.getQPayDeflectionBinsResultDto()) == null || (binsDto = qPayDeflectionBinsResultDto2.getBinsDto()) == null) {
            list = null;
        } else {
            Iterable<QPayDeflectionBinDto> iterable = binsDto;
            list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (QPayDeflectionBinDto parseFromNullable : iterable) {
                list.add((QPayDeflectionBin) ModelMappingIntegrationKt.parseFromNullable(new QPayDeflectionBin((String) null, false, 3, (DefaultConstructorMarker) null), parseFromNullable));
            }
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if (!(qPayDeflectionBinsResponseDto == null || (qPayDeflectionBinsResultDto = qPayDeflectionBinsResponseDto.getQPayDeflectionBinsResultDto()) == null)) {
            str = qPayDeflectionBinsResultDto.getSavedCardExpiryDate();
        }
        if (str == null) {
            str = "";
        }
        return new QPayDeflectionBinDetail(list, str);
    }
}
