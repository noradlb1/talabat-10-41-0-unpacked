package com.talabat.fluttercore.presentation.utils;

import com.adjust.sdk.AdjustEvent;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¨\u0006\n"}, d2 = {"Lcom/talabat/fluttercore/presentation/utils/AdjustUtil;", "", "()V", "createAdjustEvent", "Lcom/adjust/sdk/AdjustEvent;", "token", "", "callbackParams", "", "partnerParams", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AdjustUtil {
    @NotNull
    public static final AdjustUtil INSTANCE = new AdjustUtil();

    private AdjustUtil() {
    }

    @NotNull
    public final AdjustEvent createAdjustEvent(@NotNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        AdjustEvent adjustEvent = new AdjustEvent(str);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                adjustEvent.addCallbackParameter((String) next.getKey(), (String) next.getValue());
            }
        }
        if (map2 != null) {
            for (Map.Entry next2 : map2.entrySet()) {
                adjustEvent.addPartnerParameter((String) next2.getKey(), (String) next2.getValue());
            }
        }
        return adjustEvent;
    }
}
