package androidx.datastore.preferences.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
public final class PreferencesKt$edit$2 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f35733h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f35734i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<MutablePreferences, Continuation<? super Unit>, Object> f35735j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreferencesKt$edit$2(Function2<? super MutablePreferences, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super PreferencesKt$edit$2> continuation) {
        super(2, continuation);
        this.f35735j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PreferencesKt$edit$2 preferencesKt$edit$2 = new PreferencesKt$edit$2(this.f35735j, continuation);
        preferencesKt$edit$2.f35734i = obj;
        return preferencesKt$edit$2;
    }

    @Nullable
    public final Object invoke(@NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
        return ((PreferencesKt$edit$2) create(preferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f35733h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutablePreferences mutablePreferences = ((Preferences) this.f35734i).toMutablePreferences();
            Function2<MutablePreferences, Continuation<? super Unit>, Object> function2 = this.f35735j;
            this.f35734i = mutablePreferences;
            this.f35733h = 1;
            if (function2.invoke(mutablePreferences, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return mutablePreferences;
        } else if (i11 == 1) {
            MutablePreferences mutablePreferences2 = (MutablePreferences) this.f35734i;
            ResultKt.throwOnFailure(obj);
            return mutablePreferences2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
