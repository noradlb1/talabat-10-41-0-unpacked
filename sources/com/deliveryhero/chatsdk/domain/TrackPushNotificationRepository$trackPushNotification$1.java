package com.deliveryhero.chatsdk.domain;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/deliveryhero/chatsdk/domain/TrackPushNotificationRepository$trackPushNotification$1", "Lretrofit2/Callback;", "", "onFailure", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackPushNotificationRepository$trackPushNotification$1 implements Callback<Unit> {
    final /* synthetic */ Function1<Result<Unit>, Unit> $resultListener;

    public TrackPushNotificationRepository$trackPushNotification$1(Function1<? super Result<Unit>, Unit> function1) {
        this.$resultListener = function1;
    }

    public void onFailure(@NotNull Call<Unit> call, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(th2, "t");
        Function1<Result<Unit>, Unit> function1 = this.$resultListener;
        Result.Companion companion = Result.Companion;
        function1.invoke(Result.m6328boximpl(Result.m6329constructorimpl(ResultKt.createFailure(th2))));
    }

    public void onResponse(@NotNull Call<Unit> call, @NotNull Response<Unit> response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccessful()) {
            Function1<Result<Unit>, Unit> function1 = this.$resultListener;
            Result.Companion companion = Result.Companion;
            function1.invoke(Result.m6328boximpl(Result.m6329constructorimpl(Unit.INSTANCE)));
            return;
        }
        Function1<Result<Unit>, Unit> function12 = this.$resultListener;
        Result.Companion companion2 = Result.Companion;
        function12.invoke(Result.m6328boximpl(Result.m6329constructorimpl(ResultKt.createFailure(new HttpException(response)))));
    }
}
