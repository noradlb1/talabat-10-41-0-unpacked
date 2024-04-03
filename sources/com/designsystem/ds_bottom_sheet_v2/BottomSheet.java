package com.designsystem.ds_bottom_sheet_v2;

import a6.a;
import a6.b;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.compose.DialogNavigator;
import com.designsystem.ds_fixed_footer.DSBaseFixedFooter;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.extensions.ActivityExtensionsKt;
import com.designsystem.extensions.ViewExtensionsKt;
import com.designsystem.marshmallow.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\f\b'\u0018\u0000 f2\u00020\u0001:\u0001fB\u0007¢\u0006\u0004\bd\u0010eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bJ&\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010$\u001a\u00020#2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010%\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER.\u0010G\u001a\u0004\u0018\u00010\u00112\b\u0010F\u001a\u0004\u0018\u00010\u00118\u0006@FX\u000e¢\u0006\u0012\n\u0004\bG\u00100\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR*\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010R8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR*\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010R8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010T\u001a\u0004\bY\u0010V\"\u0004\bZ\u0010XR\u001c\u0010`\u001a\u00020[8$@$X¤\u000e¢\u0006\f\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010c\u001a\u00020\u00198$@$X¤\u000e¢\u0006\f\u001a\u0004\ba\u0010O\"\u0004\bb\u0010Q¨\u0006g"}, d2 = {"Lcom/designsystem/ds_bottom_sheet_v2/BottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View;", "rootView", "", "adjustContentMargins", "setupAnimation", "clearViews", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "behaviour", "setupBottomSheetBehaviour", "view", "Landroid/view/ViewGroup;", "container", "addViewToContainer", "launchDismissTimer", "Landroidx/fragment/app/Fragment;", "newContentFragment", "initFirstContentFragment", "changeContentFragment", "", "getMaxHeight", "getMaxContentHeight", "overrideBackNavigation", "", "navigateBack", "Landroidx/fragment/app/FragmentManager;", "manager", "show", "Landroid/view/LayoutInflater;", "inflater", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "onViewCreated", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Lkotlinx/coroutines/Job;", "timerJob", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "scopeMain", "Lkotlinx/coroutines/CoroutineScope;", "tempFragment", "Landroidx/fragment/app/Fragment;", "Lcom/designsystem/ds_navigation_bar/DSNavigationBar;", "navigationBar", "Lcom/designsystem/ds_navigation_bar/DSNavigationBar;", "getNavigationBar", "()Lcom/designsystem/ds_navigation_bar/DSNavigationBar;", "setNavigationBar", "(Lcom/designsystem/ds_navigation_bar/DSNavigationBar;)V", "Lcom/designsystem/ds_fixed_footer/DSBaseFixedFooter;", "footer", "Lcom/designsystem/ds_fixed_footer/DSBaseFixedFooter;", "getFooter", "()Lcom/designsystem/ds_fixed_footer/DSBaseFixedFooter;", "setFooter", "(Lcom/designsystem/ds_fixed_footer/DSBaseFixedFooter;)V", "", "dismissAfter", "J", "getDismissAfter", "()J", "setDismissAfter", "(J)V", "value", "body", "getBody", "()Landroidx/fragment/app/Fragment;", "setBody", "(Landroidx/fragment/app/Fragment;)V", "withNavigationBar", "Z", "getWithNavigationBar", "()Z", "setWithNavigationBar", "(Z)V", "Lkotlin/Function0;", "onShow", "Lkotlin/jvm/functions/Function0;", "getOnShow", "()Lkotlin/jvm/functions/Function0;", "setOnShow", "(Lkotlin/jvm/functions/Function0;)V", "getOnDismiss", "setOnDismiss", "", "i0", "()D", "setMaxBottomSheetHeightRatio", "(D)V", "maxBottomSheetHeightRatio", "j0", "setFullScreen", "isFullScreen", "<init>", "()V", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1})
public abstract class BottomSheet extends BottomSheetDialogFragment {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String DSBottomSheetDefaultContentFragmentTag = "DSBottomSheetDefaultContentFragmentTag";
    @Nullable
    private Fragment body;
    private long dismissAfter;
    @Nullable
    private DSBaseFixedFooter footer;
    @Nullable
    private DSNavigationBar navigationBar;
    @Nullable
    private Function0<Unit> onDismiss;
    @Nullable
    private Function0<Unit> onShow;
    @NotNull
    private final CoroutineScope scopeMain = CoroutineScopeKt.CoroutineScope(JobKt.Job$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    @Nullable
    private Fragment tempFragment;
    @Nullable
    private Job timerJob;
    private boolean withNavigationBar = true;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/designsystem/ds_bottom_sheet_v2/BottomSheet$Companion;", "", "()V", "DSBottomSheetDefaultContentFragmentTag", "", "getDSBottomSheetDefaultContentFragmentTag$marshmallow_release", "()Ljava/lang/String;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getDSBottomSheetDefaultContentFragmentTag$marshmallow_release() {
            return BottomSheet.DSBottomSheetDefaultContentFragmentTag;
        }
    }

