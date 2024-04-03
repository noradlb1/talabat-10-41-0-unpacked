package com.talabat.adapters.grocery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import ye.a;
import ye.b;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0016J\u0014\u0010$\u001a\u00020\u001d2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/talabat/adapters/grocery/SearchHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/adapters/grocery/SearchHistoryAdapter$SearchHistoryItemViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/talabat/adapters/grocery/SearchHistoryAdapter$onTermSelectedListener;", "(Landroid/content/Context;Lcom/talabat/adapters/grocery/SearchHistoryAdapter$onTermSelectedListener;)V", "cellClicklistener", "getCellClicklistener", "()Lcom/talabat/adapters/grocery/SearchHistoryAdapter$onTermSelectedListener;", "setCellClicklistener", "(Lcom/talabat/adapters/grocery/SearchHistoryAdapter$onTermSelectedListener;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getListener", "setListener", "searchHistoryTermsLocalList", "Ljava/util/ArrayList;", "", "getSearchHistoryTermsLocalList", "()Ljava/util/ArrayList;", "setSearchHistoryTermsLocalList", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setNewList", "newSearchTermsList", "SearchHistoryItemViewHolder", "onTermSelectedListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryItemViewHolder> {
    @NotNull
    private onTermSelectedListener cellClicklistener = this.listener;
    @NotNull
    private Context context;
    @NotNull
    private onTermSelectedListener listener;
    @NotNull
    private ArrayList<String> searchHistoryTermsLocalList = new ArrayList<>();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/adapters/grocery/SearchHistoryAdapter$SearchHistoryItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "cell", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "getCell", "()Landroid/widget/RelativeLayout;", "setCell", "(Landroid/widget/RelativeLayout;)V", "searchTerm", "Landroid/widget/TextView;", "getSearchTerm", "()Landroid/widget/TextView;", "setSearchTerm", "(Landroid/widget/TextView;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SearchHistoryItemViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout cell;
        @NotNull
        private TextView searchTerm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SearchHistoryItemViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            TalabatTextView talabatTextView = (TalabatTextView) view.findViewById(R.id.search_term);
            Intrinsics.checkNotNullExpressionValue(talabatTextView, "itemView.search_term");
            this.searchTerm = talabatTextView;
            this.cell = (RelativeLayout) view.findViewById(R.id.search_history_cell);
        }

        public final RelativeLayout getCell() {
            return this.cell;
        }

        @NotNull
        public final TextView getSearchTerm() {
            return this.searchTerm;
        }

        public final void setCell(RelativeLayout relativeLayout) {
            this.cell = relativeLayout;
        }

        public final void setSearchTerm(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.searchTerm = textView;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/adapters/grocery/SearchHistoryAdapter$onTermSelectedListener;", "", "onSearchTermSelected", "", "searchTerm", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface onTermSelectedListener {
        void onSearchTermSelected(@NotNull String str);
    }

    public SearchHistoryAdapter(@NotNull Context context2, @NotNull onTermSelectedListener ontermselectedlistener) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(ontermselectedlistener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.context = context2;
        this.listener = ontermselectedlistener;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9496onBindViewHolder$lambda0(SearchHistoryAdapter searchHistoryAdapter, Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(searchHistoryAdapter, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$searchTermItem");
        searchHistoryAdapter.cellClicklistener.onSearchTermSelected((String) objectRef.element);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m9497onBindViewHolder$lambda1(SearchHistoryItemViewHolder searchHistoryItemViewHolder, View view) {
        Intrinsics.checkNotNullParameter(searchHistoryItemViewHolder, "$holder");
        searchHistoryItemViewHolder.getCell().performClick();
    }

    @NotNull
    public final onTermSelectedListener getCellClicklistener() {
        return this.cellClicklistener;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public int getItemCount() {
        return this.searchHistoryTermsLocalList.size();
    }

    @NotNull
    public final onTermSelectedListener getListener() {
        return this.listener;
    }

    @NotNull
    public final ArrayList<String> getSearchHistoryTermsLocalList() {
        return this.searchHistoryTermsLocalList;
    }

    public final void setCellClicklistener(@NotNull onTermSelectedListener ontermselectedlistener) {
        Intrinsics.checkNotNullParameter(ontermselectedlistener, "<set-?>");
        this.cellClicklistener = ontermselectedlistener;
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setListener(@NotNull onTermSelectedListener ontermselectedlistener) {
        Intrinsics.checkNotNullParameter(ontermselectedlistener, "<set-?>");
        this.listener = ontermselectedlistener;
    }

    public final void setNewList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "newSearchTermsList");
        if (!this.searchHistoryTermsLocalList.isEmpty()) {
            this.searchHistoryTermsLocalList.clear();
        }
        this.searchHistoryTermsLocalList.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final void setSearchHistoryTermsLocalList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.searchHistoryTermsLocalList = arrayList;
    }

    public void onBindViewHolder(@NotNull SearchHistoryItemViewHolder searchHistoryItemViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(searchHistoryItemViewHolder, "holder");
        if (this.searchHistoryTermsLocalList.size() > 0) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            T t11 = this.searchHistoryTermsLocalList.get(i11);
            Intrinsics.checkNotNullExpressionValue(t11, "searchHistoryTermsLocalList.get(position)");
            objectRef.element = t11;
            if (!TalabatUtils.isNullOrEmpty((String) t11)) {
                searchHistoryItemViewHolder.getSearchTerm().setText((CharSequence) objectRef.element);
                searchHistoryItemViewHolder.getCell().setOnClickListener(new a(this, objectRef));
                searchHistoryItemViewHolder.getSearchTerm().setOnClickListener(new b(searchHistoryItemViewHolder));
            }
        }
    }

    @NotNull
    public SearchHistoryItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_history_list_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        return new SearchHistoryItemViewHolder(inflate);
    }
}
