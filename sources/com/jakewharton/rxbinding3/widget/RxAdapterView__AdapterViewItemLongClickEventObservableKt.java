package com.jakewharton.rxbinding3.widget;

import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.jakewharton.rxbinding3.internal.AlwaysTrue;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a8\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007¨\u0006\t"}, d2 = {"itemLongClickEvents", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/widget/AdapterViewItemLongClickEvent;", "T", "Landroid/widget/Adapter;", "Landroid/widget/AdapterView;", "handled", "Lkotlin/Function1;", "", "rxbinding_release"}, k = 5, mv = {1, 1, 15}, xs = "com/jakewharton/rxbinding3/widget/RxAdapterView")
final /* synthetic */ class RxAdapterView__AdapterViewItemLongClickEventObservableKt {
    @CheckResult
    @NotNull
    @JvmOverloads
    public static final <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(@NotNull AdapterView<T> adapterView) {
        return itemLongClickEvents$default(adapterView, (Function1) null, 1, (Object) null);
    }

    @CheckResult
    @NotNull
    @JvmOverloads
    public static final <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(@NotNull AdapterView<T> adapterView, @NotNull Function1<? super AdapterViewItemLongClickEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(adapterView, "$this$itemLongClickEvents");
        Intrinsics.checkParameterIsNotNull(function1, InstabugDbContract.CrashEntry.COLUMN_HANDLED);
        return new AdapterViewItemLongClickEventObservable(adapterView, function1);
    }

    public static /* synthetic */ Observable itemLongClickEvents$default(AdapterView adapterView, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = AlwaysTrue.INSTANCE;
        }
        return RxAdapterView.itemLongClickEvents(adapterView, function1);
    }
}
