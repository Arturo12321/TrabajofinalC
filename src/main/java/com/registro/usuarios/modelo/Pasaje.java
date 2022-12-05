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
		private String Clase;
		@NotNull
		private int Asiento;
		@NotNull
		private int valor;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getClase() {
			return Clase;
		}
		public void setClase(String clase) {
			Clase = clase;
		}
		public int getAsiento() {
			return Asiento;
		}
		public void setAsiento(int asiento) {
			Asiento = asiento;
		}
		public int getValor() {
			return valor;
		}
		public void setValor(int valor) {
			this.valor = valor;
		}
		@Override
		public String toString() {
			return "Pasaje [id=" + id + ", Clase=" + Clase + ", Asiento=" + Asiento + ", valor=" + valor + "]";
		}
		
		
}
