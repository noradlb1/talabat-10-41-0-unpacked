package androidx.datastore;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DataStoreSingletonDelegate$getValue$1$1 extends Lambda implements Function0<File> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f11566g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DataStoreSingletonDelegate<T> f11567h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreSingletonDelegate$getValue$1$1(Context context, DataStoreSingletonDelegate<T> dataStoreSingletonDelegate) {
        super(0);
        this.f11566g = context;
        this.f11567h = dataStoreSingletonDelegate;
    }

    @NotNull
    public final File invoke() {
        Context context = this.f11566g;
        Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
        return DataStoreFile.dataStoreFile(context, this.f11567h.fileName);
    }
}
