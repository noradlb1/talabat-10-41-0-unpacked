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
@DebugMetadata(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
public final class PreferenceDataStore$updateData$2 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f35728h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f35729i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Preferences, Continuation<? super Preferences>, Object> f35730j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreferenceDataStore$updateData$2(Function2<? super Preferences, ? super Continuation<? super Preferences>, ? extends Object> function2, Continuation<? super PreferenceDataStore$updateData$2> continuation) {
        super(2, continuation);
        this.f35730j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PreferenceDataStore$updateData$2 preferenceDataStore$updateData$2 = new PreferenceDataStore$updateData$2(this.f35730j, continuation);
        preferenceDataStore$updateData$2.f35729i = obj;
        return preferenceDataStore$updateData$2;
    }

    @Nullable
    public final Object invoke(@NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
        return ((PreferenceDataStore$updateData$2) create(preferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f35728h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<Preferences, Continuation<? super Preferences>, Object> function2 = this.f35730j;
            this.f35728h = 1;
            obj = function2.invoke((Preferences) this.f35729i, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Preferences preferences = (Preferences) obj;
        ((MutablePreferences) preferences).freeze$datastore_preferences_core();
        return preferences;
    }
}
