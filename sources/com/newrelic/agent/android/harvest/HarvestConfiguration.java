package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class HarvestConfiguration {
    private static final String DEFAULT_ACCOUNT_ID = "";
    private static final int DEFAULT_ACTIVITY_TRACE_LENGTH = 65534;
    private static final int DEFAULT_ACTIVITY_TRACE_MAX_REPORT_ATTEMPTS = 1;
    private static final float DEFAULT_ACTIVITY_TRACE_MIN_UTILIZATION = 0.3f;
    private static final String DEFAULT_APP_ID = "";
    private static final int DEFAULT_ERROR_LIMIT = 50;
    private static final int DEFAULT_MAX_TRANSACTION_AGE = 600;
    private static final int DEFAULT_MAX_TRANSACTION_COUNT = 1000;
    private static final String DEFAULT_PRIORITY_ENCODING_KEY = "d67afc830dab717fd163bfcb0b8b88423e9a1a3b";
    private static final int DEFAULT_REPORT_PERIOD = 60;
    private static final int DEFAULT_RESPONSE_BODY_LIMIT = 2048;
    private static final int DEFAULT_STACK_TRACE_LIMIT = 100;
    private static final String DEFAULT_TRUSTED_ACCOUNT_KEY = "";
    private static HarvestConfiguration defaultHarvestConfiguration;
    @SerializedName("account_id")
    private String account_id;
    @SerializedName("activity_trace_max_report_attempts")
    private int activity_trace_max_report_attempts;
    @SerializedName("activity_trace_max_size")
    private int activity_trace_max_size;
    @SerializedName("activity_trace_min_utilization")
    private double activity_trace_min_utilization;
    @SerializedName("application_id")
    private String application_id;
    @SerializedName("at_capture")
    private ActivityTraceConfiguration at_capture;
    @SerializedName("collect_network_errors")
    private boolean collect_network_errors;
    @SerializedName("cross_process_id")
    private String cross_process_id;
    @SerializedName("data_report_period")
    private int data_report_period;
    @SerializedName("data_token")
    private int[] data_token;
    @SerializedName("error_limit")
    private int error_limit;
    @SerializedName("priority_encoding_key")
    private String priority_encoding_key;
    @SerializedName("report_max_transaction_age")
    private int report_max_transaction_age;
    @SerializedName("report_max_transaction_count")
    private int report_max_transaction_count;
    @SerializedName("response_body_limit")
    private int response_body_limit;
    @SerializedName("server_timestamp")
    private long server_timestamp;
    @SerializedName("stack_trace_limit")
    private int stack_trace_limit;
    @SerializedName("trusted_account_key")
    private String trusted_account_key;

    public HarvestConfiguration() {
        setDefaultValues();
    }

    public static HarvestConfiguration getDefaultHarvestConfiguration() {
        HarvestConfiguration harvestConfiguration = defaultHarvestConfiguration;
        if (harvestConfiguration != null) {
            return harvestConfiguration;
        }
        HarvestConfiguration harvestConfiguration2 = new HarvestConfiguration();
        defaultHarvestConfiguration = harvestConfiguration2;
        return harvestConfiguration2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HarvestConfiguration harvestConfiguration = (HarvestConfiguration) obj;
        if (this.collect_network_errors != harvestConfiguration.collect_network_errors || this.data_report_period != harvestConfiguration.data_report_period || this.error_limit != harvestConfiguration.error_limit || this.report_max_transaction_age != harvestConfiguration.report_max_transaction_age || this.report_max_transaction_count != harvestConfiguration.report_max_transaction_count || this.response_body_limit != harvestConfiguration.response_body_limit || this.stack_trace_limit != harvestConfiguration.stack_trace_limit || this.activity_trace_max_size != harvestConfiguration.activity_trace_max_size || this.activity_trace_max_report_attempts != harvestConfiguration.activity_trace_max_report_attempts) {
            return false;
        }
        String str = this.cross_process_id;
        if (str == null && harvestConfiguration.cross_process_id != null) {
            return false;
        }
        if (str != null && harvestConfiguration.cross_process_id == null) {
            return false;
        }
        if ((str != null && !str.equals(harvestConfiguration.cross_process_id)) || !this.priority_encoding_key.equals(harvestConfiguration.priority_encoding_key)) {
            return false;
        }
        String str2 = this.account_id;
        if (str2 == null && harvestConfiguration.account_id != null) {
            return false;
        }
        if (str2 != null && harvestConfiguration.account_id == null) {
            return false;
        }
        if (str2 != null && !str2.equals(harvestConfiguration.account_id)) {
            return false;
        }
        String str3 = this.application_id;
        if (str3 == null && harvestConfiguration.application_id != null) {
            return false;
        }
        if (str3 != null && harvestConfiguration.application_id == null) {
            return false;
        }
        if (str3 != null && !str3.equals(harvestConfiguration.application_id)) {
            return false;
        }
        String str4 = this.trusted_account_key;
        if ((str4 == null || str4.equals(harvestConfiguration.trusted_account_key)) && ((int) this.activity_trace_min_utilization) * 100 == ((int) harvestConfiguration.activity_trace_min_utilization) * 100) {
            return Arrays.equals(this.data_token, harvestConfiguration.data_token);
        }
        return false;
    }

    public String getAccount_id() {
        String str = this.account_id;
        return str == null ? "" : str;
    }

    public int getActivity_trace_max_report_attempts() {
        return this.activity_trace_max_report_attempts;
    }

    public int getActivity_trace_max_size() {
        return this.activity_trace_max_size;
    }

    public double getActivity_trace_min_utilization() {
        return this.activity_trace_min_utilization;
    }

    public String getApplication_id() {
        String str = this.application_id;
        return str == null ? "" : str;
    }

    public ActivityTraceConfiguration getAt_capture() {
        return this.at_capture;
    }

    public String getCross_process_id() {
        return this.cross_process_id;
    }

    public DataToken getDataToken() {
        if (this.data_token == null) {
            return new DataToken(0, 0);
        }
        int[] iArr = this.data_token;
        return new DataToken(iArr[0], iArr[1]);
    }

    public int getData_report_period() {
        return this.data_report_period;
    }

    public int[] getData_token() {
        return this.data_token;
    }

    public int getError_limit() {
        return this.error_limit;
    }

    public String getPriority_encoding_key() {
        return this.priority_encoding_key;
    }

    public long getReportMaxTransactionAgeMilliseconds() {
        return TimeUnit.MILLISECONDS.convert((long) this.report_max_transaction_age, TimeUnit.SECONDS);
    }

    public int getReport_max_transaction_age() {
        return this.report_max_transaction_age;
    }

    public int getReport_max_transaction_count() {
        return this.report_max_transaction_count;
    }

    public int getResponse_body_limit() {
        return this.response_body_limit;
    }

    public long getServer_timestamp() {
        return this.server_timestamp;
    }

    public int getStack_trace_limit() {
        return this.stack_trace_limit;
    }

    public String getTrusted_account_key() {
        String str = this.trusted_account_key;
        return str == null ? "" : str;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = (this.collect_network_errors ? 1 : 0) * true;
        String str = this.cross_process_id;
        int i18 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i19 = (((i17 + i11) * 31) + this.data_report_period) * 31;
        int[] iArr = this.data_token;
        if (iArr != null) {
            i12 = Arrays.hashCode(iArr);
        } else {
            i12 = 0;
        }
        long doubleToLongBits = Double.doubleToLongBits(this.activity_trace_min_utilization);
        int i21 = (((((((((((((((((i19 + i12) * 31) + this.error_limit) * 31) + this.report_max_transaction_age) * 31) + this.report_max_transaction_count) * 31) + this.response_body_limit) * 31) + this.stack_trace_limit) * 31) + this.activity_trace_max_size) * 31) + this.activity_trace_max_report_attempts) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        ActivityTraceConfiguration activityTraceConfiguration = this.at_capture;
        if (activityTraceConfiguration != null) {
            i13 = activityTraceConfiguration.hashCode();
        } else {
            i13 = 0;
        }
        int i22 = (i21 + i13) * 31;
        String str2 = this.account_id;
        if (str2 != null) {
            i14 = str2.hashCode();
        } else {
            i14 = 0;
        }
        int i23 = (i22 + i14) * 31;
        String str3 = this.application_id;
        if (str3 != null) {
            i15 = str3.hashCode();
        } else {
            i15 = 0;
        }
        int i24 = (i23 + i15) * 31;
        String str4 = this.priority_encoding_key;
        if (str4 != null) {
            i16 = str4.hashCode();
        } else {
            i16 = 0;
        }
        int i25 = (i24 + i16) * 31;
        String str5 = this.trusted_account_key;
        if (str5 != null) {
            i18 = str5.hashCode();
        }
        return i25 + i18;
    }

    public boolean isCollect_network_errors() {
        return this.collect_network_errors;
    }

    public void reconfigure(HarvestConfiguration harvestConfiguration) {
        setCollect_network_errors(harvestConfiguration.isCollect_network_errors());
        if (harvestConfiguration.getCross_process_id() != null) {
            setCross_process_id(harvestConfiguration.getCross_process_id());
        }
        setData_report_period(harvestConfiguration.getData_report_period());
        DataToken dataToken = harvestConfiguration.getDataToken();
        if (dataToken != null && dataToken.isValid()) {
            setData_token(harvestConfiguration.getData_token());
        }
        setError_limit(harvestConfiguration.getError_limit());
        setReport_max_transaction_age(harvestConfiguration.getReport_max_transaction_age());
        setReport_max_transaction_count(harvestConfiguration.getReport_max_transaction_count());
        setResponse_body_limit(harvestConfiguration.getResponse_body_limit());
        setServer_timestamp(harvestConfiguration.getServer_timestamp());
        setStack_trace_limit(harvestConfiguration.getStack_trace_limit());
        setActivity_trace_min_utilization(harvestConfiguration.getActivity_trace_min_utilization());
        setActivity_trace_max_report_attempts(harvestConfiguration.getActivity_trace_max_report_attempts());
        if (harvestConfiguration.getAt_capture() != null) {
            setAt_capture(harvestConfiguration.getAt_capture());
        }
        setPriority_encoding_key(harvestConfiguration.getPriority_encoding_key());
        setAccount_id(harvestConfiguration.getAccount_id());
        setApplication_id(harvestConfiguration.getApplication_id());
        setTrusted_account_key(harvestConfiguration.getTrusted_account_key());
    }

    public void setAccount_id(String str) {
        this.account_id = str;
    }

    public void setActivity_trace_max_report_attempts(int i11) {
        this.activity_trace_max_report_attempts = i11;
    }

    public void setActivity_trace_max_size(int i11) {
        this.activity_trace_max_size = i11;
    }

    public void setActivity_trace_min_utilization(double d11) {
        this.activity_trace_min_utilization = d11;
    }

    public void setApplication_id(String str) {
        this.application_id = str;
    }

    public void setAt_capture(ActivityTraceConfiguration activityTraceConfiguration) {
        this.at_capture = activityTraceConfiguration;
    }

    public void setCollect_network_errors(boolean z11) {
        this.collect_network_errors = z11;
    }

    public void setCross_process_id(String str) {
        this.cross_process_id = str;
    }

    public void setData_report_period(int i11) {
        this.data_report_period = i11;
    }

    public void setData_token(int[] iArr) {
        this.data_token = iArr;
    }

    public void setDefaultValues() {
        setData_token(new int[]{0, 0});
        setCollect_network_errors(true);
        setCross_process_id((String) null);
        setData_report_period(60);
        setError_limit(50);
        setResponse_body_limit(2048);
        setStack_trace_limit(100);
        setReport_max_transaction_age(600);
        setReport_max_transaction_count(1000);
        setActivity_trace_max_size(65534);
        setActivity_trace_max_report_attempts(1);
        setActivity_trace_min_utilization(0.30000001192092896d);
        setAt_capture(ActivityTraceConfiguration.defaultActivityTraceConfiguration());
        setPriority_encoding_key(DEFAULT_PRIORITY_ENCODING_KEY);
        setAccount_id("");
        setApplication_id("");
        setTrusted_account_key("");
    }

    public void setError_limit(int i11) {
        this.error_limit = i11;
    }

    public void setPriority_encoding_key(String str) {
        this.priority_encoding_key = str;
    }

    public void setReport_max_transaction_age(int i11) {
        this.report_max_transaction_age = i11;
    }

    public void setReport_max_transaction_count(int i11) {
        this.report_max_transaction_count = i11;
    }

    public void setResponse_body_limit(int i11) {
        this.response_body_limit = i11;
    }

    public void setServer_timestamp(long j11) {
        this.server_timestamp = j11;
    }

    public void setStack_trace_limit(int i11) {
        this.stack_trace_limit = i11;
    }

    public void setTrusted_account_key(String str) {
        this.trusted_account_key = str;
    }

    public String toString() {
        boolean z11 = this.collect_network_errors;
        String str = this.cross_process_id;
        int i11 = this.data_report_period;
        String arrays = Arrays.toString(this.data_token);
        int i12 = this.error_limit;
        int i13 = this.report_max_transaction_age;
        int i14 = this.report_max_transaction_count;
        int i15 = this.response_body_limit;
        long j11 = this.server_timestamp;
        int i16 = this.stack_trace_limit;
        int i17 = this.activity_trace_max_size;
        int i18 = this.activity_trace_max_report_attempts;
        double d11 = this.activity_trace_min_utilization;
        ActivityTraceConfiguration activityTraceConfiguration = this.at_capture;
        String str2 = this.priority_encoding_key;
        String str3 = this.account_id;
        String str4 = this.application_id;
        String str5 = this.trusted_account_key;
        return "HarvestConfiguration{collect_network_errors=" + z11 + ", cross_process_id='" + str + "', data_report_period=" + i11 + ", data_token=" + arrays + ", error_limit=" + i12 + ", report_max_transaction_age=" + i13 + ", report_max_transaction_count=" + i14 + ", response_body_limit=" + i15 + ", server_timestamp=" + j11 + ", stack_trace_limit=" + i16 + ", activity_trace_max_size=" + i17 + ", activity_trace_max_report_attempts=" + i18 + ", activity_trace_min_utilization=" + d11 + ", at_capture=" + activityTraceConfiguration + ", priority_encoding_key=" + str2 + ", account_id=" + str3 + ", application_id=" + str4 + ", trusted_account_key=" + str5 + "}";
    }
}
