package com.talabat.flutter.channels;

import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import buisnessmodels.Customer;
import com.talabat.flutter.VendorListSearchFlutterActivity;
import com.talabat.fluttercore.domain.entities.FlutterVertical;
import com.talabat.fluttercore.domain.entities.FlutterVerticalKt;
import com.talabat.search.domain.callback.SearchMethodHandlerCallback;
import com.talabat.search.domain.handler.SearchMethodHandler;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0017J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/flutter/channels/SearchMethodChannel;", "Lcom/talabat/search/domain/handler/SearchMethodHandler;", "()V", "searchCallBack", "Lcom/talabat/search/domain/callback/SearchMethodHandlerCallback;", "getChannelArguments", "", "", "", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setSearchMethodChannelCallbacks", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SearchMethodChannel implements SearchMethodHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_ELIGIBLE_CONFIGURATION = "getSearchConfiguration";
    private SearchMethodHandlerCallback searchCallBack;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/flutter/channels/SearchMethodChannel$Companion;", "", "()V", "GET_ELIGIBLE_CONFIGURATION", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    @VisibleForTesting
    public Map<String, Object> getChannelArguments(@NotNull SearchMethodHandlerCallback searchMethodHandlerCallback) {
        Intrinsics.checkNotNullParameter(searchMethodHandlerCallback, "searchCallBack");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FlutterVertical[] availableVertical = searchMethodHandlerCallback.getAvailableVertical();
        int selectedCollectionId = searchMethodHandlerCallback.getSelectedCollectionId();
        int selectedCuisine = searchMethodHandlerCallback.getSelectedCuisine();
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (FlutterVertical map : availableVertical) {
            arrayList.add(FlutterVerticalKt.toMap(map));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put(VendorListSearchFlutterActivity.COLLECTION_ID_KEY, Integer.valueOf(selectedCollectionId));
        if (selectedCuisine > 0) {
            linkedHashMap2.put(VendorListSearchFlutterActivity.CUISINE_ID_KEY, Integer.valueOf(selectedCuisine));
        } else {
            linkedHashMap2.put(VendorListSearchFlutterActivity.CUISINE_ID_KEY, 0);
        }
        linkedHashMap2.put("filterIds", CollectionsKt__CollectionsKt.emptyList());
        linkedHashMap.put("verticals", arrayList);
        linkedHashMap.put("filter", linkedHashMap2);
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isShowPro()) {
            z11 = true;
        }
        linkedHashMap.put("isTalabatProSubscriptionEnabled", Boolean.valueOf(z11));
        return linkedHashMap;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) GET_ELIGIBLE_CONFIGURATION)) {
            Object obj = methodCall.arguments;
            LogManager.debug(GET_ELIGIBLE_CONFIGURATION + obj);
            SearchMethodHandlerCallback searchMethodHandlerCallback = this.searchCallBack;
            if (searchMethodHandlerCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchCallBack");
                searchMethodHandlerCallback = null;
            }
            result.success(getChannelArguments(searchMethodHandlerCallback));
            return;
        }
        result.notImplemented();
    }

    public void setSearchMethodChannelCallbacks(@NotNull SearchMethodHandlerCallback searchMethodHandlerCallback) {
        Intrinsics.checkNotNullParameter(searchMethodHandlerCallback, "searchCallBack");
        this.searchCallBack = searchMethodHandlerCallback;
    }
}
