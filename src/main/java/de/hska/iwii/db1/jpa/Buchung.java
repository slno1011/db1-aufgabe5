package de.hska.iwii.db1.jpa;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "buchung")
public class Buchung {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "flugID")
  private Flug flug;

  public Flug getFlug() {
    return flug;
  }

  public void setFlug(Flug flug) {
    this.flug = flug;
  }

  @ManyToOne
  @JoinColumn(name = "kundeID")
  private Kunde kunde;

  public Kunde getKunde() {
    return kunde;
  }

  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
  }

  @Column(name = "plaetze")
  private int plaetze;

  public int getPlaetze() {
    return plaetze;
  }

  public void setPlatze(int plaetze) {
    if (plaetze >= 1)
      this.plaetze = plaetze;
  }

  @Column(name = "datum")
  @Temporal(TemporalType.DATE)
  private Date datum;

  public Date getDatum() {
    return datum;
  }

  public void setDatum(Date datum) {
    this.datum = datum;
  }
}
