package com.av.avcorelibrary.Object;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by CodeSyaona on 7/11/16.
 */
public class EventListObject extends RealmObject {

    @SerializedName("event_id")
    private String eventId;
    @SerializedName("is_rave")
    private String isRave;
    @SerializedName("venue_id")
    private String venueId;
    @SerializedName("event_name")
    private String eventName;
    @SerializedName("attendees_count")
    private String attendeesCount;
    @SerializedName("tablecell_pic")
    private String bannerImage;
    @SerializedName("main_pic")
    private String mainImage;
    @SerializedName("cohorts")
    private String cohorts;
    @SerializedName("pos")
    private String pos;
    @SerializedName("time_stamp")
    private String timeStamp;
    @SerializedName("is_featured")
    private String isFeatured;
    @SerializedName("max_attendees")
    private String maxAttendees;
    @SerializedName("repeats")
    private String repeats;
    @SerializedName("event_date")
    private String eventDate;
    @SerializedName("event_type")
    private String eventType;
    @SerializedName("keywords")
    private String keywords;
    @SerializedName("is_hero")
    private String isHero;
    @SerializedName("is_globe")
    private String isGlobe;
    @SerializedName("is_hidden_text")
    private String isHidden;
    @SerializedName("venue_name")
    private String venueName;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lon")
    private String lon;
    @SerializedName("male_limit")
    private String maleLimit;
    @SerializedName("female_limit")
    private String femaleLimit;
    @SerializedName("is_exclusive")
    private String isExclusive;
    @SerializedName("starts_at")
    private String startsAt;
    @SerializedName("ends_at")
    private String endsAt;
    @SerializedName("event_cutoff")
    private String eventCutoff;
    @SerializedName("dp_val")
    private String dpVal;
    @SerializedName("address")
    private String address;
    @SerializedName("star")
    private String star;
    @SerializedName("action")
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStar() {

        return star;
    }

    public void setStar(String star) {

        this.star = star;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getDpVal() {

        return dpVal;
    }

    public void setDpVal(String dpVal) {

        this.dpVal = dpVal;
    }

    public String getEventCutoff() {

        return eventCutoff;
    }

    public void setEventCutoff(String eventCutoff) {

        this.eventCutoff = eventCutoff;
    }

    public String getEndsAt() {

        return endsAt;
    }

    public void setEndsAt(String endsAt) {

        this.endsAt = endsAt;
    }

    public String getStartsAt() {

        return startsAt;
    }

    public void setStartsAt(String startsAt) {

        this.startsAt = startsAt;
    }

    public String getIsExclusive() {

        return isExclusive;
    }

    public void setIsExclusive(String isExclusive) {

        this.isExclusive = isExclusive;
    }

    public String getFemaleLimit() {

        return femaleLimit;
    }

    public void setFemaleLimit(String femaleLimit) {

        this.femaleLimit = femaleLimit;
    }

    public String getMaleLimit() {

        return maleLimit;
    }

    public void setMaleLimit(String maleLimit) {

        this.maleLimit = maleLimit;
    }

    public String getLon() {

        return lon;
    }

    public void setLon(String lon) {

        this.lon = lon;
    }

    public String getLat() {

        return lat;
    }

    public void setLat(String lat) {

        this.lat = lat;
    }

    public String getVenueName() {

        return venueName;
    }

    public void setVenueName(String venueName) {

        this.venueName = venueName;
    }

    public String getIsHidden() {

        return isHidden;
    }

    public void setIsHidden(String isHidden) {

        this.isHidden = isHidden;
    }

    public String getIsGlobe() {

        return isGlobe;
    }

    public void setIsGlobe(String isGlobe) {

        this.isGlobe = isGlobe;
    }

    public String getIsHero() {

        return isHero;
    }

    public void setIsHero(String isHero) {

        this.isHero = isHero;
    }

    public String getKeywords() {

        return keywords;
    }

    public void setKeywords(String keywords) {

        this.keywords = keywords;
    }

    public String getEventType() {

        return eventType;
    }

    public void setEventType(String eventType) {

        this.eventType = eventType;
    }

    public String getEventDate() {

        return eventDate;
    }

    public void setEventDate(String eventDate) {

        this.eventDate = eventDate;
    }

    public String getRepeats() {

        return repeats;
    }

    public void setRepeats(String repeats) {

        this.repeats = repeats;
    }

    public String getMaxAttendees() {

        return maxAttendees;
    }

    public void setMaxAttendees(String maxAttendees) {

        this.maxAttendees = maxAttendees;
    }

    public String getIsFeatured() {

        return isFeatured;
    }

    public void setIsFeatured(String isFeatured) {

        this.isFeatured = isFeatured;
    }

    public String getTimeStamp() {

        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {

        this.timeStamp = timeStamp;
    }

    public String getPos() {

        return pos;
    }

    public void setPos(String pos) {

        this.pos = pos;
    }

    public String getCohorts() {

        return cohorts;
    }

    public void setCohorts(String cohorts) {

        this.cohorts = cohorts;
    }

    public String getMainImage() {

        return mainImage;
    }

    public void setMainImage(String mainImage) {

        this.mainImage = mainImage;
    }

    public String getBannerImage() {

        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {

        this.bannerImage = bannerImage;
    }

    public String getAttendeesCount() {

        return attendeesCount;
    }

    public void setAttendeesCount(String attendeesCount) {

        this.attendeesCount = attendeesCount;
    }

    public String getEventName() {

        return eventName;
    }

    public void setEventName(String eventName) {

        this.eventName = eventName;
    }

    public String getVenueId() {

        return venueId;
    }

    public void setVenueId(String venueId) {

        this.venueId = venueId;
    }

    public String getIsRave() {

        return isRave;
    }

    public void setIsRave(String isRave) {

        this.isRave = isRave;
    }

    public String getEventId() {

        return eventId;
    }

    public void setEventId(String eventId) {

        this.eventId = eventId;
    }

}
