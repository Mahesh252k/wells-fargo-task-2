package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    @OneToOne
    @JoinColumn(name ="clientId")
    private Client client;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    private Date creationDate;

    protected Portfolio(){

    }

    public Portfolio(Client client, List<Security> securities, Date creationDate) {
        this.client = client;
        this.securities = securities;
        this.creationDate = creationDate;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
