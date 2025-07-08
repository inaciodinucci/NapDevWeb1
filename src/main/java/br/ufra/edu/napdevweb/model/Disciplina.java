package br.ufra.edu.napdevweb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String professor;
    private Double indice;
    @Column(unique = true)
    private Integer codigo;
} 