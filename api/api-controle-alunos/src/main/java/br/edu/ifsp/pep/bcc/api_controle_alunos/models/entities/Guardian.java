package br.edu.ifsp.pep.bcc.api_controle_alunos.models.entities;

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

@Table(name = "guardian")
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "guardian_id")
    private int idGuardian;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @EqualsAndHashCode.Include
    @NotNull
    private Student student;

    @NotNull
    @Column(name = "guardian_name", length = 100)
    private String nameGuardian;

    @NotNull
    @Column(name = "guardian_birthdate")
    private Date birthdateGuardian;
}
