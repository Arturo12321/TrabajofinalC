package com.registro.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="RSERVAS")
public class Reserva {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@NotNull
		private String fecha;
		@NotNull
		private int hora;
		
		private double mon;
		private double nasi;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public int getHora() {
			return hora;
		}
		public void setHora(int hora) {
			this.hora = hora;
		}
		public double getMon() {
			return mon;
		}
		public void setMon(double mon) {
			this.mon = mon;
		}
		public double getNasi() {
			return nasi;
		}
		public void setNasi(double nasi) {
			this.nasi = nasi;
		}
		@Override
		public String toString() {
			return "Reserva [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", mon=" + mon + ", nasi=" + nasi
					+ "]";
		}
		
}
