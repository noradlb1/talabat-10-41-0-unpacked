package tracking.gtm.automation.utils;

import android.content.Context;
import com.talabat.talabatcore.logger.LogManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "tracking.gtm.automation.utils.FileUtils$Companion$writeToFileKotlin$2", f = "FileUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileUtils$Companion$writeToFileKotlin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f63554h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f63555i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Context f63556j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f63557k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f63558l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileUtils$Companion$writeToFileKotlin$2(String str, Context context, String str2, String str3, Continuation<? super FileUtils$Companion$writeToFileKotlin$2> continuation) {
        super(2, continuation);
        this.f63555i = str;
        this.f63556j = context;
        this.f63557k = str2;
        this.f63558l = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileUtils$Companion$writeToFileKotlin$2(this.f63555i, this.f63556j, this.f63557k, this.f63558l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((FileUtils$Companion$writeToFileKotlin$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f63554h == 0) {
            ResultKt.throwOnFailure(obj);
            File absoluteFilesPath = FileUtils.Companion.getAbsoluteFilesPath(this.f63555i, this.f63556j);
            if (!absoluteFilesPath.exists()) {
                absoluteFilesPath.mkdirs();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(absoluteFilesPath, this.f63557k));
                byte[] bytes = this.f63558l.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
                TrackingPreferenceUtils.INSTANCE.clearJsonFromPreference(this.f63556j);
                return Boxing.boxBoolean(true);
            } catch (FileNotFoundException e11) {
                String message = e11.getMessage();
                LogManager.debug("TrackingAutomation: " + message);
                return Boxing.boxBoolean(false);
            } catch (NumberFormatException e12) {
                String message2 = e12.getMessage();
                LogManager.debug("TrackingAutomation: " + message2);
                return Boxing.boxBoolean(false);
            } catch (IOException e13) {
                String message3 = e13.getMessage();
                LogManager.debug("TrackingAutomation: " + message3);
                return Boxing.boxBoolean(false);
            } catch (Exception e14) {
                String message4 = e14.getMessage();
                LogManager.debug("TrackingAutomation: " + message4);
                return Boxing.boxBoolean(false);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
