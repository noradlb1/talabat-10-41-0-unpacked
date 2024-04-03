package com.deliveryhero.fluid.content;

import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlinx.serialization.Transient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010D\u001a\u00020E2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002060GH\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH&R$\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0018\u0010 \u001a\u00020!X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0011R$\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011R\u001c\u0010,\u001a\u00060\u000bj\u0002`-X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\u001c\u00100\u001a\u00060\u000bj\u0002`1X¦\u000e¢\u0006\f\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR\u001a\u00104\u001a\b\u0012\u0004\u0012\u000206058VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u0004\u0018\u00018\u0000X¦\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b?\u0010\u001a\"\u0004\b@\u0010\u001cR\u001a\u0010A\u001a\u0004\u0018\u00010\u0013X¦\u000e¢\u0006\f\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010\u0017¨\u0006L"}, d2 = {"Lcom/deliveryhero/fluid/content/ContentBuilder;", "TrackingModelT", "", "cells", "", "getCells", "()Ljava/util/List;", "setCells", "(Ljava/util/List;)V", "customData", "", "", "getCustomData$annotations", "()V", "getCustomData", "()Ljava/util/Map;", "setCustomData", "(Ljava/util/Map;)V", "height", "", "getHeight", "()Ljava/lang/Float;", "setHeight", "(Ljava/lang/Float;)V", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "layoutType", "getLayoutType", "setLayoutType", "maxAgeMs", "", "getMaxAgeMs", "()I", "setMaxAgeMs", "(I)V", "metadata", "getMetadata", "setMetadata", "scalarValues", "getScalarValues", "setScalarValues", "templateHash", "Lcom/deliveryhero/fluid/template/sources/TemplateHash;", "getTemplateHash", "setTemplateHash", "templateId", "Lcom/deliveryhero/fluid/template/TemplateId;", "getTemplateId", "setTemplateId", "templateRequests", "", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "getTemplateRequests", "()Ljava/util/Set;", "tracking", "getTracking", "()Ljava/lang/Object;", "setTracking", "(Ljava/lang/Object;)V", "variationHash", "getVariationHash", "setVariationHash", "width", "getWidth", "setWidth", "accumulateTemplateRequests", "", "requests", "", "build", "Lcom/deliveryhero/fluid/content/Content;", "source", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ContentBuilder<TrackingModelT> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        private static <TrackingModelT> void accumulateTemplateRequests(ContentBuilder<TrackingModelT> contentBuilder, Set<ReadableTemplateSource.Request> set) {
            set.add(new ReadableTemplateSource.Request(contentBuilder.getTemplateId(), contentBuilder.getTemplateHash()));
            for (ContentBuilder accumulateTemplateRequests : contentBuilder.getCells()) {
                accumulateTemplateRequests(accumulateTemplateRequests, set);
            }
        }

        @Transient
        public static /* synthetic */ void getCustomData$annotations() {
        }

        @NotNull
        public static <TrackingModelT> Set<ReadableTemplateSource.Request> getTemplateRequests(@NotNull ContentBuilder<TrackingModelT> contentBuilder) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            accumulateTemplateRequests(contentBuilder, linkedHashSet);
            return linkedHashSet;
        }
    }

    @NotNull
    Content build(@NotNull ReadableTemplateSource readableTemplateSource);

    @NotNull
    List<ContentBuilder<TrackingModelT>> getCells();

    @NotNull
    Map<String, Object> getCustomData();

    @Nullable
    Float getHeight();

    @NotNull
    String getId();

    @Nullable
    String getLayoutType();

    int getMaxAgeMs();

    @NotNull
    Map<String, String> getMetadata();

    @NotNull
    Map<String, String> getScalarValues();

    @NotNull
    String getTemplateHash();

    @NotNull
    String getTemplateId();

    @NotNull
    Set<ReadableTemplateSource.Request> getTemplateRequests();

    @Nullable
    TrackingModelT getTracking();

    @Nullable
    String getVariationHash();

    @Nullable
    Float getWidth();

    void setCells(@NotNull List<? extends ContentBuilder<TrackingModelT>> list);

    void setCustomData(@NotNull Map<String, ? extends Object> map);

    void setHeight(@Nullable Float f11);

    void setId(@NotNull String str);

    void setLayoutType(@Nullable String str);

    void setMaxAgeMs(int i11);

    void setMetadata(@NotNull Map<String, String> map);

    void setScalarValues(@NotNull Map<String, String> map);

    void setTemplateHash(@NotNull String str);

    void setTemplateId(@NotNull String str);

    void setTracking(@Nullable TrackingModelT trackingmodelt);

    void setVariationHash(@Nullable String str);

    void setWidth(@Nullable Float f11);
}
