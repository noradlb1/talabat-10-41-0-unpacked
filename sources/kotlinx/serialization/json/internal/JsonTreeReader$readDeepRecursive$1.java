package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H@"}, d2 = {"Lkotlin/DeepRecursiveScope;", "", "Lkotlinx/serialization/json/JsonElement;", "it", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
public final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f26444h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ JsonTreeReader f26445i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readDeepRecursive$1> continuation) {
        super(3, continuation);
        this.f26445i = jsonTreeReader;
    }

    @Nullable
    public final Object invoke(@NotNull DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, @NotNull Unit unit, @Nullable Continuation<? super JsonElement> continuation) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.f26445i, continuation);
        jsonTreeReader$readDeepRecursive$1.L$0 = deepRecursiveScope;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26444h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepRecursiveScope deepRecursiveScope = (DeepRecursiveScope) this.L$0;
            byte peekNextToken = this.f26445i.lexer.peekNextToken();
            if (peekNextToken == 1) {
                return this.f26445i.readValue(true);
            }
            if (peekNextToken == 0) {
                return this.f26445i.readValue(false);
            }
            if (peekNextToken == 6) {
                JsonTreeReader jsonTreeReader = this.f26445i;
                this.f26444h = 1;
                obj = jsonTreeReader.readObject(deepRecursiveScope, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (peekNextToken == 8) {
                return this.f26445i.readArray();
            } else {
                AbstractJsonLexer.fail$default(this.f26445i.lexer, "Can't begin reading element, unexpected token", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (JsonElement) obj;
    }
}
