package com.talabat.filters.navigation;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.filters.FiltersIntegratorKt;
import com.talabat.filters.R;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/appcompat/app/AppCompatActivity;", "activity", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.navigation.FiltersView$updateViews$2", f = "FiltersView.kt", i = {0}, l = {52}, m = "invokeSuspend", n = {"activity"}, s = {"L$0"})
public final class FiltersView$updateViews$2 extends SuspendLambda implements Function2<AppCompatActivity, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59574h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59575i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ View f59576j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FiltersView f59577k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f59578l;

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.filters.navigation.FiltersView$updateViews$2$2", f = "FiltersView.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.filters.navigation.FiltersView$updateViews$2$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f59579h;

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass2(filtersView, continuation);
        }

        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f59579h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Function1 access$getResetSelection$p = filtersView.resetSelection;
                this.f59579h = 1;
                if (access$getResetSelection$p.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersView$updateViews$2(View view, FiltersView filtersView, Context context, Continuation<? super FiltersView$updateViews$2> continuation) {
        super(2, continuation);
        this.f59576j = view;
        this.f59577k = filtersView;
        this.f59578l = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m10434invokeSuspend$lambda0(Context context, AppCompatActivity appCompatActivity, FiltersView filtersView, View view) {
        view.setEnabled(false);
        AppTracker.onFilterButtonClicked(context);
        RouterKt.startFragmentForResult(appCompatActivity, filtersView.type).with(filtersView.getCallbacks$com_talabat_Components_filters_filters());
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FiltersView$updateViews$2 filtersView$updateViews$2 = new FiltersView$updateViews$2(this.f59576j, this.f59577k, this.f59578l, continuation);
        filtersView$updateViews$2.f59575i = obj;
        return filtersView$updateViews$2;
    }

    @Nullable
    public final Object invoke(@NotNull AppCompatActivity appCompatActivity, @Nullable Continuation<? super Unit> continuation) {
        return ((FiltersView$updateViews$2) create(appCompatActivity, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AppCompatActivity appCompatActivity;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59574h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            AppCompatActivity appCompatActivity2 = (AppCompatActivity) this.f59575i;
            AnonymousClass1 r12 = new Function1<Throwable, Unit>(FiltersIntegratorKt.getLogger()) {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Throwable th2) {
                    Intrinsics.checkNotNullParameter(th2, "p0");
                    ((FiltersLogger) this.receiver).displayErrorMessage(th2);
                }
            };
            final FiltersView filtersView = this.f59577k;
            AnonymousClass2 r32 = new AnonymousClass2((Continuation<? super AnonymousClass2>) null);
            this.f59575i = appCompatActivity2;
            this.f59574h = 1;
            if (CoroutinesKt.runSuspended(r12, r32, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            appCompatActivity = appCompatActivity2;
        } else if (i11 == 1) {
            appCompatActivity = (AppCompatActivity) this.f59575i;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ((LinearLayout) this.f59576j.findViewById(R.id.filtersViewLayout)).setOnClickListener(new a(this.f59578l, appCompatActivity, this.f59577k));
        this.f59577k.updateBubbleVisibility(this.f59576j, appCompatActivity);
        return Unit.INSTANCE;
    }
}
