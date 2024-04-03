package com.talabat.talabatcommon.views.tabBarWithTag;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.designsystem.marshmallow.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/views/tabBarWithTag/TabItemView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "id", "", "getId$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()I", "setId$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(I)V", "text", "", "getText$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Ljava/lang/String;", "setText$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Ljava/lang/String;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TabItemView extends View {
    @NotNull
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: id  reason: collision with root package name */
    private int f11756id;
    @NotNull
    private String text;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TabItemView(@NotNull Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TabItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.text = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSTabItem, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.DSTabItem, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSTabItem_ti_text);
            if (string != null) {
                this.text = string;
                obtainStyledAttributes.recycle();
                return;
            }
            throw new IllegalArgumentException("DSTabItem text is missing.");
        }
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

    public final int getId$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.f11756id;
    }

    @NotNull
    public final String getText$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.text;
    }

    public final void setId$com_talabat_NewArchi_TalabatCommon_TalabatCommon(int i11) {
        this.f11756id = i11;
    }

    public final void setText$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabItemView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }
}
