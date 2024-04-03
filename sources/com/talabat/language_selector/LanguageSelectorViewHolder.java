package com.talabat.language_selector;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcore.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import os.a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0013"}, d2 = {"Lcom/talabat/language_selector/LanguageSelectorViewHolder;", "Lcom/talabat/talabatcore/BaseViewHolder;", "Lcom/talabat/language_selector/LanguageViewEntity;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "handleLanguageChange", "", "dialog", "Landroid/app/Dialog;", "lang", "", "languageSelected", "Lcom/talabat/language_selector/LanguageSelectorDialogClickListener;", "populate", "model", "setSelection", "view", "Landroid/view/View;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LanguageSelectorViewHolder extends BaseViewHolder<LanguageViewEntity> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LanguageSelectorViewHolder(@NotNull ViewGroup viewGroup) {
        super(viewGroup, R.layout.language_selector_item);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    private final void handleLanguageChange(Dialog dialog, String str, LanguageSelectorDialogClickListener languageSelectorDialogClickListener) {
        if (Intrinsics.areEqual((Object) GlobalDataModel.SelectedLanguage, (Object) str)) {
            dialog.dismiss();
            return;
        }
        dialog.dismiss();
        languageSelectorDialogClickListener.onLanguageChanged(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: populate$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10679populate$lambda1$lambda0(LanguageSelectorViewHolder languageSelectorViewHolder, LanguageViewEntity languageViewEntity, View view) {
        Intrinsics.checkNotNullParameter(languageSelectorViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(languageViewEntity, "$model");
        languageSelectorViewHolder.handleLanguageChange(languageViewEntity.getDialog(), languageViewEntity.getSelectedLanguage(), languageViewEntity.getLanguageSelected());
    }

    private final void setSelection(LanguageViewEntity languageViewEntity, View view) {
        if (languageViewEntity.getSelected()) {
            ((ImageView) view.findViewById(R.id.language_selector)).setImageResource(R.drawable.ic_m_check_selector);
        } else {
            ((ImageView) view.findViewById(R.id.language_selector)).setImageResource(R.drawable.ic_m_radio_unselected);
        }
    }

    public void populate(@NotNull LanguageViewEntity languageViewEntity) {
        Intrinsics.checkNotNullParameter(languageViewEntity, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        View view = this.itemView;
        ((TalabatTextView) view.findViewById(R.id.language_text)).setText(languageViewEntity.getDisplayedLanguage());
        Intrinsics.checkNotNullExpressionValue(view, "this");
        setSelection(languageViewEntity, view);
        ((RelativeLayout) view.findViewById(R.id.language_row)).setOnClickListener(new a(this, languageViewEntity));
    }
}
