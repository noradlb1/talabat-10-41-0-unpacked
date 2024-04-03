package com.talabat.talabatcore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcore.extensions.LifecycleKt;
import dw.a;
import dw.b;
import dw.c;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0018\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b2\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n2%\u0010\f\u001a!\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\b\u0012\u00060\u000bj\u0002`\u000f\u0012\u0004\u0012\u0002H\u00030\n¢\u0006\u0002\b\u0010H\u0003\u001a\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bH\u0007\u001a?\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0016\"\u0004\b\u0000\u0010\u0002*\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b2\u001d\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u0010H\u0003\u001aS\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0000\u0010\u0018*\u00020\u00192'\u0010\f\u001a#\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0005j\b\u0012\u0004\u0012\u0002H\u0018`\u001a¢\u0006\u0002\b\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u00020\u0019H\u0002\u001a\u0001\u0010 \u001a\n \"*\u0004\u0018\u00010!0!\"\u0004\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00180\u00172\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180%0$2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`(2I\u0010)\u001aE\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0001j\b\u0012\u0004\u0012\u0002H\u0018`*\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180%\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u0002H\u0018`+¢\u0006\u0002\b\u0010H\u0002\u001aÆ\u0001\u0010,\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0018*\u00020\u00192\b\b\u0001\u0010-\u001a\u00020\u000b2\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180%0/2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2M\b\u0002\u0010)\u001aG\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0001j\b\u0012\u0004\u0012\u0002H\u0018`*\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010%\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u0002H\u0018`0¢\u0006\u0002\b\u00102'\u00101\u001a#\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u0002H\u0018`2¢\u0006\u0002\b\u0010H\u0002¢\u0006\u0002\u00103\u001a³\u0001\u0010,\u001a\u00020!\"\u0004\b\u0000\u0010\u0018*\u00020\u00192\b\b\u0001\u0010-\u001a\u00020\u000b2\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180%0$2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2M\b\u0002\u0010)\u001aG\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0001j\b\u0012\u0004\u0012\u0002H\u0018`*\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010%\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u0002H\u0018`0¢\u0006\u0002\b\u00102'\u00101\u001a#\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u0002H\u0018`2¢\u0006\u0002\b\u0010H\u0002\u001a\f\u00104\u001a\u000205*\u00020\u0019H\u0002\u001a»\u0001\u00106\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0018*\u00020\u00192\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180%0/2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2M\b\u0002\u0010)\u001aG\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0001j\b\u0012\u0004\u0012\u0002H\u0018`*\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010%\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u0002H\u0018`0¢\u0006\u0002\b\u00102'\u0010\f\u001a#\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0005j\b\u0012\u0004\u0012\u0002H\u0018`\u001a¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0002\u00107\u001aÀ\u0001\u00106\u001a\u00020!\"\u0004\b\u0000\u0010\u0018*\u00020\u00192\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180%0$2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2K\b\u0002\u0010)\u001aE\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0001j\b\u0012\u0004\u0012\u0002H\u0018`*\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180%\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u0002H\u0018`+¢\u0006\u0002\b\u00102\u0018\b\u0002\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`(2'\u0010\f\u001a#\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0005j\b\u0012\u0004\u0012\u0002H\u0018`\u001a¢\u0006\u0002\b\u0010H\u0003*6\b\u0002\u00108\u001a\u0004\b\u0000\u0010\u0018\"\u0014\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u00012\u0014\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0001*@\b\u0002\u00109\u001a\u0004\b\u0000\u0010\u0018\"\u0019\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u00102\u0019\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u0010*$\b\u0002\u0010:\"\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060\u0005*n\b\u0002\u0010;\u001a\u0004\b\u0000\u0010\u0018\"%\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u0018`*\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180%\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u00102;\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0001j\b\u0012\u0004\u0012\u0002H\u0018`*\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180%\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u0010*r\b\u0002\u0010<\u001a\u0004\b\u0000\u0010\u0018\"'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u0018`*\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010%\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u00102=\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0001j\b\u0012\u0004\u0012\u0002H\u0018`*\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010%\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u0010*\f\b\u0002\u0010=\"\u00020\r2\u00020\r*@\b\u0002\u0010>\u001a\u0004\b\u0000\u0010\u0018\"\u0019\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0005¢\u0006\u0002\b\u00102\u0019\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00160\u0005¢\u0006\u0002\b\u0010*\f\b\u0002\u0010?\"\u00020\u000b2\u00020\u000b¨\u0006@"}, d2 = {"Adapter", "Lcom/talabat/talabatcore/adapters/UpdatableAdapter;", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function1;", "", "items", "", "bind", "Lkotlin/Function2;", "", "createViewHolder", "Landroid/view/ViewGroup;", "Lcom/talabat/talabatcore/adapters/ParentViewGroup;", "Lcom/talabat/talabatcore/adapters/ViewType;", "Lkotlin/ExtensionFunctionType;", "inflateView", "Landroid/view/View;", "parent", "layoutResource", "ViewHolder", "Lcom/talabat/talabatcore/adapters/UpdatableViewHolder;", "Lcom/talabat/talabatcore/adapters/Binding;", "I", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/talabat/talabatcore/adapters/ViewHolderInitializer;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "contextLifecycleOwner", "disposable", "Lio/reactivex/disposables/Disposable;", "kotlin.jvm.PlatformType", "observable", "Lio/reactivex/Observable;", "", "onError", "", "Lcom/talabat/talabatcore/adapters/OnError;", "onUpdate", "Lcom/talabat/talabatcore/adapters/ItemsAdapter;", "Lcom/talabat/talabatcore/adapters/OnNonNullUpdate;", "invoke", "itemLayoutResource", "dataSource", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/talabatcore/adapters/OnUpdate;", "onBind", "Lcom/talabat/talabatcore/adapters/OnBind;", "(Landroidx/recyclerview/widget/RecyclerView;ILandroidx/lifecycle/LiveData;Landroidx/lifecycle/LifecycleOwner;Landroidx/recyclerview/widget/RecyclerView$LayoutManager;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkotlin/Unit;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "withAdapter", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LifecycleOwner;Landroidx/recyclerview/widget/RecyclerView$LayoutManager;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "ItemsAdapter", "OnBind", "OnError", "OnNonNullUpdate", "OnUpdate", "ParentViewGroup", "ViewHolderInitializer", "ViewType", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FunctionalAdaptersKt {
    @FunctionalAdaptersDsl
    private static final <T, VH extends RecyclerView.ViewHolder & Function1<? super T, ? extends Unit>> UpdatableAdapter<T, VH> Adapter(List<T> list, Function2<? super VH, ? super Integer, Unit> function2, Function2<? super ViewGroup, ? super Integer, ? extends VH> function22) {
        return new UpdatableAdapter<>(list, function2, function22);
    }

    /* access modifiers changed from: private */
    @FunctionalAdaptersDsl
    public static final <T> UpdatableViewHolder<T> ViewHolder(ViewGroup viewGroup, int i11, Function2<? super View, ? super T, Unit> function2) {
        return new UpdatableViewHolder<>(inflateView(viewGroup, i11), function2);
    }

    private static final <I> Binding<I> bind(RecyclerView recyclerView, Function1<? super ViewGroup, UpdatableViewHolder<I>> function1, RecyclerView.LayoutManager layoutManager, LifecycleOwner lifecycleOwner) {
        UpdatableAdapter e11 = e((List) null, (Function2) null, new FunctionalAdaptersKt$bind$updatableAdapter$1(function1), 3, (Object) null);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(e11);
        if (lifecycleOwner == null) {
            lifecycleOwner = contextLifecycleOwner(recyclerView);
        }
        return new Binding<>(e11, lifecycleOwner);
    }

    private static final LifecycleOwner contextLifecycleOwner(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        if (!(context instanceof LifecycleOwner)) {
            context = null;
        }
        if (context != null) {
            return (LifecycleOwner) context;
        }
        return null;
    }

    private static final <I> Disposable disposable(Binding<I> binding, Observable<List<I>> observable, Function1<? super Throwable, Unit> function1, Function2<? super UpdatableAdapter<I, UpdatableViewHolder<I>>, ? super List<? extends I>, Unit> function2) {
        return observable.share().observeOn(AndroidSchedulers.mainThread()).doOnError(new a(function1)).onErrorReturnItem(new ArrayList()).subscribe(new a(function2, binding));
    }

    /* access modifiers changed from: private */
    /* renamed from: disposable$lambda-5  reason: not valid java name */
    public static final void m5823disposable$lambda5(Function1 function1, Throwable th2) {
        Intrinsics.checkNotNullParameter(function1, "$onError");
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        function1.invoke(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: disposable$lambda-6  reason: not valid java name */
    public static final void m5824disposable$lambda6(Function2 function2, Binding binding, List list) {
        Intrinsics.checkNotNullParameter(function2, "$onUpdate");
        Intrinsics.checkNotNullParameter(binding, "$this_disposable");
        UpdatableAdapter itemsAdapter = binding.getItemsAdapter();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        function2.invoke(itemsAdapter, list);
    }

    public static /* synthetic */ UpdatableAdapter e(List list, Function2 function2, Function2 function22, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = new ArrayList();
        }
        if ((i11 & 2) != 0) {
            function2 = new FunctionalAdaptersKt$Adapter$1(list);
        }
        return Adapter(list, function2, function22);
    }

    public static /* synthetic */ Disposable f(RecyclerView recyclerView, Observable observable, RecyclerView.LayoutManager layoutManager, Function2 function2, Function1 function1, Function1 function12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            layoutManager = linearLayoutManager(recyclerView);
        }
        RecyclerView.LayoutManager layoutManager2 = layoutManager;
        if ((i11 & 4) != 0) {
            function2 = FunctionalAdaptersKt$withAdapter$3.INSTANCE;
        }
        Function2 function22 = function2;
        if ((i11 & 8) != 0) {
            function1 = FunctionalAdaptersKt$withAdapter$4.INSTANCE;
        }
        return withAdapter(recyclerView, observable, layoutManager2, function22, (Function1<? super Throwable, Unit>) function1, function12);
    }

    @FunctionalAdaptersDsl
    @NotNull
    public static final View inflateView(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …tResource, parent, false)");
        return inflate;
    }

    @FunctionalAdaptersDsl
    @Nullable
    public static final <I> Unit invoke(@NotNull RecyclerView recyclerView, @LayoutRes int i11, @NotNull LiveData<List<I>> liveData, @Nullable LifecycleOwner lifecycleOwner, @NotNull RecyclerView.LayoutManager layoutManager, @NotNull Function2<? super UpdatableAdapter<I, UpdatableViewHolder<I>>, ? super List<? extends I>, Unit> function2, @NotNull Function2<? super View, ? super I, Unit> function22) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(liveData, "dataSource");
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(function2, "onUpdate");
        Intrinsics.checkNotNullParameter(function22, "onBind");
        return withAdapter(recyclerView, liveData, lifecycleOwner, layoutManager, function2, new FunctionalAdaptersKt$invoke$2(i11, function22));
    }

    public static /* synthetic */ Unit invoke$default(RecyclerView recyclerView, int i11, LiveData liveData, LifecycleOwner lifecycleOwner, RecyclerView.LayoutManager layoutManager, Function2 function2, Function2 function22, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            lifecycleOwner = null;
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if ((i12 & 8) != 0) {
            layoutManager = linearLayoutManager(recyclerView);
        }
        RecyclerView.LayoutManager layoutManager2 = layoutManager;
        if ((i12 & 16) != 0) {
            function2 = FunctionalAdaptersKt$invoke$1.INSTANCE;
        }
        return invoke(recyclerView, i11, liveData, lifecycleOwner2, layoutManager2, function2, function22);
    }

    private static final LinearLayoutManager linearLayoutManager(RecyclerView recyclerView) {
        return new LinearLayoutManager(recyclerView.getContext(), 1, false);
    }

    @FunctionalAdaptersDsl
    private static final <I> Unit withAdapter(RecyclerView recyclerView, LiveData<List<I>> liveData, LifecycleOwner lifecycleOwner, RecyclerView.LayoutManager layoutManager, Function2<? super UpdatableAdapter<I, UpdatableViewHolder<I>>, ? super List<? extends I>, Unit> function2, Function1<? super ViewGroup, UpdatableViewHolder<I>> function1) {
        Binding<I> bind = bind(recyclerView, function1, layoutManager, lifecycleOwner);
        if (lifecycleOwner == null) {
            return null;
        }
        LifecycleKt.observe(lifecycleOwner, liveData, new FunctionalAdaptersKt$withAdapter$2$1(function2, bind));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: withAdapter$lambda-3  reason: not valid java name */
    public static final void m5825withAdapter$lambda3(Function1 function1, Throwable th2) {
        Intrinsics.checkNotNullParameter(function1, "$onError");
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        function1.invoke(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: withAdapter$lambda-4  reason: not valid java name */
    public static final void m5826withAdapter$lambda4(Function2 function2, UpdatableAdapter updatableAdapter, List list) {
        Intrinsics.checkNotNullParameter(function2, "$onUpdate");
        Intrinsics.checkNotNullParameter(updatableAdapter, "$updatableAdapter");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        function2.invoke(updatableAdapter, list);
    }

    @FunctionalAdaptersDsl
    @NotNull
    public static final <I> Disposable invoke(@NotNull RecyclerView recyclerView, @LayoutRes int i11, @NotNull Observable<List<I>> observable, @NotNull RecyclerView.LayoutManager layoutManager, @NotNull Function2<? super UpdatableAdapter<I, UpdatableViewHolder<I>>, ? super List<? extends I>, Unit> function2, @NotNull Function2<? super View, ? super I, Unit> function22) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(observable, "dataSource");
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(function2, "onUpdate");
        Intrinsics.checkNotNullParameter(function22, "onBind");
        return f(recyclerView, observable, layoutManager, function2, (Function1) null, new FunctionalAdaptersKt$invoke$4(i11, function22), 8, (Object) null);
    }

    @FunctionalAdaptersDsl
    private static final <I> Disposable withAdapter(RecyclerView recyclerView, Observable<List<I>> observable, RecyclerView.LayoutManager layoutManager, Function2<? super UpdatableAdapter<I, UpdatableViewHolder<I>>, ? super List<? extends I>, Unit> function2, Function1<? super Throwable, Unit> function1, Function1<? super ViewGroup, UpdatableViewHolder<I>> function12) {
        UpdatableAdapter e11 = e((List) null, (Function2) null, new FunctionalAdaptersKt$withAdapter$updatableAdapter$1(function12), 3, (Object) null);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(e11);
        Disposable subscribe = observable.share().observeOn(AndroidSchedulers.mainThread()).doOnError(new b(function1)).onErrorReturnItem(new ArrayList()).subscribe(new c(function2, e11));
        Intrinsics.checkNotNullExpressionValue(subscribe, "observable.share()\n     …bleAdapter.onUpdate(it) }");
        return subscribe;
    }

    public static /* synthetic */ Disposable invoke$default(RecyclerView recyclerView, int i11, Observable observable, RecyclerView.LayoutManager layoutManager, Function2 function2, Function2 function22, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            layoutManager = linearLayoutManager(recyclerView);
        }
        RecyclerView.LayoutManager layoutManager2 = layoutManager;
        if ((i12 & 8) != 0) {
            function2 = FunctionalAdaptersKt$invoke$3.INSTANCE;
        }
        return invoke(recyclerView, i11, observable, layoutManager2, function2, function22);
    }
}
