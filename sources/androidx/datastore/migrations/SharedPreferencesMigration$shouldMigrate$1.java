package androidx.datastore.migrations;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.migrations.SharedPreferencesMigration", f = "SharedPreferencesMigration.kt", i = {0}, l = {147}, m = "shouldMigrate", n = {"this"}, s = {"L$0"})
public final class SharedPreferencesMigration$shouldMigrate$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35713h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f35714i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesMigration<T> f35715j;

    /* renamed from: k  reason: collision with root package name */
    public int f35716k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration$shouldMigrate$1(SharedPreferencesMigration<T> sharedPreferencesMigration, Continuation<? super SharedPreferencesMigration$shouldMigrate$1> continuation) {
        super(continuation);
        this.f35715j = sharedPreferencesMigration;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35714i = obj;
        this.f35716k |= Integer.MIN_VALUE;
        return this.f35715j.shouldMigrate(null, this);
    }
}
