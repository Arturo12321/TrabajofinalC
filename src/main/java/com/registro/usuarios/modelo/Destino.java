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
		private String ciudad;
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


		public String getCiudad() {
			return ciudad;
		}


		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
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
			return "Destino [id=" + id + ", ciudad=" + ciudad + ", cost_dest=" + cost_dest + ", nAero="
					+ nAero + "]";
		}
		
		
}
