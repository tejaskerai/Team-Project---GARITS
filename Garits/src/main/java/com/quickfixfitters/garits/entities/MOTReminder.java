package com.quickfixfitters.garits.entities;


import java.util.Date;
import java.util.List;
import javax.persistence.*;

//Dunno wtf this entity is
@Entity
@Table(name = "MOTReminder")
public class MOTReminder {

    @Id
    @Column(name = "MOTReminderID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int motReminderId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Vehicle motVehicle;

    public MOTReminder() {
    }

    public int getMotReminderId() {
        return motReminderId;
    }

    public void setMotReminderId(int motReminderId) {
        this.motReminderId = motReminderId;
    }

    public Vehicle getMotVehicle() {
        return motVehicle;
    }

    public void setMotVehicle(Vehicle motVehicle) {
        this.motVehicle = motVehicle;
    }
}
