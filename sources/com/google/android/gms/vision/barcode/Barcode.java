package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "BarcodeCreator")
@SafeParcelable.Reserved({1})
public class Barcode extends AbstractSafeParcelable {
    public static final int ALL_FORMATS = 0;
    public static final int AZTEC = 4096;
    public static final int CALENDAR_EVENT = 11;
    public static final int CODABAR = 8;
    public static final int CODE_128 = 1;
    public static final int CODE_39 = 2;
    public static final int CODE_93 = 4;
    public static final int CONTACT_INFO = 1;
    public static final Parcelable.Creator<Barcode> CREATOR = new zzb();
    public static final int DATA_MATRIX = 16;
    public static final int DRIVER_LICENSE = 12;
    public static final int EAN_13 = 32;
    public static final int EAN_8 = 64;
    public static final int EMAIL = 2;
    public static final int GEO = 10;
    public static final int ISBN = 3;
    public static final int ITF = 128;
    public static final int PDF417 = 2048;
    public static final int PHONE = 4;
    public static final int PRODUCT = 5;
    public static final int QR_CODE = 256;
    public static final int SMS = 6;
    public static final int TEXT = 7;
    public static final int UPC_A = 512;
    public static final int UPC_E = 1024;
    public static final int URL = 8;
    public static final int WIFI = 9;
    @SafeParcelable.Field(id = 13)
    public CalendarEvent calendarEvent;
    @SafeParcelable.Field(id = 14)
    public ContactInfo contactInfo;
    @SafeParcelable.Field(id = 6)
    public Point[] cornerPoints;
    @SafeParcelable.Field(id = 4)
    public String displayValue;
    @SafeParcelable.Field(id = 15)
    public DriverLicense driverLicense;
    @SafeParcelable.Field(id = 7)
    public Email email;
    @SafeParcelable.Field(id = 2)
    public int format;
    @SafeParcelable.Field(id = 12)
    public GeoPoint geoPoint;
    @SafeParcelable.Field(id = 8)
    public Phone phone;
    @SafeParcelable.Field(id = 16)
    public byte[] rawBytes;
    @SafeParcelable.Field(id = 3)
    public String rawValue;
    @SafeParcelable.Field(id = 9)
    public Sms sms;
    @SafeParcelable.Field(id = 11)
    public UrlBookmark url;
    @SafeParcelable.Field(id = 5)
    public int valueFormat;
    @SafeParcelable.Field(id = 10)
    public WiFi wifi;

    @SafeParcelable.Class(creator = "AddressCreator")
    @SafeParcelable.Reserved({1})
    public static class Address extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Address> CREATOR = new zza();
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        @SafeParcelable.Field(id = 3)
        public String[] addressLines;
        @SafeParcelable.Field(id = 2)
        public int type;

