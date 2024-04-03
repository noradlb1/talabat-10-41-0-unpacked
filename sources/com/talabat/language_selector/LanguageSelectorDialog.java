package com.talabat.language_selector;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import androidx.annotation.StyleRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class LanguageSelectorDialog {
    private Activity activity;
    private RecyclerView languageRecyclerView;
    private LanguageSelectorDialogClickListener languageSelectorDialogClickListener;
    private SupportedLanguagesProvider supportedLanguagesProvider;
    private int themeResId;

    public LanguageSelectorDialog(Activity activity2, @StyleRes int i11, LanguageSelectorDialogClickListener languageSelectorDialogClickListener2) {
        this.activity = activity2;
        this.themeResId = i11;
        this.languageSelectorDialogClickListener = languageSelectorDialogClickListener2;
        initView();
    }

    private void ConfigureDialog(Dialog dialog) {
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.language_selector_popup);
        dialog.getWindow().addFlags(4);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        dialog.getWindow().setLayout((int) (((double) displayMetrics.widthPixels) * 0.9d), -2);
    }

    private void initSupportedLanguages(Dialog dialog) {
        this.languageRecyclerView = (RecyclerView) dialog.findViewById(R.id.language_recyclerView);
        LanguageSelectorAdapter languageSelectorAdapter = new LanguageSelectorAdapter();
        this.supportedLanguagesProvider = new SupportedLanguagesProvider(this.activity, dialog, this.languageSelectorDialogClickListener);
        this.languageRecyclerView.setLayoutManager(new LinearLayoutManager(this.activity));
        this.languageRecyclerView.setAdapter(languageSelectorAdapter);
        languageSelectorAdapter.updatePointHistory(this.supportedLanguagesProvider.getSupportedLanguages());
    }

    private void initView() {
        Dialog dialog = new Dialog(this.activity, this.themeResId);
        ConfigureDialog(dialog);
        initSupportedLanguages(dialog);
        dialog.show();
    }
}
