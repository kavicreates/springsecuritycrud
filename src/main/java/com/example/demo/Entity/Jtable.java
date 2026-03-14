package com.example.demo.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jtable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sname;
    private String location;

    public Jtable() {}

    public Jtable(Long id, String sname,String location) {
        this.id = id;
        this.sname = sname;
        this.location=location;
    }

    public Long getId() { return id; }
    public String getSname() { return sname; }
    public String getLocation(){ return location;}

    public void setId(Long id) { this.id = id; }
    public void setSname(String sname) { this.sname = sname; }
    public void setLocation(String location) { this.location = location; }

}
