package com.talabat.core.deeplink.data.handler.foodlist;

import android.content.Context;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.restaurant.FoodListFlutterScreen;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/foodlist/FoodListHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoodListHandler implements Handler {
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = "foodlist";

    public FoodListHandler(@NotNull Navigator navigator2) {
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
        double d11;
        String str;
        int i11;
        String str2;
        Integer intOrNull;
        Double doubleOrNull;
        Double doubleOrNull2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        Navigator navigator2 = this.navigator;
        String str3 = parsedLinkModel.getData().get("latitude");
        double d12 = 0.0d;
        if (str3 == null || (doubleOrNull2 = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(str3)) == null) {
            d11 = 0.0d;
        } else {
            d11 = doubleOrNull2.doubleValue();
        }
        String str4 = parsedLinkModel.getData().get("longitude");
        if (!(str4 == null || (doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(str4)) == null)) {
            d12 = doubleOrNull.doubleValue();
        }
        double d13 = d12;
        String str5 = parsedLinkModel.getData().get("areaId");
        if (str5 == null) {
            str5 = "";
        }
        String str6 = parsedLinkModel.getData().get("cityId");
        if (str6 == null) {
            str = "";
        } else {
            str = str6;
        }
        String str7 = parsedLinkModel.getData().get("countryId");
        if (str7 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str7)) == null) {
            i11 = 0;
        } else {
            i11 = intOrNull.intValue();
        }
        int i12 = i11;
        String str8 = parsedLinkModel.getData().get("areaName");
        if (str8 == null) {
            str2 = "";
        } else {
            str2 = str8;
        }
        Navigator.DefaultImpls.navigateTo$default(navigator2, context, new FoodListFlutterScreen(new FoodListFlutterScreen.FoodListFlutterData(d11, d13, str5, str, i12, str2)), (Function1) null, 4, (Object) null);
    }
}
