package com.facebook.appevents.integrity;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0012H\u0007J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007R+\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/integrity/ProtectedModeManager;", "", "()V", "defaultStandardParameterNames", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getDefaultStandardParameterNames", "()Ljava/util/HashSet;", "defaultStandardParameterNames$delegate", "Lkotlin/Lazy;", "enabled", "", "standardParams", "convertJSONArrayToHashSet", "jsonArray", "Lorg/json/JSONArray;", "disable", "", "enable", "loadStandardParams", "processParametersForProtectedMode", "parameters", "Landroid/os/Bundle;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class ProtectedModeManager {
    @NotNull
    public static final ProtectedModeManager INSTANCE = new ProtectedModeManager();
    @NotNull
    private static final Lazy defaultStandardParameterNames$delegate = LazyKt__LazyJVMKt.lazy(ProtectedModeManager$defaultStandardParameterNames$2.INSTANCE);
    private static boolean enabled;
    @Nullable
    private static HashSet<String> standardParams;

    private ProtectedModeManager() {
    }

    private final HashSet<String> convertJSONArrayToHashSet(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>();
        int length = jSONArray.length();
        if (length > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                String string = jSONArray.getString(i11);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                hashSet.add(string);
                if (i12 >= length) {
                    break;
                }
                i11 = i12;
            }
        }
        return hashSet;
    }

    @JvmStatic
    public static final void disable() {
        enabled = false;
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
        INSTANCE.loadStandardParams();
    }

    private final void loadStandardParams() {
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (queryAppSettings != null) {
            HashSet<String> convertJSONArrayToHashSet = convertJSONArrayToHashSet(queryAppSettings.getProtectedModeStandardParamsSetting());
            if (convertJSONArrayToHashSet == null) {
                convertJSONArrayToHashSet = getDefaultStandardParameterNames();
            }
            standardParams = convertJSONArrayToHashSet;
        }
    }

    @JvmStatic
    public static final void processParametersForProtectedMode(@Nullable Bundle bundle) {
        if (enabled && bundle != null && !bundle.isEmpty() && standardParams != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            Set<String> keySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "parameters.keySet()");
            for (String str : keySet) {
                HashSet<String> hashSet = standardParams;
                Intrinsics.checkNotNull(hashSet);
                if (!hashSet.contains(str)) {
                    Intrinsics.checkNotNullExpressionValue(str, RemoteMessageConst.MessageBody.PARAM);
                    arrayList.add(str);
                }
            }
            for (String remove : arrayList) {
                bundle.remove(remove);
            }
            bundle.putString("pm", "1");
        }
    }

    @NotNull
    public final HashSet<String> getDefaultStandardParameterNames() {
        return (HashSet) defaultStandardParameterNames$delegate.getValue();
    }
}
