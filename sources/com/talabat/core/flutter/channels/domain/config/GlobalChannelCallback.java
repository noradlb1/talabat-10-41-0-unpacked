package com.talabat.core.flutter.channels.domain.config;

import android.app.Activity;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0016\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H&J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\bH&J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH&J\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0013"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelCallback;", "", "backNavigation", "", "activity", "Landroid/app/Activity;", "configs", "", "", "currentAddress", "environment", "onAttach", "activityName", "channelIdentity", "", "onDetach", "setCustomerInfo", "args", "setPaymentCards", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GlobalChannelCallback {
    void backNavigation(@Nullable Activity activity);

    @NotNull
    Map<String, Object> configs();

    @Nullable
    Map<String, Object> currentAddress();

    @NotNull
    String environment();

    void onAttach(@Nullable String str, int i11);

    void onDetach(@Nullable String str, int i11);

    void setCustomerInfo(@Nullable Object obj);

    void setPaymentCards(@Nullable Object obj);
}
