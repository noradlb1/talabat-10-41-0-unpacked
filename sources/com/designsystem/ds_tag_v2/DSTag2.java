package com.designsystem.ds_tag_v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AbstractComposeView;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010-\u001a\u00020.H\u0017¢\u0006\u0002\u0010/R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R/\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\t\u001a\u0004\u0018\u00010\u00188F@FX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\t\u001a\u0004\u0018\u00010\u001f8F@FX\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\t\u001a\u0004\u0018\u00010&8F@FX\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/designsystem/ds_tag_v2/DSTag2;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/designsystem/ds_tag_v2/DSTagColor;", "color", "getColor", "()Lcom/designsystem/ds_tag_v2/DSTagColor;", "setColor", "(Lcom/designsystem/ds_tag_v2/DSTagColor;)V", "color$delegate", "Landroidx/compose/runtime/MutableState;", "icon", "getIcon", "()Ljava/lang/Integer;", "setIcon", "(Ljava/lang/Integer;)V", "icon$delegate", "", "label", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "label$delegate", "Lcom/designsystem/ds_tag_v2/DSTagPriority;", "priority", "getPriority", "()Lcom/designsystem/ds_tag_v2/DSTagPriority;", "setPriority", "(Lcom/designsystem/ds_tag_v2/DSTagPriority;)V", "priority$delegate", "Lcom/designsystem/ds_tag_v2/DSTagSize;", "size", "getSize", "()Lcom/designsystem/ds_tag_v2/DSTagSize;", "setSize", "(Lcom/designsystem/ds_tag_v2/DSTagSize;)V", "size$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSTag2 extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState color$delegate;
    @NotNull
    private final MutableState icon$delegate;
    @NotNull
    private final MutableState label$delegate;
    @NotNull
    private final MutableState priority$delegate;
    @NotNull
    private final MutableState size$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTag2(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTag2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSTag2(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1510586977);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            getLabel();
            getPriority();
            getSize();
            getColor();
            Modifier.Companion companion = Modifier.Companion;
            String label = getLabel();
            if (label == null) {
                label = "";
            }
            String str = label;
            DSTagPriority priority = getPriority();
            if (priority == null) {
                priority = DSTagPriority.Normal;
            }
            DSTagPriority dSTagPriority = priority;
            DSTagSize size = getSize();
            if (size == null) {
                size = DSTagSize.Medium;
            }
            DSTagSize dSTagSize = size;
            DSTagColor color = getColor();
            if (color == null) {
                color = DSTagColor.Blue;
            }
            DSTag2Kt.DSTag2(companion, str, dSTagPriority, dSTagSize, color, getIcon(), startRestartGroup, 6, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSTag2$Content$5(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final DSTagColor getColor() {
        return (DSTagColor) this.color$delegate.getValue();
    }

    @Nullable
    public final Integer getIcon() {
        return (Integer) this.icon$delegate.getValue();
    }

    @Nullable
    public final String getLabel() {
        return (String) this.label$delegate.getValue();
    }

    @Nullable
    public final DSTagPriority getPriority() {
        return (DSTagPriority) this.priority$delegate.getValue();
    }

    @Nullable
    public final DSTagSize getSize() {
        return (DSTagSize) this.size$delegate.getValue();
    }

    public final void setColor(@Nullable DSTagColor dSTagColor) {
        this.color$delegate.setValue(dSTagColor);
    }

    public final void setIcon(@Nullable Integer num) {
        this.icon$delegate.setValue(num);
    }

    public final void setLabel(@Nullable String str) {
        this.label$delegate.setValue(str);
    }

    public final void setPriority(@Nullable DSTagPriority dSTagPriority) {
        this.priority$delegate.setValue(dSTagPriority);
    }

    public final void setSize(@Nullable DSTagSize dSTagSize) {
        this.size$delegate.setValue(dSTagSize);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTag2(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        DSTagColor dSTagColor = null;
        this.label$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.priority$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.size$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.color$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.icon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSTag2, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.DSTag2, 0, 0)");
            setLabel(obtainStyledAttributes.getString(R.styleable.DSTag2_tg2_label));
            int i12 = obtainStyledAttributes.getInt(R.styleable.DSTag2_tg2_priority, -1);
            setPriority(i12 >= 0 ? DSTagPriority.values()[i12] : null);
            int i13 = obtainStyledAttributes.getInt(R.styleable.DSTag2_tg2_size, -1);
            setSize(i13 >= 0 ? DSTagSize.values()[i13] : null);
            int i14 = obtainStyledAttributes.getInt(R.styleable.DSTag2_tg2_color, -1);
            setColor(i14 >= 0 ? DSTagColor.values()[i14] : dSTagColor);
            setIcon(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSTag2_tg2_icon));
        }
    }
}
