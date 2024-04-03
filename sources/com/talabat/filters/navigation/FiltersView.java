package com.talabat.filters.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.talabat.filters.FiltersIntegratorKt;
import com.talabat.filters.R;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.talabatcommon.views.StartForResultCallbacks;
import datamodels.filters.Selectables;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001Bz\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u0012\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0019\u001a\u00020\u000b*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R)\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0018R)\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0018R)\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/talabat/filters/navigation/FiltersView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "type", "", "resetSelection", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "hasSelection", "", "filtersSelected", "(Landroid/content/Context;Landroid/util/AttributeSet;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "callbacks", "Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "Ldatamodels/filters/Selectables;", "getCallbacks$com_talabat_Components_filters_filters", "()Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "setCallbacks$com_talabat_Components_filters_filters", "(Lcom/talabat/talabatcommon/views/StartForResultCallbacks;)V", "Lkotlin/jvm/functions/Function1;", "updateBubbleVisibility", "Landroid/view/View;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "updateViews", "(Landroid/view/View;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_Components_filters_filters"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FiltersView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public StartForResultCallbacks<Selectables> callbacks;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Continuation<? super Integer>, Object> filtersSelected;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Continuation<? super Boolean>, Object> hasSelection;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Continuation<? super Unit>, Object> resetSelection;
    /* access modifiers changed from: private */
    public final int type;

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.filters.navigation.FiltersView$4", f = "FiltersView.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.filters.navigation.FiltersView$4  reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f59565h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ FiltersView f59566i;

        {
            this.f59566i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass4(this.f59566i, context, continuation);
        }

        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f59565h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                FiltersView filtersView = this.f59566i;
                Context context = context;
                this.f59565h = 1;
                if (filtersView.updateViews(filtersView, context, this) == coroutine_suspended) {
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
    public FiltersView(@NotNull final Context context, @NotNull AttributeSet attributeSet, int i11, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1, @NotNull Function1<? super Continuation<? super Boolean>, ? extends Object> function12, @NotNull Function1<? super Continuation<? super Integer>, ? extends Object> function13) {
        super(context, attributeSet);
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        Intrinsics.checkNotNullParameter(function1, "resetSelection");
        Intrinsics.checkNotNullParameter(function12, "hasSelection");
        Intrinsics.checkNotNullParameter(function13, "filtersSelected");
        this.type = i11;
        this.resetSelection = function1;
        this.hasSelection = function12;
        this.filtersSelected = function13;
        View.inflate(context, R.layout.view_filters, this);
        if (context instanceof LifecycleOwner) {
            lifecycleOwner = context;
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            CoroutinesKt.launchCatching$default(lifecycleScope, new Function1<Throwable, Unit>(FiltersIntegratorKt.getLogger()) {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Throwable th2) {
                    Intrinsics.checkNotNullParameter(th2, "p0");
                    ((FiltersLogger) this.receiver).displayErrorMessage(th2);
                }
            }, (CoroutineContext) null, new AnonymousClass4(this, (Continuation<? super AnonymousClass4>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void updateBubbleVisibility(View view, AppCompatActivity appCompatActivity) {
        appCompatActivity.getLifecycle().addObserver(new FiltersView$updateBubbleVisibility$1(view, this));
    }

    /* access modifiers changed from: private */
    public final Object updateViews(View view, Context context, Continuation<? super AppCompatActivity> continuation) {
        return FiltersViewKt.toActivity(context, new FiltersView$updateViews$2(view, this, context, (Continuation<? super FiltersView$updateViews$2>) null), continuation);
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
    public final StartForResultCallbacks<Selectables> getCallbacks$com_talabat_Components_filters_filters() {
        StartForResultCallbacks<Selectables> startForResultCallbacks = this.callbacks;
        if (startForResultCallbacks != null) {
            return startForResultCallbacks;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callbacks");
        return null;
    }

    public final void setCallbacks$com_talabat_Components_filters_filters(@NotNull StartForResultCallbacks<Selectables> startForResultCallbacks) {
        Intrinsics.checkNotNullParameter(startForResultCallbacks, "<set-?>");
        this.callbacks = startForResultCallbacks;
    }
}
