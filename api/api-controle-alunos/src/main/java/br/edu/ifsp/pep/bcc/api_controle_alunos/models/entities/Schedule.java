package br.edu.ifsp.pep.bcc.api_controle_alunos.models.entities;

import br.edu.ifsp.pep.bcc.api_controle_alunos.models.entities.enuns.Periodo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "schedule_id")
    private int idSchedule;

    @Column(name = "schedule_start")
    @NotNull
    private Time startSchedule;

    @NotNull
    @Column(name = "schedule_end")
    private Time endSchedule;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "schedule_period")
    private Periodo periodSchedule;
}
