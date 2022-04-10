package pl.edu.wszib.http2.service.model;

import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.wszib.http2.service.common.CrudResource;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.ParseException;


@Entity
@Table
public class Profile implements CrudResource<Integer> {


  @Id
  @GeneratedValue
  private Integer id;
  @Size(min = 3, max = 50)
  @Pattern(regexp = "[a-zA-Z]+")
  @Column(nullable = false)
  private String imie;
  @Size(min = 3, max = 50)
  @Pattern(regexp = "[a-zA-Z]+")
  @Column(nullable = false)
  private String nazwisko;
  @DateTimeFormat(pattern = "yyyy-MD-dd")
  @NotBlank
  @Column(nullable = false)
  private String dataUrodzenia;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Plec plec;
  @Lob

  private byte[] zdjecie;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer integer) {
    this.id = integer;
  }

  public String getImie() {
    return imie;
  }

  public void setImie(String imie) {
    this.imie = imie;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public void setNazwisko(String nazwisko) {
    this.nazwisko = nazwisko;
  }

  public String getDataUrodzenia() {
    return dataUrodzenia;
  }

  public void setDataUrodzenia(String dataUrodzenia) throws ParseException {
    this.dataUrodzenia = dataUrodzenia;
  }

  public byte[] getZdjecie() {
    return zdjecie;
  }

  public void setZdjecie(byte[] zdjecie) {
    this.zdjecie = zdjecie;
  }

  public Plec getPlec() {
    return plec;
  }

  public void setPlec(Plec plec) {
    this.plec = plec;
  }
}
