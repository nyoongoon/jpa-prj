package com.example.jpa_prj.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGrandChild is a Querydsl query type for GrandChild
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGrandChild extends EntityPathBase<GrandChild> {

    private static final long serialVersionUID = 1592354464L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGrandChild grandChild = new QGrandChild("grandChild");

    public final QChild child;

    public final StringPath grandChildId = createString("grandChildId");

    public QGrandChild(String variable) {
        this(GrandChild.class, forVariable(variable), INITS);
    }

    public QGrandChild(Path<? extends GrandChild> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGrandChild(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGrandChild(PathMetadata metadata, PathInits inits) {
        this(GrandChild.class, metadata, inits);
    }

    public QGrandChild(Class<? extends GrandChild> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.child = inits.isInitialized("child") ? new QChild(forProperty("child"), inits.get("child")) : null;
    }

}

