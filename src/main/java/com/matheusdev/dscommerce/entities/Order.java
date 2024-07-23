package com.matheusdev.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order") //Nomeia a tabela pedidos
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private OrderStatus status;

    @ManyToOne //Informa que será muitos para um, muitos pedidos para um cliente
    @JoinColumn(name = "client_id") //Nomear chave estrangeira da variável client da classe User
    private User client;
}
