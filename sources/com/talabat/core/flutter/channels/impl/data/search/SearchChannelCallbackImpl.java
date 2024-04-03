package com.talabat.core.flutter.channels.impl.data.search;

import android.os.Bundle;
import buisnessmodels.Customer;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.flutter.channels.domain.search.SearchChannelCallback;
import com.talabat.fluttercore.domain.entities.FlutterVertical;
import com.talabat.fluttercore.domain.entities.FlutterVerticalKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/search/SearchChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/search/SearchChannelCallback;", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "getAvailableVertical", "", "Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "arguments", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)[Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "getSearchConfiguration", "", "", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchChannelCallbackImpl implements SearchChannelCallback {
    @NotNull
    private final Lazy gson$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, SearchChannelCallbackImpl$gson$2.INSTANCE);

    private final FlutterVertical[] getAvailableVertical(Bundle bundle) {
        String str;
        boolean z11;
        Object obj;
        if (bundle != null) {
            str = bundle.getString("verticals");
        } else {
            str = null;
        }
        Reflection.getOrCreateKotlinClass(SearchChannelCallbackImpl.class).getSimpleName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("verticals ");
        sb2.append(str);
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new FlutterVertical[0];
        }
        Gson gson = getGson();
        Class cls = FlutterVertical[].class;
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(str, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson, str, cls);
        }
        Intrinsics.checkNotNullExpressionValue(obj, "gson.fromJson(verticals,…terVertical>::class.java)");
        return (FlutterVertical[]) obj;
    }

    private final Gson getGson() {
        return (Gson) this.gson$delegate.getValue();
    }

    @NotNull
    public Map<String, Object> getSearchConfiguration(@Nullable Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FlutterVertical[] availableVertical = getAvailableVertical(bundle);
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (FlutterVertical map : availableVertical) {
            arrayList.add(FlutterVerticalKt.toMap(map));
        }
        linkedHashMap.put("verticals", arrayList);
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isShowPro()) {
            z11 = true;
        }
        linkedHashMap.put("isTalabatProSubscriptionEnabled", Boolean.valueOf(z11));
        Reflection.getOrCreateKotlinClass(SearchChannelCallbackImpl.class).getSimpleName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("resultMap ");
        sb2.append(linkedHashMap);
        return linkedHashMap;
    }
}
