package com.deliveryhero.chatsdk;

import com.deliveryhero.chatsdk.domain.TrackPushNotificationRepository;
import com.deliveryhero.chatsdk.domain.model.PushNotificationData;
import com.deliveryhero.customerchat.di.MyKoinContext;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0004\u0012\u00020\u00040\bø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/deliveryhero/chatsdk/PushNotificationTracker;", "", "()V", "trackPushNotification", "", "data", "Lcom/deliveryhero/chatsdk/domain/model/PushNotificationData;", "resultListener", "Lkotlin/Function1;", "Lkotlin/Result;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushNotificationTracker {
    @NotNull
    public static final PushNotificationTracker INSTANCE = new PushNotificationTracker();

    private PushNotificationTracker() {
    }

    public final void trackPushNotification(@NotNull PushNotificationData pushNotificationData, @NotNull Function1<? super Result<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(pushNotificationData, "data");
        Intrinsics.checkNotNullParameter(function1, "resultListener");
        if (StringsKt__StringsJVMKt.isBlank(pushNotificationData.getCountry()) || StringsKt__StringsJVMKt.isBlank(pushNotificationData.getPushID())) {
            Result.Companion companion = Result.Companion;
            function1.invoke(Result.m6328boximpl(Result.m6329constructorimpl(ResultKt.createFailure(new IllegalArgumentException("Invalid data. Country or PushId is blank")))));
            return;
        }
        ((TrackPushNotificationRepository) MyKoinContext.INSTANCE.getKoin().getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(TrackPushNotificationRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null)).trackPushNotification(pushNotificationData, function1);
    }
}
