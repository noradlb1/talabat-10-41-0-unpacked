package com.talabat.talabatcommon.feature.walletCardManagement;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/CardDeleteEventConstants;", "", "()V", "CARD_DELETE_EVENT_ERROR_CODE_KEY", "", "CARD_DELETE_EVENT_ERROR_MESSAGE_KEY", "CARD_DELETE_EVENT_SCREEN_NAME_KEY", "CARD_DELETE_EVENT_SCREEN_NAME_VALUE", "CARD_DELETE_EVENT_SCREEN_TYPE_KEY", "CARD_DELETE_EVENT_SCREEN_TYPE_VALUE", "CARD_DELETION_ERROR_MESSAGE", "CARD_DELETION_EXCEPTION", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CardDeleteEventConstants {
    @NotNull
    public static final String CARD_DELETE_EVENT_ERROR_CODE_KEY = "errorCode";
    @NotNull
    public static final String CARD_DELETE_EVENT_ERROR_MESSAGE_KEY = "errorMessage";
    @NotNull
    public static final String CARD_DELETE_EVENT_SCREEN_NAME_KEY = "screenName";
    @NotNull
    public static final String CARD_DELETE_EVENT_SCREEN_NAME_VALUE = "Manage Cards Screen";
    @NotNull
    public static final String CARD_DELETE_EVENT_SCREEN_TYPE_KEY = "screenType";
    @NotNull
    public static final String CARD_DELETE_EVENT_SCREEN_TYPE_VALUE = "wallet";
    @NotNull
    public static final String CARD_DELETION_ERROR_MESSAGE = "errorMessage";
    @NotNull
    public static final String CARD_DELETION_EXCEPTION = "Card Deletion exception";
    @NotNull
    public static final CardDeleteEventConstants INSTANCE = new CardDeleteEventConstants();

    private CardDeleteEventConstants() {
    }
}
