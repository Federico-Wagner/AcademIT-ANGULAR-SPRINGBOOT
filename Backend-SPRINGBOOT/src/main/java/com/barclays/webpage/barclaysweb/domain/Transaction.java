package com.barclays.webpage.barclaysweb.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "transactions")
public class Transaction implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "typeID")
    @JsonIgnoreProperties({"id"})
    private Transactions_type type;

    @ManyToOne
    @JoinColumn(name="userID_giver")
    @JsonIncludeProperties({"firstname","lastname"})
    @JsonIgnoreProperties({"transactions_sent", "transaction_received"})
    private User giver;

    @ManyToOne
    @JoinColumn(name="userID_receptor")
    @JsonIgnoreProperties({"transactions_sent", "transaction_received"})
    @JsonIncludeProperties({"firstname","lastname"})
    private User receptor;

    @Column(name = "amount", nullable = false)
    private float amount;

    @Column(name = "date", nullable = false)
    private String date;
}
