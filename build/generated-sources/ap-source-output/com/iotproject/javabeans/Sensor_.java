package com.iotproject.javabeans;

import com.iotproject.javabeans.Raspberry;
import com.iotproject.javabeans.SensorData;
import com.iotproject.javabeans.SensorType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T09:34:00")
@StaticMetamodel(Sensor.class)
public class Sensor_ { 

    public static volatile SingularAttribute<Sensor, Raspberry> raspberry;
    public static volatile SingularAttribute<Sensor, String> macAddress;
    public static volatile SingularAttribute<Sensor, SensorType> sensorType;
    public static volatile SingularAttribute<Sensor, String> name;
    public static volatile ListAttribute<Sensor, SensorData> sensorData;
    public static volatile SingularAttribute<Sensor, Integer> sensorId;

}