    private final void addViewToContainer(View view, ViewGroup viewGroup) {
        if (view != null) {
            ViewExtensionsKt.removeFromParent(view);
            viewGroup.addView(view);
        }
    }

    private final void adjustContentMargins(View view) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        int i11;
        int i12;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds_xxs);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds_xxxs);
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new BottomSheet$adjustContentMargins$$inlined$doOnLayout$1(this, dimensionPixelSize, dimensionPixelSize2));
            return;
        }
        DSNavigationBar navigationBar2 = getNavigationBar();
        View view2 = null;
        if (navigationBar2 == null) {
            num = null;
        } else {
            num = Integer.valueOf(navigationBar2.getHeight());
        }
        if (num == null) {
            num2 = 0;
        } else {
            DSNavigationBar navigationBar3 = getNavigationBar();
            if (navigationBar3 == null) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(navigationBar3.getHeight() - dimensionPixelSize);
            }
        }
        DSBaseFixedFooter footer2 = getFooter();
        if (footer2 == null) {
            num3 = null;
        } else {
            num3 = Integer.valueOf(footer2.getHeight());
        }
        if (num3 == null) {
            num4 = 0;
        } else {
            DSBaseFixedFooter footer3 = getFooter();
            if (footer3 == null) {
                num4 = null;
            } else {
                num4 = Integer.valueOf(footer3.getHeight() - dimensionPixelSize2);
            }
        }
        View view3 = getView();
        if (view3 != null) {
            view2 = view3.findViewById(R.id.dsBottomSheetBodyFragmentContainer);
        }
        Intrinsics.checkNotNullExpressionValue(view2, "dsBottomSheetBodyFragmentContainer");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (num2 == null) {
                i11 = 0;
            } else {
                i11 = num2.intValue();
            }
            if (num4 == null) {
                i12 = 0;
            } else {
                i12 = num4.intValue();
            }
            layoutParams2.setMargins(0, i11, 0, i12);
            view2.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    private final void changeContentFragment(Fragment fragment) {
        View view;
        if (getActivity() != null) {
            View view2 = getView();
            View view3 = null;
            if (view2 == null) {
                view = null;
            } else {
                view = view2.findViewById(R.id.dsBottomSheetBodyFragmentContainer);
            }
            if (view != null) {
                List<Fragment> fragments = getChildFragmentManager().getFragments();
                Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
                Fragment fragment2 = (Fragment) CollectionsKt___CollectionsKt.getOrNull(fragments, 0);
                if (fragment2 != null) {
                    view3 = fragment2.getView();
                }
                FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
                if (view3 != null) {
                    beginTransaction.addSharedElement(view3, view3.getTransitionName());
                }
                beginTransaction.setReorderingAllowed(true);
                BottomSheetSharedTransition bottomSheetSharedTransition = new BottomSheetSharedTransition();
                bottomSheetSharedTransition.setContentMaxHeight(getMaxContentHeight());
                Unit unit = Unit.INSTANCE;
                fragment.setSharedElementEnterTransition(bottomSheetSharedTransition);
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beg…)\n            }\n        }");
                beginTransaction.replace(R.id.dsBottomSheetBodyFragmentContainer, fragment).addToBackStack(fragment.getClass().getName()).commit();
                return;
            }
        }
        this.tempFragment = fragment;
    }

    private final void clearViews() {
        View view = getView();
        ((RoundedCoordinatorLayout) (view == null ? null : view.findViewById(R.id.dsBottomSheetRootContainer))).removeAllViews();
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int getMaxContentHeight() {
        /*
            r7 = this;
            android.view.View r0 = r7.getView()
            r1 = 0
            if (r0 != 0) goto L_0x0009
            r0 = r1
            goto L_0x000f
        L_0x0009:
            int r2 = com.designsystem.marshmallow.R.id.dsBottomSheetNavigationBarContainer
            android.view.View r0 = r0.findViewById(r2)
        L_0x000f:
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r2 = 0
            if (r0 != 0) goto L_0x0016
            r0 = r2
            goto L_0x001a
        L_0x0016:
            int r0 = r0.getHeight()
        L_0x001a:
            android.view.View r3 = r7.getView()
            if (r3 != 0) goto L_0x0022
            r3 = r1
            goto L_0x0028
        L_0x0022:
            int r4 = com.designsystem.marshmallow.R.id.dsBottomSheetNavigationBarContainer
            android.view.View r3 = r3.findViewById(r4)
        L_0x0028:
            java.lang.String r4 = "dsBottomSheetNavigationBarContainer"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            boolean r4 = r3 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r4 == 0) goto L_0x0038
            r1 = r3
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
        L_0x0038:
            if (r1 != 0) goto L_0x003c
            r1 = r2
            goto L_0x003e
        L_0x003c:
            int r1 = r1.topMargin
        L_0x003e:
            int r0 = r0 + r1
            com.designsystem.ds_fixed_footer.DSBaseFixedFooter r1 = r7.footer
            if (r1 != 0) goto L_0x0044
            goto L_0x0048
        L_0x0044:
            int r2 = r1.getHeight()
        L_0x0048:
            androidx.fragment.app.FragmentActivity r1 = r7.requireActivity()
            java.lang.String r3 = "requireActivity()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            int r1 = com.designsystem.extensions.ActivityExtensionsKt.getScreenHeight(r1)
            double r3 = (double) r1
            double r5 = r7.i0()
            double r3 = r3 * r5
            int r1 = (int) r3
            int r1 = r1 - r2
            int r1 = r1 - r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_bottom_sheet_v2.BottomSheet.getMaxContentHeight():int");
    }

    private final int getMaxHeight() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return (int) (((double) ActivityExtensionsKt.getScreenHeight(requireActivity)) * i0());
    }

    private final void initFirstContentFragment(Fragment fragment) {
        if (!getChildFragmentManager().getFragments().contains(fragment)) {
            FragmentTransaction addToBackStack = getChildFragmentManager().beginTransaction().replace(R.id.dsBottomSheetBodyFragmentContainer, fragment).addToBackStack(fragment.getClass().getName());
            Intrinsics.checkNotNullExpressionValue(addToBackStack, "childFragmentManager.beg…ragment::class.java.name)");
            addToBackStack.commit();
            this.tempFragment = null;
        }
    }

    private final void launchDismissTimer() {
        this.timerJob = BuildersKt__Builders_commonKt.launch$default(this.scopeMain, (CoroutineContext) null, (CoroutineStart) null, new BottomSheet$launchDismissTimer$1(this, (Continuation<? super BottomSheet$launchDismissTimer$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean navigateBack() {
        if (getChildFragmentManager().getBackStackEntryCount() <= 1) {
            dismiss();
        } else {
            getChildFragmentManager().popBackStack();
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateDialog$lambda-3$lambda-2  reason: not valid java name */
    public static final boolean m8262onCreateDialog$lambda3$lambda2(BottomSheet bottomSheet, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(bottomSheet, "this$0");
        if (i11 == 4 && keyEvent.getAction() == 1) {
            return bottomSheet.navigateBack();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m8263onViewCreated$lambda4(BottomSheet bottomSheet, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(bottomSheet, "this$0");
        Function0<Unit> onShow2 = bottomSheet.getOnShow();
        if (onShow2 != null) {
            onShow2.invoke();
        }
        if (bottomSheet.getDismissAfter() > 0) {
            bottomSheet.launchDismissTimer();
        }
        if (dialogInterface != null) {
            BottomSheetBehavior<FrameLayout> behavior = ((BottomSheetDialog) dialogInterface).getBehavior();
            Intrinsics.checkNotNullExpressionValue(behavior, "dialog as BottomSheetDialog).behavior");
            bottomSheet.setupBottomSheetBehaviour(behavior);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    private final void overrideBackNavigation() {
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new BottomSheet$overrideBackNavigation$1(this));
    }

    private final void setupAnimation() {
        Window window;
        Dialog dialog = getDialog();
        WindowManager.LayoutParams layoutParams = null;
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.windowAnimations = R.style.BottomSheetDialogAnimation;
        }
    }

    private final void setupBottomSheetBehaviour(BottomSheetBehavior<FrameLayout> bottomSheetBehavior) {
        bottomSheetBehavior.setFitToContents(true);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        bottomSheetBehavior.setPeekHeight(ActivityExtensionsKt.getScreenHeight(requireActivity));
        bottomSheetBehavior.setState(4);
        bottomSheetBehavior.setSkipCollapsed(true);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final Fragment getBody() {
        return this.body;
    }

    public final long getDismissAfter() {
        return this.dismissAfter;
    }

    @Nullable
    public final DSBaseFixedFooter getFooter() {
        return this.footer;
    }

    @Nullable
    public final DSNavigationBar getNavigationBar() {
        return this.navigationBar;
    }

    @Nullable
    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    @Nullable
    public final Function0<Unit> getOnShow() {
        return this.onShow;
    }

    public final boolean getWithNavigationBar() {
        return this.withNavigationBar;
    }

    public abstract double i0();

    public abstract boolean j0();

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnKeyListener(new a(this));
        return onCreateDialog;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.ds_bottom_sheet_container, viewGroup, false);
        ((RoundedCoordinatorLayout) inflate.findViewById(R.id.dsBottomSheetRootContainer)).setDrawRoundedCorners(!j0());
        int i11 = R.id.dsBottomSheetContentContainer;
        ((MaxHeightFrameLayout) inflate.findViewById(i11)).setMaxHeight(getMaxHeight());
        ((MaxHeightFrameLayout) inflate.findViewById(i11)).setFullScreen(j0());
        return inflate;
    }

    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, DialogNavigator.NAME);
        clearViews();
        Job job = this.timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Function0<Unit> function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
        super.onDismiss(dialogInterface);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        View view2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        overrideBackNavigation();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new b(this));
        }
        View view3 = null;
        if (this.withNavigationBar) {
            DSNavigationBar dSNavigationBar = this.navigationBar;
            View view4 = getView();
            if (view4 == null) {
                view2 = null;
            } else {
                view2 = view4.findViewById(R.id.dsBottomSheetNavigationBarContainer);
            }
            Intrinsics.checkNotNullExpressionValue(view2, "dsBottomSheetNavigationBarContainer");
            addViewToContainer(dSNavigationBar, (ViewGroup) view2);
        }
        DSBaseFixedFooter dSBaseFixedFooter = this.footer;
        View view5 = getView();
        if (view5 != null) {
            view3 = view5.findViewById(R.id.dsBottomSheetFooterContainer);
        }
        Intrinsics.checkNotNullExpressionValue(view3, "dsBottomSheetFooterContainer");
        addViewToContainer(dSBaseFixedFooter, (ViewGroup) view3);
        Fragment fragment = this.tempFragment;
        if (fragment != null) {
            initFirstContentFragment(fragment);
        }
        adjustContentMargins(view);
        setupAnimation();
    }

    public final void setBody(@Nullable Fragment fragment) {
        this.body = fragment;
        if (fragment != null) {
            changeContentFragment(fragment);
        }
    }

    public final void setDismissAfter(long j11) {
        this.dismissAfter = j11;
    }

    public final void setFooter(@Nullable DSBaseFixedFooter dSBaseFixedFooter) {
        this.footer = dSBaseFixedFooter;
    }

    public final void setNavigationBar(@Nullable DSNavigationBar dSNavigationBar) {
        this.navigationBar = dSNavigationBar;
    }

    public final void setOnDismiss(@Nullable Function0<Unit> function0) {
        this.onDismiss = function0;
    }

    public final void setOnShow(@Nullable Function0<Unit> function0) {
        this.onShow = function0;
    }

    public final void setWithNavigationBar(boolean z11) {
        this.withNavigationBar = z11;
    }

    public final void show(@NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        show(fragmentManager, DSBottomSheetDefaultContentFragmentTag);
    }
}
