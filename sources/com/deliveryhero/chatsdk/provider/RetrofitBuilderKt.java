package com.deliveryhero.chatsdk.provider;

import com.squareup.moshi.Moshi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018@X\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0007\u001a\u00020\b8@X\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\n\"\u001b\u0010\f\u001a\u00020\r8@X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u001b\u0010\u0011\u001a\u00020\u00128@X\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"DefaultRetrofitBuilder", "Lretrofit2/Retrofit$Builder;", "kotlin.jvm.PlatformType", "getDefaultRetrofitBuilder", "()Lretrofit2/Retrofit$Builder;", "DefaultRetrofitBuilder$delegate", "Lkotlin/Lazy;", "callAdapter", "Lretrofit2/adapter/rxjava2/RxJava2CallAdapterFactory;", "getCallAdapter", "()Lretrofit2/adapter/rxjava2/RxJava2CallAdapterFactory;", "callAdapter$delegate", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "moshi$delegate", "moshiConverter", "Lretrofit2/converter/moshi/MoshiConverterFactory;", "getMoshiConverter", "()Lretrofit2/converter/moshi/MoshiConverterFactory;", "moshiConverter$delegate", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RetrofitBuilderKt {
    @NotNull
    private static final Lazy DefaultRetrofitBuilder$delegate = LazyKt__LazyJVMKt.lazy(RetrofitBuilderKt$DefaultRetrofitBuilder$2.INSTANCE);
    @NotNull
    private static final Lazy callAdapter$delegate;
    @NotNull
    private static final Lazy moshi$delegate;
    @NotNull
    private static final Lazy moshiConverter$delegate = LazyKt__LazyJVMKt.lazy(RetrofitBuilderKt$moshiConverter$2.INSTANCE);

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        callAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, RetrofitBuilderKt$callAdapter$2.INSTANCE);
        moshi$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, RetrofitBuilderKt$moshi$2.INSTANCE);
    }

    @NotNull
    public static final RxJava2CallAdapterFactory getCallAdapter() {
        Object value = callAdapter$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-callAdapter>(...)");
        return (RxJava2CallAdapterFactory) value;
    }

    public static final Retrofit.Builder getDefaultRetrofitBuilder() {
        return (Retrofit.Builder) DefaultRetrofitBuilder$delegate.getValue();
    }

    @NotNull
    public static final Moshi getMoshi() {
        Object value = moshi$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-moshi>(...)");
        return (Moshi) value;
    }

    @NotNull
    public static final MoshiConverterFactory getMoshiConverter() {
        Object value = moshiConverter$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-moshiConverter>(...)");
        return (MoshiConverterFactory) value;
    }
}
