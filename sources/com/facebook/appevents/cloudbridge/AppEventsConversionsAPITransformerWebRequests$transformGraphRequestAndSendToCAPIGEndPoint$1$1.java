package com.facebook.appevents.cloudbridge;

import com.facebook.internal.Utility;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n"}, d2 = {"", "<anonymous parameter 0>", "", "responseCode", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1 extends Lambda implements Function2<String, Integer, Unit> {
    final /* synthetic */ List<Map<String, Object>> $processedEvents;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1(List<? extends Map<String, ? extends Object>> list) {
        super(2);
        this.$processedEvents = list;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m8903invoke$lambda0(Integer num, List list) {
        Intrinsics.checkNotNullParameter(list, "$processedEvents");
        if (!CollectionsKt___CollectionsKt.contains(AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE, num)) {
            AppEventsConversionsAPITransformerWebRequests.INSTANCE.handleError$facebook_core_release(num, list, 5);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Integer) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str, @Nullable Integer num) {
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new a(num, this.$processedEvents));
    }
}
