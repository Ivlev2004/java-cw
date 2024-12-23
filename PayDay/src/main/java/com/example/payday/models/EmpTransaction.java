package com.example.payday.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_transactions")
public class EmpTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "summary")
    private Double summary;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User recipient;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User sender;

    private LocalDateTime dateOfTransaction;

    public EmpTransaction() {
    }

    @PrePersist
    private void init() {
        dateOfTransaction = LocalDateTime.now();
    }

    public Long getId() {
        return this.id;
    }

    public Double getSummary() {
        return this.summary;
    }

    public User getRecipient() {
        return this.recipient;
    }

    public User getSender() {
        return this.sender;
    }

    public LocalDateTime getDateOfTransaction() {
        return this.dateOfTransaction;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSummary(Double summary) {
        this.summary = summary;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EmpTransaction)) return false;
        final EmpTransaction other = (EmpTransaction) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$summary = this.getSummary();
        final Object other$summary = other.getSummary();
        if (this$summary == null ? other$summary != null : !this$summary.equals(other$summary)) return false;
        final Object this$recipient = this.getRecipient();
        final Object other$recipient = other.getRecipient();
        if (this$recipient == null ? other$recipient != null : !this$recipient.equals(other$recipient)) return false;
        final Object this$sender = this.getSender();
        final Object other$sender = other.getSender();
        if (this$sender == null ? other$sender != null : !this$sender.equals(other$sender)) return false;
        final Object this$dateOfTransaction = this.getDateOfTransaction();
        final Object other$dateOfTransaction = other.getDateOfTransaction();
        if (this$dateOfTransaction == null ? other$dateOfTransaction != null : !this$dateOfTransaction.equals(other$dateOfTransaction))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EmpTransaction;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $summary = this.getSummary();
        result = result * PRIME + ($summary == null ? 43 : $summary.hashCode());
        final Object $recipient = this.getRecipient();
        result = result * PRIME + ($recipient == null ? 43 : $recipient.hashCode());
        final Object $sender = this.getSender();
        result = result * PRIME + ($sender == null ? 43 : $sender.hashCode());
        final Object $dateOfTransaction = this.getDateOfTransaction();
        result = result * PRIME + ($dateOfTransaction == null ? 43 : $dateOfTransaction.hashCode());
        return result;
    }

    public String toString() {
        return "EmpTransaction(id=" + this.getId() + ", summary=" + this.getSummary() + ", recipient=" + this.getRecipient() + ", sender=" + this.getSender() + ", dateOfTransaction=" + this.getDateOfTransaction() + ")";
    }
}
