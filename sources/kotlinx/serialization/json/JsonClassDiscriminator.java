package kotlinx.serialization.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Target;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InheritableSerialInfo;
import org.jetbrains.annotations.NotNull;

@InheritableSerialInfo
@Target(allowedTargets = {AnnotationTarget.CLASS})
@ExperimentalSerializationApi
@java.lang.annotation.Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/json/JsonClassDiscriminator;", "", "discriminator", "", "()Ljava/lang/String;", "Impl", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonClassDiscriminator {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004XÆ\u0005¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/json/JsonClassDiscriminator$Impl;", "Lkotlinx/serialization/json/JsonClassDiscriminator;", "()V", "discriminator", "", "()Ljava/lang/String;", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class Impl implements JsonClassDiscriminator {
        private final /* synthetic */ String _discriminator;

        private Impl() {
        }

        public Impl(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "discriminator");
            this._discriminator = str;
        }

        @JvmName(name = "discriminator")
        public final /* synthetic */ String discriminator() {
            return this._discriminator;
        }
    }

    String discriminator();
}
