package br.edu.ifsp.pep.bcc.api_controle_alunos.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "class_id")
    private int idClass;

    @Column(name = "class_acronym", length = 20)
    @NotNull
    private String abbreviationClass;

    @Column(name = "class_year")
    @NotNull
    private Year yearClass;

    @OneToMany(mappedBy = "idStudent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();
}
