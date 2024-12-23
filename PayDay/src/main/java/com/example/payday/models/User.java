package com.example.payday.models;

import com.example.payday.models.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private boolean active;

    @Column(name = "password", length = 1000)
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipient")
    private List<EmpTransaction> recTransactions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sender")
    private List<EmpTransaction> senTransactions = new ArrayList<>();

    private Double accountBalance;

    private LocalDateTime dateOfCreated;

    public User() {
    }


    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
        accountBalance = 0.0;
    }

    public boolean isAdmin() {
        return roles.contains(Role.ROLE_ADMIN);
    }

    public boolean isAccountant() {
        return roles.contains(Role.ROLE_ACCOUNTANT);
    }

    public boolean isEmployee() {
        return roles.contains(Role.ROLE_EMPLOYEE);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public boolean isActive() {
        return this.active;
    }

    public String getPassword() {
        return this.password;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public List<EmpTransaction> getRecTransactions() {
        return this.recTransactions;
    }

    public List<EmpTransaction> getSenTransactions() {
        return this.senTransactions;
    }

    public Double getAccountBalance() {
        return this.accountBalance;
    }

    public LocalDateTime getDateOfCreated() {
        return this.dateOfCreated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setRecTransactions(List<EmpTransaction> recTransactions) {
        this.recTransactions = recTransactions;
    }

    public void setSenTransactions(List<EmpTransaction> senTransactions) {
        this.senTransactions = senTransactions;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setDateOfCreated(LocalDateTime dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
            return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.isActive() != other.isActive()) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) return false;
        final Object this$recTransactions = this.getRecTransactions();
        final Object other$recTransactions = other.getRecTransactions();
        if (this$recTransactions == null ? other$recTransactions != null : !this$recTransactions.equals(other$recTransactions))
            return false;
        final Object this$senTransactions = this.getSenTransactions();
        final Object other$senTransactions = other.getSenTransactions();
        if (this$senTransactions == null ? other$senTransactions != null : !this$senTransactions.equals(other$senTransactions))
            return false;
        final Object this$accountBalance = this.getAccountBalance();
        final Object other$accountBalance = other.getAccountBalance();
        if (this$accountBalance == null ? other$accountBalance != null : !this$accountBalance.equals(other$accountBalance))
            return false;
        final Object this$dateOfCreated = this.getDateOfCreated();
        final Object other$dateOfCreated = other.getDateOfCreated();
        if (this$dateOfCreated == null ? other$dateOfCreated != null : !this$dateOfCreated.equals(other$dateOfCreated))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + (this.isActive() ? 79 : 97);
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        final Object $recTransactions = this.getRecTransactions();
        result = result * PRIME + ($recTransactions == null ? 43 : $recTransactions.hashCode());
        final Object $senTransactions = this.getSenTransactions();
        result = result * PRIME + ($senTransactions == null ? 43 : $senTransactions.hashCode());
        final Object $accountBalance = this.getAccountBalance();
        result = result * PRIME + ($accountBalance == null ? 43 : $accountBalance.hashCode());
        final Object $dateOfCreated = this.getDateOfCreated();
        result = result * PRIME + ($dateOfCreated == null ? 43 : $dateOfCreated.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", email=" + this.getEmail() + ", phoneNumber=" + this.getPhoneNumber() + ", name=" + this.getName() + ", active=" + this.isActive() + ", password=" + this.getPassword() + ", roles=" + this.getRoles() + ", recTransactions=" + this.getRecTransactions() + ", senTransactions=" + this.getSenTransactions() + ", accountBalance=" + this.getAccountBalance() + ", dateOfCreated=" + this.getDateOfCreated() + ")";
    }
}
