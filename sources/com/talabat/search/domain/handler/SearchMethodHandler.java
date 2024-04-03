package com.talabat.search.domain.handler;

import com.talabat.search.domain.callback.SearchMethodHandlerCallback;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/search/domain/handler/SearchMethodHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "setSearchMethodChannelCallbacks", "", "searchCallBack", "Lcom/talabat/search/domain/callback/SearchMethodHandlerCallback;", "com_talabat_feature_search_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SearchMethodHandler extends MethodChannel.MethodCallHandler {
    void setSearchMethodChannelCallbacks(@NotNull SearchMethodHandlerCallback searchMethodHandlerCallback);
}
