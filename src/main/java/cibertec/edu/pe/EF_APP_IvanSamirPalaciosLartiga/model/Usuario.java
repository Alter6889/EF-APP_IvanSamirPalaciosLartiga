package cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Setter
    @Getter
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Setter
    @Getter
    private String codigo;
    @Setter
    @Getter
    private String contraseña;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String rol;

}
