/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotproject.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class SensorType implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorTypeId;
    private String name;
    
    @OneToMany(mappedBy = "sensorType", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Sensor> sensors = new ArrayList<>();
    
    public SensorType() {
    }

    public SensorType(int sensorTypeId, String name) {
        this.sensorTypeId = sensorTypeId;
        this.name = name;
    }

    public int getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(int sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

}
