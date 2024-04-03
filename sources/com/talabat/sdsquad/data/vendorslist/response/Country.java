package com.talabat.sdsquad.data.vendorslist.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\bO\b\b\u0018\u00002\u00020\u0001Bÿ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001eJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010A\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010U\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,Jº\u0002\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u00052\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\rHÖ\u0001J\t\u0010[\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b*\u0010\"R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b/\u0010\"R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b0\u0010\"R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b1\u0010,R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b2\u0010\"R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0013\u0010\"R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b3\u0010\"R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b4\u0010\"R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b5\u0010\"R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010 R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010 R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b8\u0010,R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b9\u0010\"R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b:\u0010\"R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010 R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b<\u0010\"¨\u0006\\"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/Country;", "", "aico", "", "amexAvail", "", "apa", "apptheme", "cd", "cities", "curs", "cwa", "dno", "", "flag", "ht", "icc", "id", "im", "isGoGreen", "iscity", "issel", "itce", "na", "sl", "tp", "tpay", "uniTrac", "url", "vca", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAico", "()Ljava/lang/String;", "getAmexAvail", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getApa", "getApptheme", "getCd", "getCities", "()Ljava/lang/Object;", "getCurs", "getCwa", "getDno", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFlag", "getHt", "getIcc", "getId", "getIm", "getIscity", "getIssel", "getItce", "getNa", "getSl", "getTp", "getTpay", "getUniTrac", "getUrl", "getVca", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/sdsquad/data/vendorslist/response/Country;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Country {
    @SerializedName("aico")
    @Nullable
    private final String aico;
    @SerializedName("amexAvail")
    @Nullable
    private final Boolean amexAvail;
    @SerializedName("apa")
    @Nullable
    private final Boolean apa;
    @SerializedName("apptheme")
    @Nullable
    private final String apptheme;
    @SerializedName("cd")
    @Nullable

    /* renamed from: cd  reason: collision with root package name */
    private final String f61304cd;
    @SerializedName("cities")
    @Nullable
    private final Object cities;
    @SerializedName("curs")
    @Nullable
    private final String curs;
    @SerializedName("cwa")
    @Nullable
    private final Boolean cwa;
    @SerializedName("dno")
    @Nullable
    private final Integer dno;
    @SerializedName("flag")
    @Nullable
    private final String flag;
    @SerializedName("ht")
    @Nullable

    /* renamed from: ht  reason: collision with root package name */
    private final Boolean f61305ht;
    @SerializedName("icc")
    @Nullable
    private final Boolean icc;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f61306id;
    @SerializedName("im")
    @Nullable

    /* renamed from: im  reason: collision with root package name */
    private final Boolean f61307im;
    @SerializedName("isGoGreen")
    @Nullable
    private final Boolean isGoGreen;
    @SerializedName("iscity")
    @Nullable
    private final Boolean iscity;
    @SerializedName("issel")
    @Nullable
    private final Boolean issel;
    @SerializedName("itce")
    @Nullable
    private final Boolean itce;
    @SerializedName("na")
    @Nullable

    /* renamed from: na  reason: collision with root package name */
    private final String f61308na;
    @SerializedName("sl")
    @Nullable

    /* renamed from: sl  reason: collision with root package name */
    private final String f61309sl;
    @SerializedName("tp")
    @Nullable

    /* renamed from: tp  reason: collision with root package name */
    private final Integer f61310tp;
    @SerializedName("tpay")
    @Nullable
    private final Boolean tpay;
    @SerializedName("uniTrac")
    @Nullable
    private final Boolean uniTrac;
    @SerializedName("url")
    @Nullable
    private final String url;
    @SerializedName("vca")
    @Nullable
    private final Boolean vca;

    public Country(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3, @Nullable Object obj, @Nullable String str4, @Nullable Boolean bool3, @Nullable Integer num, @Nullable String str5, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Integer num2, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable Boolean bool8, @Nullable Boolean bool9, @Nullable Boolean bool10, @Nullable String str6, @Nullable String str7, @Nullable Integer num3, @Nullable Boolean bool11, @Nullable Boolean bool12, @Nullable String str8, @Nullable Boolean bool13) {
        this.aico = str;
        this.amexAvail = bool;
        this.apa = bool2;
        this.apptheme = str2;
        this.f61304cd = str3;
        this.cities = obj;
        this.curs = str4;
        this.cwa = bool3;
        this.dno = num;
        this.flag = str5;
        this.f61305ht = bool4;
        this.icc = bool5;
        this.f61306id = num2;
        this.f61307im = bool6;
        this.isGoGreen = bool7;
        this.iscity = bool8;
        this.issel = bool9;
        this.itce = bool10;
        this.f61308na = str6;
        this.f61309sl = str7;
        this.f61310tp = num3;
        this.tpay = bool11;
        this.uniTrac = bool12;
        this.url = str8;
        this.vca = bool13;
    }

    public static /* synthetic */ Country copy$default(Country country, String str, Boolean bool, Boolean bool2, String str2, String str3, Object obj, String str4, Boolean bool3, Integer num, String str5, Boolean bool4, Boolean bool5, Integer num2, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, String str6, String str7, Integer num3, Boolean bool11, Boolean bool12, String str8, Boolean bool13, int i11, Object obj2) {
        Country country2 = country;
        int i12 = i11;
        return country.copy((i12 & 1) != 0 ? country2.aico : str, (i12 & 2) != 0 ? country2.amexAvail : bool, (i12 & 4) != 0 ? country2.apa : bool2, (i12 & 8) != 0 ? country2.apptheme : str2, (i12 & 16) != 0 ? country2.f61304cd : str3, (i12 & 32) != 0 ? country2.cities : obj, (i12 & 64) != 0 ? country2.curs : str4, (i12 & 128) != 0 ? country2.cwa : bool3, (i12 & 256) != 0 ? country2.dno : num, (i12 & 512) != 0 ? country2.flag : str5, (i12 & 1024) != 0 ? country2.f61305ht : bool4, (i12 & 2048) != 0 ? country2.icc : bool5, (i12 & 4096) != 0 ? country2.f61306id : num2, (i12 & 8192) != 0 ? country2.f61307im : bool6, (i12 & 16384) != 0 ? country2.isGoGreen : bool7, (i12 & 32768) != 0 ? country2.iscity : bool8, (i12 & 65536) != 0 ? country2.issel : bool9, (i12 & 131072) != 0 ? country2.itce : bool10, (i12 & 262144) != 0 ? country2.f61308na : str6, (i12 & 524288) != 0 ? country2.f61309sl : str7, (i12 & 1048576) != 0 ? country2.f61310tp : num3, (i12 & 2097152) != 0 ? country2.tpay : bool11, (i12 & 4194304) != 0 ? country2.uniTrac : bool12, (i12 & 8388608) != 0 ? country2.url : str8, (i12 & 16777216) != 0 ? country2.vca : bool13);
    }

    @Nullable
    public final String component1() {
        return this.aico;
    }

    @Nullable
    public final String component10() {
        return this.flag;
    }

    @Nullable
    public final Boolean component11() {
        return this.f61305ht;
    }

    @Nullable
    public final Boolean component12() {
        return this.icc;
    }

    @Nullable
    public final Integer component13() {
        return this.f61306id;
    }

    @Nullable
    public final Boolean component14() {
        return this.f61307im;
    }

    @Nullable
    public final Boolean component15() {
        return this.isGoGreen;
    }

    @Nullable
    public final Boolean component16() {
        return this.iscity;
    }

    @Nullable
    public final Boolean component17() {
        return this.issel;
    }

    @Nullable
    public final Boolean component18() {
        return this.itce;
    }

    @Nullable
    public final String component19() {
        return this.f61308na;
    }

    @Nullable
    public final Boolean component2() {
        return this.amexAvail;
    }

    @Nullable
    public final String component20() {
        return this.f61309sl;
    }

    @Nullable
    public final Integer component21() {
        return this.f61310tp;
    }

    @Nullable
    public final Boolean component22() {
        return this.tpay;
    }

    @Nullable
    public final Boolean component23() {
        return this.uniTrac;
    }

    @Nullable
    public final String component24() {
        return this.url;
    }

    @Nullable
    public final Boolean component25() {
        return this.vca;
    }

    @Nullable
    public final Boolean component3() {
        return this.apa;
    }

    @Nullable
    public final String component4() {
        return this.apptheme;
    }

    @Nullable
    public final String component5() {
        return this.f61304cd;
    }

    @Nullable
    public final Object component6() {
        return this.cities;
    }

    @Nullable
    public final String component7() {
        return this.curs;
    }

    @Nullable
    public final Boolean component8() {
        return this.cwa;
    }

    @Nullable
    public final Integer component9() {
        return this.dno;
    }

    @NotNull
    public final Country copy(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3, @Nullable Object obj, @Nullable String str4, @Nullable Boolean bool3, @Nullable Integer num, @Nullable String str5, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Integer num2, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable Boolean bool8, @Nullable Boolean bool9, @Nullable Boolean bool10, @Nullable String str6, @Nullable String str7, @Nullable Integer num3, @Nullable Boolean bool11, @Nullable Boolean bool12, @Nullable String str8, @Nullable Boolean bool13) {
        return new Country(str, bool, bool2, str2, str3, obj, str4, bool3, num, str5, bool4, bool5, num2, bool6, bool7, bool8, bool9, bool10, str6, str7, num3, bool11, bool12, str8, bool13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Country)) {
            return false;
        }
        Country country = (Country) obj;
        return Intrinsics.areEqual((Object) this.aico, (Object) country.aico) && Intrinsics.areEqual((Object) this.amexAvail, (Object) country.amexAvail) && Intrinsics.areEqual((Object) this.apa, (Object) country.apa) && Intrinsics.areEqual((Object) this.apptheme, (Object) country.apptheme) && Intrinsics.areEqual((Object) this.f61304cd, (Object) country.f61304cd) && Intrinsics.areEqual(this.cities, country.cities) && Intrinsics.areEqual((Object) this.curs, (Object) country.curs) && Intrinsics.areEqual((Object) this.cwa, (Object) country.cwa) && Intrinsics.areEqual((Object) this.dno, (Object) country.dno) && Intrinsics.areEqual((Object) this.flag, (Object) country.flag) && Intrinsics.areEqual((Object) this.f61305ht, (Object) country.f61305ht) && Intrinsics.areEqual((Object) this.icc, (Object) country.icc) && Intrinsics.areEqual((Object) this.f61306id, (Object) country.f61306id) && Intrinsics.areEqual((Object) this.f61307im, (Object) country.f61307im) && Intrinsics.areEqual((Object) this.isGoGreen, (Object) country.isGoGreen) && Intrinsics.areEqual((Object) this.iscity, (Object) country.iscity) && Intrinsics.areEqual((Object) this.issel, (Object) country.issel) && Intrinsics.areEqual((Object) this.itce, (Object) country.itce) && Intrinsics.areEqual((Object) this.f61308na, (Object) country.f61308na) && Intrinsics.areEqual((Object) this.f61309sl, (Object) country.f61309sl) && Intrinsics.areEqual((Object) this.f61310tp, (Object) country.f61310tp) && Intrinsics.areEqual((Object) this.tpay, (Object) country.tpay) && Intrinsics.areEqual((Object) this.uniTrac, (Object) country.uniTrac) && Intrinsics.areEqual((Object) this.url, (Object) country.url) && Intrinsics.areEqual((Object) this.vca, (Object) country.vca);
    }

    @Nullable
    public final String getAico() {
        return this.aico;
    }

    @Nullable
    public final Boolean getAmexAvail() {
        return this.amexAvail;
    }

    @Nullable
    public final Boolean getApa() {
        return this.apa;
    }

    @Nullable
    public final String getApptheme() {
        return this.apptheme;
    }

    @Nullable
    public final String getCd() {
        return this.f61304cd;
    }

    @Nullable
    public final Object getCities() {
        return this.cities;
    }

    @Nullable
    public final String getCurs() {
        return this.curs;
    }

    @Nullable
    public final Boolean getCwa() {
        return this.cwa;
    }

    @Nullable
    public final Integer getDno() {
        return this.dno;
    }

    @Nullable
    public final String getFlag() {
        return this.flag;
    }

    @Nullable
    public final Boolean getHt() {
        return this.f61305ht;
    }

    @Nullable
    public final Boolean getIcc() {
        return this.icc;
    }

    @Nullable
    public final Integer getId() {
        return this.f61306id;
    }

    @Nullable
    public final Boolean getIm() {
        return this.f61307im;
    }

    @Nullable
    public final Boolean getIscity() {
        return this.iscity;
    }

    @Nullable
    public final Boolean getIssel() {
        return this.issel;
    }

    @Nullable
    public final Boolean getItce() {
        return this.itce;
    }

    @Nullable
    public final String getNa() {
        return this.f61308na;
    }

    @Nullable
    public final String getSl() {
        return this.f61309sl;
    }

    @Nullable
    public final Integer getTp() {
        return this.f61310tp;
    }

    @Nullable
    public final Boolean getTpay() {
        return this.tpay;
    }

    @Nullable
    public final Boolean getUniTrac() {
        return this.uniTrac;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Boolean getVca() {
        return this.vca;
    }

    public int hashCode() {
        String str = this.aico;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.amexAvail;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.apa;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.apptheme;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f61304cd;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Object obj = this.cities;
        int hashCode6 = (hashCode5 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str4 = this.curs;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool3 = this.cwa;
        int hashCode8 = (hashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num = this.dno;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.flag;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool4 = this.f61305ht;
        int hashCode11 = (hashCode10 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.icc;
        int hashCode12 = (hashCode11 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Integer num2 = this.f61306id;
        int hashCode13 = (hashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool6 = this.f61307im;
        int hashCode14 = (hashCode13 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.isGoGreen;
        int hashCode15 = (hashCode14 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.iscity;
        int hashCode16 = (hashCode15 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.issel;
        int hashCode17 = (hashCode16 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        Boolean bool10 = this.itce;
        int hashCode18 = (hashCode17 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        String str6 = this.f61308na;
        int hashCode19 = (hashCode18 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f61309sl;
        int hashCode20 = (hashCode19 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num3 = this.f61310tp;
        int hashCode21 = (hashCode20 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool11 = this.tpay;
        int hashCode22 = (hashCode21 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
        Boolean bool12 = this.uniTrac;
        int hashCode23 = (hashCode22 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
        String str8 = this.url;
        int hashCode24 = (hashCode23 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool13 = this.vca;
        if (bool13 != null) {
            i11 = bool13.hashCode();
        }
        return hashCode24 + i11;
    }

    @Nullable
    public final Boolean isGoGreen() {
        return this.isGoGreen;
    }

    @NotNull
    public String toString() {
        String str = this.aico;
        Boolean bool = this.amexAvail;
        Boolean bool2 = this.apa;
        String str2 = this.apptheme;
        String str3 = this.f61304cd;
        Object obj = this.cities;
        String str4 = this.curs;
        Boolean bool3 = this.cwa;
        Integer num = this.dno;
        String str5 = this.flag;
        Boolean bool4 = this.f61305ht;
        Boolean bool5 = this.icc;
        Integer num2 = this.f61306id;
        Boolean bool6 = this.f61307im;
        Boolean bool7 = this.isGoGreen;
        Boolean bool8 = this.iscity;
        Boolean bool9 = this.issel;
        Boolean bool10 = this.itce;
        String str6 = this.f61308na;
        String str7 = this.f61309sl;
        Integer num3 = this.f61310tp;
        Boolean bool11 = this.tpay;
        Boolean bool12 = this.uniTrac;
        String str8 = this.url;
        Boolean bool13 = this.vca;
        return "Country(aico=" + str + ", amexAvail=" + bool + ", apa=" + bool2 + ", apptheme=" + str2 + ", cd=" + str3 + ", cities=" + obj + ", curs=" + str4 + ", cwa=" + bool3 + ", dno=" + num + ", flag=" + str5 + ", ht=" + bool4 + ", icc=" + bool5 + ", id=" + num2 + ", im=" + bool6 + ", isGoGreen=" + bool7 + ", iscity=" + bool8 + ", issel=" + bool9 + ", itce=" + bool10 + ", na=" + str6 + ", sl=" + str7 + ", tp=" + num3 + ", tpay=" + bool11 + ", uniTrac=" + bool12 + ", url=" + str8 + ", vca=" + bool13 + ")";
    }
}
