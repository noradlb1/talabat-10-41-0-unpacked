package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.CustomTabPrefetchHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/CustomTab;", "", "action", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "openCustomTab", "", "activity", "Landroid/app/Activity;", "packageName", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public class CustomTab {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private Uri uri;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017¨\u0006\t"}, d2 = {"Lcom/facebook/internal/CustomTab$Companion;", "", "()V", "getURIForAction", "Landroid/net/Uri;", "action", "", "parameters", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public Uri getURIForAction(@NotNull String str, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
            Utility utility = Utility.INSTANCE;
            String dialogAuthority = ServerProtocol.getDialogAuthority();
            return Utility.buildUri(dialogAuthority, FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle);
        }
    }

    public CustomTab(@NotNull String str, @Nullable Bundle bundle) {
        Uri uri2;
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        bundle = bundle == null ? new Bundle() : bundle;
        GamingAction[] values = GamingAction.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (GamingAction rawValue : values) {
            arrayList.add(rawValue.getRawValue());
        }
        if (arrayList.contains(str)) {
            Utility utility = Utility.INSTANCE;
            uri2 = Utility.buildUri(ServerProtocol.getGamingDialogAuthority(), Intrinsics.stringPlus("/dialog/", str), bundle);
        } else {
            uri2 = Companion.getURIForAction(str, bundle);
        }
        this.uri = uri2;
    }

    @JvmStatic
    @NotNull
    public static Uri getURIForAction(@NotNull String str, @Nullable Bundle bundle) {
        return Companion.getURIForAction(str, bundle);
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    public final boolean openCustomTab(@NotNull Activity activity, @Nullable String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        CustomTabsIntent build = new CustomTabsIntent.Builder(CustomTabPrefetchHelper.Companion.getPreparedSessionOnce()).build();
        build.intent.setPackage(str);
        try {
            build.launchUrl(activity, this.uri);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public final void setUri(@NotNull Uri uri2) {
        Intrinsics.checkNotNullParameter(uri2, "<set-?>");
        this.uri = uri2;
    }
}
