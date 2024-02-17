package ru.synergy.springJPA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "\"contactName\"", nullable = false)
    private String contactName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    public Contact(User user, String contactName, String phone, String email) {
        this.user = user;
        this.contactName = contactName;
        this.phone = phone;
        this.email = email;
    }

    public Contact(String contactName, String phone, String email) {
        this.contactName = contactName;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id= " + id +
                ", user_id=" + user.getId() +
                ", contactName='" + contactName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}