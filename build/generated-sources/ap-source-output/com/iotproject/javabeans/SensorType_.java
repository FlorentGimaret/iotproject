package com.iotproject.javabeans;

import com.iotproject.javabeans.Sensor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T12:22:11")
@StaticMetamodel(SensorType.class)
public class SensorType_ { 

    public static volatile ListAttribute<SensorType, Sensor> sensors;
    public static volatile SingularAttribute<SensorType, String> name;
    public static volatile SingularAttribute<SensorType, Integer> sensorTypeId;

}