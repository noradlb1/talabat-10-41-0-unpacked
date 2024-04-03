package os;

import android.view.View;
import com.talabat.language_selector.LanguageSelectorViewHolder;
import com.talabat.language_selector.LanguageViewEntity;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LanguageSelectorViewHolder f62770b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LanguageViewEntity f62771c;

    public /* synthetic */ a(LanguageSelectorViewHolder languageSelectorViewHolder, LanguageViewEntity languageViewEntity) {
        this.f62770b = languageSelectorViewHolder;
        this.f62771c = languageViewEntity;
    }

    public final void onClick(View view) {
        LanguageSelectorViewHolder.m10679populate$lambda1$lambda0(this.f62770b, this.f62771c, view);
    }
}
