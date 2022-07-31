package com.barclays.webpage.barclaysweb.domain;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="transactions_type")
public class Transactions_type {
    @Id
    @Column(name = "type_id", nullable = false)
    private Long id;

    @Column(name = "type_name", nullable = false)
    private String currency;
}
