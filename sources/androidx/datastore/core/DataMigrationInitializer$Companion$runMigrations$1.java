package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", i = {0, 1}, l = {42, 57}, m = "runMigrations", n = {"cleanUps", "cleanUpFailure"}, s = {"L$0", "L$0"})
public final class DataMigrationInitializer$Companion$runMigrations$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35609h;

    /* renamed from: i  reason: collision with root package name */
    public Object f35610i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f35611j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DataMigrationInitializer.Companion f35612k;

    /* renamed from: l  reason: collision with root package name */
    public int f35613l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$1(DataMigrationInitializer.Companion companion, Continuation<? super DataMigrationInitializer$Companion$runMigrations$1> continuation) {
        super(continuation);
        this.f35612k = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35611j = obj;
        this.f35613l |= Integer.MIN_VALUE;
        return this.f35612k.runMigrations((List) null, (InitializerApi) null, this);
    }
}
