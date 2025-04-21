package com.learn.hub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.hub.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private Role role = Role.STUDENT;
    @JsonIgnore
    private String password;

    @ManyToMany
    @JoinTable(
        name = "student_badge",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "badge_id")
    )
    @JsonIgnore
    private List<Badge> badges;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Inscriptions> inscriptions;

    @OneToMany(mappedBy = "prof")
    @JsonIgnore
    private List<Formation> formations;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        role.getPermissions().forEach(permissions ->
            authorities.add(new SimpleGrantedAuthority(permissions.name()))
        );
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        System.out.println("authorities"+authorities);
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
