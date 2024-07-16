package com.vodaintern.timestamp.Entry;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table
public class Entry {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long userId;
    private Date date;
    private LocalTime startime;
    private LocalTime endtime;


    public Entry() {
    }


// Constructors
    public Entry(Date date,
                 LocalTime startime,
                 LocalTime endtime,
                 Long userId) {
        this.date = date;
        this.startime = startime;
        this.endtime = endtime;
        this.userId = userId;
    }

    public Entry(Date date, LocalTime startime, LocalTime endtime) {
        this.date = date;
        this.startime = startime;
        this.endtime = endtime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getStartime() {
        return startime;
    }

    public void setStartime(LocalTime startime) {
        this.startime = startime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "date=" + date +
                ", startime=" + startime +
                ", endtime=" + endtime +
                ", userId=" + userId +
                '}';
    }
}
