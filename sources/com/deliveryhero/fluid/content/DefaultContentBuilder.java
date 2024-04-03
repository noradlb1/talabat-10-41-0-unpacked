package com.deliveryhero.fluid.content;

import com.braze.models.FeatureFlag;
import com.deliveryhero.fluid.content.ContentBuilder;
import com.deliveryhero.fluid.content.serializers.ScalarValuesSerializer;
import com.deliveryhero.fluid.content.utils.LegacySizeTransformer;
import com.deliveryhero.fluid.telemetry.profile.ProfilerTags;
import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSourceKt;
import com.facebook.AccessToken;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import com.visa.checkout.PurchaseInfo;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonNames;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b8\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 v*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002uvB×\u0001\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0001\u0010\t\u001a\u00020\u0004\u0012\u0010\b\u0001\u0010\n\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b\u0012\u0010\b\u0001\u0010\f\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\r\u0012\u0016\b\u0001\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f\u0012\u0016\b\u0001\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f\u0012\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019BÃ\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u000b\u0012\n\u0010\f\u001a\u00060\u0006j\u0002`\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u000f\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001cJ\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\u0015\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0012HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010IJ\t\u0010^\u001a\u00020\u0004HÆ\u0003J\r\u0010_\u001a\u00060\u0006j\u0002`\u000bHÆ\u0003J\r\u0010`\u001a\u00060\u0006j\u0002`\rHÆ\u0003J\u0015\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000fHÆ\u0003J\u0015\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000fHÆ\u0003J\u0015\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u000fHÆ\u0003JØ\u0001\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\t\u001a\u00020\u00042\f\b\u0002\u0010\n\u001a\u00060\u0006j\u0002`\u000b2\f\b\u0002\u0010\f\u001a\u00060\u0006j\u0002`\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u000f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010eJ\u0013\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010i\u001a\u00020\u0004HÖ\u0001J\t\u0010j\u001a\u00020\u0006HÖ\u0001J;\u0010k\u001a\u00020l\"\u0004\b\u0001\u0010m2\f\u0010n\u001a\b\u0012\u0004\u0012\u0002Hm0\u00002\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hm0tHÇ\u0001R0\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00128\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R0\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u000f8\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u000e¢\u0006\u0016\n\u0002\u0010-\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010\u0005\u001a\u00020\u00068\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010\u001e\u001a\u0004\b/\u00100\"\u0004\b1\u00102R&\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u001e\u001a\u0004\b4\u00100\"\u0004\b5\u00102R$\u0010\t\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u001e\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R0\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f8\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010\u001e\u001a\u0004\b<\u0010%\"\u0004\b=\u0010'R0\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f8\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b>\u0010\u001e\u001a\u0004\b?\u0010%\"\u0004\b@\u0010'R(\u0010\f\u001a\u00060\u0006j\u0002`\r8\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u0010\u001e\u001a\u0004\bB\u00100\"\u0004\bC\u00102R(\u0010\n\u001a\u00060\u0006j\u0002`\u000b8\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bD\u0010\u001e\u001a\u0004\bE\u00100\"\u0004\bF\u00102R(\u0010\b\u001a\u0004\u0018\u00018\u00008\u0016@\u0016X\u000e¢\u0006\u0016\n\u0002\u0010L\u0012\u0004\bG\u0010\u001e\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR&\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bM\u0010\u001e\u001a\u0004\bN\u00100\"\u0004\bO\u00102R(\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u000e¢\u0006\u0016\n\u0002\u0010-\u0012\u0004\bP\u0010\u001e\u001a\u0004\bQ\u0010*\"\u0004\bR\u0010,¨\u0006w"}, d2 = {"Lcom/deliveryhero/fluid/content/DefaultContentBuilder;", "TrackingModelT", "Lcom/deliveryhero/fluid/content/ContentBuilder;", "seen1", "", "id", "", "variationHash", "tracking", "maxAgeMs", "templateId", "Lcom/deliveryhero/fluid/template/TemplateId;", "templateHash", "Lcom/deliveryhero/fluid/template/sources/TemplateHash;", "scalarValues", "", "metadata", "cells", "", "width", "", "height", "layoutType", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "customData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getCells$annotations", "()V", "getCells", "()Ljava/util/List;", "setCells", "(Ljava/util/List;)V", "getCustomData$annotations", "getCustomData", "()Ljava/util/Map;", "setCustomData", "(Ljava/util/Map;)V", "getHeight$annotations", "getHeight", "()Ljava/lang/Float;", "setHeight", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getId$annotations", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getLayoutType$annotations", "getLayoutType", "setLayoutType", "getMaxAgeMs$annotations", "getMaxAgeMs", "()I", "setMaxAgeMs", "(I)V", "getMetadata$annotations", "getMetadata", "setMetadata", "getScalarValues$annotations", "getScalarValues", "setScalarValues", "getTemplateHash$annotations", "getTemplateHash", "setTemplateHash", "getTemplateId$annotations", "getTemplateId", "setTemplateId", "getTracking$annotations", "getTracking", "()Ljava/lang/Object;", "setTracking", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getVariationHash$annotations", "getVariationHash", "setVariationHash", "getWidth$annotations", "getWidth", "setWidth", "build", "Lcom/deliveryhero/fluid/content/Content;", "source", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)Lcom/deliveryhero/fluid/content/DefaultContentBuilder;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "T0", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@SerialName("static")
public final class DefaultContentBuilder<TrackingModelT> implements ContentBuilder<TrackingModelT> {
    @NotNull
    private static final SerialDescriptor $cachedDescriptor;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private List<? extends ContentBuilder<TrackingModelT>> cells;
    @NotNull
    private Map<String, ? extends Object> customData;
    @Nullable
    private Float height;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private String f30192id;
    @Nullable
    private String layoutType;
    private int maxAgeMs;
    @NotNull
    private Map<String, String> metadata;
    @NotNull
    private Map<String, String> scalarValues;
    @NotNull
    private String templateHash;
    @NotNull
    private String templateId;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private TrackingModelT f30193tracking;
    @Nullable
    private String variationHash;
    @Nullable
    private Float width;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u0004\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0004HÆ\u0001¨\u0006\b"}, d2 = {"Lcom/deliveryhero/fluid/content/DefaultContentBuilder$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/content/DefaultContentBuilder;", "T0", "typeSerial0", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T0> KSerializer<DefaultContentBuilder<T0>> serializer(@NotNull KSerializer<T0> kSerializer) {
            Intrinsics.checkNotNullParameter(kSerializer, "typeSerial0");
            return new DefaultContentBuilder$$serializer(kSerializer);
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("static", (GeneratedSerializer<?>) null, 12);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("variation_hash", true);
        pluginGeneratedSerialDescriptor.addElement("tracking", true);
        pluginGeneratedSerialDescriptor.addElement(AccessToken.EXPIRES_IN_KEY, true);
        pluginGeneratedSerialDescriptor.addElement("template_id", false);
        pluginGeneratedSerialDescriptor.addElement("template_hash", false);
        pluginGeneratedSerialDescriptor.addElement(FeatureFlag.PROPERTIES, true);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.TAG_METADATA, true);
        pluginGeneratedSerialDescriptor.addElement(ComponentMapper.CELLS, true);
        pluginGeneratedSerialDescriptor.addElement("width", true);
        pluginGeneratedSerialDescriptor.addElement("height", true);
        pluginGeneratedSerialDescriptor.addElement("layout_type", true);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DefaultContentBuilder(int i11, @SerialName("id") String str, @SerialName("variation_hash") @JsonNames(names = {"homescreen_variation_id"}) String str2, @SerialName("tracking") Object obj, @SerialName("expires_in") @JsonNames(names = {"expiry"}) int i12, @SerialName("template_id") String str3, @SerialName("template_hash") String str4, @Serializable(with = ScalarValuesSerializer.class) @SerialName("properties") Map map, @SerialName("metadata") Map map2, @SerialName("cells") @JsonNames(names = {"components", "items"}) List list, @SerialName("width") Float f11, @SerialName("height") Float f12, @SerialName("layout_type") String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if (49 != (i11 & 49)) {
            PluginExceptionsKt.throwMissingFieldException(i11, 49, $cachedDescriptor);
        }
        this.f30192id = str;
        if ((i11 & 2) == 0) {
            this.variationHash = null;
        } else {
            this.variationHash = str2;
        }
        if ((i11 & 4) == 0) {
            this.f30193tracking = null;
        } else {
            this.f30193tracking = obj;
        }
        if ((i11 & 8) == 0) {
            this.maxAgeMs = 0;
        } else {
            this.maxAgeMs = i12;
        }
        this.templateId = str3;
        this.templateHash = str4;
        if ((i11 & 64) == 0) {
            this.scalarValues = MapsKt__MapsKt.emptyMap();
        } else {
            this.scalarValues = map;
        }
        if ((i11 & 128) == 0) {
            this.metadata = MapsKt__MapsKt.emptyMap();
        } else {
            this.metadata = map2;
        }
        this.customData = MapsKt__MapsKt.emptyMap();
        if ((i11 & 256) == 0) {
            this.cells = CollectionsKt__CollectionsKt.emptyList();
        } else {
            this.cells = list;
        }
        if ((i11 & 512) == 0) {
            this.width = null;
        } else {
            this.width = f11;
        }
        if ((i11 & 1024) == 0) {
            this.height = null;
        } else {
            this.height = f12;
        }
        if ((i11 & 2048) == 0) {
            this.layoutType = null;
        } else {
            this.layoutType = str5;
        }
    }

    public static /* synthetic */ DefaultContentBuilder copy$default(DefaultContentBuilder defaultContentBuilder, String str, String str2, Object obj, int i11, String str3, String str4, Map map, Map map2, Map map3, List list, Float f11, Float f12, String str5, int i12, Object obj2) {
        int i13 = i12;
        return defaultContentBuilder.copy((i13 & 1) != 0 ? defaultContentBuilder.getId() : str, (i13 & 2) != 0 ? defaultContentBuilder.getVariationHash() : str2, (i13 & 4) != 0 ? defaultContentBuilder.getTracking() : obj, (i13 & 8) != 0 ? defaultContentBuilder.getMaxAgeMs() : i11, (i13 & 16) != 0 ? defaultContentBuilder.getTemplateId() : str3, (i13 & 32) != 0 ? defaultContentBuilder.getTemplateHash() : str4, (i13 & 64) != 0 ? defaultContentBuilder.getScalarValues() : map, (i13 & 128) != 0 ? defaultContentBuilder.getMetadata() : map2, (i13 & 256) != 0 ? defaultContentBuilder.getCustomData() : map3, (i13 & 512) != 0 ? defaultContentBuilder.getCells() : list, (i13 & 1024) != 0 ? defaultContentBuilder.getWidth() : f11, (i13 & 2048) != 0 ? defaultContentBuilder.getHeight() : f12, (i13 & 4096) != 0 ? defaultContentBuilder.getLayoutType() : str5);
    }

    @SerialName("cells")
    @JsonNames(names = {"components", "items"})
    public static /* synthetic */ void getCells$annotations() {
    }

    @Transient
    public static /* synthetic */ void getCustomData$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("layout_type")
    public static /* synthetic */ void getLayoutType$annotations() {
    }

    @SerialName("expires_in")
    @JsonNames(names = {"expiry"})
    public static /* synthetic */ void getMaxAgeMs$annotations() {
    }

    @SerialName("metadata")
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @Serializable(with = ScalarValuesSerializer.class)
    @SerialName("properties")
    public static /* synthetic */ void getScalarValues$annotations() {
    }

    @SerialName("template_hash")
    public static /* synthetic */ void getTemplateHash$annotations() {
    }

    @SerialName("template_id")
    public static /* synthetic */ void getTemplateId$annotations() {
    }

    @SerialName("tracking")
    public static /* synthetic */ void getTracking$annotations() {
    }

    @SerialName("variation_hash")
    @JsonNames(names = {"homescreen_variation_id"})
    public static /* synthetic */ void getVariationHash$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    @JvmStatic
    public static final <T0> void write$Self(@NotNull DefaultContentBuilder<T0> defaultContentBuilder, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor, @NotNull KSerializer<T0> kSerializer) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(defaultContentBuilder, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        Intrinsics.checkNotNullParameter(kSerializer, "typeSerial0");
        boolean z19 = false;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, defaultContentBuilder.getId());
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) && defaultContentBuilder.getVariationHash() == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, defaultContentBuilder.getVariationHash());
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) && defaultContentBuilder.getTracking() == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, kSerializer, defaultContentBuilder.getTracking());
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) && defaultContentBuilder.getMaxAgeMs() == 0) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            compositeEncoder.encodeIntElement(serialDescriptor, 3, defaultContentBuilder.getMaxAgeMs());
        }
        compositeEncoder.encodeStringElement(serialDescriptor, 4, defaultContentBuilder.getTemplateId());
        compositeEncoder.encodeStringElement(serialDescriptor, 5, defaultContentBuilder.getTemplateHash());
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) && Intrinsics.areEqual((Object) defaultContentBuilder.getScalarValues(), (Object) MapsKt__MapsKt.emptyMap())) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 6, new ScalarValuesSerializer(), defaultContentBuilder.getScalarValues());
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) && Intrinsics.areEqual((Object) defaultContentBuilder.getMetadata(), (Object) MapsKt__MapsKt.emptyMap())) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (z15) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            compositeEncoder.encodeSerializableElement(serialDescriptor, 7, new LinkedHashMapSerializer(stringSerializer, stringSerializer), defaultContentBuilder.getMetadata());
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) && Intrinsics.areEqual((Object) defaultContentBuilder.getCells(), (Object) CollectionsKt__CollectionsKt.emptyList())) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 8, new ArrayListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(ContentBuilder.class), new Annotation[0])), defaultContentBuilder.getCells());
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) && defaultContentBuilder.getWidth() == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, FloatSerializer.INSTANCE, defaultContentBuilder.getWidth());
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 10) && defaultContentBuilder.getHeight() == null) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 10, FloatSerializer.INSTANCE, defaultContentBuilder.getHeight());
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 11) || defaultContentBuilder.getLayoutType() != null) {
            z19 = true;
        }
        if (z19) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, defaultContentBuilder.getLayoutType());
        }
    }

    @NotNull
    public Content build(@NotNull ReadableTemplateSource readableTemplateSource) {
        Intrinsics.checkNotNullParameter(readableTemplateSource, "source");
        LegacySizeTransformer.INSTANCE.transform(this);
        Map<String, TemplateBuilder> safely = ReadableTemplateSourceKt.getSafely(readableTemplateSource, getTemplateRequests());
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(safely.size()));
        for (Map.Entry entry : safely.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((TemplateBuilder) entry.getValue()).build(readableTemplateSource.getParseConfig()));
        }
        return (Content) readableTemplateSource.getParseConfig().getProfiler().trace(ProfilerTags.BUILD_CONTENT, new DefaultContentBuilder$build$1(this, readableTemplateSource, linkedHashMap));
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @NotNull
    public final List<ContentBuilder<TrackingModelT>> component10() {
        return getCells();
    }

    @Nullable
    public final Float component11() {
        return getWidth();
    }

    @Nullable
    public final Float component12() {
        return getHeight();
    }

    @Nullable
    public final String component13() {
        return getLayoutType();
    }

    @Nullable
    public final String component2() {
        return getVariationHash();
    }

    @Nullable
    public final TrackingModelT component3() {
        return getTracking();
    }

    public final int component4() {
        return getMaxAgeMs();
    }

    @NotNull
    public final String component5() {
        return getTemplateId();
    }

    @NotNull
    public final String component6() {
        return getTemplateHash();
    }

    @NotNull
    public final Map<String, String> component7() {
        return getScalarValues();
    }

    @NotNull
    public final Map<String, String> component8() {
        return getMetadata();
    }

    @NotNull
    public final Map<String, Object> component9() {
        return getCustomData();
    }

    @NotNull
    public final DefaultContentBuilder<TrackingModelT> copy(@NotNull String str, @Nullable String str2, @Nullable TrackingModelT trackingmodelt, int i11, @NotNull String str3, @NotNull String str4, @NotNull Map<String, String> map, @NotNull Map<String, String> map2, @NotNull Map<String, ? extends Object> map3, @NotNull List<? extends ContentBuilder<TrackingModelT>> list, @Nullable Float f11, @Nullable Float f12, @Nullable String str5) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "id");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "templateId");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "templateHash");
        Map<String, String> map4 = map;
        Intrinsics.checkNotNullParameter(map4, "scalarValues");
        Map<String, String> map5 = map2;
        Intrinsics.checkNotNullParameter(map5, TtmlNode.TAG_METADATA);
        Map<String, ? extends Object> map6 = map3;
        Intrinsics.checkNotNullParameter(map6, PurchaseInfo.CUSTOM_DATA);
        List<? extends ContentBuilder<TrackingModelT>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, ComponentMapper.CELLS);
        return new DefaultContentBuilder(str6, str2, trackingmodelt, i11, str7, str8, map4, map5, map6, list2, f11, f12, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultContentBuilder)) {
            return false;
        }
        DefaultContentBuilder defaultContentBuilder = (DefaultContentBuilder) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) defaultContentBuilder.getId()) && Intrinsics.areEqual((Object) getVariationHash(), (Object) defaultContentBuilder.getVariationHash()) && Intrinsics.areEqual(getTracking(), defaultContentBuilder.getTracking()) && getMaxAgeMs() == defaultContentBuilder.getMaxAgeMs() && Intrinsics.areEqual((Object) getTemplateId(), (Object) defaultContentBuilder.getTemplateId()) && Intrinsics.areEqual((Object) getTemplateHash(), (Object) defaultContentBuilder.getTemplateHash()) && Intrinsics.areEqual((Object) getScalarValues(), (Object) defaultContentBuilder.getScalarValues()) && Intrinsics.areEqual((Object) getMetadata(), (Object) defaultContentBuilder.getMetadata()) && Intrinsics.areEqual((Object) getCustomData(), (Object) defaultContentBuilder.getCustomData()) && Intrinsics.areEqual((Object) getCells(), (Object) defaultContentBuilder.getCells()) && Intrinsics.areEqual((Object) getWidth(), (Object) defaultContentBuilder.getWidth()) && Intrinsics.areEqual((Object) getHeight(), (Object) defaultContentBuilder.getHeight()) && Intrinsics.areEqual((Object) getLayoutType(), (Object) defaultContentBuilder.getLayoutType());
    }

    @NotNull
    public List<ContentBuilder<TrackingModelT>> getCells() {
        return this.cells;
    }

    @NotNull
    public Map<String, Object> getCustomData() {
        return this.customData;
    }

    @Nullable
    public Float getHeight() {
        return this.height;
    }

    @NotNull
    public String getId() {
        return this.f30192id;
    }

    @Nullable
    public String getLayoutType() {
        return this.layoutType;
    }

    public int getMaxAgeMs() {
        return this.maxAgeMs;
    }

    @NotNull
    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    @NotNull
    public Map<String, String> getScalarValues() {
        return this.scalarValues;
    }

    @NotNull
    public String getTemplateHash() {
        return this.templateHash;
    }

    @NotNull
    public String getTemplateId() {
        return this.templateId;
    }

    @NotNull
    public Set<ReadableTemplateSource.Request> getTemplateRequests() {
        return ContentBuilder.DefaultImpls.getTemplateRequests(this);
    }

    @Nullable
    public TrackingModelT getTracking() {
        return this.f30193tracking;
    }

    @Nullable
    public String getVariationHash() {
        return this.variationHash;
    }

    @Nullable
    public Float getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((((((((((((((getId().hashCode() * 31) + (getVariationHash() == null ? 0 : getVariationHash().hashCode())) * 31) + (getTracking() == null ? 0 : getTracking().hashCode())) * 31) + getMaxAgeMs()) * 31) + getTemplateId().hashCode()) * 31) + getTemplateHash().hashCode()) * 31) + getScalarValues().hashCode()) * 31) + getMetadata().hashCode()) * 31) + getCustomData().hashCode()) * 31) + getCells().hashCode()) * 31) + (getWidth() == null ? 0 : getWidth().hashCode())) * 31) + (getHeight() == null ? 0 : getHeight().hashCode())) * 31;
        if (getLayoutType() != null) {
            i11 = getLayoutType().hashCode();
        }
        return hashCode + i11;
    }

    public void setCells(@NotNull List<? extends ContentBuilder<TrackingModelT>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cells = list;
    }

    public void setCustomData(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.customData = map;
    }

    public void setHeight(@Nullable Float f11) {
        this.height = f11;
    }

    public void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30192id = str;
    }

    public void setLayoutType(@Nullable String str) {
        this.layoutType = str;
    }

    public void setMaxAgeMs(int i11) {
        this.maxAgeMs = i11;
    }

    public void setMetadata(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.metadata = map;
    }

    public void setScalarValues(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.scalarValues = map;
    }

    public void setTemplateHash(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.templateHash = str;
    }

    public void setTemplateId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.templateId = str;
    }

    public void setTracking(@Nullable TrackingModelT trackingmodelt) {
        this.f30193tracking = trackingmodelt;
    }

    public void setVariationHash(@Nullable String str) {
        this.variationHash = str;
    }

    public void setWidth(@Nullable Float f11) {
        this.width = f11;
    }

    @NotNull
    public String toString() {
        return "DefaultContentBuilder(id=" + getId() + ", variationHash=" + getVariationHash() + ", tracking=" + getTracking() + ", maxAgeMs=" + getMaxAgeMs() + ", templateId=" + getTemplateId() + ", templateHash=" + getTemplateHash() + ", scalarValues=" + getScalarValues() + ", metadata=" + getMetadata() + ", customData=" + getCustomData() + ", cells=" + getCells() + ", width=" + getWidth() + ", height=" + getHeight() + ", layoutType=" + getLayoutType() + ')';
    }

    public DefaultContentBuilder(@NotNull String str, @Nullable String str2, @Nullable TrackingModelT trackingmodelt, int i11, @NotNull String str3, @NotNull String str4, @NotNull Map<String, String> map, @NotNull Map<String, String> map2, @NotNull Map<String, ? extends Object> map3, @NotNull List<? extends ContentBuilder<TrackingModelT>> list, @Nullable Float f11, @Nullable Float f12, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str3, "templateId");
        Intrinsics.checkNotNullParameter(str4, "templateHash");
        Intrinsics.checkNotNullParameter(map, "scalarValues");
        Intrinsics.checkNotNullParameter(map2, TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullParameter(map3, PurchaseInfo.CUSTOM_DATA);
        Intrinsics.checkNotNullParameter(list, ComponentMapper.CELLS);
        this.f30192id = str;
        this.variationHash = str2;
        this.f30193tracking = trackingmodelt;
        this.maxAgeMs = i11;
        this.templateId = str3;
        this.templateHash = str4;
        this.scalarValues = map;
        this.metadata = map2;
        this.customData = map3;
        this.cells = list;
        this.width = f11;
        this.height = f12;
        this.layoutType = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DefaultContentBuilder(java.lang.String r18, java.lang.String r19, java.lang.Object r20, int r21, java.lang.String r22, java.lang.String r23, java.util.Map r24, java.util.Map r25, java.util.Map r26, java.util.List r27, java.lang.Float r28, java.lang.Float r29, java.lang.String r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r19
        L_0x000b:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0011
            r6 = r2
            goto L_0x0013
        L_0x0011:
            r6 = r20
        L_0x0013:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001a
            r1 = 0
            r7 = r1
            goto L_0x001c
        L_0x001a:
            r7 = r21
        L_0x001c:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0026
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            r10 = r1
            goto L_0x0028
        L_0x0026:
            r10 = r24
        L_0x0028:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0032
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            r11 = r1
            goto L_0x0034
        L_0x0032:
            r11 = r25
        L_0x0034:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003e
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            r12 = r1
            goto L_0x0040
        L_0x003e:
            r12 = r26
        L_0x0040:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x004a
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r13 = r1
            goto L_0x004c
        L_0x004a:
            r13 = r27
        L_0x004c:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0052
            r14 = r2
            goto L_0x0054
        L_0x0052:
            r14 = r28
        L_0x0054:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x005a
            r15 = r2
            goto L_0x005c
        L_0x005a:
            r15 = r29
        L_0x005c:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0063
            r16 = r2
            goto L_0x0065
        L_0x0063:
            r16 = r30
        L_0x0065:
            r3 = r17
            r4 = r18
            r8 = r22
            r9 = r23
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.content.DefaultContentBuilder.<init>(java.lang.String, java.lang.String, java.lang.Object, int, java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.util.Map, java.util.List, java.lang.Float, java.lang.Float, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
