package apptrastero.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "objectes")
public class Objecte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nom;
    private String color;
    private String talla;

    @ManyToOne
    @JoinColumn(name = "id_ubicacio")
    private Ubicacio ubicacio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Ubicacio getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(Ubicacio ubicacio) {
        this.ubicacio = ubicacio;
    }

    @Override
    public String toString() {
        return "Objecte{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", color='" + color + '\'' +
                ", talla='" + talla + '\'' +
                ", ubicacio=" + ubicacio +
                '}';
    }
}
