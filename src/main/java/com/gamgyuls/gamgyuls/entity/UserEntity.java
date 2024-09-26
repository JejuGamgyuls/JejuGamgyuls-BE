package com.gamgyuls.gamgyuls.entity;


import com.gamgyuls.gamgyuls.dto.SignUpDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="user")
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;
    @Column(name="user_id", nullable = false)
    private String userId;
    @Column(nullable = false)
    private String pwd;
    @Column(nullable = false)
    private String name;

    public UserEntity(SignUpDto dto) {
        this.email = dto.getEmail();
        this.userId = dto.getUserId();
        this.pwd = dto.getPwd();
        this.name = dto.getName();
    }
}