package com.talabat.core.tracking.data.perseus;

import android.os.Bundle;
import com.deliveryhero.customerchat.eventTracking.constants.ContactDetailsKeys;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.core.tracking.domain.perseus.PerseusEventTools;
import com.talabat.darkstores.data.tracking.BannerTracker;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0016J0\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0014\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/tracking/data/perseus/LegacyPerseusEvenTools;", "Lcom/talabat/core/tracking/domain/perseus/PerseusEventTools;", "()V", "adaptEventName", "", "name", "params", "Landroid/os/Bundle;", "originalEventName", "", "", "addPerseusParams", "eventName", "input", "", "convertBundleToJson", "Lorg/json/JSONObject;", "bundle", "convertListToJson", "Lorg/json/JSONArray;", "list", "", "handleValue", "obj", "replaceLastUnderscoreWithDot", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyPerseusEvenTools implements PerseusEventTools {
    private final JSONObject convertBundleToJson(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj instanceof List) {
                jSONObject.put(next, (Object) convertListToJson((List) obj));
            } else if (obj instanceof Bundle) {
                jSONObject.put(next, (Object) convertBundleToJson((Bundle) obj));
            } else {
                jSONObject.put(next, (Object) String.valueOf(obj));
            }
        }
        return jSONObject;
    }

    private final JSONArray convertListToJson(List<?> list) {
        JSONArray jSONArray = new JSONArray();
        for (Object handleValue : list) {
            jSONArray.put(handleValue(handleValue));
        }
        return jSONArray;
    }

    private final Object handleValue(Object obj) {
        if (obj instanceof List) {
            return convertListToJson((List) obj);
        }
        if (obj instanceof Bundle) {
            return convertBundleToJson((Bundle) obj);
        }
        return obj;
    }

    private final String replaceLastUnderscoreWithDot(String str) {
        int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, JavaConstant.Dynamic.DEFAULT_NAME, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            return StringsKt__StringsKt.replaceRange((CharSequence) str, lastIndexOf$default, lastIndexOf$default + 1, (CharSequence) RealDiscoveryConfigurationRepository.VERSION_DELIMETER).toString();
        }
        return str;
    }

    @NotNull
    public String adaptEventName(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        return adaptEventName(str, String.valueOf(map.get("originalEventName")));
    }

    @NotNull
    public Map<String, String> addPerseusParams(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "input");
        map.put("perseusDataSource", ContactDetailsKeys.SENT_FROM_VALUE);
        map.put("dataLayerEventName", str);
        return map;
    }

    @NotNull
    public String adaptEventName(@NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        String string = bundle.getString("originalEventName", "");
        Intrinsics.checkNotNullExpressionValue(string, "params.getString(\n      …FAULT_VALUE\n            )");
        return adaptEventName(str, string);
    }

    @NotNull
    public Map<String, String> addPerseusParams(@NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(bundle, "input");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<String> keySet = bundle.keySet();
        if (keySet != null) {
            for (String str2 : keySet) {
                Intrinsics.checkNotNullExpressionValue(str2, "key");
                linkedHashMap.put(str2, String.valueOf(handleValue(bundle.get(str2))));
            }
        }
        return addPerseusParams(str, (Map<String, String>) linkedHashMap);
    }

    private final String adaptEventName(String str, String str2) {
        switch (str.hashCode()) {
            case -1119414983:
                if (str.equals(FirebaseAnalytics.Event.VIEW_SEARCH_RESULTS)) {
                    str = str2;
                    break;
                }
                break;
            case -455112672:
                if (str.equals("ecommerce_purchase")) {
                    str = "transaction";
                    break;
                }
                break;
            case 164161734:
                if (str.equals("add_to_cart")) {
                    str = BannerTracker.ADDED;
                    break;
                }
                break;
            case 326022172:
                if (str.equals(FirebaseAnalytics.Event.BEGIN_CHECKOUT)) {
                    str = "checkout_loaded";
                    break;
                }
                break;
            case 1927902362:
                if (str.equals("remove_from_cart")) {
                    str = "remove_cart_clicked";
                    break;
                }
                break;
        }
        return replaceLastUnderscoreWithDot(str);
    }
}
