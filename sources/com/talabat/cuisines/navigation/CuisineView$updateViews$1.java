package com.talabat.cuisines.navigation;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.cuisines.CuisinesIntegrator;
import com.talabat.cuisines.CuisinesIntegratorKt;
import com.talabat.cuisines.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisineView$updateViews$1 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f56041g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CuisineView f56042h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f56043i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisineView$updateViews$1(View view, CuisineView cuisineView, Context context) {
        super(1);
        this.f56041g = view;
        this.f56042h = cuisineView;
        this.f56043i = context;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: com.talabat.talabatcommon.views.StartForResultCallbacks} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: com.talabat.cuisines.navigation.StartCuisineViewForResult} */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m9615invoke$lambda2(android.content.Context r2, com.talabat.cuisines.navigation.CuisineView r3, androidx.appcompat.app.AppCompatActivity r4, android.view.View r5) {
        /*
            java.lang.String r0 = "$context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "$activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            r5.setEnabled(r0)
            boolean r5 = r3.isPickup()
            tracking.AppTracker.onCuisineButtonClicked(r2, r5)
            com.talabat.core.experiment.data.TalabatExperiment r2 = com.talabat.core.experiment.data.TalabatExperiment.INSTANCE
            com.talabat.core.experiment.data.TalabatExperimentConstants r5 = com.talabat.core.experiment.data.TalabatExperimentConstants.CUISINE_SCREEN_DS_ADOPTION_EXPERIMENT
            com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy r1 = com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy.FWF
            boolean r2 = r2.getBooleanVariant(r5, r0, r1)
            r5 = 0
            if (r2 == 0) goto L_0x0047
            boolean r2 = r3.isCollection
            boolean r0 = r3.isPickup()
            com.talabat.cuisines.navigation.StartCuisineViewForResult r1 = r3.startCuisineViewForResult
            if (r1 != 0) goto L_0x003d
            java.lang.String r1 = "startCuisineViewForResult"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x003e
        L_0x003d:
            r5 = r1
        L_0x003e:
            com.talabat.cuisines.navigation.CuisineView$updateViews$1$3$1 r1 = new com.talabat.cuisines.navigation.CuisineView$updateViews$1$3$1
            r1.<init>(r3)
            com.talabat.cuisines.presentation.bottomsheet.CuisinesDSBottomSheetKt.createAndShowCuisinesDSBottomSheet(r4, r2, r0, r5, r1)
            goto L_0x0064
        L_0x0047:
            boolean r2 = r3.isCollection
            boolean r0 = r3.isPickup()
            com.talabat.talabatcommon.views.StartForResultExecutor r2 = com.talabat.cuisines.navigation.RouterKt.startFragmentForResult(r4, r2, r0)
            com.talabat.talabatcommon.views.StartForResultCallbacks r3 = r3.startForResultCallbacks
            if (r3 != 0) goto L_0x0060
            java.lang.String r3 = "startForResultCallbacks"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0061
        L_0x0060:
            r5 = r3
        L_0x0061:
            r2.with(r5)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.cuisines.navigation.CuisineView$updateViews$1.m9615invoke$lambda2(android.content.Context, com.talabat.cuisines.navigation.CuisineView, androidx.appcompat.app.AppCompatActivity, android.view.View):void");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AppCompatActivity appCompatActivity) {
        Object obj;
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        CuisineView cuisineView = this.f56042h;
        try {
            Result.Companion companion = Result.Companion;
            cuisineView.resetSelection.invoke();
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null && CuisinesIntegrator.INSTANCE.isLoggerInitialized()) {
            CuisinesIntegratorKt.getLogger().error(r02);
        }
        ((LinearLayout) this.f56041g.findViewById(R.id.cuisineViewLayout)).setOnClickListener(new a(this.f56043i, this.f56042h, appCompatActivity));
        this.f56042h.updateBubbleVisibility(appCompatActivity);
    }
}
