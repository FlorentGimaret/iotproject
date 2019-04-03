/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotproject.javabeans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class SensorData implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorDataId;
    private String data;
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="SENSORID", nullable=false)
    private Sensor sensor;
    
    public SensorData() {}

    public SensorData(int sensorDataId, String data, Date date) {
        this.sensorDataId = sensorDataId;
        this.data = data;
        this.date = date;
    }

    public int getSensorDataId() {
        return sensorDataId;
    }

    public void setSensorDataId(int sensorDataId) {
        this.sensorDataId = sensorDataId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /*public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }*/


    
}
