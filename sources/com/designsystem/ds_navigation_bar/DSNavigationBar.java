package com.designsystem.ds_navigation_bar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AbstractComposeView;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.behaviour.DSNavigationBarAnimationBehaviorFixed;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010+\u001a\u00020,H\u0017¢\u0006\u0002\u0010-J\"\u0010.\u001a\r\u0012\u0004\u0012\u00020,0/¢\u0006\u0002\b02\b\u00101\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u00102R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u00198F@FX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR/\u0010 \u001a\u0004\u0018\u00010\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u00198F@FX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR/\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\t\u001a\u0004\u0018\u00010$8F@FX\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0011\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcom/designsystem/ds_navigation_bar/DSNavigationBar;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "animationBehavior", "getAnimationBehavior", "()Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "setAnimationBehavior", "(Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;)V", "animationBehavior$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "leadingIconButton", "getLeadingIconButton", "()Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "setLeadingIconButton", "(Lcom/designsystem/ds_icon_button/DSIconButtonModel;)V", "leadingIconButton$delegate", "", "subtitle", "getSubtitle", "()Ljava/lang/String;", "setSubtitle", "(Ljava/lang/String;)V", "subtitle$delegate", "title", "getTitle", "setTitle", "title$delegate", "Landroid/view/View;", "trailingContainer", "getTrailingContainer", "()Landroid/view/View;", "setTrailingContainer", "(Landroid/view/View;)V", "trailingContainer$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "createTrailingContainerComposable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "view", "(Landroid/view/View;)Lkotlin/jvm/functions/Function2;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DSNavigationBar extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState animationBehavior$delegate;
    @NotNull
    private final MutableState leadingIconButton$delegate;
    @NotNull
    private final MutableState subtitle$delegate;
    @NotNull
    private final MutableState title$delegate;
    @NotNull
    private final MutableState trailingContainer$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSNavigationBar(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSNavigationBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSNavigationBar(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final Function2<Composer, Integer, Unit> createTrailingContainerComposable(View view) {
        return ComposableLambdaKt.composableLambdaInstance(-985536412, true, new DSNavigationBar$createTrailingContainerComposable$1(view));
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1264675523);
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
            getLeadingIconButton();
            String title = getTitle();
            String subtitle = getSubtitle();
            DSIconButtonModel leadingIconButton = getLeadingIconButton();
            if (leadingIconButton == null) {
                leadingIconButton = DSIconButtonModel.Companion.empty();
            }
            DSNavigationBarKt.DSNavigationBar((Modifier) null, title, subtitle, leadingIconButton, createTrailingContainerComposable(getTrailingContainer()), getAnimationBehavior(), startRestartGroup, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSNavigationBar$Content$2(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @NotNull
    public final DSNavigationBarAnimationBehaviour getAnimationBehavior() {
        return (DSNavigationBarAnimationBehaviour) this.animationBehavior$delegate.getValue();
    }

    @Nullable
    public final DSIconButtonModel getLeadingIconButton() {
        return (DSIconButtonModel) this.leadingIconButton$delegate.getValue();
    }

    @Nullable
    public final String getSubtitle() {
        return (String) this.subtitle$delegate.getValue();
    }

    @Nullable
    public final String getTitle() {
        return (String) this.title$delegate.getValue();
    }

    @Nullable
    public final View getTrailingContainer() {
        return (View) this.trailingContainer$delegate.getValue();
    }

    public final void setAnimationBehavior(@NotNull DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour) {
        Intrinsics.checkNotNullParameter(dSNavigationBarAnimationBehaviour, "<set-?>");
        this.animationBehavior$delegate.setValue(dSNavigationBarAnimationBehaviour);
    }

    public final void setLeadingIconButton(@Nullable DSIconButtonModel dSIconButtonModel) {
        this.leadingIconButton$delegate.setValue(dSIconButtonModel);
    }

    public final void setSubtitle(@Nullable String str) {
        this.subtitle$delegate.setValue(str);
    }

    public final void setTitle(@Nullable String str) {
        this.title$delegate.setValue(str);
    }

    public final void setTrailingContainer(@Nullable View view) {
        this.trailingContainer$delegate.setValue(view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSNavigationBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.leadingIconButton$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.title$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.subtitle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.trailingContainer$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animationBehavior$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new DSNavigationBarAnimationBehaviorFixed((ViewGroup) null, 1, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSNavigationBar, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…le.DSNavigationBar, 0, 0)");
            setTitle(obtainStyledAttributes.getString(R.styleable.DSNavigationBar_nb_title));
            setSubtitle(obtainStyledAttributes.getString(R.styleable.DSNavigationBar_nb_subtitle));
            obtainStyledAttributes.recycle();
        }
    }
}
