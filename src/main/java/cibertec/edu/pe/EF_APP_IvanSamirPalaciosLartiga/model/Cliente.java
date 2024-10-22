package cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cliente")
public class Cliente {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Setter
    @Getter
    private String nombre;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String telefono;
    @Setter
    @Getter
    private String direccion;
    @Setter
    @Getter
    private int edad;
}
