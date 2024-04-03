package com.talabat.card_tokenization;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.card_tokenization.datasource.CheckoutTokenizationDataSource;
import com.talabat.card_tokenization.mapper.NonEnglishNumbersMapper;
import com.talabat.card_tokenization.provider.CheckoutApiClientProvider;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\b\u0001\u0010\u001e\u001a\u00020\u001cH\u0016J\u001c\u0010\u001f\u001a\u00020\u001a2\b\b\u0001\u0010 \u001a\u00020!2\b\b\u0001\u0010\"\u001a\u00020#H\u0016R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/talabat/card_tokenization/CardTokenizationPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "getChannel$annotations", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "checkoutTokenizationDataSource", "Lcom/talabat/card_tokenization/datasource/CheckoutTokenizationDataSource;", "getCheckoutTokenizationDataSource$annotations", "getCheckoutTokenizationDataSource", "()Lcom/talabat/card_tokenization/datasource/CheckoutTokenizationDataSource;", "setCheckoutTokenizationDataSource", "(Lcom/talabat/card_tokenization/datasource/CheckoutTokenizationDataSource;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$annotations", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "card_tokenization_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardTokenizationPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    @NotNull
    public static final String ARG_CVV_KEY = "cvv";
    @NotNull
    public static final String ARG_ENV_KEY = "env";
    @NotNull
    public static final String ARG_EXPIRY_MONTH_KEY = "expiryMonth";
    @NotNull
    public static final String ARG_EXPIRY_YEAR_KEY = "expiryYear";
    @NotNull
    public static final String ARG_HOLDER_NAME_KEY = "holderName";
    @NotNull
    public static final String ARG_NUMBER_KEY = "number";
    @NotNull
    public static final String ARG_PUBLIC_KEY_KEY = "publicKey";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String ERROR_CODE_INVALID_ARGUMENT = "invalidArgument";
    @NotNull
    public static final String ERROR_CODE_TOKENIZATION_FAILED = "tokenizationFailure";
    @NotNull
    public static final String METHOD_CHANNEL_NAME = "card_tokenization";
    @NotNull
    public static final String TOKENIZE_CARD_METHOD_NAME = "tokenizeCard";
    public MethodChannel channel;
    @Nullable
    private CheckoutTokenizationDataSource checkoutTokenizationDataSource;
    @NotNull
    private CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/card_tokenization/CardTokenizationPlugin$Companion;", "", "()V", "ARG_CVV_KEY", "", "ARG_ENV_KEY", "ARG_EXPIRY_MONTH_KEY", "ARG_EXPIRY_YEAR_KEY", "ARG_HOLDER_NAME_KEY", "ARG_NUMBER_KEY", "ARG_PUBLIC_KEY_KEY", "ERROR_CODE_INVALID_ARGUMENT", "ERROR_CODE_TOKENIZATION_FAILED", "METHOD_CHANNEL_NAME", "TOKENIZE_CARD_METHOD_NAME", "card_tokenization_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getChannel$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getCheckoutTokenizationDataSource$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getCoroutineScope$annotations() {
    }

    @NotNull
    public final MethodChannel getChannel() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            return methodChannel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("channel");
        return null;
    }

    @Nullable
    public final CheckoutTokenizationDataSource getCheckoutTokenizationDataSource() {
        return this.checkoutTokenizationDataSource;
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        setChannel(new MethodChannel(flutterPluginBinding.getBinaryMessenger(), METHOD_CHANNEL_NAME));
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.applicationContext");
        this.checkoutTokenizationDataSource = new CheckoutTokenizationDataSource(applicationContext, new CheckoutApiClientProvider(), new NonEnglishNumbersMapper());
        getChannel().setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        getChannel().setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.checkoutTokenizationDataSource = null;
        CoroutineScopeKt.cancel$default(this.coroutineScope, (CancellationException) null, 1, (Object) null);
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) TOKENIZE_CARD_METHOD_NAME)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CardTokenizationPlugin$onMethodCall$1(methodCall, result, this, (Continuation<? super CardTokenizationPlugin$onMethodCall$1>) null), 3, (Object) null);
        } else {
            result.notImplemented();
        }
    }

    public final void setChannel(@NotNull MethodChannel methodChannel) {
        Intrinsics.checkNotNullParameter(methodChannel, "<set-?>");
        this.channel = methodChannel;
    }

    public final void setCheckoutTokenizationDataSource(@Nullable CheckoutTokenizationDataSource checkoutTokenizationDataSource2) {
        this.checkoutTokenizationDataSource = checkoutTokenizationDataSource2;
    }

    public final void setCoroutineScope(@NotNull CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "<set-?>");
        this.coroutineScope = coroutineScope2;
    }
}
