package tracking.perseus;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.configuration.country.Country;
import com.talabat.perseus.Perseus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.perseus.TalabatPerseus;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "tracking.perseus.TalabatPerseus$Companion$configurePerseusAsync$1", f = "TalabatPerseus.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TalabatPerseus$Companion$configurePerseusAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f63562h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Country f63563i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f63564j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f63565k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f63566l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f63567m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f63568n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f63569o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Context f63570p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f63571q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f63572r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ String f63573s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ String f63574t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f63575u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatPerseus$Companion$configurePerseusAsync$1(Country country, String str, String str2, String str3, String str4, String str5, String str6, Context context, boolean z11, String str7, String str8, String str9, SharedPreferences sharedPreferences, Continuation<? super TalabatPerseus$Companion$configurePerseusAsync$1> continuation) {
        super(2, continuation);
        this.f63563i = country;
        this.f63564j = str;
        this.f63565k = str2;
        this.f63566l = str3;
        this.f63567m = str4;
        this.f63568n = str5;
        this.f63569o = str6;
        this.f63570p = context;
        this.f63571q = z11;
        this.f63572r = str7;
        this.f63573s = str8;
        this.f63574t = str9;
        this.f63575u = sharedPreferences;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TalabatPerseus$Companion$configurePerseusAsync$1(this.f63563i, this.f63564j, this.f63565k, this.f63566l, this.f63567m, this.f63568n, this.f63569o, this.f63570p, this.f63571q, this.f63572r, this.f63573s, this.f63574t, this.f63575u, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TalabatPerseus$Companion$configurePerseusAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f63562h == 0) {
            ResultKt.throwOnFailure(obj);
            Perseus.INSTANCE.configurePerseus(this.f63564j, this.f63565k, this.f63566l, this.f63567m, this.f63568n, this.f63569o, this.f63570p, PerseusCountryMapperKt.perseusCountryCode(this.f63563i), this.f63571q, PerseusCountryMapperKt.perseusGlobalEntityId(this.f63563i), this.f63572r, this.f63573s, this.f63574t);
            this.f63575u.edit().putString("KIW387", TalabatPerseus.Companion.getMyClientId$default(TalabatPerseus.Companion, (Context) null, 1, (Object) null)).apply();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
