package com.talabat.core.deeplink.data.handler.address;

import android.content.Context;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.address.AddressListScreen;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.helpers.GlobalConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/address/AddressListHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressListHandler implements Handler {
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = "legacy-address-list";

    public AddressListHandler(@NotNull Navigator navigator2) {
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
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        String str = parsedLinkModel.getData().get(GlobalConstants.ExtraNames.ISFORSELECTION);
        if (str != null) {
            z11 = Boolean.parseBoolean(str);
        } else {
            z11 = true;
        }
        String str2 = parsedLinkModel.getData().get("isOrderFlow");
        if (str2 != null) {
            z12 = Boolean.parseBoolean(str2);
        } else {
            z12 = true;
        }
        String str3 = parsedLinkModel.getData().get("isFromCheckout");
        if (str3 != null) {
            z13 = Boolean.parseBoolean(str3);
        } else {
            z13 = true;
        }
        String str4 = parsedLinkModel.getData().get("noAreaChange");
        if (str4 != null) {
            z14 = Boolean.parseBoolean(str4);
        } else {
            z14 = true;
        }
        String str5 = parsedLinkModel.getData().get("isFromFlutter");
        if (str5 != null) {
            z15 = Boolean.parseBoolean(str5);
        } else {
            z15 = true;
        }
        String str6 = parsedLinkModel.getData().get(GlobalConstants.FORCE_MAP.IS_ADD_ADDRESS_FROM_CHECKOUT);
        if (str6 != null) {
            z16 = Boolean.parseBoolean(str6);
        } else {
            z16 = true;
        }
        String str7 = parsedLinkModel.getData().get(NavigationMethodChannel.SHOW_ADD_ADDRESS_BUTTON);
        if (str7 != null) {
            z17 = Boolean.parseBoolean(str7);
        } else {
            z17 = true;
        }
        this.navigator.navigateTo(context, new AddressListScreen((Void) null, 1, (DefaultConstructorMarker) null), new AddressListHandler$handle$1(z11, z12, z13, z14, z15, z16, z17));
    }
}
