package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity;

import com.talabat.core.observabilityNew.domain.squads.home.HomeScreenPerformanceParams;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderSource;", "", "screenName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScreenName", "()Ljava/lang/String;", "HOME_SCREEN", "ORDER_CONFIRMATION_SCREEN", "INFO_BOTTOM_SHEET", "DEFAULT", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum TipRiderSource {
    HOME_SCREEN(HomeScreenPerformanceParams.SCREEN_NAME),
    ORDER_CONFIRMATION_SCREEN("orderConfirmationScreen"),
    INFO_BOTTOM_SHEET("InfoBottomSheet"),
    DEFAULT(StringUtils.empty(StringCompanionObject.INSTANCE));
    
    @NotNull
    private final String screenName;

    private TipRiderSource(String str) {
        this.screenName = str;
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }
}
