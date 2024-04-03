package com.talabat.core.deeplink.data.handler.menu;

import android.content.Context;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.observabilityNew.domain.squads.menu.MenuScreenPerformanceParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/menu/MenuHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuHandler implements Handler {
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = MenuScreenPerformanceParams.SCREEN_TYPE;

    public MenuHandler(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        this.navigator = navigator2;
    }

    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) getScreenName()));
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void handle(@NotNull Context context, @NotNull ParsedLinkModel parsedLinkModel) {
        int i11;
        int i12;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        String str = parsedLinkModel.getData().get("bid");
        if (str != null) {
            i11 = Integer.parseInt(str);
        } else {
            i11 = -1;
        }
        String str2 = parsedLinkModel.getData().get("dm");
        if (str2 == null) {
            str2 = "rider";
        }
        String str3 = parsedLinkModel.getData().get("sco");
        if (str3 == null) {
            str3 = "";
        }
        String str4 = parsedLinkModel.getData().get("i");
        if (str4 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str4)) == null) {
            i12 = -1;
        } else {
            i12 = intOrNull.intValue();
        }
        String str5 = "talabat://?s=vendor-menu&branchId=" + i11 + "&deliveryMode=" + str2 + "&intraFlutterNavigation=true";
        if (!StringsKt__StringsJVMKt.isBlank(str3)) {
            str5 = str5 + "&shopClickOrigin=" + str3;
        }
        if (i12 != -1) {
            str5 = str5 + "&itemId=" + i12;
        }
        Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new FlutterScreen(new FlutterScreen.FlutterScreenData(str5)), (Function1) null, 4, (Object) null);
    }
}
