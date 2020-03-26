package apptrastero.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ubicacions")
public class Ubicacio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ubicacio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    @Override
    public String toString() {
        return "Ubicacio{" +
                "id=" + id +
                ", ubicacio='" + ubicacio + '\'' +
                '}';
    }
}
