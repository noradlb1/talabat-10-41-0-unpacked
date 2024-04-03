package com.talabat.core.deeplink.data.handler.nfv;

import android.content.Context;
import android.os.Bundle;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.grocery.GroceryHomeScreen;
import com.talabat.core.navigation.domain.screen.pharmacy.VendorListScreen;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/nfv/PharmacyAndFlowersHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "nfvFlutterEnable", "", "getNfvFlutterEnable", "()Z", "nfvFlutterEnable$delegate", "Lkotlin/Lazy;", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "navigateToFlutterNfwScreen", "vertical", "verticalId", "", "Companion", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PharmacyAndFlowersHandler implements Handler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String FLOWERS_VERTICAL = "flowers";
    public static final int FLOWERS_VERTICAL_ID = 3;
    @NotNull
    private static final String PHARMACY_VERTICAL = "pharmacy";
    public static final int PHARMACY_VERTICAL_ID = 2;
    @NotNull
    private static final String PHARMACY_VERTICAL_KEYWORD = "vertical";
    @NotNull
    public static final String VARIATION_NFV_EXPERIMENT = "Variation1";
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final Lazy nfvFlutterEnable$delegate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/nfv/PharmacyAndFlowersHandler$Companion;", "", "()V", "FLOWERS_VERTICAL", "", "FLOWERS_VERTICAL_ID", "", "PHARMACY_VERTICAL", "PHARMACY_VERTICAL_ID", "PHARMACY_VERTICAL_KEYWORD", "VARIATION_NFV_EXPERIMENT", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PharmacyAndFlowersHandler(@NotNull Navigator navigator2, @NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        this.navigator = navigator2;
        this.nfvFlutterEnable$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new PharmacyAndFlowersHandler$nfvFlutterEnable$2(iTalabatExperiment));
    }

    private final boolean getNfvFlutterEnable() {
        return ((Boolean) this.nfvFlutterEnable$delegate.getValue()).booleanValue();
    }

    private final void navigateToFlutterNfwScreen(Context context, String str, int i11) {
        int i12 = i11;
        String str2 = str;
        Context context2 = context;
        Navigator.DefaultImpls.navigateTo$default(this.navigator, context2, new GroceryHomeScreen(new GroceryHomeScreen.GroceryHomeData(i12, str2, CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(i11)), (Bundle) null, 8, (DefaultConstructorMarker) null)), (Function1) null, 4, (Object) null);
    }

    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        Integer num;
        boolean z11;
        String str = parsedLinkModel.getData().get("vertical");
        if (str != null) {
            num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        } else {
            num = null;
        }
        if (Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) getScreenName()) || (Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) "l") && ((num != null && num.intValue() == 2) || (num != null && num.intValue() == 3 && getNfvFlutterEnable())))) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boxing.boxBoolean(z11);
    }

    @NotNull
    public String getScreenName() {
        return "pharmacy";
    }

    public void handle(@NotNull Context context, @NotNull ParsedLinkModel parsedLinkModel) {
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        String str = parsedLinkModel.getData().get("vertical");
        if (str != null) {
            num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        } else {
            num = null;
        }
        int i11 = 2;
        if (num != null && num.intValue() == 2 && getNfvFlutterEnable()) {
            navigateToFlutterNfwScreen(context, "pharmacy", 2);
        } else if (num != null && num.intValue() == 3 && getNfvFlutterEnable()) {
            navigateToFlutterNfwScreen(context, "flowers", 3);
        } else {
            Navigator navigator2 = this.navigator;
            if (num != null) {
                i11 = num.intValue();
            }
            Navigator.DefaultImpls.navigateTo$default(navigator2, context, new VendorListScreen(new VendorListScreen.VendorListData("pharmacy", i11)), (Function1) null, 4, (Object) null);
        }
    }
}