        public Address() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 2, this.type);
            SafeParcelWriter.writeStringArray(parcel, 3, this.addressLines, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public Address(@SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) String[] strArr) {
            this.type = i11;
            this.addressLines = strArr;
        }
    }

    @SafeParcelable.Class(creator = "CalendarDateTimeCreator")
    @SafeParcelable.Reserved({1})
    public static class CalendarDateTime extends AbstractSafeParcelable {
        public static final Parcelable.Creator<CalendarDateTime> CREATOR = new zzd();
        @SafeParcelable.Field(id = 4)
        public int day;
        @SafeParcelable.Field(id = 5)
        public int hours;
        @SafeParcelable.Field(id = 8)
        public boolean isUtc;
        @SafeParcelable.Field(id = 6)
        public int minutes;
        @SafeParcelable.Field(id = 3)
        public int month;
        @SafeParcelable.Field(id = 9)
        public String rawValue;
        @SafeParcelable.Field(id = 7)
        public int seconds;
        @SafeParcelable.Field(id = 2)
        public int year;

        public CalendarDateTime() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 2, this.year);
            SafeParcelWriter.writeInt(parcel, 3, this.month);
            SafeParcelWriter.writeInt(parcel, 4, this.day);
            SafeParcelWriter.writeInt(parcel, 5, this.hours);
            SafeParcelWriter.writeInt(parcel, 6, this.minutes);
            SafeParcelWriter.writeInt(parcel, 7, this.seconds);
            SafeParcelWriter.writeBoolean(parcel, 8, this.isUtc);
            SafeParcelWriter.writeString(parcel, 9, this.rawValue, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public CalendarDateTime(@SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) int i12, @SafeParcelable.Param(id = 4) int i13, @SafeParcelable.Param(id = 5) int i14, @SafeParcelable.Param(id = 6) int i15, @SafeParcelable.Param(id = 7) int i16, @SafeParcelable.Param(id = 8) boolean z11, @SafeParcelable.Param(id = 9) String str) {
            this.year = i11;
            this.month = i12;
            this.day = i13;
            this.hours = i14;
            this.minutes = i15;
            this.seconds = i16;
            this.isUtc = z11;
            this.rawValue = str;
        }
    }

    @SafeParcelable.Class(creator = "CalendarEventCreator")
    @SafeParcelable.Reserved({1})
    public static class CalendarEvent extends AbstractSafeParcelable {
        public static final Parcelable.Creator<CalendarEvent> CREATOR = new zzf();
        @SafeParcelable.Field(id = 3)
        public String description;
        @SafeParcelable.Field(id = 8)
        public CalendarDateTime end;
        @SafeParcelable.Field(id = 4)
        public String location;
        @SafeParcelable.Field(id = 5)
        public String organizer;
        @SafeParcelable.Field(id = 7)
        public CalendarDateTime start;
        @SafeParcelable.Field(id = 6)
        public String status;
        @SafeParcelable.Field(id = 2)
        public String summary;

        public CalendarEvent() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.summary, false);
            SafeParcelWriter.writeString(parcel, 3, this.description, false);
            SafeParcelWriter.writeString(parcel, 4, this.location, false);
            SafeParcelWriter.writeString(parcel, 5, this.organizer, false);
            SafeParcelWriter.writeString(parcel, 6, this.status, false);
            SafeParcelWriter.writeParcelable(parcel, 7, this.start, i11, false);
            SafeParcelWriter.writeParcelable(parcel, 8, this.end, i11, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public CalendarEvent(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) CalendarDateTime calendarDateTime, @SafeParcelable.Param(id = 8) CalendarDateTime calendarDateTime2) {
            this.summary = str;
            this.description = str2;
            this.location = str3;
            this.organizer = str4;
            this.status = str5;
            this.start = calendarDateTime;
            this.end = calendarDateTime2;
        }
    }

    @SafeParcelable.Class(creator = "ContactInfoCreator")
    @SafeParcelable.Reserved({1})
    public static class ContactInfo extends AbstractSafeParcelable {
        public static final Parcelable.Creator<ContactInfo> CREATOR = new zze();
        @SafeParcelable.Field(id = 8)
        public Address[] addresses;
        @SafeParcelable.Field(id = 6)
        public Email[] emails;
        @SafeParcelable.Field(id = 2)

        /* renamed from: name  reason: collision with root package name */
        public PersonName f44512name;
        @SafeParcelable.Field(id = 3)
        public String organization;
        @SafeParcelable.Field(id = 5)
        public Phone[] phones;
        @SafeParcelable.Field(id = 4)
        public String title;
        @SafeParcelable.Field(id = 7)
        public String[] urls;

        public ContactInfo() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeParcelable(parcel, 2, this.f44512name, i11, false);
            SafeParcelWriter.writeString(parcel, 3, this.organization, false);
            SafeParcelWriter.writeString(parcel, 4, this.title, false);
            SafeParcelWriter.writeTypedArray(parcel, 5, this.phones, i11, false);
            SafeParcelWriter.writeTypedArray(parcel, 6, this.emails, i11, false);
            SafeParcelWriter.writeStringArray(parcel, 7, this.urls, false);
            SafeParcelWriter.writeTypedArray(parcel, 8, this.addresses, i11, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public ContactInfo(@SafeParcelable.Param(id = 2) PersonName personName, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) Phone[] phoneArr, @SafeParcelable.Param(id = 6) Email[] emailArr, @SafeParcelable.Param(id = 7) String[] strArr, @SafeParcelable.Param(id = 8) Address[] addressArr) {
            this.f44512name = personName;
            this.organization = str;
            this.title = str2;
            this.phones = phoneArr;
            this.emails = emailArr;
            this.urls = strArr;
            this.addresses = addressArr;
        }
    }

    @SafeParcelable.Class(creator = "DriverLicenseCreator")
    @SafeParcelable.Reserved({1})
    public static class DriverLicense extends AbstractSafeParcelable {
        public static final Parcelable.Creator<DriverLicense> CREATOR = new zzh();
        @SafeParcelable.Field(id = 8)
        public String addressCity;
        @SafeParcelable.Field(id = 9)
        public String addressState;
        @SafeParcelable.Field(id = 7)
        public String addressStreet;
        @SafeParcelable.Field(id = 10)
        public String addressZip;
        @SafeParcelable.Field(id = 14)
        public String birthDate;
        @SafeParcelable.Field(id = 2)
        public String documentType;
        @SafeParcelable.Field(id = 13)
        public String expiryDate;
        @SafeParcelable.Field(id = 3)
        public String firstName;
        @SafeParcelable.Field(id = 6)
        public String gender;
        @SafeParcelable.Field(id = 12)
        public String issueDate;
        @SafeParcelable.Field(id = 15)
        public String issuingCountry;
        @SafeParcelable.Field(id = 5)
        public String lastName;
        @SafeParcelable.Field(id = 11)
        public String licenseNumber;
        @SafeParcelable.Field(id = 4)
        public String middleName;

        public DriverLicense() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.documentType, false);
            SafeParcelWriter.writeString(parcel, 3, this.firstName, false);
            SafeParcelWriter.writeString(parcel, 4, this.middleName, false);
            SafeParcelWriter.writeString(parcel, 5, this.lastName, false);
            SafeParcelWriter.writeString(parcel, 6, this.gender, false);
            SafeParcelWriter.writeString(parcel, 7, this.addressStreet, false);
            SafeParcelWriter.writeString(parcel, 8, this.addressCity, false);
            SafeParcelWriter.writeString(parcel, 9, this.addressState, false);
            SafeParcelWriter.writeString(parcel, 10, this.addressZip, false);
            SafeParcelWriter.writeString(parcel, 11, this.licenseNumber, false);
            SafeParcelWriter.writeString(parcel, 12, this.issueDate, false);
            SafeParcelWriter.writeString(parcel, 13, this.expiryDate, false);
            SafeParcelWriter.writeString(parcel, 14, this.birthDate, false);
            SafeParcelWriter.writeString(parcel, 15, this.issuingCountry, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public DriverLicense(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7, @SafeParcelable.Param(id = 9) String str8, @SafeParcelable.Param(id = 10) String str9, @SafeParcelable.Param(id = 11) String str10, @SafeParcelable.Param(id = 12) String str11, @SafeParcelable.Param(id = 13) String str12, @SafeParcelable.Param(id = 14) String str13, @SafeParcelable.Param(id = 15) String str14) {
            this.documentType = str;
            this.firstName = str2;
            this.middleName = str3;
            this.lastName = str4;
            this.gender = str5;
            this.addressStreet = str6;
            this.addressCity = str7;
            this.addressState = str8;
            this.addressZip = str9;
            this.licenseNumber = str10;
            this.issueDate = str11;
            this.expiryDate = str12;
            this.birthDate = str13;
            this.issuingCountry = str14;
        }
    }

    @SafeParcelable.Class(creator = "EmailCreator")
    @SafeParcelable.Reserved({1})
    public static class Email extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Email> CREATOR = new zzg();
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        @SafeParcelable.Field(id = 3)
        public String address;
        @SafeParcelable.Field(id = 5)
        public String body;
        @SafeParcelable.Field(id = 4)
        public String subject;
        @SafeParcelable.Field(id = 2)
        public int type;

        public Email() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 2, this.type);
            SafeParcelWriter.writeString(parcel, 3, this.address, false);
            SafeParcelWriter.writeString(parcel, 4, this.subject, false);
            SafeParcelWriter.writeString(parcel, 5, this.body, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public Email(@SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3) {
            this.type = i11;
            this.address = str;
            this.subject = str2;
            this.body = str3;
        }
    }

    @SafeParcelable.Class(creator = "GeoPointCreator")
    @SafeParcelable.Reserved({1})
    public static class GeoPoint extends AbstractSafeParcelable {
        public static final Parcelable.Creator<GeoPoint> CREATOR = new zzj();
        @SafeParcelable.Field(id = 2)
        public double lat;
        @SafeParcelable.Field(id = 3)
        public double lng;

        public GeoPoint() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeDouble(parcel, 2, this.lat);
            SafeParcelWriter.writeDouble(parcel, 3, this.lng);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public GeoPoint(@SafeParcelable.Param(id = 2) double d11, @SafeParcelable.Param(id = 3) double d12) {
            this.lat = d11;
            this.lng = d12;
        }
    }

    @SafeParcelable.Class(creator = "PersonNameCreator")
    @SafeParcelable.Reserved({1})
    public static class PersonName extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PersonName> CREATOR = new zzi();
        @SafeParcelable.Field(id = 5)
        public String first;
        @SafeParcelable.Field(id = 2)
        public String formattedName;
        @SafeParcelable.Field(id = 7)
        public String last;
        @SafeParcelable.Field(id = 6)
        public String middle;
        @SafeParcelable.Field(id = 4)
        public String prefix;
        @SafeParcelable.Field(id = 3)
        public String pronunciation;
        @SafeParcelable.Field(id = 8)
        public String suffix;

        public PersonName() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.formattedName, false);
            SafeParcelWriter.writeString(parcel, 3, this.pronunciation, false);
            SafeParcelWriter.writeString(parcel, 4, this.prefix, false);
            SafeParcelWriter.writeString(parcel, 5, this.first, false);
            SafeParcelWriter.writeString(parcel, 6, this.middle, false);
            SafeParcelWriter.writeString(parcel, 7, this.last, false);
            SafeParcelWriter.writeString(parcel, 8, this.suffix, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public PersonName(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7) {
            this.formattedName = str;
            this.pronunciation = str2;
            this.prefix = str3;
            this.first = str4;
            this.middle = str5;
            this.last = str6;
            this.suffix = str7;
        }
    }

    @SafeParcelable.Class(creator = "PhoneCreator")
    @SafeParcelable.Reserved({1})
    public static class Phone extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Phone> CREATOR = new zzl();
        public static final int FAX = 3;
        public static final int HOME = 2;
        public static final int MOBILE = 4;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        @SafeParcelable.Field(id = 3)
        public String number;
        @SafeParcelable.Field(id = 2)
        public int type;

        public Phone() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 2, this.type);
            SafeParcelWriter.writeString(parcel, 3, this.number, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public Phone(@SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) String str) {
            this.type = i11;
            this.number = str;
        }
    }

    @SafeParcelable.Class(creator = "SmsCreator")
    @SafeParcelable.Reserved({1})
    public static class Sms extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Sms> CREATOR = new zzk();
        @SafeParcelable.Field(id = 2)
        public String message;
        @SafeParcelable.Field(id = 3)
        public String phoneNumber;

        public Sms() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.message, false);
            SafeParcelWriter.writeString(parcel, 3, this.phoneNumber, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public Sms(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
            this.message = str;
            this.phoneNumber = str2;
        }
    }

    @SafeParcelable.Class(creator = "UrlBookmarkCreator")
    @SafeParcelable.Reserved({1})
    public static class UrlBookmark extends AbstractSafeParcelable {
        public static final Parcelable.Creator<UrlBookmark> CREATOR = new zzn();
        @SafeParcelable.Field(id = 2)
        public String title;
        @SafeParcelable.Field(id = 3)
        public String url;

        public UrlBookmark() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.title, false);
            SafeParcelWriter.writeString(parcel, 3, this.url, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public UrlBookmark(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
            this.title = str;
            this.url = str2;
        }
    }

    @SafeParcelable.Class(creator = "WiFiCreator")
    @SafeParcelable.Reserved({1})
    public static class WiFi extends AbstractSafeParcelable {
        public static final Parcelable.Creator<WiFi> CREATOR = new zzm();
        public static final int OPEN = 1;
        public static final int WEP = 3;
        public static final int WPA = 2;
        @SafeParcelable.Field(id = 4)
        public int encryptionType;
        @SafeParcelable.Field(id = 3)
        public String password;
        @SafeParcelable.Field(id = 2)
        public String ssid;

        public WiFi() {
        }

        public void writeToParcel(Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.ssid, false);
            SafeParcelWriter.writeString(parcel, 3, this.password, false);
            SafeParcelWriter.writeInt(parcel, 4, this.encryptionType);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @SafeParcelable.Constructor
        public WiFi(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) int i11) {
            this.ssid = str;
            this.password = str2;
            this.encryptionType = i11;
        }
    }

    public Barcode() {
    }

    public Rect getBoundingBox() {
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MIN_VALUE;
        int i13 = 0;
        int i14 = Integer.MAX_VALUE;
        int i15 = Integer.MIN_VALUE;
        while (true) {
            Point[] pointArr = this.cornerPoints;
            if (i13 >= pointArr.length) {
                return new Rect(i11, i14, i15, i12);
            }
            Point point = pointArr[i13];
            i11 = Math.min(i11, point.x);
            i15 = Math.max(i15, point.x);
            i14 = Math.min(i14, point.y);
            i12 = Math.max(i12, point.y);
            i13++;
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.format);
        SafeParcelWriter.writeString(parcel, 3, this.rawValue, false);
        SafeParcelWriter.writeString(parcel, 4, this.displayValue, false);
        SafeParcelWriter.writeInt(parcel, 5, this.valueFormat);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.cornerPoints, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.email, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.phone, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.sms, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.wifi, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.url, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.geoPoint, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.calendarEvent, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.contactInfo, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.driverLicense, i11, false);
        SafeParcelWriter.writeByteArray(parcel, 16, this.rawBytes, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public Barcode(@SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) int i12, @SafeParcelable.Param(id = 6) Point[] pointArr, @SafeParcelable.Param(id = 7) Email email2, @SafeParcelable.Param(id = 8) Phone phone2, @SafeParcelable.Param(id = 9) Sms sms2, @SafeParcelable.Param(id = 10) WiFi wiFi, @SafeParcelable.Param(id = 11) UrlBookmark urlBookmark, @SafeParcelable.Param(id = 12) GeoPoint geoPoint2, @SafeParcelable.Param(id = 13) CalendarEvent calendarEvent2, @SafeParcelable.Param(id = 14) ContactInfo contactInfo2, @SafeParcelable.Param(id = 15) DriverLicense driverLicense2, @SafeParcelable.Param(id = 16) byte[] bArr) {
        this.format = i11;
        this.rawValue = str;
        this.rawBytes = bArr;
        this.displayValue = str2;
        this.valueFormat = i12;
        this.cornerPoints = pointArr;
        this.email = email2;
        this.phone = phone2;
        this.sms = sms2;
        this.wifi = wiFi;
        this.url = urlBookmark;
        this.geoPoint = geoPoint2;
        this.calendarEvent = calendarEvent2;
        this.contactInfo = contactInfo2;
        this.driverLicense = driverLicense2;
    }
}
