package com.instabug.bug.view.visualusersteps.steppreview;

import android.os.Bundle;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class a {
    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public final b a(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        String string = bundle.getString("title", "");
        String string2 = bundle.getString("screen_name", "");
        String string3 = bundle.getString("uri", "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(KEY_TITLE, \"\")");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(KEY_SCREENSHOT_URI, \"\")");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(KEY_SCREEN_NAME, \"\")");
        return new b(string, string3, string2);
    }
}
