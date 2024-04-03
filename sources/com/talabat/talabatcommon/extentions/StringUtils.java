package com.talabat.talabatcommon.extentions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0003\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\f\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"NOT_AVAILABLE", "", "empty", "Lkotlin/String$Companion;", "localized", "context", "Landroid/content/Context;", "notAvailable", "openUrlInBrowser", "", "vendorImage", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "StringUtils")
public final class StringUtils {
    @NotNull
    private static final String NOT_AVAILABLE = "NA";

    @NotNull
    public static final String empty(@NotNull StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        return "";
    }

    @NotNull
    public static final String localized(@NotNull String str, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String string = context.getString(Integer.parseInt(str));
            Intrinsics.checkNotNullExpressionValue(string, "{\n        context.getString(this.toInt())\n    }");
            return string;
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    @NotNull
    public static final String notAvailable(@NotNull StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        return "NA";
    }

    public static final void openUrlInBrowser(@NotNull String str, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    @NotNull
    public static final String vendorImage(@Nullable String str) {
        String str2 = GlobalDataModel.imageBaseUrl;
        return str2 + "restaurants/" + str;
    }
}
