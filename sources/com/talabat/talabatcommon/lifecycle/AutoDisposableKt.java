package com.talabat.talabatcommon.lifecycle;

import android.content.Context;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ActivityKt;
import com.talabat.talabatcommon.extentions.ThrowablesKt;
import io.reactivex.Observer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0007\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0007\u001a&\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0007\u001aC\u0010\u0006\u001a\u00020\u0001\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\b2\u001b\b\u0004\u0010\t\u001a\u0015\u0012\u0004\u0012\u0002H\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004H\u0007\u001a-\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00122\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0004¢\u0006\u0002\u0010\u0013\u001a>\u0010\u0014\u001a\u00020\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0002*\u0002H\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0018\u001a<\u0010\u0019\u001a\u00020\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0002*\u0002H\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001c\u001a/\u0010\u001d\u001a\u00020\u0001*\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007\u001a%\u0010 \u001a\u00020!*\u00020\"2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007\u001a7\u0010$\u001a\u00020\u0001\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000b*\u00020\u00022\u0019\b\u0004\u0010%\u001a\u0013\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006&"}, d2 = {"autoDisposeOwner", "", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "initializer", "Lkotlin/Function0;", "autoDisposeView", "bind", "layoutId", "", "binding", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "closeSubjects", "", "beforeClose", "withAutoDisposables", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "withContextLifecycle", "T", "context", "onInitialize", "(Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "withLifecycle", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;)V", "withLifecycleAutoDisposables", "registerOnLifecycleEvent", "Landroidx/lifecycle/Lifecycle$Event;", "withViewHolder", "Landroid/view/View;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "block", "withViewModel", "binder", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AutoDisposableKt {
    @AutoDisposableDsl
    public static final void autoDisposeOwner(@NotNull AutoDisposable autoDisposable, @NotNull Function0<Unit> function0) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(autoDisposable, "<this>");
        Intrinsics.checkNotNullParameter(function0, "initializer");
        Unit unit = null;
        if (autoDisposable instanceof LifecycleOwner) {
            lifecycleOwner = autoDisposable;
        } else {
            lifecycleOwner = null;
        }
        if (!(lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
            lifecycle.addObserver(new AutoDisposableKt$autoDisposeOwner$3(function0, autoDisposable));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            throw new UnsupportedOperationException(autoDisposable + " must be a LifecycleOwner");
        }
    }

    @AutoDisposableDsl
    public static final void autoDisposeView(@NotNull AutoDisposable autoDisposable, @NotNull Function0<Unit> function0) {
        View view;
        Intrinsics.checkNotNullParameter(autoDisposable, "<this>");
        Intrinsics.checkNotNullParameter(function0, "initializer");
        Unit unit = null;
        if (autoDisposable instanceof View) {
            view = autoDisposable;
        } else {
            view = null;
        }
        if (view != null) {
            view.addOnAttachStateChangeListener(new AutoDisposableKt$autoDisposeView$3(function0, autoDisposable));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            throw new UnsupportedOperationException(autoDisposable + " must be a View");
        }
    }

    @AutoDisposableDsl
    public static final void bind(@NotNull AutoDisposable autoDisposable, @LayoutRes int i11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(autoDisposable, "<this>");
        Intrinsics.checkNotNullParameter(function0, "binding");
        if (autoDisposable instanceof View) {
            ViewKt.withLayout((View) autoDisposable, i11, new AutoDisposableKt$bind$1(autoDisposable, function0));
        } else if (autoDisposable instanceof AppCompatActivity) {
            ActivityKt.withLayout((AppCompatActivity) autoDisposable, i11, new AutoDisposableKt$bind$2(autoDisposable, function0));
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View or AppCompatActivity"));
        }
    }

    @AutoDisposableDsl
    public static final void closeSubjects(@NotNull Object obj, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (function0 != null) {
            Unit invoke = function0.invoke();
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "javaClass.declaredFields");
        ArrayList arrayList = new ArrayList(declaredFields.length);
        for (Field field : declaredFields) {
            field.setAccessible(true);
            arrayList.add(field);
        }
        ArrayList<Field> arrayList2 = new ArrayList<>();
        for (Object next : arrayList) {
            if (!((Field) next).isAnnotationPresent(ExcludeFromOnCleared.class)) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Field field2 : arrayList2) {
            Object obj2 = field2.get(obj);
            if (obj2 != null) {
                arrayList3.add(obj2);
            }
        }
        ArrayList<Observer> arrayList4 = new ArrayList<>();
        for (Object next2 : arrayList3) {
            if (next2 instanceof Observer) {
                arrayList4.add(next2);
            }
        }
        for (Observer onComplete : arrayList4) {
            onComplete.onComplete();
        }
    }

    public static /* synthetic */ void closeSubjects$default(Object obj, Function0 function0, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            function0 = null;
        }
        closeSubjects(obj, function0);
    }

    @Nullable
    @AutoDisposableDsl
    public static final Unit withAutoDisposables(@NotNull Context context, @NotNull Function1<? super AutoDisposable, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(function1, "initializer");
        if (!(context instanceof LifecycleOwner)) {
            context = null;
        }
        if (context == null) {
            return null;
        }
        withLifecycleAutoDisposables$default((LifecycleOwner) context, (Lifecycle.Event) null, new AutoDisposableKt$withAutoDisposables$3(function1), 1, (Object) null);
        return Unit.INSTANCE;
    }

    @AutoDisposableDsl
    public static final <T extends AutoDisposable> void withContextLifecycle(@NotNull T t11, @Nullable Context context, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onInitialize");
        Unit unit = null;
        if (context != null) {
            if (!(context instanceof LifecycleOwner)) {
                context = null;
            }
            if (context != null) {
                withLifecycle(t11, (LifecycleOwner) context, function1);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            ThrowablesKt.log(new UnsupportedOperationException("context must be a LifecycleOwner"));
        }
    }

    @AutoDisposableDsl
    public static final <T extends AutoDisposable> void withLifecycle(@NotNull T t11, @NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(function1, "onInitialize");
        lifecycleOwner.getLifecycle().addObserver(new AutoDisposableKt$withLifecycle$1(function1, t11));
    }

    @AutoDisposableDsl
    public static final void withLifecycleAutoDisposables(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event, @NotNull Function1<? super AutoDisposable, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(event, "registerOnLifecycleEvent");
        Intrinsics.checkNotNullParameter(function1, "initializer");
        lifecycleOwner.getLifecycle().addObserver(new AutoDisposableKt$withLifecycleAutoDisposables$1(event, function1));
    }

    public static /* synthetic */ void withLifecycleAutoDisposables$default(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            event = Lifecycle.Event.ON_CREATE;
        }
        withLifecycleAutoDisposables(lifecycleOwner, event, function1);
    }

    @NotNull
    @AutoDisposableDsl
    public static final View withViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewHolder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        View view = viewHolder.itemView;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        withAutoDisposables(context, new AutoDisposableKt$withViewHolder$1$1(function1, view));
        Intrinsics.checkNotNullExpressionValue(view, "itemView.apply {\n    ite…{\n        block()\n    }\n}");
        return view;
    }

    @AutoDisposableDsl
    public static final /* synthetic */ <VM extends ViewModel> void withViewModel(AutoDisposable autoDisposable, Function1<? super VM, Unit> function1) {
        Intrinsics.checkNotNullParameter(autoDisposable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "binder");
        if (autoDisposable instanceof View) {
            Intrinsics.needClassReification();
            autoDisposeView(autoDisposable, new AutoDisposableKt$withViewModel$1(autoDisposable, function1));
        } else if (autoDisposable instanceof AppCompatActivity) {
            Intrinsics.needClassReification();
            autoDisposeOwner(autoDisposable, new AutoDisposableKt$withViewModel$2(function1, autoDisposable));
        } else if (autoDisposable instanceof Fragment) {
            Intrinsics.needClassReification();
            autoDisposeOwner(autoDisposable, new AutoDisposableKt$withViewModel$3(function1, autoDisposable));
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View, AppCompatActivity, or a Fragment"));
        }
    }

    @AutoDisposableDsl
    public static final /* synthetic */ <VM extends ViewModel> void bind(AutoDisposable autoDisposable, @LayoutRes int i11, Function1<? super VM, Unit> function1) {
        Intrinsics.checkNotNullParameter(autoDisposable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "binding");
        if (autoDisposable instanceof View) {
            Intrinsics.needClassReification();
            ViewKt.withLayout((View) autoDisposable, i11, new AutoDisposableKt$bind$3(autoDisposable, function1));
        } else if (autoDisposable instanceof AppCompatActivity) {
            Intrinsics.needClassReification();
            ActivityKt.withLayout((AppCompatActivity) autoDisposable, i11, new AutoDisposableKt$bind$4(autoDisposable, function1));
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View or AppCompatActivity"));
        }
    }
}
