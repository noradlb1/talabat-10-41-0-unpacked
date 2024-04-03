package com.deliveryhero.persistence.cache;

import com.google.gson.annotations.SerializedName;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonNames;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 %*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002$%B/\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u0017H\u0002J;\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0001\u0010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001c0#HÇ\u0001R\u001e\u0010\u0005\u001a\u00028\u00008\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018¨\u0006&"}, d2 = {"Lcom/deliveryhero/persistence/cache/CacheData;", "T", "", "seen1", "", "data", "expiryDateInSeconds", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Object;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Object;J)V", "getData$annotations", "()V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getExpiryDateInSeconds$annotations", "getExpiryDateInSeconds", "()J", "setExpiryDateInSeconds", "(J)V", "isExpired", "", "()Z", "isExpiryDateAlreadyConvertedToTimestamp", "write$Self", "", "T0", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "$serializer", "Companion", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
public final class CacheData<T> {
    @NotNull
    private static final SerialDescriptor $cachedDescriptor;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long NEVER_EXPIRING = 0;
    public static final int ONE_YEAR_IN_SECONDS = 31536000;
    @SerializedName(alternate = {"a"}, value = "data")
    private final T data;
    @SerializedName(alternate = {"b"}, value = "expiryDateInSeconds")
    private long expiryDateInSeconds;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\t0\b\"\u0004\b\u0001\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\bHÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deliveryhero/persistence/cache/CacheData$Companion;", "", "()V", "NEVER_EXPIRING", "", "ONE_YEAR_IN_SECONDS", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/persistence/cache/CacheData;", "T0", "typeSerial0", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T0> KSerializer<CacheData<T0>> serializer(@NotNull KSerializer<T0> kSerializer) {
            Intrinsics.checkNotNullParameter(kSerializer, "typeSerial0");
            return new CacheData$$serializer(kSerializer);
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.deliveryhero.persistence.cache.CacheData", (GeneratedSerializer<?>) null, 2);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        pluginGeneratedSerialDescriptor.addElement("expiryDateInSeconds", false);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CacheData(int i11, @JsonNames(names = {"data", "a"}) Object obj, @JsonNames(names = {"expiryDateInSeconds", "b"}) long j11, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i11 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i11, 3, $cachedDescriptor);
        }
        this.data = obj;
        this.expiryDateInSeconds = j11;
        if (j11 != 0 && !isExpiryDateAlreadyConvertedToTimestamp()) {
            this.expiryDateInSeconds += TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }
    }

    @JsonNames(names = {"data", "a"})
    public static /* synthetic */ void getData$annotations() {
    }

    @JsonNames(names = {"expiryDateInSeconds", "b"})
    public static /* synthetic */ void getExpiryDateInSeconds$annotations() {
    }

    private final boolean isExpiryDateAlreadyConvertedToTimestamp() {
        return this.expiryDateInSeconds > 31536000;
    }

    @JvmStatic
    public static final <T0> void write$Self(@NotNull CacheData<T0> cacheData, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor, @NotNull KSerializer<T0> kSerializer) {
        Intrinsics.checkNotNullParameter(cacheData, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        Intrinsics.checkNotNullParameter(kSerializer, "typeSerial0");
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, kSerializer, cacheData.data);
        compositeEncoder.encodeLongElement(serialDescriptor, 1, cacheData.expiryDateInSeconds);
    }

    public final T getData() {
        return this.data;
    }

    public final long getExpiryDateInSeconds() {
        return this.expiryDateInSeconds;
    }

    public final boolean isExpired() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        long j11 = this.expiryDateInSeconds;
        if (1 > j11 || j11 >= seconds) {
            return false;
        }
        return true;
    }

    public final void setExpiryDateInSeconds(long j11) {
        this.expiryDateInSeconds = j11;
    }

    public CacheData(T t11, long j11) {
        this.data = t11;
        this.expiryDateInSeconds = j11;
        if (j11 != 0 && !isExpiryDateAlreadyConvertedToTimestamp()) {
            this.expiryDateInSeconds += TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }
    }
}
