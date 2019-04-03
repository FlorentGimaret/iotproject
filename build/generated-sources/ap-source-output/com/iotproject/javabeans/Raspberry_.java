package com.iotproject.javabeans;

import com.iotproject.javabeans.Sensor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T09:34:00")
@StaticMetamodel(Raspberry.class)
public class Raspberry_ { 

    public static volatile SingularAttribute<Raspberry, Integer> raspberryId;
    public static volatile SingularAttribute<Raspberry, String> macAddress;
    public static volatile ListAttribute<Raspberry, Sensor> sensors;
    public static volatile SingularAttribute<Raspberry, String> name;

}