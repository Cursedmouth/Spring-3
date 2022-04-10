package pl.edu.wszib.http2.service.model;

import pl.edu.wszib.http2.service.common.CrudResource;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Produkt implements CrudResource<Integer> {

  @Id
  @GeneratedValue
  private Integer id;
  @Size(min = 3, max = 50)
  @Pattern(regexp = "[a-zA-Z\\s]+")
  @Column(nullable = false)
  private String nazwa;
  @Column(nullable = false)
  private Integer ilosc;
  @Column(nullable = false)
  private Float cena;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  public String getNazwa() {
    return nazwa;
  }

  public void setNazwa(String nazwa) {
    this.nazwa = nazwa;
  }

  public Integer getIlosc() {
    return ilosc;
  }

  public void setIlosc(Integer ilosc) {
    this.ilosc = ilosc;
  }

  public Float getCena() {
    return cena;
  }

  public void setCena(Float cena) {
    this.cena = cena;
  }
}
