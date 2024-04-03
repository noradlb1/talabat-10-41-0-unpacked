package com.designsystem.ds_tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/designsystem/ds_tabs/DSTabItem;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "id", "", "getId$marshmallow_release", "()I", "setId$marshmallow_release", "(I)V", "secondaryText", "", "getSecondaryText$marshmallow_release", "()Ljava/lang/String;", "setSecondaryText$marshmallow_release", "(Ljava/lang/String;)V", "text", "getText$marshmallow_release", "setText$marshmallow_release", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSTabItem extends View {
    public static final int $stable = 8;

    /* renamed from: id  reason: collision with root package name */
    private int f33047id;
    @Nullable
    private String secondaryText;
    @NotNull
    private String text;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTabItem(@NotNull Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSTabItem(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final int getId$marshmallow_release() {
        return this.f33047id;
    }

    @Nullable
    public final String getSecondaryText$marshmallow_release() {
        return this.secondaryText;
    }

    @NotNull
    public final String getText$marshmallow_release() {
        return this.text;
    }

    public final void setId$marshmallow_release(int i11) {
        this.f33047id = i11;
    }

    public final void setSecondaryText$marshmallow_release(@Nullable String str) {
        this.secondaryText = str;
    }

    public final void setText$marshmallow_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTabItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.text = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSTabItem, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.DSTabItem, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSTabItem_ti_text);
            if (string != null) {
                setText$marshmallow_release(string);
                setSecondaryText$marshmallow_release(obtainStyledAttributes.getString(R.styleable.DSTabItem_ti_secondary_text));
                obtainStyledAttributes.recycle();
                return;
            }
            throw new IllegalArgumentException("DSTabItem text is missing.");
        }
    }
}
