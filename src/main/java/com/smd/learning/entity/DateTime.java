package com.smd.learning.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "jpa_datetime")
public class DateTime implements Serializable {

    private static final long serialVersionUID = 8208150534551442294L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

//    @Basic
    @Column(name = "util_date")
    @Temporal(TemporalType.DATE)
    private Date utilDate;

//    @Basic
    @Column(name = "util_time")
    @Temporal(TemporalType.TIME)
    private Date utilTime;

//    @Basic
    @Column(name = "util_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date utilTimestamp;

//    @Basic
    @Column(name = "calendar_date")
    @Temporal(TemporalType.DATE)
    private Calendar calendarDate;

//    @Basic
    @Column(name = "calendar_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar calendarTimestamp;

    @Column(name = "value")
    private String value;

    public DateTime() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUtilDate() {
        return utilDate;
    }

    public void setUtilDate(Date utilDate) {
        this.utilDate = utilDate;
    }

    public Date getUtilTime() {
        return utilTime;
    }

    public void setUtilTime(Date utilTime) {
        this.utilTime = utilTime;
    }

    public Date getUtilTimestamp() {
        return utilTimestamp;
    }

    public void setUtilTimestamp(Date utilTimestamp) {
        this.utilTimestamp = utilTimestamp;
    }

    public Calendar getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(Calendar calendarDate) {
        this.calendarDate = calendarDate;
    }

    public Calendar getCalendarTimestamp() {
        return calendarTimestamp;
    }

    public void setCalendarTimestamp(Calendar calendarTimestamp) {
        this.calendarTimestamp = calendarTimestamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DateTime(Date utilDate, Date utilTime, Date utilTimestamp, Calendar calendarDate, Calendar calendarTimestamp, String value) {
        this.utilDate = utilDate;
        this.utilTime = utilTime;
        this.utilTimestamp = utilTimestamp;
        this.calendarDate = calendarDate;
        this.calendarTimestamp = calendarTimestamp;
        this.value = value;
    }

    @Override
    public String toString() {
        return "DateTime{" + "\n" +
                "id=" + id + "\n" +
                ", utilDate=" + utilDate + "\n" +
                ", utilTime=" + utilTime + "\n" +
                ", utilTimestamp=" + utilTimestamp + "\n" +
                ", calendarDate=" + calendarDate + "\n" +
                ", calendarTimestamp=" + calendarTimestamp + "\n" +
                ", value='" + value + '\'' + "\n" +
                '}';
    }
}
