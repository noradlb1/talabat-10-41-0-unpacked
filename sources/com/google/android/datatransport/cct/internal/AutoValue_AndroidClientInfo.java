package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;

final class AutoValue_AndroidClientInfo extends AndroidClientInfo {
    private final String applicationBuild;
    private final String country;
    private final String device;
    private final String fingerprint;
    private final String hardware;
    private final String locale;
    private final String manufacturer;
    private final String mccMnc;
    private final String model;
    private final String osBuild;
    private final String product;
    private final Integer sdkVersion;

    public static final class Builder extends AndroidClientInfo.Builder {
        private String applicationBuild;
        private String country;
        private String device;
        private String fingerprint;
        private String hardware;
        private String locale;
        private String manufacturer;
        private String mccMnc;
        private String model;
        private String osBuild;
        private String product;
        private Integer sdkVersion;

        public AndroidClientInfo build() {
            return new AutoValue_AndroidClientInfo(this.sdkVersion, this.model, this.hardware, this.device, this.product, this.osBuild, this.manufacturer, this.fingerprint, this.locale, this.country, this.mccMnc, this.applicationBuild);
        }

        public AndroidClientInfo.Builder setApplicationBuild(@Nullable String str) {
            this.applicationBuild = str;
            return this;
        }

        public AndroidClientInfo.Builder setCountry(@Nullable String str) {
            this.country = str;
            return this;
        }

        public AndroidClientInfo.Builder setDevice(@Nullable String str) {
            this.device = str;
            return this;
        }

        public AndroidClientInfo.Builder setFingerprint(@Nullable String str) {
            this.fingerprint = str;
            return this;
        }

        public AndroidClientInfo.Builder setHardware(@Nullable String str) {
            this.hardware = str;
            return this;
        }

        public AndroidClientInfo.Builder setLocale(@Nullable String str) {
            this.locale = str;
            return this;
        }

        public AndroidClientInfo.Builder setManufacturer(@Nullable String str) {
            this.manufacturer = str;
            return this;
        }

        public AndroidClientInfo.Builder setMccMnc(@Nullable String str) {
            this.mccMnc = str;
            return this;
        }

        public AndroidClientInfo.Builder setModel(@Nullable String str) {
            this.model = str;
            return this;
        }

        public AndroidClientInfo.Builder setOsBuild(@Nullable String str) {
            this.osBuild = str;
            return this;
        }

        public AndroidClientInfo.Builder setProduct(@Nullable String str) {
            this.product = str;
            return this;
        }

