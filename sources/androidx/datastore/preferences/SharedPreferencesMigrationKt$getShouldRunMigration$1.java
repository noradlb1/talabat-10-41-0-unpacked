package androidx.datastore.preferences;

import androidx.datastore.preferences.core.Preferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "prefs", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getShouldRunMigration$1", f = "SharedPreferencesMigration.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SharedPreferencesMigrationKt$getShouldRunMigration$1 extends SuspendLambda implements Function2<Preferences, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f35725h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f35726i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Set<String> f35727j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigrationKt$getShouldRunMigration$1(Set<String> set, Continuation<? super SharedPreferencesMigrationKt$getShouldRunMigration$1> continuation) {
        super(2, continuation);
        this.f35727j = set;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SharedPreferencesMigrationKt$getShouldRunMigration$1 sharedPreferencesMigrationKt$getShouldRunMigration$1 = new SharedPreferencesMigrationKt$getShouldRunMigration$1(this.f35727j, continuation);
        sharedPreferencesMigrationKt$getShouldRunMigration$1.f35726i = obj;
        return sharedPreferencesMigrationKt$getShouldRunMigration$1;
    }

    @Nullable
    public final Object invoke(@NotNull Preferences preferences, @Nullable Continuation<? super Boolean> continuation) {
        return ((SharedPreferencesMigrationKt$getShouldRunMigration$1) create(preferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f35725h == 0) {
            ResultKt.throwOnFailure(obj);
            Set<Preferences.Key<?>> keySet = ((Preferences) this.f35726i).asMap().keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10));
            for (Preferences.Key name2 : keySet) {
                arrayList.add(name2.getName());
            }
            boolean z11 = true;
            if (this.f35727j != SharedPreferencesMigrationKt.getMIGRATE_ALL_KEYS()) {
                Set<String> set = this.f35727j;
                if (!(set instanceof Collection) || !set.isEmpty()) {
                    Iterator<T> it = set.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Boxing.boxBoolean(!arrayList.contains((String) it.next())).booleanValue()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z11 = false;
            }
            return Boxing.boxBoolean(z11);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
