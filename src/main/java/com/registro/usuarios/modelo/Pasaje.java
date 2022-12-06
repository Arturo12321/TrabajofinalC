package com.registro.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;
@Entity
@Table(name="PASAJES")
public class Pasaje {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@NotNull
		private String clase;
		@NotNull
		private int asiento;
		@NotNull
		private int valor;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getClase() {
			return clase;
		}
		public void setClase(String clase) {
			this.clase = clase;
		}
		public int getAsiento() {
			return asiento;
		}
		public void setAsiento(int asiento) {
			this.asiento = asiento;
		}
		public int getValor() {
			return valor;
		}
		public void setValor(int valor) {
			this.valor = valor;
		}
		@Override
		public String toString() {
			return "Pasaje [id=" + id + ", Clase=" + clase + ", Asiento=" + asiento + ", valor=" + valor + "]";
		}
		
		
}
