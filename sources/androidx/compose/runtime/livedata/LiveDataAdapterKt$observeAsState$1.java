package androidx.compose.runtime.livedata;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class LiveDataAdapterKt$observeAsState$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LiveData<T> f9482g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f9483h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<R> f9484i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDataAdapterKt$observeAsState$1(LiveData<T> liveData, LifecycleOwner lifecycleOwner, MutableState<R> mutableState) {
        super(1);
        this.f9482g = liveData;
        this.f9483h = lifecycleOwner;
        this.f9484i = mutableState;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        LiveDataAdapterKt$observeAsState$1$observer$1 liveDataAdapterKt$observeAsState$1$observer$1 = new LiveDataAdapterKt$observeAsState$1$observer$1(this.f9484i);
        this.f9482g.observe(this.f9483h, liveDataAdapterKt$observeAsState$1$observer$1);
        return new LiveDataAdapterKt$observeAsState$1$invoke$$inlined$onDispose$1(this.f9482g, liveDataAdapterKt$observeAsState$1$observer$1);
    }
}
