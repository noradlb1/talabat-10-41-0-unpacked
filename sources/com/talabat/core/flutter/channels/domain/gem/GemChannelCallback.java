package com.talabat.core.flutter.channels.domain.gem;

import android.app.Activity;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H&J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003H&J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H&J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0006H&J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/gem/GemChannelCallback;", "", "getGemData", "", "", "getGemHomeData", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "arguments", "getGemOffersStatus", "getGemRemainingTimeData", "", "getIsGemEnabled", "", "getOrganicListingData", "navigateToGemCollection", "activity", "Landroid/app/Activity;", "navigateToGemPopup", "setGemExpirationDialogShown", "syncOffers", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemChannelCallback {
    @NotNull
    Map<String, Object> getGemData();

    void getGemHomeData(@NotNull MethodChannel.Result result, @Nullable Object obj);

    void getGemOffersStatus(@NotNull MethodChannel.Result result);

    @Nullable
    Map<String, Long> getGemRemainingTimeData();

    boolean getIsGemEnabled(@Nullable Object obj);

    @NotNull
    Map<String, Object> getOrganicListingData();

    void navigateToGemCollection(@NotNull Activity activity);

    void navigateToGemPopup(@Nullable Object obj, @NotNull Activity activity);

    void setGemExpirationDialogShown();

    void syncOffers(@NotNull MethodChannel.Result result, @Nullable Object obj);
}
