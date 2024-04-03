package androidx.datastore.preferences;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PreferenceDataStoreSingletonDelegate$getValue$1$1 extends Lambda implements Function0<File> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f35718g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PreferenceDataStoreSingletonDelegate f35719h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreSingletonDelegate$getValue$1$1(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        super(0);
        this.f35718g = context;
        this.f35719h = preferenceDataStoreSingletonDelegate;
    }

    @NotNull
    public final File invoke() {
        Context context = this.f35718g;
        Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
        return PreferenceDataStoreFile.preferencesDataStoreFile(context, this.f35719h.f35717name);
    }
}
