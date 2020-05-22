package com.novellius.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Directores.class)
public abstract class Directores_ {

	public static volatile ListAttribute<Directores, Peliculas> peliculas;
	public static volatile SingularAttribute<Directores, String> NomDire;
	public static volatile SingularAttribute<Directores, String> ApeDire;
	public static volatile SingularAttribute<Directores, String> DescDire;
	public static volatile SingularAttribute<Directores, Integer> idDire;

}

