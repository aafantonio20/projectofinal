package pe.edu.ulima.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.ulima.model.Personal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-02T10:20:34")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Float> montoPagar;
    public static volatile SingularAttribute<Venta, String> mesa;
    public static volatile SingularAttribute<Venta, Integer> pax;
    public static volatile SingularAttribute<Venta, Personal> id_personal;
    public static volatile SingularAttribute<Venta, Integer> id_venta;

}