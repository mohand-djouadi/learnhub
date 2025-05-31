package com.learn.hub.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Formation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean premium;
    private String code;

    @OneToMany(mappedBy = "formation")
    public List<Cour> cours;

    @OneToOne(mappedBy = "formation")
    private Badge badge;

    @OneToMany(mappedBy = "formation")
    private List<Inscriptions> inscriptions;

    @OneToOne(mappedBy = "formation")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "prof_id")
    private User prof;

}
