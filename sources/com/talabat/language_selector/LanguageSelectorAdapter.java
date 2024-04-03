package com.talabat.language_selector;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/language_selector/LanguageSelectorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/language_selector/LanguageSelectorViewHolder;", "supportedLanguages", "", "Lcom/talabat/language_selector/LanguageViewEntity;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updatePointHistory", "items", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LanguageSelectorAdapter extends RecyclerView.Adapter<LanguageSelectorViewHolder> {
    @NotNull
    private List<LanguageViewEntity> supportedLanguages;

    public LanguageSelectorAdapter() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LanguageSelectorAdapter(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }

    public int getItemCount() {
        return this.supportedLanguages.size();
    }

    public final void updatePointHistory(@NotNull List<LanguageViewEntity> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.supportedLanguages = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull LanguageSelectorViewHolder languageSelectorViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(languageSelectorViewHolder, "holder");
        languageSelectorViewHolder.populate(this.supportedLanguages.get(i11));
    }

    @NotNull
    public LanguageSelectorViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new LanguageSelectorViewHolder(viewGroup);
    }

    public LanguageSelectorAdapter(@NotNull List<LanguageViewEntity> list) {
        Intrinsics.checkNotNullParameter(list, "supportedLanguages");
        this.supportedLanguages = list;
    }
}
