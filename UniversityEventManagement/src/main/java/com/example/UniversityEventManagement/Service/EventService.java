package com.example.UniversityEventManagement.Service;

import com.example.UniversityEventManagement.model.Event;
import com.example.UniversityEventManagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private static List<Student> Slist = new ArrayList<>();
    private static List<Event> Elist = new ArrayList<>();

    static{
        Slist.add(new Student(1,"Ameya","Shinde",22,"Computer"));
        Slist.add(new Student(2,"Aditya","Dahat",22,"Computer"));
        Elist.add(new Event(101,"Holi","University Hostel","09-03-2023","9 AM","7 PM"));
    }

    public void addStudent(Student student) {
        Slist.add(student);
    }

    public void addEvent(Event event) {
        Elist.add(event);
    }

    public Student findStudentById(int id) {
        Student s = null;
        for(Student student : Slist){
            if(student.getStudentId() == id){
                s = student;
                break;
            }
        }
        return s;
    }

    public Event findEventById(int id) {
        Event e = null;
        for(Event event : Elist){
            if(event.getEventId() == id){
                e = event;
                break;
            }
        }
        return e;
    }

    public List<Event> findEventByDate(String date) {
        List<Event> Elists = new ArrayList<>();
        for(Event event : Elist){
            if(event.getDate().equals(date)){
                Elists.add(event);
            }
        }
        return Elists;
    }

    public void updateDepartment(int id, String department){
        Student student = findStudentById(id);
        student.setDepartment(department);
    }

    public void deleteStudent(int id){
        Student student = findStudentById(id);
        Slist.remove(student);
    }

    public void deleteEvent(int id){
        Event event = findEventById(id);
        Elist.remove(event);
    }

    public List<Student> getAll(){
        return Slist;
    }

    public <newEvent> void updateEventInfo(int id, Event newEvent){
        Event event = findEventById(id);
        event.setEventId(newEvent.getEventId());
        event.setEventName(newEvent.getEventName());
        event.setEventLocation(newEvent.getEventLocation());
        event.setDate(newEvent.getDate());
        event.setStartTime(newEvent.getStartTime());
        event.setEndTime(newEvent.getEndTime());

    }

    public List<Event> getAllEvents() {
        return Elist;
    }
}
