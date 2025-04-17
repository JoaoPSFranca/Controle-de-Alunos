package br.edu.ifsp.pep.bcc.api_controle_alunos.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private int idReport;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @NotNull
    private Student student;

    @ManyToOne
    @JoinColumn(name = "guardian_id", referencedColumnName = "guardian_id")
    private Guardian guardian;

    @Column(name = "report_date")
    @NotNull
    private Date dateReport;

    @Column(name = "report_time")
    @NotNull
    private Time timeReport;

    @Column(name = "report_reason")
    private String reasonReport;

    @Column(name = "report_doc")
    private String docReport;
}

//CREATE TABLE relatorio (
//        relatorio_id INT NOT NULL,
//        aluno_id INT NOT NULL,
//        relatorio_data DATE NOT NULL,
//        relatorio_horario TIME NOT NULL,
//        responsavel_id INT,
//        relatorio_motivo TEXT,
//        relatorio_documento TEXT,
//        PRIMARY KEY (relatorio_id),
//FOREIGN KEY (aluno_id) REFERENCES aluno (aluno_id),
//FOREIGN KEY (responsavel_id) REFERENCES responsavel (responsavel_id)
//        );
