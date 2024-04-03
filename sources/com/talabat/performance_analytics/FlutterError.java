package com.talabat.performance_analytics;

import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/talabat/performance_analytics/FlutterError;", "", "code", "", "message", "details", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getCode", "()Ljava/lang/String;", "getDetails", "()Ljava/lang/Object;", "getMessage", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FlutterError extends Throwable {
    @NotNull
    private final String code;
    @Nullable
    private final Object details;
    @Nullable
    private final String message;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlutterError(String str, String str2, Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : obj);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final Object getDetails() {
        return this.details;
    }

    @Nullable
    public String getMessage() {
        return this.message;
    }

    public FlutterError(@NotNull String str, @Nullable String str2, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        this.code = str;
        this.message = str2;
        this.details = obj;
    }
}
