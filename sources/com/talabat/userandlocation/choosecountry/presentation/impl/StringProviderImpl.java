package com.talabat.userandlocation.choosecountry.presentation.impl;

import android.content.res.Resources;
import com.talabat.localization.R;
import com.talabat.userandlocation.choosecountry.presentation.StringProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/presentation/impl/StringProviderImpl;", "Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "clearCartConfirmationStrings", "Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider$ClearCartConfirmationStrings;", "getClearCartConfirmationStrings", "()Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider$ClearCartConfirmationStrings;", "genericErrorMessage", "", "getGenericErrorMessage", "()Ljava/lang/String;", "screenTitle", "getScreenTitle", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StringProviderImpl implements StringProvider {
    @NotNull
    private final Resources resources;

    public StringProviderImpl(@NotNull Resources resources2) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        this.resources = resources2;
    }

    @NotNull
    public StringProvider.ClearCartConfirmationStrings getClearCartConfirmationStrings() {
        String string = this.resources.getString(R.string.dialog_title_clear_cart);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.….dialog_title_clear_cart)");
        String string2 = this.resources.getString(R.string.dialog_message_clear_cart);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(com.…ialog_message_clear_cart)");
        String string3 = this.resources.getString(R.string.yes);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(com.…ocalization.R.string.yes)");
        String string4 = this.resources.getString(R.string.f61015no);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(com.…localization.R.string.no)");
        return new StringProvider.ClearCartConfirmationStrings(string, string2, string3, string4);
    }

    @NotNull
    public String getGenericErrorMessage() {
        String string = this.resources.getString(R.string.generic_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…n.R.string.generic_error)");
        return string;
    }

    @NotNull
    public String getScreenTitle() {
        String string = this.resources.getString(R.string.title_activity_select_country);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…_activity_select_country)");
        return string;
    }
}
