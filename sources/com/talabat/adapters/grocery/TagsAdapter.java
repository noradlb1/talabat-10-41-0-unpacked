package com.talabat.adapters.grocery;

import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.GroceryDetailsViewScreen;
import com.talabat.R;
import com.talabat.TalabatTextView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ye.c;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000267B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\u001bJ\u001c\u0010)\u001a\u00020$2\n\u0010*\u001a\u00060\u0002R\u00020\u00002\u0006\u0010+\u001a\u00020&H\u0016J\u001c\u0010,\u001a\u00060\u0002R\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&H\u0016J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u001fH\u0002J\u0016\u0010\u0018\u001a\u00020$2\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0019J\u0014\u00104\u001a\u00020$2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004X\u000e¢\u0006\u0002\n\u0000R \u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/talabat/adapters/grocery/TagsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/adapters/grocery/TagsAdapter$TagItemViewHolder;", "tagsListOriginal", "Ljava/util/ArrayList;", "LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "context", "Landroid/content/Context;", "listener", "Lcom/talabat/adapters/grocery/TagsAdapter$onTagSelectedListener;", "(Ljava/util/ArrayList;Landroid/content/Context;Lcom/talabat/adapters/grocery/TagsAdapter$onTagSelectedListener;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getListener", "()Lcom/talabat/adapters/grocery/TagsAdapter$onTagSelectedListener;", "setListener", "(Lcom/talabat/adapters/grocery/TagsAdapter$onTagSelectedListener;)V", "selectedTagsList", "getSelectedTagsList", "()Ljava/util/ArrayList;", "setSelectedTagsList", "(Ljava/util/ArrayList;)V", "setAllSelected", "", "tagIdList", "", "getTagIdList", "setTagIdList", "tagListMutex", "Landroid/widget/TextView;", "tagsList", "getTagsList", "setTagsList", "clearSelection", "", "getItemCount", "", "getTagIdString", "getTagNameString", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onTagSelected", "textView", "setAll", "notify", "setTagsArray", "groceryTagsModels", "TagItemViewHolder", "onTagSelectedListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TagsAdapter extends RecyclerView.Adapter<TagItemViewHolder> {
    @NotNull
    private Context context;
    @NotNull
    private onTagSelectedListener listener;
    @NotNull
    private ArrayList<GroceryTagsModel> selectedTagsList = new ArrayList<>();
    private boolean setAllSelected;
    @NotNull
    private ArrayList<String> tagIdList = new ArrayList<>();
    @NotNull
    private ArrayList<TextView> tagListMutex = new ArrayList<>();
    @NotNull
    private ArrayList<GroceryTagsModel> tagsList;
    @NotNull
    private final ArrayList<GroceryTagsModel> tagsListOriginal;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/adapters/grocery/TagsAdapter$TagItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/talabat/adapters/grocery/TagsAdapter;Landroid/view/View;)V", "tagName", "Landroid/widget/TextView;", "getTagName", "()Landroid/widget/TextView;", "setTagName", "(Landroid/widget/TextView;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TagItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TagsAdapter f55268h;
        @NotNull
        private TextView tagName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TagItemViewHolder(@NotNull TagsAdapter tagsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f55268h = tagsAdapter;
            TalabatTextView talabatTextView = (TalabatTextView) view.findViewById(R.id.tag_text_view);
            Intrinsics.checkNotNullExpressionValue(talabatTextView, "itemView.tag_text_view");
            this.tagName = talabatTextView;
        }

        @NotNull
        public final TextView getTagName() {
            return this.tagName;
        }

        public final void setTagName(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tagName = textView;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/adapters/grocery/TagsAdapter$onTagSelectedListener;", "", "onTagSelected", "", "tagsString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface onTagSelectedListener {
        void onTagSelected(@NotNull String str);
    }

    public TagsAdapter(@NotNull ArrayList<GroceryTagsModel> arrayList, @NotNull Context context2, @NotNull onTagSelectedListener ontagselectedlistener) {
        Intrinsics.checkNotNullParameter(arrayList, "tagsListOriginal");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(ontagselectedlistener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.tagsListOriginal = arrayList;
        this.context = context2;
        this.listener = ontagselectedlistener;
        this.tagsList = arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9498onBindViewHolder$lambda0(TagsAdapter tagsAdapter, GroceryTagsModel groceryTagsModel, TagItemViewHolder tagItemViewHolder, View view) {
        boolean z11;
        Intrinsics.checkNotNullParameter(tagsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(groceryTagsModel, "$item");
        Intrinsics.checkNotNullParameter(tagItemViewHolder, "$holder");
        if (!tagsAdapter.tagIdList.contains(String.valueOf(groceryTagsModel.getTagId()))) {
            tagsAdapter.tagIdList.clear();
            tagsAdapter.tagIdList.add(String.valueOf(groceryTagsModel.getTagId()));
            if (tagsAdapter.getTagIdString().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                tagsAdapter.listener.onTagSelected(tagsAdapter.getTagIdString());
            }
            tagsAdapter.onTagSelected(tagItemViewHolder.getTagName());
        }
        if (!tagsAdapter.selectedTagsList.contains(groceryTagsModel)) {
            tagsAdapter.selectedTagsList.clear();
            tagsAdapter.selectedTagsList.add(groceryTagsModel);
            tagsAdapter.listener.onTagSelected(tagsAdapter.getTagIdString());
            tagsAdapter.onTagSelected(tagItemViewHolder.getTagName());
        }
        tagsAdapter.getTagIdString();
    }

    private final void onTagSelected(TextView textView) {
        Iterator<TextView> it = this.tagListMutex.iterator();
        while (it.hasNext()) {
            TextView next = it.next();
            if (next == textView) {
                next.setBackground(ContextCompat.getDrawable(this.context, R.drawable.bg_m_grocery_tag_selected));
                next.setTextColor(this.context.getResources().getColor(R.color.ds_primary_100));
            } else {
                if (next != null) {
                    next.setBackground(ContextCompat.getDrawable(this.context, R.drawable.bg_m_grocery_tag_not_selected));
                }
                if (next != null) {
                    next.setTextColor(this.context.getResources().getColor(R.color.black));
                }
            }
        }
    }

    public final void clearSelection() {
        if (!this.tagIdList.isEmpty()) {
            this.tagIdList.clear();
        }
        if (!this.selectedTagsList.isEmpty()) {
            this.selectedTagsList.clear();
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public int getItemCount() {
        ArrayList<GroceryTagsModel> arrayList = this.tagsList;
        Intrinsics.checkNotNull(arrayList);
        return arrayList.size();
    }

    @NotNull
    public final onTagSelectedListener getListener() {
        return this.listener;
    }

    @NotNull
    public final ArrayList<GroceryTagsModel> getSelectedTagsList() {
        return this.selectedTagsList;
    }

    @NotNull
    public final ArrayList<String> getTagIdList() {
        return this.tagIdList;
    }

    @NotNull
    public final String getTagIdString() {
        boolean z11;
        if (!(!this.tagIdList.isEmpty())) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.tagIdList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (sb2.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                sb2.append(",");
            }
            sb2.append(next);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "stringBuilder.toString()");
        return sb3;
    }

    @NotNull
    public final String getTagNameString() {
        boolean z11;
        if (!(!this.selectedTagsList.isEmpty())) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<GroceryTagsModel> it = this.selectedTagsList.iterator();
        while (it.hasNext()) {
            GroceryTagsModel next = it.next();
            if (next.getTagId() != -1) {
                if (sb2.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    sb2.append(",");
                }
                sb2.append(next.getTagName());
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "stringBuilder.toString()");
        return sb3;
    }

    @NotNull
    public final ArrayList<GroceryTagsModel> getTagsList() {
        return this.tagsList;
    }

    public final void setAllSelected(boolean z11, boolean z12) {
        if (z11) {
            this.setAllSelected = z11;
            if (z12) {
                notifyDataSetChanged();
            }
        }
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setListener(@NotNull onTagSelectedListener ontagselectedlistener) {
        Intrinsics.checkNotNullParameter(ontagselectedlistener, "<set-?>");
        this.listener = ontagselectedlistener;
    }

    public final void setSelectedTagsList(@NotNull ArrayList<GroceryTagsModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.selectedTagsList = arrayList;
    }

    public final void setTagIdList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.tagIdList = arrayList;
    }

    public final void setTagsArray(@NotNull ArrayList<GroceryTagsModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "groceryTagsModels");
        if (this.tagsList.size() > 0) {
            this.tagsList.clear();
        }
        this.tagsList.addAll(arrayList);
    }

    public final void setTagsList(@NotNull ArrayList<GroceryTagsModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.tagsList = arrayList;
    }

    public void onBindViewHolder(@NotNull TagItemViewHolder tagItemViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(tagItemViewHolder, "holder");
        GroceryTagsModel groceryTagsModel = this.tagsList.get(i11);
        Intrinsics.checkNotNullExpressionValue(groceryTagsModel, "tagsList[position]");
        GroceryTagsModel groceryTagsModel2 = groceryTagsModel;
        tagItemViewHolder.getTagName().setText(StringsKt__StringsKt.trim((CharSequence) groceryTagsModel2.getTagName()).toString());
        this.tagListMutex.add(tagItemViewHolder.getTagName());
        if (this.setAllSelected) {
            this.tagIdList.clear();
            this.selectedTagsList.clear();
        }
        if (groceryTagsModel2.getTagId() == -1 && (this.tagIdList.isEmpty() || this.setAllSelected)) {
            onTagSelected(tagItemViewHolder.getTagName());
            if (this.context instanceof GroceryDetailsViewScreen) {
                this.listener.onTagSelected(getTagIdString());
            }
        }
        tagItemViewHolder.getTagName().setOnClickListener(new c(this, groceryTagsModel2, tagItemViewHolder));
    }

    @NotNull
    public TagItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grocery_tag_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        return new TagItemViewHolder(this, inflate);
    }
}
