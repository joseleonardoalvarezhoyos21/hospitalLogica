package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class ModeloDatos {

	HashMap<String, Paciente> pacientesMap;
	HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
	HashMap<String, EmpleadoEventual> empleadosEventualMap;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica> citasList;

	public ModeloDatos() {
		pacientesMap = new HashMap<String, Paciente>();
		empleadosPlanillaMap = new HashMap<String, EmpleadoPlanilla>();
		empleadosEventualMap = new HashMap<String, EmpleadoEventual>();
		medicosMap = new HashMap<String, Medico>();
		citasList = new ArrayList<CitaMedica>();
	}

	public void resgistrarPersona(Paciente miPaciente) {
		if (!pacientesMap.containsKey(miPaciente.getNumeroDeDNI())) {
			pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
			System.out.println(
					"Se ha registrado el empleado por planilla " + miPaciente.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El paciente: " + miPaciente.getNombre() + " ya existe");
		}

	}

	public void resgistrarPersona(EmpleadoPlanilla miEmpPlanilla) {

		if (!empleadosPlanillaMap.containsKey(miEmpPlanilla.getNumeroDeDNI())) {
			empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
			System.out.println(
					"Se ha registrado el empleado por planilla " + miEmpPlanilla.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El empleado de planilla: " + miEmpPlanilla.getNombre() + " ya existe");
		}

	}

	public void resgistrarPersona(EmpleadoEventual miEmpEventual) {

		if (!empleadosEventualMap.containsKey(miEmpEventual.getNumeroDeDNI())) {
			empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
			System.out.println(
					"Se ha registrado el empleado por planilla " + miEmpEventual.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El empleado eventual: " + miEmpEventual.getNombre() + " ya existe");
		}

	}

	public void resgistrarPersona(Medico miMedico) {
		if (!medicosMap.containsKey(miMedico.getNumeroDeDNI())) {
			medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
			System.out.println(
					"Se ha registrado el empleado por planilla " + miMedico.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El medico: " + miMedico.getNombre() + " ya existe");
		}

	}

	public void imprirPacientes() {

		if (!pacientesMap.isEmpty()) {
			String msj = "PACIENTES REGISTRADOS\n";
			Iterator<String> iterator = pacientesMap.keySet().iterator();

			while (iterator.hasNext()) {
				String clave = iterator.next();
				pacientesMap.get(clave).imprimirDatosPersona(msj);
			}
		} else {
			System.out.println("No hay apcientes registrados");
		}

	}

	public void imprirEmpleadosEventuales() {

		if (!empleadosEventualMap.isEmpty()) {
			String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";
			for (String clave : empleadosEventualMap.keySet()) {
				empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
			}
		} else {
			System.out.println("No hay empleados eventuales registrados");
		}
	}

	public void imprirEmpleadosPorPlanilla() {

		if (!empleadosPlanillaMap.isEmpty()) {
			String msj = "EMPLEADOS POR PLANILLA REGISTRADOS\n";
			for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
				empleadoPlanilla.imprimirDatosPersona(msj);

				System.out.println("Los siguientes medicos tambien estan registrados \n");
				imprimirMedicos();
			}
		} else {
			System.out.println("No hay empleados por planilla registrados");
		}

	}

	public void imprimirMedicos() {

		if (!medicosMap.isEmpty()) {
			String msj = "MEDICOS REGISTRADOS\n";
			for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
				elemento.getValue().imprimirDatosPersona(msj);
			}
		} else {
			System.out.println("No hay medicos registrados");
		}
	}

	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		Paciente miPaciente = null;

		if (pacientesMap.containsKey(documentoPaciente)) {
			miPaciente = pacientesMap.get(documentoPaciente);
		}
		return miPaciente;
	}

	public EmpleadoEventual consultarEmpleadoEventualPorDocumento(String documentoEmpleadoEventual) {
		if (empleadosEventualMap.containsKey(documentoEmpleadoEventual)) {
			return empleadosEventualMap.get(documentoEmpleadoEventual);
		} else {
			return null;
		}
	}

	public EmpleadoPlanilla consultarEmpleadoPorPlanillaPorDocumento(String documentoEmpleadoPlanilla) {
		if (empleadosPlanillaMap.containsKey(documentoEmpleadoPlanilla)) {
			return empleadosPlanillaMap.get(documentoEmpleadoPlanilla);
		} else {
			return null;
		}
	}

	public Medico consultarMedicoPorDocumento(String documentoMedico) {
		if (medicosMap.containsKey(documentoMedico)) {
			return medicosMap.get(documentoMedico);
		} else {
			return null;
		}
	}

	public Medico consultarMedicoPorNombre(String nombreMedico) {
		for (Medico medico : medicosMap.values()) {

			if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
				return medico;
			}
		}
		return null;
	}

	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("Se ha registrado la cita exitosamente \n");
		System.out.println(miCita.informacionCitaMedica());
	}

	public void imprimirCitasMedicasProgramadas() {

		if (!citasList.isEmpty()) {
			String msj = "CITAS MEDICAS PROGRAMADAS \n";
			CitaMedica miCita = null;

			System.out.println(msj + "\n");

			if (citasList.size() > 0) {
				for (int i = 0; i < citasList.size(); i++) {
					miCita = citasList.get(i);
					System.out.println(miCita.informacionCitaMedica());
				}
			} else {
				System.out.println("No existen citas programadas");
			}
		} else {
			System.out.println("No hay citas programadas");
		}
	}
}
