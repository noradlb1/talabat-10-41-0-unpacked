package com.talabat.language_selector;

import android.app.Dialog;
import androidx.navigation.compose.DialogNavigator;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006 "}, d2 = {"Lcom/talabat/language_selector/LanguageViewEntity;", "", "displayedLanguage", "", "selected", "", "dialog", "Landroid/app/Dialog;", "selectedLanguage", "languageSelected", "Lcom/talabat/language_selector/LanguageSelectorDialogClickListener;", "(Ljava/lang/String;ZLandroid/app/Dialog;Ljava/lang/String;Lcom/talabat/language_selector/LanguageSelectorDialogClickListener;)V", "getDialog", "()Landroid/app/Dialog;", "getDisplayedLanguage", "()Ljava/lang/String;", "getLanguageSelected", "()Lcom/talabat/language_selector/LanguageSelectorDialogClickListener;", "getSelected", "()Z", "getSelectedLanguage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LanguageViewEntity {
    @NotNull
    private final Dialog dialog;
    @NotNull
    private final String displayedLanguage;
    @NotNull
    private final LanguageSelectorDialogClickListener languageSelected;
    private final boolean selected;
    @NotNull
    private final String selectedLanguage;

    public LanguageViewEntity(@NotNull String str, boolean z11, @NotNull Dialog dialog2, @NotNull String str2, @NotNull LanguageSelectorDialogClickListener languageSelectorDialogClickListener) {
        Intrinsics.checkNotNullParameter(str, "displayedLanguage");
        Intrinsics.checkNotNullParameter(dialog2, DialogNavigator.NAME);
        Intrinsics.checkNotNullParameter(str2, "selectedLanguage");
        Intrinsics.checkNotNullParameter(languageSelectorDialogClickListener, ConstantsKt.SELECTED_LANGUAGE);
        this.displayedLanguage = str;
        this.selected = z11;
        this.dialog = dialog2;
        this.selectedLanguage = str2;
        this.languageSelected = languageSelectorDialogClickListener;
    }

    public static /* synthetic */ LanguageViewEntity copy$default(LanguageViewEntity languageViewEntity, String str, boolean z11, Dialog dialog2, String str2, LanguageSelectorDialogClickListener languageSelectorDialogClickListener, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = languageViewEntity.displayedLanguage;
        }
        if ((i11 & 2) != 0) {
            z11 = languageViewEntity.selected;
        }
        boolean z12 = z11;
        if ((i11 & 4) != 0) {
            dialog2 = languageViewEntity.dialog;
        }
        Dialog dialog3 = dialog2;
        if ((i11 & 8) != 0) {
            str2 = languageViewEntity.selectedLanguage;
        }
        String str3 = str2;
        if ((i11 & 16) != 0) {
            languageSelectorDialogClickListener = languageViewEntity.languageSelected;
        }
        return languageViewEntity.copy(str, z12, dialog3, str3, languageSelectorDialogClickListener);
    }

    @NotNull
    public final String component1() {
        return this.displayedLanguage;
    }

    public final boolean component2() {
        return this.selected;
    }

    @NotNull
    public final Dialog component3() {
        return this.dialog;
    }

    @NotNull
    public final String component4() {
        return this.selectedLanguage;
    }

    @NotNull
    public final LanguageSelectorDialogClickListener component5() {
        return this.languageSelected;
    }

    @NotNull
    public final LanguageViewEntity copy(@NotNull String str, boolean z11, @NotNull Dialog dialog2, @NotNull String str2, @NotNull LanguageSelectorDialogClickListener languageSelectorDialogClickListener) {
        Intrinsics.checkNotNullParameter(str, "displayedLanguage");
        Intrinsics.checkNotNullParameter(dialog2, DialogNavigator.NAME);
        Intrinsics.checkNotNullParameter(str2, "selectedLanguage");
        Intrinsics.checkNotNullParameter(languageSelectorDialogClickListener, ConstantsKt.SELECTED_LANGUAGE);
        return new LanguageViewEntity(str, z11, dialog2, str2, languageSelectorDialogClickListener);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LanguageViewEntity)) {
            return false;
        }
        LanguageViewEntity languageViewEntity = (LanguageViewEntity) obj;
        return Intrinsics.areEqual((Object) this.displayedLanguage, (Object) languageViewEntity.displayedLanguage) && this.selected == languageViewEntity.selected && Intrinsics.areEqual((Object) this.dialog, (Object) languageViewEntity.dialog) && Intrinsics.areEqual((Object) this.selectedLanguage, (Object) languageViewEntity.selectedLanguage) && Intrinsics.areEqual((Object) this.languageSelected, (Object) languageViewEntity.languageSelected);
    }

    @NotNull
    public final Dialog getDialog() {
        return this.dialog;
    }

    @NotNull
    public final String getDisplayedLanguage() {
        return this.displayedLanguage;
    }

    @NotNull
    public final LanguageSelectorDialogClickListener getLanguageSelected() {
        return this.languageSelected;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final String getSelectedLanguage() {
        return this.selectedLanguage;
    }

    public int hashCode() {
        int hashCode = this.displayedLanguage.hashCode() * 31;
        boolean z11 = this.selected;
        if (z11) {
            z11 = true;
        }
        return ((((((hashCode + (z11 ? 1 : 0)) * 31) + this.dialog.hashCode()) * 31) + this.selectedLanguage.hashCode()) * 31) + this.languageSelected.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.displayedLanguage;
        boolean z11 = this.selected;
        Dialog dialog2 = this.dialog;
        String str2 = this.selectedLanguage;
        LanguageSelectorDialogClickListener languageSelectorDialogClickListener = this.languageSelected;
        return "LanguageViewEntity(displayedLanguage=" + str + ", selected=" + z11 + ", dialog=" + dialog2 + ", selectedLanguage=" + str2 + ", languageSelected=" + languageSelectorDialogClickListener + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LanguageViewEntity(String str, boolean z11, Dialog dialog2, String str2, LanguageSelectorDialogClickListener languageSelectorDialogClickListener, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? false : z11, dialog2, str2, languageSelectorDialogClickListener);
    }
}
