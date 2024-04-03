package com.opsquad.features.orderDetails.models.responses;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u001e\u0018\u00002\u00020\u0001:\u0001bB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\b\u0018\u00010\u001cR\u00020\u00008\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR \u0010'\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR \u0010*\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR \u0010-\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR \u00100\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR \u00103\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001e\u00106\u001a\u0002078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u0002078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R\u001e\u0010=\u001a\u0002078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R \u0010?\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010\u000eR \u0010A\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR\u001e\u0010D\u001a\u00020E8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001e\u0010J\u001a\u00020E8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010G\"\u0004\bL\u0010IR \u0010M\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000eR \u0010P\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u000eR \u0010S\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\f\"\u0004\bU\u0010\u000eR \u0010V\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\f\"\u0004\bX\u0010\u000eR \u0010Y\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\f\"\u0004\b[\u0010\u000eR \u0010\\\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\f\"\u0004\b^\u0010\u000eR\u001e\u0010_\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0006\"\u0004\ba\u0010\b¨\u0006c"}, d2 = {"Lcom/opsquad/features/orderDetails/models/responses/OrderAddressResponse;", "", "()V", "areaId", "", "getAreaId", "()I", "setAreaId", "(I)V", "areaName", "", "getAreaName", "()Ljava/lang/String;", "setAreaName", "(Ljava/lang/String;)V", "block", "getBlock", "setBlock", "buildingNo", "getBuildingNo", "setBuildingNo", "cityId", "getCityId", "setCityId", "countyId", "getCountyId", "setCountyId", "extraAddressObjects", "Lcom/opsquad/features/orderDetails/models/responses/OrderAddressResponse$ExtraAddressObjects;", "getExtraAddressObjects", "()Lcom/opsquad/features/orderDetails/models/responses/OrderAddressResponse$ExtraAddressObjects;", "setExtraAddressObjects", "(Lcom/opsquad/features/orderDetails/models/responses/OrderAddressResponse$ExtraAddressObjects;)V", "extraDirections", "getExtraDirections", "setExtraDirections", "floor", "getFloor", "setFloor", "geoAddressMsg", "getGeoAddressMsg", "setGeoAddressMsg", "geoAddressTitle", "getGeoAddressTitle", "setGeoAddressTitle", "grl", "getGrl", "setGrl", "grlid", "getGrlid", "setGrlid", "id", "getId", "setId", "isAreaSplit", "", "()Z", "setAreaSplit", "(Z)V", "isDeliverable", "setDeliverable", "isOldAddreses", "setOldAddreses", "isPrimary", "setPrimary", "judda", "getJudda", "setJudda", "latitude", "", "getLatitude", "()D", "setLatitude", "(D)V", "longitude", "getLongitude", "setLongitude", "mobilNumberCountryCode", "getMobilNumberCountryCode", "setMobilNumberCountryCode", "mobileNumber", "getMobileNumber", "setMobileNumber", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "profileName", "getProfileName", "setProfileName", "street", "getStreet", "setStreet", "suite", "getSuite", "setSuite", "type", "getType", "setType", "ExtraAddressObjects", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderAddressResponse {
    @SerializedName("aid")
    private int areaId;
    @SerializedName("an")
    @Nullable
    private String areaName;
    @SerializedName("blk")
    @Nullable
    private String block;
    @SerializedName("bno")
    @Nullable
    private String buildingNo;
    @SerializedName("cid")
    private int cityId;
    @SerializedName("cnt")
    private int countyId;
    @SerializedName("extra")
    @Nullable
    private ExtraAddressObjects extraAddressObjects;
    @SerializedName("exd")
    @Nullable
    private String extraDirections;
    @SerializedName("fl")
    @Nullable
    private String floor;
    @SerializedName("msg")
    @Nullable
    private String geoAddressMsg;
    @SerializedName("title")
    @Nullable
    private String geoAddressTitle;
    @SerializedName("grl")
    @Nullable
    private String grl;
    @SerializedName("grlid")
    @Nullable
    private String grlid;
    @SerializedName("eid")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private String f52863id;
    @SerializedName("asplt")
    private boolean isAreaSplit;
    @SerializedName("efd")
    private boolean isDeliverable;
    @SerializedName("iso")
    private boolean isOldAddreses;
    @SerializedName("ip")
    @Nullable
    private String isPrimary;
    @SerializedName("jd")
    @Nullable
    private String judda;
    @SerializedName("ltd")
    private double latitude;
    @SerializedName("lngt")
    private double longitude;
    @SerializedName("ccd")
    @Nullable
    private String mobilNumberCountryCode;
    @SerializedName("mob")
    @Nullable
    private String mobileNumber;
    @SerializedName("ph")
    @Nullable
    private String phoneNumber;
    @SerializedName("pn")
    @Nullable
    private String profileName;
    @SerializedName("st")
    @Nullable
    private String street;
    @SerializedName("su")
    @Nullable
    private String suite;
    @SerializedName("type")
    private int type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/opsquad/features/orderDetails/models/responses/OrderAddressResponse$ExtraAddressObjects;", "", "(Lcom/opsquad/features/orderDetails/models/responses/OrderAddressResponse;)V", "isBlockFromMap", "", "()Z", "setBlockFromMap", "(Z)V", "isSatliteView", "setSatliteView", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ExtraAddressObjects {
        @SerializedName("igb")
        private boolean isBlockFromMap;
        @SerializedName("iev")
        private boolean isSatliteView;

        public ExtraAddressObjects() {
        }

        public final boolean isBlockFromMap() {
            return this.isBlockFromMap;
        }

        public final boolean isSatliteView() {
            return this.isSatliteView;
        }

        public final void setBlockFromMap(boolean z11) {
            this.isBlockFromMap = z11;
        }

        public final void setSatliteView(boolean z11) {
            this.isSatliteView = z11;
        }
    }

    public final int getAreaId() {
        return this.areaId;
    }

    @Nullable
    public final String getAreaName() {
        return this.areaName;
    }

    @Nullable
    public final String getBlock() {
        return this.block;
    }

    @Nullable
    public final String getBuildingNo() {
        return this.buildingNo;
    }

    public final int getCityId() {
        return this.cityId;
    }

    public final int getCountyId() {
        return this.countyId;
    }

    @Nullable
    public final ExtraAddressObjects getExtraAddressObjects() {
        return this.extraAddressObjects;
    }

    @Nullable
    public final String getExtraDirections() {
        return this.extraDirections;
    }

    @Nullable
    public final String getFloor() {
        return this.floor;
    }

    @Nullable
    public final String getGeoAddressMsg() {
        return this.geoAddressMsg;
    }

    @Nullable
    public final String getGeoAddressTitle() {
        return this.geoAddressTitle;
    }

    @Nullable
    public final String getGrl() {
        return this.grl;
    }

    @Nullable
    public final String getGrlid() {
        return this.grlid;
    }

    @Nullable
    public final String getId() {
        return this.f52863id;
    }

    @Nullable
    public final String getJudda() {
        return this.judda;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final String getMobilNumberCountryCode() {
        return this.mobilNumberCountryCode;
    }

    @Nullable
    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Nullable
    public final String getProfileName() {
        return this.profileName;
    }

    @Nullable
    public final String getStreet() {
        return this.street;
    }

    @Nullable
    public final String getSuite() {
        return this.suite;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isAreaSplit() {
        return this.isAreaSplit;
    }

    public final boolean isDeliverable() {
        return this.isDeliverable;
    }

    public final boolean isOldAddreses() {
        return this.isOldAddreses;
    }

    @Nullable
    public final String isPrimary() {
        return this.isPrimary;
    }

    public final void setAreaId(int i11) {
        this.areaId = i11;
    }

    public final void setAreaName(@Nullable String str) {
        this.areaName = str;
    }

    public final void setAreaSplit(boolean z11) {
        this.isAreaSplit = z11;
    }

    public final void setBlock(@Nullable String str) {
        this.block = str;
    }

    public final void setBuildingNo(@Nullable String str) {
        this.buildingNo = str;
    }

    public final void setCityId(int i11) {
        this.cityId = i11;
    }

    public final void setCountyId(int i11) {
        this.countyId = i11;
    }

    public final void setDeliverable(boolean z11) {
        this.isDeliverable = z11;
    }

    public final void setExtraAddressObjects(@Nullable ExtraAddressObjects extraAddressObjects2) {
        this.extraAddressObjects = extraAddressObjects2;
    }

    public final void setExtraDirections(@Nullable String str) {
        this.extraDirections = str;
    }

    public final void setFloor(@Nullable String str) {
        this.floor = str;
    }

    public final void setGeoAddressMsg(@Nullable String str) {
        this.geoAddressMsg = str;
    }

    public final void setGeoAddressTitle(@Nullable String str) {
        this.geoAddressTitle = str;
    }

    public final void setGrl(@Nullable String str) {
        this.grl = str;
    }

    public final void setGrlid(@Nullable String str) {
        this.grlid = str;
    }

    public final void setId(@Nullable String str) {
        this.f52863id = str;
    }

    public final void setJudda(@Nullable String str) {
        this.judda = str;
    }

    public final void setLatitude(double d11) {
        this.latitude = d11;
    }

    public final void setLongitude(double d11) {
        this.longitude = d11;
    }

    public final void setMobilNumberCountryCode(@Nullable String str) {
        this.mobilNumberCountryCode = str;
    }

    public final void setMobileNumber(@Nullable String str) {
        this.mobileNumber = str;
    }

    public final void setOldAddreses(boolean z11) {
        this.isOldAddreses = z11;
    }

    public final void setPhoneNumber(@Nullable String str) {
        this.phoneNumber = str;
    }

    public final void setPrimary(@Nullable String str) {
        this.isPrimary = str;
    }

    public final void setProfileName(@Nullable String str) {
        this.profileName = str;
    }

    public final void setStreet(@Nullable String str) {
        this.street = str;
    }

    public final void setSuite(@Nullable String str) {
        this.suite = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }
}
