package com.google.crypto.tink.jwt;

import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.errorprone.annotations.Immutable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.time.Instant;
import j$.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Immutable
public final class RawJwt {
    private static final long MAX_TIMESTAMP_VALUE = 253402300799L;
    private final JsonObject payload;
    private final Optional<String> typeHeader;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final JsonObject payload;
        /* access modifiers changed from: private */
        public Optional<String> typeHeader;
        /* access modifiers changed from: private */
        public boolean withoutExpiration;

        private void setTimestampClaim(String str, Instant instant) {
            long epochSecond = instant.getEpochSecond();
            if (epochSecond > RawJwt.MAX_TIMESTAMP_VALUE || epochSecond < 0) {
                throw new IllegalArgumentException("timestamp of claim " + str + " is out of range");
            }
            this.payload.add(str, new JsonPrimitive((Number) Long.valueOf(epochSecond)));
        }

        public Builder addAudience(String str) {
            JsonArray jsonArray;
            if (JsonUtil.isValidString(str)) {
                if (this.payload.has(AuthenticationTokenClaims.JSON_KEY_AUD)) {
                    JsonElement jsonElement = this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD);
                    if (jsonElement.isJsonArray()) {
                        jsonArray = jsonElement.getAsJsonArray();
                    } else {
                        throw new IllegalArgumentException("addAudience can't be used together with setAudience");
                    }
                } else {
                    jsonArray = new JsonArray();
                }
                jsonArray.add(str);
                this.payload.add(AuthenticationTokenClaims.JSON_KEY_AUD, jsonArray);
                return this;
            }
            throw new IllegalArgumentException("invalid string");
        }

        public Builder addBooleanClaim(String str, boolean z11) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(Boolean.valueOf(z11)));
            return this;
        }

        public Builder addJsonArrayClaim(String str, String str2) throws JwtInvalidException {
            JwtNames.validate(str);
            this.payload.add(str, JsonUtil.parseJsonArray(str2));
            return this;
        }

        public Builder addJsonObjectClaim(String str, String str2) throws JwtInvalidException {
            JwtNames.validate(str);
            this.payload.add(str, JsonUtil.parseJson(str2));
            return this;
        }

        public Builder addNullClaim(String str) {
            JwtNames.validate(str);
            this.payload.add(str, JsonNull.INSTANCE);
            return this;
        }

        public Builder addNumberClaim(String str, double d11) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive((Number) Double.valueOf(d11)));
            return this;
        }

        public Builder addStringClaim(String str, String str2) {
            if (JsonUtil.isValidString(str2)) {
                JwtNames.validate(str);
                this.payload.add(str, new JsonPrimitive(str2));
                return this;
            }
            throw new IllegalArgumentException();
        }

        public RawJwt build() {
            return new RawJwt(this);
        }

        public Builder setAudience(String str) {
            if (this.payload.has(AuthenticationTokenClaims.JSON_KEY_AUD) && this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD).isJsonArray()) {
                throw new IllegalArgumentException("setAudience can't be used together with setAudiences or addAudience");
            } else if (JsonUtil.isValidString(str)) {
                this.payload.add(AuthenticationTokenClaims.JSON_KEY_AUD, new JsonPrimitive(str));
                return this;
            } else {
                throw new IllegalArgumentException("invalid string");
            }
        }

        public Builder setAudiences(List<String> list) {
            if (this.payload.has(AuthenticationTokenClaims.JSON_KEY_AUD) && !this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD).isJsonArray()) {
                throw new IllegalArgumentException("setAudiences can't be used together with setAudience");
            } else if (!list.isEmpty()) {
                JsonArray jsonArray = new JsonArray();
                for (String next : list) {
                    if (JsonUtil.isValidString(next)) {
                        jsonArray.add(next);
                    } else {
                        throw new IllegalArgumentException("invalid string");
                    }
                }
                this.payload.add(AuthenticationTokenClaims.JSON_KEY_AUD, jsonArray);
                return this;
            } else {
                throw new IllegalArgumentException("audiences must not be empty");
            }
        }

        public Builder setExpiration(Instant instant) {
            setTimestampClaim(AuthenticationTokenClaims.JSON_KEY_EXP, instant);
            return this;
        }

        public Builder setIssuedAt(Instant instant) {
            setTimestampClaim(AuthenticationTokenClaims.JSON_KEY_IAT, instant);
            return this;
        }

        public Builder setIssuer(String str) {
            if (JsonUtil.isValidString(str)) {
                this.payload.add(AuthenticationTokenClaims.JSON_KEY_ISS, new JsonPrimitive(str));
                return this;
            }
            throw new IllegalArgumentException();
        }

        public Builder setJwtId(String str) {
            if (JsonUtil.isValidString(str)) {
                this.payload.add(AuthenticationTokenClaims.JSON_KEY_JIT, new JsonPrimitive(str));
                return this;
            }
            throw new IllegalArgumentException();
        }

        public Builder setNotBefore(Instant instant) {
            setTimestampClaim("nbf", instant);
            return this;
        }

        public Builder setSubject(String str) {
            if (JsonUtil.isValidString(str)) {
                this.payload.add(AuthenticationTokenClaims.JSON_KEY_SUB, new JsonPrimitive(str));
                return this;
            }
            throw new IllegalArgumentException();
        }

        public Builder setTypeHeader(String str) {
            this.typeHeader = Optional.of(str);
            return this;
        }

        public Builder withoutExpiration() {
            this.withoutExpiration = true;
            return this;
        }

        private Builder() {
            this.typeHeader = Optional.empty();
            this.withoutExpiration = false;
            this.payload = new JsonObject();
        }
    }

    public static RawJwt fromJsonPayload(Optional<String> optional, String str) throws JwtInvalidException {
        return new RawJwt(optional, str);
    }

    private Instant getInstant(String str) throws JwtInvalidException {
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp");
        } else {
            try {
                return Instant.ofEpochMilli((long) (this.payload.get(str).getAsJsonPrimitive().getAsDouble() * 1000.0d));
            } catch (NumberFormatException e11) {
                throw new JwtInvalidException("claim " + str + " is not a timestamp: " + e11);
            }
        }
    }

    private String getStringClaimInternal(String str) throws JwtInvalidException {
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isString()) {
            return this.payload.get(str).getAsString();
        } else {
            throw new JwtInvalidException("claim " + str + " is not a string");
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private void validateAudienceClaim() throws JwtInvalidException {
        if (this.payload.has(AuthenticationTokenClaims.JSON_KEY_AUD)) {
            if ((!this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD).isJsonPrimitive() || !this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD).getAsJsonPrimitive().isString()) && getAudiences().size() < 1) {
                throw new JwtInvalidException("invalid JWT payload: claim aud is present but empty.");
            }
        }
    }

    private void validateStringClaim(String str) throws JwtInvalidException {
        if (this.payload.has(str)) {
            if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isString()) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a string.");
            }
        }
    }

    private void validateTimestampClaim(String str) throws JwtInvalidException {
        if (this.payload.has(str)) {
            if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a number.");
            }
            double asDouble = this.payload.get(str).getAsJsonPrimitive().getAsDouble();
            if (asDouble > 2.53402300799E11d || asDouble < 0.0d) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " has an invalid timestamp");
            }
        }
    }

    public Set<String> customClaimNames() {
        HashSet hashSet = new HashSet();
        for (String next : this.payload.keySet()) {
            if (!JwtNames.isRegisteredName(next)) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public List<String> getAudiences() throws JwtInvalidException {
        if (hasAudiences()) {
            JsonElement jsonElement = this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD);
            if (jsonElement.isJsonPrimitive()) {
                if (jsonElement.getAsJsonPrimitive().isString()) {
                    return Collections.unmodifiableList(Arrays.asList(new String[]{jsonElement.getAsString()}));
                }
                throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", new Object[]{jsonElement}));
            } else if (jsonElement.isJsonArray()) {
                JsonArray asJsonArray = jsonElement.getAsJsonArray();
                ArrayList arrayList = new ArrayList(asJsonArray.size());
                for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
                    if (!asJsonArray.get(i11).isJsonPrimitive() || !asJsonArray.get(i11).getAsJsonPrimitive().isString()) {
                        throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", new Object[]{asJsonArray.get(i11)}));
                    }
                    arrayList.add(asJsonArray.get(i11).getAsString());
                }
                return Collections.unmodifiableList(arrayList);
            } else {
                throw new JwtInvalidException("claim aud is not a string or a JSON array");
            }
        } else {
            throw new JwtInvalidException("claim aud does not exist");
        }
    }

    public Boolean getBooleanClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isBoolean()) {
            return Boolean.valueOf(this.payload.get(str).getAsBoolean());
        } else {
            throw new JwtInvalidException("claim " + str + " is not a boolean");
        }
    }

    public Instant getExpiration() throws JwtInvalidException {
        return getInstant(AuthenticationTokenClaims.JSON_KEY_EXP);
    }

    public Instant getIssuedAt() throws JwtInvalidException {
        return getInstant(AuthenticationTokenClaims.JSON_KEY_IAT);
    }

    public String getIssuer() throws JwtInvalidException {
        return getStringClaimInternal(AuthenticationTokenClaims.JSON_KEY_ISS);
    }

    public String getJsonArrayClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (this.payload.get(str).isJsonArray()) {
            return this.payload.get(str).getAsJsonArray().toString();
        } else {
            throw new JwtInvalidException("claim " + str + " is not a JSON array");
        }
    }

    public String getJsonObjectClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (this.payload.get(str).isJsonObject()) {
            return this.payload.get(str).getAsJsonObject().toString();
        } else {
            throw new JwtInvalidException("claim " + str + " is not a JSON object");
        }
    }

    public String getJsonPayload() {
        return this.payload.toString();
    }

    public String getJwtId() throws JwtInvalidException {
        return getStringClaimInternal(AuthenticationTokenClaims.JSON_KEY_JIT);
    }

    public Instant getNotBefore() throws JwtInvalidException {
        return getInstant("nbf");
    }

    public Double getNumberClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            return Double.valueOf(this.payload.get(str).getAsDouble());
        } else {
            throw new JwtInvalidException("claim " + str + " is not a number");
        }
    }

    public String getStringClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        return getStringClaimInternal(str);
    }

    public String getSubject() throws JwtInvalidException {
        return getStringClaimInternal(AuthenticationTokenClaims.JSON_KEY_SUB);
    }

    public String getTypeHeader() throws JwtInvalidException {
        if (this.typeHeader.isPresent()) {
            return this.typeHeader.get();
        }
        throw new JwtInvalidException("type header is not set");
    }

    public boolean hasAudiences() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_AUD);
    }

    public boolean hasBooleanClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.has(str) || !this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isBoolean()) {
            return false;
        }
        return true;
    }

    public boolean hasExpiration() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_EXP);
    }

    public boolean hasIssuedAt() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_IAT);
    }

    public boolean hasIssuer() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_ISS);
    }

    public boolean hasJsonArrayClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.has(str) || !this.payload.get(str).isJsonArray()) {
            return false;
        }
        return true;
    }

    public boolean hasJsonObjectClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.has(str) || !this.payload.get(str).isJsonObject()) {
            return false;
        }
        return true;
    }

    public boolean hasJwtId() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_JIT);
    }

    public boolean hasNotBefore() {
        return this.payload.has("nbf");
    }

    public boolean hasNumberClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.has(str) || !this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            return false;
        }
        return true;
    }

    public boolean hasStringClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.has(str) || !this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isString()) {
            return false;
        }
        return true;
    }

    public boolean hasSubject() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_SUB);
    }

    public boolean hasTypeHeader() {
        return this.typeHeader.isPresent();
    }

    public boolean isNullClaim(String str) {
        JwtNames.validate(str);
        try {
            return JsonNull.INSTANCE.equals(this.payload.get(str));
        } catch (JsonParseException unused) {
            return false;
        }
    }

    public String toString() {
        JsonObject jsonObject = new JsonObject();
        if (this.typeHeader.isPresent()) {
            jsonObject.add(ClientData.KEY_TYPE, new JsonPrimitive(this.typeHeader.get()));
        }
        return jsonObject + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + this.payload;
    }

    private RawJwt(Builder builder) {
        if (!builder.payload.has(AuthenticationTokenClaims.JSON_KEY_EXP) && !builder.withoutExpiration) {
            throw new IllegalArgumentException("neither setExpiration() nor withoutExpiration() was called");
        } else if (!builder.payload.has(AuthenticationTokenClaims.JSON_KEY_EXP) || !builder.withoutExpiration) {
            this.typeHeader = builder.typeHeader;
            this.payload = builder.payload.deepCopy();
        } else {
            throw new IllegalArgumentException("setExpiration() and withoutExpiration() must not be called together");
        }
    }

    private RawJwt(Optional<String> optional, String str) throws JwtInvalidException {
        this.typeHeader = optional;
        this.payload = JsonUtil.parseJson(str);
        validateStringClaim(AuthenticationTokenClaims.JSON_KEY_ISS);
        validateStringClaim(AuthenticationTokenClaims.JSON_KEY_SUB);
        validateStringClaim(AuthenticationTokenClaims.JSON_KEY_JIT);
        validateTimestampClaim(AuthenticationTokenClaims.JSON_KEY_EXP);
        validateTimestampClaim("nbf");
        validateTimestampClaim(AuthenticationTokenClaims.JSON_KEY_IAT);
        validateAudienceClaim();
    }
}
