package com.talabat.core.deeplink.data.handler.foodlist;

import android.content.Context;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListFeatureFlagsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEventKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/foodlist/FoodListCollectionsHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "foodVerticalId", "", "screenName", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeeplink", "handle", "", "context", "Landroid/content/Context;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoodListCollectionsHandler implements Handler {
    @NotNull
    private final String foodVerticalId = "0";
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = "l";
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public FoodListCollectionsHandler(@NotNull Navigator navigator2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.navigator = navigator2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private final String getDeeplink(ParsedLinkModel parsedLinkModel) {
        boolean z11;
        String str = parsedLinkModel.getData().get("li");
        if (str == null) {
            return "talabat://?s=/food-list-organic";
        }
        String str2 = "talabat://?s=/vendor-list-collection&deeplink=" + str;
        String str3 = parsedLinkModel.getData().get("from");
        if (str3 == null || StringsKt__StringsJVMKt.isBlank(str3)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return str2;
        }
        return str2 + "&from=" + str3;
    }

    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        boolean z11 = false;
        boolean featureFlag = this.talabatFeatureFlag.getFeatureFlag(VendorListFeatureFlagsKeys.VENDORLIST_COLLECTION_DEEP_LINK_NAVIGATION, false);
        boolean featureFlag2 = this.talabatFeatureFlag.getFeatureFlag(VendorListFeatureFlagsKeys.VENDORLIST_DEEP_LINK_NAVIGATION_HOF, false);
        if ((featureFlag && Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) getScreenName()) && parsedLinkModel.getData().containsKey("li")) || (featureFlag2 && Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) getScreenName()) && Intrinsics.areEqual((Object) parsedLinkModel.getData().get(BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL), (Object) this.foodVerticalId))) {
            z11 = true;
        }
        return Boxing.boxBoolean(z11);
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void handle(@NotNull Context context, @NotNull ParsedLinkModel parsedLinkModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new FlutterScreen(new FlutterScreen.FlutterScreenData(getDeeplink(parsedLinkModel))), (Function1) null, 4, (Object) null);
    }
}
