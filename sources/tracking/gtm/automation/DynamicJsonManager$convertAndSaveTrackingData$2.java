package tracking.gtm.automation;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import tracking.gtm.automation.utils.FileUtils;

@Instrumented
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "tracking.gtm.automation.DynamicJsonManager$convertAndSaveTrackingData$2", f = "DynamicJsonManager.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class DynamicJsonManager$convertAndSaveTrackingData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f63544h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ JSONArray f63545i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f63546j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Context f63547k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicJsonManager$convertAndSaveTrackingData$2(JSONArray jSONArray, String str, Context context, Continuation<? super DynamicJsonManager$convertAndSaveTrackingData$2> continuation) {
        super(2, continuation);
        this.f63545i = jSONArray;
        this.f63546j = str;
        this.f63547k = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DynamicJsonManager$convertAndSaveTrackingData$2(this.f63545i, this.f63546j, this.f63547k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((DynamicJsonManager$convertAndSaveTrackingData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        String str2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f63544h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            JsonParser jsonParser = new JsonParser();
            Gson create = new GsonBuilder().setPrettyPrinting().create();
            Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder().setPrettyPrinting().create()");
            JSONArray jSONArray = this.f63545i;
            if (!(jSONArray instanceof JSONArray)) {
                str = jSONArray.toString();
            } else {
                str = JSONArrayInstrumentation.toString(jSONArray);
            }
            JsonElement parse = jsonParser.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "jParser.parse(eventJsonArray.toString())");
            if (!(create instanceof Gson)) {
                str2 = create.toJson(parse);
            } else {
                str2 = GsonInstrumentation.toJson(create, parse);
            }
            String str3 = str2;
            Intrinsics.checkNotNullExpressionValue(str3, "gsonBuilder.toJson(jElement)");
            FileUtils.Companion companion = FileUtils.Companion;
            String str4 = this.f63546j;
            Context context = this.f63547k;
            this.f63544h = 1;
            obj = companion.writeToFileKotlin(str4, str3, EventLogConstants.TRACKING_FOLDER, context, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
