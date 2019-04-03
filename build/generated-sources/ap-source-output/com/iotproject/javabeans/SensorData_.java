package com.iotproject.javabeans;

import com.iotproject.javabeans.Sensor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T09:34:00")
@StaticMetamodel(SensorData.class)
public class SensorData_ { 

    public static volatile SingularAttribute<SensorData, Date> date;
    public static volatile SingularAttribute<SensorData, String> data;
    public static volatile SingularAttribute<SensorData, Sensor> sensor;
    public static volatile SingularAttribute<SensorData, Integer> sensorDataId;

}