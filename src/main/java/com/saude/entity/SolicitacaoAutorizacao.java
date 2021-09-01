package com.saude.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "solicitacao_autorizacao")
public class SolicitacaoAutorizacao {

    @Id
    @GeneratedValue
    @Column(name="id_solicitacao")
    private int idSolicitacao;

    @Column(name="id_procedimento")
    private int idProcedimento;

    @Column(name="idade")
    private int idade;

    @Column(name="sexo")
    private char sexo;
}