        public AndroidClientInfo.Builder setSdkVersion(@Nullable Integer num) {
            this.sdkVersion = num;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.sdkVersion;
        if (num != null ? num.equals(androidClientInfo.getSdkVersion()) : androidClientInfo.getSdkVersion() == null) {
            String str = this.model;
            if (str != null ? str.equals(androidClientInfo.getModel()) : androidClientInfo.getModel() == null) {
                String str2 = this.hardware;
                if (str2 != null ? str2.equals(androidClientInfo.getHardware()) : androidClientInfo.getHardware() == null) {
                    String str3 = this.device;
                    if (str3 != null ? str3.equals(androidClientInfo.getDevice()) : androidClientInfo.getDevice() == null) {
                        String str4 = this.product;
                        if (str4 != null ? str4.equals(androidClientInfo.getProduct()) : androidClientInfo.getProduct() == null) {
                            String str5 = this.osBuild;
                            if (str5 != null ? str5.equals(androidClientInfo.getOsBuild()) : androidClientInfo.getOsBuild() == null) {
                                String str6 = this.manufacturer;
                                if (str6 != null ? str6.equals(androidClientInfo.getManufacturer()) : androidClientInfo.getManufacturer() == null) {
                                    String str7 = this.fingerprint;
                                    if (str7 != null ? str7.equals(androidClientInfo.getFingerprint()) : androidClientInfo.getFingerprint() == null) {
                                        String str8 = this.locale;
                                        if (str8 != null ? str8.equals(androidClientInfo.getLocale()) : androidClientInfo.getLocale() == null) {
                                            String str9 = this.country;
                                            if (str9 != null ? str9.equals(androidClientInfo.getCountry()) : androidClientInfo.getCountry() == null) {
                                                String str10 = this.mccMnc;
                                                if (str10 != null ? str10.equals(androidClientInfo.getMccMnc()) : androidClientInfo.getMccMnc() == null) {
                                                    String str11 = this.applicationBuild;
                                                    if (str11 == null) {
                                                        if (androidClientInfo.getApplicationBuild() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(androidClientInfo.getApplicationBuild())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    public String getApplicationBuild() {
        return this.applicationBuild;
    }

    @Nullable
    public String getCountry() {
        return this.country;
    }

    @Nullable
    public String getDevice() {
        return this.device;
    }

    @Nullable
    public String getFingerprint() {
        return this.fingerprint;
    }

    @Nullable
    public String getHardware() {
        return this.hardware;
    }

    @Nullable
    public String getLocale() {
        return this.locale;
    }

    @Nullable
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Nullable
    public String getMccMnc() {
        return this.mccMnc;
    }

    @Nullable
    public String getModel() {
        return this.model;
    }

    @Nullable
    public String getOsBuild() {
        return this.osBuild;
    }

    @Nullable
    public String getProduct() {
        return this.product;
    }

    @Nullable
    public Integer getSdkVersion() {
        return this.sdkVersion;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        Integer num = this.sdkVersion;
        int i23 = 0;
        if (num == null) {
            i11 = 0;
        } else {
            i11 = num.hashCode();
        }
        int i24 = (i11 ^ 1000003) * 1000003;
        String str = this.model;
        if (str == null) {
            i12 = 0;
        } else {
            i12 = str.hashCode();
        }
        int i25 = (i24 ^ i12) * 1000003;
        String str2 = this.hardware;
        if (str2 == null) {
            i13 = 0;
        } else {
            i13 = str2.hashCode();
        }
        int i26 = (i25 ^ i13) * 1000003;
        String str3 = this.device;
        if (str3 == null) {
            i14 = 0;
        } else {
            i14 = str3.hashCode();
        }
        int i27 = (i26 ^ i14) * 1000003;
        String str4 = this.product;
        if (str4 == null) {
            i15 = 0;
        } else {
            i15 = str4.hashCode();
        }
        int i28 = (i27 ^ i15) * 1000003;
        String str5 = this.osBuild;
        if (str5 == null) {
            i16 = 0;
        } else {
            i16 = str5.hashCode();
        }
        int i29 = (i28 ^ i16) * 1000003;
        String str6 = this.manufacturer;
        if (str6 == null) {
            i17 = 0;
        } else {
            i17 = str6.hashCode();
        }
        int i31 = (i29 ^ i17) * 1000003;
        String str7 = this.fingerprint;
        if (str7 == null) {
            i18 = 0;
        } else {
            i18 = str7.hashCode();
        }
        int i32 = (i31 ^ i18) * 1000003;
        String str8 = this.locale;
        if (str8 == null) {
            i19 = 0;
        } else {
            i19 = str8.hashCode();
        }
        int i33 = (i32 ^ i19) * 1000003;
        String str9 = this.country;
        if (str9 == null) {
            i21 = 0;
        } else {
            i21 = str9.hashCode();
        }
        int i34 = (i33 ^ i21) * 1000003;
        String str10 = this.mccMnc;
        if (str10 == null) {
            i22 = 0;
        } else {
            i22 = str10.hashCode();
        }
        int i35 = (i34 ^ i22) * 1000003;
        String str11 = this.applicationBuild;
        if (str11 != null) {
            i23 = str11.hashCode();
        }
        return i35 ^ i23;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.sdkVersion + ", model=" + this.model + ", hardware=" + this.hardware + ", device=" + this.device + ", product=" + this.product + ", osBuild=" + this.osBuild + ", manufacturer=" + this.manufacturer + ", fingerprint=" + this.fingerprint + ", locale=" + this.locale + ", country=" + this.country + ", mccMnc=" + this.mccMnc + ", applicationBuild=" + this.applicationBuild + "}";
    }

    private AutoValue_AndroidClientInfo(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        this.sdkVersion = num;
        this.model = str;
        this.hardware = str2;
        this.device = str3;
        this.product = str4;
        this.osBuild = str5;
        this.manufacturer = str6;
        this.fingerprint = str7;
        this.locale = str8;
        this.country = str9;
        this.mccMnc = str10;
        this.applicationBuild = str11;
    }
}
