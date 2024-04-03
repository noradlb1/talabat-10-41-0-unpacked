package com.talabat.feature.foodcart2.data.datasources;

import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\f"}, d2 = {"com/talabat/feature/foodcart2/data/datasources/FoodCartFlutterDataSourceImpl$updateQuantity$2$1", "Lio/flutter/plugin/common/MethodChannel$Result;", "error", "", "errorCode", "", "errorMessage", "errorDetails", "", "notImplemented", "success", "result", "com_talabat_feature_foodcart2_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoodCartFlutterDataSourceImpl$updateQuantity$2$1 implements MethodChannel.Result {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Continuation<Unit> f58552a;

    public FoodCartFlutterDataSourceImpl$updateQuantity$2$1(Continuation<? super Unit> continuation) {
        this.f58552a = continuation;
    }

    public void error(@NotNull String str, @Nullable String str2, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(str, "errorCode");
        Continuation<Unit> continuation = this.f58552a;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
    }

    public void notImplemented() {
        Continuation<Unit> continuation = this.f58552a;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
    }

    public void success(@Nullable Object obj) {
        Continuation<Unit> continuation = this.f58552a;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
    }
}
