package com.talabat.core.deeplink.data.handler.flutter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.deeplink.data.handler.flutter.uiless.UiLessFlutterEngineBinding;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/flutter/FlutterDeepLinkHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "uiLessBinding", "Lcom/talabat/core/deeplink/data/handler/flutter/uiless/UiLessFlutterEngineBinding;", "(Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/deeplink/data/handler/flutter/uiless/UiLessFlutterEngineBinding;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatDeeplink", "handle", "", "context", "Landroid/content/Context;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterDeepLinkHandler implements Handler {
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = "";
    @NotNull
    private final UiLessFlutterEngineBinding uiLessBinding;

    public FlutterDeepLinkHandler(@NotNull Navigator navigator2, @NotNull UiLessFlutterEngineBinding uiLessFlutterEngineBinding) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(uiLessFlutterEngineBinding, "uiLessBinding");
        this.navigator = navigator2;
        this.uiLessBinding = uiLessFlutterEngineBinding;
        uiLessFlutterEngineBinding.init();
    }

    private final String formatDeeplink(ParsedLinkModel parsedLinkModel) {
        boolean unused = StringsKt__StringsJVMKt.isBlank(parsedLinkModel.getScreenName());
        Uri.Builder buildUpon = Uri.parse(parsedLinkModel.getScreenName()).buildUpon();
        for (Map.Entry next : parsedLinkModel.getData().entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "run {\n            assert…ld().toString()\n        }");
        return uri;
    }

    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.uiLessBinding.canOpenDeepLink(parsedLinkModel.getScreenName(), new FlutterDeepLinkHandler$canHandle$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void handle(@NotNull Context context, @NotNull ParsedLinkModel parsedLinkModel) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        try {
            Result.Companion companion = Result.Companion;
            String formatDeeplink = formatDeeplink(parsedLinkModel);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("formattedDeeplink ");
            sb2.append(formatDeeplink);
            this.navigator.navigateTo(context, new FlutterScreen(new FlutterScreen.FlutterScreenData(formatDeeplink)), FlutterDeepLinkHandler$handle$1$1.INSTANCE);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r52 = Result.m6332exceptionOrNullimpl(obj);
        if (r52 != null) {
            String simpleName = FlutterDeepLinkHandler.class.getSimpleName();
            String screenName2 = parsedLinkModel.getScreenName();
            Map<String, String> data = parsedLinkModel.getData();
            Log.e(simpleName, "Fail to handle the deeplink screenName:" + screenName2 + " data:" + data, r52);
        }
    }
}
