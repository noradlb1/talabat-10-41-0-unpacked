package com.talabat.core.deeplink.data.handler.cart;

import android.content.Context;
import android.util.Log;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.deeplink.data.handler.flutter.FlutterDeepLinkHandler;
import com.talabat.core.deeplink.data.handler.flutter.uiless.UiLessFlutterEngineBinding;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.cart.CartScreen;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/cart/CartHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "uiLessFlutterEngineBinding", "Lcom/talabat/core/deeplink/data/handler/flutter/uiless/UiLessFlutterEngineBinding;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/deeplink/data/handler/flutter/uiless/UiLessFlutterEngineBinding;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "shortName", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartHandler implements Handler {
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = "cart";
    /* access modifiers changed from: private */
    @NotNull
    public final String shortName = "b";
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final UiLessFlutterEngineBinding uiLessFlutterEngineBinding;

    public CartHandler(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Navigator navigator2, @NotNull UiLessFlutterEngineBinding uiLessFlutterEngineBinding2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(uiLessFlutterEngineBinding2, "uiLessFlutterEngineBinding");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.navigator = navigator2;
        this.uiLessFlutterEngineBinding = uiLessFlutterEngineBinding2;
    }

    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.uiLessFlutterEngineBinding.canOpenDeepLink(getScreenName(), new CartHandler$canHandle$2$1(this.talabatFeatureFlag.getFeatureFlag(OrderingFeatureFlagsKeys.FLUTTER_PUSH_NOTIFICATION_CART_DEEPLINK_ENABLED, false), parsedLinkModel, this, safeContinuation));
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
            StringBuilder sb2 = new StringBuilder();
            sb2.append("formattedDeeplink ");
            sb2.append("talabat://?s=cart&shopClickOrigin=");
            Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new FlutterScreen(new FlutterScreen.FlutterScreenData("talabat://?s=cart&shopClickOrigin=")), (Function1) null, 4, (Object) null);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            String simpleName = FlutterDeepLinkHandler.class.getSimpleName();
            String screenName2 = parsedLinkModel.getScreenName();
            Map<String, String> data = parsedLinkModel.getData();
            Log.e(simpleName, "Fail to handle the deeplink screenName:" + screenName2 + " data:" + data, r02);
            Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new CartScreen((Void) null, 1, (DefaultConstructorMarker) null), (Function1) null, 4, (Object) null);
        }
    }
}
