import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class Procesos {

	ModeloDatos miModeloDatos;
	
	public Procesos() {
		miModeloDatos = new ModeloDatos();
		presentarMenuOpciones();
	}

	private void presentarMenuOpciones() {
		
		String menu = "MENU HOSPITAL \n\n";
			menu+="1. Registrar paciente\n";
			menu+="2. Registrar empleado\n";
			menu+="3. Registrar cita medica\n";
			menu+="4. Imprimir información\n";
			menu+="5. Salir\n\n";
			menu+="Ingrese una opcion\n";
			
		int opcion = 0;
		
		do {
			
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcion) {
			case 1:
				registrarPaciente();
				break;
				
			case 2:
				registrarEmpleado();
				break;
				
			case 3:
				registrarCitaMedica();
				break;

			case 4:
				imprimirInformacion();
				break;
				
			case 5:
				System.out.println("El sistema ha terminado");
				break;

			default:System.out.println("No existe el código, verifique nuevamente");
				break;
			}
			
			
		} while (opcion!=5);
				
	}

	private void registrarPaciente() {
		Paciente miPaciente = new Paciente();
		miPaciente.registrarDatos();
		
		miModeloDatos.resgistrarPersona(miPaciente);
		
	}

	private void registrarEmpleado() {
		String menuTipoEmpleado = "Resgistro de empleado\n";
		menuTipoEmpleado+="1. Empleado Eventual\n";
		menuTipoEmpleado+="2. Empleado por planilla\n";
		menuTipoEmpleado+="Seleccione el tipo de empleado a regstrar\n";
		
		int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
		
		switch (tipoEmpleado) {
		case 1:
				EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
				miEmpleadoEventual.registrarDatos();
				miModeloDatos.resgistrarPersona(miEmpleadoEventual);
			break;
			
		case 2:
			String resp =  JOptionPane.showInputDialog("Ingrese si, si es un médico, de lo contrario es otro tipo de empleado");
			if (resp.equalsIgnoreCase("si")) {
				Medico miMedico = new Medico();
				miMedico.registrarDatos();
				miModeloDatos.resgistrarPersona(miMedico);
			}else {
				EmpleadoPlanilla miEmpleadoPlanilla = new EmpleadoPlanilla();
				miEmpleadoPlanilla.registrarDatos();
				miModeloDatos.resgistrarPersona(miEmpleadoPlanilla);
			}
			break;

		default:System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
			break;
		}
		
	}

	private void registrarCitaMedica() {
		String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");
		
		Paciente pacienteEncontrado = miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
		
		if (pacienteEncontrado!=null) {
			String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico");
			Medico medicoEncontrado = miModeloDatos.consultarMedicoPorNombre(nombreMedico);
			
			if (medicoEncontrado!=null) {
				String servicio = JOptionPane.showInputDialog("Ingrese servicio o motivo de consulta");
				String fechaConsulta = JOptionPane.showInputDialog("Ingrese fecha de la consulta");
				String horaConsulta = JOptionPane.showInputDialog("Ingrese horade la consulta");
				
				String lugar = "La cita sera en el consultorio: "+ medicoEncontrado.getNumeroDeConsultorio();
				CitaMedica miCita = new CitaMedica(pacienteEncontrado, medicoEncontrado, servicio, fechaConsulta, horaConsulta, lugar);
				miModeloDatos.registrarCitaMedica(miCita);
			}else {
				System.out.println("El medico no se encuentra registrado en el sistema");
			}
		}else {
			System.out.println("El paciente no se encuentra registrado en el sistema");
		}	
	}

	private void imprimirInformacion() {
		String menuImprimir="MENU IMPRESIONES\n";
		menuImprimir+="1. Listar pacientes\n";
		menuImprimir+="2. Listar empleados eventuales\n";
		menuImprimir+="3. Listar empleados por planilla\n";
		menuImprimir+="4. Listar medicos\n";
		menuImprimir+="5. Listar Citas Programadas\n";
		menuImprimir+="Ingrese una opcion\n";
		
		System.out.println("********************************************************");
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
		
		switch (opcion) {
		case 1:
			miModeloDatos.imprirPacientes();
			break;
			
		case 2:
			miModeloDatos.imprirEmpleadosEventuales();
			break;
			
		case 3:
			miModeloDatos.imprirEmpleadosPorPlanilla();
			break;
			
		case 4:
			miModeloDatos.imprimirMedicos();
			break;
			
		case 5:
			miModeloDatos.imprimirCitasMedicasProgramadas();
			break;	

		default: System.out.println("No existe esa opcion");
			break;
		}
		
	}

}
