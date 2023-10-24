package co.edu.escuelaing.cvds.lab8.model;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPRESA")
public class Empresa {
    @Id
    @Column(name = "nitId")
    private Long nitId;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "direction")
    private String direction;

    public Empresa() {
    }
    public Empresa(Long nitId, String name, String phone, String email, String direction) {
        this.nitId = nitId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.direction = direction;
    }

    public Long getNitId() {
        return nitId;
    }

    public void setNitId(Long nitId) {
        this.nitId = nitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

// Getters and setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(nitId, empresa.nitId) && Objects.equals(name, empresa.name) && Objects.equals(phone, empresa.phone) && Objects.equals(email, empresa.email) && Objects.equals(direction, empresa.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nitId, name, phone, email, direction);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nitId=" + nitId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}

