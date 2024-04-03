package com.talabat.talabatcommon.views.titleViewMoreGridView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ&\u0010\u0015\u001a\u00020\u001a2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u0006!"}, d2 = {"Lcom/talabat/talabatcommon/views/titleViewMoreGridView/TitleViewMoreGridView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionTitle", "", "getActionTitle", "()Ljava/lang/String;", "setActionTitle", "(Ljava/lang/String;)V", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "title", "getTitle", "setTitle", "", "numberOfColumns", "decorator", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setGridNestedScrollingEnabled", "enabled", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TitleViewMoreGridView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private String actionTitle;
    @Nullable
    private RecyclerView.Adapter<?> adapter;
    @NotNull
    private String title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleViewMoreGridView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.title = "";
        this.actionTitle = "";
        LayoutInflater.from(getContext()).inflate(R.layout.view_title_view_more_grid, this, true);
        setOrientation(1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: com.talabat.talabatcommon.views.titleViewMoreGridView.GridSpacingItemDecoration} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.talabat.talabatcommon.views.titleViewMoreGridView.GridSpacingItemDecoration} */
    /* JADX WARNING: type inference failed for: r10v1, types: [androidx.recyclerview.widget.RecyclerView$ItemDecoration] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void setAdapter$default(com.talabat.talabatcommon.views.titleViewMoreGridView.TitleViewMoreGridView r7, androidx.recyclerview.widget.RecyclerView.Adapter r8, int r9, androidx.recyclerview.widget.RecyclerView.ItemDecoration r10, int r11, java.lang.Object r12) {
        /*
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0005
            r9 = 2
        L_0x0005:
            r11 = r11 & 4
            if (r11 == 0) goto L_0x001e
            com.talabat.talabatcommon.views.titleViewMoreGridView.GridSpacingItemDecoration r10 = new com.talabat.talabatcommon.views.titleViewMoreGridView.GridSpacingItemDecoration
            android.content.res.Resources r11 = r7.getResources()
            int r12 = com.talabat.talabatcommon.R.dimen.grid_view_internal_margin
            int r2 = r11.getDimensionPixelOffset(r12)
            r3 = 0
            r4 = 0
            r5 = 4
            r6 = 0
            r0 = r10
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L_0x001e:
            r7.setAdapter(r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.titleViewMoreGridView.TitleViewMoreGridView.setAdapter$default(com.talabat.talabatcommon.views.titleViewMoreGridView.TitleViewMoreGridView, androidx.recyclerview.widget.RecyclerView$Adapter, int, androidx.recyclerview.widget.RecyclerView$ItemDecoration, int, java.lang.Object):void");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public final String getActionTitle() {
        return this.actionTitle;
    }

    @Nullable
    public final RecyclerView.Adapter<?> getAdapter() {
        return this.adapter;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final void setActionTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionTitle = str;
    }

    public final void setAdapter(@Nullable RecyclerView.Adapter<?> adapter2) {
        this.adapter = adapter2;
    }

    public final void setGridNestedScrollingEnabled(boolean z11) {
        ((RecyclerView) _$_findCachedViewById(R.id.titleViewMoreRecyclerView)).setNestedScrollingEnabled(z11);
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setAdapter(@NotNull RecyclerView.Adapter<?> adapter2, int i11, @NotNull RecyclerView.ItemDecoration itemDecoration) {
        Intrinsics.checkNotNullParameter(adapter2, "adapter");
        Intrinsics.checkNotNullParameter(itemDecoration, "decorator");
        if (this.adapter == null) {
            this.adapter = adapter2;
        }
        if (i11 <= 1) {
            ((RecyclerView) _$_findCachedViewById(R.id.titleViewMoreRecyclerView)).setLayoutManager(new LinearLayoutManager(getContext()));
        } else {
            int i12 = R.id.titleViewMoreRecyclerView;
            ((RecyclerView) _$_findCachedViewById(i12)).setLayoutManager(new GridLayoutManager(getContext(), i11));
            ((RecyclerView) _$_findCachedViewById(i12)).addItemDecoration(itemDecoration);
        }
        ((RecyclerView) _$_findCachedViewById(R.id.titleViewMoreRecyclerView)).setAdapter(this.adapter);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleViewMoreGridView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        this.title = str;
        this.actionTitle = str;
        LayoutInflater.from(getContext()).inflate(R.layout.view_title_view_more_grid, this, true);
        setOrientation(1);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TitleViewMoreGridView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…          0\n            )");
            String string = obtainStyledAttributes.getString(R.styleable.TitleViewMoreGridView_title);
            this.title = string == null ? str : string;
            String string2 = obtainStyledAttributes.getString(R.styleable.TitleViewMoreGridView_actionTitle);
            this.actionTitle = string2 != null ? string2 : str;
            obtainStyledAttributes.recycle();
            ((TextView) _$_findCachedViewById(R.id.titleViewMoreTitleTextView)).setText(this.title);
            ((TextView) _$_findCachedViewById(R.id.titleViewMoreViewMoreTextView)).setText(this.actionTitle);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleViewMoreGridView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.title = "";
        this.actionTitle = "";
        LayoutInflater.from(getContext()).inflate(R.layout.view_title_view_more_grid, this, true);
        setOrientation(1);
    }
}
