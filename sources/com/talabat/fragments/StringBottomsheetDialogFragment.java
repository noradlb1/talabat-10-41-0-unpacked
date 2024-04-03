package com.talabat.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.talabat.R;
import com.talabat.TalabatTextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mq.s;
import mq.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0004\u0015\u0016\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/fragments/StringBottomsheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "mListener", "Lcom/talabat/fragments/StringBottomsheetDialogFragment$Listener;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onViewCreated", "view", "Companion", "ItemAdapter", "Listener", "ViewHolder", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StringBottomsheetDialogFragment extends BottomSheetDialogFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    @Nullable
    public Listener mListener;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00070\u0004¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/talabat/fragments/StringBottomsheetDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/talabat/fragments/StringBottomsheetDialogFragment;", "Lorg/jetbrains/annotations/NotNull;", "layoutId", "", "dataList", "Ljava/util/ArrayList;", "", "dialogTitle", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StringBottomsheetDialogFragment newInstance(int i11, @NotNull ArrayList<String> arrayList, @NotNull String str) {
            Intrinsics.checkNotNullParameter(arrayList, "dataList");
            Intrinsics.checkNotNullParameter(str, "dialogTitle");
            StringBottomsheetDialogFragment stringBottomsheetDialogFragment = new StringBottomsheetDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(StringBottomsheetDialogFragmentKt.ARG_VIEW_ID, i11);
            bundle.putStringArrayList(StringBottomsheetDialogFragmentKt.ARG_DATA_LIST, arrayList);
            bundle.putString("dialog_title", str);
            stringBottomsheetDialogFragment.setArguments(bundle);
            return stringBottomsheetDialogFragment;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0015\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/fragments/StringBottomsheetDialogFragment$ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/fragments/StringBottomsheetDialogFragment$ViewHolder;", "Lcom/talabat/fragments/StringBottomsheetDialogFragment;", "timings", "Ljava/util/ArrayList;", "", "(Lcom/talabat/fragments/StringBottomsheetDialogFragment;Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ItemAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ StringBottomsheetDialogFragment f59825i;
        @NotNull
        private final ArrayList<String> timings;

        public ItemAdapter(@NotNull StringBottomsheetDialogFragment stringBottomsheetDialogFragment, ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "timings");
            this.f59825i = stringBottomsheetDialogFragment;
            this.timings = arrayList;
        }

        public int getItemCount() {
            return this.timings.size();
        }

        public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            viewHolder.getText$com_talabat_talabat_talabat().setText(this.timings.get(i11));
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            StringBottomsheetDialogFragment stringBottomsheetDialogFragment = this.f59825i;
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "from(parent.context)");
            return new ViewHolder(stringBottomsheetDialogFragment, from, viewGroup);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/fragments/StringBottomsheetDialogFragment$Listener;", "", "onItemClicked", "", "position", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Listener {
        void onItemClicked(@NotNull String str);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/fragments/StringBottomsheetDialogFragment$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "(Lcom/talabat/fragments/StringBottomsheetDialogFragment;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)V", "text", "Landroid/widget/TextView;", "getText$com_talabat_talabat_talabat", "()Landroid/widget/TextView;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ StringBottomsheetDialogFragment f59826h;
        @NotNull
        private final TextView text;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ViewHolder(@org.jetbrains.annotations.NotNull com.talabat.fragments.StringBottomsheetDialogFragment r3, @org.jetbrains.annotations.NotNull android.view.LayoutInflater r4, android.view.ViewGroup r5) {
            /*
                r2 = this;
                java.lang.String r0 = "inflater"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "parent"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                r2.f59826h = r3
                android.os.Bundle r0 = r3.getArguments()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                java.lang.String r1 = "view_id"
                int r0 = r0.getInt(r1)
                r1 = 0
                android.view.View r4 = r4.inflate(r0, r5, r1)
                r2.<init>(r4)
                android.view.View r4 = r2.itemView
                int r5 = com.talabat.R.id.value_text_view
                android.view.View r4 = r4.findViewById(r5)
                android.widget.TextView r4 = (android.widget.TextView) r4
                java.lang.String r5 = "itemView.value_text_view"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                r2.text = r4
                com.talabat.fragments.b r5 = new com.talabat.fragments.b
                r5.<init>(r3, r2)
                r4.setOnClickListener(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.fragments.StringBottomsheetDialogFragment.ViewHolder.<init>(com.talabat.fragments.StringBottomsheetDialogFragment, android.view.LayoutInflater, android.view.ViewGroup):void");
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-1  reason: not valid java name */
        public static final void m10498_init_$lambda1(StringBottomsheetDialogFragment stringBottomsheetDialogFragment, ViewHolder viewHolder, View view) {
            Intrinsics.checkNotNullParameter(stringBottomsheetDialogFragment, "this$0");
            Intrinsics.checkNotNullParameter(viewHolder, "this$1");
            Listener access$getMListener$p = stringBottomsheetDialogFragment.mListener;
            if (access$getMListener$p != null) {
                access$getMListener$p.onItemClicked(viewHolder.text.getText().toString());
                stringBottomsheetDialogFragment.dismiss();
            }
        }

        @NotNull
        public final TextView getText$com_talabat_talabat_talabat() {
            return this.text;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m10496onViewCreated$lambda0(StringBottomsheetDialogFragment stringBottomsheetDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(stringBottomsheetDialogFragment, "this$0");
        stringBottomsheetDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m10497onViewCreated$lambda1(StringBottomsheetDialogFragment stringBottomsheetDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(stringBottomsheetDialogFragment, "this$0");
        stringBottomsheetDialogFragment.dismiss();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            this.mListener = (Listener) parentFragment;
        } else {
            this.mListener = (Listener) context;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.AppBottomSheetDialogTheme);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_item_list_dialog, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        this.mListener = null;
        super.onDetach();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Intrinsics.checkNotNull(arguments);
        ((TalabatTextView) _$_findCachedViewById(R.id.bottom_sheet_title)).setText(arguments.getString("dialog_title"));
        ((LinearLayout) _$_findCachedViewById(R.id.close_categories_view)).setOnClickListener(new s(this));
        ((ImageView) _$_findCachedViewById(R.id.close_categories)).setOnClickListener(new t(this));
        int i11 = R.id.list;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i11);
        Bundle arguments2 = getArguments();
        Intrinsics.checkNotNull(arguments2);
        ArrayList<String> stringArrayList = arguments2.getStringArrayList(StringBottomsheetDialogFragmentKt.ARG_DATA_LIST);
        if (stringArrayList == null) {
            stringArrayList = new ArrayList<>();
        }
        recyclerView.setAdapter(new ItemAdapter(this, stringArrayList));
    }
}
