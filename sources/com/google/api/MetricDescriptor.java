package com.google.api;

import com.google.api.LabelDescriptor;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class MetricDescriptor extends GeneratedMessageLite<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
    /* access modifiers changed from: private */
    public static final MetricDescriptor DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
    public static final int LABELS_FIELD_NUMBER = 2;
    public static final int LAUNCH_STAGE_FIELD_NUMBER = 12;
    public static final int METADATA_FIELD_NUMBER = 10;
    public static final int METRIC_KIND_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<MetricDescriptor> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int UNIT_FIELD_NUMBER = 5;
    public static final int VALUE_TYPE_FIELD_NUMBER = 4;
    private String description_ = "";
    private String displayName_ = "";
    private Internal.ProtobufList<LabelDescriptor> labels_ = GeneratedMessageLite.emptyProtobufList();
    private int launchStage_;
    private MetricDescriptorMetadata metadata_;
    private int metricKind_;
    private String name_ = "";
    private String type_ = "";
    private String unit_ = "";
    private int valueType_;

    /* renamed from: com.google.api.MetricDescriptor$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.MetricDescriptor.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addAllLabels(iterable);
            return this;
        }

        public Builder addLabels(LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(labelDescriptor);
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearDescription();
            return this;
        }

        public Builder clearDisplayName() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearDisplayName();
            return this;
        }

        public Builder clearLabels() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearLabels();
            return this;
        }

        public Builder clearLaunchStage() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearLaunchStage();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearMetadata();
            return this;
        }

        public Builder clearMetricKind() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearMetricKind();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearName();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearType();
            return this;
        }

        public Builder clearUnit() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearUnit();
            return this;
        }

        public Builder clearValueType() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearValueType();
            return this;
        }

        public String getDescription() {
            return ((MetricDescriptor) this.instance).getDescription();
        }

        public ByteString getDescriptionBytes() {
            return ((MetricDescriptor) this.instance).getDescriptionBytes();
        }

        public String getDisplayName() {
            return ((MetricDescriptor) this.instance).getDisplayName();
        }

        public ByteString getDisplayNameBytes() {
            return ((MetricDescriptor) this.instance).getDisplayNameBytes();
        }

        public LabelDescriptor getLabels(int i11) {
            return ((MetricDescriptor) this.instance).getLabels(i11);
        }

        public int getLabelsCount() {
            return ((MetricDescriptor) this.instance).getLabelsCount();
        }

        public List<LabelDescriptor> getLabelsList() {
            return Collections.unmodifiableList(((MetricDescriptor) this.instance).getLabelsList());
        }

        public LaunchStage getLaunchStage() {
            return ((MetricDescriptor) this.instance).getLaunchStage();
        }

        public int getLaunchStageValue() {
            return ((MetricDescriptor) this.instance).getLaunchStageValue();
        }

        public MetricDescriptorMetadata getMetadata() {
            return ((MetricDescriptor) this.instance).getMetadata();
        }

        public MetricKind getMetricKind() {
            return ((MetricDescriptor) this.instance).getMetricKind();
        }

        public int getMetricKindValue() {
            return ((MetricDescriptor) this.instance).getMetricKindValue();
        }

        public String getName() {
            return ((MetricDescriptor) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((MetricDescriptor) this.instance).getNameBytes();
        }

        public String getType() {
            return ((MetricDescriptor) this.instance).getType();
        }

        public ByteString getTypeBytes() {
            return ((MetricDescriptor) this.instance).getTypeBytes();
        }

        public String getUnit() {
            return ((MetricDescriptor) this.instance).getUnit();
        }

        public ByteString getUnitBytes() {
            return ((MetricDescriptor) this.instance).getUnitBytes();
        }

        public ValueType getValueType() {
            return ((MetricDescriptor) this.instance).getValueType();
        }

        public int getValueTypeValue() {
            return ((MetricDescriptor) this.instance).getValueTypeValue();
        }

        public boolean hasMetadata() {
            return ((MetricDescriptor) this.instance).hasMetadata();
        }

        public Builder mergeMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).mergeMetadata(metricDescriptorMetadata);
            return this;
        }

        public Builder removeLabels(int i11) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).removeLabels(i11);
            return this;
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setDisplayName(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDisplayName(str);
            return this;
        }

        public Builder setDisplayNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDisplayNameBytes(byteString);
            return this;
        }

        public Builder setLabels(int i11, LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLabels(i11, labelDescriptor);
            return this;
        }

        public Builder setLaunchStage(LaunchStage launchStage) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLaunchStage(launchStage);
            return this;
        }

        public Builder setLaunchStageValue(int i11) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLaunchStageValue(i11);
            return this;
        }

        public Builder setMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetadata(metricDescriptorMetadata);
            return this;
        }

        public Builder setMetricKind(MetricKind metricKind) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetricKind(metricKind);
            return this;
        }

        public Builder setMetricKindValue(int i11) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetricKindValue(i11);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setType(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setType(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setTypeBytes(byteString);
            return this;
        }

        public Builder setUnit(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setUnit(str);
            return this;
        }

        public Builder setUnitBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setUnitBytes(byteString);
            return this;
        }

        public Builder setValueType(ValueType valueType) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setValueType(valueType);
            return this;
        }

        public Builder setValueTypeValue(int i11) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setValueTypeValue(i11);
            return this;
        }

        private Builder() {
            super(MetricDescriptor.DEFAULT_INSTANCE);
        }

        public Builder addLabels(int i11, LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(i11, labelDescriptor);
            return this;
        }

        public Builder setLabels(int i11, LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLabels(i11, (LabelDescriptor) builder.build());
            return this;
        }

        public Builder setMetadata(MetricDescriptorMetadata.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetadata((MetricDescriptorMetadata) builder.build());
            return this;
        }

        public Builder addLabels(LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels((LabelDescriptor) builder.build());
            return this;
        }

        public Builder addLabels(int i11, LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(i11, (LabelDescriptor) builder.build());
            return this;
        }
    }

    public static final class MetricDescriptorMetadata extends GeneratedMessageLite<MetricDescriptorMetadata, Builder> implements MetricDescriptorMetadataOrBuilder {
        /* access modifiers changed from: private */
        public static final MetricDescriptorMetadata DEFAULT_INSTANCE;
        public static final int INGEST_DELAY_FIELD_NUMBER = 3;
        public static final int LAUNCH_STAGE_FIELD_NUMBER = 1;
        private static volatile Parser<MetricDescriptorMetadata> PARSER = null;
        public static final int SAMPLE_PERIOD_FIELD_NUMBER = 2;
        private Duration ingestDelay_;
        private int launchStage_;
        private Duration samplePeriod_;

        public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptorMetadata, Builder> implements MetricDescriptorMetadataOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearIngestDelay() {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).clearIngestDelay();
                return this;
            }

            @Deprecated
            public Builder clearLaunchStage() {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).clearLaunchStage();
                return this;
            }

            public Builder clearSamplePeriod() {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).clearSamplePeriod();
                return this;
            }

            public Duration getIngestDelay() {
                return ((MetricDescriptorMetadata) this.instance).getIngestDelay();
            }

            @Deprecated
            public LaunchStage getLaunchStage() {
                return ((MetricDescriptorMetadata) this.instance).getLaunchStage();
            }

            @Deprecated
            public int getLaunchStageValue() {
                return ((MetricDescriptorMetadata) this.instance).getLaunchStageValue();
            }

            public Duration getSamplePeriod() {
                return ((MetricDescriptorMetadata) this.instance).getSamplePeriod();
            }

            public boolean hasIngestDelay() {
                return ((MetricDescriptorMetadata) this.instance).hasIngestDelay();
            }

            public boolean hasSamplePeriod() {
                return ((MetricDescriptorMetadata) this.instance).hasSamplePeriod();
            }

            public Builder mergeIngestDelay(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).mergeIngestDelay(duration);
                return this;
            }

            public Builder mergeSamplePeriod(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).mergeSamplePeriod(duration);
                return this;
            }

            public Builder setIngestDelay(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setIngestDelay(duration);
                return this;
            }

            @Deprecated
            public Builder setLaunchStage(LaunchStage launchStage) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setLaunchStage(launchStage);
                return this;
            }

            @Deprecated
            public Builder setLaunchStageValue(int i11) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setLaunchStageValue(i11);
                return this;
            }

            public Builder setSamplePeriod(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setSamplePeriod(duration);
                return this;
            }

            private Builder() {
                super(MetricDescriptorMetadata.DEFAULT_INSTANCE);
            }

            public Builder setIngestDelay(Duration.Builder builder) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setIngestDelay((Duration) builder.build());
                return this;
            }

            public Builder setSamplePeriod(Duration.Builder builder) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setSamplePeriod((Duration) builder.build());
                return this;
            }
        }

        static {
            MetricDescriptorMetadata metricDescriptorMetadata = new MetricDescriptorMetadata();
            DEFAULT_INSTANCE = metricDescriptorMetadata;
            GeneratedMessageLite.registerDefaultInstance(MetricDescriptorMetadata.class, metricDescriptorMetadata);
        }

        private MetricDescriptorMetadata() {
        }

        /* access modifiers changed from: private */
        public void clearIngestDelay() {
            this.ingestDelay_ = null;
        }

        /* access modifiers changed from: private */
        public void clearLaunchStage() {
            this.launchStage_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearSamplePeriod() {
            this.samplePeriod_ = null;
        }

        public static MetricDescriptorMetadata getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeIngestDelay(Duration duration) {
            duration.getClass();
            Duration duration2 = this.ingestDelay_;
            if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
                this.ingestDelay_ = duration;
            } else {
                this.ingestDelay_ = (Duration) ((Duration.Builder) Duration.newBuilder(this.ingestDelay_).mergeFrom(duration)).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void mergeSamplePeriod(Duration duration) {
            duration.getClass();
            Duration duration2 = this.samplePeriod_;
            if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
                this.samplePeriod_ = duration;
            } else {
                this.samplePeriod_ = (Duration) ((Duration.Builder) Duration.newBuilder(this.samplePeriod_).mergeFrom(duration)).buildPartial();
            }
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<MetricDescriptorMetadata> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setIngestDelay(Duration duration) {
            duration.getClass();
            this.ingestDelay_ = duration;
        }

        /* access modifiers changed from: private */
        public void setLaunchStage(LaunchStage launchStage) {
            this.launchStage_ = launchStage.getNumber();
        }

        /* access modifiers changed from: private */
        public void setLaunchStageValue(int i11) {
            this.launchStage_ = i11;
        }

        /* access modifiers changed from: private */
        public void setSamplePeriod(Duration duration) {
            duration.getClass();
            this.samplePeriod_ = duration;
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new MetricDescriptorMetadata();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\t\u0003\t", new Object[]{"launchStage_", "samplePeriod_", "ingestDelay_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MetricDescriptorMetadata> parser = PARSER;
                    if (parser == null) {
                        synchronized (MetricDescriptorMetadata.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public Duration getIngestDelay() {
            Duration duration = this.ingestDelay_;
            return duration == null ? Duration.getDefaultInstance() : duration;
        }

        @Deprecated
        public LaunchStage getLaunchStage() {
            LaunchStage forNumber = LaunchStage.forNumber(this.launchStage_);
            if (forNumber == null) {
                return LaunchStage.UNRECOGNIZED;
            }
            return forNumber;
        }

        @Deprecated
        public int getLaunchStageValue() {
            return this.launchStage_;
        }

        public Duration getSamplePeriod() {
            Duration duration = this.samplePeriod_;
            return duration == null ? Duration.getDefaultInstance() : duration;
        }

        public boolean hasIngestDelay() {
            return this.ingestDelay_ != null;
        }

        public boolean hasSamplePeriod() {
            return this.samplePeriod_ != null;
        }

        public static Builder newBuilder(MetricDescriptorMetadata metricDescriptorMetadata) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(metricDescriptorMetadata);
        }

        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MetricDescriptorMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MetricDescriptorMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(InputStream inputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MetricDescriptorMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MetricDescriptorMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface MetricDescriptorMetadataOrBuilder extends MessageLiteOrBuilder {
        Duration getIngestDelay();

        @Deprecated
        LaunchStage getLaunchStage();

        @Deprecated
        int getLaunchStageValue();

        Duration getSamplePeriod();

        boolean hasIngestDelay();

        boolean hasSamplePeriod();
    }

    public enum MetricKind implements Internal.EnumLite {
        METRIC_KIND_UNSPECIFIED(0),
        GAUGE(1),
        DELTA(2),
        CUMULATIVE(3),
        UNRECOGNIZED(-1);
        
        public static final int CUMULATIVE_VALUE = 3;
        public static final int DELTA_VALUE = 2;
        public static final int GAUGE_VALUE = 1;
        public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<MetricKind> internalValueMap = null;
        private final int value;

        public static final class MetricKindVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            static {
                INSTANCE = new MetricKindVerifier();
            }

            private MetricKindVerifier() {
            }

            public boolean isInRange(int i11) {
                return MetricKind.forNumber(i11) != null;
            }
        }

        /* access modifiers changed from: public */
        static {
            internalValueMap = new Internal.EnumLiteMap<MetricKind>() {
                public MetricKind findValueByNumber(int i11) {
                    return MetricKind.forNumber(i11);
                }
            };
        }

        private MetricKind(int i11) {
            this.value = i11;
        }

        public static MetricKind forNumber(int i11) {
            if (i11 == 0) {
                return METRIC_KIND_UNSPECIFIED;
            }
            if (i11 == 1) {
                return GAUGE;
            }
            if (i11 == 2) {
                return DELTA;
            }
            if (i11 != 3) {
                return null;
            }
            return CUMULATIVE;
        }

        public static Internal.EnumLiteMap<MetricKind> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return MetricKindVerifier.INSTANCE;
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MetricKind valueOf(int i11) {
            return forNumber(i11);
        }
    }

    public enum ValueType implements Internal.EnumLite {
        VALUE_TYPE_UNSPECIFIED(0),
        BOOL(1),
        INT64(2),
        DOUBLE(3),
        STRING(4),
        DISTRIBUTION(5),
        MONEY(6),
        UNRECOGNIZED(-1);
        
        public static final int BOOL_VALUE = 1;
        public static final int DISTRIBUTION_VALUE = 5;
        public static final int DOUBLE_VALUE = 3;
        public static final int INT64_VALUE = 2;
        public static final int MONEY_VALUE = 6;
        public static final int STRING_VALUE = 4;
        public static final int VALUE_TYPE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<ValueType> internalValueMap = null;
        private final int value;

        public static final class ValueTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            static {
                INSTANCE = new ValueTypeVerifier();
            }

            private ValueTypeVerifier() {
            }

            public boolean isInRange(int i11) {
                return ValueType.forNumber(i11) != null;
            }
        }

        /* access modifiers changed from: public */
        static {
            internalValueMap = new Internal.EnumLiteMap<ValueType>() {
                public ValueType findValueByNumber(int i11) {
                    return ValueType.forNumber(i11);
                }
            };
        }

        private ValueType(int i11) {
            this.value = i11;
        }

        public static ValueType forNumber(int i11) {
            switch (i11) {
                case 0:
                    return VALUE_TYPE_UNSPECIFIED;
                case 1:
                    return BOOL;
                case 2:
                    return INT64;
                case 3:
                    return DOUBLE;
                case 4:
                    return STRING;
                case 5:
                    return DISTRIBUTION;
                case 6:
                    return MONEY;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return ValueTypeVerifier.INSTANCE;
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ValueType valueOf(int i11) {
            return forNumber(i11);
        }
    }

    static {
        MetricDescriptor metricDescriptor = new MetricDescriptor();
        DEFAULT_INSTANCE = metricDescriptor;
        GeneratedMessageLite.registerDefaultInstance(MetricDescriptor.class, metricDescriptor);
    }

    private MetricDescriptor() {
    }

    /* access modifiers changed from: private */
    public void addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
        ensureLabelsIsMutable();
        AbstractMessageLite.addAll(iterable, this.labels_);
    }

    /* access modifiers changed from: private */
    public void addLabels(LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        ensureLabelsIsMutable();
        this.labels_.add(labelDescriptor);
    }

    /* access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* access modifiers changed from: private */
    public void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* access modifiers changed from: private */
    public void clearLabels() {
        this.labels_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void clearLaunchStage() {
        this.launchStage_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
    }

    /* access modifiers changed from: private */
    public void clearMetricKind() {
        this.metricKind_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    /* access modifiers changed from: private */
    public void clearUnit() {
        this.unit_ = getDefaultInstance().getUnit();
    }

    /* access modifiers changed from: private */
    public void clearValueType() {
        this.valueType_ = 0;
    }

    private void ensureLabelsIsMutable() {
        Internal.ProtobufList<LabelDescriptor> protobufList = this.labels_;
        if (!protobufList.isModifiable()) {
            this.labels_ = GeneratedMessageLite.mutableCopy(protobufList);
        }
    }

    public static MetricDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void mergeMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
        metricDescriptorMetadata.getClass();
        MetricDescriptorMetadata metricDescriptorMetadata2 = this.metadata_;
        if (metricDescriptorMetadata2 == null || metricDescriptorMetadata2 == MetricDescriptorMetadata.getDefaultInstance()) {
            this.metadata_ = metricDescriptorMetadata;
        } else {
            this.metadata_ = (MetricDescriptorMetadata) ((MetricDescriptorMetadata.Builder) MetricDescriptorMetadata.newBuilder(this.metadata_).mergeFrom(metricDescriptorMetadata)).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MetricDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removeLabels(int i11) {
        ensureLabelsIsMutable();
        this.labels_.remove(i11);
    }

    /* access modifiers changed from: private */
    public void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    /* access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setDisplayName(String str) {
        str.getClass();
        this.displayName_ = str;
    }

    /* access modifiers changed from: private */
    public void setDisplayNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.displayName_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setLabels(int i11, LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        ensureLabelsIsMutable();
        this.labels_.set(i11, labelDescriptor);
    }

    /* access modifiers changed from: private */
    public void setLaunchStage(LaunchStage launchStage) {
        this.launchStage_ = launchStage.getNumber();
    }

    /* access modifiers changed from: private */
    public void setLaunchStageValue(int i11) {
        this.launchStage_ = i11;
    }

    /* access modifiers changed from: private */
    public void setMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
        metricDescriptorMetadata.getClass();
        this.metadata_ = metricDescriptorMetadata;
    }

    /* access modifiers changed from: private */
    public void setMetricKind(MetricKind metricKind) {
        this.metricKind_ = metricKind.getNumber();
    }

    /* access modifiers changed from: private */
    public void setMetricKindValue(int i11) {
        this.metricKind_ = i11;
    }

    /* access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    /* access modifiers changed from: private */
    public void setTypeBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.type_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setUnit(String str) {
        str.getClass();
        this.unit_ = str;
    }

    /* access modifiers changed from: private */
    public void setUnitBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.unit_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setValueType(ValueType valueType) {
        this.valueType_ = valueType.getNumber();
    }

    /* access modifiers changed from: private */
    public void setValueTypeValue(int i11) {
        this.valueType_ = i11;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MetricDescriptor();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\f\n\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\f\u0004\f\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\n\t\f\f", new Object[]{"name_", "labels_", LabelDescriptor.class, "metricKind_", "valueType_", "unit_", "description_", "displayName_", "type_", "metadata_", "launchStage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MetricDescriptor> parser = PARSER;
                if (parser == null) {
                    synchronized (MetricDescriptor.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getDescription() {
        return this.description_;
    }

    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    public String getDisplayName() {
        return this.displayName_;
    }

    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    public LabelDescriptor getLabels(int i11) {
        return this.labels_.get(i11);
    }

    public int getLabelsCount() {
        return this.labels_.size();
    }

    public List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    public LabelDescriptorOrBuilder getLabelsOrBuilder(int i11) {
        return this.labels_.get(i11);
    }

    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    public LaunchStage getLaunchStage() {
        LaunchStage forNumber = LaunchStage.forNumber(this.launchStage_);
        if (forNumber == null) {
            return LaunchStage.UNRECOGNIZED;
        }
        return forNumber;
    }

    public int getLaunchStageValue() {
        return this.launchStage_;
    }

    public MetricDescriptorMetadata getMetadata() {
        MetricDescriptorMetadata metricDescriptorMetadata = this.metadata_;
        return metricDescriptorMetadata == null ? MetricDescriptorMetadata.getDefaultInstance() : metricDescriptorMetadata;
    }

    public MetricKind getMetricKind() {
        MetricKind forNumber = MetricKind.forNumber(this.metricKind_);
        if (forNumber == null) {
            return MetricKind.UNRECOGNIZED;
        }
        return forNumber;
    }

    public int getMetricKindValue() {
        return this.metricKind_;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public String getUnit() {
        return this.unit_;
    }

    public ByteString getUnitBytes() {
        return ByteString.copyFromUtf8(this.unit_);
    }

    public ValueType getValueType() {
        ValueType forNumber = ValueType.forNumber(this.valueType_);
        if (forNumber == null) {
            return ValueType.UNRECOGNIZED;
        }
        return forNumber;
    }

    public int getValueTypeValue() {
        return this.valueType_;
    }

    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    public static Builder newBuilder(MetricDescriptor metricDescriptor) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(metricDescriptor);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void addLabels(int i11, LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        ensureLabelsIsMutable();
        this.labels_.add(i11, labelDescriptor);
    }

    public static MetricDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MetricDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
