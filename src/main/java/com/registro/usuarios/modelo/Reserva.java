package com.registro.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="RESERVAS")
public class Reserva {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@NotNull
		private String fecha;
		@NotNull
		private int hora;
		@NotNull
		private String ides;
		@NotNull
		private String idpa;
		@NotNull
		private int idcom;
		private double cantidad;
		private double pago;
		
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

		public String getIdes() {
			return ides;
		}
		public void setIdes(String ides) {
			this.ides = ides;
		}

		public String getIdpa() {
			return idpa;
		}

		public void setIdpa(String idpa) {
			this.idpa = idpa;
		}

		public int getIdcom() {
			return idcom;
		}

		public void setIdcom(int idcom) {
			this.idcom = idcom;
		}

		public double getCantidad() {
			return cantidad;
		}

		public void setCantidad(double cantidad) {
			this.cantidad = cantidad;
		}


		public double getPago() {
			return pago;
		}

		public void setPago(double pago) {
			this.pago = pago;
		}

		@Override
		public String toString() {
			return "Reserva [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", ides=" + ides + ", idpa=" + idpa
					+ ", idcom=" + idcom + ", cantidad=" + cantidad + ", pago=" + pago + "]";
		}
		
		
		
		
		
		
		
}
