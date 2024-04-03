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
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010E\u001a\u000203H\u0017¢\u0006\u0002\u0010FJ*\u0010G\u001a\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u000203\u0018\u00010H¢\u0006\u0002\bI2\b\u0010J\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0002\u0010KR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R8\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\t\u001a\u0004\u0018\u00010\u00188F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\t\u001a\u0004\u0018\u00010\u001f8F@FX\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R/\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0011\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR9\u0010*\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b)2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b)8F@FX\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0011\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R9\u0010.\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b)2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b)8F@FX\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0011\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R7\u00104\u001a\b\u0012\u0004\u0012\u000203022\f\u0010\t\u001a\b\u0012\u0004\u0012\u000203028F@FX\u0002¢\u0006\u0012\n\u0004\b9\u0010\u0011\u001a\u0004\b5\u00106\"\u0004\b7\u00108R/\u0010:\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0011\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR/\u0010?\u001a\u0004\u0018\u00010>2\b\u0010\t\u001a\u0004\u0018\u00010>8F@FX\u0002¢\u0006\u0012\n\u0004\bD\u0010\u0011\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006L"}, d2 = {"Lcom/designsystem/ds_list_item_v2/DSListItem;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "descriptor", "getDescriptor", "()Ljava/lang/String;", "setDescriptor", "(Ljava/lang/String;)V", "descriptor$delegate", "Landroidx/compose/runtime/MutableState;", "descriptorColor", "getDescriptorColor", "()Ljava/lang/Integer;", "setDescriptorColor", "(Ljava/lang/Integer;)V", "descriptorColor$delegate", "Landroidx/compose/ui/unit/Dp;", "imageCornerRadius", "getImageCornerRadius-lTKBWiU", "()Landroidx/compose/ui/unit/Dp;", "setImageCornerRadius-YLDhkOg", "(Landroidx/compose/ui/unit/Dp;)V", "imageCornerRadius$delegate", "", "isEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "isEnabled$delegate", "label", "getLabel", "setLabel", "label$delegate", "Landroidx/annotation/DrawableRes;", "leadingIcon", "getLeadingIcon", "setLeadingIcon", "leadingIcon$delegate", "leadingImage", "getLeadingImage", "setLeadingImage", "leadingImage$delegate", "Lkotlin/Function0;", "", "onTap", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "setOnTap", "(Lkotlin/jvm/functions/Function0;)V", "onTap$delegate", "secondaryLabel", "getSecondaryLabel", "setSecondaryLabel", "secondaryLabel$delegate", "Landroid/view/View;", "trailingView", "getTrailingView", "()Landroid/view/View;", "setTrailingView", "(Landroid/view/View;)V", "trailingView$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "viewToComposable", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "view", "(Landroid/view/View;)Lkotlin/jvm/functions/Function3;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSListItem extends AbstractComposeView {
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
    private final MutableState label$delegate;
    @NotNull
    private final MutableState leadingIcon$delegate;
    @NotNull
    private final MutableState leadingImage$delegate;
    @NotNull
    private final MutableState onTap$delegate;
    @NotNull
    private final MutableState secondaryLabel$delegate;
    @NotNull
    private final MutableState trailingView$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSListItem(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSListItem(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final Function3<Boolean, Composer, Integer, Unit> viewToComposable(View view) {
        if (view == null) {
            return null;
        }
        return ComposableLambdaKt.composableLambdaInstance(-985534650, true, new DSListItem$viewToComposable$1(view));
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        float f11;
        boolean z11;
        int i13;
        int i14 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1847001016);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            getLabel();
            String label = getLabel();
            if (label == null) {
                label = "";
            }
            String secondaryLabel = getSecondaryLabel();
            String descriptor = getDescriptor();
            Integer descriptorColor = getDescriptorColor();
            Function0<Unit> onTap = getOnTap();
            Integer leadingIcon = getLeadingIcon();
            Integer leadingImage = getLeadingImage();
            Dp r11 = m8479getImageCornerRadiuslTKBWiU();
            if (r11 == null) {
                startRestartGroup.startReplaceableGroup(-1847000564);
                f11 = DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8841getDsMD9Ej5fM();
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1847000600);
                startRestartGroup.endReplaceableGroup();
                f11 = r11.m5492unboximpl();
            }
            Function3<Boolean, Composer, Integer, Unit> viewToComposable = viewToComposable(getTrailingView());
            Boolean isEnabled = isEnabled();
            if (isEnabled == null) {
                z11 = true;
            } else {
                z11 = isEnabled.booleanValue();
            }
            DSListItemKt.m8481DSListItemWu8B24Y(label, (Modifier) null, secondaryLabel, descriptor, descriptorColor, onTap, leadingIcon, leadingImage, f11, viewToComposable, z11, startRestartGroup, 0, 0, 2);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSListItem$Content$2(this, i14));
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
    public final Dp m8479getImageCornerRadiuslTKBWiU() {
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

    @NotNull
    public final Function0<Unit> getOnTap() {
        return (Function0) this.onTap$delegate.getValue();
    }

    @Nullable
    public final String getSecondaryLabel() {
        return (String) this.secondaryLabel$delegate.getValue();
    }

    @Nullable
    public final View getTrailingView() {
        return (View) this.trailingView$delegate.getValue();
    }

    @Nullable
    public final Boolean isEnabled() {
        return (Boolean) this.isEnabled$delegate.getValue();
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
    public final void m8480setImageCornerRadiusYLDhkOg(@Nullable Dp dp2) {
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

    public final void setOnTap(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onTap$delegate.setValue(function0);
    }

    public final void setSecondaryLabel(@Nullable String str) {
        this.secondaryLabel$delegate.setValue(str);
    }

    public final void setTrailingView(@Nullable View view) {
        this.trailingView$delegate.setValue(view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSListItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.label$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.secondaryLabel$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.descriptor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.descriptorColor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DSListItem$onTap$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.leadingIcon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.leadingImage$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.imageCornerRadius$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.trailingView$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSListItemV2, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…eable.DSListItemV2, 0, 0)");
            setLabel(obtainStyledAttributes.getString(R.styleable.DSListItemV2_li_v2_label));
            setSecondaryLabel(obtainStyledAttributes.getString(R.styleable.DSListItemV2_li_v2_secondary_label));
            setDescriptor(obtainStyledAttributes.getString(R.styleable.DSListItemV2_li_v2_descriptor));
            setDescriptorColor(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSListItemV2_li_v2_descriptor_color));
            setLeadingIcon(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSListItemV2_li_v2_leading_icon));
            setLeadingImage(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSListItemV2_li_v2_leading_image));
            m8480setImageCornerRadiusYLDhkOg(Dp.m5476boximpl(Dp.m5478constructorimpl(obtainStyledAttributes.getDimension(R.styleable.DSListItemV2_li_v2_image_corner_radius, 0.0f))));
            setEnabled(Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.DSListItemV2_li_v2_is_enabled, true)));
            obtainStyledAttributes.recycle();
        }
    }
}
