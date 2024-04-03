package com.talabat.talabatcommon.extentions.network;

import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcommon.network.GenericApiErrorResponse;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.ServerError;
import com.talabat.talabatcore.exception.SystemError;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.logger.LogManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Response;

@Instrumented
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u001aM\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\b0\u0006\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u000e\u001a\u0002H\t¢\u0006\u0002\u0010\u000f\u001a%\u0010\u0010\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b¢\u0006\u0002\u0010\u0011\u001aY\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\b0\u0006\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u000e\u001a\u0002H\tH\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aY\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00130\u0006\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b2\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000b0\u00132\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u000e\u001a\u0002H\t¢\u0006\u0002\u0010\u0015\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"parseTheServerError", "Lcom/talabat/talabatcore/exception/ServerError;", "EB", "response", "Lretrofit2/Response;", "request", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "R", "T", "call", "Lretrofit2/Call;", "transform", "Lkotlin/Function1;", "default", "(Lretrofit2/Call;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lcom/talabat/talabatcore/functional/Either;", "requestWithErrorHandle", "(Lretrofit2/Call;)Ljava/lang/Object;", "requests", "", "calls", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lcom/talabat/talabatcore/functional/Either;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RequestKt {
    @NotNull
    public static final <EB> ServerError parseTheServerError(@NotNull Response<?> response) {
        GenericApiErrorResponse genericApiErrorResponse;
        String str;
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody errorBody = response.errorBody();
        if (errorBody == null || (string = errorBody.string()) == null) {
            genericApiErrorResponse = null;
        } else {
            Gson gson = GsonKt.getGson();
            Class cls = GenericApiErrorResponse.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(string, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, string, cls);
            }
            genericApiErrorResponse = (GenericApiErrorResponse) obj;
        }
        Integer valueOf = Integer.valueOf(response.code());
        if (genericApiErrorResponse == null || (str = genericApiErrorResponse.getErrorMessage()) == null) {
            str = "";
        }
        return new ServerError(valueOf, str, String.valueOf(response.body()));
    }

    @NotNull
    public static final <T, R> Either<Failure, R> request(@NotNull Call<T> call, @NotNull Function1<? super T, ? extends R> function1, T t11) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(function1, "transform");
        try {
            Response<T> execute = call.execute();
            boolean isSuccessful = execute.isSuccessful();
            if (isSuccessful) {
                T body = execute.body();
                if (body != null) {
                    t11 = body;
                }
                return new Either.Right(function1.invoke(t11));
            } else if (!isSuccessful) {
                Integer valueOf = Integer.valueOf(execute.code());
                String message = execute.message();
                Intrinsics.checkNotNullExpressionValue(message, "response.message()");
                return new Either.Left(new ServerError(valueOf, message, String.valueOf(execute.body())));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } catch (Throwable th2) {
            LogManager.logException(th2);
            return new Either.Left(new ServerError((Integer) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null));
        }
    }

    @NotNull
    public static final <T, R, EB> Either<Failure, R> requestWithErrorHandle(@NotNull Call<T> call, @NotNull Function1<? super T, ? extends R> function1, T t11) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(function1, "transform");
        try {
            Response<T> execute = call.clone().execute();
            boolean isSuccessful = execute.isSuccessful();
            if (isSuccessful) {
                T body = execute.body();
                if (body != null) {
                    t11 = body;
                }
                return new Either.Right(function1.invoke(t11));
            } else if (!isSuccessful) {
                Intrinsics.checkNotNullExpressionValue(execute, "response");
                return new Either.Left(parseTheServerError(execute));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } catch (Failure e11) {
            LogManager.logException(e11);
            return new Either.Left(e11);
        } catch (Throwable th2) {
            LogManager.logException(th2);
            String message = th2.getMessage();
            if (message == null) {
                message = "";
            }
            return new Either.Left(new SystemError(message));
        }
    }

    @NotNull
    public static final <T, R> Either<Failure, List<R>> requests(@NotNull List<? extends Call<T>> list, @NotNull Function1<? super T, ? extends R> function1, T t11) {
        Intrinsics.checkNotNullParameter(list, "calls");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (Call execute : list) {
            try {
                Response execute2 = execute.execute();
                boolean isSuccessful = execute2.isSuccessful();
                if (isSuccessful) {
                    T body = execute2.body();
                    if (body == null) {
                        body = t11;
                    }
                    arrayList.add(function1.invoke(body));
                } else if (!isSuccessful) {
                    Integer valueOf = Integer.valueOf(execute2.code());
                    String message = execute2.message();
                    Intrinsics.checkNotNullExpressionValue(message, "response.message()");
                    return new Either.Left(new ServerError(valueOf, message, String.valueOf(execute2.body())));
                }
            } catch (Throwable th2) {
                LogManager.logException(th2);
                return new Either.Left(new ServerError((Integer) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null));
            }
        }
        return new Either.Right(arrayList);
    }

    public static final <T, EB> T requestWithErrorHandle(@NotNull Call<T> call) throws Failure {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        try {
            Response<T> execute = call.clone().execute();
            boolean isSuccessful = execute.isSuccessful();
            if (isSuccessful) {
                T body = execute.body();
                if (body != null) {
                    return body;
                }
                throw new ServerError((Integer) null, "Empty Body", (String) null, 5, (DefaultConstructorMarker) null);
            } else if (!isSuccessful) {
                Intrinsics.checkNotNullExpressionValue(execute, "response");
                throw parseTheServerError(execute);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } catch (Failure e11) {
            LogManager.logException(e11);
            throw e11;
        } catch (Throwable th2) {
            LogManager.logException(th2);
            String message = th2.getMessage();
            if (message == null) {
                message = "";
            }
            throw new SystemError(message);
        }
    }
}
