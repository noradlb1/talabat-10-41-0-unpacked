package com.talabat.adapters.homeMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.R;
import datamodels.AddressArea;
import datamodels.Area;
import datamodels.AreaExpandableListViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ze.f;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0003HIJB;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\n2\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016J\u0018\u0010-\u001a\u00020.2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016J2\u0010/\u001a\u0002002\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u0001002\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0016J\b\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000fH\u0016J\b\u00109\u001a\u00020\u000fH\u0016J\u0010\u0010:\u001a\u00020.2\u0006\u0010+\u001a\u00020\u000fH\u0016J*\u0010;\u001a\u0002002\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u0001002\u0006\u00103\u001a\u000204H\u0016J\b\u0010=\u001a\u00020\u001bH\u0016J,\u0010>\u001a\u00020\u000f2\u001a\u0010?\u001a\u0016\u0012\u0004\u0012\u00020@\u0018\u00010\tj\n\u0012\u0004\u0012\u00020@\u0018\u0001`\n2\u0006\u0010A\u001a\u00020\u001bH\u0002J\u0018\u0010B\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016J\u001a\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001b2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/talabat/adapters/homeMap/HomeMapSearchAreaAdapter;", "Landroid/widget/BaseExpandableListAdapter;", "Landroid/widget/Filterable;", "context", "Landroid/content/Context;", "displayData", "", "Ldatamodels/AreaExpandableListViewModel;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/talabat/adapters/homeMap/HomeMapSearchAreaAdapter$onItemClickListener;", "(Landroid/content/Context;Ljava/util/List;Ljava/util/ArrayList;Lcom/talabat/adapters/homeMap/HomeMapSearchAreaAdapter$onItemClickListener;)V", "areaHighLight", "", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "getDisplayData", "()Ljava/util/List;", "setDisplayData", "(Ljava/util/List;)V", "forceFilterCities", "", "highlightCityId", "inflater", "Landroid/view/LayoutInflater;", "getInflater", "()Landroid/view/LayoutInflater;", "setInflater", "(Landroid/view/LayoutInflater;)V", "getListener", "()Lcom/talabat/adapters/homeMap/HomeMapSearchAreaAdapter$onItemClickListener;", "onlySingledCity", "filerData", "str", "", "getChild", "", "groupPosition", "childPosition", "getChildId", "", "getChildView", "Landroid/view/View;", "isLastChild", "convertView", "parent", "Landroid/view/ViewGroup;", "getChildrenCount", "getFilter", "Landroid/widget/Filter;", "getGroup", "getGroupCount", "getGroupId", "getGroupView", "isExpanded", "hasStableIds", "headerHighLight", "areas", "Ldatamodels/Area;", "issFromAddress", "isChildSelectable", "isExpandIcon", "", "isExpand", "img", "Landroid/widget/ImageView;", "ListHeaderViewHolder", "ListItemViewHolder", "onItemClickListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapSearchAreaAdapter extends BaseExpandableListAdapter implements Filterable {
    private int areaHighLight = -1;
    @NotNull
    private final Context context;
    @NotNull
    private ArrayList<AreaExpandableListViewModel> data;
    @NotNull
    private List<AreaExpandableListViewModel> displayData;
    private boolean forceFilterCities;
    private int highlightCityId = -1;
    @NotNull
    private LayoutInflater inflater;
    @NotNull
    private final onItemClickListener listener;
    private boolean onlySingledCity;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/talabat/adapters/homeMap/HomeMapSearchAreaAdapter$ListHeaderViewHolder;", "", "()V", "arrowImageView", "Landroid/widget/ImageView;", "getArrowImageView", "()Landroid/widget/ImageView;", "setArrowImageView", "(Landroid/widget/ImageView;)V", "bottom_seperator", "Landroid/view/View;", "getBottom_seperator", "()Landroid/view/View;", "setBottom_seperator", "(Landroid/view/View;)V", "header", "Landroid/widget/TextView;", "getHeader", "()Landroid/widget/TextView;", "setHeader", "(Landroid/widget/TextView;)V", "headerSelectedText", "getHeaderSelectedText", "setHeaderSelectedText", "top_seperator", "getTop_seperator", "setTop_seperator", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/adapters/homeMap/HomeMapSearchAreaAdapter$ListItemViewHolder;", "", "()V", "bottom_seperator", "Landroid/view/View;", "getBottom_seperator", "()Landroid/view/View;", "setBottom_seperator", "(Landroid/view/View;)V", "item", "Landroid/widget/TextView;", "getItem", "()Landroid/widget/TextView;", "setItem", "(Landroid/widget/TextView;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/adapters/homeMap/HomeMapSearchAreaAdapter$onItemClickListener;", "", "onAreaSelected", "", "area", "Ldatamodels/Area;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface onItemClickListener {
        void onAreaSelected(@NotNull Area area);
    }

    public HomeMapSearchAreaAdapter(@NotNull Context context2, @NotNull List<AreaExpandableListViewModel> list, @NotNull ArrayList<AreaExpandableListViewModel> arrayList, @NotNull onItemClickListener onitemclicklistener) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(list, "displayData");
        Intrinsics.checkNotNullParameter(arrayList, "data");
        Intrinsics.checkNotNullParameter(onitemclicklistener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.context = context2;
        this.displayData = list;
        this.data = arrayList;
        this.listener = onitemclicklistener;
        LayoutInflater from = LayoutInflater.from(context2);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.inflater = from;
        this.onlySingledCity = this.data.size() != 1 ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: getChildView$lambda-0  reason: not valid java name */
    public static final void m9504getChildView$lambda0(HomeMapSearchAreaAdapter homeMapSearchAreaAdapter, AreaExpandableListViewModel areaExpandableListViewModel, int i11, View view) {
        Intrinsics.checkNotNullParameter(homeMapSearchAreaAdapter, "this$0");
        Intrinsics.checkNotNullParameter(areaExpandableListViewModel, "$areaExpandableListViewModel");
        onItemClickListener onitemclicklistener = homeMapSearchAreaAdapter.listener;
        if (onitemclicklistener != null) {
            ArrayList<Area> areas = areaExpandableListViewModel.getAreas();
            Intrinsics.checkNotNull(areas);
            Area area = areas.get(i11);
            Intrinsics.checkNotNullExpressionValue(area, "areaExpandableListViewMo…reas!!.get(childPosition)");
            onitemclicklistener.onAreaSelected(area);
        }
    }

    private final int headerHighLight(ArrayList<Area> arrayList, boolean z11) {
        int i11 = -3;
        if (arrayList != null) {
            Iterator<Area> it = arrayList.iterator();
            while (it.hasNext()) {
                Area next = it.next();
                if (next.getCityId() == this.highlightCityId) {
                    i11 = next.getCityId();
                }
            }
        }
        return i11;
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
    public final ArrayList<AreaExpandableListViewModel> filerData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        ArrayList<AreaExpandableListViewModel> arrayList = new ArrayList<>();
        Iterator<AreaExpandableListViewModel> it = this.data.iterator();
        while (it.hasNext()) {
            AreaExpandableListViewModel next = it.next();
            AreaExpandableListViewModel areaExpandableListViewModel = new AreaExpandableListViewModel();
            areaExpandableListViewModel.setCityName(next.getCityName());
            areaExpandableListViewModel.setAreas(new ArrayList());
            ArrayList<Area> areas = next.getAreas();
            Intrinsics.checkNotNull(areas);
            Iterator<Area> it2 = areas.iterator();
            while (it2.hasNext()) {
                Area next2 = it2.next();
                String str2 = next2.areaName;
                Intrinsics.checkNotNullExpressionValue(str2, "area.areaName");
                String lowerCase = str2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                String lowerCase2 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    ArrayList<Area> areas2 = areaExpandableListViewModel.getAreas();
                    Intrinsics.checkNotNull(areas2);
                    if (!areas2.contains(next2)) {
                        ArrayList<Area> areas3 = areaExpandableListViewModel.getAreas();
                        Intrinsics.checkNotNull(areas3);
                        areas3.add(next2);
                    }
                }
            }
            ArrayList<Area> areas4 = areaExpandableListViewModel.getAreas();
            Intrinsics.checkNotNull(areas4);
            if (areas4.size() <= 0) {
                arrayList.remove(areaExpandableListViewModel);
            } else if (!arrayList.contains(areaExpandableListViewModel)) {
                arrayList.add(areaExpandableListViewModel);
            }
        }
        return arrayList;
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
        AreaExpandableListViewModel areaExpandableListViewModel = this.displayData.get(i11);
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
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.adapters.homeMap.HomeMapSearchAreaAdapter.ListItemViewHolder");
            }
        }
        ArrayList<Area> areas = areaExpandableListViewModel.getAreas();
        Intrinsics.checkNotNull(areas);
        if (areas.get(i12) instanceof AddressArea) {
            Intrinsics.checkNotNull(areaExpandableListViewModel);
            ArrayList<Area> areas2 = areaExpandableListViewModel.getAreas();
            Intrinsics.checkNotNull(areas2);
            AddressArea addressArea = (AddressArea) areas2.get(i12);
            Intrinsics.checkNotNull(listItemViewHolder);
            TextView item = listItemViewHolder.getItem();
            if (item != null) {
                item.setTextColor(ContextCompat.getColor(this.context, R.color.talabat_black));
            }
            TextView item2 = listItemViewHolder.getItem();
            if (item2 != null) {
                String str = addressArea.profileName;
                String str2 = addressArea.areaName;
                item2.setText(str + " (" + str2 + ")");
            }
        } else {
            int i13 = this.areaHighLight;
            if (i13 > 0) {
                Intrinsics.checkNotNull(areaExpandableListViewModel);
                ArrayList<Area> areas3 = areaExpandableListViewModel.getAreas();
                Intrinsics.checkNotNull(areas3);
                if (i13 == areas3.get(i12).getId()) {
                    Intrinsics.checkNotNull(listItemViewHolder);
                    TextView item3 = listItemViewHolder.getItem();
                    if (item3 != null) {
                        item3.setTextColor(ContextCompat.getColor(this.context, R.color.ds_primary_100));
                    }
                } else {
                    Intrinsics.checkNotNull(listItemViewHolder);
                    TextView item4 = listItemViewHolder.getItem();
                    if (item4 != null) {
                        item4.setTextColor(ContextCompat.getColor(this.context, R.color.talabat_black));
                    }
                }
            } else {
                Intrinsics.checkNotNull(listItemViewHolder);
                TextView item5 = listItemViewHolder.getItem();
                if (item5 != null) {
                    item5.setTextColor(ContextCompat.getColor(this.context, R.color.talabat_black));
                }
            }
            TextView item6 = listItemViewHolder.getItem();
            if (item6 != null) {
                Intrinsics.checkNotNull(areaExpandableListViewModel);
                ArrayList<Area> areas4 = areaExpandableListViewModel.getAreas();
                Intrinsics.checkNotNull(areas4);
                item6.setText(areas4.get(i12).areaName);
            }
            View bottom_seperator = listItemViewHolder.getBottom_seperator();
            if (bottom_seperator != null) {
                bottom_seperator.setVisibility(8);
            }
            view.setOnClickListener(new f(this, areaExpandableListViewModel, i12));
        }
        return view;
    }

    public int getChildrenCount(int i11) {
        ArrayList<Area> areas = this.displayData.get(i11).getAreas();
        Intrinsics.checkNotNull(areas);
        return areas.size();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final ArrayList<AreaExpandableListViewModel> getData() {
        return this.data;
    }

    @NotNull
    public final List<AreaExpandableListViewModel> getDisplayData() {
        return this.displayData;
    }

    @NotNull
    public Filter getFilter() {
        return new HomeMapSearchAreaAdapter$getFilter$1(this);
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
        AreaExpandableListViewModel areaExpandableListViewModel = this.displayData.get(i11);
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
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.adapters.homeMap.HomeMapSearchAreaAdapter.ListHeaderViewHolder");
            }
        }
        ExpandableListView expandableListView = (ExpandableListView) viewGroup;
        Intrinsics.checkNotNull(listHeaderViewHolder);
        ImageView arrowImageView = listHeaderViewHolder.getArrowImageView();
        if (arrowImageView != null) {
            arrowImageView.setVisibility(0);
        }
        TextView header = listHeaderViewHolder.getHeader();
        if (header != null) {
            header.setText(areaExpandableListViewModel.getCityName());
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

    public final void setData(@NotNull ArrayList<AreaExpandableListViewModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.data = arrayList;
    }

    public final void setDisplayData(@NotNull List<AreaExpandableListViewModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.displayData = list;
    }

    public final void setInflater(@NotNull LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "<set-?>");
        this.inflater = layoutInflater;
    }
}
