package com.smd.learning.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "jpa_box_turtle")
public class BoxTurtle implements Serializable {

    private static final long serialVersionUID = -32357572997874549L;

    @EmbeddedId
    private BoxTurtleId id;

    @Column(name = "name")
    private String name;

    public BoxTurtle() {
    }

    public BoxTurtle(BoxTurtleId id, String name) {
        this.id = id;
        this.name = name;
    }

    public BoxTurtleId getId() {
        return id;
    }

    public void setId(BoxTurtleId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BoxTurtle{" +
                "id=" + id.toString() +
                ", name='" + name + '\'' +
                '}';
    }
}
