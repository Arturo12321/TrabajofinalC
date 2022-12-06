package com.registro.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;
@Entity
@Table(name="DESTINOS")
public class Destino {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@NotNull
		private String ciudad_dest;
		@NotNull
		private Double cost_dest;
		@NotNull
		private Integer nAero;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCiudad_dest() {
			return ciudad_dest;
		}
		public void setCiudad_dest(String ciudad_dest) {
			this.ciudad_dest = ciudad_dest;
		}
		public Double getCost_dest() {
			return cost_dest;
		}
		public void setCost_dest(Double cost_dest) {
			this.cost_dest = cost_dest;
		}
		public Integer getnAero() {
			return nAero;
		}
		public void setnAero(Integer nAero) {
			this.nAero = nAero;
		}
		@Override
		public String toString() {
			return "Destino [id=" + id + ", ciudad_dest=" + ciudad_dest + ", cost_dest=" + cost_dest + ", nAero="
					+ nAero + "]";
		}
		
		
}
