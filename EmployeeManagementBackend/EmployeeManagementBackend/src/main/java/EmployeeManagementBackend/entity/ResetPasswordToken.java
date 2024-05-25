package EmployeeManagementBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "reset_password_tokens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResetPasswordToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String token;
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
}
