package com.novellius.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Peliculas.class)
public abstract class Peliculas_ {

	public static volatile SingularAttribute<Peliculas, Directores> director;
	public static volatile SingularAttribute<Peliculas, String> nombre;
	public static volatile SingularAttribute<Peliculas, Integer> id;

}

