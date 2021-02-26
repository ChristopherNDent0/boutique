package boutique.jsf.mbean;

import boutique.hibernate.model.Personne;
import boutique.spring.service.PersonneService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class PersonneManager implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{personneService}")
    private PersonneService personneService;
    private Personne personne;
    private List<Personne> personneList;

    public Personne personne() {
        if (personne == null) {
            int idPersonne = 1; //todo: replace with proper check
            personne = personneService.personneInfo(idPersonne);
        }
        return personne;
    }

    public List<Personne> getPersonneList() {
        if (personneList == null) {
            personneList = personneService.personneInfoList();
        }
        return personneList;
    }

    public void setPersonneList(List<Personne> personneList) {
        this.personneList = personneList;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public void setPersonneService(PersonneService personneService) {
        this.personneService = personneService;
    }
}
