package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado{

	private double salarioMensual;
	private double porcentajeAdicionalPorHoraExtra;
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		salarioMensual = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual"));
		porcentajeAdicionalPorHoraExtra  = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje Adicional por hora extra"));
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos = "Salario mensual: "+ salarioMensual + "\n";
		datos += "Porcentaje adicional por hora extra: "+ porcentajeAdicionalPorHoraExtra + "\n";
		
		System.out.println(datos);
	}
	
	public double getSalarioMensual() {
		return salarioMensual;
	}
	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}
	public double getPorcentajeAdicionalPorHoraExtra() {
		return porcentajeAdicionalPorHoraExtra;
	}
	public void setPorcentajeAdicionalPorHoraExtra(double porcentajeAdicionalPorHoraExtra) {
		this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
	}
	
}
