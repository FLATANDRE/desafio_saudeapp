package com.saude.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "regras_autorizacao")
public class RegraAutorizacao {

    @Id
    @GeneratedValue
    @Column(name="id_regra")
    private int idRegra;

    @Column(name="id_procedimento")
    private int idProcedimento;

    @Column(name="idade")
    private int idade;

    @Column(name="sexo")
    private char sexo;

    @Column(name="permitido")
    private boolean permitido;
}
