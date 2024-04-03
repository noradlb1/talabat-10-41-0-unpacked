package com.talabat.feature.ulaccountinfo.presentation.channels;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J,\u0010\u0005\u001a\u00020\u00032\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/ulaccountinfo/presentation/channels/AccountInfoMethodChannelCallback;", "", "closeAccountInfoScreen", "", "logOutAndClearCache", "saveSuccessResult", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "com_talabat_feature_ul-account-info_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AccountInfoMethodChannelCallback {
    void closeAccountInfoScreen();

    void logOutAndClearCache();

    void saveSuccessResult(@NotNull HashMap<String, Object> hashMap);
}
