package com.hrynczyszyn.Entity;

import com.hrynczyszyn.enumeration.SkiStatus;
import com.hrynczyszyn.enumeration.SkiStiffness;
import com.hrynczyszyn.enumeration.SkiType;

import javax.persistence.*;

@Entity
@Table(name = "ski")
public class Ski {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,
            name = "type")
    private SkiType type;

    @Column(nullable = false,
            length = 20,
            name = "brand")
    private String brand;

    @Column(nullable = false,
            name = "length")
    private int length;

    @Column(
            nullable = false,
            name = "turning_radius")
    private int turningRadius;

    @Column(nullable = false,
            name = "ski_stiffness")
    private SkiStiffness stiffness;

    @Column(nullable = false,
            name = "ski_status")
    private SkiStatus status;
}
