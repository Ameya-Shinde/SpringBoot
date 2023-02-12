package com.example.UniversityEventManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private int eventId;
    private String eventName;
    private String eventLocation;
    private String date;
    private String startTime;
    private String endTime;

}
