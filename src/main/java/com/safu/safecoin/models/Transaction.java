package com.safu.safecoin.models;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hash;
    private String txReceiptStatus;
    private Timestamp timestamp;
    @ManyToOne
    @JoinColumn(name = "from")
    private Wallet from;
    @ManyToOne
    @JoinColumn(name = "to")
    private Wallet to;
    private float value;
    private String coinType;

    public Long getId() {
        return id;
    }

    public Transaction setId(Long id) {
        this.id = id;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public Transaction setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getTxReceiptStatus() {
        return txReceiptStatus;
    }

    public Transaction setTxReceiptStatus(String txReceiptStatus) {
        this.txReceiptStatus = txReceiptStatus;
        return this;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Transaction setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Wallet getFrom() {
        return from;
    }

    public Transaction setFrom(Wallet from) {
        this.from = from;
        return this;
    }

    public Wallet getTo() {
        return to;
    }

    public Transaction setTo(Wallet to) {
        this.to = to;
        return this;
    }

    public float getValue() {
        return value;
    }

    public Transaction setValue(float value) {
        this.value = value;
        return this;
    }

    public String getCoinType() {
        return coinType;
    }

    public Transaction setCoinType(String coinType) {
        this.coinType = coinType;
        return this;
    }
}
