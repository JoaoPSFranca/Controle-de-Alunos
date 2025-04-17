package br.edu.ifsp.pep.bcc.api_controle_alunos.models.entities;

import br.edu.ifsp.pep.bcc.api_controle_alunos.models.entities.enuns.License;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "student_id")
    private int idStudent;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    @EqualsAndHashCode.Include
    @NotNull
    private Class idClass;

    @Column(name = "student_name", length = 100)
    @NotNull
    private String nameStudent;

    @Column(name = "student_birthdate")
    @NotNull
    private Date birthdateStudent;

    @Column(name = "student_adult")
    @NotNull
    private Boolean adultStudent;

    @Column(name = "student_license")
    @Enumerated(EnumType.STRING)
    @NotNull
    private License licenseStudent = License.NEGADA;


}