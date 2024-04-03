package com.designsystem.ds_list_item_v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_theme.DSThemeKt;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010W\u001a\u00020=H\u0017¢\u0006\u0002\u0010XR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R8\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\t\u001a\u0004\u0018\u00010\u00188F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\t\u001a\u0004\u0018\u00010\u001f8F@FX\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R+\u0010%\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8G@GX\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0011\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R/\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0011\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR9\u00100\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b/2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b/8F@FX\u0002¢\u0006\u0012\n\u0004\b3\u0010\u0011\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016R9\u00104\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b/2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b/8F@FX\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0011\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R/\u00108\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b;\u0010\u0011\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fRC\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020=0<2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020=0<8F@FX\u0002¢\u0006\u0012\n\u0004\bC\u0010\u0011\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR/\u0010D\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\bG\u0010\u0011\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR/\u0010H\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\bK\u0010\u0011\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR+\u0010L\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8F@FX\u0002¢\u0006\u0012\n\u0004\bO\u0010\u0011\u001a\u0004\bM\u0010'\"\u0004\bN\u0010)R/\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010\t\u001a\u0004\u0018\u00010P8B@BX\u0002¢\u0006\u0012\n\u0004\bV\u0010\u0011\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, d2 = {"Lcom/designsystem/ds_list_item_v2/DSSelectionListItem;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "descriptor", "getDescriptor", "()Ljava/lang/String;", "setDescriptor", "(Ljava/lang/String;)V", "descriptor$delegate", "Landroidx/compose/runtime/MutableState;", "descriptorColor", "getDescriptorColor", "()Ljava/lang/Integer;", "setDescriptorColor", "(Ljava/lang/Integer;)V", "descriptorColor$delegate", "Landroidx/compose/ui/unit/Dp;", "imageCornerRadius", "getImageCornerRadius-lTKBWiU", "()Landroidx/compose/ui/unit/Dp;", "setImageCornerRadius-YLDhkOg", "(Landroidx/compose/ui/unit/Dp;)V", "imageCornerRadius$delegate", "", "isEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "isEnabled$delegate", "isSelected", "isListItemSelected", "()Z", "setListItemSelected", "(Z)V", "isSelected$delegate", "label", "getLabel", "setLabel", "label$delegate", "Landroidx/annotation/DrawableRes;", "leadingIcon", "getLeadingIcon", "setLeadingIcon", "leadingIcon$delegate", "leadingImage", "getLeadingImage", "setLeadingImage", "leadingImage$delegate", "oldPrice", "getOldPrice", "setOldPrice", "oldPrice$delegate", "Lkotlin/Function1;", "", "onChanged", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "setOnChanged", "(Lkotlin/jvm/functions/Function1;)V", "onChanged$delegate", "price", "getPrice", "setPrice", "price$delegate", "secondaryLabel", "getSecondaryLabel", "setSecondaryLabel", "secondaryLabel$delegate", "showSelectionIndicator", "getShowSelectionIndicator", "setShowSelectionIndicator", "showSelectionIndicator$delegate", "Landroid/view/View;", "trailingView", "getTrailingView", "()Landroid/view/View;", "setTrailingView", "(Landroid/view/View;)V", "trailingView$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DSSelectionListItem extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState descriptor$delegate;
    @NotNull
    private final MutableState descriptorColor$delegate;
    @NotNull
    private final MutableState imageCornerRadius$delegate;
    @NotNull
    private final MutableState isEnabled$delegate;
    @NotNull
    private final MutableState isSelected$delegate;
    @NotNull
    private final MutableState label$delegate;
    @NotNull
    private final MutableState leadingIcon$delegate;
    @NotNull
    private final MutableState leadingImage$delegate;
    @NotNull
    private final MutableState oldPrice$delegate;
    @NotNull
    private final MutableState onChanged$delegate;
    @NotNull
    private final MutableState price$delegate;
    @NotNull
    private final MutableState secondaryLabel$delegate;
    @NotNull
    private final MutableState showSelectionIndicator$delegate;
    @NotNull
    private final MutableState trailingView$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSelectionListItem(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSelectionListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSSelectionListItem(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    public final View getTrailingView() {
        return (View) this.trailingView$delegate.getValue();
    }

    private final void setTrailingView(View view) {
        this.trailingView$delegate.setValue(view);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1294878808);
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
            DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819902913, true, new DSSelectionListItem$Content$2(this)), startRestartGroup, 6);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSSelectionListItem$Content$3(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final String getDescriptor() {
        return (String) this.descriptor$delegate.getValue();
    }

    @Nullable
    public final Integer getDescriptorColor() {
        return (Integer) this.descriptorColor$delegate.getValue();
    }

    @Nullable
    /* renamed from: getImageCornerRadius-lTKBWiU  reason: not valid java name */
    public final Dp m8483getImageCornerRadiuslTKBWiU() {
        return (Dp) this.imageCornerRadius$delegate.getValue();
    }

    @Nullable
    public final String getLabel() {
        return (String) this.label$delegate.getValue();
    }

    @Nullable
    public final Integer getLeadingIcon() {
        return (Integer) this.leadingIcon$delegate.getValue();
    }

    @Nullable
    public final Integer getLeadingImage() {
        return (Integer) this.leadingImage$delegate.getValue();
    }

    @Nullable
    public final String getOldPrice() {
        return (String) this.oldPrice$delegate.getValue();
    }

    @NotNull
    public final Function1<Boolean, Unit> getOnChanged() {
        return (Function1) this.onChanged$delegate.getValue();
    }

    @Nullable
    public final String getPrice() {
        return (String) this.price$delegate.getValue();
    }

    @Nullable
    public final String getSecondaryLabel() {
        return (String) this.secondaryLabel$delegate.getValue();
    }

    public final boolean getShowSelectionIndicator() {
        return ((Boolean) this.showSelectionIndicator$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final Boolean isEnabled() {
        return (Boolean) this.isEnabled$delegate.getValue();
    }

    @JvmName(name = "isListItemSelected")
    public final boolean isListItemSelected() {
        return ((Boolean) this.isSelected$delegate.getValue()).booleanValue();
    }

    public final void setDescriptor(@Nullable String str) {
        this.descriptor$delegate.setValue(str);
    }

    public final void setDescriptorColor(@Nullable Integer num) {
        this.descriptorColor$delegate.setValue(num);
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.isEnabled$delegate.setValue(bool);
    }

    /* renamed from: setImageCornerRadius-YLDhkOg  reason: not valid java name */
    public final void m8484setImageCornerRadiusYLDhkOg(@Nullable Dp dp2) {
        this.imageCornerRadius$delegate.setValue(dp2);
    }

    public final void setLabel(@Nullable String str) {
        this.label$delegate.setValue(str);
    }

    public final void setLeadingIcon(@Nullable Integer num) {
        this.leadingIcon$delegate.setValue(num);
    }

    public final void setLeadingImage(@Nullable Integer num) {
        this.leadingImage$delegate.setValue(num);
    }

    @JvmName(name = "setListItemSelected")
    public final void setListItemSelected(boolean z11) {
        this.isSelected$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setOldPrice(@Nullable String str) {
        this.oldPrice$delegate.setValue(str);
    }

    public final void setOnChanged(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onChanged$delegate.setValue(function1);
    }

    public final void setPrice(@Nullable String str) {
        this.price$delegate.setValue(str);
    }

    public final void setSecondaryLabel(@Nullable String str) {
        this.secondaryLabel$delegate.setValue(str);
    }

    public final void setShowSelectionIndicator(boolean z11) {
        this.showSelectionIndicator$delegate.setValue(Boolean.valueOf(z11));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSelectionListItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.label$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        Boolean bool = Boolean.TRUE;
        this.isSelected$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onChanged$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DSSelectionListItem$onChanged$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.secondaryLabel$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.descriptor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.descriptorColor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.leadingIcon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.leadingImage$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.imageCornerRadius$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.price$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.oldPrice$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.showSelectionIndicator$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.trailingView$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSSelectionListItem, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…SSelectionListItem, 0, 0)");
            setLabel(obtainStyledAttributes.getString(R.styleable.DSSelectionListItem_sli_label));
            setListItemSelected(obtainStyledAttributes.getBoolean(R.styleable.DSSelectionListItem_sli_is_selected, true));
            setSecondaryLabel(obtainStyledAttributes.getString(R.styleable.DSSelectionListItem_sli_secondary_label));
            setDescriptor(obtainStyledAttributes.getString(R.styleable.DSSelectionListItem_sli_descriptor));
            setDescriptorColor(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSSelectionListItem_sli_descriptor_color));
            setLeadingIcon(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSSelectionListItem_sli_leading_icon));
            setLeadingImage(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSSelectionListItem_sli_leading_image));
            m8484setImageCornerRadiusYLDhkOg(Dp.m5476boximpl(Dp.m5478constructorimpl(obtainStyledAttributes.getDimension(R.styleable.DSSelectionListItem_sli_image_corner_radius, 0.0f))));
            setEnabled(Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.DSSelectionListItem_sli_is_enabled, true)));
            setPrice(obtainStyledAttributes.getString(R.styleable.DSSelectionListItem_sli_price));
            setOldPrice(obtainStyledAttributes.getString(R.styleable.DSSelectionListItem_sli_old_price));
            setShowSelectionIndicator(obtainStyledAttributes.getBoolean(R.styleable.DSSelectionListItem_sli_show_selection_indication, true));
            obtainStyledAttributes.recycle();
        }
    }
}
