package springjpaexample.domain;


import javax.persistence.*;

@Entity
@NamedQuery(name = "Dumpling.findByTimeDevouredIn",
        query = "select d from Dumpling d where d.timeDevouredIn < ?1")
public class Dumpling {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private FillingType filling;

    private CookingTechnique cooked;

    @ManyToOne
    private Eater eater;

    private int timeDevouredIn;

    Dumpling() {

    }

    public Dumpling(FillingType filling, CookingTechnique cooked, Eater eater, int timeDevouredIn) {
        this.filling = filling;
        this.cooked = cooked;
        this.eater = eater;
        this.timeDevouredIn = timeDevouredIn;
    }


    public FillingType getFilling() {
        return filling;
    }

    public int getTimeDevouredIn() {
        return timeDevouredIn;
    }

    @Override
    public String toString() {
        return "Dumpling{" +
                "id=" + id +
                ", filling=" + filling +
                ", cooked=" + cooked +
                ", eater='" + eater + '\'' +
                ", timeDevouredIn=" + timeDevouredIn + " seconds " +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dumpling dumpling = (Dumpling) o;

        if (id != null ? !id.equals(dumpling.id) : dumpling.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Integer getId() {
        return id;
    }
}
