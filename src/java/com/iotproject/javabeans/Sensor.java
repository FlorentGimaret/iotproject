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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sensor implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorId;
    private String name;
    private String macAddress;
    
    @ManyToOne
    @JoinColumn(name="RASPBERRYID", nullable=false)
    private Raspberry raspberry;
    
    @ManyToOne
    @JoinColumn(name="SENSORTYPEID", nullable=false)
    private SensorType sensorType;
    
    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<SensorData> sensorData = new ArrayList<>();
    
    public Sensor() {}

    public Sensor(int sensorId, String name, String macAddress, Raspberry raspberry, SensorType sensorType) {
        this.sensorId = sensorId;
        this.name = name;
        this.macAddress = macAddress;
        this.raspberry = raspberry;
        this.sensorType = sensorType;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Raspberry getRaspberry() {
        return raspberry;
    }

    public void setRaspberry(Raspberry raspberry) {
        this.raspberry = raspberry;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public List<SensorData> getSensorData() {
        return sensorData;
    }

    public void setSensorData(List<SensorData> sensorData) {
        this.sensorData = sensorData;
    }


    
}
