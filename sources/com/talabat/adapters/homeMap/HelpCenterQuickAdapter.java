package com.talabat.adapters.homeMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.R;
import datamodels.Area;
import datamodels.HelpExpandableListViewModel;
import datamodels.HelpQuickDesc;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ze.e;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003567B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J2\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010*\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J*\u0010,\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010.\u001a\u00020$H\u0016J\u0018\u0010/\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u001a\u00100\u001a\u0002012\u0006\u00102\u001a\u00020$2\b\u00103\u001a\u0004\u0018\u000104H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u00068"}, d2 = {"Lcom/talabat/adapters/homeMap/HelpCenterQuickAdapter;", "Landroid/widget/BaseExpandableListAdapter;", "context", "Landroid/content/Context;", "displayData", "", "Ldatamodels/HelpExpandableListViewModel;", "listener", "Lcom/talabat/adapters/homeMap/HelpCenterQuickAdapter$onItemClickListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/talabat/adapters/homeMap/HelpCenterQuickAdapter$onItemClickListener;)V", "areaHighLight", "", "getContext", "()Landroid/content/Context;", "getDisplayData", "()Ljava/util/List;", "setDisplayData", "(Ljava/util/List;)V", "highlightCityId", "inflater", "Landroid/view/LayoutInflater;", "getInflater", "()Landroid/view/LayoutInflater;", "setInflater", "(Landroid/view/LayoutInflater;)V", "getListener", "()Lcom/talabat/adapters/homeMap/HelpCenterQuickAdapter$onItemClickListener;", "getChild", "", "groupPosition", "childPosition", "getChildId", "", "getChildView", "Landroid/view/View;", "isLastChild", "", "convertView", "parent", "Landroid/view/ViewGroup;", "getChildrenCount", "getGroup", "getGroupCount", "getGroupId", "getGroupView", "isExpanded", "hasStableIds", "isChildSelectable", "isExpandIcon", "", "isExpand", "img", "Landroid/widget/ImageView;", "ListHeaderViewHolder", "ListItemViewHolder", "onItemClickListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterQuickAdapter extends BaseExpandableListAdapter {
    private int areaHighLight = -1;
    @NotNull
    private final Context context;
    @NotNull
    private List<HelpExpandableListViewModel> displayData;
    private int highlightCityId = -1;
    @NotNull
    private LayoutInflater inflater;
    @NotNull
    private final onItemClickListener listener;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/talabat/adapters/homeMap/HelpCenterQuickAdapter$ListHeaderViewHolder;", "", "()V", "arrowImageView", "Landroid/widget/ImageView;", "getArrowImageView", "()Landroid/widget/ImageView;", "setArrowImageView", "(Landroid/widget/ImageView;)V", "bottom_seperator", "Landroid/view/View;", "getBottom_seperator", "()Landroid/view/View;", "setBottom_seperator", "(Landroid/view/View;)V", "header", "Landroid/widget/TextView;", "getHeader", "()Landroid/widget/TextView;", "setHeader", "(Landroid/widget/TextView;)V", "headerSelectedText", "getHeaderSelectedText", "setHeaderSelectedText", "top_seperator", "getTop_seperator", "setTop_seperator", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ListHeaderViewHolder {
        @Nullable
        private ImageView arrowImageView;
        @Nullable
        private View bottom_seperator;
        @Nullable
        private TextView header;
        @Nullable
        private TextView headerSelectedText;
        @Nullable
        private View top_seperator;

        @Nullable
        public final ImageView getArrowImageView() {
            return this.arrowImageView;
        }

        @Nullable
        public final View getBottom_seperator() {
            return this.bottom_seperator;
        }

        @Nullable
        public final TextView getHeader() {
            return this.header;
        }

        @Nullable
        public final TextView getHeaderSelectedText() {
            return this.headerSelectedText;
        }

        @Nullable
        public final View getTop_seperator() {
            return this.top_seperator;
        }

        public final void setArrowImageView(@Nullable ImageView imageView) {
            this.arrowImageView = imageView;
        }

        public final void setBottom_seperator(@Nullable View view) {
            this.bottom_seperator = view;
        }

        public final void setHeader(@Nullable TextView textView) {
            this.header = textView;
        }

        public final void setHeaderSelectedText(@Nullable TextView textView) {
            this.headerSelectedText = textView;
        }

        public final void setTop_seperator(@Nullable View view) {
            this.top_seperator = view;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/adapters/homeMap/HelpCenterQuickAdapter$ListItemViewHolder;", "", "()V", "bottom_seperator", "Landroid/view/View;", "getBottom_seperator", "()Landroid/view/View;", "setBottom_seperator", "(Landroid/view/View;)V", "item", "Landroid/widget/TextView;", "getItem", "()Landroid/widget/TextView;", "setItem", "(Landroid/widget/TextView;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ListItemViewHolder {
        @Nullable
        private View bottom_seperator;
        @Nullable
        private TextView item;

        @Nullable
        public final View getBottom_seperator() {
            return this.bottom_seperator;
        }

        @Nullable
        public final TextView getItem() {
            return this.item;
        }

        public final void setBottom_seperator(@Nullable View view) {
            this.bottom_seperator = view;
        }

        public final void setItem(@Nullable TextView textView) {
            this.item = textView;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/adapters/homeMap/HelpCenterQuickAdapter$onItemClickListener;", "", "onAreaSelected", "", "area", "Ldatamodels/Area;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface onItemClickListener {
        void onAreaSelected(@NotNull Area area);
    }

    public HelpCenterQuickAdapter(@NotNull Context context2, @NotNull List<HelpExpandableListViewModel> list, @NotNull onItemClickListener onitemclicklistener) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(list, "displayData");
        Intrinsics.checkNotNullParameter(onitemclicklistener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.context = context2;
        this.displayData = list;
        this.listener = onitemclicklistener;
        LayoutInflater from = LayoutInflater.from(context2);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.inflater = from;
    }

    /* access modifiers changed from: private */
    /* renamed from: getChildView$lambda-0  reason: not valid java name */
    public static final void m9503getChildView$lambda0(View view) {
    }

    private final void isExpandIcon(boolean z11, ImageView imageView) {
        if (z11) {
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_up);
            }
        } else if (imageView != null) {
            imageView.setImageResource(R.drawable.icon_down);
        }
    }

    @NotNull
    public Object getChild(int i11, int i12) {
        return this.displayData.get(i12);
    }

    public long getChildId(int i11, int i12) {
        return (long) i12;
    }

    @NotNull
    public View getChildView(int i11, int i12, boolean z11, @Nullable View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        HelpExpandableListViewModel helpExpandableListViewModel = this.displayData.get(i11);
        ListItemViewHolder listItemViewHolder = null;
        if (view == null || (view.getTag() instanceof ListHeaderViewHolder)) {
            view = this.inflater.inflate(R.layout.home_map_area_list_item, (ViewGroup) null);
            listItemViewHolder = new ListItemViewHolder();
            Intrinsics.checkNotNull(view);
            View findViewById = view.findViewById(R.id.item_text);
            if (findViewById != null) {
                listItemViewHolder.setItem((TextView) findViewById);
                listItemViewHolder.setBottom_seperator(view.findViewById(R.id.seperator_bottom));
                view.setTag(listItemViewHolder);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
        } else if (view.getTag() instanceof ListItemViewHolder) {
            Object tag = view.getTag();
            if (tag != null) {
                listItemViewHolder = (ListItemViewHolder) tag;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.adapters.homeMap.HelpCenterQuickAdapter.ListItemViewHolder");
            }
        }
        Intrinsics.checkNotNull(listItemViewHolder);
        TextView item = listItemViewHolder.getItem();
        if (item != null) {
            Intrinsics.checkNotNull(helpExpandableListViewModel);
            ArrayList<HelpQuickDesc> desc = helpExpandableListViewModel.getDesc();
            Intrinsics.checkNotNull(desc);
            item.setText(desc.get(i12).getDesc());
        }
        View bottom_seperator = listItemViewHolder.getBottom_seperator();
        if (bottom_seperator != null) {
            bottom_seperator.setVisibility(8);
        }
        view.setOnClickListener(new e());
        return view;
    }

    public int getChildrenCount(int i11) {
        ArrayList<HelpQuickDesc> desc = this.displayData.get(i11).getDesc();
        Intrinsics.checkNotNull(desc);
        return desc.size();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final List<HelpExpandableListViewModel> getDisplayData() {
        return this.displayData;
    }

    @NotNull
    public Object getGroup(int i11) {
        return this.displayData.get(i11);
    }

    public int getGroupCount() {
        return this.displayData.size();
    }

    public long getGroupId(int i11) {
        return (long) i11;
    }

    @NotNull
    public View getGroupView(int i11, boolean z11, @Nullable View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        HelpExpandableListViewModel helpExpandableListViewModel = this.displayData.get(i11);
        ListHeaderViewHolder listHeaderViewHolder = null;
        if (view == null || (view.getTag() instanceof ListItemViewHolder)) {
            view = this.inflater.inflate(R.layout.map_search_list_header, (ViewGroup) null);
            listHeaderViewHolder = new ListHeaderViewHolder();
            Intrinsics.checkNotNull(view);
            View findViewById = view.findViewById(R.id.header);
            if (findViewById != null) {
                listHeaderViewHolder.setHeader((TextView) findViewById);
                listHeaderViewHolder.setBottom_seperator(view.findViewById(R.id.seperator_bottom_header));
                listHeaderViewHolder.setTop_seperator(view.findViewById(R.id.seperator_top_header));
                View findViewById2 = view.findViewById(R.id.expandble_arrow);
                if (findViewById2 != null) {
                    listHeaderViewHolder.setArrowImageView((ImageView) findViewById2);
                    View findViewById3 = view.findViewById(R.id.header_selected_txt);
                    if (findViewById3 != null) {
                        listHeaderViewHolder.setHeaderSelectedText((TextView) findViewById3);
                        view.setTag(listHeaderViewHolder);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
        } else if (view.getTag() instanceof ListHeaderViewHolder) {
            Object tag = view.getTag();
            if (tag != null) {
                listHeaderViewHolder = (ListHeaderViewHolder) tag;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.adapters.homeMap.HelpCenterQuickAdapter.ListHeaderViewHolder");
            }
        }
        Intrinsics.checkNotNull(listHeaderViewHolder);
        ImageView arrowImageView = listHeaderViewHolder.getArrowImageView();
        if (arrowImageView != null) {
            arrowImageView.setVisibility(0);
        }
        TextView header = listHeaderViewHolder.getHeader();
        if (header != null) {
            header.setText(helpExpandableListViewModel.getTitle());
        }
        View top_seperator = listHeaderViewHolder.getTop_seperator();
        if (top_seperator != null) {
            top_seperator.setVisibility(0);
        }
        View bottom_seperator = listHeaderViewHolder.getBottom_seperator();
        if (bottom_seperator != null) {
            bottom_seperator.setVisibility(8);
        }
        isExpandIcon(z11, listHeaderViewHolder.getArrowImageView());
        return view;
    }

    @NotNull
    public final LayoutInflater getInflater() {
        return this.inflater;
    }

    @NotNull
    public final onItemClickListener getListener() {
        return this.listener;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i11, int i12) {
        return false;
    }

    public final void setDisplayData(@NotNull List<HelpExpandableListViewModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.displayData = list;
    }

    public final void setInflater(@NotNull LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "<set-?>");
        this.inflater = layoutInflater;
    }
}
