package com.jgg.sdp.domain.summary;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="SUM_ARBOL")
@NamedQueries({
     @NamedQuery(name="SUMArbol.find",
                 query="SELECT a FROM SUMArbol a " +
                       "         WHERE a.idCalling = ?1 " +
                       "         AND   a.idCalled  = ?2 " +
                       "         AND   a.nombre    = ?3")
    ,@NamedQuery(name="SUMArbol.listCalled",
                 query="SELECT a FROM SUMArbol a  WHERE a.idCalling = ?1 ")
}) 

public class SUMArbol implements Serializable {

   private static final long serialVersionUID = 3388498438837906852L;
   
   public static final String Llamados = "SELECT idCalled, SUM(sesiones), SUM(veces) " +
                                         "       FROM  SUM_ARBOL " +
                                         "       WHERE idCalling = ?1 " +
                                         "       GROUP BY idCalled";

   @Id
   @Column(name="idCalling")
   private Long idCalling;

   @Id
   @Column(name="idCalled")
   private Long idCalled;

   @Id
   @Column(name="nombre")
   private String nombre;

   @Column(name="sesiones")
   private Long sesiones;
   
   @Column(name="veces")
   private Long veces;

   @Column(name="totElapsed")
   private Long totElapsed;

   @Column(name="totCpu")
   private Long totCpu;
   
   @Column(name="totSuspend")
   private Long totSuspend;

   @Column(name="avgElapsed")
   private Long avgElapsed;

   @Column(name="avgCpu")
   private Long avgCpu;
   
   @Column(name="avgSuspend")
   private Long avgSuspend;
   
   @Column(name="tms")
   private Timestamp tms;

   public Long getIdCalling() {
       return idCalling;
   }
   
   public void setIdCalling(Long idCalling) {
       this.idCalling = idCalling;
   }
   
   public Long getIdCalled() {
       return idCalled;
   }
   
   public void setIdCalled(Long idCalled) {
       this.idCalled = idCalled;
   }

   public String getNombre() {
       return nombre;
   }
   
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   public Long getSesiones() {
       return sesiones;
   }
   
   public void setSesiones(Long sesiones) {
       this.sesiones = sesiones;
   }
   
   public Long getVeces() {
       return veces;
   }
   
   public void setVeces(Long veces) {
       this.veces = veces;
   }
   
   public Long getTotElapsed() {
       return totElapsed;
   }
   
   public void setTotElapsed(Long totElapsed) {
       this.totElapsed = totElapsed;
   }
   
   public Long getTotCpu() {
       return totCpu;
   }
   
   public void setTotCpu(Long totCpu) {
       this.totCpu = totCpu;
   }
   
   public Long getTotSuspend() {
       return totSuspend;
   }
   
   public void setTotSuspend(Long totSuspend) {
       this.totSuspend = totSuspend;
   }
   
   public Long getAvgElapsed() {
       return avgElapsed;
   }
   
   public void setAvgElapsed(Long avgElapsed) {
       this.avgElapsed = avgElapsed;
   }
   
   public Long getAvgCpu() {
       return avgCpu;
   }
   
   public void setAvgCpu(Long avgCpu) {
       this.avgCpu = avgCpu;
   }
   
   public Long getAvgSuspend() {
       return avgSuspend;
   }
   
   public void setAvgSuspend(Long avgSuspend) {
       this.avgSuspend = avgSuspend;
   }
   
   public Timestamp getTms() {
       return tms;
   }
   
   public void setTms(Timestamp tms) {
       this.tms = tms;
   }

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((avgCpu == null) ? 0 : avgCpu.hashCode());
    result = prime * result
            + ((avgElapsed == null) ? 0 : avgElapsed.hashCode());
    result = prime * result
            + ((avgSuspend == null) ? 0 : avgSuspend.hashCode());
    result = prime * result + ((idCalled == null) ? 0 : idCalled.hashCode());
    result = prime * result + ((idCalling == null) ? 0 : idCalling.hashCode());
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((tms == null) ? 0 : tms.hashCode());
    result = prime * result + ((totCpu == null) ? 0 : totCpu.hashCode());
    result = prime * result
            + ((totElapsed == null) ? 0 : totElapsed.hashCode());
    result = prime * result
            + ((totSuspend == null) ? 0 : totSuspend.hashCode());
    result = prime * result + ((veces == null) ? 0 : veces.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    SUMArbol other = (SUMArbol) obj;
    if (avgCpu == null) {
        if (other.avgCpu != null)
            return false;
    } else if (!avgCpu.equals(other.avgCpu))
        return false;
    if (avgElapsed == null) {
        if (other.avgElapsed != null)
            return false;
    } else if (!avgElapsed.equals(other.avgElapsed))
        return false;
    if (avgSuspend == null) {
        if (other.avgSuspend != null)
            return false;
    } else if (!avgSuspend.equals(other.avgSuspend))
        return false;
    if (idCalled == null) {
        if (other.idCalled != null)
            return false;
    } else if (!idCalled.equals(other.idCalled))
        return false;
    if (idCalling == null) {
        if (other.idCalling != null)
            return false;
    } else if (!idCalling.equals(other.idCalling))
        return false;
    if (nombre == null) {
        if (other.nombre != null)
            return false;
    } else if (!nombre.equals(other.nombre))
        return false;
    if (tms == null) {
        if (other.tms != null)
            return false;
    } else if (!tms.equals(other.tms))
        return false;
    if (totCpu == null) {
        if (other.totCpu != null)
            return false;
    } else if (!totCpu.equals(other.totCpu))
        return false;
    if (totElapsed == null) {
        if (other.totElapsed != null)
            return false;
    } else if (!totElapsed.equals(other.totElapsed))
        return false;
    if (totSuspend == null) {
        if (other.totSuspend != null)
            return false;
    } else if (!totSuspend.equals(other.totSuspend))
        return false;
    if (veces == null) {
        if (other.veces != null)
            return false;
    } else if (!veces.equals(other.veces))
        return false;
    return true;
}
      
}
