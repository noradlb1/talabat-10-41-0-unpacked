package com.braze.ui.actions.brazeactions.steps;

import androidx.annotation.VisibleForTesting;
import com.appboy.enums.Channel;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b#J\t\u0010$\u001a\u00020\u001bHÖ\u0001J\u001c\u0010%\u001a\u00020 2\b\b\u0002\u0010&\u001a\u00020\u001b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010*\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010+\u001a\u00020,H\u0016R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00018FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00018FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/braze/ui/actions/brazeactions/steps/StepData;", "", "srcJson", "Lorg/json/JSONObject;", "channel", "Lcom/appboy/enums/Channel;", "(Lorg/json/JSONObject;Lcom/appboy/enums/Channel;)V", "args", "", "getArgs", "()Ljava/util/List;", "args$delegate", "Lkotlin/Lazy;", "getChannel", "()Lcom/appboy/enums/Channel;", "firstArg", "getFirstArg", "()Ljava/lang/Object;", "firstArg$delegate", "secondArg", "getSecondArg", "secondArg$delegate", "getSrcJson", "()Lorg/json/JSONObject;", "coerceArgToPropertiesOrNull", "Lcom/braze/models/outgoing/BrazeProperties;", "index", "", "component1", "component2", "copy", "equals", "", "other", "getArg", "getArg$android_sdk_ui_release", "hashCode", "isArgCountInBounds", "fixedArgCount", "rangedArgCount", "Lkotlin/ranges/IntRange;", "isArgOptionalJsonObject", "isArgString", "toString", "", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StepData {
    @NotNull
    public static final String ARGS = "args";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Lazy args$delegate;
    @NotNull
    private final Channel channel;
    @NotNull
    private final Lazy firstArg$delegate;
    @NotNull
    private final Lazy secondArg$delegate;
    @NotNull
    private final JSONObject srcJson;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/braze/ui/actions/brazeactions/steps/StepData$Companion;", "", "()V", "ARGS", "", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StepData(@NotNull JSONObject jSONObject, @NotNull Channel channel2) {
        Intrinsics.checkNotNullParameter(jSONObject, "srcJson");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.srcJson = jSONObject;
        this.channel = channel2;
        this.args$delegate = LazyKt__LazyJVMKt.lazy(new StepData$args$2(this));
        this.firstArg$delegate = LazyKt__LazyJVMKt.lazy(new StepData$firstArg$2(this));
        this.secondArg$delegate = LazyKt__LazyJVMKt.lazy(new StepData$secondArg$2(this));
    }

    public static /* synthetic */ StepData copy$default(StepData stepData, JSONObject jSONObject, Channel channel2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            jSONObject = stepData.srcJson;
        }
        if ((i11 & 2) != 0) {
            channel2 = stepData.channel;
        }
        return stepData.copy(jSONObject, channel2);
    }

    /* access modifiers changed from: private */
    public final List<Object> getArgs() {
        return (List) this.args$delegate.getValue();
    }

    public static /* synthetic */ boolean isArgCountInBounds$default(StepData stepData, int i11, IntRange intRange, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = -1;
        }
        if ((i12 & 2) != 0) {
            intRange = null;
        }
        return stepData.isArgCountInBounds(i11, intRange);
    }

    @Nullable
    public final BrazeProperties coerceArgToPropertiesOrNull(int i11) {
        Object orNull = CollectionsKt___CollectionsKt.getOrNull(getArgs(), i11);
        if (orNull == null || !(orNull instanceof JSONObject)) {
            return null;
        }
        return new BrazeProperties((JSONObject) orNull);
    }

    @NotNull
    public final JSONObject component1() {
        return this.srcJson;
    }

    @NotNull
    public final Channel component2() {
        return this.channel;
    }

    @NotNull
    public final StepData copy(@NotNull JSONObject jSONObject, @NotNull Channel channel2) {
        Intrinsics.checkNotNullParameter(jSONObject, "srcJson");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        return new StepData(jSONObject, channel2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StepData)) {
            return false;
        }
        StepData stepData = (StepData) obj;
        return Intrinsics.areEqual((Object) this.srcJson, (Object) stepData.srcJson) && this.channel == stepData.channel;
    }

    @VisibleForTesting
    @Nullable
    public final Object getArg$android_sdk_ui_release(int i11) {
        return CollectionsKt___CollectionsKt.getOrNull(getArgs(), i11);
    }

    @NotNull
    public final Channel getChannel() {
        return this.channel;
    }

    @Nullable
    public final Object getFirstArg() {
        return this.firstArg$delegate.getValue();
    }

    @Nullable
    public final Object getSecondArg() {
        return this.secondArg$delegate.getValue();
    }

    @NotNull
    public final JSONObject getSrcJson() {
        return this.srcJson;
    }

    public int hashCode() {
        return (this.srcJson.hashCode() * 31) + this.channel.hashCode();
    }

    public final boolean isArgCountInBounds(int i11, @Nullable IntRange intRange) {
        if (i11 != -1 && getArgs().size() != i11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new StepData$isArgCountInBounds$1(i11, this), 7, (Object) null);
            return false;
        } else if (intRange == null || intRange.contains(getArgs().size())) {
            return true;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new StepData$isArgCountInBounds$2(intRange, this), 7, (Object) null);
            return false;
        }
    }

    public final boolean isArgOptionalJsonObject(int i11) {
        Object arg$android_sdk_ui_release = getArg$android_sdk_ui_release(i11);
        if (arg$android_sdk_ui_release == null || (arg$android_sdk_ui_release instanceof JSONObject)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new StepData$isArgOptionalJsonObject$1(i11, this), 7, (Object) null);
        return false;
    }

    public final boolean isArgString(int i11) {
        if (getArg$android_sdk_ui_release(i11) instanceof String) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new StepData$isArgString$1(i11, this), 7, (Object) null);
        return false;
    }

    @NotNull
    public String toString() {
        return "Channel " + this.channel + " and json\n" + JsonUtils.getPrettyPrintedString(this.srcJson);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StepData(JSONObject jSONObject, Channel channel2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, (i11 & 2) != 0 ? Channel.UNKNOWN : channel2);
    }
}
